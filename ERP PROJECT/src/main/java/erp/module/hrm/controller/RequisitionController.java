package erp.module.hrm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import erp.core.ConvertCore;
import erp.core.log.ILog;
import erp.core.site.BaseController;
import erp.core.site.MessageCore;
import erp.core.site.MessageDict;
import erp.module.hrm.model.Hrm_City;
import erp.module.hrm.model.Hrm_Clearance_Level;
import erp.module.hrm.model.Hrm_Contract;
import erp.module.hrm.model.Hrm_Country;
import erp.module.hrm.model.Hrm_Education;
import erp.module.hrm.model.Hrm_Position;
import erp.module.hrm.model.Hrm_Requisition;
import erp.module.hrm.model.Hrm_State;
import erp.module.hrm.service.Hrm_CityService;
import erp.module.hrm.service.Hrm_Clearance_LevelService;
import erp.module.hrm.service.Hrm_ContractService;
import erp.module.hrm.service.Hrm_CountryService;
import erp.module.hrm.service.Hrm_EducationService;
import erp.module.hrm.service.Hrm_PositionService;
import erp.module.hrm.service.Hrm_RequisitionService;
import erp.module.hrm.service.Hrm_StateService;

@Controller
@RequestMapping("/hrm/requisition")
public class RequisitionController extends BaseController {

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String list(Map<String, Object> map) {

		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("requisition_list")) {
			return View("redirect:/alert/access-denied", null);
		}
		
		Hrm_PositionService posService = new Hrm_PositionService();
		List<Hrm_Position> listPosition = posService.getAll();
		map.put("ListPosition", listPosition);

		Hrm_ContractService contractService = new Hrm_ContractService();
		List<Hrm_Contract> listContract = contractService.getAll();
		map.put("ListContract", listContract);
		
		Hrm_RequisitionService requisitionService = new Hrm_RequisitionService();
		List<Hrm_Requisition> listRequisition = requisitionService.getAll();
		map.put("ListRequisition", listRequisition);

