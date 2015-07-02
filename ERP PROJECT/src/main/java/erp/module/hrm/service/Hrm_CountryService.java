package erp.module.hrm.service;

import java.sql.SQLException;
import java.util.List;

import erp.core.database.BUS;
import erp.core.log.ILog;
import erp.module.hrm.dao.Hrm_CountryDAO;
import erp.module.hrm.model.Hrm_Country;

public class Hrm_CountryService extends BUS {

	public List<Hrm_Country> getAll() {

		List<Hrm_Country> lstResult = null;
		try {
			lstResult = new Hrm_CountryDAO(this.m_objData).getAll();
			ILog.Debug("Contract list retrieved: " + lstResult.size(), this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Debug(e.getMessage(), this);
		}
		return lstResult;
	}
}
