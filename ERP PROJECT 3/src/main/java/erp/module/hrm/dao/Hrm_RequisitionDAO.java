package erp.module.hrm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import erp.core.ConvertCore;
import erp.core.database.DAO;
import erp.core.database.IData;
import erp.core.database.ResultSetMapper;
import erp.core.log.ILog;
import erp.module.hrm.model.Hrm_Requisition;
import erp.module.user.model.User;

public class Hrm_RequisitionDAO extends DAO {

	public Hrm_RequisitionDAO(IData objData) {
		super(objData);
		// TODO Auto-generated constructor stub
	}

	public boolean insert(String requisitionIdInput, 
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
		// public boolean Insert(Hrm_Requisition hrmRequisition) throws
		// SQLException {
		boolean isOk = true;
		try {

			this.TryConnect();

			this.m_objData
					.SetStoreName("hrm_requisition_insert(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			this.m_objData.Parameters.setString(1, requisitionIdInput);
			this.m_objData.Parameters.setInt(2, contractId);
			this.m_objData.Parameters.setString(3, requester);
			this.m_objData.Parameters.setInt(4, positionID);
			this.m_objData.Parameters.setTimestamp(5, ConvertCore.ConvertToSqlTimestamp(requiredDate));
			this.m_objData.Parameters.setInt(6, requisitionStatusId);
			this.m_objData.Parameters.setString(7, salaryRange);
			this.m_objData.Parameters.setInt(8, clearanceLvId);
			this.m_objData.Parameters.setString(9, certificateReq);
			this.m_objData.Parameters.setInt(10, educationId);
			this.m_objData.Parameters.setString(11, educationOther);
			this.m_objData.Parameters.setString(12, cityName);
			this.m_objData.Parameters.setInt(13, stateId);
			this.m_objData.Parameters.setInt(14, countryId);
			this.m_objData.Parameters.setString(15, attachment);
			this.m_objData.Parameters.setString(16, createUser);
			this.m_objData.Parameters.setString(17, updateUser);
			
			this.m_objData.ExecNoneQuery();

			isOk = true;

		} catch (Exception e) {
			isOk = false;
			ILog.Error("Requisition DAO - Insert: ", this, e);
			e.printStackTrace();
		} finally {
			this.TryDisconnect();
		}

		return isOk;
	}

	public List<Hrm_Requisition> getAll(int contract_id,
			int requisition_id,
			String location, 
			String requester,
			int position_id, 
			int requisitionStatusId, 
			Date dtRequiredDate)
			throws SQLException {

		try {

			this.TryConnect();
			this.m_objData.SetStoreName("hrm_requisition_getAll(?,?,?,?,?,?,?)");
			this.m_objData.Parameters.setInt(1, contract_id);
			this.m_objData.Parameters.setInt(2, requisition_id);
			this.m_objData.Parameters.setString(3, location);
			this.m_objData.Parameters.setString(4, requester);
			this.m_objData.Parameters.setInt(5, position_id);
			this.m_objData.Parameters.setInt(6, requisitionStatusId);
			this.m_objData.Parameters.setTimestamp(7, dtRequiredDate != null ? ConvertCore.ConvertToSqlTimestamp(dtRequiredDate) : null);
			
			ResultSetMapper util = new ResultSetMapper<User>();
			ResultSet rsResult = this.m_objData.ExecToResultSet();
			
			List<Hrm_Requisition> lstResult = util.mapRersultSetToObject(
					rsResult, Hrm_Requisition.class);

			if (lstResult == null)
				return null;

			if (lstResult.size() > 0)
				return lstResult;
			return null;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			this.TryDisconnect();
		}

		return null;
	}

	public Hrm_Requisition getById(int requisitionId) throws SQLException {

		try {

			this.TryConnect();
			this.m_objData.SetStoreName("hrm_requisition_getById(?)");
			this.m_objData.Parameters.setInt(1, requisitionId);
			ResultSetMapper util = new ResultSetMapper<User>();
			ResultSet rsResult = this.m_objData.ExecToResultSet();
			List<Hrm_Requisition> lstResult = util.mapRersultSetToObject(
					rsResult, Hrm_Requisition.class);

			if (lstResult == null)
				return null;

			if (lstResult.size() > 0)
				return lstResult.get(0);

			return null;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			this.TryDisconnect();
		}

		return null;
	}

	public boolean update(int requisitionId, String requisitionIdInput,
			int contractId, String requester, int positionId,
			Date requiredDate, int requisitionStatusId, String salaryRange,
			int clearanceLvId, String certificateReq, int educationId,
			String educationOther, String cityName, int stateId,
			int countryId, String attachment, String updateUser)
			throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData
					.SetStoreName("hrm_requisition_update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			this.m_objData.Parameters.setInt(1, requisitionId);
			this.m_objData.Parameters.setString(2, requisitionIdInput);
			this.m_objData.Parameters.setInt(3, contractId);
			this.m_objData.Parameters.setString(4, requester);
			this.m_objData.Parameters.setInt(5, positionId);
			this.m_objData.Parameters.setTimestamp(6, ConvertCore.ConvertToSqlTimestamp(requiredDate));
			this.m_objData.Parameters.setInt(7, requisitionStatusId);
			this.m_objData.Parameters.setString(8, salaryRange);
			this.m_objData.Parameters.setInt(9, clearanceLvId);
			this.m_objData.Parameters.setString(10, certificateReq);
			this.m_objData.Parameters.setInt(11, educationId);
			this.m_objData.Parameters.setString(12, educationOther);
			this.m_objData.Parameters.setString(13, cityName);
			this.m_objData.Parameters.setInt(14, stateId);
			this.m_objData.Parameters.setInt(15, countryId);
			this.m_objData.Parameters.setString(16, attachment);
			this.m_objData.Parameters.setString(17, updateUser);
			
			this.m_objData.ExecNoneQuery();

			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			this.TryDisconnect();
		}

		return false;
	}

	// TODO: need to add username who call delete function parameter
	public boolean delete(int requisitionId, String userName)
			throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("hrm_requisition_delete(?)");

			this.m_objData.Parameters.setInt(1, requisitionId);

			this.m_objData.ExecNoneQuery();

			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.TryDisconnect();
		}

		return false;
	}

}