		return View("/hrm/requisition/requisition_list", map);
	}
	
	@RequestMapping(value = { "/", "/search" }, method = RequestMethod.GET)
	public String search(
			@RequestParam(value = "requisition_id", required = false) int requisition_id,
			@RequestParam(value = "contract_id", required = false) int contract_id,
			@RequestParam(value = "location", required = false) String location,
			@RequestParam(value = "requester", required = false) String requester,
			@RequestParam(value = "position_id", required = false) String position_id,
			@RequestParam(value = "requisitionStatusId", required = false) String requisitionStatusId,
			@RequestParam(value = "required_date", required = false) String required_date

			, Map<String, Object> map) {

		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("requisition_list")) {
			return View("redirect:/alert/access-denied", null);
		}
		
		/*if (contract_id == null)
			contract_id = "";*/
		/*if (requisition_id == null)
			requisition_id = "-1";*/
		if (location == null)
			location = "";
		if (requester == null)
			requester = "";
		if (position_id == null)
			position_id = "-1";
		if (required_date == null)
			required_date = "";
		if(requisitionStatusId == null){
			requisitionStatusId = "-1";
		}

		map.put("contract_id", contract_id);
		map.put("requisition_id", requisition_id);
		map.put("location", location);
		map.put("requester", requester);
		map.put("position_id", position_id);
		map.put("requisitionStatusId", requisitionStatusId);
		map.put("required_date", required_date);
		
		Hrm_PositionService posService = new Hrm_PositionService();
		List<Hrm_Position> listPosition = posService.getAll();
		map.put("ListPosition", listPosition);
		
		Hrm_RequisitionService requisitionService = new Hrm_RequisitionService();
		List<Hrm_Requisition> listRequisition = requisitionService.getAll();
		map.put("ListRequisition", listRequisition);
		
		Hrm_ContractService contractService = new Hrm_ContractService();
		List<Hrm_Contract> listContract = contractService.getAll();
		map.put("ListContract", listContract);

		java.util.Date dtRequiredDate = null;
		
		if (required_date!="")
			dtRequiredDate = ConvertCore.StringToDate(required_date,
					"MM/dd/yyyy");
		int iPositionId = Integer.parseInt(position_id);
		int iRequisitionStatusId = Integer.parseInt(requisitionStatusId);

		List<Hrm_Requisition> listRequisitionSearched = requisitionService.getAll(
				contract_id, requisition_id, location, requester,
				iPositionId, iRequisitionStatusId, dtRequiredDate);
		map.put("ListRequisitionSearched", listRequisitionSearched);

		

		return View("/hrm/requisition/requisition_list", map);
	}

	@RequestMapping(value = { "/", "/add" }, method = RequestMethod.GET)
	public String add(Map<String, Object> map) {

		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("requisition_add")) {
			return View("redirect:/alert/access-denied", null);
		}
		Hrm_ContractService contractService = new Hrm_ContractService();
		List<Hrm_Contract> listContract = contractService.getAll();
		map.put("ListContract", listContract);

		Hrm_PositionService posService = new Hrm_PositionService();
		List<Hrm_Position> listPosition = posService.getAll();
		map.put("ListPosition", listPosition);

		Hrm_Clearance_LevelService clrLvService = new Hrm_Clearance_LevelService();
		List<Hrm_Clearance_Level> listClearanceLv = clrLvService.getAll();
		map.put("ListClearanceLv", listClearanceLv);

		Hrm_EducationService eduService = new Hrm_EducationService();
		List<Hrm_Education> listEducation = eduService.getAll();
		map.put("ListEducation", listEducation);

		Hrm_StateService stateService = new Hrm_StateService();
		List<Hrm_State> listState = stateService.getAll();
		map.put("ListState", listState);

		Hrm_CountryService countryService = new Hrm_CountryService();
		List<Hrm_Country> listCountry = countryService.getAll();
		map.put("ListCountry", listCountry);
		
		return View("/hrm/requisition/requisition_add", map);
	}

	@RequestMapping(value = { "/", "/add" }, method = RequestMethod.POST)
	public String add(@RequestParam("id") int id,
			@RequestParam("requisitionIdInput") String requisitionIdInput,
			@RequestParam("contractId") int contractId,
			@RequestParam("requester") String requester,
			@RequestParam("positionId") int positionId,
			@RequestParam("requiredDate") String requiredDate,
			@RequestParam("requisitionStatusId") int requisitionStatusId,
			@RequestParam("salaryRange") String salaryRange,
			@RequestParam("clearanceLvId") int clearanceLvId,
			@RequestParam("certificateReq") String certificateReq,
			@RequestParam("educationId") int educationId,
			@RequestParam(value = "educationOther", required = false) String educationOther,
			@RequestParam("cityName") String cityName,
			@RequestParam("stateId") int stateId,
			@RequestParam("countryId") int countryId,
			@RequestParam("attachment") MultipartFile attachment,
			Map<String, Object> map) throws SQLException {
		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		
		if (!getCurrentUser().has_permission("requisition_add")) {
			return View("redirect:/alert/access-denied", null);
		}

		java.util.Date dtRequiredDate = ConvertCore.StringToDate(requiredDate,
				"MM/dd/yyyy");
		MessageCore messageCore = new MessageCore(map);
		
		Hrm_RequisitionService requisitionService = new Hrm_RequisitionService();
		String attachmentName = attachment.getOriginalFilename();
		int randomNum = 10000 + (int) (Math.random() * 99999);

		attachmentName = randomNum + attachmentName;

		String filePath = new File("").getAbsolutePath();

		if (!attachment.isEmpty()) {
			try {
				byte[] bytes = attachment.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(filePath
								+ "/fileuploads/" + attachmentName)));
				stream.write(bytes);
				stream.close();
				ILog.Debug("You successfully uploaded " + attachmentName + "!",
						this);
			} catch (Exception e) {
				ILog.Debug("You failed to upload " + attachmentName + " => "
						+ e.getMessage(), this);
			}
		} else {
			ILog.Debug("You failed to upload " + attachmentName
					+ " because the file was empty.", this);
		}

		educationOther = educationOther.trim();
		boolean isCompleted = requisitionService.addRequisition(
				requisitionIdInput, contractId, requester, positionId,
				dtRequiredDate, requisitionStatusId, salaryRange, clearanceLvId,
				certificateReq, educationId, educationOther, cityName, stateId,
				countryId, attachmentName, getCurrentUser().getUser_name(),
				getCurrentUser().getUser_name());

		if (isCompleted) {
			messageCore.lstMessage.add(MessageDict.SUCCESS);
			messageCore.showMessage();

		} else {
			messageCore.lstMessage.add(MessageDict.FAILED);
			messageCore.showError();
			// Reload with information is included in map
			return View("/hrm/requisition/requisition_add", map);
		}

		return View("redirect:/hrm/requisition/list", map);
	}

	@RequestMapping(value = { "/", "/edit/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable int id, Map<String, Object> map) {

		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("requisition_edit")) {
			return View("redirect:/alert/access-denied", null);
		}
		Hrm_ContractService contractService = new Hrm_ContractService();
		List<Hrm_Contract> listContract = contractService.getAll();
		map.put("ListContract", listContract);

		Hrm_PositionService posService = new Hrm_PositionService();
		List<Hrm_Position> listPosition = posService.getAll();
		map.put("ListPosition", listPosition);

		Hrm_Clearance_LevelService clrLvService = new Hrm_Clearance_LevelService();
		List<Hrm_Clearance_Level> listClearanceLv = clrLvService.getAll();
		map.put("ListClearanceLv", listClearanceLv);

		Hrm_EducationService eduService = new Hrm_EducationService();
		List<Hrm_Education> listEducation = eduService.getAll();
		map.put("ListEducation", listEducation);

		Hrm_StateService stateService = new Hrm_StateService();
		List<Hrm_State> listState = stateService.getAll();
		map.put("ListState", listState);

		Hrm_CountryService countryService = new Hrm_CountryService();
		List<Hrm_Country> listCountry = countryService.getAll();
		map.put("ListCountry", listCountry);
		
		Hrm_CityService cityService = new Hrm_CityService();
		List<Hrm_City> listCity = cityService.getAll();
		map.put("ListCity", listCity);
		
		// Get Requisition model by ID
		Hrm_RequisitionService requisitionService = new Hrm_RequisitionService();
		Hrm_Requisition targetRequisition = null;
		targetRequisition = requisitionService.getById(id);

		map.put("targetRequisition", targetRequisition);
		
		return View("/hrm/requisition/requisition_edit", map);
	}
	
	@RequestMapping(value = { "/", "/view/{id}" }, method = RequestMethod.GET)
	public String view(@PathVariable int id, Map<String, Object> map) {
		
		if (!getCurrentUser().has_permission("requisition_view")) {
			return View("redirect:/alert/access-denied", null);
		}
		if (getCurrentUser() == null) {
			return View("", map);
		}

		Hrm_ContractService contractService = new Hrm_ContractService();
		List<Hrm_Contract> listContract = contractService.getAll();
		map.put("ListContract", listContract);

		Hrm_PositionService posService = new Hrm_PositionService();
		List<Hrm_Position> listPosition = posService.getAll();
		map.put("ListPosition", listPosition);

		Hrm_Clearance_LevelService clrLvService = new Hrm_Clearance_LevelService();
		List<Hrm_Clearance_Level> listClearanceLv = clrLvService.getAll();
		map.put("ListClearanceLv", listClearanceLv);

		Hrm_EducationService eduService = new Hrm_EducationService();
		List<Hrm_Education> listEducation = eduService.getAll();
		map.put("ListEducation", listEducation);

		Hrm_StateService stateService = new Hrm_StateService();
		List<Hrm_State> listState = stateService.getAll();
		map.put("ListState", listState);

		Hrm_CountryService countryService = new Hrm_CountryService();
		List<Hrm_Country> listCountry = countryService.getAll();
		map.put("ListCountry", listCountry);

		// Get Requisition model by ID
		Hrm_RequisitionService requisitionService = new Hrm_RequisitionService();
		Hrm_Requisition targetRequisition = requisitionService.getById(id);

		map.put("targetRequisition", targetRequisition);

		return View("/hrm/requisition/requisition_view", map);
	}


	@RequestMapping(value = { "/", "/edit" }, method = RequestMethod.POST)
	public String edit(@RequestParam("requisitionId") int requisitionId,
			@RequestParam("requisitionIdInput") String requisitionIdInput,
			@RequestParam("contractId") int contractId,
			@RequestParam("requester") String requester,
			@RequestParam("positionId") int positionId,
			@RequestParam("requiredDate") String requiredDate,
			@RequestParam("requisitionStatusId") int requisitionStatusId,
			@RequestParam("salaryRange") String salaryRange,
			@RequestParam("clearanceLvId") int clearanceLvId,
			@RequestParam("certificateReq") String certificateReq,
			@RequestParam("educationId") int educationId,
			@RequestParam(value = "educationOther", required = false) String educationOther,
			@RequestParam("cityName") String cityName,
			@RequestParam("stateId") int stateId,
			@RequestParam("countryId") int countryId,
			@RequestParam("attachment") MultipartFile attachment,
			@RequestParam("oldfile") String oldfile, Map<String, Object> map)
			throws SQLException {

		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("requisition_edit")) {
			return View("redirect:/alert/access-denied", null);
		}

		java.util.Date dtRequiredDate = ConvertCore.StringToDate(requiredDate, "MM/dd/yyyy");

		MessageCore messageCore = new MessageCore(map);
		String newFile = oldfile;
		if (attachment != null) {

			String attachmentName = attachment.getOriginalFilename();
			if (!attachmentName.isEmpty()) {
				int randomNum = 10000 + (int) (Math.random() * 99999);

				attachmentName = randomNum + attachmentName;

				String filePath = new File("").getAbsolutePath();

				if (!attachment.isEmpty()) {
					try {
						byte[] bytes = attachment.getBytes();
						BufferedOutputStream stream = new BufferedOutputStream(
								new FileOutputStream(new File(filePath
										+ "/fileuploads/" + attachmentName)));
						stream.write(bytes);
						stream.close();
						ILog.Debug("You successfully uploaded "
								+ attachmentName + "!", this);

						try {
							File oldFileDelete = new File(filePath
									+ "/fileuploads/" + oldfile);
							oldFileDelete.delete();
						} catch (Exception e) {

						}
						newFile = attachmentName;
					} catch (Exception e) {
						ILog.Debug("You failed to upload " + attachmentName
								+ " => " + e.getMessage(), this);
					}
				} else {
					ILog.Debug("You failed to upload " + attachmentName
							+ " because the file was empty.", this);
				}
			}
		}

		Hrm_RequisitionService requisitionService = new Hrm_RequisitionService();
		educationOther = educationOther.trim();
		boolean isCompleted = requisitionService.update(requisitionId,
				requisitionIdInput, contractId, requester, positionId,
				dtRequiredDate, requisitionStatusId, salaryRange, clearanceLvId,
				certificateReq, educationId, educationOther, cityName, stateId,
				countryId, newFile, getCurrentUser().getUser_name());

		if (isCompleted) {
			messageCore.lstMessage.add(MessageDict.SUCCESS);
			messageCore.showMessage();
		} else {
			messageCore.lstMessage.add(MessageDict.FAILED);
			messageCore.showError();
			// Reload with information is included in map
			// return View("/hrm/requisition/edit", map);
			return "";
		}

		return View("redirect:/hrm/requisition/list", map);
	}

	@RequestMapping(value = { "/", "/delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable int id, Map<String, Object> map) {

		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		
		if (!getCurrentUser().has_permission("requisition_delete")) {
			return View("redirect:/alert/access-denied", null);
		}

		MessageCore mess = new MessageCore(map);

		Hrm_RequisitionService requisitionService = new Hrm_RequisitionService();

		try {
			if (requisitionService.Delete(id, getCurrentUser().getUser_name())) {
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

		return View("redirect:/hrm/requisition/list", map);
	}

	@RequestMapping(value = { "/", "/download/{file_name}" }, method = RequestMethod.GET)
	public void downLoad(@PathVariable("file_name") String fileName,
			HttpServletResponse response) throws IOException {

		String filePath = new File("").getAbsolutePath();

		String fileNameFull = filePath + "/fileuploads/" + fileName;
		ILog.Debug("File name to download: " + fileName, this);
		File fileToDownload = new File(fileNameFull);
		
		InputStream inputStream = new FileInputStream(fileToDownload);
		response.setContentType("application/force-download");
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName.replaceAll(" ", "_"));
		IOUtils.copy(inputStream, response.getOutputStream());
		response.flushBuffer();
		inputStream.close();
	}
	
	@RequestMapping(value = { "/", "/copy/{id}" }, method = RequestMethod.GET)
	public String copy(@PathVariable int id, Map<String, Object> map) {
		
		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("requisition_copy")) {
			return View("redirect:/alert/access-denied", null);
		}

		Hrm_ContractService contractService = new Hrm_ContractService();
		List<Hrm_Contract> listContract = contractService.getAll();
		map.put("ListContract", listContract);

		Hrm_PositionService posService = new Hrm_PositionService();
		List<Hrm_Position> listPosition = posService.getAll();
		map.put("ListPosition", listPosition);

		Hrm_Clearance_LevelService clrLvService = new Hrm_Clearance_LevelService();
		List<Hrm_Clearance_Level> listClearanceLv = clrLvService.getAll();
		map.put("ListClearanceLv", listClearanceLv);

		Hrm_EducationService eduService = new Hrm_EducationService();
		List<Hrm_Education> listEducation = eduService.getAll();
		map.put("ListEducation", listEducation);

		Hrm_StateService stateService = new Hrm_StateService();
		List<Hrm_State> listState = stateService.getAll();
		map.put("ListState", listState);

		Hrm_CountryService countryService = new Hrm_CountryService();
		List<Hrm_Country> listCountry = countryService.getAll();
		map.put("ListCountry", listCountry);
		
		// Get Requisition model by ID
		Hrm_RequisitionService requisitionService = new Hrm_RequisitionService();
		Hrm_Requisition targetRequisition = requisitionService.getById(id);
		map.put("targetRequisition", targetRequisition);
		
		return View("/hrm/requisition/requisition_add", map);
	}
	

	/*@RequestMapping(value = {"/", "/state_change/{id}"}, method = RequestMethod.GET)
	@ResponseBody
	public String processAjaxStateChangeRequest(@PathVariable int id){
		
		// Reload city list follow by stateId 
		Hrm_CityService cityService = new Hrm_CityService();
		List<Hrm_City> listCity = cityService.getByStateId(id);
		
		if(listCity == null || listCity.size() == 0){
			return null;
		}

		String jsonResponse = "{\"cities\":[";
		
		for (int i = 0; i < listCity.size(); i++) {
			Hrm_City city = listCity.get(i);
			String statement = "{\"cityId\" : %d, \"zipcode\" : \"%s\" , \"cityName\" : \"%s\"}";
			String cityName = city.getCity_name().replace("\n", "").replace("\r", "");
			String zipCode = city.getZipcode().replace("\n", "").replace("\r", "");
			
			jsonResponse = jsonResponse.concat(String.format(statement, city.getCity_id(), zipCode, cityName));
			
			if(i + 1 < listCity.size()){
				jsonResponse = jsonResponse.concat(", ");
			}
		}
		
		jsonResponse = jsonResponse.concat("]}");
		return jsonResponse;
	}
	
	@RequestMapping(value = {"/", "/city_change/{id}"}, method = RequestMethod.GET)
	@ResponseBody
	public String processAjaxCityChangeRequest(@PathVariable int id){
		
		// Reload city list follow by stateId 
		Hrm_CityService cityService = new Hrm_CityService();
		List<Hrm_City> listCity = cityService.getByCityId(id);
		
		if(listCity == null || listCity.size() == 0){
			return null;
		}

		String jsonResponse = "{\"cities\":[";
		for (int i = 0; i < listCity.size(); i++) {
			Hrm_City city = listCity.get(i);
			String statement = "{\"cityId\" : %d, \"zipcode\" : \"%s\" , \"cityName\" : \"%s\"}";
			String cityName = city.getCity_name().replace("\n", "").replace("\r", "");
			String zipCode = city.getZipcode().replace("\n", "").replace("\r", "");
			
			jsonResponse = jsonResponse.concat(String.format(statement, city.getCity_id(), zipCode, cityName));
			
			if(i + 1 < listCity.size()){
				jsonResponse = jsonResponse.concat(", ");
			}
		}
		jsonResponse = jsonResponse.concat("]}");
		
		return jsonResponse;
	}*/
}
