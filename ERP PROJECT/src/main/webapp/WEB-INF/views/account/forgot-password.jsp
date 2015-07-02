<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<title>Login form</title>


<div class="container erp-form">
	<form id="forgot-form" method="post" action="/erp/account/forgot">
		<div class="form-inline">
			<h3>Forgot password</h3>
			<div class="row">
				<div class="col-sm-2">
					<label>Email:</label>
				</div>
				<div class="col-sm-8">
					<input name="email" type="email" class="form-control" required>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-2">
					<label></label>
				</div>
				<div class="col-sm-8">
					<button type="submit" class="btn btn-default">Forgot
						password</button>
				</div>
			</div>
		</div>
	</form>
</div>
<script>
	$("#forgot-form").validate();
</script>
