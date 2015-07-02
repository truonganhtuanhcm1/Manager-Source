package erp.module.hrm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import erp.core.ConvertCore;
import erp.core.site.BaseController;
import erp.core.site.MessageCore;
import erp.module.hrm.model.Hrm_Contract;
import erp.module.hrm.model.Hrm_Country;
import erp.module.hrm.model.Hrm_Department;
import erp.module.hrm.model.Hrm_State;
import erp.module.hrm.model.Hrm_Termination_Reason;
import erp.module.hrm.model.Hrm_Work_Time;
import erp.module.hrm.service.Hrm_ContractService;
import erp.module.hrm.service.Hrm_CountryService;
import erp.module.hrm.service.Hrm_DepartmentService;
import erp.module.hrm.service.Hrm_StateService;
import erp.module.hrm.service.Hrm_TerminationReasonService;
import erp.module.hrm.service.Hrm_WorkTimeService;

@Controller
@RequestMapping("/hrm/employee_record")
public class EmployeeController extends BaseController {

	@RequestMapping(value = { "/", "/add" }, method = RequestMethod.GET)
	public String add(Map<String, Object> map){
		
		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("employee_add")) {
			return View("redirect:/alert/access-denied", null);
		}
		
		Hrm_StateService stateService = new Hrm_StateService();
		List<Hrm_State> listState = stateService.getAll();
		map.put("ListState", listState);

		Hrm_CountryService countryService = new Hrm_CountryService();
		List<Hrm_Country> listCountry = countryService.getAll();
		map.put("ListCountry", listCountry);
		
		Hrm_WorkTimeService workTimeService = new Hrm_WorkTimeService();
		List<Hrm_Work_Time> listWorkTime = workTimeService.getAll();
		map.put("ListWorkTime", listWorkTime);
		
		Hrm_ContractService contractService = new Hrm_ContractService();
		List<Hrm_Contract> listContract = contractService.getAll();
		map.put("ListContract", listContract);
		
		Hrm_DepartmentService departmentService = new Hrm_DepartmentService();
		List<Hrm_Department> listDepartment = departmentService.getAll();
		map.put("ListDepartment", listDepartment);
		
		Hrm_TerminationReasonService terminationReasonService = new Hrm_TerminationReasonService();
		List<Hrm_Termination_Reason> listTerminationReason = terminationReasonService.getAll();
		map.put("ListTerminationReason", listTerminationReason);
		
		return View("/hrm/employee/employee_record_add", map);
	}
	
	@RequestMapping(value = {"/", "add"}, method = RequestMethod.POST)
	public String add(@RequestParam("empIdInput") String empIdInput,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("midName") String midName,
			@RequestParam("street") String street,
			@RequestParam("cityName") String cityName,
			@RequestParam("stateId") int stateId,
			@RequestParam("zipCode") String zipCode,
			@RequestParam("countryId") int countryId,
			@RequestParam("positionType") String positionType,
			@RequestParam("hiredDate") String hiredDate,
			@RequestParam("salary") String salary,
			@RequestParam("workTimeId") int workTimeId,
			@RequestParam("email") String email,
			@RequestParam("mobile") String mobile,
			@RequestParam("homeNumber") String homeNumber,
			@RequestParam("clearanceLvId") int clearanceLvId, 
			@RequestParam("contractId") int contractId,
			@RequestParam("departmentId") int departmentId, 
			@RequestParam("program") String program,
			@RequestParam("programManager") String programManager,
			@RequestParam("pocPhone") String pocPhone,
			@RequestParam("evaluationDate") String evaluationDate,
			@RequestParam("taxInfo") String taxInfo,
			@RequestParam("courtOrder") String courtOrder,
			@RequestParam("county") String county,
			@RequestParam("courtAddress") String courtAddress,
			@RequestParam("amount") String amount, 
			@RequestParam("terminationDate") String terminationDate,
			@RequestParam(value = "rehire", required = false) boolean rehire,
			@RequestParam(value = "notHire", required = false) boolean notHire,
			@RequestParam("terminationReasonId") int terminationReasonId,
			Map<String, Object> map){
		
		if(getCurrentUser() == null){
			return View("", map);
		}
		
		if(getCurrentUser().has_permission("employee_add")){
			return View("redirect:/alert/access-denied", null);
		}
		
		MessageCore messageCore = new MessageCore(map);
		String createdUser = getCurrentUser().getUser_name();
		
		java.util.Date dtHiredDate = ConvertCore.StringToDate(hiredDate, "MM/dd/yyyy");
		java.util.Date dtEvaluationDate = ConvertCore.StringToDate(evaluationDate, "MM/dd/yyyy");
		java.util.Date dtTerminationDate = ConvertCore.StringToDate(terminationDate, "MM/dd/yyyy");
		
		
		return View("redirect:/hrm/employee_record/list", map);
	}
	
}
