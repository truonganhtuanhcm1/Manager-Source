<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title><decorator:title default="Home" /></title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script type="text/javascript"
	src='<c:url value="/web-resources/js/lib/jquery-1.10.2.js"/>'></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href='<c:url value="/web-resources/css/pure-0.4.2.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/web-resources/css/font-awesome-4.0.3/css/font-awesome.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/web-resources/css/jquery-ui-1.10.4.custom.css"/>'>

<link rel="stylesheet"
	href='<c:url value="/web-resources/css/erp.css"/>'>

<!--  It is advised to put the <script> tags at the end of the document body so they don't block rendering of the page -->

<script type="text/javascript"
	src='<c:url value="/web-resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
<script type="text/javascript"
	src='<c:url value="/web-resources/js/lib/jquery.ui.datepicker.js"/>'></script>
<script type="text/javascript"
	src='http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js'></script>
<!-- Latest compiled and minified CSS -->



</head>

<body>

	<%@ include file="controls/message.jsp"%>
	<%@ include file="controls/menu.jsp"%>

	<div class="row">
		<div id="menu-left" class="col-sm-3"
			style="height: 100%; border: 1px solid #ccc; border-radius: 5px">
			<h3 class="text-center">Menu</h3>
			<%@ include file="controls/menu_home_left.jsp"%>
		</div>
		<div class="col-sm-9">
			<div
				style="border: 1px solid #ccc; color: #FDC014; border-radius: 5px; margin: 0 5px; padding-left: 10px">
				<decorator:body />
			</div>
		</div>
	</div>


</body>
</html>