package erp.module.hrm.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import erp.core.ConvertCore;
import erp.core.log.ILog;
import erp.core.site.BaseController;
import erp.core.site.MessageCore;
import erp.core.site.MessageDict;
import erp.module.hrm.model.Hrm_Client_Group;
import erp.module.hrm.model.Hrm_Recruitment;
import erp.module.hrm.model.Hrm_RecruitmentType;
import erp.module.hrm.service.Hrm_ClientGroupService;
import erp.module.hrm.service.Hrm_RecruitmentService;
import erp.module.hrm.service.Hrm_RecruitmentTypeService;

@Controller
@RequestMapping("/hrm/recruitment")// map from url http://localhost:8080/erp/hrm/recruitment/list
public class RecruitmentController extends BaseController {
	
	@RequestMapping(value = { "/", "/employee_record_edit" }, method = RequestMethod.GET)
	public String employee_record_edit(Map<String, Object> map){
		return View("/hrm/recruitment/employee_record_edit", map);
	}
	
	@RequestMapping(value = { "/", "/employee_record_list" }, method = RequestMethod.GET)
	public String employee_record_list(Map<String, Object> map){
		return View("/hrm/recruitment/employee_record_list", map);
	}
	
	

	
	@RequestMapping(value = { "/", "/candidate_tracker_edit" }, method = RequestMethod.GET)
	public String candidate_tracker_edit(Map<String, Object> map){
		return View("/hrm/recruitment/candidate_tracker_edit", map);
	}
	
