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
import erp.module.hrm.model.Hrm_Candidate_Tracker;
import erp.module.hrm.model.Hrm_Contract;
import erp.module.hrm.model.Hrm_Country;
import erp.module.hrm.model.Hrm_Education;
import erp.module.hrm.model.Hrm_Position;
import erp.module.hrm.model.Hrm_Requisition;
import erp.module.hrm.model.Hrm_State;
import erp.module.hrm.model.Hrm_Status;
import erp.module.hrm.service.Hrm_CandidateTrackerService;
import erp.module.hrm.service.Hrm_ContractService;
import erp.module.hrm.service.Hrm_CountryService;
import erp.module.hrm.service.Hrm_EducationService;
import erp.module.hrm.service.Hrm_PositionService;
import erp.module.hrm.service.Hrm_RequisitionService;
import erp.module.hrm.service.Hrm_StateService;
import erp.module.hrm.service.Hrm_StatusService;

@Controller
@RequestMapping("/hrm/candidate_tracker")
public class CandidateTrackerController extends BaseController {
	
	@RequestMapping(value = { "/", "/add" }, method = RequestMethod.GET)
	public String add(Map<String, Object> map){
		
		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("cand_tracker_add")) {
			return View("redirect:/alert/access-denied", null);
		}
		
		Hrm_RequisitionService reqService = new Hrm_RequisitionService();
		List<Hrm_Requisition> listRequisition = reqService.getAll();
		map.put("ListRequisition", listRequisition);
		
		Hrm_ContractService contractService = new Hrm_ContractService();
		List<Hrm_Contract> listContract = contractService.getAll();
		map.put("ListContract", listContract);
		
		Hrm_PositionService posService = new Hrm_PositionService();
		List<Hrm_Position> listPosition = posService.getAll();
		map.put("ListPosition", listPosition);
		
		Hrm_StateService stateService = new Hrm_StateService();
		List<Hrm_State> listState = stateService.getAll();
		map.put("ListState", listState);

		Hrm_CountryService countryService = new Hrm_CountryService();
		List<Hrm_Country> listCountry = countryService.getAll();
		map.put("ListCountry", listCountry);
		
		Hrm_EducationService eduService = new Hrm_EducationService();
		List<Hrm_Education> listEducation = eduService.getAll();
		map.put("ListEducation", listEducation);
		
		Hrm_StatusService statusService = new Hrm_StatusService();
		List<Hrm_Status> listStatus = statusService.getAll();
		
		map.put("ListStatus", listStatus);
		
