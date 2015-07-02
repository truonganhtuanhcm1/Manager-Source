<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<title>Candidate Tracker Add</title>
<form id="add-form" class="form-horizontal" role="form" enctype="multipart/form-data"
	action="/erp/hrm/candidate_tracker/add" method="post">
	<input type="hidden" name="id" value="0">
	<h3>Candidate Tracker Add</h3>
	
	<div class="form-group">
		<label for="candidateTrackerIdInput" class="col-sm-3 control-label">Candidate ID :</label>
		<div class="col-sm-3">
			<input required name="candidateTrackerIdInput" class="form-control" type="text" value="">
		</div>
	</div>
	
	<div class="form-group">
		<label for="contractIdInput" class="col-sm-3 control-label">Contract ID :</label>
		<div class="col-sm-3">
			<select required class="form-control contractId" name="contractId">
				<c:forEach items="${ListContract}" var="Contract">
					<option value="${Contract.contract_id}">
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
					<option value="${Contract.contract_id}">
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
					<option value="${Contract.contract_id}">
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
					<option value="${Requisition.requisition_id}">
						<c:out value="${Requisition.requisition_id_input}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label"><br>Candidate
			Name:</label>
		<div class="col-sm-2">
			<label for="firstname" class="col-sm-12 control-label">First
				Name </label> <input required name="firstName" type="text"
				class="form-control" value="">
		</div>
		<div class="col-sm-2">
			<label for="firstname" class="col-sm-12 control-label">Last
				Name </label> <input required name="lastName" type="text"
				class="form-control" value="">
		</div>
		<div class="col-sm-2">
			<label for="firstname" class="col-sm-12 control-label">M.I </label> <input
				name="midName" type="text" class="form-control" value="">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label"><br>Location:</label>
		<div class="col-sm-2">
			<label for="lastname" class="col-sm-12 control-label text-left">Street</label>
			<input required name="city" class="form-control" type="text" value="">
		</div>

		<div class="col-sm-2">
			<label for="lastname" class="col-sm-12 control-label text-left">State</label>
			<select required class="form-control stateId" name="stateId">
				<c:forEach items="${ListState}" var="State">
					<option value="${State.state_id}">
						<c:out value="${State.state_name}" />
					</option>
				</c:forEach>
			</select>
		</div>

		<div class="col-sm-2">
			<label for="lastname" class="col-sm-12 control-label text-left">Country</label>
			<select required class="form-control" name="countryId">
				<c:forEach items="${ListCountry}" var="Country">
					<option value="${Country.country_id}">
						<c:out value="${Country.country_name}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Status:</label>
		<div class="col-sm-3">
			<select name="statusId" id="statusId" class="form-control" >
				<c:forEach items="${ListStatus}" var="Status">
					<option value="${Status.status_id}">
						<c:out value="${Status.status_name}" />
					</option>
				</c:forEach>
			</select>
		</div>

		<div class="col-sm-3">
			<input name="statusOther" id="statusOther" type="text" class="form-control" value="">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Clearance
			Level:</label>
		<div class="col-sm-3">
			<select class="form-control clearanceLvId" name="clearanceLvId">
				<optgroup label="publicbic Trust">
					<option value="1">public Trust/1</option>
					<option value="2">public Trust/2</option>
					<option value="3">public Trust/3</option>
					<option value="4">public Trust/4</option>
					<option value="5">public Trust/5</option>
					<option value="6">public Trust/6</option>
				</optgroup>
				<option id="clearanceLv_Secret" value="7">Secret</option>
				<optgroup label="Top Secret">
					<option value="8">Top Secret/CI</option>
					<option value="9">Top Secret/CI with poly</option>
					<option value="10">Top Secret/SCI</option>
					<option value="11">Top Secret/SCI with poly</option>
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
					<option value="${Position.position_id}">
						<c:out value="${Position.position_title}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Job Location:</label>
		<div class="col-sm-6">
			<input name="jobLocation" class="form-control" type="text" value="job location"/>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Candidate Salary Range:</label>
		<div class="col-sm-6">
			<input required name="salaryRange" type="text" class="form-control" value="$25.000-$30.000">
			e.g ($25.000-$30.000)
		</div>
	</div>

	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Education Degree:</label>
		<div class="col-sm-3">
			<select class="form-control" name="educationId"  id="educationId">
				<c:forEach items="${ListEducation}" var="Education">
					<option value="${Education.education_id}">
						<c:out value="${Education.education_name}" />
					</option>
				</c:forEach>
			</select>
		</div>
		<div class="col-sm-3">
			<input id="educationOther" name="educationOther" type="text" class="form-control" value="">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Certifications:</label>
		<div class="col-sm-3">
			<input required name="certifications" type="text" class="form-control" value="certification">
		</div>
	</div>

	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Experience:</label>
		<div class="col-sm-6">
			<!-- <input required name="experience" type="text" class="form-control" value=""> -->
			<textarea required name="experience" rows="2" class="form-control" 
				aria-required="true"></textarea>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Email Address:</label>
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
				<option value="0" selected>Mobile</option>
				<option value="1">Home</option>
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
				class="form-control" value="">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Email
			Date:</label>
		<div class="col-sm-2">
			<select name="emailDateType" class="form-control">
				<option value="1">First</option>
				<option value="2">Second</option>
			</select>
		</div>
		<div class="col-sm-3">
			<input required name="emailDate" class="form-control"
				id="email-datepicker" value="">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Call Date:</label>
		<div class="col-sm-2">
			<select name="callDateType" class="form-control">
				<option value="1">First</option>
				<option value="2">Second</option>
			</select>
		</div>
		<div class="col-sm-3">
			<input required name="callDate" class="form-control"
				id="call-datepicker" value="">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Alternative Position :</label>
		<div class="col-sm-6">
			<input name="altPosition" class="form-control" type="text" value="alt position">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Candidate Comments:</label>
		<div class="col-sm-6">
			<textarea required name="candidateComment" rows="4"
				class="form-control" aria-required="true">candidate comment</textarea>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">DVS Comments:</label>
		<div class="col-sm-6">
			<textarea required name="dvsComment" rows="4" class="form-control"
				aria-required="true">dvs comment</textarea>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Question
			1:</label>
		<div class="col-sm-6">
			<input name="question1" class="form-control" type="text"
				value="Question 1">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label"></label>
		<div class="col-sm-6">
			<textarea required name="description1" rows="3" class="form-control"
				aria-required="true">Description 1</textarea>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Question
			2:</label>
		<div class="col-sm-6">
			<input name="question2" class="form-control" type="text"
				value="Question 2">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label"></label>
		<div class="col-sm-6">
			<textarea required name="description2" rows="3" class="form-control"
				aria-required="true">Description 2</textarea>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Question
			3:</label>
		<div class="col-sm-6">
			<input name="question3" class="form-control" type="text"
				value="Question 3">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label"></label>
		<div class="col-sm-6">
			<textarea required name="description3" rows="3" class="form-control"
				aria-required="true">Description 3</textarea>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Question
			4:</label>
		<div class="col-sm-6">
			<input name="question4" class="form-control" type="text"
				value="Question 4">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label"></label>
		<div class="col-sm-6">
			<textarea required name="description4" rows="3" class="form-control"
				aria-required="true">Description 4</textarea>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Question
			5:</label>
		<div class="col-sm-6">
			<input name="question5" class="form-control" type="text"
				value="Question 5">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label"></label>
		<div class="col-sm-6">
			<textarea required name="description5" rows="3" class="form-control"
				aria-required="true">Description 5</textarea>
		</div>
	</div>

	<!-- Not requirement fields follows: -->
	<div style='display: none'>
		<div class="form-group">
			<label for="firstname" class="col-sm-3 control-label">Refered
				Location:</label>
			<div class="col-sm-6">
				<input name="referedLocation" class="form-control" type="text" />
			</div>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-3 control-label">Phone
				Screen Date:</label>
			<div class="col-sm-3">
				<input name="phoneScreenDate" class="form-control"
					id="phone-datepicker" value="">
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
					aria-required="true"></textarea>
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
					aria-required="true"></textarea>
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
					aria-required="true"></textarea>
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
					value="">
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
					aria-required="true"></textarea>
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
					aria-required="true"></textarea>
			</div>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-3 control-label">Avaliable
				Start Date:</label>
			<div class="col-sm-3">
				<input name="availableStartDate" class="form-control"
					id="start-datepicker" type="text" value="">
			</div>
		</div>
	</div>
	
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Attachment: </label>
		<div class="col-sm-4">
			<input required id="attachment" name="attachment" type="file" class="form-control" value="">
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-offset-3 col-sm-1">
			<button id="btnSubmit" type="button" class="btn btn-danger">Create</button>
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
		
		$("#statusOther").hide();
		$("#educationOther").hide();
		
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
	
	function confirmSubmit(){
		var isOk = false;
		
		$('#bookDialog1').dialog({
			
			autoOpen : true,
			position : 'center',
			modal : true,
			resizable : false,
			width : 440,
			title:'Alert',
			buttons : {
				"Yes": function(){
					$(this).dialog('close');
					$("#add-form").submit();
				},
				
				"No": function() {
					$(this).dialog('close');
				}
			},
			close : function(event, ui) {
				$(this).dialog('close');
			}
		});
	}
	
	$("#bookDialog1").text("Do you want to create this candidate tracker ?");
	
	$("#btnSubmit").click(function(){
		confirmSubmit();
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