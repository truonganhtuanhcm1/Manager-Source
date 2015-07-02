package erp.module.hrm.service;

import java.sql.SQLException;
import java.util.List;

import erp.core.database.BUS;
import erp.core.log.ILog;
import erp.module.hrm.dao.Hrm_ClientGroupDao;
import erp.module.hrm.model.Hrm_Client_Group;

public class Hrm_ClientGroupService extends BUS{
	
	public List<Hrm_Client_Group> getList() {
		// TODO Auto-generated method stub
		List<Hrm_Client_Group> lstResult = null;
		try {
			lstResult = new Hrm_ClientGroupDao(this.m_objData).getList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ILog.Debug("Result size = " + lstResult.size(), this);
		return lstResult;
	}
	
}
