package erp.module.user.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import erp.core.log.ILog;
import erp.core.site.BaseController;
import erp.core.site.MessageCore;
import erp.core.site.MessageDict;
import erp.module.user.service.GroupService;

@Controller
@RequestMapping("/user/group")
public class GroupController extends BaseController {
	

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String list(Map<String, Object> map) {
		
		if(getCurrentUser()==null){
			return View("", map);
		}

		if (!getCurrentUser().has_permission("group_list")) {
			return View("redirect:/alert/access-denied", null);
		}

		GroupService gService = new GroupService();
		map.put("listGroup", gService.Search(""));

		return View("/user/group/list-group", map);
	}

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.POST)
	public String list(@RequestParam("keyword") String keyword,
			Map<String, Object> map) {
		
		if(getCurrentUser()==null){
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("group_list")) {
			return View("redirect:/alert/access-denied", null);
		}

		GroupService gService = new GroupService();
		map.put("listGroup", gService.Search(keyword));
		map.put("Keyword", keyword);

		return View("/user/group/list-group", map);
	}

	@RequestMapping(value = { "/", "/delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable int id, Map<String, Object> map) {

		if(getCurrentUser()==null){
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("group_delete")) {
			return View("redirect:/alert/access-denied", null);
		}

		MessageCore mess = new MessageCore(map);

		GroupService gService = new GroupService();
		if (gService.Delete(id, getCurrentUser().getUser_name())) {

			mess.lstMessage.add(MessageDict.SUCCESS);
			mess.showMessage();
		} else {

			mess.lstMessage.add(MessageDict.FAILED);
			mess.showError();
		}

		return View("redirect:/user/group/list", map);
	}

	@RequestMapping(value = { "/", "/edit" }, method = RequestMethod.POST)
	public String add(@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("description") String description,
			Map<String, Object> map) {

		if(getCurrentUser()==null){
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("group_add")) {
			return View("redirect:/alert/access-denied", null);
		}

		MessageCore mess = new MessageCore(map);

		GroupService gService = new GroupService();

		boolean isFlag = false;

		if (id > 0) {// update
			ILog.Debug("Update group id=" + id, this);
			isFlag = gService.Update(id, name, description, getCurrentUser()
					.getUser_name());
		} else {// add new group

			ILog.Debug("Insert group id=" + id, this);
			isFlag = gService.Insert(name, description, getCurrentUser()
					.getUser_name());
		}

		if (isFlag) {

			mess.lstMessage.add(MessageDict.SUCCESS);
			mess.showMessage();
		} else {

			mess.lstMessage.add(MessageDict.FAILED);
			mess.showError();
		}

		return View("redirect:/user/group/list", map);

	}

}
