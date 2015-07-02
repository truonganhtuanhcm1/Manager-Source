package erp.module.hrm.service;

import java.sql.SQLException;
import java.util.List;

import erp.core.database.BUS;
import erp.core.log.ILog;
import erp.module.hrm.dao.Hrm_Clearance_LevelDAO;
import erp.module.hrm.model.Hrm_Clearance_Level;

public class Hrm_Clearance_LevelService extends BUS {

	public List<Hrm_Clearance_Level> getAll() {

		List<Hrm_Clearance_Level> lstResult = null;
		try {
			lstResult = new Hrm_Clearance_LevelDAO(this.m_objData).getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Debug(e.getMessage(), this);
		}
		return lstResult;
	}
}
