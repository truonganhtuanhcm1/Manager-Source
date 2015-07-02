package erp.module.hrm.service;

import java.sql.SQLException;
import java.util.List;

import erp.core.database.BUS;
import erp.core.log.ILog;
import erp.module.hrm.dao.Hrm_PositionDAO;
import erp.module.hrm.model.Hrm_Position;

public class Hrm_PositionService extends BUS {

	public List<Hrm_Position> getAll() {

		List<Hrm_Position> lstResult = null;
		try {
			lstResult = new Hrm_PositionDAO(this.m_objData).getAll();
			ILog.Debug("Position list retrieved: " + lstResult.size(), this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Debug(e.getMessage(), this);
		}
		return lstResult;
	}
}
