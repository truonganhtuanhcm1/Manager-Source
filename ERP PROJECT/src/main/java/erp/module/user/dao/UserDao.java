package erp.module.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import erp.core.ConvertCore;
import erp.core.database.DAO;
import erp.core.database.IData;
import erp.core.database.ResultSetMapper;
import erp.core.log.ILog;
import erp.module.user.model.User;

public class UserDao extends DAO {

	public UserDao(IData m_objData) {
		super(m_objData);
		// TODO Auto-generated constructor stub
	}

	public User getUser(String username) throws SQLException {

		try {

			this.TryConnect();

			this.m_objData.SetStoreName("sys_user_getByUsername(?)");
			this.m_objData.Parameters.setString(1, username);

			ResultSetMapper util = new ResultSetMapper<User>();

			ResultSet lstResult = this.m_objData.ExecToResultSet();

			List<User> lstUser = util.mapRersultSetToObject(lstResult,
					User.class);

			if (lstUser == null)
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

	public User getUserByEmail(String email) throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("sys_user_getByEmail(?)");
			this.m_objData.Parameters.setString(1, email);

			ResultSetMapper util = new ResultSetMapper<User>();

			ResultSet lstResult = this.m_objData.ExecToResultSet();

			List<User> lstUser = util.mapRersultSetToObject(lstResult,
					User.class);

			if (lstUser == null)
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

	public void update(User userForgot) throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("sys_user_update(?,?,?,?,?,?,?)");
			this.m_objData.Parameters.setString(1, userForgot.getUser_name());
			this.m_objData.Parameters.setString(2, userForgot.getPassword());
			this.m_objData.Parameters.setString(3,
					userForgot.getPassword_hint());
			this.m_objData.Parameters.setString(4, userForgot.getClient_id());
			this.m_objData.Parameters.setInt(5, userForgot.getStatus_id());
			this.m_objData.Parameters.setString(6, userForgot.getUpdate_user());
			this.m_objData.Parameters.setString(7, userForgot.getForgot_key());

			this.m_objData.ExecNoneQuery();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			this.TryDisconnect();
		}
	}

	public List<User> Search(String keyword, int group_id, String ClientType,
			String status_id) throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("sys_user_search(?,?,?,?)");

			this.m_objData.Parameters.setString(1, keyword);
			this.m_objData.Parameters.setInt(2, group_id);
			this.m_objData.Parameters.setString(3, ClientType);
			this.m_objData.Parameters.setString(4, status_id);

			ResultSetMapper util = new ResultSetMapper<User>();

			ResultSet lstResult = this.m_objData.ExecToResultSet();

			List<User> lstUser = util.mapRersultSetToObject(lstResult,
					User.class);

			if (lstUser == null)
				return null;

