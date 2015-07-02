package erp.module.hrm.service;

import java.sql.SQLException;
import java.util.List;

import erp.core.database.BUS;
import erp.core.log.ILog;
import erp.module.hrm.dao.Hrm_TerminationReasonDAO;
import erp.module.hrm.model.Hrm_Termination_Reason;

public class Hrm_TerminationReasonService extends BUS {

	public List<Hrm_Termination_Reason> getAll() {

		List<Hrm_Termination_Reason> lstResult = null;
		try {
			lstResult = new Hrm_TerminationReasonDAO(this.m_objData).getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ILog.Debug(e.getMessage(), this);
		}
		return lstResult;
	}
}
