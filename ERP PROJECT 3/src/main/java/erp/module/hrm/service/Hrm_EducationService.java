package erp.module.hrm.service;

import java.sql.SQLException;
import java.util.List;

import erp.core.database.BUS;
import erp.core.log.ILog;
import erp.module.hrm.dao.Hrm_EducationDAO;
import erp.module.hrm.model.Hrm_Education;

public class Hrm_EducationService extends BUS {

	public List<Hrm_Education> getAll() {

		List<Hrm_Education> lstResult = null;
		try {
			lstResult = new Hrm_EducationDAO(m_objData).getAll();
			ILog.Debug("Position list retrieved: " + lstResult.size(), this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Debug(e.getMessage(), this);
		}
		return lstResult;
	}
}
