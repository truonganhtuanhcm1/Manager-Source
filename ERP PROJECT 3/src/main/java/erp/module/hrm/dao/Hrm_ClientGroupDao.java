package erp.module.hrm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import erp.core.database.DAO;
import erp.core.database.IData;
import erp.core.database.ResultSetMapper;
import erp.module.hrm.model.Hrm_Client_Group;
import erp.module.user.model.User;

public class Hrm_ClientGroupDao extends DAO{

	public Hrm_ClientGroupDao(IData m_objData) {
		super(m_objData);
		// TODO Auto-generated constructor stub
	}

	public List<Hrm_Client_Group> getList() throws SQLException {

		try {

			this.TryConnect();

			this.m_objData.SetStoreName("hrm_client_group_getList()");

			ResultSetMapper util = new ResultSetMapper<User>();

			ResultSet rsResult = this.m_objData.ExecToResultSet();

			List<Hrm_Client_Group> lstResult = util.mapRersultSetToObject(rsResult,
					Hrm_Client_Group.class);
			
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
