package erp.module.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import erp.core.database.DAO;
import erp.core.database.IData;
import erp.core.database.ResultSetMapper;
import erp.module.user.model.Status;
import erp.module.user.model.User;

public class StatusDao extends DAO {

	public StatusDao(IData objData) {
		super(objData);
		// TODO Auto-generated constructor stub
	}

	public List<Status> GetAll() throws SQLException {
		// TODO Auto-generated method stub
		try {

			this.TryConnect();

			this.m_objData.SetStoreName("sys_status_getAll()");

			ResultSetMapper util = new ResultSetMapper<User>();

			ResultSet lstResult = this.m_objData.ExecToResultSet();

			List<Status> lstUser = util.mapRersultSetToObject(lstResult,
					Status.class);

			if (lstUser == null)
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
