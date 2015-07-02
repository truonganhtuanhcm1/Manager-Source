package erp.module.user.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import erp.core.Utils;
import erp.core.ValidationCore;
import erp.core.log.ILog;
import erp.core.sender.EmailSender;
import erp.core.site.BaseController;
import erp.core.site.MessageCore;
import erp.core.site.MessageDict;
import erp.module.user.model.User;
import erp.module.user.service.UserService;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login(Map<String, Object> map) {

		if (this.isLogined()) {

			return View("redirect:/user/user/profile", map);
		}

		return ViewLogin("/account/login", map);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam(value = "remember", required = false) boolean isRemember,
			Map<String, Object> map) {

		ILog.Info(username + " login", this);

		MessageCore mess = new MessageCore(map);

		boolean isValid = true;

		if (!ValidationCore.validUsername(username)) {

			mess.lstMessage.add(MessageDict.ACC_USERNAME_INVALID);
			mess.showError();
			isValid &= false;

		}

		if (isValid && !ValidationCore.validPassword(password)) {

			mess.lstMessage.add(MessageDict.ACC_PASSWORD_INVALID);
			mess.showError();
			isValid &= false;
		}

		User userLogin = new UserService().Login(username, password);

		if (userLogin == null) {

			// login failed
			isValid &= false;

		} else {

			// login success full
			getSession().setAttribute("user", userLogin);

		}

		if (isValid) {

			mess.lstMessage.add(MessageDict.ACC_SUCCESS);
			mess.showMessage();
			return View("redirect:/user/user/profile", map);

		} else {

			mess.lstMessage.add(MessageDict.ACC_FAILED);
			mess.showError();

		}

		return ViewLogin("/account/login", map);
	}

	@RequestMapping(value = { "/", "/logout" }, method = RequestMethod.GET)
	public String logout(Map<String, Object> map) {

		getSession().setAttribute("user", null);

		MessageCore mess = new MessageCore(map);

		mess.lstMessage.add(MessageDict.ACC_LOUT);

		mess.showMessage();

		return ViewLogin("redirect:/account/login", map);
	}

	@RequestMapping(value = { "/", "/forgot" }, method = RequestMethod.GET)
	public String forgot(Map<String, Object> map) {

		return ViewLogin("/account/forgot-password", map);

	}

	@RequestMapping(value = { "/", "/forgot" }, method = RequestMethod.POST)
	public String forgot(@RequestParam("email") String email,
			Map<String, Object> map) {

		MessageCore mess = new MessageCore(map);

		// Get user by email
		UserService userService = new UserService();

		User userForgot = userService.getByEmail(email);

		if (userForgot == null) {
			mess.lstMessage.add(MessageDict.EMAIL_NOT_EXISTS + ": " + email);
			mess.showError();
			return ViewLogin("/account/forgot-password", map);
		}

		String key = Utils.GenKey();
		userForgot.setForgot_key(key);
		userForgot.setUpdate_user(userForgot.getUser_name());

		if (userService.Update(userForgot)) {

			String url = this.getURLWithContextPath(getRequest());
			
			ILog.Debug("url: "+url, this);

			String link = String.format("%s/account/reset/%s/%s",
					url, email, key);

			String html = "We received a request to reset the password associated with this e-mail address. If you made this request, please follow the instructions below.";

			html += "<br><br>Click the link below to reset your password using our secure server:";

			html += String
					.format("<br><br>Click here to reset password: <a href='%s'>%s</a>",
							link, link);

			html += "<br><br>If you did not request to have your password reset you can safely ignore this email. Rest assured your customer account is safe.";

			html += "<br><br>If clicking the link doesn't seem to work, you can copy and paste the link into your browser's address window, or retype it there. Once you have returned to Directviz.com, we will give instructions for resetting your password.";

			html += "<br><br>Directviz.com will never e-mail you and ask you to disclose or verify your Directviz.com password, credit card, or banking account number. If you receive a suspicious e-mail with a link to update your account information, do not click on the link--instead, report the e-mail to Directviz.com for investigation. Thanks for visiting Directviz.com!";

			EmailSender.Send(email, "ERP Forgot Password", html);
			mess.lstMessage.add(MessageDict.EMAIL_SENT + " to: " + email);
			mess.lstMessage.add(MessageDict.EMAIL_CHECK + ": " + email);
			mess.showMessage();
		} else {

			mess.lstMessage.add(MessageDict.ACC_UPDATE_ERROR);
			mess.showError();
		}

		return ViewLogin("/account/forgot-password", map);
	}

	@RequestMapping(value = "/reset/{email}/{key}", method = RequestMethod.GET)
	public String reset(@PathVariable String email, @PathVariable String key,
			Map<String, Object> map) {

		map.put("email", email);
		map.put("key", key);

		MessageCore mess = new MessageCore(map);

		// Get user by email
		UserService userService = new UserService();

		User userForgot = userService.getByEmail(email);
		// Check email & key
		if (userForgot == null) {

			mess.lstMessage.add(MessageDict.EMAIL_NOT_EXISTS + ": " + email);
			mess.showError();
			return ViewLogin("redirect:/account/forgot", map);

		}

		if (!userForgot.getForgot_key().equals(key)) {

			mess.lstMessage.add(MessageDict.ACC_FORGOT_KEY_INVALID);
			mess.showError();
			return ViewLogin("redirect:/account/forgot", map);

		}

		// Update forgot key

		return ViewLogin("/account/reset-password", map);

	}

	@RequestMapping(value = "/reset/{email}/{key}", method = RequestMethod.POST)
	public String reset(@PathVariable String email, @PathVariable String key,
			@RequestParam("password") String password,
			@RequestParam("re-password") String repassword,
			Map<String, Object> map) {

		map.put("email", email);
		map.put("key", key);

		MessageCore mess = new MessageCore(map);

		// Check password
		if (!ValidationCore.validPassword(password)) {

			mess.lstMessage.add(MessageDict.ACC_PASSWORD_INVALID);
			mess.showError();
			return ViewLogin("/account/reset-password", map);
		}

		// Check password match
		if (password.equals(repassword) == false) {
			mess.lstMessage.add(MessageDict.ACC_PASSWORD_NOT_MATCH);
			mess.showError();
			return ViewLogin("/account/reset-password", map);
		} else {

			// Get user by email
			UserService userService = new UserService();

			User userForgot = userService.getByEmail(email);
			// Check email & key
			if (userForgot == null) {

				mess.lstMessage
						.add(MessageDict.EMAIL_NOT_EXISTS + ": " + email);
				mess.showError();
				return ViewLogin("redirect:/account/forgot-password", map);

			}

			if (!userForgot.getForgot_key().equals(key)) {

				mess.lstMessage.add(MessageDict.ACC_FORGOT_KEY_INVALID);
				mess.showError();
				return ViewLogin("redirect:/account/forgot-password", map);

			}

			// Update new password
			userForgot.setPassword(password);

			if (userService.Update(userForgot)) {
				mess.lstMessage.add(MessageDict.ACC_FOTGOT_SUCCESS);
				mess.showMessage();
				return ViewLogin("/account/login", map);
			} else {
				mess.lstMessage.add(MessageDict.ACC_FOTGOT_FAILED);
				mess.showError();
				return ViewLogin("/account/reset-password", map);
			}

		}

		// return ViewLogin("/account/reset-password", map);

	}

}
