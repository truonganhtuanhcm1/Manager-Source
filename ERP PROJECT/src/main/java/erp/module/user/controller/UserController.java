package erp.module.user.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import erp.core.ConvertCore;
import erp.core.ValidationCore;
import erp.core.site.BaseController;
import erp.core.site.MessageCore;
import erp.core.site.MessageDict;
import erp.module.user.model.Hrm_Client_Type;
import erp.module.user.model.Status;
import erp.module.user.model.User;
import erp.module.user.service.GroupService;
import erp.module.user.service.Hrm_Client_TypeService;
import erp.module.user.service.StatusService;
import erp.module.user.service.UserService;

@Controller
@RequestMapping("/user/user")
public class UserController extends BaseController {

	@RequestMapping(value = { "/", "/profile" }, method = RequestMethod.GET)
	public String profile(Map<String, Object> map) {

		if(getCurrentUser()==null){
			return View("", map);
		}
		
		map.put("user", this.getCurrentUser());

		return View("/user/user/profile", map);
	}

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String list(Map<String, Object> map) {

		if(getCurrentUser()==null){
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("user_list")) {
			return View("redirect:/alert/access-denied", null);
		}

		// Load all user
		UserService usrService = new UserService();
		List<User> lstUser = usrService.Search("", 0, "", "");
		map.put("listuser", lstUser);

		// Load all group
		GroupService gService = new GroupService();
		map.put("listGroup", gService.Search(""));

		// Load all client type
		Hrm_Client_TypeService clTypeService = new Hrm_Client_TypeService();

		List<Hrm_Client_Type> lstClientType = clTypeService.getAll();

		map.put("lstClientType", lstClientType);

		// Load all status

		StatusService stService = new StatusService();
		List<Status> lstStatus = stService.getAll();

		map.put("lstStatus", lstStatus);

		return View("/user/user/list-user", map);
	}

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.POST)
	public String list(@RequestParam("keyword") String keyword,
			@RequestParam("group_id") String Group_id,
			@RequestParam("client_type_id") String client_type_id,
			@RequestParam("status_id") String status_id, Map<String, Object> map) {

		if(getCurrentUser()==null){
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("user_list")) {
			return View("redirect:/alert/access-denied", null);
		}

		// Get list users
		UserService usrService = new UserService();

		int iGroupID = 0;
		if (!Group_id.equals(""))
			iGroupID = Integer.parseInt(Group_id);

		List<User> lstUser = usrService.Search(keyword, iGroupID,
				client_type_id, status_id);

		map.put("listuser", lstUser);
		// .Get list users

		// Get list groups
		GroupService gService = new GroupService();
		map.put("listGroup", gService.Search(""));
		// .Get list groups

		Hrm_Client_TypeService clTypeService = new Hrm_Client_TypeService();

		// Load list type client
		List<Hrm_Client_Type> lstClientType = clTypeService.getAll();
		map.put("lstClientType", lstClientType);
		// .Load list type client

		// Load all status

		StatusService stService = new StatusService();
		List<Status> lstStatus = stService.getAll();

		map.put("lstStatus", lstStatus);

		map.put("keyword", keyword);
		map.put("group_id", Group_id);
		map.put("client_type_id", client_type_id);
		map.put("status_id", status_id);

		return View("/user/user/list-user", map);
	}

	@RequestMapping(value = { "/", "/edit/{username}" }, method = RequestMethod.GET)
	public String edit(@PathVariable String username, Map<String, Object> map) {

		if(getCurrentUser()==null){
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("user_edit")) {
			return View("redirect:/alert/access-denied", null);
		}

		// Load user need edit
		UserService usrService = new UserService();
		User editUser = usrService.GetByUsername(username);

		map.put("editUser", editUser);
		// .Load user need edit

		// Get list groups
		GroupService gService = new GroupService();
		map.put("listGroup", gService.Search(""));
		// .Get list groups

		Hrm_Client_TypeService clTypeService = new Hrm_Client_TypeService();

		// Load list type client
		List<Hrm_Client_Type> lstClientType = clTypeService.getAll();
		map.put("lstClientType", lstClientType);
		// .Load list type client

		// Load all status

		StatusService stService = new StatusService();
		List<Status> lstStatus = stService.getAll();

		map.put("lstStatus", lstStatus);

		return View("/user/user/edit-user", map);
	}

	@RequestMapping(value = { "/", "/edit" }, method = RequestMethod.POST)
	public String edit(@RequestParam("user_name") String user_name,
			@RequestParam("email") String email,
			@RequestParam("group_id") String group_id,
			@RequestParam("client_type_id") String client_type_id,
			@RequestParam("status_id") String status_id,
			@RequestParam("first_name") String first_name,
			@RequestParam("last_name") String last_name,
			@RequestParam("birth_date") String birth_date,
			@RequestParam("phone") String phone,
			@RequestParam("address") String address, Map<String, Object> map) {

		if(getCurrentUser()==null){
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("user_edit")) {
			return View("redirect:/alert/access-denied", null);
		}

		UserService usrService = new UserService();

		Date dBirthDate = ConvertCore.StringToDate(birth_date, "dd/MM/yyyy");

		MessageCore mess = new MessageCore(map);

		// Load user need edit
		User editUser = usrService.GetByUsername(user_name);

		if (!email.equals(editUser.getEmail())) {

			User editUserOld = usrService.getByEmail(email);
			if (editUserOld != null) {
				mess.lstMessage.add(MessageDict.EXIST_EMAIL);
				mess.showError();
				return View("redirect:/user/user/edit/" + user_name, map);
			}
		}

		try {
			if (usrService.UpdateFull(user_name, editUser.getClient_id(),
					editUser.getContact_id(), email, group_id, client_type_id,
					status_id, first_name, last_name, dBirthDate, phone,
					address, getCurrentUser().getUser_name())) {

				mess.lstMessage.add(MessageDict.SUCCESS);
				mess.showMessage();
				return View("redirect:/user/user/list", map);
			} else {
				mess.lstMessage.add(MessageDict.FAILED);
				mess.showError();
				return View("redirect:/user/user/edit/" + user_name, map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return View("redirect:/user/user/edit/" + user_name, map);

	}

	@RequestMapping(value = { "/", "/delete/{user_name}" }, method = RequestMethod.GET)
	public String delete(@PathVariable String user_name, Map<String, Object> map) {

		if(getCurrentUser()==null){
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("user_delete")) {
			return View("redirect:/alert/access-denied", null);
		}

		MessageCore mess = new MessageCore(map);

		UserService uService = new UserService();
		if (uService.Delete(user_name, getCurrentUser().getUser_name())) {

			mess.lstMessage.add(MessageDict.SUCCESS);
			mess.showMessage();
		} else {

			mess.lstMessage.add(MessageDict.FAILED);
			mess.showError();
		}

		return View("redirect:/user/user/list", map);
	}

	@RequestMapping(value = { "/", "/add" }, method = RequestMethod.GET)
	public String add(Map<String, Object> map) {

		if(getCurrentUser()==null){
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("user_add")) {
			return View("redirect:/alert/access-denied", null);
		}

		// Get list groups
		GroupService gService = new GroupService();
		map.put("listGroup", gService.Search(""));
		// .Get list groups

		Hrm_Client_TypeService clTypeService = new Hrm_Client_TypeService();

		// Load list type client
		List<Hrm_Client_Type> lstClientType = clTypeService.getAll();
		map.put("lstClientType", lstClientType);
		// .Load list type client

		// Load all status

		StatusService stService = new StatusService();
		List<Status> lstStatus = stService.getAll();

		map.put("lstStatus", lstStatus);

		return View("/user/user/add-user", map);
	}

	@RequestMapping(value = { "/", "/add" }, method = RequestMethod.POST)
	public String add(@RequestParam("user_name") String user_name,
			@RequestParam("password") String password,
			@RequestParam("repassword") String repassword,
			@RequestParam("email") String email,
			@RequestParam("group_id") String group_id,
			@RequestParam("client_type_id") String client_type_id,
			@RequestParam("status_id") String status_id,
			@RequestParam("first_name") String first_name,
			@RequestParam("last_name") String last_name,
			@RequestParam("birth_date") String birth_date,
			@RequestParam("phone") String phone,
			@RequestParam("address") String address, Map<String, Object> map) {

		if(getCurrentUser()==null){
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("user_add")) {
			return View("redirect:/alert/access-denied", null);
		}

		map.put("user_name", user_name);
		map.put("email", email);
		map.put("group_id", group_id);
		map.put("client_type_id", client_type_id);
		map.put("status_id", status_id);
		map.put("first_name", first_name);
		map.put("last_name", last_name);
		map.put("birth_date", birth_date);
		map.put("phone", phone);
		map.put("address", address);

		// Get list groups
		GroupService gService = new GroupService();
		map.put("listGroup", gService.Search(""));
		// .Get list groups

		Hrm_Client_TypeService clTypeService = new Hrm_Client_TypeService();

		// Load list type client
		List<Hrm_Client_Type> lstClientType = clTypeService.getAll();
		map.put("lstClientType", lstClientType);
		// .Load list type client

		// Load all status

		StatusService stService = new StatusService();
		List<Status> lstStatus = stService.getAll();

		map.put("lstStatus", lstStatus);

		UserService usrService = new UserService();

		Date dBirthDate = ConvertCore.StringToDate(birth_date, "dd/MM/yyyy");

		MessageCore mess = new MessageCore(map);

		// Load user need edit
		User editUser = usrService.GetByUsername(user_name);
		if (editUser != null) {
			mess.lstMessage.add(MessageDict.EXIST_USERNAME);
			mess.showError();
			return View("/user/user/add-user", map);
		}
		editUser = usrService.getByEmail(email);
		if (editUser != null) {
			mess.lstMessage.add(MessageDict.EXIST_EMAIL);
			mess.showError();
			return View("/user/user/add-user", map);
		}

		boolean isValid = true;

		if (!ValidationCore.validUsername(user_name)) {

			mess.lstMessage.add(MessageDict.ACC_USERNAME_INVALID);
			mess.showError();
			isValid &= false;
			return View("/user/user/add-user", map);
		}

		if (isValid && !ValidationCore.validPassword(password)) {

			mess.lstMessage.add(MessageDict.ACC_PASSWORD_INVALID);
			mess.showError();
			isValid &= false;
			return View("/user/user/add-user", map);
		}

		try {
			if (usrService
					.InsertFull(user_name, password, email, group_id,
							client_type_id, status_id, first_name, last_name,
							dBirthDate, phone, address, getCurrentUser()
									.getUser_name())) {

				mess.lstMessage.add(MessageDict.SUCCESS);
				mess.showMessage();
				return View("redirect:/user/user/list", map);
			} else {
				mess.lstMessage.add(MessageDict.FAILED);
				mess.showError();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return View("/user/user/add-user", map);

	}

	@RequestMapping(value = { "/", "/changepassword" }, method = RequestMethod.POST)
	public String add(@RequestParam("user_name") String user_name,
			@RequestParam("password") String password,
			@RequestParam("repassword") String repassword,
			Map<String, Object> map) {

		if(getCurrentUser()==null){
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("user_changepassword")) {
			return View("redirect:/alert/access-denied", null);
		}

		MessageCore mess = new MessageCore(map);

		// Check password
		if (!ValidationCore.validPassword(password)) {

			mess.lstMessage.add(MessageDict.ACC_PASSWORD_INVALID);
			mess.showError();
			return View("redirect:/user/user/edit/" + user_name, map);
		}

		// Check password match
		if (password.equals(repassword) == false) {
			mess.lstMessage.add(MessageDict.ACC_PASSWORD_NOT_MATCH);
			mess.showError();
			return View("redirect:/user/user/edit/" + user_name, map);
		} else {

			// Get user by email
			UserService userService = new UserService();

			User userForgot = userService.GetByUsername(user_name);
			// Check email & key
			if (userForgot == null) {

				mess.lstMessage.add(MessageDict.ACC_USERNAME_INVALID + ": "
						+ user_name);
				mess.showError();
				return View("redirect:/user/user/edit/" + user_name, map);

			}

			// Update new password
			userForgot.setPassword(password);

			if (userService.Update(userForgot)) {
				mess.lstMessage.add(MessageDict.SUCCESS);
				mess.showMessage();
				return View("redirect:/user/user/list", map);
			} else {
				mess.lstMessage.add(MessageDict.FAILED);
				mess.showError();
				return View("redirect:/user/user/edit/" + user_name, map);
			}
		}
	}

}
