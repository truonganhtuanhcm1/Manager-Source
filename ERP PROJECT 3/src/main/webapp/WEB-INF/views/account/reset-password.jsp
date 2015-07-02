<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<title>Login form</title>


<div class="container erp-form" >
	<form id="reset" method="post" action="/erp/account/reset/${email}/${key}">
		<div class="form-inline">
			<h3>Reset password</h3>
			<div class="row">
				<div class="col-sm-4">
					<label>Email:</label>
				</div>
				<div class="col-sm-8">
					<input readonly="readonly" name="email" value="${email}"
						type="email" class="form-control" required> 
						<input hidden="true"
						readonly="readonly" name="key" value="${key}" type="text"
						class="form-control" required>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-4">
					<label>Password:</label>
				</div>
				<div class="col-sm-8">
					<input name="password" type="password" class="form-control"
						required>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-4">
					<label>Re-Password:</label>
				</div>
				<div class="col-sm-8">
					<input name="re-password" type="password" class="form-control"
						required>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-4">
					<label></label>
				</div>
				<div class="col-sm-8">
					<button type="submit" class="btn btn-default">Reset
						password</button>
				</div>
			</div>
		</div>
	</form>
</div>
<script>
	$("#reset-form").validate();
</script>
