package erp.module.hrm.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import erp.core.database.BUS;
import erp.core.log.ILog;
import erp.module.hrm.dao.Hrm_RecruitmentDao;
import erp.module.hrm.model.Hrm_Recruitment;

public class Hrm_RecruitmentService extends BUS {

	public boolean Insert(int positionID, int recruitment_type_id,
			String title, Date expDate, boolean status, String description,
			String requirement, String user_name) {
		// TODO Auto-generated method stub

		Hrm_RecruitmentDao reDao = new Hrm_RecruitmentDao(this.m_objData);

		try {
			return reDao.Insert(positionID, recruitment_type_id, title,
					expDate, status, description, requirement, user_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ILog.Error("Hrm_RecruitmentDao Insert", this, e);
			e.printStackTrace();
		}
		return false;

	}

	public List<Hrm_Recruitment> Search(int iPosistion_id, int iType_id,
			int iStatus_id, Date dtFrom_date, Date dtTo_date) {
		// TODO Auto-generated method stub
		List<Hrm_Recruitment> lstResult = null;
		try {
			lstResult = new Hrm_RecruitmentDao(this.m_objData)
					.Search(iPosistion_id, iType_id, iStatus_id, dtFrom_date,
							dtTo_date);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ILog.Debug("Result size = " + lstResult.size(), this);
		return lstResult;
	}

	public boolean UpdateStatus(int id, int status, String user_name)
			throws SQLException {
		// TODO Auto-generated method stub

		Hrm_RecruitmentDao reDAo = new Hrm_RecruitmentDao(m_objData);

		return reDAo.UpdateStatus(id, status, user_name);

	}

	public boolean Delete(int id, String user_name) throws SQLException {
		// TODO Auto-generated method stub

		Hrm_RecruitmentDao reDAo = new Hrm_RecruitmentDao(m_objData);

		return reDAo.Delete(id, user_name);

	}

	public Hrm_Recruitment GetByID(int id) throws SQLException {
		// TODO Auto-generated method stub
		Hrm_RecruitmentDao reDAo = new Hrm_RecruitmentDao(m_objData);

		return reDAo.GetByID(id);
	}

	public boolean Update(int id, int positionID, int recruitment_type_id,
			String title, Date expDate, boolean status, String description,
			String requirement, String user_name) {
		// TODO Auto-generated method stub
		Hrm_RecruitmentDao reDao = new Hrm_RecruitmentDao(this.m_objData);

		try {
			return reDao.Update(id, positionID, recruitment_type_id, title,
					expDate, status, description, requirement, user_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ILog.Error("Hrm_RecruitmentDao Insert", this, e);
			e.printStackTrace();
		}
		return false;
	}

}
