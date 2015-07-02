package erp.module.user.service;

import java.sql.SQLException;
import java.util.List;

import erp.core.database.BUS;
import erp.core.log.ILog;
import erp.module.user.dao.PermissionDao;
import erp.module.user.model.Permission;

public class PermissionService extends BUS {

	public List<Permission> getByGroupId(String keyword, String group_id) {
		// TODO Auto-generated method stub
		ILog.Debug("Get permission of " + group_id, this);
		List<Permission> lstResult = null;
		try {
			lstResult = new PermissionDao(this.m_objData).getByGroupId(keyword,
					group_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Error("Search group error", this, e);
		}

		return lstResult;
	}

	public void add_permission(String group_id, String permission_id) {
		// TODO Auto-generated method stub
		try {
			new PermissionDao(this.m_objData).add_permission(group_id,
					permission_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Error("add_permission error", this, e);
		}
	}

	public void remove_permission(String group_id, String permission_id) {
		// TODO Auto-generated method stub
		try {
			new PermissionDao(this.m_objData).remove_permission(group_id,
					permission_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Error("add_permission error", this, e);
		}
	}

}
