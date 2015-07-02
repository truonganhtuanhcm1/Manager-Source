<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Permissions</h3>

<form id="form" class="form-horizontal" role="form" method="post"
	action="/erp/user/permission/group">
	<h3>Search</h3>
	<div class="form-group">
		<label class="col-sm-2 control-label">Keyword:</label>
		<div class="col-sm-3">
			<input name="keyword" class="form-control" value="${keyword }"
				minlength="3">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Group:</label>
		<div class="col-sm-3">
			<select required name="group_id" class="form-control">
				<option value="">Choose</option>
				<c:forEach items="${listGroup}" var="Group">
					<option value="${Group.group_id}"
						${Group.group_id == group_id ? 'selected' : ''}>
						<c:out value="${Group.group_name}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-12">
			<button name="btn_load" type="submit" class="btn btn-default">Load
				permission</button>
		</div>
	</div>
	<h3>Permissions List</h3>
	<div class="form-group">

		<c:forEach items="${lstPermission}" var="Item">
			<div class="col-sm-3">
				<input type="checkbox" name="${Item.permission_id}"
					title="${Item.description}" ${Item.applied != "0" ? 'checked' : ''} />
				&nbsp; ${Item.permission_id}
			</div>

		</c:forEach>

	</div>
	<br> <br>
	<div class="form-group">
		<div class=" col-sm-12">
			<button name="btn_save" type="submit" class="btn btn-default">Save</button>
		</div>
	</div>
</form>

<script>
	$("#form").validate();
</script>


