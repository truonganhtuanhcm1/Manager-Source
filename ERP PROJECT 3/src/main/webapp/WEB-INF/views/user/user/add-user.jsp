<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Edit user</h3>

<form id="form" class="form-horizontal" role="form" method="post"
	action="/erp/user/user/add">
	<h3>Account information</h3>
	<div class="form-group">
		<label class="col-sm-2 control-label">Username:</label>
		<div class="col-sm-3">
			<input required name="user_name" class="form-control"
				value="${user_name }" minlength="5">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Password:</label>
		<div class="col-sm-3">
			<input required name="password" type="password" class="form-control" value="" minlength="5">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Re-Password:</label>
		<div class="col-sm-3">
			<input required name="repassword" type="password" class="form-control" value="" minlength="5">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Email:</label>
		<div class="col-sm-3">
			<input required name="email" type="email" class="form-control"
				value="${email }" minlength="5">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Group:</label>
		<div class="col-sm-3">
			<select required name="group_id" class="form-control">
				<option value="">Choose</option>
				<c:forEach items="${listGroup}" var="Group">
					<option value="${Group.group_id}"
						${Group.group_id == group_id ? 'selected' : ''}>
						<c:out value="${Group.group_name}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Client Type:</label>
		<div class="col-sm-3">
			<select required name="client_type_id" class="form-control">
				<option value="">Choose</option>
				<c:forEach items="${lstClientType}" var="Type">
					<option value="${Type.client_type_id}"
						${Type.client_type_id == client_type_id ? 'selected' : ''}>
						<c:out value="${Type.client_type_id}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">Status</label>
		<div class="col-sm-3">
			<select required name="status_id" class="form-control">
				<option value="">Choose</option>
				<c:forEach items="${lstStatus}" var="Status">
					<option value="${Status.status_id}"
						${Status.status_id == status_id ? 'selected' : ''}>
						<c:out value="${Status.description}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<br>
	<h3>Personal information</h3>
	<div class="form-group">
		<label class="col-sm-2 control-label">First name:</label>
		<div class="col-sm-3">
			<input required name="first_name" class="form-control"
				value="${first_name }">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Last name:</label>
		<div class="col-sm-3">
			<input required name="last_name" class="form-control"
				value="${last_name }">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Birth date:</label>
		<div class="col-sm-3">
			<input required id="birth-date" name="birth_date"
				class="form-control" value="${birth_date_string }">
		</div>
	</div>
	<br>
	<h3>Contact information</h3>
	<div class="form-group">
		<label class="col-sm-2 control-label">Phone:</label>
		<div class="col-sm-3">
			<input required name="phone" class="form-control" value="${phone }">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Address:</label>
		<div class="col-sm-3">
			<input required name="address" class="form-control"
				value="${address }">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-12">
			<button type="submit" class="btn btn-default">Save</button>
			<a type="button" class="btn btn-default" href="/erp/user/user/list">Manage
				users</a>
		</div>
	</div>
</form>


<script>
	$(function() {
		$("#birth-date").datepicker();
	});
	$("#form").validate();
</script>


