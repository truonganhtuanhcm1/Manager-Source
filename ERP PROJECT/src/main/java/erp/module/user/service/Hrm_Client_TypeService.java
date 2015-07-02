package erp.module.user.service;

import java.sql.SQLException;
import java.util.List;

import erp.core.database.BUS;
import erp.module.user.dao.Hrm_Client_TypeDao;
import erp.module.user.model.Hrm_Client_Type;

public class Hrm_Client_TypeService extends BUS{

	public List<Hrm_Client_Type> getAll() {
		// TODO Auto-generated method stub
		try {
			return new Hrm_Client_TypeDao(this.m_objData).getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
