<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<fmt:formatDate value="${recruit.expired_date}" var="formattedDate" type="date" pattern="MM/dd/yyyy" />

<title>Add Employee Record</title>

<form id="add-form" class="form-horizontal" role="form" action="/erp/hrm/employee_record/add" method="post">
	<!-- <input type="hidden" name="id"> -->
	<h3>Employee Record Add</h3>
	
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label">Employee ID:</label>
		<div class="col-sm-3">
			<input required name="empIdInput" type="text" class="form-control" value="">
		</div>
	</div>
	
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label"><br>Employee Name:</label>
		<div class="col-sm-3">
			<label for="firstname" class="col-sm-12 control-label">First Name </label> 
			<input required name="firstName" type="text" class="form-control" value="">
		</div>
		<div class="col-sm-2">
			<label for="firstname" class="col-sm-12 control-label">Last Name </label> 
			<input required name="lastName" type="text" class="form-control" value="">
		</div>
		<div class="col-sm-2">
			<label for="firstname" class="col-sm-12 control-label">M.I</label> 
			<input name="midName" type="text" class="form-control" value="">
		</div>
	</div>
	
	<div class="form-group">
		<label for="location" class="col-sm-3 control-label"><br>Location:</label>
		<div class="col-sm-3">
			<label for="street" class="col-sm-12 control-label text-left">Street</label>
			<input required name="street" class="form-control" value="">
		</div>
		<div class="col-sm-4">
			<label for="city" class="col-sm-12 control-label text-left">City</label>
			<input required name="cityName" class="form-control" value="">
		</div>
	</div>
	
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label"></label>
		<div class="col-sm-3">
			<label for="lastname" class="col-sm-12 control-label text-left">State</label>
			<select required name="stateId" class="form-control" >
				<c:forEach items="${ListState}" var="State">
					<option value="${State.state_id}">
						<c:out value="${State.state_name}" />
					</option>
				</c:forEach>
			</select>
		</div>
		
		<div class="col-sm-2">
			<label for="zipCode" class="col-sm-12 control-label text-left">Zip code</label> 
			<input required name="zipCode" class="form-control" value="">
		</div>
		
		<div class="col-sm-2">
			<label for="country" class="col-sm-12 control-label text-left">Country</label>
			<select name="countryId" class="form-control">
				<c:forEach items="${ListCountry}" var="Country">
					<option value="${Country.country_id}">
						<c:out value="${Country.country_name}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label for="positionType" class="col-sm-3 control-label">Position Type :</label>
		<div class="col-sm-7">
			<input required name="positionType" type="text" class="form-control" value="">
		</div>
	</div>
	
	<div class="form-group">
		<label for="hiredDate" class="col-sm-3 control-label">Hired	Date :</label>
		<div class="col-sm-3">
			<input required name="hiredDate" type="text" class="form-control" id="hired-date">
		</div>
	</div>
	
	<div class="form-group">
		<label for="salary" class="col-sm-3 control-label">Salary :</label>
		<div class="col-sm-3">
			<input required name="salary" type="text" class="form-control">
		</div>
	</div>
	
	<div class="form-group">
		<label for="workTimeId" class="col-sm-3 control-label"></label>
		<div class="col-sm-9">
			<input type="hidden" name="workTimeId" id="workTimeId" value="-1"/>
			<c:forEach items="${ListWorkTime}" var="WorkTime">
				<input type="checkbox" class="workTimeGroup" value="${WorkTime.work_time_id}"> ${WorkTime.work_time_name}
			</c:forEach>
		</div>
		<div class="col-sm-1"></div>
	</div>
	
	<div class="form-group">
		<label for="contactInfo" class="col-sm-3 control-label"><br>Contact Information :</label>
		<div class="col-sm-3">
			<label for="email" class="col-sm-12 control-label">Email Address </label> 
			<input required name="email" type="text" class="form-control" value="">
		</div>
		<div class="col-sm-2">
			<label for="mobile" class="col-sm-12 control-label">Mobile</label> 
			<input required name="mobile" type="text" class="form-control" value="">
		</div>
		<div class="col-sm-2" style="padding-right: 0">
			<label for="homeNumber" class="col-sm-12 control-label">Home Number</label> 
			<input required name="homeNumber" type="text" class="form-control" value="">
		</div>
	</div>
	
	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Clearance Level:</label>
		<div class="col-sm-3">
			<select class="form-control clearanceLvId" name="clearanceLvId">
				<optgroup label="Pulbic Trust">
					<option value="1">Pulbic Trust/1</option>
					<option value="2">Pulbic Trust/2</option>
					<option value="3">Pulbic Trust/3</option>
					<option value="4">Pulbic Trust/4</option>
					<option value="5">Pulbic Trust/5</option>
					<option value="6">Pulbic Trust/6</option>
				</optgroup>
				<option id="clearanceLv_Secret" value="7">Secret</option>
				<optgroup label="Top Secret">
					<option  value="8">Top Secret/CI</option>
					<option  value="9">Top Secret/CI with poly</option>
					<option  value="10">Top Secret/SCI</option>
					<option  value="11">Top Secret/SCI with poly</option>
					<option  value="12">Top Secret/SCI with full Scope</option>
					<option  value="13">Top Secret/SCI with lifestyle</option>
				</optgroup>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label for="lastname" class="col-sm-3 control-label">Contract:</label>
		<div class="col-sm-3">
			<select name="contractId" class="form-control">
				<c:forEach items="${ListContract}" var="Contract">
					<option value="${Contract.contract_id}">
						<c:out value="${Contract.contract_id_input}" />
					</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label for="department" class="col-sm-3 control-label">Department:</label>
		<div class="col-sm-3">
			<select name="departmentId" class="form-control">
				<c:forEach items="${ListDepartment}" var="Department">
					<option value="${Department.department_id }">
						<c:out value="${Department.department_name }"></c:out>
					</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label for="program" class="col-sm-3 control-label">Program:</label>
		<div class="col-sm-6">
			<input name="program" type="text" class="form-control" value="">
		</div>
	</div>
	
	<div class="form-group">
		<label for="programManager" class="col-sm-3 control-label">Program Manager:</label>
		<div class="col-sm-6">
			<input name="programManager" type="text" class="form-control">
		</div>
	</div>
	
	<div class="form-group">
		<label for="pocPhone" class="col-sm-3 control-label">POC Phone Number :</label>
		<div class="col-sm-6">
			<input name="pocPhone" type="text" class="form-control">
		</div>
	</div>
	
	<div class="form-group">
		<label for="evaluationDate" class="col-sm-3 control-label">Evaluation Date:</label>
		<div class="col-sm-3">
			<input name="evaluationDate" id="evaluation-date" type="text" class="form-control">
		</div>
	</div>
	
	<div class="form-group">
		<label for="taxInfo" class="col-sm-3 control-label">Tax Infomation:</label>
		<div class="col-sm-6">
			<input name="taxInfo" type="text" class="form-control">
		</div>
	</div>
	
	<div class="form-group">
		<label for="wage" class="col-sm-3 control-label"><br>Wage Garnishment:</label>
		<div class="col-sm-6">
			<div class="col-sm-7" style="padding-left:0">
			<label for="courtOrder" class="col-sm-12 control-label">Court Order Number</label>
				<input name="courtOrder" type="text" class="form-control">
			</div>
			
			<div class="col-sm-5" style="padding-right: 0">
			<label for="county" class="col-sm-12 control-label">County</label>
				<input name="county" type="text" class="form-control">
			</div>
		</div>
	</div>
	
	<div class="form-group">
		<label for="firstname" class="col-sm-3 control-label"><br></label>
		<div class="col-sm-6">
			<div class="col-sm-7" style="padding-left:0">
			<label for="courtAddress" class="col-sm-12 control-label">Court Address</label>
				<input name="courtAddress" type="text" class="form-control">
			</div>
			
			<div class="col-sm-5"  style="padding-right: 0">
			<label for="amount" class="col-sm-12 control-label">Amount </label>
				<input name="amount" type="text" class="form-control">
			</div>
		</div>
	</div>

	<div class="form-group">
		<label for="terminationDate" class="col-sm-3 control-label">Termination Date:</label>
		<div class="col-sm-3"> 
			<input name="terminationDate" id="termination-date" type="text" class="form-control">
		</div>
	</div>
	
	<div class="form-group">
		<label for="hireStatus" class="col-sm-3 control-label"> </label>
		<div class="col-sm-3">
			<input name="rehire" type="checkbox"> Rehire 
			<input name="notHire" type="checkbox"> Not Rehired
		</div>
	</div>
	
	<div class="form-group">
		<label for="terminationReason" class="col-sm-3 control-label">Reason for Termination:</label>
		<div class="col-sm-6">
			<select name="terminationReasonId" class="form-control">
				<c:forEach items="${ListTerminationReason}" var="TerminationReason">
					<option value="${TerminationReason.termination_reason_id }">
						<c:out value="${TerminationReason.termination_reason_content }"></c:out>
					</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-3 col-sm-1">
			<!-- <a href='/erp/hrm/recruitment/candidate_tracker_list' type="submit" class="btn btn-danger">Create</a> -->
			<button type="submit" class="btn btn-danger">Create</button>
		</div>
	</div>
</form>

<script>
	$(function() {
		$("#hired-date").datepicker();
		$("#evaluation-date").datepicker();
		$("#termination-date").datepicker();

	});
	$("#add-form").validate();
	
	$("#clearanceLv_Secret").css("font-weight", "bold"); 
	
	function resetCheckbox(selectedWorkTime){
		var workTimeItems = $(".workTimeGroup");
		//for (var i = 0; i < elemen)
		$.each(workTimeItems, function(idx, target){
			target.checked = false;
		});
	}
	
	$(".workTimeGroup").change(function(){
		if (this.checked){
			resetCheckbox();
			//$("#workTimeId").val(this.val);
			//alert(this.val());
			this.checked = true;
		}
		else{
			$("#workTimeId").val("-1");
		}
	});
	
	
</script>