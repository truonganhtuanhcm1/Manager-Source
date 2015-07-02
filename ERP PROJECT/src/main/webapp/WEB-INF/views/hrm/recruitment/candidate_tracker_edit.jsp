<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:formatDate value="${recruit.expired_date}" var="formattedDate"
	type="date" pattern="MM/dd/yyyy" />

<title>Edit Candidate Tracker</title>
<form id="add-form" class="form-horizontal" role="form"
	action="/erp/hrm/recruitment/add" method="post">
	<input type="hidden" name="id">
	<h3>Candidate Edit</h3>
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label"><br>Candidate
			Name:</label>
		<div class="col-sm-2">
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
			<label for="firstname" class="col-sm-12 control-label">M.I
				 </label> <input required name="title" type="text" class="form-control"
				value="">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Status:</label>
		<div class="col-sm-3">
			<select class="form-control">
				<option>Hired</option>
				<option>Interview</option>
				<option>Pending</option>
				<option>Opened</option>
				<option>Closed</option>
				<option>Sent to client</option>
				<option>Others</option>
			</select>
		</div>
		<div class="col-sm-3">
			<input required name="title" type="text" class="form-control"
				value="Others">
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Job Location
			:</label>
		<div class="col-sm-6">
			<input name="" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Refered Location
			:</label>
		<div class="col-sm-6">
			<input name="" class="form-control">
		</div>
	</div>
	
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Candidate
			Salary Range:</label>
		<div class="col-sm-6">
			<input required name="title" type="text" class="form-control"
				value="ABC Project">

		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Education | Degree
			:</label>
		<div class="col-sm-3">
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
		<label for="firstname" class="col-sm-3 control-label">Experience
			:</label>
		<div class="col-sm-6">
			<input required name="title" type="text" class="form-control"
				value="aaaa">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Email
			Address :</label>
		<div class="col-sm-3">
			<input required name="title" type="text" class="form-control"
				value="">

		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Phone
			Number :</label>
		<div class="col-sm-3">
			<input required name="expiredDate" class="form-control" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Email
			Date :</label>
		<div class="col-sm-3">
			<input required name="expiredDate" class="form-control"
				id="email-datepicker" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Call Date
			:</label>
		<div class="col-sm-3">
			<input required name="expiredDate" class="form-control"
				id="call-datepicker" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Phone
			Screen Date:</label>
		<div class="col-sm-3">
			<input required name="expiredDate" class="form-control"
				id="phone-datepicker" value="">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Comments
			from Candidate:</label>
		<div class="col-sm-6">
			<textarea required="" name="description" rows="4"
				class="form-control" aria-required="true"></textarea>
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">DVS
			Comments:</label>

		<div class="col-sm-6">
			<textarea required="" name="description" rows="4"
				class="form-control" aria-required="true"></textarea>
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Position
			:</label>
		<div class="col-sm-3">
			<input required name="expiredDate" class="form-control"
				id="from-datepicker" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Alternative
			Positions :</label>
		<div class="col-sm-3">
			<input required name="expiredDate" class="form-control"
				id="from-datepicker" value="">
		</div>
	</div>
		<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label"><br>Address:</label>
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
		<label for="lastname" class="col-sm-3 control-label">Best Time
			to Contract: </label>
		<div class="col-sm-3">
			<input required name="expiredDate" class="form-control"
				value="">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Clearance
			Level:</label>
		<div class="col-sm-3">
			<select class="form-control clearanceLvId" name="clearanceLvId">
				<optgroup label="Pulbic Trust">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
				</optgroup>
				<option value="7">Secret</option>
				<optgroup label="Top Secret">
					<option  value="8">CI</option>
					<option  value="9">CI with poly</option>
					<option  value="10">SCI</option>
					<option  value="11">SCI with poly</option>
				</optgroup>
				<option  value="12">etc.</option>
			</select>
		</div>
		<div class="clearance_etc"  style="display:none;">
			<label for="lastname" class="col-sm-1 control-label">
				Other:</label>
			<div class="col-sm-3">
				<input required name="clearance_etc" class="form-control " type="text"
					value="${clearance_etc}">
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Certifications:
		</label>
		<div class="col-sm-3">
			<input required name="expiredDate" class="form-control"
				id="from-datepicker" value="">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Requisition
			ID :</label>
		<div class="col-sm-3">
			<select class="form-control valid" aria-invalid="false">
				<option>001</option>
				<option>002</option>
				<option>003</option>
			</select>
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
			<textarea required="" name="description" rows="4"
				class="form-control" aria-required="true"></textarea>
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
			<textarea required="" name="description" rows="4"
				class="form-control" aria-required="true"></textarea>
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
			<textarea required="" name="description" rows="4"
				class="form-control" aria-required="true"></textarea>
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
			<input required name="expiredDate" class="form-control"
				id="from-datepicker" value="">
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
			<textarea required="" name="description" rows="4"
				class="form-control" aria-required="true"></textarea>
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
			<textarea required="" name="description" rows="4"
				class="form-control" aria-required="true"></textarea>
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Avaliable Start Date:</label>
		<div class="col-sm-3">
			<input required name="expiredDate" class="form-control"
				id="start-datepicker" value="">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-3 col-sm-1">
			<a href='/erp/hrm/recruitment/candidate_tracker_list' type="submit" class="btn btn-danger">Create</a>
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
	});
	$("#add-form").validate();
	
	$( ".clearanceLvId" ).change(function() {
		var text = $( ".clearanceLvId" ).val();
	  	if(text==12){
	  		$('.clearance_etc').show();
	  	}else{
	  		$('.clearance_etc').hide();
	  	}
	});
</script>