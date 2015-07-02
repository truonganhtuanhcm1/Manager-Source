package erp.module.hrm.service;

import java.sql.SQLException;
import java.util.List;

import erp.core.database.BUS;
import erp.core.log.ILog;
import erp.module.hrm.dao.Hrm_RecruitmentTypeDao;
import erp.module.hrm.model.Hrm_RecruitmentType;

public class Hrm_RecruitmentTypeService extends BUS {
	
	public List<Hrm_RecruitmentType> getList() {
		// TODO Auto-generated method stub
		List<Hrm_RecruitmentType> lstResult = null;
		try {
			//Get data from DAO
			lstResult = new Hrm_RecruitmentTypeDao(this.m_objData).getList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ILog.Debug("Result size = " + lstResult.size(), this);
		return lstResult;
	}
	
}
