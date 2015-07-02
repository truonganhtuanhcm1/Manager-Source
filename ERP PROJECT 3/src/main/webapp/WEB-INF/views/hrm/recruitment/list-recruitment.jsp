<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>List Recruitment</title>

<form class="form-horizontal" role="form">
	<h3>Recruitment Search</h3>
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">Position:</label>
		<div class="col-sm-3">
			<select name="posistion_id" class="form-control">
				<option value="-1">All positions</option>
				<c:forEach items="${ListGroup}" var="Group">
					<option value="${Group.client_id}" ${Group.client_id == posistion_id ? 'selected' : ''}>
						<c:out value="${Group.group_name}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">Type:</label>
		<div class="col-sm-3">
			<select name="type_id" class="form-control">
				<option value="-1">All types</option>
				<c:forEach items="${ListType}" var="Type">
					<option value="${Type.recruitment_type_id}"  ${Type.recruitment_type_id == type_id ? 'selected' : ''}>
						<c:out value="${Type.description}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">Status:</label>
		<div class="col-sm-3">
			<select name="status_id" class="form-control">
				<option value="-1">All status</option>
				<option value="1"  ${"1" == status_id ? 'selected' : ''}>Enable</option>
				<option value="0"  ${"0" == status_id ? 'selected' : ''}>Disable</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">From
			date:</label>
		<div class="col-sm-3">
			<input name="from_date" class="form-control" id="from-datepicker" value="${from_date}">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">To date:</label>
		<div class="col-sm-3">
			<input name="to_date"  class="form-control" id=to-datepicker  value="${to_date}">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">Search</button>
			<a href="/erp/hrm/recruitment/add" class="btn btn-default ${permission_recruitment_add == true ? 'block' : 'none'}">Create</a>
		</div>
	</div>
</form>

<table class="table table-bordered">
	<thead>
		<tr>
			<th>No.</th>
			<th>Position</th>
			<th>Type</th>
			<th>Expired date</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
<!-- data put from controller with name lstRecruit -->
		<c:forEach items="${lstRecruit}" var="Re">
			<tr>
				<td><c:out value="${Re.recruitment_id}" /></td>
				<td><c:out value="${Re.client_id_position_name}" /></td>
				<td><c:out value="${Re.recruitment_type_name}" /></td>
				<td><c:out value="${Re.expired_date}" /></td>
				<td><c:if test='${Re.enable == "true" }'>
				Enable
				</c:if> <c:if test='${Re.enable == "false" }'>
				Disable
				</c:if></td>
				<td width="100px"><nobr>
						<a class="pure-button pure-button-primary ${permission_recruitment_edit == true ? 'block' : 'none'}"
								href="edit/${Re.recruitment_id}"> <i class="fa fa-pencil"></i>Edit
							</a>
						<c:if test='${Re.enable == "false" }'>
							<a class="pure-button pure-button-primary ${permission_recruitment_edit == true ? 'block' : 'none'}"
								onclick="return confirm('Are you sure you want to enable this recruitment?');"
								href="enable/${Re.recruitment_id}"> <i class="fa fa-times"></i>Enable
							</a>
						</c:if>
						<c:if test='${Re.enable == "true" }'>
							<a class="pure-button pure-button-primary ${permission_recruitment_edit == true ? 'block' : 'none'}"
								onclick="return confirm('Are you sure you want to disable this recruitment?');"
								href="disable/${Re.recruitment_id}"> <i class="fa fa-times"></i>Disable
							</a>
						</c:if>
						<a class="pure-button pure-button-primary ${permission_recruitment_delete == true ? 'block' : 'none'}"
							onclick="return confirm('Are you sure you want to delete this recruitment?');"
							href="delete/${Re.recruitment_id}"> <i class="fa fa-times"></i>Delete
						</a>

					</nobr></td>
			</tr>
		</c:forEach>

	</tbody>
</table>

<script>
	$(function() {
		$("#from-datepicker").datepicker();
		$("#to-datepicker").datepicker();
	});
</script>