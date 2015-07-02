package erp.core.site;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;

import erp.module.user.model.Permission;
import erp.module.user.model.User;

@Controller
public class BaseController {

	@Autowired
	private HttpServletRequest request;

	// @Autowired
	// private HttpServletResponse response;

	public BaseController() {

	}

	public String getURLWithContextPath(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath();
	}

	private void InitPage(Map<String, Object> map) {

		User userTemp = getCurrentUser();
		if (userTemp != null) {
			map.put("loginedUser", userTemp);

			for (Permission item : userTemp.getLstPermission()) {
				map.put("permission_" + item.getApplied(), true);
			}
		}

		String messageList = this.getRequest().getParameter("messageList");
		String messageStatus = this.getRequest().getParameter("messageStatus");

		// ILog.Debug("messageList: "+messageList, this);
		// ILog.Debug("messageStatus: "+messageStatus, this);

		if (messageList != null) {

			MessageCore mess = new MessageCore(map);
			mess.lstMessage.add(messageList);

			if (messageStatus.equals("2")) {
				mess.showError();
			} else {
				mess.showMessage();
			}
		}
	}

	protected HttpServletRequest getRequest() {
		return request;
		// return ((ServletRequestAttributes) RequestContextHolder
		// .currentRequestAttributes()).getRequest();
	}

	protected HttpSession getSession() {
		return getRequest().getSession();
	}

	protected boolean isLogined() {

		HttpSession session = getSession();

		return session.getAttribute("user") != null;
	}

	protected User getCurrentUser() {

		Object objUser = getSession().getAttribute("user");
		if (objUser != null)
			return (User) objUser;
		return null;

	}

	protected String View(String url, Map<String, Object> map) {

		if (isLogined() == false) {

			MessageCore mess = new MessageCore(map);

			mess.lstMessage.add(MessageDict.ACC_PLZ_LOGIN);

			mess.showMessage();

			url = "redirect:/account/login";
		}
		// if(m_device!=null && m_device.isMobile())
		// url = url+"_mobile";
		if (map != null)
			InitPage(map);
		return url;

	}

	protected String ViewLogin(String url, Map<String, Object> map) {

		// if(m_device!=null && m_device.isMobile())
		// url = url+"_mobile";
		if (map != null)
			InitPage(map);
		return url;

	}

}
