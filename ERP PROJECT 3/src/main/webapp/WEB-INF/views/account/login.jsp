<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<title>Login</title>


<div class="container erp-form" >
	<form id="login-form" method="post" action="/erp/account/login">
		<div class="form-inline">
			<h3>Login</h3>
			<div class="row">
				<div class="col-sm-4">
					<label>Username:</label>
				</div>
				<div class="col-sm-8">
					<input name="username" class="form-control" required minlength="5">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<label>Password:</label>
				</div>
				<div class="col-sm-8">
					<input name="password" type="password" class="form-control" required minlength="5">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<label>Remember me</label> <input name="remember" type="checkbox">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<a href="/erp/account/forgot">Forgot password</a>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<a href="#register">Register</a>
				</div>
			</div>
			<div class="row">
			<div class="col-sm-4">
					
				</div>
				<div class="col-sm-8">
					<button style="" type="submit" class="btn btn-default">Login</button>
				</div>
			</div>
		</div>
	</form>
</div>
<script>
$("#login-form").validate();
</script>
