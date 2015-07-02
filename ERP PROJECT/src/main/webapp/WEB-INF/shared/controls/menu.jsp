<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand logo" href="#"> <img
				src='<c:url value="/web-resources/css/erp-images/DVS_logo_final.png"/>' />
			</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/erp/user/user/profile"><i class="glyphicon glyphicon-home"></i>&nbsp;Home</a></li>
				<li><a href="#about"><i class="glyphicon glyphicon-folder-open"></i>&nbsp;Recuitment</a></li>
				<li><a href="#contact">Employee</a></li>
				<li><a href="#contact">Report</a></li>
			</ul>
			<c:if test="${loginedUser == null}">
				<ul class="nav navbar-nav" style="float: right;">
					<li><a href="/erp/account/login">Login</a></li>
					<li><a href="#about">Register</a></li>
				</ul>
			</c:if>
			<c:if test="${loginedUser != null}">
				<ul class="nav navbar-nav" style="float: right;">
					<li><a href="#">Hello <b>${loginedUser.user_name }</b></a></li>
					<li><a href="/erp/account/logout">Logout</a></li>
				</ul>
			</c:if>

		</div>

		<!--/.nav-collapse -->
	</div>
</nav>