			if (lstUser.size() > 0)
				return lstUser;
			return null;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			this.TryDisconnect();
		}

		return null;
	}

	public boolean UpdateFull(String user_name, String email, String group_id,
			String client_type_id, String first_name, String last_name,
			Date dBirthDate, String phone, String address, String udpate_user)
			throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData
					.SetStoreName("sys_user_updateFull(?,?,?,?,?,?,?,?,?,?)");
			this.m_objData.Parameters.setString(1, user_name);
			this.m_objData.Parameters.setString(2, email);
			this.m_objData.Parameters.setString(3, group_id);
			this.m_objData.Parameters.setString(4, client_type_id);
			this.m_objData.Parameters.setString(5, first_name);
			this.m_objData.Parameters.setString(6, last_name);
			this.m_objData.Parameters.setDate(7,
					ConvertCore.ConvertToSqlDate(dBirthDate));
			this.m_objData.Parameters.setString(8, phone);
			this.m_objData.Parameters.setString(9, address);
			this.m_objData.Parameters.setString(10, udpate_user);

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

	public boolean UpdateUserInfo(String user_name, String email,
			String status_id, String udpate_user) throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("sys_user_UpdateUserInfo(?,?,?,?)");
			this.m_objData.Parameters.setString(1, user_name);
			this.m_objData.Parameters.setString(2, email);
			this.m_objData.Parameters.setString(3, status_id);
			this.m_objData.Parameters.setString(4, udpate_user);

			this.m_objData.ExecNoneQuery();
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Error("sys_user_UpdateUserInfo error", this, e);
		} finally {

			this.TryDisconnect();
		}
		return false;
	}

	public boolean UpdateClientInfo(String client_id, String client_type_id,
			String group_id, String udpate_user) throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("hrm_client_UpdateClientInfo(?,?,?,?)");
			this.m_objData.Parameters.setString(1, client_id);
			this.m_objData.Parameters.setString(2, client_type_id);
			this.m_objData.Parameters.setString(3, group_id);
			this.m_objData.Parameters.setString(4, udpate_user);

			this.m_objData.ExecNoneQuery();
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Error("hrm_client_UpdateClientInfo error", this, e);
		} finally {

			this.TryDisconnect();
		}
		return false;
	}

	public boolean UpdateContactInfo(String contact_id, String email,
			String phone, String address, String udpate_user)
			throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData
					.SetStoreName("hrm_contact_UpdateContactInfo(?,?,?,?,?)");
			this.m_objData.Parameters.setString(1, contact_id);
			this.m_objData.Parameters.setString(2, email);
			this.m_objData.Parameters.setString(3, phone);
			this.m_objData.Parameters.setString(4, address);
			this.m_objData.Parameters.setString(5, udpate_user);

			this.m_objData.ExecNoneQuery();
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Error("hrm_contact_UpdateContactInfo error", this, e);
		} finally {

			this.TryDisconnect();
		}
		return false;
	}

	public boolean UpdatePersonInfo(String client_id, String first_name,
			String last_name, Date dBirthDate, String udpate_user)
			throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData
					.SetStoreName("hrm_person_UpdatePersonInfo(?,?,?,?,?)");
			this.m_objData.Parameters.setString(1, client_id);
			this.m_objData.Parameters.setString(2, first_name);
			this.m_objData.Parameters.setString(3, last_name);
			this.m_objData.Parameters.setDate(4,
					ConvertCore.ConvertToSqlDate(dBirthDate));
			this.m_objData.Parameters.setString(5, udpate_user);

			this.m_objData.ExecNoneQuery();
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Error("hrm_person_UpdatePersonInfo error", this, e);
		} finally {

			this.TryDisconnect();
		}
		return false;
	}

	public boolean Delete(String user_name, String delete_user)
			throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("sys_user_delete(?,?)");
			this.m_objData.Parameters.setString(1, user_name);
			this.m_objData.Parameters.setString(2, delete_user);

			this.m_objData.ExecNoneQuery();
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Error("hrm_person_UpdatePersonInfo error", this, e);
		} finally {

			this.TryDisconnect();
		}
		return false;
	}

	public String InsertClientInfo(String client_type_id, String group_id,
			String create_user) throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("hrm_client_InsertClientInfo(?,?,?)");
			this.m_objData.Parameters.setString(1, client_type_id);
			this.m_objData.Parameters.setString(2, group_id);
			this.m_objData.Parameters.setString(3, create_user);

			return this.m_objData.ExecToString();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Error("hrm_client_InsertClientInfo error", this, e);
		} finally {

			this.TryDisconnect();
		}
		return "";
	}

	public boolean InsertUserInfo(String client_id, String user_name,
			String password, String email, String status_id, String create_user)
			throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("sys_user_InsertUserInfo(?,?,?,?,?,?)");
			this.m_objData.Parameters.setString(1, client_id);
			this.m_objData.Parameters.setString(2, user_name);
			this.m_objData.Parameters.setString(3, password);
			this.m_objData.Parameters.setString(4, email);
			this.m_objData.Parameters.setString(5, status_id);
			this.m_objData.Parameters.setString(6, create_user);

			this.m_objData.ExecNoneQuery();
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Error("sys_user_InsertUserInfo error", this, e);
		} finally {

			this.TryDisconnect();
		}
		return false;
	}

	public boolean InsertContactInfo(String client_id, String email,
			String phone, String address, String create_user)
			throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData
					.SetStoreName("hrm_contact_InsertContactInfo(?,?,?,?,?)");
			this.m_objData.Parameters.setString(1, client_id);
			this.m_objData.Parameters.setString(2, email);
			this.m_objData.Parameters.setString(3, phone);
			this.m_objData.Parameters.setString(4, address);
			this.m_objData.Parameters.setString(5, create_user);

			this.m_objData.ExecNoneQuery();
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Error("hrm_contact_UpdateContactInfo error", this, e);
		} finally {

			this.TryDisconnect();
		}
		return false;
	}

	public boolean InsertPersonInfo(String client_id, String first_name,
			String last_name, Date dBirthDate, String create_user)
			throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData
					.SetStoreName("hrm_person_InsertPersonInfo(?,?,?,?,?)");
			this.m_objData.Parameters.setString(1, client_id);
			this.m_objData.Parameters.setString(2, first_name);
			this.m_objData.Parameters.setString(3, last_name);
			this.m_objData.Parameters.setDate(4,
					ConvertCore.ConvertToSqlDate(dBirthDate));
			this.m_objData.Parameters.setString(5, create_user);

			this.m_objData.ExecNoneQuery();
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Error("hrm_person_InsertPersonInfo error", this, e);
		} finally {

			this.TryDisconnect();
		}
		return false;
	}
}
