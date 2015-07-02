package erp.module.hrm.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import erp.core.database.BUS;
import erp.core.log.ILog;
import erp.module.hrm.dao.Hrm_ContractDAO;
import erp.module.hrm.model.Hrm_Contract;

public class Hrm_ContractService extends BUS {
	
	public List<Hrm_Contract> getAll() {
		
		List<Hrm_Contract> lstResult = null;
		try {
			lstResult = new Hrm_ContractDAO(this.m_objData).getAll();
			//ILog.Debug("Contract list retrieved: " + lstResult.size(), this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Debug(e.getMessage(), this);
		}
		return lstResult;
	}
	
	public List<Hrm_Contract> search(
			String contractIdInput,
			String contractNumber,
			String contractName,
			String modification,
			String value,
			Date startDate,
			Date endDate) {
		
		List<Hrm_Contract> lstResult = null;
		try {
			lstResult = new Hrm_ContractDAO(this.m_objData).
					search(contractIdInput, contractNumber, contractName, modification, value, startDate, endDate);
			//ILog.Debug("Contract list retrieved: " + lstResult.size(), this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Debug(e.getMessage(), this);
		}
		return lstResult;
	}
	
	public boolean addContract(
			String contractIdInput,
			String contractNumber,
			String contractName,
			String description,
			String modification,
			String value,
			Date startDate,
			Date endDate,
			String createUser) throws SQLException {

		this.BeginTran();

		Hrm_ContractDAO dao = new Hrm_ContractDAO(this.m_objData);
		boolean isOk = true;
		boolean isCreated = false;
		try {
			isOk = dao.Insert(contractIdInput, contractNumber, contractName, description, modification, value, startDate, endDate, createUser);
		} catch (SQLException e) {
			isOk = false;
			ILog.Error("BUS Contract Add", this, e);
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
		}

		return isCreated;
	}
	
	public boolean UpdateContract(int contractId,
			String contractIdInput,
			String contractNumber,
			String contractName,
			String description,
			String modification,
			String value,
			Date startDate,
			Date endDate,
			String updateUser) throws SQLException {

		this.BeginTran();

		Hrm_ContractDAO dao = new Hrm_ContractDAO(this.m_objData);
		boolean isOk = true;
		boolean isCreated = false;
		try {
			isOk = dao.update(contractId, contractIdInput, contractNumber, contractName, description, modification, value, startDate, endDate, updateUser);
		} catch (SQLException e) {
			isOk = false;
			ILog.Error("BUS Contract Update", this, e);
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
		}

		return isCreated;
	}
	
	public boolean deleteContract(int contractId,
			String deleteUser) throws SQLException {

		this.BeginTran();

		Hrm_ContractDAO dao = new Hrm_ContractDAO(this.m_objData);
		boolean isOk = true;
		boolean isDeleted = false;
		try {
			isOk = dao.delete(contractId, deleteUser);
		} catch (SQLException e) {
			isOk = false;
			ILog.Error("Service Contract at Deleting", this, e);
			e.printStackTrace();
		}

		try {
			if (isOk) {
				this.CommitTran();
				isDeleted = true;
			} else {
				this.RollbackTran();
				isDeleted = false;
			}
		} catch (Exception e) {
			isDeleted = false;
		}

		return isDeleted;
	}
	
	public Hrm_Contract getById(int contractId) {

		Hrm_Contract contract = null;
		try {
			contract = new Hrm_ContractDAO(this.m_objData).getById(contractId);
		} catch (SQLException e) {
			ILog.Debug(e.getMessage(), this);
		}
		return contract;
	}
}
