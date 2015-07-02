package erp.module.hrm.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import erp.core.database.BUS;
import erp.core.log.ILog;
import erp.module.hrm.dao.Hrm_RequisitionDAO;
import erp.module.hrm.model.Hrm_Requisition;

public class Hrm_RequisitionService extends BUS {

	public boolean addRequisition(String requisitionIdInput, 
			int contractId,
			String requester, 
			int positionID, 
			Date requiredDate,
			int requisitionStatusId, 
			String salaryRange, 
			int clearanceLvId,
			String certificateReq, 
			int educationId, 
			String educationOther,
			String cityName,
			int stateId, 
			int countryId,
			String attachment,
			String createUser, 
			String updateUser) throws SQLException {

		this.BeginTran();

		Hrm_RequisitionDAO dao = new Hrm_RequisitionDAO(this.m_objData);
		boolean isOk = true;
		boolean isCreated = false;
		try {
			isOk = dao.insert(requisitionIdInput, contractId, requester,
					positionID, requiredDate, requisitionStatusId, salaryRange,
					clearanceLvId, certificateReq, educationId, educationOther, cityName,
					stateId, countryId, attachment, createUser, updateUser);
		} catch (SQLException e) {
			isOk = false;
			ILog.Error("Hrm_RecruitmentDao Insert", this, e);
			e.printStackTrace();
		}

		try {
			if (isOk) {
				this.CommitTran();
				isCreated = true;
			} else {
				this.RollbackTran();
				isCreated = false;
			}
		} catch (Exception e) {
			isCreated = false;
			ILog.Error(
					"RequisitionService - Add requisition: " + e.getMessage(),
					this, e);
		}

		return isCreated;
	}

	public boolean update(
			int requisitionId, 
			String requisitionIdInput,
			int contractId, 
			String requester, 
			int positionId,
			Date requiredDate, 
			int requisitionStatusId,
			String salaryRange, 
			int clearanceLvId,
			String certificateReq, 
			int educationId,
			String educationOther,
			String cityName, 
			int stateId, 
			int countryId, 
			String attachment,
			String updateUser
			)
			throws SQLException {

		this.BeginTran();
		boolean isOk = true;
		Hrm_RequisitionDAO requisitionDAO = new Hrm_RequisitionDAO(
				this.m_objData);

		try {
			isOk &= requisitionDAO.update(
					requisitionId, 
					requisitionIdInput,
					contractId, 
					requester, 
					positionId, 
					requiredDate, 
					requisitionStatusId,
					salaryRange, 
					clearanceLvId,
					certificateReq, 
					educationId,
					educationOther,
					cityName,
					stateId, 
					countryId, 
					attachment, 
					updateUser);
			if (isOk) {
				this.CommitTran();
			} else {
				this.RollbackTran();
			}
		} catch (SQLException e) {
			isOk &= false;
			ILog.Error("Requisition Update", this, e);
			e.printStackTrace();
		}

		return isOk;
	}

	public List<Hrm_Requisition> getAll(int contract_id, int requisition_id, String location, String requester
			, int position_id, int requisitionStatusId, Date dtRequiredDate) {

		List<Hrm_Requisition> lstResult = null;
		try {
			lstResult = new Hrm_RequisitionDAO(this.m_objData).getAll(contract_id, requisition_id, location, requester, 
					position_id, requisitionStatusId, dtRequiredDate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Debug(e.getMessage(), this);
		}
		return lstResult;
	}
	
	public List<Hrm_Requisition> getAll()
	{
		return this.getAll(-1, -1, "", "", -1, -1, null);
	}

	public Hrm_Requisition getById(int requisitionId) {

		Hrm_Requisition requisition = null;
		try {
			requisition = new Hrm_RequisitionDAO(this.m_objData)
					.getById(requisitionId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Debug(e.getMessage(), this);
		}
		return requisition;
	}
	
	public boolean Delete(int requisitionId, String userName) throws SQLException {
		// TODO Auto-generated method stub
		this.BeginTran();
		
		Hrm_RequisitionDAO requisitionDAO = new Hrm_RequisitionDAO(m_objData);
		boolean isOk = requisitionDAO.delete(requisitionId, userName);

		if (isOk) {
			this.CommitTran();
		} else {
			this.RollbackTran();
		}
		
		return isOk;
		
	}

}
