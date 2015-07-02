<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<title>List Candidate</title>
<form class="form-horizontal" role="form"  action="/erp/hrm/candidate_tracker/list">
	<h3>Candidate Search</h3>
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">Keywords:</label>
		<div class="col-sm-3">
			<input name="keyword" class="form-control" value="${keyword}">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">Status:</label>
		<div class="col-sm-3">
			<select class="form-control" name="statusId">
				<option value="-1">All status</option>
				<c:forEach items="${ListStatus}" var="Status">
					<option value="${Status.status_id}" ${Status.status_id == statusId ? 'selected' : ''}>
						<c:out value="${Status.status_name}"></c:out>
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">Position:</label>
		<div class="col-sm-3">
			<input name="position" class="form-control" value="${position}">
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">Requisition ID:</label>
		<div class="col-sm-3">
			<input name="requisitionIdInput" class="form-control" value="${requisitionIdInput}">
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
		<c:forEach items="${ListCandidateTracker}" var="CandidateTracker">
			<tr>
				<td>${CandidateTracker.candidate_tracker_id}</td>
				<td><c:out value="${CandidateTracker.requisition_id_input}"></c:out></td>
				<td><c:out value="${CandidateTracker.first_name} ${CandidateTracker.mid_name} ${CandidateTracker.last_name}"></c:out></td>
				<td><c:out value="${CandidateTracker.position_title}"></c:out></td>
				<td><c:out value="${CandidateTracker.phone_first}"></c:out></td>
				<td><c:out value="${CandidateTracker.status_name}"></c:out></td>
				<td width="100px"><nobr>
						<a class="pure-button pure-button-primary block ${permission_cand_tracker_edit == true ? 'block' : 'none'}"
							href="/erp/hrm/candidate_tracker/edit/${CandidateTracker.candidate_tracker_id}"> <i
							class="fa fa-pencil"></i>Edit
						</a>  
						<%-- <a class="pure-button pure-button-primary block ${permission_cand_tracker_del == true ? 'block' : 'none'}"
							onclick="return confirm('Are you sure you want to delete this recruitment?');"
							href="delete/${CandidateTracker.candidate_tracker_id}"> <i class="fa fa-times"></i>Delete
						</a> --%>
						<a class="pure-button pure-button-primary block ${permission_cand_tracker_view == true ? 'block' : 'none'}"
							href="view/${CandidateTracker.candidate_tracker_id}"> <i class="fa fa-times"></i>View
						</a>
	
					</nobr>
				</td>
			</tr>
		</c:forEach>
		
	</tbody>
</table>

<script>
	$(function() {
		$("#from-datepicker").datepicker();
		$("#to-datepicker").datepicker();
	});
	$("#add-form").validate();
</script>