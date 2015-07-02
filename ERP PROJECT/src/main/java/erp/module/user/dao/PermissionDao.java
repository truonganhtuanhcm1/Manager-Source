package erp.module.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import erp.core.database.DAO;
import erp.core.database.IData;
import erp.core.database.ResultSetMapper;
import erp.module.user.model.Permission;

public class PermissionDao extends DAO {

	public PermissionDao(IData objData) {
		super(objData);
		// TODO Auto-generated constructor stub
	}

	public List<Permission> getByGroupId(String keyword, String group_id)
			throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("sys_permission_getByGroupID(?,?)");
			this.m_objData.Parameters.setString(1, keyword);
			this.m_objData.Parameters.setString(2, group_id);

			ResultSetMapper util = new ResultSetMapper<Permission>();

			ResultSet lstResult = this.m_objData.ExecToResultSet();

			List<Permission> lstUser = util.mapRersultSetToObject(lstResult,
					Permission.class);

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

	public void add_permission(String group_id, String permission_id)
			throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("sys_permission_group_add(?,?)");
			this.m_objData.Parameters.setString(1, group_id);
			this.m_objData.Parameters.setString(2, permission_id);

			this.m_objData.ExecNoneQuery();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			this.TryDisconnect();
		}
	}

	public void remove_permission(String group_id, String permission_id)
			throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("sys_permission_group_remove(?,?)");
			this.m_objData.Parameters.setString(1, group_id);
			this.m_objData.Parameters.setString(2, permission_id);

			this.m_objData.ExecNoneQuery();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			this.TryDisconnect();
		}
	}

}
