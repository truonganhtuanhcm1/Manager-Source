package erp.module.hrm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import erp.core.database.DAO;
import erp.core.database.IData;
import erp.core.database.ResultSetMapper;
import erp.module.hrm.model.Hrm_City;
import erp.module.user.model.User;

public class Hrm_CityDAO extends DAO {

	public Hrm_CityDAO(IData objData) {
		super(objData);
		// TODO Auto-generated constructor stub
	}
	
	public List<Hrm_City> getAll() throws SQLException {

		try {

			this.TryConnect();
			this.m_objData.SetStoreName("hrm_city_getAll()");

			ResultSetMapper util = new ResultSetMapper<User>();

			ResultSet rsResult = this.m_objData.ExecToResultSet();

			List<Hrm_City> lstResult = util.mapRersultSetToObject(rsResult, Hrm_City.class);
			
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
	
	public List<Hrm_City> getByStateId(int stateId) throws SQLException {

		try {

			this.TryConnect();
			this.m_objData.SetStoreName("hrm_city_get_by_stateId(?)");
			this.m_objData.Parameters.setInt(1, stateId);

			ResultSetMapper util = new ResultSetMapper<User>();

			ResultSet rsResult = this.m_objData.ExecToResultSet();

			List<Hrm_City> lstResult = util.mapRersultSetToObject(rsResult, Hrm_City.class);
			
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
	
	public List<Hrm_City> getByCityId(int cityId) throws SQLException {

		try {

			this.TryConnect();
			this.m_objData.SetStoreName("hrm_city_by_cityId(?)");
			this.m_objData.Parameters.setInt(1, cityId);

			ResultSetMapper util = new ResultSetMapper<User>();

			ResultSet rsResult = this.m_objData.ExecToResultSet();

			List<Hrm_City> lstResult = util.mapRersultSetToObject(rsResult, Hrm_City.class);
			
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
