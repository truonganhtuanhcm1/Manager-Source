package erp.module.hrm.service;

import java.sql.SQLException;
import java.util.List;

import erp.core.database.BUS;
import erp.core.log.ILog;
import erp.module.hrm.dao.Hrm_CityDAO;
import erp.module.hrm.model.Hrm_City;

public class Hrm_CityService extends BUS {

	public List<Hrm_City> getAll() {

		List<Hrm_City> lstResult = null;
		try {
			lstResult = new Hrm_CityDAO(this.m_objData).getAll();
		} catch (SQLException e) {
			ILog.Debug(e.getMessage(), this);
		}
		return lstResult;
	}
	
	public List<Hrm_City> getByStateId(int stateId) {
		
		List<Hrm_City> lstResult = null;
		try {
			lstResult = new Hrm_CityDAO(this.m_objData).getByStateId(stateId);
		} catch (SQLException e) {
			ILog.Debug(e.getMessage(), this);
		}
		return lstResult;
	}
	
	public List<Hrm_City> getByCityId(int cityId) {
		
		List<Hrm_City> lstResult = null;
		try {
			lstResult = new Hrm_CityDAO(this.m_objData).getByCityId(cityId);
		} catch (SQLException e) {
			ILog.Debug(e.getMessage(), this);
		}
		return lstResult;
	}
}
