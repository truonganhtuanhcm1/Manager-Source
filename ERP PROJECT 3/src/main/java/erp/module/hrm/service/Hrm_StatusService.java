package erp.module.hrm.service;

import java.sql.SQLException;
import java.util.List;

import erp.core.database.BUS;
import erp.core.log.ILog;
import erp.module.hrm.dao.Hrm_StatusDAO;
import erp.module.hrm.model.Hrm_Status;

public class Hrm_StatusService extends BUS {
	
	public List<Hrm_Status> getAll() {

		List<Hrm_Status> lstResult = null;
		try {
			lstResult = new Hrm_StatusDAO(this.m_objData).getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Debug(e.getMessage(), this);
		}
		return lstResult;
	}

}
