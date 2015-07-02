<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<title>List Contract</title>
<form class="form-horizontal" role="form" action="/erp/hrm/contract/list">
	<h3>Contract Search</h3>
	
	<input type="hidden" name="contractId" value="${contractId}">
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Contract ID:</label>
		<div class="col-sm-4">
			<input name="contractIdInput" class="form-control" value="${contractIdInput}">
		</div>	
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Contract Number:</label>
		<div class="col-sm-4">
			<input name="contractNumber" class="form-control" value="${contractNumber}">
		</div>	
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Contract
			Name:</label>
		<div class="col-sm-4">
			<input name="contractName" class="form-control" value="${contractName}">
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Value:</label>
		<div class="col-sm-4">
			<input name="value" class="form-control" value="${value}">
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">Modification:</label>
		<div class="col-sm-4">
			<input  name="modification" type="text" class="form-control" value="${modification}">
		</div>
	</div>


	<div class="form-group">
		<label class="col-sm-2 control-label">Start Date:</label>
		<div class="col-sm-4">
			<input name="startDate" class="form-control" id="from-datepicker" value="${startDate}">
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">End Date:</label>
		<div class="col-sm-4">
			<input name="endDate" class="form-control" id="to-datepicker" value="${endDate}">
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
			<th>Contract ID</th>
			<th>Contract Number</th>
			<th>Contract Name</th>
			<th>Value</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
	<%-- <c:set var="myVar" value="0"/>   --%>
		<c:forEach items="${ListContract}" var="Contract">
			<fmt:formatDate value="${Contract.start_date}" var="formattedStartDate" type="date" pattern="MM/dd/yyyy" />
			<fmt:formatDate value="${Contract.end_date}" var="formattedEndDate" type="date" pattern="MM/dd/yyyy" />
			<tr>
				<td><c:out value="${Contract.contract_id_input}"></c:out></td> <%-- <c:set var="myVar" value="${myVar + 1}"/> --%>
				<td><c:out value="${Contract.contract_number}"></c:out></td>
				<td><c:out value="${Contract.contract_name}"></c:out></td>
				<td><c:out value="${Contract.value}"></c:out></td>
				<td><c:out value="${formattedStartDate}"></c:out></td>
				<td><c:out value="${formattedEndDate}"></c:out></td>
				<td width="100px"><nobr>
					<a class="pure-button pure-button-primary ${permission_contract_edit == true ? 'block' : 'none'}"
						href="/erp/hrm/contract/edit/${Contract.contract_id}">
						<i class="fa fa-pencil"></i>Edit
					</a> 
					<a class="pure-button pure-button-primary ${permission_contract_view == true ? 'block' : 'none'}"
						href="/erp/hrm/contract/view/${Contract.contract_id}"> <i class="fa fa-times"></i>View
					</a> 
					<a class="pure-button pure-button-primary ${permission_contract_delete == true ? 'block' : 'none'}"
						onclick="return confirm('Are you sure you want to delete this contract?');"
						href="delete/${Contract.contract_id}"> <i class="fa fa-times"></i>Delete
					</a>

				</nobr></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<script>
	$(function() {
		$("#from-datepicker").datepicker();
		$("#to-datepicker").datepicker();
	});
	$("#add-form").validate();
</script>