package erp.module.user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import erp.core.log.ILog;
import erp.core.site.BaseController;
import erp.core.site.MessageCore;
import erp.core.site.MessageDict;
import erp.module.user.model.Permission;
import erp.module.user.service.GroupService;
import erp.module.user.service.PermissionService;

@Controller
@RequestMapping("/user/permission")
public class PermissionController extends BaseController {
	


	@RequestMapping(value = { "/", "/group" }, method = RequestMethod.GET)
	public String permission_group(Map<String, Object> map) {

		if(getCurrentUser()==null){
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("permission_list")) {
			return View("redirect:/alert/access-denied", null);
		}
		
		// Get groups
		GroupService gService = new GroupService();
		map.put("listGroup", gService.Search(""));

		return ViewLogin("/user/permission/group-permission", map);
	}

	@RequestMapping(value = { "/", "/group" }, method = RequestMethod.POST)
	public String permission_group(@RequestParam("keyword") String keyword,
			@RequestParam("group_id") String group_id, Map<String, Object> map) {

		if(getCurrentUser()==null){
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("permission_add")) {
			return View("redirect:/alert/access-denied", null);
		}

		map.put("keyword", keyword);
		map.put("group_id", group_id);

		MessageCore mess = new MessageCore(map);
		
		// Get groups
		GroupService gService = new GroupService();
		map.put("listGroup", gService.Search(""));

		// Get permissions by group

		PermissionService pService = new PermissionService();
		List<Permission> lstPermission = pService.getByGroupId(keyword,group_id);
		map.put("lstPermission", lstPermission);

		if (getRequest().getParameter("btn_save") != null) {

			ILog.Debug("Saving permissions...", this);

			for (Permission permission : lstPermission) {

				if (getRequest().getParameter(permission.getPermission_id()) != null) {
					
					if (getRequest()
							.getParameter(permission.getPermission_id())
							.equals("on")
							&& permission.getApplied().equals("0")) {
						ILog.Debug(permission.getPermission_id() + " on", this);
						pService.add_permission(group_id,permission.getPermission_id());
						permission.setApplied("1");
					}
				}
				
				if (getRequest().getParameter(permission.getPermission_id()) == null
						&& !permission.getApplied().equals("0")) {
					
					ILog.Debug(permission.getPermission_id() + " remove", this);
					pService.remove_permission(group_id,permission.getPermission_id());
					permission.setApplied("0");
				}
				
			}
			
			mess.lstMessage.add(MessageDict.SUCCESS);
			mess.showMessage();
			
		}

		return View("/user/permission/group-permission", map);
	}

}
