<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="panel-group">

	<div class="panel panel-default ${(permission_group_list == true || permission_user_list == true || permission_permission_list) ? 'block' : 'none'}">
		<div class="panel-heading">
			<a class="accordion-toggle collapsed" data-toggle="collapse"
				data-parent="#accordion2" href="#collapseTwo"><i
				class="glyphicon glyphicon-folder-open"></i>&nbsp; Administrative</a>
		</div>
		<div id="collapseTwo" class="panel-collapse collapse"
			style="height: 0px;">
			<div class="panel-body">
				<ul class="nav nav-tabs nav-stacked">
					<li class="${permission_group_list == true ? 'block' : 'none'}"><a href="/erp/user/group/list"><i
							class="icon-double-angle-right"></i><i
							class="glyphicon glyphicon-list-alt"></i>&nbsp; Manage Groups</a></li>
					<li class="${permission_user_list == true ? 'block' : 'none'}"><a href="/erp/user/user/list"><i
							class="icon-double-angle-right"></i> <i
							class="glyphicon glyphicon-plus"></i>&nbsp; Manage Users</a></li>

					<li  class="${permission_permission_list == true ? 'block' : 'none'}"><a href="/erp/user/permission/group"><i
							class="icon-double-angle-right"></i><i
							class="glyphicon glyphicon-list-alt"></i>&nbsp; Manage Permission
							Groups</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="panel panel-default ${permission_recruitment_list || permission_employee_list ? 'block' : 'none'}">
		<div class="panel-heading">
			<a class="accordion-toggle collapsed" data-toggle="collapse"
				data-parent="#accordion1" href="#collapseOne"><i
				class="glyphicon glyphicon-folder-open"></i>&nbsp; Human Resource</a>
		</div>
		<div id="collapseOne" class="panel-collapse collapse"
			style="height: 0px;">
			<div class="panel-body">
				<ul class="nav nav-tabs nav-stacked">
				<li  class="${permission_requisition_add == true ? 'block' : 'none'}"><a href="javascript:void(0)"><i
							class="icon-double-angle-right"></i><i
							class="glyphicon glyphicon-list-plus"></i>&nbsp;  1. RECRUITMENT</a></li>
					<li style="margin-left: 20px !important;"  class="${permission_requisition_add == true ? 'block' : 'none'}">
						<a href="/erp/hrm/requisition/add">
							<img src='<c:url value="/web-resources/images/add.png"/>'/>  Create Requisition
						</a>
					</li>
					<li style="margin-left: 20px !important;" class="${permission_requisition_list == true ? 'block' : 'none'}">
					<a href="/erp/hrm/requisition/list">
					<img src='<c:url value="/web-resources/images/list.png"/>'/> Manage Requisition</a></li>
							
				</ul>
				<ul class="nav nav-tabs nav-stacked">
				<li  class="${permission_requisition_add == true ? 'block' : 'none'}"><a href="javascript:void(0)"><i
							class="icon-double-angle-right"></i><i
							class="glyphicon glyphicon-list-plus"></i>&nbsp;  2. CONTRACT MANAGEMENT</a></li>
					<li style="margin-left: 20px !important;"  class="${permission_contract_add == true ? 'block' : 'none'}"><a href="/erp/hrm/contract/add">
					<img src='<c:url value="/web-resources/images/add.png"/>'/> Create Contract</a></li>
					<li style="margin-left: 20px !important;" class="${permission_contract_list == true ? 'block' : 'none'}"><a href="/erp/hrm/contract/search">
					<img src='<c:url value="/web-resources/images/list.png"/>'/> Manage Contract</a></li>
							
				</ul>
				
				<ul class="nav nav-tabs nav-stacked">
				<li  class="${permission_cand_tracker_list == true ? 'block' : 'none'}"><a href="javascript:void(0)"><i
							class="icon-double-angle-right"></i><i
							class="glyphicon glyphicon-list-plus"></i>&nbsp;  3. CANDIDATE TRACKER MANAGEMENT</a></li>
					<li style="margin-left: 20px !important;"  class="${permission_cand_tracker_add == true ? 'block' : 'none'}"><a href="/erp/hrm/candidate_tracker/add">
					<img src='<c:url value="/web-resources/images/add.png"/>'/> Create Candidate Tracker</a></li>
					<li style="margin-left: 20px !important;" class="${permission_cand_tracker_list == true ? 'block' : 'none'}"><a href="/erp/hrm/candidate_tracker/search">
					<img src='<c:url value="/web-resources/images/list.png"/>'/> Manage Candidate Tracker</a></li>
							
				</ul>
			</div>
		</div>
	</div>

	

</div>