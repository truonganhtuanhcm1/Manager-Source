package erp.module.hrm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import erp.core.ConvertCore;
import erp.core.database.DAO;
import erp.core.database.IData;
import erp.core.database.ResultSetMapper;
import erp.module.hrm.model.Hrm_Contract;
import erp.module.user.model.User;

public class Hrm_ContractDAO extends DAO {

	public Hrm_ContractDAO(IData objData) {
		super(objData);
		// TODO Auto-generated constructor stub
	}
	
	public List<Hrm_Contract> getAll() throws SQLException {

		try {

			this.TryConnect();
			this.m_objData.SetStoreName("hrm_contract_getAll()");

			ResultSetMapper util = new ResultSetMapper<User>();

			ResultSet rsResult = this.m_objData.ExecToResultSet();

			List<Hrm_Contract> lstResult = util.mapRersultSetToObject(rsResult, Hrm_Contract.class);
			
			if(lstResult==null)
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
	
	public List<Hrm_Contract> search(
			String contractIdInput,
			String contractNumber,
			String contractName,
			String modification,
			String value,
			Date startDate,
			Date endDate) throws SQLException {

		try {
			
			if (startDate == null){
				startDate = endDate;
			}
			else if (endDate == null){
				endDate = startDate;
			}
				
			this.TryConnect();
			this.m_objData.SetStoreName("hrm_contract_search(?,?,?,?,?,?,?)");
			this.m_objData.Parameters.setString(1, contractIdInput);
			this.m_objData.Parameters.setString(2, contractNumber);
			this.m_objData.Parameters.setString(3, contractName);
			this.m_objData.Parameters.setString(4, modification);
			this.m_objData.Parameters.setString(5, value);
			this.m_objData.Parameters.setTimestamp(6, startDate == null ? null : ConvertCore.ConvertToSqlTimestamp(startDate));
			this.m_objData.Parameters.setTimestamp(7, endDate == null ? null : ConvertCore.ConvertToSqlTimestamp(endDate));

			ResultSetMapper util = new ResultSetMapper<User>();

			ResultSet rsResult = this.m_objData.ExecToResultSet();

			List<Hrm_Contract> lstResult = util.mapRersultSetToObject(rsResult, Hrm_Contract.class);
			
			if(lstResult==null)
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
	
	public boolean Insert(
			String contractIdInput,
			String contractNumber, 
			String contractName, 
			String description,
			String modification,
			String value,
			Date startDate,
			Date endDate,
			String createUser
			) throws SQLException {
		try {
			this.TryConnect();

			this.m_objData.SetStoreName("hrm_contract_insert(?,?,?,?,?,?,?,?,?)");

			this.m_objData.Parameters.setString(1, contractIdInput);
			this.m_objData.Parameters.setString(2, contractNumber);
			this.m_objData.Parameters.setString(3, contractName);
			this.m_objData.Parameters.setString(4, description);
			this.m_objData.Parameters.setString(5, modification);
			this.m_objData.Parameters.setString(6, value);
			this.m_objData.Parameters.setTimestamp(7, ConvertCore.ConvertToSqlTimestamp(startDate));
			this.m_objData.Parameters.setTimestamp(8, ConvertCore.ConvertToSqlTimestamp(endDate));
			this.m_objData.Parameters.setString(9, createUser);
			
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
	
	public boolean update(int contractId,
			String contractIdInput,
			String contractNumber, 
			String contractName, 
			String description,
			String modification,
			String value,
			Date startDate,
			Date endDate,
			String updateUser
			) throws SQLException {
		try {
			this.TryConnect();

			this.m_objData.SetStoreName("hrm_contract_update(?,?,?,?,?,?,?,?,?,?)");
			this.m_objData.Parameters.setString(1, contractIdInput);
			this.m_objData.Parameters.setString(2, contractNumber);
			this.m_objData.Parameters.setString(3, contractName);
			this.m_objData.Parameters.setString(4, description);
			this.m_objData.Parameters.setString(5, modification);
			this.m_objData.Parameters.setString(6, value);
			this.m_objData.Parameters.setTimestamp(7, ConvertCore.ConvertToSqlTimestamp(startDate));
			this.m_objData.Parameters.setTimestamp(8, ConvertCore.ConvertToSqlTimestamp(endDate));
			this.m_objData.Parameters.setString(9, updateUser);
			this.m_objData.Parameters.setInt(10, contractId);
			
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
	
	public boolean delete(int contractId,
			String deleteUser
			) throws SQLException {
		try {
			this.TryConnect();

			this.m_objData.SetStoreName("hrm_contract_delete(?,?)");

			this.m_objData.Parameters.setInt(1, contractId);
			this.m_objData.Parameters.setString(2, deleteUser);
			this.m_objData.ExecNoneQuery();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			this.TryDisconnect();
		}

		return false;
	}
	
	public Hrm_Contract getById(int contractId) throws SQLException {

		try {

			this.TryConnect();
			this.m_objData.SetStoreName("hrm_contract_getById(?)");
			this.m_objData.Parameters.setInt(1, contractId);
			ResultSetMapper util = new ResultSetMapper<User>();
			ResultSet rsResult = this.m_objData.ExecToResultSet();
			List<Hrm_Contract> lstResult = util.mapRersultSetToObject(
					rsResult, Hrm_Contract.class);

			if (lstResult == null)
				return null;

			if (lstResult.size() > 0)
				return lstResult.get(0);

			return null;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.TryDisconnect();
		}

		return null;
	}


}
