<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:formatDate value="${targetRequisition.required_date}"
	var="formattedRequiredDate" type="date" pattern="MM/dd/yyyy" />
	
<title>Add Requisition</title>
<form id="add-form" class="form-horizontal" role="form" enctype="multipart/form-data"
	action="/erp/hrm/requisition/add" method="post"  onsubmit="return checkFile();">
	<input type="hidden" name="id" value="0">
	<h3>Requisition Add</h3>
	
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Requisition ID:</label>
		<div class="col-sm-4">
			<input required name="requisitionIdInput" type="text" class="form-control" value="${targetRequisition.requisition_id_input}">
		</div>
	</div>
	
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Contract ID:</label>
		<div class="col-sm-4">
			<select class="form-control contractId" name="contractId">
				<c:forEach items="${ListContract}" var="Contract">
					<option value="${Contract.contract_id}" ${Contract.contract_id == targetRequisition.contract_id ? 'selected' : ''}>
						<c:out value="${Contract.contract_id_input}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Contract Number:</label>
		<div class="col-sm-4">
			<select disabled class="form-control contractNumber">
				<c:forEach items="${ListContract}" var="Contract">
					<option value="${Contract.contract_id}" ${Contract.contract_id == targetRequisition.contract_id ? 'selected' : ''}>
						<c:out value="${Contract.contract_number}" />
					</option>
				</c:forEach>
			</select>

		</div>
	</div>
	
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Contract Name:</label>
		<div class="col-sm-4">
			<select disabled class="form-control contractName">
				<c:forEach items="${ListContract}" var="Contract">
					<option value="${Contract.contract_id}" ${Contract.contract_id == targetRequisition.contract_id ? 'selected' : ''}>
						<c:out value="${Contract.contract_name}" />
					</option>
				</c:forEach>
			</select>

		</div>
	</div>
	
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Requester :</label>
		<div class="col-sm-4">
			<input required name="requester" type="text" class="form-control" value="${targetRequisition.requester}">
		</div>
	</div>
	
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Position Title:</label>
		<div class="col-sm-4">
			<!-- <input required name="title" type="text" class="form-control" value=""> -->
			<select class="form-control" name="positionId">
				<c:forEach items="${ListPosition}" var="Position">
					<option value="${Position.position_id}" ${Position.position_id == targetRequisition.position_id ? 'selected' : ''}>
						<c:out value="${Position.position_title}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Required Date:</label>
		<div class="col-sm-4">
			<input required name="requiredDate" class="form-control" 
				id="from-datepicker" value="${formattedRequiredDate}">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Status:</label>
		<div class="col-sm-4">
			<select class="form-control" name="requisitionStatusId">
				<option value="0" ${0 == targetRequisition.status_id ? 'selected' : ''}>Closed</option>
				<option value="1" ${1 == targetRequisition.status_id ? 'selected' : ''}>Open</option>
				<option value="2" ${2 == targetRequisition.status_id ? 'selected' : ''}>Pending</option>
			</select>
		</div>
	</div>
	
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Position Salary Range:</label>
		<div class="col-sm-4">
			<input required name="salaryRange" class="form-control" type="text" value="${targetRequisition.salary_range}">
		</div>
	</div>
	
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Clearance Level:</label>
		<div class="col-sm-4">
			<select class="form-control clearanceLvId" name="clearanceLvId">
				<optgroup label="Public Trust">
					<option value="1" ${targetRequisition.clearance_lv_id ==1? 'selected' : ''}>Public Trust/1</option>
					<option value="2" ${targetRequisition.clearance_lv_id ==2? 'selected' : ''}>Public Trust/2</option>
					<option value="3" ${targetRequisition.clearance_lv_id ==3? 'selected' : ''}>Public Trust/3</option>
					<option value="4" ${targetRequisition.clearance_lv_id ==4? 'selected' : ''}>Public Trust/4</option>
					<option value="5" ${targetRequisition.clearance_lv_id ==5? 'selected' : ''}>Public Trust/5</option>
					<option value="6" ${targetRequisition.clearance_lv_id ==6? 'selected' : ''}>Public Trust/6</option>
				</optgroup>
				<option id="clearanceLv_Secret" value="7" ${targetRequisition.clearance_lv_id ==7? 'selected' : ''}>Secret</option>
				<optgroup label="Top Secret">
					<option  value="8" ${targetRequisition.clearance_lv_id ==8? 'selected' : ''}>Top Secret/CI</option>
					<option  value="9" ${targetRequisition.clearance_lv_id ==9? 'selected' : ''}>Top Secret/CI with poly</option>
					<option  value="10" ${targetRequisition.clearance_lv_id ==10? 'selected' : ''}>Top Secret/SCI</option>
					<option  value="11" ${targetRequisition.clearance_lv_id ==11? 'selected' : ''}>Top Secret/SCI with poly</option>
					<option  value="12" ${targetRequisition.clearance_lv_id ==12? 'selected' : ''}>Top Secret/CI with full Scope</option>
					<option  value="13" ${targetRequisition.clearance_lv_id ==13? 'selected' : ''}>Top Secret/CI with lifestyle</option>
				</optgroup>
			</select>
		</div>
	</div>
	
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Certification Requirement :</label>
		<div class="col-sm-4">
			<input required name="certificateReq" class="form-control"
				 value="${targetRequisition.certificate_req}">
		</div>
	</div>
	
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Education Degree:</label>
		<div class="col-sm-4">
			<select class="form-control educationId" name="educationId">
				<c:forEach items="${ListEducation}" var="Education">
					<option value="${Education.education_id}" 
						${Education.education_id == targetRequisition.education_id ? 'selected' : ''}>
						<c:out value="${Education.education_name}" />
					</option>
				</c:forEach>
			</select>
		</div>
		<div class="col-sm-3">
			<input required type="text" name="educationOther" class="form-control educationOther" 
				value="${targetRequisition.education_other}"/>
		</div>
	</div>
	
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label"><br>Location:</label>

		<div class="col-sm-3">
			<label for="lastname" class="col-sm-12 control-label text-left">City</label>
			<input required name="cityName" class="form-control" value="${targetRequisition.city_name}">
		</div>
		
		<div class="col-sm-3">
			<label for="lastname" class="col-sm-12 control-label text-left">State</label>
			<select class="form-control stateId" name="stateId">
				<c:forEach items="${ListState}" var="State">
					<option value="${State.state_id}" ${State.state_id == targetRequisition.state_id ? 'selected' : ''}>
						<c:out value="${State.state_name}" />
					</option>
				</c:forEach>
			</select>
		</div>
		
		<div class="col-sm-2">
			<label for="lastname" class="col-sm-12 control-label text-left">Country</label>
			<select class="form-control" name="countryId">
				<c:forEach items="${ListCountry}" var="Country">
					<option value="${Country.country_id}" 
						${Country.country_id == targetRequisition.country_id ? 'selected' : ''}>
						<c:out value="${Country.country_name}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Attachments: </label>
		<div class="col-sm-4">
			<input required id="attachment" name="attachment" type="file" class="form-control" value="${targetRequisition.attachment}">
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
		$("#from-datepicker").datepicker();
		$("#to-datepicker").datepicker();
		$(".educationOther").hide();
		if($(".educationOther").val() != null && $(".educationOther").val() != ''){
			$(".educationOther").show();
		}
	});
	
	$("#add-form").validate();
	
	function checkFile(){
	
		var attachment = $('#attachment').val();
		if(attachment!='' 
		&& attachment.indexOf('.doc')==-1
		 && attachment.indexOf('.pdf')==-1){
			alert('Only pdf, docs support!');
			return false;
		}
		return true;
	}
	
	/* $( ".clearanceLvId" ).change(function() {
		var text = $( ".clearanceLvId" ).val();
	  	if(text==12){
	  		$('.clearance_etc').show();
	  	}else{
	  		$('.clearance_etc').hide();
	  	}
	}); */
	
	// OnChange event on City dropdown
	$(".contractId").change(function() {
		var contractId = $(".contractId").val();
		$(".contractNumber").val(contractId);
		$(".contractName").val(contractId);
	}); 
	
	$("#clearanceLv_Secret").css("font-weight", "bold"); 
	
	function confirmSubmit(){
		var isOk = false;
		
		$('#bookDialog1').dialog({
			
			autoOpen : true,
			position : 'center',
			modal : true,
			resizable : false,
			width : 440,
			title:'Confirm',
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
	
	$("#btnSubmit").click(function(){
		confirmSubmit();
	});
	
	$("#bookDialog1").text("Do you want to create this requisition ?");
	
	$(".educationId").change(function(){
		if($(".educationId option:selected").text().trim() === "Others"){
			$(".educationOther").show();
		}
		else{
			$(".educationOther").hide();
			$(".educationOther").val(null);
		}
	});
	
	/* function requestZipCode(cityId){
		if (cityId == null)
			return;
		
		$.ajax({
			url: "/erp/hrm/requisition/city_change/" + cityId,
			type: "GET",
			success: function(responseText){
				
				if (responseText == 0){
					return;
				}
				
				var obj = JSON.parse(responseText);
				cities = obj.cities;
				
				for (var i = 0; i < obj.cities.length; i++){
					$(".zipCode").append($("<option>")
							.val(obj.cities[i].zipcode)
							.html(obj.cities[i].zipcode)
					 );
				}
			}
		});
	} */
	
	/* function requestCity(stateId){
		if (stateId == null)
			return;
		
		$.ajax({
			url: "/erp/hrm/requisition/state_change/" + stateId,
			type: "GET",
			success: function(responseText){
				if (responseText == 0){
					// Raise event onchange() for City select
					$(".cityId").trigger("change");
					return;
				}
				
				var obj = JSON.parse(responseText);
				cities = obj.cities;
				
				for (var i = 0; i < obj.cities.length; i++){
					$(".cityId").append($("<option>")
							.val(obj.cities[i].cityId)
							.html(obj.cities[i].cityName)
					 );
				}
				
				// Raise event onchange() for City select
				$(".cityId").trigger("change");
			}
		}); 
	} */
	
	/* // After successfully loaded State list
	$(".stateId").ready(function() {
		var stateId = $(".stateId").val();
		if(stateId == null)
			return;
		
		// Remove all options in city options 
		$(".cityId option").each(function(){
			$(this).remove();
		});
		
		// Request and load city list
		requestCity(stateId);
	}); */
	
	/*
	// After successfully loaded City list
	$(".cityId").ready(function() {
		var cityId = $(".cityId").val();
		if(cityId == null)
			return;
		
		// Remove all options in Zipcode dropdown 
		$(".zipCode option").each(function(){
			$(this).remove();
		});
		
		// Request and load zipcode list
		requestZipCode(cityId);
	}); 
	*/
	
	/* // OnChange event on City dropdown
	$(".cityId").change(function() {
		var cityId = $(".cityId").val();

		// Remove all options in Zipcode dropdown 
		$(".zipCode option").each(function(){
			$(this).remove();
		});
		
		// Request and load zipcode list by city id
		requestZipCode(cityId);
	});
	
	// OnChange event on State dropdown
	$(".stateId").change(function() {
		var stateId = $(".stateId").val();
		
		// Remove all options in City dropdown 
		$(".cityId option").each(function(){
			$(this).remove();
		});
		
		// Request and load city list by state id
		requestCity(stateId);
	}); */
	
</script>