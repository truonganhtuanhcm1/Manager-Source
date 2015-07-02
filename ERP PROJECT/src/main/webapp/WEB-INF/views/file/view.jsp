<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<title>View file</title>

<%-- <iframe src="http://docs.google.com/gview?url=${url}" 
	style="width:1200px; height:768px;" frameborder="0"></iframe> --%>
	
<iframe id="view" src="http://docs.google.com/gview?url=${url}" 
	 frameborder="0" style="width:1024px; height:768px"></iframe>
	 
<!-- style="width:1024px; height:768px;" -->
	
<script>
	$(document).ready(function(){
		$("#view").width(1000);	
	});
	
	
</script>
