<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:formatDate value="${recruit.expired_date}" var="formattedDate"
	type="date" pattern="MM/dd/yyyy" />

<title>Edit Recruitment</title>
<form id="add-form" class="form-horizontal" role="form"
	action="/erp/hrm/recruitment/add" method="post">
	<input type="hidden" name="id" value="${recruit.recruitment_id }">
	<h3>Recruitment Edit</h3>
	<div class="form-group">
		<label for="firstname" class="col-sm-2 control-label">Position:</label>
		<div class="col-sm-3">
			<select required name="PositionID" class="form-control">
				<option></option>
				<c:forEach items="${ListGroup}" var="Group">
					<option value="${Group.client_id}" ${Group.client_id == recruit.client_id_position ? 'selected' : ''}>
						<c:out value="${Group.group_name}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">Type:</label>
		<div class="col-sm-3">
			<select name="TypeID" required class="form-control">
				<option></option>
				<c:forEach items="${ListType}" var="Type">
					<option value="${Type.recruitment_type_id}"
						${Type.recruitment_type_id == recruit.recruitment_type_id ? 'selected' : ''}>
						<c:out value="${Type.description}" />
					</option>
				</c:forEach>
			</select>

		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">Title:</label>
		<div class="col-sm-3">
			<input required name="title" type="text" class="form-control"
				value="${recruit.title }">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">Expired
			date:</label>
		<div class="col-sm-3">
			<input required name="expiredDate" class="form-control"
				id="from-datepicker" value="${formattedDate}">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">Enable:</label>
		<div class="col-sm-3">
			<input name="Status" type="checkbox" style="margin-top: 10px"
				<c:if test="${recruit.enable == 'true'}">checked="checked"</c:if> />
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">Job
			description:</label>
		<div class="col-sm-7">
			<c:out value="${Type.description}" />
			<textarea required name="description" rows="4" class="form-control">${recruit.job_description }</textarea>
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">Job
			requirement:</label>
		<div class="col-sm-7">
			<textarea required name="requirement" rows="4" class="form-control">${recruit.job_recruitment }</textarea>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-1">
			<button type="submit" class="btn btn-danger">Update</button>
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