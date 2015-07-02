<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:formatDate value="${recruit.expired_date}" var="formattedDate"
	type="date" pattern="MM/dd/yyyy" />

<title>Edit Requisition</title>
<form id="add-form" class="form-horizontal" role="form"
	action="/erp/hrm/recruitment/add" method="post">
	<input type="hidden" name="id">
	<h3>Requisition Edit</h3>
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Requisition
			ID:</label>
		<div class="col-sm-4">
			<input required name="title" type="text" class="form-control"
				value="001">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Contract
			Name:</label>
		<div class="col-sm-4">
			<select class="form-control">
				<option>001</option>
				<option>002</option>
			</select>

		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Contract
			Number:</label>
		<div class="col-sm-4">
			<select class="form-control">
				<option>0123123</option>
				<option>0123123</option>
			</select>

		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Requester
			:</label>
		<div class="col-sm-4">
			<input required name="title" type="text" class="form-control"
				value="001">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Position
			Type:</label>
		<div class="col-sm-4">
			<input required name="title" type="text" class="form-control"
				value="">

		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Required
			Date:</label>
		<div class="col-sm-4">
			<input required name="expiredDate" class="form-control"
				id="from-datepicker" value="">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Status:</label>
		<div class="col-sm-4">
			<select class="form-control">
				<option>Open</option>
				<option>Closed</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Position
			Salary Range:</label>
		<div class="col-sm-4">
			<input required name="expiredDate" class="form-control"
				id="from-datepicker" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Clearance
			Level:</label>

		<div class="col-sm-4">
			<select class="form-control">
				<optgroup label="Pulbic trust">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">etc.</option>
				</optgroup>
				<option  value="4">Secret</option>
				<optgroup label="Top Secret">
					<option  value="5">CI</option>
					<option  value="6">CI with poly</option>
					<option  value="7">SCI</option>
					<option  value="8">SCI with poly</option>
					<option  value="9">etc.</option>
				</optgroup>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Certification
			Requirement :</label>
		<div class="col-sm-4">
			<input required name="expiredDate" class="form-control"
				id="from-datepicker" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Education
			| Degree:</label>
		<div class="col-sm-4">
			<select class="form-control">
				<option>BS</option>
				<option>MS</option>
				<option>BA</option>
				<option>MBA</option>
				<option>Others</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label"><br>Location:</label>
		<div class="col-sm-3">
			<label for="lastname" class="col-sm-12 control-label text-left">Street</label>
			<input required name="expiredDate" class="form-control"
				id="from-datepicker" value="">
		</div>
		<div class="col-sm-4">
			<label for="lastname" class="col-sm-12 control-label text-left">City</label>
			<input required name="expiredDate" class="form-control"
				id="from-datepicker" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label"></label>
		<div class="col-sm-3">
			<label for="lastname" class="col-sm-12 control-label text-left">State</label>
			<select class="form-control">
				<option>Texas</option>
			</select>
		</div>
		<div class="col-sm-2">
			<label for="lastname" class="col-sm-12 control-label text-left">Zip
				Code</label> <input required name="expiredDate" class="form-control"
				id="from-datepicker" value="">
		</div>
		<div class="col-sm-2">
			<label for="lastname" class="col-sm-12 control-label text-left">Country</label>
			<select class="form-control">
				<option>US</option>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Attachments:
		</label>
		<div class="col-sm-4">
			<input required name="expiredDate" type="file" class="form-control"
				id="from-datepicker" value="">
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-3 col-sm-1">
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