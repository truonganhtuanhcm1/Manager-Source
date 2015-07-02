package erp.module.hrm.service;

import java.sql.SQLException;
import java.util.List;

import erp.core.database.BUS;
import erp.core.log.ILog;
import erp.module.hrm.dao.Hrm_WorkTimeDAO;
import erp.module.hrm.model.Hrm_Work_Time;

public class Hrm_WorkTimeService extends BUS {

	public List<Hrm_Work_Time> getAll() {

		List<Hrm_Work_Time> lstResult = null;
		try {
			lstResult = new Hrm_WorkTimeDAO(this.m_objData).getAll();
		} catch (SQLException e) {
			ILog.Debug(e.getMessage(), this);
		}
		return lstResult;
	}
}
