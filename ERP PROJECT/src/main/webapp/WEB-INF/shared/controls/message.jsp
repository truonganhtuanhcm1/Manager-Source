<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="bookDialog1" style="display:none">
	<c:forEach items="${messageList}" var="String" >
		<div>
			<c:if test="${messageStatus == 1 || messageStatus == 3}">
				<img width="20px"  src='<c:url value="/web-resources/images/success.png"/>'>
			</c:if>
			
			<c:if test="${messageStatus == 2 }">
				<img width="20px" src='<c:url value="/web-resources/images/error.png"/>'>
			</c:if>
			
			 <c:out value="${String}" />
		</div>
	</c:forEach>
</div>  

<c:if test="${messageStatus != null && messageStatus != 3}">
	<script>
		$('#bookDialog1').dialog({
		
			autoOpen : true,
			position : 'center',
			modal : true,
			resizable : false,
			width : 440,
			title:'Alert',
			buttons : {
				"OK" : function() {
					$(this).dialog('close');
				}
			},
			close : function() {
		
				$(this).dialog('close');
				
			}
		});
	</script>
</c:if>


