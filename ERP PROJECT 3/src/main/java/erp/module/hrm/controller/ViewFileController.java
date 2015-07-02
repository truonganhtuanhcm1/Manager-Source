package erp.module.hrm.controller;

import java.io.File;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import erp.core.log.ILog;
import erp.core.site.BaseController;

@Controller
@RequestMapping("/file")
public class ViewFileController extends BaseController {
	
	@RequestMapping(value = { "/", "/view/{fileName}" }, method = RequestMethod.GET)
	public String view(@PathVariable("fileName") String fileName,
			Map<String, Object> map){
		
		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("view_file")) {
			return View("redirect:/alert/access-denied", null);
		}
		String domain = "http://14.161.46.73:8080";
		String fileNameFull ="/erp/hrm/candidate_tracker/download/"+ fileName+".file";
		String etc = "&embedded=true";
		String url = domain + fileNameFull + etc;
		ILog.Debug(fileNameFull, this);
		map.put("url", url);
		
		return View("/file/view", map);
	}
	
}
