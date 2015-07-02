package erp.module.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import erp.core.site.BaseController;

@Controller
@RequestMapping("/alert")
public class AlertController extends BaseController {

	@RequestMapping(value = { "/", "/access-denied" }, method = RequestMethod.GET)
	public String access_denied() {

		return View("/alert/access-denied", null);
	}
}