		return View("/hrm/candidate_tracker/candidate_tracker_add", map);
	}
	
	@RequestMapping(value = { "/", "/add" }, method = RequestMethod.POST)
	public String add(@RequestParam("id") int id, 
			@RequestParam("candidateTrackerIdInput") String candidateTrackerIdInput,
			@RequestParam("contractId") int contractId,
			@RequestParam("requisitionId") int requisitionId,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("midName") String midName,
			@RequestParam("city") String city,
			@RequestParam("stateId") int stateId,
			@RequestParam("countryId") int countryId,
			@RequestParam("statusId") int statusId,
			@RequestParam("statusOther") String statusOther,
			@RequestParam("clearanceLvId") int clearanceLvId,
			@RequestParam("positionId") int positionId,
			@RequestParam("jobLocation") String jobLocation,
			@RequestParam("salaryRange") String salaryRange,
			@RequestParam("educationId") int educationId,
			@RequestParam("educationOther") String educationOther,
			@RequestParam("certifications") String certifications,
			@RequestParam("experience") String experience,
			@RequestParam("emailFirst") String emailFirst,
			@RequestParam("emailSecond") String emailSecond,
			@RequestParam("emailThird") String emailThird,
			@RequestParam("phoneFirst") String phoneFirst,
			@RequestParam("phoneSecond") String phoneSecond,
			@RequestParam("phoneThird") String phoneThird,
			@RequestParam("bestTimeContact") String bestTimeContact,
			@RequestParam("emailDateType") int emailDateType,
			@RequestParam("emailDate") String emailDate,
			@RequestParam("callDateType") int callDateType,
			@RequestParam("callDate") String callDate,
			@RequestParam("altPosition") String altPosition,
			@RequestParam("candidateComment") String candidateComment,
			@RequestParam("dvsComment") String dvsComment,
			@RequestParam("question1") String question1,
			@RequestParam("question2") String question2,
			@RequestParam("question3") String question3,
			@RequestParam("question4") String question4,
			@RequestParam("question5") String question5,
			@RequestParam("description1") String description1,
			@RequestParam("description2") String description2,
			@RequestParam("description3") String description3,
			@RequestParam("description4") String description4,
			@RequestParam("description5") String description5,
			@RequestParam("referedLocation") String referedLocation,
			@RequestParam("phoneScreenDate") String phoneScreenDate,
			@RequestParam("qQualification") String qQualification,
			@RequestParam("qBackground") String qBackground,
			@RequestParam("qTechnicalSkill") String qTechnicalSkill,
			@RequestParam("qExpectedSalary") String qExpectedSalary,
			@RequestParam("qCommunication") String qCommunication,
			@RequestParam("qInitiative") String qInitiative,
			@RequestParam("availableStartDate") String availableStartDate,
			@RequestParam("attachment") MultipartFile attachment,
			Map<String, Object> map) throws SQLException{
		
		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("cand_tracker_add")) {
			return View("redirect:/alert/access-denied", null);
		}
		
		MessageCore messageCore = new MessageCore(map);
		
		//messageCore.showConfirm();
		
		
		java.util.Date dtEmailDate = ConvertCore.StringToDate(emailDate, "MM/dd/yyyy");
		java.util.Date dtCallDate = ConvertCore.StringToDate(callDate, "MM/dd/yyyy");
		java.util.Date dtAvailableStartDate = ConvertCore.StringToDate(availableStartDate, "MM/dd/yyyy");
		java.util.Date dtphoneScreenDate = ConvertCore.StringToDate(phoneScreenDate, "MM/dd/yyyy");
		
		String createUser = getCurrentUser().getUser_name();
		Hrm_CandidateTrackerService candidateService = new Hrm_CandidateTrackerService();
		
		// File processing
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
				ILog.Debug("You successfully uploaded " + attachmentName + "!", this);
			} catch (Exception e) {
				ILog.Debug("You failed to upload " + attachmentName + " => " + e.getMessage(), this);
			}
		} else {
			ILog.Debug("You failed to upload " + attachmentName + " because the file was empty.", this);
		}
		
		boolean isCompleted = candidateService.addCandidateTracker(candidateTrackerIdInput, contractId, requisitionId, stateId, countryId, statusId, 
				clearanceLvId, positionId, educationId, educationOther, firstName, midName, lastName, city, statusOther, jobLocation, 
				referedLocation, salaryRange, experience, emailFirst, emailSecond, emailThird, phoneFirst, phoneSecond, phoneThird, 
				emailDateType, dtEmailDate, 
				callDateType, dtCallDate, dtphoneScreenDate, candidateComment, dvsComment, altPosition, bestTimeContact, 
				certifications, qQualification, qBackground, qTechnicalSkill, qExpectedSalary, qCommunication, qInitiative, 
				dtAvailableStartDate, question1, question2, question3, description1, description2, description3, createUser,
				question4, question5, description4, description5, attachmentName);
		
		if (isCompleted) {
			messageCore.lstMessage.add(MessageDict.SUCCESS);
			messageCore.showMessage();

		} else {
			messageCore.lstMessage.add(MessageDict.FAILED);
			messageCore.showError();
			// Reload with information is included in map
			return View("/hrm/candidate_tracker/candidate_add", map);
		}
		
		return View("redirect:/hrm/candidate_tracker/list", map);
	}
	
	@RequestMapping(value = { "/", "/edit/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable int id,
			Map<String, Object> map){
		
		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("cand_tracker_edit")) {
			return View("redirect:/alert/access-denied", null);
		}
		
		Hrm_ContractService contractService = new Hrm_ContractService();
		List<Hrm_Contract> listContract = contractService.getAll();
		map.put("ListContract", listContract);
		
		Hrm_RequisitionService reqService = new Hrm_RequisitionService();
		List<Hrm_Requisition> listRequisition = reqService.getAll();
		map.put("ListRequisition", listRequisition);
		
		Hrm_PositionService posService = new Hrm_PositionService();
		List<Hrm_Position> listPosition = posService.getAll();
		map.put("ListPosition", listPosition);
		
		Hrm_StateService stateService = new Hrm_StateService();
		List<Hrm_State> listState = stateService.getAll();
		map.put("ListState", listState);

		Hrm_CountryService countryService = new Hrm_CountryService();
		List<Hrm_Country> listCountry = countryService.getAll();
		map.put("ListCountry", listCountry);
		
		Hrm_EducationService eduService = new Hrm_EducationService();
		List<Hrm_Education> listEducation = eduService.getAll();
		map.put("ListEducation", listEducation);
		
		Hrm_StatusService statusService = new Hrm_StatusService();
		List<Hrm_Status> listStatus = statusService.getAll();
		map.put("ListStatus", listStatus);
		
		// Get Requisition model by ID
		Hrm_CandidateTrackerService candService = new Hrm_CandidateTrackerService();
		Hrm_Candidate_Tracker target = null;
		target = candService.getByCandidateTrackerId(id);
		map.put("target", target);
		
		return View("/hrm/candidate_tracker/candidate_tracker_edit", map);
	}
	
	@RequestMapping(value = { "/", "/edit" }, method = RequestMethod.POST)
	public String edit(@RequestParam("id") int id, 
			@RequestParam("candidateTrackerIdInput") String candidateTrackerIdInput,
			@RequestParam("contractId") int contractId,
			@RequestParam("requisitionId") int requisitionId,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("midName") String midName,
			@RequestParam("city") String city,
			@RequestParam("stateId") int stateId,
			@RequestParam("countryId") int countryId,
			@RequestParam("statusId") int statusId,
			@RequestParam("statusOther") String statusOther,
			@RequestParam("clearanceLvId") int clearanceLvId,
			@RequestParam("positionId") int positionId,
			@RequestParam("jobLocation") String jobLocation,
			@RequestParam("salaryRange") String salaryRange,
			@RequestParam("educationId") int educationId,
			@RequestParam("educationOther") String educationOther,
			@RequestParam("certifications") String certifications,
			@RequestParam("experience") String experience,
			@RequestParam("emailFirst") String emailFirst,
			@RequestParam("emailSecond") String emailSecond,
			@RequestParam("emailThird") String emailThird,
			@RequestParam("phoneFirst") String phoneFirst,
			@RequestParam("phoneSecond") String phoneSecond,
			@RequestParam("phoneThird") String phoneThird,
			@RequestParam("bestTimeContact") String bestTimeContact,
			@RequestParam("emailDateType") int emailDateType,
			@RequestParam("emailDate") String emailDate,
			@RequestParam("callDateType") int callDateType,
			@RequestParam("callDate") String callDate,
			@RequestParam("altPosition") String altPosition,
			@RequestParam("candidateComment") String candidateComment,
			@RequestParam("dvsComment") String dvsComment,
			@RequestParam("question1") String question1,
			@RequestParam("question2") String question2,
			@RequestParam("question3") String question3,
			@RequestParam("question4") String question4,
			@RequestParam("question5") String question5,
			@RequestParam("description1") String description1,
			@RequestParam("description2") String description2,
			@RequestParam("description3") String description3,
			@RequestParam("description4") String description4,
			@RequestParam("description5") String description5,
			@RequestParam("referedLocation") String referedLocation,
			@RequestParam("phoneScreenDate") String phoneScreenDate,
			@RequestParam("qQualification") String qQualification,
			@RequestParam("qBackground") String qBackground,
			@RequestParam("qTechnicalSkill") String qTechnicalSkill,
			@RequestParam("qExpectedSalary") String qExpectedSalary,
			@RequestParam("qCommunication") String qCommunication,
			@RequestParam("qInitiative") String qInitiative,
			@RequestParam("availableStartDate") String availableStartDate,
			@RequestParam("attachment") MultipartFile attachment,
			@RequestParam("oldfile") String oldfile,
			Map<String, Object> map) throws SQLException{
		
		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("cand_tracker_edit")) {
			return View("redirect:/alert/access-denied", null);
		}
		
		MessageCore messageCore = new MessageCore(map);
		
		java.util.Date dtEmailDate = ConvertCore.StringToDate(emailDate, "MM/dd/yyyy");
		java.util.Date dtCallDate = ConvertCore.StringToDate(callDate, "MM/dd/yyyy");
		java.util.Date dtAvailableStartDate = ConvertCore.StringToDate(availableStartDate, "MM/dd/yyyy");
		java.util.Date dtphoneScreenDate = ConvertCore.StringToDate(phoneScreenDate, "MM/dd/yyyy");
		
		String updateUser = getCurrentUser().getUser_name();
		Hrm_CandidateTrackerService candidateService = new Hrm_CandidateTrackerService();
		
		// File processing
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
								new FileOutputStream(new File(filePath + "/fileuploads/" + attachmentName)));
						stream.write(bytes);
						stream.close();
						ILog.Debug("You successfully uploaded " + attachmentName + "!", this);

						try {
							File oldFileDelete = new File(filePath + "/fileuploads/" + oldfile);
							oldFileDelete.delete();
						} catch (Exception e) {

						}
						newFile = attachmentName;
					} catch (Exception e) {
						ILog.Debug("You failed to upload " + attachmentName + " => " + e.getMessage(), this);
					}
				} else {
					ILog.Debug("You failed to upload " + attachmentName + " because the file was empty.", this);
				}
			}
		}

		boolean isCompleted = candidateService.updateCandidateTracker(id, candidateTrackerIdInput, contractId, requisitionId, stateId, countryId, statusId, 
				clearanceLvId, positionId, educationId, educationOther, firstName, midName, lastName, city, statusOther, jobLocation, 
				referedLocation, salaryRange, experience, emailFirst, emailSecond, emailThird, phoneFirst, phoneSecond, 
				phoneThird, emailDateType, dtEmailDate, callDateType, dtCallDate, dtphoneScreenDate, candidateComment, 
				dvsComment, altPosition, bestTimeContact, 
				certifications, qQualification, qBackground, qTechnicalSkill, qExpectedSalary, qCommunication, qInitiative, 
				dtAvailableStartDate, question1, question2, question3, question4, question5, description1, description2, 
				description3, description4, description5, newFile, updateUser);
		
		if (isCompleted) {
			messageCore.lstMessage.add(MessageDict.SUCCESS);
			messageCore.showMessage();

		} else {
			messageCore.lstMessage.add(MessageDict.FAILED);
			messageCore.showError();
			return "";
		}
		
		return View("redirect:/hrm/candidate_tracker/list", map);
	}
	
	@RequestMapping(value = { "/", "/delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable int id, 
			Map<String, Object> map) {

		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("cand_tracker_del")) {
			return View("redirect:/alert/access-denied", null);
		}

		MessageCore mess = new MessageCore(map);
		String deleteUser = getCurrentUser().getUser_name();
		Hrm_CandidateTrackerService candidateService = new Hrm_CandidateTrackerService();

		try {
			if (candidateService.delete(id, deleteUser)) {
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

		return View("redirect:/hrm/candidate_tracker/list", map);
	}
	
	@RequestMapping(value = { "/", "/search" }, method = RequestMethod.GET)
	public String search(
			Map<String, Object> map){
		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("cand_tracker_list")) {
			return View("redirect:/alert/access-denied", null);
		}
		
		Hrm_StatusService statusService = new Hrm_StatusService();
		List<Hrm_Status> listStatus = statusService.getAll();
		map.put("ListStatus", listStatus);
		
		
		return View("/hrm/candidate_tracker/candidate_tracker_list", map);
		
		
	}
	
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String list(@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "statusId", required = false) String statusId,
			@RequestParam(value = "position", required = false) String position,
			@RequestParam(value = "requisitionIdInput", required = false) String requisitionIdInput,
			Map<String, Object> map){
		
		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("cand_tracker_list")) {
			return View("redirect:/alert/access-denied", null);
		}
		
		if (keyword == null){
			keyword = "";
		}
		if (statusId == null){
			statusId = "-1";
		}
		if (position == null){
			position = "";
		}
		if (requisitionIdInput == null){
			requisitionIdInput = "";
		}
		
		int iStatusId = Integer.parseInt(statusId);
		
		map.put("keyword", keyword);
		map.put("statusId", statusId);
		map.put("position", position);
		map.put("requisitionIdInput", requisitionIdInput);
		
		Hrm_StatusService statusService = new Hrm_StatusService();
		List<Hrm_Status> listStatus = statusService.getAll();
		map.put("ListStatus", listStatus);
		
		Hrm_CandidateTrackerService candTrackerService = new Hrm_CandidateTrackerService();
		List<Hrm_Candidate_Tracker> listCandTracker = candTrackerService
				.search(keyword, iStatusId, position, requisitionIdInput);
		map.put("ListCandidateTracker", listCandTracker);
		
		return View("/hrm/candidate_tracker/candidate_tracker_list", map);
	}
	
	@RequestMapping(value = { "/", "/view/{id}" }, method = RequestMethod.GET)
	public String view(@PathVariable int id,
			Map<String, Object> map){
		
		if (getCurrentUser() == null) {
			return View("", map);
		}
		
		if (!getCurrentUser().has_permission("cand_tracker_view")) {
			return View("redirect:/alert/access-denied", null);
		}
		
		Hrm_ContractService contractService = new Hrm_ContractService();
		List<Hrm_Contract> listContract = contractService.getAll();
		map.put("ListContract", listContract);
		
		Hrm_RequisitionService reqService = new Hrm_RequisitionService();
		List<Hrm_Requisition> listRequisition = reqService.getAll();
		map.put("ListRequisition", listRequisition);
		
		Hrm_PositionService posService = new Hrm_PositionService();
		List<Hrm_Position> listPosition = posService.getAll();
		map.put("ListPosition", listPosition);
		
		Hrm_StateService stateService = new Hrm_StateService();
		List<Hrm_State> listState = stateService.getAll();
		map.put("ListState", listState);

		Hrm_CountryService countryService = new Hrm_CountryService();
		List<Hrm_Country> listCountry = countryService.getAll();
		map.put("ListCountry", listCountry);
		
		Hrm_EducationService eduService = new Hrm_EducationService();
		List<Hrm_Education> listEducation = eduService.getAll();
		map.put("ListEducation", listEducation);
		
		Hrm_StatusService statusService = new Hrm_StatusService();
		List<Hrm_Status> listStatus = statusService.getAll();
		map.put("ListStatus", listStatus);
		
		// Get Requisition by ID
		Hrm_CandidateTrackerService candService = new Hrm_CandidateTrackerService();
		Hrm_Candidate_Tracker target = candService.getByCandidateTrackerId(id);
		map.put("target", target);
		
		return View("/hrm/candidate_tracker/candidate_tracker_view", map);
	}
	
	@RequestMapping(value = { "/", "/download/{file_name}" }, method = RequestMethod.GET)
	public void download(@PathVariable("file_name") String fileName,
			HttpServletResponse response) throws IOException {

		String filePath = new File("").getAbsolutePath();

		String fileNameFull = filePath + "/fileuploads/" + fileName;
		
		File fileToDownload = new File(fileNameFull);
		
		InputStream inputStream = new FileInputStream(fileToDownload);
		response.setContentType("application/force-download");
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName.replaceAll(" ", "_"));
		IOUtils.copy(inputStream, response.getOutputStream());
		response.flushBuffer();
		inputStream.close();
	}
}
