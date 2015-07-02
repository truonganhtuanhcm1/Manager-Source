<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<title>Viewing Contract</title>
<form id="add-form" class="form-horizontal" role="form" enctype="multipart/form-data"
	action="/erp/hrm/contract/view" method="post" >
	<h3>Viewing Contract</h3>
	
	<input type="hidden" name="contractId" value="${targetContract.contract_id}">
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Contract ID:</label>
		<div class="col-sm-4">
			<input disabled name="contractIdInput" class="form-control" value="${targetContract.contract_id_input}">
		</div>	
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Contract Number:</label>
		<div class="col-sm-4">
			<input disabled name="contractNumber" class="form-control" value="${targetContract.contract_number}">
		</div>	
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Contract Name:</label>
		<div class="col-sm-4">
			<input disabled name="contractName" class="form-control" value="${targetContract.contract_name}">
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Description:</label>
		<div class="col-sm-4">
			<input disabled name="description" class="form-control" value="${targetContract.description}">
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Modification:</label>
		<div class="col-sm-4">
			<input disabled name="modification" type="text" class="form-control" value="${targetContract.modification}">
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Value:</label>
		<div class="col-sm-4">
			<input disabled name="value" type="text" class="form-control" value="${targetContract.value}">
		</div>
	</div>

	<fmt:formatDate value="${targetContract.start_date}" var="formattedStartDate" type="date" pattern="MM/dd/yyyy" />
	<div class="form-group">
		<label class="col-sm-2 control-label">Start Date:</label>
		<div class="col-sm-4">
			
			<input disabled name="startDate" class="form-control" id="from-datepicker" value="${formattedStartDate}">
		</div>
	</div>
	
	<fmt:formatDate value="${targetContract.end_date}" var="formattedEndDate" type="date" pattern="MM/dd/yyyy" />
	<div class="form-group">
		<label class="col-sm-2 control-label">End Date:</label>
		<div class="col-sm-4">
			<input disabled name="endDate" class="form-control" id="to-datepicker" value="${formattedEndDate}">
		</div>
	</div>

	<!-- <div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-danger">Update</button>

		</div>
	</div> -->
</form>

<script>
	$(function() {
		$("#from-datepicker").datepicker();
		$("#to-datepicker").datepicker();
	});
	
	$("#add-form").validate();
</script>