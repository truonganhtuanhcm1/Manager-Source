package erp.module.hrm.service;

import java.sql.SQLException;
import java.util.List;

import erp.core.database.BUS;
import erp.core.log.ILog;
import erp.module.hrm.dao.Hrm_StateDAO;
import erp.module.hrm.model.Hrm_State;

public class Hrm_StateService extends BUS {
	public List<Hrm_State> getAll() {

		List<Hrm_State> lstResult = null;
		try {
			lstResult = new Hrm_StateDAO(this.m_objData).getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Debug(e.getMessage(), this);
		}
		return lstResult;
	}
}
