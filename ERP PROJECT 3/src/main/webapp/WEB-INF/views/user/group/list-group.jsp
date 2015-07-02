<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Manage groups</h3>

<form class="form-horizontal" role="form" method="post">
	<h3>Search</h3>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">Keyword</label>
		<div class="col-sm-3">
			<input name="keyword" class="form-control" value="${Keyword}">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-12">
			<button type="submit" class="btn btn-default">Search</button>
			<input type="button"
				class="btn btn-default ${permission_group_add == true ? 'block' : 'none'}"
				onclick="edit(0)" value="Add group">
		</div>
	</div>
</form>


<br>
<br>

<table class="table table-bordered">
	<thead>
		<tr>
			<th>No.</th>
			<th>Group name</th>
			<th>Description</th>
			<th>Created date</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${listGroup}" var="Group">
			<tr>
				<td><c:out value="${Group.group_id}" /></td>
				<td><c:out value="${Group.group_name}" /></td>
				<td><c:out value="${Group.description}" /></td>
				<td><c:out value="${Group.create_time}" /></td>
				<td width="100px"><nobr>
						<a class="pure-button pure-button-primary ${permission_group_edit == true ? 'block' : 'none'}"
							href="javascript:void(0)"
							onclick="edit(${Group.group_id},'${Group.group_name}','${Group.description}')">
							<i class="fa fa-pencil"></i>Edit
						</a> <a class="pure-button pure-button-primary ${permission_group_delete == true ? 'block' : 'none'}"
							onclick="return confirm('Are you sure you want to delete this group?');"
							href="delete/${Group.group_id}"> <i class="fa fa-times"></i>Delete
						</a>

					</nobr></td>
			</tr>
		</c:forEach>

	</tbody>
</table>

<div id="groupEdit" style="display: none">
	<form id="add-form" class="form-horizontal" role="form"
		action="/erp/user/group/edit" method="post">
		<input type="hidden" id="id" name="id" value="0">

		<div class="form-group">
			<label for="firstname" class="col-sm-3 control-label">Name:</label>
			<div class="col-sm-8">
				<input type="text" required class="form-control" name="name"
					id="name">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-3 control-label">Description:</label>
			<div class="col-sm-8">
				<input type="text" required class="form-control" name="description"
					id="description">
			</div>
		</div>
	</form>
</div>

<script>

$("#add-form").validate();

function edit(id,name,description){
	
	if(id>0){
		title ="Edit group";
	}else{
		title= "Add group";
	}
	
	$("#id").val(id);
	$("#name").val(name);
	$("#description").val(description);
	
	$('#add-form').dialog({

		autoOpen : true,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		title: title,
		buttons : {
			"OK" : function() {
				$("#add-form").submit();
				$(this).dialog('close');
			},
			"CANCEL" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			$(this).dialog('close');
			
		}
	});
	
	
}

</script>
