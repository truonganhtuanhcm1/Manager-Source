<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<title>Candidate Tracker Edit</title>

<fmt:formatDate value="${target.email_date}" var="formattedEmailDate"
	type="date" pattern="MM/dd/yyyy" />
<fmt:formatDate value="${target.call_date}" var="formattedCallDate"
	type="date" pattern="MM/dd/yyyy" />
<fmt:formatDate value="${target.available_start_date}"
	var="formattedAvailableDate" type="date" pattern="MM/dd/yyyy" />
<fmt:formatDate value="${target.phone_screen_date}"
	var="formattedPhoneScreenDate" type="date" pattern="MM/dd/yyyy" />

<form id="add-form" class="form-horizontal" role="form" enctype="multipart/form-data"
	action="/erp/hrm/candidate_tracker/edit" method="post">
	<input type="hidden" name="id" value="${target.candidate_tracker_id}">
	<h3>Candidate Tracker Edit</h3>
	
	<div class="form-group">
		<label for="candidateTrackerIdInput" class="col-sm-3 control-label">Candidate ID :</label>
		<div class="col-sm-3">
			<input required name="candidateTrackerIdInput" class="form-control" type="text" value="${target.candidate_tracker_id_input}">
		</div>
	</div>
	
	<div class="form-group">
		<label for="contractIdInput" class="col-sm-3 control-label">Contract ID :</label>
		<div class="col-sm-3">
			<select required class="form-control contractId" name="contractId">
				<c:forEach items="${ListContract}" var="Contract">
					<option value="${Contract.contract_id}"
						${Contract.contract_id == target.contract_id ? 'selected' : ''}>
						<c:out value="${Contract.contract_id_input}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<div class="form-group">
		<label for="contractNumber" class="col-sm-3 control-label">Contract Number :</label>
		<div class="col-sm-3">
			<select disabled class="form-control contractNumber">
				<c:forEach items="${ListContract}" var="Contract">
					<option value="${Contract.contract_id}"
						${Contract.contract_id == target.contract_id ? 'selected' : ''}>
						<c:out value="${Contract.contract_number}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<div class="form-group">
		<label for="contractName" class="col-sm-3 control-label">Contract Name :</label>
		<div class="col-sm-3">
			<select disabled class="form-control contractName">
				<c:forEach items="${ListContract}" var="Contract">
					<option value="${Contract.contract_id}"
						${Contract.contract_id == target.contract_id ? 'selected' : ''}>
						<c:out value="${Contract.contract_name}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Requisition
			ID :</label>
		<div class="col-sm-3">
			<select required class="form-control requisitionId"
				name="requisitionId">
				<c:forEach items="${ListRequisition}" var="Requisition">
					<option value="${Requisition.requisition_id}"
						${Requisition.requisition_id == target.requisition_id ? 'selected' : ''}>
						<c:out value="${Requisition.requisition_id_input}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label"><br>Candidate	Name:</label>
		<div class="col-sm-2">
			<label for="firstname" class="col-sm-12 control-label">First
				Name </label> <input required name="firstName" type="text"
				class="form-control" value="${target.first_name}">
		</div>
		<div class="col-sm-2">
			<label for="firstname" class="col-sm-12 control-label">Last
				Name </label> <input required name="lastName" type="text"
				class="form-control" value="${target.last_name}">
		</div>
		<div class="col-sm-2">
			<label for="firstname" class="col-sm-12 control-label">M.I </label> <input
				name="midName" type="text" class="form-control"
				value="${target.mid_name}">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label"><br>Location:</label>
		<div class="col-sm-2">
			<label for="lastname" class="col-sm-12 control-label text-left">Street</label>
			<input required name="city" class="form-control" type="text"
				value="${target.city}">
		</div>

		<div class="col-sm-2">
			<label for="lastname" class="col-sm-12 control-label text-left">State</label>
			<select required class="form-control stateId" name="stateId">
				<c:forEach items="${ListState}" var="State">
					<option value="${State.state_id}"
						${State.state_id == target.state_id ? 'selected' : ''}>
						<c:out value="${State.state_name}" />
					</option>
				</c:forEach>
			</select>
		</div>

		<div class="col-sm-2">
			<label for="lastname" class="col-sm-12 control-label text-left">Country</label>
			<select required class="form-control" name="countryId">
				<c:forEach items="${ListCountry}" var="Country">
					<option value="${Country.country_id}"
						${Country.country_id == target.country_id ? 'selected' : ''}>
						<c:out value="${Country.country_name}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Status:</label>
		<div class="col-sm-3">
			<select name="statusId" id="statusId" class="form-control">
				<c:forEach items="${ListStatus}" var="Status">
					<option value="${Status.status_id}"
						${Status.status_id == target.status_id ? 'selected' : ''}>
						<c:out value="${Status.status_name}" />
					</option>
				</c:forEach>
			</select>
		</div>

		<div class="col-sm-3">
			<input id="statusOther" name="statusOther" type="text" class="form-control" value="${target.status_other}">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Clearance
			Level:</label>
		<div class="col-sm-3">
			<select class="form-control clearanceLvId" name="clearanceLvId">
				<optgroup label="Public Trust">
					<option value="1" ${target.clearance_lv_id == 1 ? 'selected' : ''}>Public
						Trust/1</option>
					<option value="2" ${target.clearance_lv_id == 2 ? 'selected' : ''}>Public
						Trust/2</option>
					<option value="3" ${target.clearance_lv_id == 3 ? 'selected' : ''}>Public
						Trust/3</option>
					<option value="4" ${target.clearance_lv_id == 4 ? 'selected' : ''}>Public
						Trust/4</option>
					<option value="5" ${target.clearance_lv_id == 5 ? 'selected' : ''}>Public
						Trust/5</option>
					<option value="6" ${target.clearance_lv_id == 6 ? 'selected' : ''}>Public
						Trust/6</option>
				</optgroup>
				<option id="clearanceLv_Secret" value="7"
					${target.clearance_lv_id == 7 ? 'selected' : ''}>Secret</option>
				<optgroup label="Top Secret">
					<option value="8" ${target.clearance_lv_id == 8 ? 'selected' : ''}>Top
						Secret/CI</option>
					<option value="9" ${target.clearance_lv_id == 9 ? 'selected' : ''}>Top
						Secret/CI with poly</option>
					<option value="10"
						${target.clearance_lv_id == 10 ? 'selected' : ''}>Top
						Secret/SCI</option>
					<option value="11"
						${target.clearance_lv_id == 11 ? 'selected' : ''}>Top
						Secret/SCI with poly</option>
				</optgroup>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Position
			Title:</label>
		<div class="col-sm-3">
			<select class="form-control" name="positionId">
				<c:forEach items="${ListPosition}" var="Position">
					<option value="${Position.position_id}"
						${Position.position_id == target.position_id ? 'selected' : ''}>
						<c:out value="${Position.position_title}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Job
			Location:</label>
		<div class="col-sm-6">
			<input name="jobLocation" class="form-control" type="text"
				value="${target.job_location}" />
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Candidate
			Salary Range:</label>
		<div class="col-sm-6">
			<input required name="salaryRange" type="text" class="form-control"
				value="${target.salary_range}">
			e.g ($25.000-$30.000)
		</div>
	</div>

	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Education
			| Degree:</label>
		<div class="col-sm-3">
			<select class="form-control" name="educationId" id="educationId">
				<c:forEach items="${ListEducation}" var="Education">
					<option value="${Education.education_id}"
						${Education.education_id == target.education_id ? 'selected' : ''}>
						<c:out value="${Education.education_name}" />
					</option>
				</c:forEach>
			</select>
		</div>
		<div class="col-sm-3">
			<input id="educationOther" name="educationOther" type="text" class="form-control" value="${target.education_other}">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Certifications:</label>
		<div class="col-sm-3">
			<input required name="certifications" type="text"
				class="form-control" value="${target.certification}">
		</div>
	</div>

	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Experience:</label>
		<div class="col-sm-6">
			<%-- <input required name="experience" type="text" class="form-control"
				value="${target.experience}"> --%>
			<textarea required name="experience" rows="2" class="form-control" 
				aria-required="true">${target.experience}</textarea>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Email
			Address:</label>
		<div class="col-sm-2">
			<select id="emailType" class="form-control">
				<option value="0" selected>Email 1</option>
				<option value="1">Email 2</option>
				<option value="2">Email 3</option>
			</select>
		</div>
		<div class="col-sm-3">
			<input id="emailFirst"  name="emailFirst"  type="text" class="form-control" value="${target.email_first}">
			<input id="emailSecond" name="emailSecond" type="text" class="form-control" value="${target.email_second}">
			<input id="emailThird"  name="emailThird"  type="text" class="form-control" value="${target.email_third}">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Phone Number:</label>
		<div class="col-sm-2">
			<select id="phoneType" class="form-control">
				<option value="0" selected>Home</option>
				<option value="1">Mobile</option>
				<option value="2">Business</option>
			</select>
		</div>
		<div class="col-sm-3">
			<input id="phoneFirst"  name="phoneFirst"  type="text" class="form-control" value="${target.phone_first}">
			<input id="phoneSecond" name="phoneSecond" type="text" class="form-control" value="${target.phone_second}">
			<input id="phoneThird"  name="phoneThird"  type="text" class="form-control" value="${target.phone_third}">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Best Time
			to Contact:</label>
		<div class="col-sm-5">
			<input required name="bestTimeContact" type="text"
				class="form-control" value="${target.best_time_contact}">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Email
			Date:</label>
		<div class="col-sm-2">
			<select name="emailDateType" class="form-control">
				<option value="1" ${1 == target.email_date_type ? 'selected' : ''}>First</option>
				<option value="2" ${2 == target.email_date_type ? 'selected' : ''}>Second</option>
			</select>
		</div>
		<div class="col-sm-3">
			<input required name="emailDate" class="form-control"
				id="email-datepicker" value="${formattedEmailDate}">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Call
			Date:</label>
		<div class="col-sm-2">
			<select name="callDateType" class="form-control">
				<option value="1" ${1 == target.call_date_type ? 'selected' : ''}>First</option>
				<option value="2" ${2 == target.call_date_type ? 'selected' : ''}>Second</option>
			</select>
		</div>
		<div class="col-sm-3">
			<input required name="callDate" class="form-control"
				id="call-datepicker" value="${formattedCallDate}">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Alternative Position :</label>
		<div class="col-sm-6">
			<input name="altPosition" class="form-control" type="text"
				value="${target.alt_position}">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Candidate
			Comments:</label>
		<div class="col-sm-6">
			<textarea required name="candidateComment" rows="4"
				class="form-control" aria-required="true">${target.candidate_comment}</textarea>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">DVS
			Comments:</label>
		<div class="col-sm-6">
			<textarea required name="dvsComment" rows="4" class="form-control"
				aria-required="true">${target.dvs_comment}</textarea>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Question
			1:</label>
		<div class="col-sm-6">
			<input name="question1" class="form-control" type="text"
				value="${target.question1}">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label"></label>
		<div class="col-sm-6">
			<textarea required name="description1" rows="3" class="form-control"
				aria-required="true">${target.description1}</textarea>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Question
			2:</label>
		<div class="col-sm-6">
			<input name="question2" class="form-control" type="text"
				value="${target.question2}">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label"></label>
		<div class="col-sm-6">
			<textarea required name="description2" rows="3" class="form-control"
				aria-required="true">${target.description2}</textarea>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Question
			3:</label>
		<div class="col-sm-6">
			<input name="question3" class="form-control" type="text"
				value="${target.question3}">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label"></label>
		<div class="col-sm-6">
			<textarea required name="description3" rows="3" class="form-control"
				aria-required="true">${target.description3}</textarea>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Question
			4:</label>
		<div class="col-sm-6">
			<input name="question4" class="form-control" type="text"
				value="${target.question4}">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label"></label>
		<div class="col-sm-6">
			<textarea required name="description4" rows="3" class="form-control"
				aria-required="true">${target.description4}</textarea>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Question
			5:</label>
		<div class="col-sm-6">
			<input name="question5" class="form-control" type="text"
				value="${target.question5}">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label"></label>
		<div class="col-sm-6">
			<textarea required name="description5" rows="3" class="form-control"
				aria-required="true">${target.description5}</textarea>
		</div>
	</div>

	<div style='display: none'>

		<!-- Not requirement fields follows: -->

		<div class="form-group">
			<label for="firstname" class="col-sm-3 control-label">Refered
				Location:</label>
			<div class="col-sm-6">
				<input name="referedLocation" class="form-control" type="text"
					value="${target.refered_location}" />
			</div>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-3 control-label">Phone
				Screen Date:</label>
			<div class="col-sm-3">
				<input name="phoneScreenDate" class="form-control"
					id="phone-datepicker" value="${formattedPhoneScreenDate}">
			</div>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-3 control-label"></label> <label
				for="lastname" class="col-sm-9 control-label"
				style="text-align: left;">Has the candidate have aquired
				similar skills or quanlifications through past work experiences?</label>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-3 control-label"></label>
			<div class="col-sm-6">
				<textarea name="qQualification" rows="4" class="form-control"
					aria-required="true">${target.q_qualification}</textarea>
			</div>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-3 control-label"></label> <label
				for="lastname" class="col-sm-9 control-label"
				style="text-align: left;">Does the candidate have the
				appropridate education background?</label>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-3 control-label"></label>
			<div class="col-sm-6">
				<textarea name="qBackground" rows="4" class="form-control"
					aria-required="true">${target.q_background}</textarea>
			</div>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-3 control-label"></label> <label
				for="lastname" class="col-sm-9 control-label"
				style="text-align: left;">Does the candidate have the
				technical skills necessary for this position?</label>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-3 control-label"></label>
			<div class="col-sm-6">
				<textarea name="qTechnicalSkill" rows="4" class="form-control"
					aria-required="true">${target.q_technical_skill}</textarea>
			</div>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-3 control-label"></label> <label
				for="lastname" class="col-sm-9 control-label"
				style="text-align: left;">Were the candidate's salary
				expectations within the range for the position?</label>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-3 control-label"></label>
			<div class="col-sm-6">
				<input name="qExpectedSalary" class="form-control" type="text"
					value="${target.	q_expected_salary}">
			</div>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-3 control-label"></label> <label
				for="lastname" class="col-sm-9 control-label"
				style="text-align: left;">Did the candidate demonstrate,
				through their answers, good teambuilding/interpersonal skills?</label>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-3 control-label"></label>
			<div class="col-sm-6">
				<textarea name="qCommunication" rows="4" class="form-control"
					aria-required="true">${target.q_communication}</textarea>
			</div>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-3 control-label"></label> <label
				for="lastname" class="col-sm-9 control-label"
				style="text-align: left;">Did the candidate demonstrate,
				through their answers, a high degree of initiative?</label>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-3 control-label"></label>
			<div class="col-sm-6">
				<textarea name="qInitiative" rows="4" class="form-control"
					aria-required="true">${target.q_initiative}</textarea>
			</div>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-3 control-label">Avaliable
				Start Date:</label>
			<div class="col-sm-3">
				<input name="availableStartDate" class="form-control"
					id="start-datepicker" type="text" value="${formattedAvailableDate}">
			</div>
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-3 control-label">Attachments: </label>
		
		<div class="col-sm-6">
			<input required disabled id="txtAttachment" class="form-control" value="${target.attachment}"/>
		</div>
		
		<div class="col-sm-1">
			<input id="fileAttachment" type="file" class="form-control attachment" name="attachment" />
			<input id="btnChangeAttachment" type="button" class="btn btn-primary" value="Change"/>
		</div>
		
		<div class="col-sm-1">
			<a href="/erp/file/view/${target.attachment}.file" target="_blank" class="btn btn-primary">View</a>
		</div>
		
		<div class="col-sm-1">
			<a href="/erp/hrm/candidate_tracker/download/${target.attachment}.file" class="btn btn-primary">Download</a>
			<input type="hidden" name="oldfile" value="${target.attachment}">
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-offset-3 col-sm-1">
			<button id="btnSubmit" type="submit" class="btn btn-danger">Update</button>
		</div>
	</div>
