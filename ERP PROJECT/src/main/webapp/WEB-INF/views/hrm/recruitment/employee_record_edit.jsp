<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:formatDate value="${recruit.expired_date}" var="formattedDate"
	type="date" pattern="MM/dd/yyyy" />

<title>Edit Employee Record</title>
<form id="add-form" class="form-horizontal" role="form"
	action="/erp/hrm/recruitment/add" method="post">
	<input type="hidden" name="id">
	<h3>Employee Record Edit</h3>
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Employee
			ID:</label>
		<div class="col-sm-3">
			<input required name="title" type="text" class="form-control"
				value="">
		</div>

	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label"><br>Employee
			Name:</label>
		<div class="col-sm-3">
			<label for="firstname" class="col-sm-12 control-label">First
				Name </label> <input required name="title" type="text" class="form-control"
				value="">
		</div>
		<div class="col-sm-2">
			<label for="firstname" class="col-sm-12 control-label">Last
				Name </label> <input required name="title" type="text" class="form-control"
				value="">
		</div>
		<div class="col-sm-2">
			<label for="firstname" class="col-sm-12 control-label">M.I</label> <input
				required name="title" type="text" class="form-control" value="">
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
				code</label> <input required name="expiredDate" class="form-control"
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
		<label for="firstname" class="col-sm-3 control-label">Position
			Type :</label>
		<div class="col-sm-7">
			<input required name="title" type="text" class="form-control"
				value="">
		</div>

	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Hired
			Date :</label>
		<div class="col-sm-3">
			<input required name="title" type="text" class="form-control"
				id="hired-date">
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Salary :</label>
		<div class="col-sm-3">
			<input required name="title" type="text" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label"></label>
		<div class="col-sm-9">
			<input required name="title" type="checkbox"> Full-time 
			<input required name="title" type="checkbox"> Part-time
			<input required name="title" type="checkbox"> SCA
			<input required name="title" type="checkbox"> Intern
			<input required name="title" type="checkbox"> Expempt
			<input required name="title" type="checkbox"> Non-Exempt
		</div>
		<div class="col-sm-1"></div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label"><br>Contact
			Information :</label>
		<div class="col-sm-3">
			<label for="firstname" class="col-sm-12 control-label">Email
				Address </label> <input required name="title" type="text"
				class="form-control" value="">
		</div>
		<div class="col-sm-2">
			<label for="firstname" class="col-sm-12 control-label">Mobile
			</label> <input required name="title" type="text" class="form-control"
				value="">
		</div>
		<div class="col-sm-2" style="padding-right: 0">
			<label for="firstname" class="col-sm-12 control-label">Home
				Number</label> <input required name="title" type="text" class="form-control"
				value="">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Clearance
			Level:</label>
		<div class="col-sm-3">
			<select class="form-control">
				<optgroup label="Pulbic trust">
					<option>1</option>
					<option>2</option>
					<option>etc.</option>
				</optgroup>
				<option>Secret</option>
				<optgroup label="Top Secret">
					<option>CI</option>
					<option>CI with poly</option>
					<option>SCI</option>
					<option>SCI with poly</option>
					<option>etc.</option>
				</optgroup>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Contract
			:</label>
		<div class="col-sm-3">
			<select class="form-control">
				<option>CT 001</option>
				<option>CT 002</option>
				<option>CT 003</option>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Department
			:</label>
		<div class="col-sm-3">
			<select class="form-control">
				<option>IT</option>
				<option>CEO</option>
				<option>SEO</option>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Program:</label>
		<div class="col-sm-6">
			<input required name="title" type="text" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Program
			Manager:</label>
		<div class="col-sm-6">
			<input required name="title" type="text" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">POC
			Phone Number :</label>
		<div class="col-sm-6">
			<input required name="title" type="text" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Evaluation
			Date:</label>
		<div class="col-sm-3">
			<input required name="title" id="evaluation-date" type="text"
				class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Tax
			Infomation:</label>
		<div class="col-sm-6">
			<input required name="title" id="evaluation-date" type="text"
				class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label"><br>Wage
			Garnishment:</label>
		<div class="col-sm-6">
			<div class="col-sm-7" style="padding-left:0">
			<label for="firstname" class="col-sm-12 control-label">Court Order Number</label>
				<input required name="title" id="evaluation-date" type="text"
					class="form-control">
			</div>
			<div class="col-sm-5" style="padding-right: 0">
			<label for="firstname" class="col-sm-12 control-label">County </label>
				<input required name="title" id="evaluation-date" type="text"
					class="form-control">
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label"><br></label>
		<div class="col-sm-6">
			<div class="col-sm-7" style="padding-left:0">
			<label for="firstname" class="col-sm-12 control-label">Court Address</label>
				<input required name="title" id="evaluation-date" type="text"
					class="form-control">
			</div>
			<div class="col-sm-5"  style="padding-right: 0">
			<label for="firstname" class="col-sm-12 control-label">Amount </label>
				<input required name="title" id="evaluation-date" type="text"
					class="form-control">
			</div>
		</div>
	</div>

	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Termination
			Date:</label>
		<div class="col-sm-3">
			<input required name="title" id="termination-date" type="text"
				class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label"> </label>
		<div class="col-sm-3">
			<input required name="title" type="checkbox"> Rehire <input
				required name="title" type="checkbox"> Not Rehired
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Reason
			for Termination:</label>
		<div class="col-sm-6">
			<select class="form-control">
			<option>Reason1</option>
			</select>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-3 col-sm-1">
			<a href='/erp/hrm/recruitment/candidate_tracker_list' type="submit"
				class="btn btn-danger">Create</a>
		</div>
	</div>
</form>

<script>
	$(function() {
		$("#hired-date").datepicker();
		$("#evaluation-date").datepicker();
		$("#termination-date").datepicker();

	});
	$("#add-form").validate();
</script>