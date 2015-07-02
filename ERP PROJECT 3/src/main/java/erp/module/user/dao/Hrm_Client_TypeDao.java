package erp.module.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import erp.core.database.DAO;
import erp.core.database.IData;
import erp.core.database.ResultSetMapper;
import erp.module.user.model.Hrm_Client_Type;
import erp.module.user.model.User;

public class Hrm_Client_TypeDao extends DAO {

	public Hrm_Client_TypeDao(IData m_objData) {
		super(m_objData);
		// TODO Auto-generated constructor stub
	}

	public List<Hrm_Client_Type> getAll() throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("hrm_client_type_getall()");

			ResultSetMapper util = new ResultSetMapper<User>();

			ResultSet lstResult = this.m_objData.ExecToResultSet();

			List<Hrm_Client_Type> lstUser = util.mapRersultSetToObject(lstResult,
					Hrm_Client_Type.class);
			
			if(lstUser==null)
				return null;

			if (lstUser.size() > 0)
				return lstUser;
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
