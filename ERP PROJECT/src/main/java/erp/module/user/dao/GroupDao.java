package erp.module.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import erp.core.database.DAO;
import erp.core.database.IData;
import erp.core.database.ResultSetMapper;
import erp.module.user.model.Group;
import erp.module.user.model.User;

public class GroupDao extends DAO {

	public GroupDao(IData m_objData) {
		super(m_objData);
		// TODO Auto-generated constructor stub
	}

	public List<Group> Search(String keyword) throws SQLException {

		try {

			this.TryConnect();

			this.m_objData.SetStoreName("sys_group_getAll(?)");
			this.m_objData.Parameters.setString(1, keyword);

			ResultSetMapper util = new ResultSetMapper<User>();

			ResultSet lstResult = this.m_objData.ExecToResultSet();

			List<Group> lstUser = util.mapRersultSetToObject(lstResult,
					Group.class);

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

	public boolean Delete(int id, String username) throws SQLException {

		try {

			this.TryConnect();

			this.m_objData.SetStoreName("sys_group_delete(?,?)");
			this.m_objData.Parameters.setInt(1, id);
			this.m_objData.Parameters.setString(2, username);

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

	public boolean Update(int id, String name, String description,
			String user_name) throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("sys_group_update(?,?,?,?)");
			this.m_objData.Parameters.setInt(1, id);
			this.m_objData.Parameters.setString(2, name);
			this.m_objData.Parameters.setString(3, description);
			this.m_objData.Parameters.setString(4, user_name);

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

	public boolean Insert(String name, String description, String user_name,int group_id)
			throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("sys_group_insert(?,?,?,?)");
			this.m_objData.Parameters.setString(1, name);
			this.m_objData.Parameters.setString(2, description);
			this.m_objData.Parameters.setString(3, user_name);
			this.m_objData.Parameters.setInt(4, group_id);

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

	public int GenID() throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("sys_group_genid()");

			String strID = this.m_objData.ExecToString();

			return Integer.parseInt(strID);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		} finally {

			this.TryDisconnect();
		}

	}

}
