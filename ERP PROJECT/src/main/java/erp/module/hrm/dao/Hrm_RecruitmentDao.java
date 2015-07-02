package erp.module.hrm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import erp.core.ConvertCore;
import erp.core.database.DAO;
import erp.core.database.IData;
import erp.core.database.ResultSetMapper;
import erp.module.hrm.model.Hrm_Recruitment;
import erp.module.user.model.User;

public class Hrm_RecruitmentDao extends DAO {

	public Hrm_RecruitmentDao(IData m_objData) {
		super(m_objData);
		// TODO Auto-generated constructor stub
	}

	public boolean Insert(int positionID, int recruitment_type_id,
			String title, Date expDate, boolean status, String description,
			String requirement, String user_name) throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData
					.SetStoreName("hrm_recruitment_insert(?,?,?,?,?,?,?,?)");

			this.m_objData.Parameters.setInt(1, positionID);
			this.m_objData.Parameters.setString(2, title);
			this.m_objData.Parameters.setDate(3,
					ConvertCore.ConvertToSqlDate(expDate));
			this.m_objData.Parameters.setBoolean(4, status);
			this.m_objData.Parameters.setString(5, description);
			this.m_objData.Parameters.setString(6, requirement);
			this.m_objData.Parameters.setString(7, user_name);
			this.m_objData.Parameters.setInt(8, recruitment_type_id);

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

	public List<Hrm_Recruitment> Search(int iPosistion_id, int iType_id, int iStatus_id, Date dtFrom_date, Date dtTo_date) throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("hrm_recruitment_search(?,?,?,?,?)");
			this.m_objData.Parameters.setInt(1, iPosistion_id);
			this.m_objData.Parameters.setInt(2, iType_id);
			this.m_objData.Parameters.setInt(3, iStatus_id);
			this.m_objData.Parameters.setDate(4,ConvertCore.ConvertToSqlDate(dtFrom_date));
			this.m_objData.Parameters.setDate(5,ConvertCore.ConvertToSqlDate(dtTo_date));

			ResultSetMapper util = new ResultSetMapper<User>();

			ResultSet rsResult = this.m_objData.ExecToResultSet();

			List<Hrm_Recruitment> lstResult = util.mapRersultSetToObject(
					rsResult, Hrm_Recruitment.class);

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

	public boolean UpdateStatus(int id, int status, String user_name) throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("hrm_recruitment_updateStatus(?,?,?)");

			this.m_objData.Parameters.setInt(1, id);
			this.m_objData.Parameters.setBoolean(2, status == 1);
			this.m_objData.Parameters.setString(3, user_name);

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

	public boolean Delete(int id, String user_name) throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("hrm_recruitment_delete(?,?)");

			this.m_objData.Parameters.setInt(1, id);
			this.m_objData.Parameters.setString(2, user_name);

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

	public Hrm_Recruitment GetByID(int id) throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("hrm_recruitment_getById(?)");
			this.m_objData.Parameters.setInt(1, id);

			ResultSetMapper util = new ResultSetMapper<User>();

			ResultSet lstResult = this.m_objData.ExecToResultSet();

			List<Hrm_Recruitment> lstUser = util.mapRersultSetToObject(lstResult,
					Hrm_Recruitment.class);
			
			if(lstUser==null)
				return null;

			if (lstUser.size() > 0)
				return lstUser.get(0);
			return null;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			this.TryDisconnect();
		}

		return null;
	}

	public boolean Update(int id, int positionID, int recruitment_type_id,
			String title, Date expDate, boolean status, String description,
			String requirement, String user_name) throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData
					.SetStoreName("hrm_recruitment_update(?,?,?,?,?,?,?,?,?)");

			this.m_objData.Parameters.setInt(1, id);
			this.m_objData.Parameters.setInt(2, positionID);
			this.m_objData.Parameters.setString(3, title);
			this.m_objData.Parameters.setDate(4,
					ConvertCore.ConvertToSqlDate(expDate));
			this.m_objData.Parameters.setBoolean(5, status);
			this.m_objData.Parameters.setString(6, description);
			this.m_objData.Parameters.setString(7, requirement);
			this.m_objData.Parameters.setString(8, user_name);
			this.m_objData.Parameters.setInt(9, recruitment_type_id);

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
