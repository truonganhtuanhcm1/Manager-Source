package erp.module.user.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import erp.core.database.BUS;
import erp.core.log.ILog;
import erp.module.hrm.dao.Hrm_RecruitmentDao;
import erp.module.hrm.model.Hrm_Recruitment;
import erp.module.user.dao.GroupDao;
import erp.module.user.dao.UserDao;
import erp.module.user.model.Group;
import erp.module.user.model.User;

public class GroupService extends BUS {

	public List<Group> Search(String keyword) {
		// TODO Auto-generated method stub
		List<Group> lstResult = null;
		try {
			lstResult = new GroupDao(this.m_objData).Search(keyword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Error("Search group error", this, e);
		}
		
		return lstResult;
	}

	public boolean Delete(int id, String update_user) {
		// TODO Auto-generated method stub
		try {
			return new GroupDao(this.m_objData).Delete(id, update_user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Error("Delete group error", this, e);
		}

		return false;
	}

	public boolean Update(int id, String name, String description,
			String user_name) {
		// TODO Auto-generated method stub
		try {
			return new GroupDao(this.m_objData).Update(id, name, description,
					user_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Error("Delete group error", this, e);
		}
		return false;
	}

	public boolean Insert(String name, String description, String user_name) {
		// TODO Auto-generated method stub
		try {
			GroupDao gDAo= new GroupDao(this.m_objData);
			int newid = gDAo.GenID();
			return new GroupDao(this.m_objData).Insert(name, description,
					user_name,newid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Error("Delete group error", this, e);
		}
		return false;
	}
}
