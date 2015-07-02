<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<title>Create Contract</title>
<form id="add-form" class="form-horizontal" role="form" enctype="multipart/form-data"
	action="/erp/hrm/contract/add" method="post" >
	<h3>Create Contract</h3>
	
	<input type="hidden" name="contractId" value="">
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Contract ID:</label>
		<div class="col-sm-4">
			<input required name="contractIdInput" class="form-control" value="">
		</div>	
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Contract Number:</label>
		<div class="col-sm-4">
			<input required name="contractNumber" class="form-control" value="">
		</div>	
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Contract Name:</label>
		<div class="col-sm-4">
			<input required name="contractName" class="form-control" value="">
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Description:</label>
		<div class="col-sm-4">
			<input name="description" class="form-control" value="">
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Modification:</label>
		<div class="col-sm-4">
			<input  name="modification" type="text" class="form-control" value="">
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Value:</label>
		<div class="col-sm-4">
			<input  name="value" type="text" class="form-control" value="">
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Start Date:</label>
		<div class="col-sm-4">
			<input required name="startDate" class="form-control" id="from-datepicker" value="">
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">End Date:</label>
		<div class="col-sm-4">
			<input required name="endDate" class="form-control" id="to-datepicker" value="">
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-danger">Create</button>

		</div>
	</div>
</form>

<script>
	$(function() {
		$("#from-datepicker").datepicker();
		$("#to-datepicker").datepicker();
	});
	
	$("#add-form").validate();
</script>