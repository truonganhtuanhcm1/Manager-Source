package erp.module.user.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import erp.core.database.BUS;
import erp.core.log.ILog;
import erp.module.user.dao.UserDao;
import erp.module.user.model.User;

public class UserService extends BUS {

	public User Login(String _strUsername, String _strPassword) {

		User userLogin = null;
		try {
			userLogin = new UserDao(this.m_objData).getUser(_strUsername);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ILog.Debug("username=" + _strUsername, this);
		ILog.Debug("password=" + _strPassword, this);
		if (userLogin == null)
			return null;// Login failed
		else {
			if (!userLogin.getPassword().equals(_strPassword))
				return null;// Login failed
		}
		// Load permissions
		PermissionService pService = new PermissionService();

		userLogin.setLstPermission(pService.getByGroupId("",
				String.valueOf(userLogin.getGroup_id())));

		return userLogin;

	}

	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		User userLogin = null;
		try {
			userLogin = new UserDao(this.m_objData).getUserByEmail(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ILog.Debug("email=" + email, this);
		if (userLogin == null)
			return null;// Login failed

		return userLogin;
	}

	public boolean Update(User userForgot) {
		// TODO Auto-generated method stub
		try {
			new UserDao(this.m_objData).update(userForgot);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}

	public List<User> Search(String keyword, int group_id, String ClientType,
			String status_id) {
		// TODO Auto-generated method stub
		try {
			return new UserDao(this.m_objData).Search(keyword, group_id,
					ClientType, status_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	public User GetByUsername(String username) {
		// TODO Auto-generated method stub
		try {
			return new UserDao(this.m_objData).getUser(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean UpdateFull(String user_name, String client_id,
			String contact_id, String email, String group_id,
			String client_type_id, String status_id, String first_name,
			String last_name, Date dBirthDate, String phone, String address,
			String udpate_user) throws SQLException {

		this.BeginTran();
		try {
			UserDao usrDao = new UserDao(this.m_objData);
			boolean isOk = true;

			isOk &= usrDao.UpdateUserInfo(user_name, email, status_id,
					udpate_user);
			if (!isOk) {
				this.RollbackTran();
				return false;
			}
			isOk &= usrDao.UpdateClientInfo(client_id, client_type_id,
					group_id, udpate_user);
			if (!isOk) {
				this.RollbackTran();
				return false;
			}
			isOk &= usrDao.UpdateContactInfo(contact_id, email, phone, address,
					udpate_user);
			if (!isOk) {
				this.RollbackTran();
				return false;
			}
			isOk &= usrDao.UpdatePersonInfo(client_id, first_name, last_name,
					dBirthDate, udpate_user);
			if (!isOk) {
				this.RollbackTran();
				return false;
			}

			this.CommitTran();

			return isOk;
		} catch (Exception e) {
			ILog.Error("UpdateFull User", this, e);
		}

		return false;
	}

	public boolean Delete(String user_name, String delete_user) {
		// TODO Auto-generated method stub
		try {
			return new UserDao(this.m_objData).Delete(user_name, delete_user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Error("Delete group error", this, e);
		}
		return false;
	}

	public boolean InsertFull(String user_name, String password, String email,
			String group_id, String client_type_id, String status_id,
			String first_name, String last_name, Date dBirthDate, String phone,
			String address, String create_user) throws SQLException {
		// TODO Auto-generated method stub
		this.BeginTran();
		try {
			UserDao usrDao = new UserDao(this.m_objData);
			boolean isOk = true;

			String client_id = usrDao.InsertClientInfo(client_type_id,
					group_id, create_user);

			if (client_id == null) {
				this.RollbackTran();
				return false;
			}

			if (client_id.equals("")) {
				this.RollbackTran();
				return false;
			}

			isOk &= usrDao.InsertUserInfo(client_id, user_name, password,
					email, status_id, create_user);
			if (!isOk) {
				this.RollbackTran();
				return false;
			}

			isOk &= usrDao.InsertContactInfo(client_id, email, phone, address,
					create_user);
			if (!isOk) {
				this.RollbackTran();
				return false;
			}
			isOk &= usrDao.InsertPersonInfo(client_id, first_name, last_name,
					dBirthDate, create_user);
			if (!isOk) {
				this.RollbackTran();
				return false;
			}

			this.CommitTran();

			return isOk;
		} catch (Exception e) {
			ILog.Error("InsertFull User", this, e);
		}

		return false;
	}
}
