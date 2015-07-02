package erp.module.hrm.controller;

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
import erp.core.site.BaseController;
import erp.core.site.MessageCore;
import erp.core.site.MessageDict;
import erp.module.hrm.model.Hrm_Contract;
import erp.module.hrm.service.Hrm_ContractService;

@Controller
@RequestMapping("/hrm/contract")

public class ContractController extends BaseController {
	
	@RequestMapping(value = {"/", "/search"}, method = RequestMethod.GET)
	public String contract_search(
			Map<String, Object> map){
		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("contract_list")) {
			return View("redirect:/alert/access-denied", null);
		}
		return View("/hrm/contract/contract_list", map);
	}

	@RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
	public String contract_list(
			@RequestParam(value = "contractId", required = false) String contractId,
			@RequestParam(value = "contractIdInput", required = false) String contractIdInput,
			@RequestParam(value = "contractNumber", required = false) String contractNumber,
			@RequestParam(value = "contractName", required = false) String contractName,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "modification", required = false) String modification,
			@RequestParam(value = "value", required = false) String value,
			@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate,
			Map<String, Object> map){
		
		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("contract_list")) {
			return View("redirect:/alert/access-denied", null);
		}
		if (contractId == null){
			contractId = "";
		}
		if (contractIdInput == null){
			contractIdInput = "";
		}
		if (contractNumber == null){
			contractNumber = "";
		}
		if (contractName == null){
			contractName = "";
		}
		if (description == null){
			description = "";
		}
		if (modification == null){
			modification = "";
		}
		if(value == null){
			value = "";
		}
		if (startDate == null){
			startDate = "";
		}
		if (endDate == null){
			endDate = "";
		}
		
		map.put("contractId", contractId);
		map.put("contractNumber", contractNumber);
		map.put("contractName", contractName);
		map.put("description", description);
		map.put("modification", modification);
		map.put("value", value);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		
		Date dtStartDate = ConvertCore.StringToDate(startDate, "MM/dd/yyyy");
		Date dtEndDate = ConvertCore.StringToDate(endDate, "MM/dd/yyyy");
		
		Hrm_ContractService contractService = new Hrm_ContractService();
		List<Hrm_Contract> listContract = contractService.search(contractIdInput, contractNumber, 
				contractName, modification, value, dtStartDate, dtEndDate);
		map.put("ListContract", listContract);
		
		return View("/hrm/contract/contract_list", map);
	}
	
	@RequestMapping(value = {"/", "/add"}, method = RequestMethod.GET)
	public String add(Map<String, Object> map){
		
		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("contract_add")) {
			return View("redirect:/alert/access-denied", null);
		}
		
		return View("/hrm/contract/contract_add", map);
	}
	
	@RequestMapping(value = {"/", "/add"}, method = RequestMethod.POST)
	public String add(
			@RequestParam(value = "contractIdInput") String contractIdInput,
			@RequestParam(value = "contractNumber") String contractNumber,
			@RequestParam(value = "contractName") String contractName,
			@RequestParam(value = "value") String value,
			@RequestParam(value = "description") String description,
			@RequestParam(value = "modification") String modification,
			@RequestParam(value = "startDate") String startDate,
			@RequestParam(value = "endDate") String endDate,Map<String, Object> map) throws SQLException{
		
		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("contract_add")) {
			return View("redirect:/alert/access-denied", null);
		}
		MessageCore messageCore = new MessageCore(map);
		java.util.Date dtStartDate = ConvertCore.StringToDate(startDate, "MM/dd/yyyy");
		java.util.Date dtEndDate = ConvertCore.StringToDate(endDate, "MM/dd/yyyy");
		
		String createUser = getCurrentUser().getUser_name();
		Hrm_ContractService contractService = new Hrm_ContractService();
		boolean isCompleted = contractService.addContract(contractIdInput, contractNumber, 
				contractName, description, modification, value, dtStartDate, dtEndDate, createUser);
		
		if (isCompleted) {
			messageCore.lstMessage.add(MessageDict.SUCCESS);
			messageCore.showMessage();

		} else {
			messageCore.lstMessage.add(MessageDict.FAILED);
			messageCore.showError();
			// Reload with information is included in map
			return View("/hrm/contract/contract_add", map);
		}
		
		return View("redirect:/hrm/contract/list", map);
	}
	
	@RequestMapping(value = { "/", "/edit/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable int id, Map<String, Object> map) {

		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("contract_edit")) {
			return View("redirect:/alert/access-denied", null);
		}

		// Get Requisition model by ID
		Hrm_ContractService contractService = new Hrm_ContractService();
		Hrm_Contract targetContract = null;
		targetContract = contractService.getById(id);

		map.put("targetContract", targetContract);
		
		

		return View("/hrm/contract/contract_edit", map);
	}
	
	@RequestMapping(value = { "/", "/edit" }, method = RequestMethod.POST)
	public String edit(@RequestParam("contractId") int contractId,
			@RequestParam("contractIdInput") String contractIdInput,
			@RequestParam("contractNumber") String contractNumber,
			@RequestParam("contractName") String contractName,
			@RequestParam("description") String description,
			@RequestParam("modification") String modification,
			@RequestParam("value") String value,
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			
			Map<String, Object> map) throws SQLException {

		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("contract_edit")) {
			return View("redirect:/alert/access-denied", null);
		}
		MessageCore messageCore = new MessageCore(map);
		java.util.Date dtStartDate = ConvertCore.StringToDate(startDate, "MM/dd/yyyy");
		java.util.Date dtEndDate = ConvertCore.StringToDate(endDate, "MM/dd/yyyy");
		String updateUser = getCurrentUser().getUser_name();
		
		// Get Requisition model by ID
		Hrm_ContractService contractService = new Hrm_ContractService();

		boolean isCompleted = contractService.UpdateContract(contractId, contractIdInput, 
				contractNumber, contractName,  description, modification, 
				value, dtStartDate, dtEndDate, updateUser);

		if (isCompleted) {
			messageCore.lstMessage.add(MessageDict.SUCCESS);
			messageCore.showMessage();
		} else {
			messageCore.lstMessage.add(MessageDict.FAILED);
			messageCore.showError();
			return "";
		}

		return View("redirect:/hrm/contract/list", map);
	}
	
	@RequestMapping(value = { "/", "/delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable int id, Map<String, Object> map) {

		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("contract_delete")) {
			return View("redirect:/alert/access-denied", null);
		}

		MessageCore mess = new MessageCore(map);
		String deleteUser = getCurrentUser().getUser_name();
		Hrm_ContractService contractService = new Hrm_ContractService();

		try {
			boolean isOk = contractService.deleteContract(id, deleteUser);
			if (isOk){
				// enable
				mess.lstMessage.add(MessageDict.SUCCESS);
				mess.showMessage();
			} else {
				mess.lstMessage.add(MessageDict.FAILED);
				mess.showError();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return View("redirect:/hrm/contract/list", map);
	}
	
	@RequestMapping(value = { "/", "/view/{id}" }, method = RequestMethod.GET)
	public String view(@PathVariable int id, Map<String, Object> map) {

		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("contract_view")) {
			return View("redirect:/alert/access-denied", null);
		}

		// Get Requisition model by ID
		Hrm_ContractService contractService = new Hrm_ContractService();
		Hrm_Contract targetContract = null;
		targetContract = contractService.getById(id);

		map.put("targetContract", targetContract);

		return View("/hrm/contract/contract_view", map);
	}
	

}
