package erp.module.hrm.service;

import java.sql.SQLException;
import java.util.List;

import erp.core.database.BUS;
import erp.core.log.ILog;
import erp.module.hrm.dao.Hrm_DepartmentDAO;
import erp.module.hrm.model.Hrm_Department;

public class Hrm_DepartmentService extends BUS {
	public List<Hrm_Department> getAll() {

		List<Hrm_Department> lstResult = null;
		try {
			lstResult = new Hrm_DepartmentDAO(this.m_objData).getAll();
			ILog.Debug("Contract list retrieved: " + lstResult.size(), this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Debug(e.getMessage(), this);
		}
		return lstResult;
	}
}
