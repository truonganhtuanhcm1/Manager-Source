package erp.module.hrm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import erp.core.database.DAO;
import erp.core.database.IData;
import erp.core.database.ResultSetMapper;
import erp.module.hrm.model.Hrm_Contract;
import erp.module.hrm.model.Hrm_Education;
import erp.module.user.model.User;

public class Hrm_EducationDAO extends DAO {

	public Hrm_EducationDAO(IData objData) {
		super(objData);
		// TODO Auto-generated constructor stub
	}

	public List<Hrm_Education> getAll() throws SQLException {

		try {

			this.TryConnect();
			this.m_objData.SetStoreName("hrm_education_getAll()");

			ResultSetMapper util = new ResultSetMapper<User>();

			ResultSet rsResult = this.m_objData.ExecToResultSet();

			List<Hrm_Education> lstResult = util.mapRersultSetToObject(rsResult, Hrm_Education.class);
			
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
