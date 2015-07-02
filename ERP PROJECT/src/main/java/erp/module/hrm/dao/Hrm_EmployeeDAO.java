package erp.module.hrm.dao;

import java.sql.SQLException;
import java.util.Date;

import erp.core.ConvertCore;
import erp.core.database.DAO;
import erp.core.database.IData;
import erp.core.log.ILog;

public class Hrm_EmployeeDAO extends DAO {

	public Hrm_EmployeeDAO(IData objData) {
		super(objData);
		// TODO Auto-generated constructor stub
	}
	
	public boolean insert(String empIdInput,
			String firstName,
			String lastName,
			String midName,
			String street,
			String city,
			int stateId,
			String zipcode,
			int countryId,
			String positionType,
			Date hiredDate,
			String salary,
			int workTimeId,
			String email,
			String mobile,
			String homeNumber,
			int clearanceLvId,
			int contractId,
			int departmentId,
			String program,
			String programManager,
			String pocPhone,
			Date evaluationDate,
			String taxInfo,
			String courtOrder,
			String county,
			String courtAddress,
			int amount,
			Date terminationDate,
			boolean rehire,
			boolean notHire,
			int terminationReasonId,
			String createUser		
			) throws SQLException {
		// public boolean Insert(Hrm_Requisition hrmRequisition) throws
		// SQLException {
		boolean isOk = true;
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("hrm_employee_insert (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			this.m_objData.Parameters.setString(1, empIdInput);
			this.m_objData.Parameters.setString(2, firstName);
			this.m_objData.Parameters.setString(3, lastName);
			this.m_objData.Parameters.setString(4, midName);
			this.m_objData.Parameters.setString(5, street);
			this.m_objData.Parameters.setString(6, city);
			this.m_objData.Parameters.setInt(7, stateId);
			this.m_objData.Parameters.setString(8, zipcode);
			this.m_objData.Parameters.setString(9, positionType);
			this.m_objData.Parameters.setInt(10, countryId);
			this.m_objData.Parameters.setTimestamp(11, hiredDate == null ? null : ConvertCore.ConvertToSqlTimestamp(hiredDate));
			this.m_objData.Parameters.setString(12, salary);
			this.m_objData.Parameters.setInt(13, workTimeId);
			this.m_objData.Parameters.setString(14, email);
			this.m_objData.Parameters.setString(15, mobile);
			this.m_objData.Parameters.setString(16, homeNumber);
			this.m_objData.Parameters.setInt(17, clearanceLvId);
			this.m_objData.Parameters.setInt(18, contractId);
			this.m_objData.Parameters.setInt(19, departmentId);
			this.m_objData.Parameters.setString(20, program);
			this.m_objData.Parameters.setString(21, programManager);
			this.m_objData.Parameters.setString(22, pocPhone);
			this.m_objData.Parameters.setTimestamp(23, evaluationDate == null ? null : ConvertCore.ConvertToSqlTimestamp(evaluationDate));
			this.m_objData.Parameters.setString(24, taxInfo);
			this.m_objData.Parameters.setString(25, courtOrder);
			this.m_objData.Parameters.setString(26, county);
			this.m_objData.Parameters.setString(27, courtAddress);
			this.m_objData.Parameters.setInt(28, amount);
			this.m_objData.Parameters.setTimestamp(29, terminationDate == null ? null : ConvertCore.ConvertToSqlTimestamp(terminationDate));
			this.m_objData.Parameters.setBoolean(30, rehire);
			this.m_objData.Parameters.setBoolean(31, notHire);
			this.m_objData.Parameters.setInt(32, terminationReasonId);
			this.m_objData.Parameters.setString(33, createUser);

			this.m_objData.ExecNoneQuery();
			isOk = true;

		} catch (Exception e) {
			isOk = false;
			ILog.Error("EmployeeDAO - Insert: ", this, e);
			e.printStackTrace();
		} finally {
			this.TryDisconnect();
		}

		return isOk;
	}

}
