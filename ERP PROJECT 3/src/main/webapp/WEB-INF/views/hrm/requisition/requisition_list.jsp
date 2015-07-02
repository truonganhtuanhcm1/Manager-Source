<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<title>List Requisition</title>
<form class="form-horizontal" role="form" action="/erp/hrm/requisition/search" method="get">
	<h3>Requisition Search</h3>
	<div class="form-group">
		<label class="col-sm-2 control-label">Requisition ID:</label>
		<div class="col-sm-4">
			<%-- <input name="requisition_id_input" class="form-control" value="${requisition_id_input}"> --%>
			<select class="form-control" name="requisition_id">
				<option value="-1">All requisition</option>
				<c:forEach items="${ListRequisition }" var="Requisition">
					<option value="${Requisition.requisition_id }" ${Requisition.requisition_id == requisition_id ? 'selected' : ''} >
						<c:out value="${Requisition.requisition_id_input }"></c:out>
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Contract ID:</label>
		<div class="col-sm-4">
			<%-- <input name="contract_id" class="form-control" value="${contract_id}"> --%>
			<select class="form-control contractId" name="contract_id">
				<option value="-1">All contract</option>
				<c:forEach items="${ListContract }" var="Contract">
					<option value="${Contract.contract_id }" ${Contract.contract_id == contract_id ? 'selected' : ''} >
						<c:out value="${Contract.contract_id_input }"></c:out>
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Contract Number:</label>
		<div class="col-sm-4">
			<select disabled class="form-control contractNumber">
				<option value="-1"></option>
				<c:forEach items="${ListContract}" var="Contract">
					<option value="${Contract.contract_id}" ${Contract.contract_id == targetRequisition.contract_id ? 'selected' : ''}>
						<c:out value="${Contract.contract_number}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Contract Name:</label>
		<div class="col-sm-4">
			<select disabled class="form-control contractName">
				<option value="-1"></option>
				<c:forEach items="${ListContract}" var="Contract">
					<option value="${Contract.contract_id}" ${Contract.contract_id == targetRequisition.contract_id ? 'selected' : ''}>
						<c:out value="${Contract.contract_name}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">Location:</label>
		<div class="col-sm-4">
			<input name="location" class="form-control" value="${location}">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Requester:</label>
		<div class="col-sm-4">
			<input  name="requester" type="text" class="form-control" value="${requester}">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Position Title :</label>
		<div class="col-sm-4">
			<select class="form-control" name="position_id">
				<option value="-1">All status</option>
				<c:forEach items="${ListPosition}" var="Position">
					<option value="${Position.position_id}" ${Position.position_id == position_id ? 'selected' : ''}>
						<c:out value="${Position.position_title}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Status:</label>
		<div class="col-sm-4">
			<select name="requisitionStatusId" class="form-control">
				<option value="-1">All status</option>
				<option value="0" ${0 == requisitionStatusId ? 'selected' : ''}>Closed</option>
				<option value="1" ${1 == requisitionStatusId ? 'selected' : ''}>Open</option>
				<option value="2" ${2 == requisitionStatusId ? 'selected' : ''}>Pending</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Required
			Date:</label>
		<div class="col-sm-4">
			<input name="required_date" class="form-control" id="from-datepicker" value="${required_date}">
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">Search</button>

		</div>
	</div>
</form>

<table class="table table-bordered">
	<thead>
		<tr>
			<th>No.</th>
			<th>Requisition ID</th>
			<th>Contract Number</th>
			<th>Contract Name</th>
			<th>Position Title</th>
			<th>Status</th>
			<th>Required Date</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
	<c:set var="myVar" value="0"/>  
		<c:forEach items="${ListRequisitionSearched}" var="Requisition">
			<fmt:formatDate value="${Requisition.required_date}"
				var="formattedRequiredDate" type="date" pattern="MM/dd/yyyy" />
			<tr>
				<td><c:out value="${ myVar}"></c:out></td>
				<c:set var="myVar" value="${ myVar+1}"/> 
				<td><c:out value="${Requisition.requisition_id_input}"></c:out></td>
				
				<td>
					<c:out value="${Requisition.contract_number}"></c:out>
				</td>
				<td>
					<c:out value="${Requisition.contract_name}"></c:out>
				</td>
						
				<td><c:out value="${Requisition.position_title}"></c:out></td>
				<td>
					<c:if test="${Requisition.status_id == 0 }">Closed</c:if>
					<c:if test="${Requisition.status_id == 1 }">Open</c:if>
					<c:if test="${Requisition.status_id == 2 }">Pending</c:if>
				</td>
				<td><c:out value="${formattedRequiredDate}"></c:out></td>
				<td width="100px"><nobr>
						<a class="pure-button pure-button-primary ${permission_requisition_edit == true ? 'block' : 'none'}"
							href="/erp/hrm/requisition/edit/${Requisition.requisition_id}">
							<i class="fa fa-pencil"></i>Edit
						</a> 
						<%-- <a class="pure-button pure-button-primary  ${permission_requisition_delete == true ? 'block' : 'none'}"
							onclick="return confirm('Are you sure you want to delete this requisition?');"
							href="delete/${Requisition.requisition_id}"> <i class="fa fa-times"></i>Delete
						</a> --%>
						
						 <a class="pure-button pure-button-primary  ${permission_requisition_view == true ? 'block' : 'none'}"
							href="view/${Requisition.requisition_id}"> <i class="fa fa-times"></i>View
						 </a>
						 
						 <a class="pure-button pure-button-primary  ${permission_requisition_copy == true ? 'block' : 'none'}"
							href="copy/${Requisition.requisition_id}"> <i class="fa fa-times"></i>Duplicate
						 </a>
					</nobr>
				</td>
				
			</tr>
		</c:forEach>
		<!--<tr>
			<td>2</td>
			<td>002</td>
			<td>ABC Project</td>
			<td>ABC Title</td>
			<td>Open</td>
			<td>03/05/2015</td>
			<td width="100px"><nobr>
					<a class="pure-button pure-button-primary block" href="/erp/hrm/recruitment/requisition_edit">
						<i class="fa fa-pencil"></i>Edit
					</a> <a class="pure-button pure-button-primary block"
						onclick="return confirm('Are you sure you want to enable this recruitment?');"
						href="view/1"> <i class="fa fa-times"></i>View
					</a> <a class="pure-button pure-button-primary block"
						onclick="return confirm('Are you sure you want to delete this recruitment?');"
						href="delete/1"> <i class="fa fa-times"></i>Copy
					</a>

				</nobr></td>
		</tr>-->
	</tbody>
</table>


<script>
	$(function() {
		$("#from-datepicker").datepicker();
		$("#to-datepicker").datepicker();
		
		loadContractInfo();
	});
	
	$("#add-form").validate();
	
	$(".contractId").change(function(){
		loadContractInfo();
	});
	
	function loadContractInfo(){
		var contractId = $(".contractId option:selected").val();
		$(".contractNumber").val(contractId);
		$(".contractName").val(contractId);
	}
	
</script>