</form>

<script>
	$(function() {
		$("#email-datepicker").datepicker();
		$("#call-datepicker").datepicker();
		$("#phone-datepicker").datepicker();
		$("#best-datepicker").datepicker();
		$("#start-datepicker").datepicker();
		
		if($("#statusId").val() != "5"){
			$("#statusOther").hide();
		}
		
		if($("#educationId").val() != "9"){
			$("#educationOther").hide();
		}
		
		$("#emailSecond").hide();
		$("#emailThird").hide();
		
		$("#phoneSecond").hide();
		$("#phoneThird").hide();
	});
	$("#add-form").validate();
	$(".clearanceLvId").change(function() {
		var text = $(".clearanceLvId").val();
		if (text == 12) {
			$('.clearance_etc').show();
		} else {
			$('.clearance_etc').hide();
		}
	});
	
	$(".attachment").hide();
	
	$("#btnChangeAttachment").click(function(){
		$("#fileAttachment").click();
	});
	
	$("#fileAttachment").change(function(){
		$("#txtAttachment").val($(this).val());
	});
	
	$("#statusId").change(function(){
		var idx = $("#statusId").val();
		if(idx === "5"){
			$("#statusOther").show();
		}else{
			$("#statusOther").val(null);
			$("#statusOther").hide();
		}
	});
	
	$("#educationId").change(function(){
		var idx = $("#educationId").val();
		if(idx === "9"){
			$("#educationOther").show();
		}else{
			$("#educationOther").val(null);
			$("#educationOther").hide();
		}
	});
	
	$("#emailType").change(function(){
		var idx = $("#emailType").val();
		switch (idx){
			case "0": $("#emailFirst").show(); $("#emailSecond").hide(); $("#emailThird").hide(); break; 
			case "1": $("#emailFirst").hide(); $("#emailSecond").show(); $("#emailThird").hide(); break;
			case "2": $("#emailFirst").hide(); $("#emailSecond").hide(); $("#emailThird").show(); break;
			default: break;
		}
	});
	
	$("#phoneType").change(function(){
		var idx = $("#phoneType").val();
		switch (idx){
			case "0": $("#phoneFirst").show(); $("#phoneSecond").hide(); $("#phoneThird").hide(); break; 
			case "1": $("#phoneFirst").hide(); $("#phoneSecond").show(); $("#phoneThird").hide(); break;
			case "2": $("#phoneFirst").hide(); $("#phoneSecond").hide(); $("#phoneThird").show(); break;
			default: break;
		}
	});
	
	$(".contractId").change(function(){
		loadContractInfo();
	});
	
	function loadContractInfo(){
		var contractId = $(".contractId option:selected").val();
		$(".contractNumber").val(contractId);
		$(".contractName").val(contractId);
	}

</script>