	@RequestMapping(value = { "/", "/candidate_tracker_list" }, method = RequestMethod.GET)
	public String candidate_tracker_list(Map<String, Object> map){
		return View("/hrm/recruitment/candidate_tracker_list", map);
	}
	
	
	
//  [http://localhost:8080/erp => root]     [/hrm/recruitment => controler]          [/list => function mapped]
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "posistion_id", required = false) String posistion_id,// Get value from  html tag name
			@RequestParam(value = "type_id", required = false) String type_id,
			@RequestParam(value = "status_id", required = false) String status_id,
			@RequestParam(value = "from_date", required = false) String from_date,
			@RequestParam(value = "to_date", required = false) String to_date,
			Map<String, Object> map) {
//Check login ? => redirect => login page
		if(getCurrentUser()==null){
			return View("", map);
		}
		// Check permission
		if (!getCurrentUser().has_permission("recruitment_list")) {
			return View("redirect:/alert/access-denied", null);
		}
// Put  value to html (view)
		map.put("posistion_id", posistion_id);
		map.put("type_id", type_id);
		map.put("status_id", status_id);
		map.put("from_date", from_date);
		map.put("to_date", to_date);

		// Get list types // get data from bus class
		Hrm_RecruitmentTypeService rtService = new Hrm_RecruitmentTypeService();

		List<Hrm_RecruitmentType> lstResultTypes = rtService.getList();
// Put result to view
		map.put("ListType", lstResultTypes);

		// Get list groups, positions

		Hrm_ClientGroupService grService = new Hrm_ClientGroupService();

		List<Hrm_Client_Group> lstResultGroups = grService.getList();

		map.put("ListGroup", lstResultGroups);

		// Search Recruitment

		int iPosistion_id = -1;
		if (posistion_id != null)
			iPosistion_id = Integer.parseInt(posistion_id);

		int iType_id = -1;
		if (type_id != null)
			iType_id = Integer.parseInt(type_id);

		int iStatus_id = -1;
		if (status_id != null)
			iStatus_id = Integer.parseInt(status_id);

		java.util.Date dtFrom_date = null;
		if (from_date != null && from_date != "")
			dtFrom_date = ConvertCore.StringToDate(from_date, "MM/dd/yyyy");

		java.util.Date dtTo_date = null;
		if (to_date != null && to_date != "")
			dtTo_date = ConvertCore.StringToDate(to_date, "MM/dd/yyyy");

		Hrm_RecruitmentService rreService = new Hrm_RecruitmentService();

		List<Hrm_Recruitment> lstRecruit = rreService.Search(iPosistion_id,
				iType_id, iStatus_id, dtFrom_date, dtTo_date);

		map.put("lstRecruit", lstRecruit);
//Call view with path : hrm/recruitment/list-recruitment
		return View("/hrm/recruitment/list-recruitment", map);
	}

	@RequestMapping(value = { "/", "/add" }, method = RequestMethod.GET)
	public String add(Map<String, Object> map) {

		if(getCurrentUser()==null){
			return View("", map);
		}
		
		// Get list types
		Hrm_RecruitmentTypeService rtService = new Hrm_RecruitmentTypeService();

		List<Hrm_RecruitmentType> lstResultTypes = rtService.getList();

		map.put("ListType", lstResultTypes);

		// Get list groups, positions

		Hrm_ClientGroupService grService = new Hrm_ClientGroupService();

		List<Hrm_Client_Group> lstResultGroups = grService.getList();

		map.put("ListGroup", lstResultGroups);

		return View("/hrm/recruitment/add-recruitment", map);
	}

	@RequestMapping(value = { "/", "/add" }, method = RequestMethod.POST,headers=("content-type=multipart/*"))
	public String add(@RequestParam("id") int id,
			@RequestParam("PositionID") int PositionID,
			@RequestParam("TypeID") int TypeID,
			@RequestParam("title") String title,
			@RequestParam("expiredDate") String expiredDate,
			@RequestParam(value = "Status", required = false) boolean Status,
			@RequestParam("description") String description,
			@RequestParam("requirement") String requirement,
			Map<String, Object> map) {

		if(getCurrentUser()==null){
			return View("", map);
		}
		
		java.util.Date expDate = ConvertCore.StringToDate(expiredDate,
				"MM/dd/yyyy");
		MessageCore mess = new MessageCore(map);
		// Insert recruitment
		Hrm_RecruitmentService reService = new Hrm_RecruitmentService();

		if (id == 0) {// Insert
			ILog.Debug("Insert recruitment " + id, this);
			if (reService.Insert(PositionID, TypeID, title, expDate, Status,
					description, requirement, this.getCurrentUser()
							.getUser_name())) {

				mess.lstMessage.add(MessageDict.SUCCESS);
				mess.showMessage();

			} else {

				map.put("PositionID", PositionID);
				map.put("title", title);
				map.put("expiredDate", expiredDate);
				map.put("Status", Status);
				map.put("TypeID", TypeID);
				map.put("description", description);
				map.put("requirement", requirement);

				mess.lstMessage.add(MessageDict.FAILED);

				mess.showError();
				
				// Reload with information is included in map
				return View("/hrm/recruitment/add-recruitment", map);
			}
		} else {// update
			ILog.Debug("Update recruitment " + id, this);
			if (reService.Update(id, PositionID, TypeID, title, expDate,
					Status, description, requirement, this.getCurrentUser()
							.getUser_name())) {

				mess.lstMessage.add(MessageDict.SUCCESS);
				mess.showMessage();

			} else {

				mess.lstMessage.add(MessageDict.FAILED);

				mess.showError();

				return View("redirect:/hrm/recruitment/edit/" + id, map);
			}
		}

		return View("redirect:/hrm/recruitment/list", map);
	}

	@RequestMapping(value = { "/", "/enable/{id}" }, method = RequestMethod.GET)
	public String enable(@PathVariable int id, Map<String, Object> map) {

		if(getCurrentUser()==null){
			return View("", map);
		}
		
		MessageCore mess = new MessageCore(map);

		Hrm_RecruitmentService reService = new Hrm_RecruitmentService();

		try {
			if (reService.UpdateStatus(id, 1, getCurrentUser().getUser_name())) {// enable

				mess.lstMessage.add(MessageDict.SUCCESS);
				mess.showMessage();
			} else {

				mess.lstMessage.add(MessageDict.FAILED);
				mess.showError();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return View("redirect:/hrm/recruitment/list", map);
	}

	@RequestMapping(value = { "/", "/disable/{id}" }, method = RequestMethod.GET)
	public String disable(@PathVariable int id, Map<String, Object> map) {

		if(getCurrentUser()==null){
			return View("", map);
		}
		
		MessageCore mess = new MessageCore(map);

		Hrm_RecruitmentService reService = new Hrm_RecruitmentService();

		try {
			if (reService.UpdateStatus(id, 0, getCurrentUser().getUser_name())) {// enable

				mess.lstMessage.add(MessageDict.SUCCESS);
				mess.showMessage();
			} else {

				mess.lstMessage.add(MessageDict.FAILED);
				mess.showError();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return View("redirect:/hrm/recruitment/list", map);
	}

	@RequestMapping(value = { "/", "/delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable int id
			, Map<String, Object> map) {

		if(getCurrentUser()==null){
			return View("", map);
		}
		
		MessageCore mess = new MessageCore(map);

		Hrm_RecruitmentService reService = new Hrm_RecruitmentService();

		try {
			if (reService.Delete(id, getCurrentUser().getUser_name())) {// enable

				mess.lstMessage.add(MessageDict.SUCCESS);
				mess.showMessage();
			} else {

				mess.lstMessage.add(MessageDict.FAILED);
				mess.showError();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return View("redirect:/hrm/recruitment/list", map);
	}

	@RequestMapping(value = { "/", "/edit/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable int id, Map<String, Object> map) {

		if(getCurrentUser()==null){
			return View("", map);
		}
		
		// Get list types
		Hrm_RecruitmentTypeService rtService = new Hrm_RecruitmentTypeService();

		List<Hrm_RecruitmentType> lstResultTypes = rtService.getList();

		map.put("ListType", lstResultTypes);

		// Get list groups, positions

		Hrm_ClientGroupService grService = new Hrm_ClientGroupService();

		List<Hrm_Client_Group> lstResultGroups = grService.getList();

		map.put("ListGroup", lstResultGroups);

		// Get recruitment by ID
		Hrm_RecruitmentService reService = new Hrm_RecruitmentService();

		Hrm_Recruitment recruit = null;
		try {
			recruit = reService.GetByID(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		map.put("recruit", recruit);

		return View("/hrm/recruitment/edit-recruitment", map);
	}
}
