<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:formatDate value="${recruit.expired_date}" var="formattedDate"
	type="date" pattern="MM/dd/yyyy" />

<title>List Candidate</title>
<form class="form-horizontal" role="form" action="/erp/hrm/candidate_tracker/list">
	<h3>Candidate Search</h3>
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">Keywords
			:</label>
		<div class="col-sm-3">
			<input name="" class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">Status:</label>
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
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">Position
			:</label>
		<div class="col-sm-3">
			<input name="" class="form-control">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">Requisition
			ID:</label>
		<div class="col-sm-3">
			<input name="from_date" class="form-control">
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">Search</button>
			
		</div>
	</div>
</form>

<table class="table table-bordered">
	<thead>
		<tr>
			<th>No.</th>
			<th>Requisition ID</th>
			<th>Candidate Name</th>
			<th>Position</th>
			<th>Phone Number</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>1</td>
			<td>001</td>
			<td>ABC Project</td>
			<td>ABC Title</td>

			<td>12312413413</td>
			<td>Hired</td>
			<td width="100px"><nobr>
					<a class="pure-button pure-button-primary block"
						href="/erp/hrm/recruitment/candidate_tracker_edit"> <i
						class="fa fa-pencil"></i>Edit
					</a>  <a class="pure-button pure-button-primary block"
						onclick="return confirm('Are you sure you want to delete this recruitment?');"
						href="delete/1"> <i class="fa fa-times"></i>View
					</a>

				</nobr></td>
		</tr>
		<tr>
			<td>2</td>
			<td>002</td>
			<td>ABC Project</td>
			<td>ABC Title</td>
			<td>23135123</td>
			<td>Not Hired</td>
			<td width="100px"><nobr>
					<a class="pure-button pure-button-primary block"
						href="/erp/hrm/recruitment/candidate_tracker_edit"> <i
						class="fa fa-pencil"></i>Edit
					</a> <a class="pure-button pure-button-primary block"
						onclick="return confirm('Are you sure you want to delete this recruitment?');"
						href="delete/1"> <i class="fa fa-times"></i>View
					</a>

				</nobr></td>
		</tr>
	</tbody>
</table>

<script>
	$(function() {
		$("#from-datepicker").datepicker();
		$("#to-datepicker").datepicker();
	});
	$("#add-form").validate();
</script>