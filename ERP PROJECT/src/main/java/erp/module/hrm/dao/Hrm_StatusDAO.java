package erp.module.hrm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import erp.core.database.DAO;
import erp.core.database.IData;
import erp.core.database.ResultSetMapper;
import erp.module.hrm.model.Hrm_Status;
import erp.module.user.model.User;

public class Hrm_StatusDAO extends DAO {

	public Hrm_StatusDAO(IData objData) {
		super(objData);
		// TODO Auto-generated constructor stub
	}
	
	public List<Hrm_Status> getAll() throws SQLException {

		try {

			this.TryConnect();
			this.m_objData.SetStoreName("hrm_status_getAll()");

			ResultSetMapper util = new ResultSetMapper<User>();

			ResultSet rsResult = this.m_objData.ExecToResultSet();

			List<Hrm_Status> lstResult = util.mapRersultSetToObject(rsResult, Hrm_Status.class);
			
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
