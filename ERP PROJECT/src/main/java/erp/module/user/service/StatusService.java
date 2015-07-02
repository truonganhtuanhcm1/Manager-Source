package erp.module.user.service;

import java.sql.SQLException;
import java.util.List;

import erp.core.database.BUS;
import erp.core.log.ILog;
import erp.module.user.dao.StatusDao;
import erp.module.user.model.Status;

public class StatusService extends BUS {

	public List<Status> getAll() {
		// TODO Auto-generated method stub
		List<Status> lstResult = null;
		try {
			lstResult = new StatusDao(this.m_objData).GetAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Error("Search group error", this, e);
		}
		
		return lstResult;
	}

}
