<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<title>Profile</title>
<div class="container" style="width: 100%; margin: 0 auto;display: none">
	<div class="form-inline">
		<h3>Profile</h3>
		<div class="row">
			<div class="col-sm-4">
				<label>Username:</label>
			</div>
			<div class="col-sm-8">${user.user_name }</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<label>Password:</label>
			</div>
			<div class="col-sm-8">${user.password }</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<label>Password Hint:</label>
			</div>
			<div class="col-sm-8">${user.password_hint }</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<label>Client ID :</label>
			</div>
			<div class="col-sm-8">${user.client_id }</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<label>Status ID :</label>
			</div>
			<div class="col-sm-8">${user.status_id }</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<label>Create time :</label>
			</div>
			<div class="col-sm-8">${user.create_time }</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<label>Update time :</label>
			</div>
			<div class="col-sm-8">${user.update_time }</div>
		</div>

	</div>