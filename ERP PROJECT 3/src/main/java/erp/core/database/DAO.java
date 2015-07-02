package erp.core.database;

import java.sql.SQLException;

public class DAO {

	public DAO(IData objData) {
		m_objData = objData;
	}

	protected IData m_objData = null;
	private boolean isAutoConnect = true;

	protected void TryConnect() throws SQLException {
		if (this.m_objData == null) {
			this.m_objData = new IData();
			this.m_objData.Connect();
		} else {
			isAutoConnect = false;
		}
	}

	protected void TryDisconnect() throws SQLException {
		if (isAutoConnect)
			this.m_objData.Disconnect();
	}
}
