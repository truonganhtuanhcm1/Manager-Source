package erp.core.database;

import java.sql.SQLException;

public class BUS {
	
	protected IData m_objData = null;

	private boolean isAutoConnect = true;

	protected void BeginTran() throws SQLException {
		if (this.m_objData == null) {
			this.m_objData = new IData();
			this.m_objData.Connect();
			this.m_objData.BeginTrans();
		} else {
			isAutoConnect = false;
		}
	}

	protected void CommitTran() throws SQLException {
		if (isAutoConnect) {
			this.m_objData.Commit();
			this.m_objData.Disconnect();
			this.m_objData = null;
		}
	}

	protected void RollbackTran() throws SQLException {
		if (isAutoConnect) {
			this.m_objData.Rollback();
			this.m_objData.Disconnect();
			this.m_objData = null;
		}
	}
}
