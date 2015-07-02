<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Manage users</h3>

<form class="form-horizontal" role="form" method="post" action="/erp/user/user/list">
	<h3>Search</h3>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">Keyword</label>
		<div class="col-sm-3">
			<input name="keyword" type="text" class="form-control" value="${keyword }">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">Group</label>
		<div class="col-sm-3">
			<select name="group_id" class="form-control">
				<option value="0">All</option>
				<c:forEach items="${listGroup}" var="Group">
					<option value="${Group.group_id}" ${Group.group_id == group_id ? 'selected' : ''}>
						<c:out value="${Group.group_name}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">Client Type</label>
		<div class="col-sm-3">
			<select  name="client_type_id" class="form-control">
				<option value="">All</option>
				<c:forEach items="${lstClientType}" var="Type">
					<option value="${Type.client_type_id}" ${Type.client_type_id == client_type_id ? 'selected' : ''}>
						<c:out value="${Type.client_type_id}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-2 control-label">Status</label>
		<div class="col-sm-3">
			<select  name="status_id" class="form-control">
				<option value="">All</option>
				<c:forEach items="${lstStatus}" var="Status">
					<option value="${Status.status_id}" ${Status.status_id == status_id ? 'selected' : ''}>
						<c:out value="${Status.description}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-12">
			<button type="submit" class="btn btn-default">Search</button>
			<a type="button" class="btn btn-default ${permission_user_add == true ? 'block' : 'none'}" href="/erp/user/user/add">Create</a>
		</div>
	</div>
</form>


<br>
<br>

<table class="table table-bordered">
	<thead>
		<tr>
			<th>Username</th>
			<th>Fisrt name</th>
			<th>Last name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Group</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${listuser}" var="User">
			<tr>
				<td><c:out value="${User.user_name}" /></td>
				<td><c:out value="${User.first_name}" /></td>
				<td><c:out value="${User.last_name}" /></td>
				<td><c:out value="${User.email}" /></td>
				<td><c:out value="${User.phone}" /></td>
				<td><c:out value="${User.group_name}" /></td>
				<td><c:out value="${User.status_name}" /></td>
				<td width="100px"><nobr>
						<a class="pure-button pure-button-primary ${permission_user_edit == true ? 'block' : 'none'}"
							href="edit/${User.user_name}"> <i class="fa fa-pencil"></i>Edit
						</a> <a class="pure-button pure-button-primary ${permission_user_delete == true ? 'block' : 'none'}"
							onclick="return confirm('Are you sure you want to delete this user?');"
							href="delete/${User.user_name}"> <i class="fa fa-times"></i>Delete
						</a>

					</nobr></td>
			</tr>
		</c:forEach>
		
	</tbody>
</table>


