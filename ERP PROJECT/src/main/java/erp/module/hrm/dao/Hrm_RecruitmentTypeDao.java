package erp.module.hrm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import erp.core.database.DAO;
import erp.core.database.IData;
import erp.core.database.ResultSetMapper;
import erp.module.hrm.model.Hrm_RecruitmentType;
import erp.module.user.model.User;

public class Hrm_RecruitmentTypeDao extends DAO{

	public Hrm_RecruitmentTypeDao(IData m_objData) {
		super(m_objData);
		// TODO Auto-generated constructor stub
	}
	
	public List<Hrm_RecruitmentType> getList() throws SQLException {

		try {

			this.TryConnect();
//Get data from db
			this.m_objData.SetStoreName("hrm_recruitment_type_getList()");

			ResultSetMapper util = new ResultSetMapper<User>();

			ResultSet rsResult = this.m_objData.ExecToResultSet();
//map result to list object
			List<Hrm_RecruitmentType> lstResult = util.mapRersultSetToObject(rsResult,
					Hrm_RecruitmentType.class);
			
			if(lstResult==null)
				return null;

			if (lstResult.size() > 0)
				return lstResult;
			return null;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			this.TryDisconnect();
		}

		return null;
	}

}
