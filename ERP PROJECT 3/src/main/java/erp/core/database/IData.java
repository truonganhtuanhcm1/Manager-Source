package erp.core.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import erp.core.log.ILog;

public class IData {
	
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	//private static final String DB_CONNECTION = "jdbc:mysql://103.27.238.216/erpsystem?noAccessToProcedureBodies=true";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost/erpsystem?noAccessToProcedureBodies=true";
	//private static final String DB_USER = "root";
	//private static final String DB_PASSWORD = "root";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD ="root";
	
	private Connection m_dbConnection = null;
	public CallableStatement Parameters;
	private String m_strStorName;
	
	public IData() {
		// TODO Auto-generated constructor stub
	}

	public void BeginTrans() throws SQLException {
		try {
			if(m_dbConnection!=null && !m_dbConnection.isClosed()){
				
				m_dbConnection.setAutoCommit(false);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ILog.Error("Database disconnect error", this, e);
			throw e;
		}
	}
	
	public void Commit() throws SQLException {
		try {
			if(m_dbConnection!=null && !m_dbConnection.isClosed()){
				
				m_dbConnection.commit();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ILog.Error("Database disconnect error", this, e);
			throw e;
		}
	}
	
	public void Rollback() throws SQLException {
		try {
			if(m_dbConnection!=null && !m_dbConnection.isClosed()){
				
				m_dbConnection.rollback();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ILog.Error("Database disconnect error", this, e);
			throw e;
		}
	}
	
 	public Connection Connect() throws SQLException{
		
		m_dbConnection = null;
		 
		try {
 
			Class.forName(DB_DRIVER);
 
		} catch (ClassNotFoundException e) {
 
			ILog.Error("Database connection error", this, e);
 
		}
 
		try {
 
			m_dbConnection = DriverManager.getConnection(
				DB_CONNECTION, DB_USER, DB_PASSWORD);
			m_dbConnection.setAutoCommit(true);
			return m_dbConnection;
 
		} catch (SQLException e) {
			
			ILog.Error("Database connection error", this, e);
			throw e;
 
		}
	}
	
	public void Disconnect() throws SQLException{
		
		try {
			if(m_dbConnection!=null && !m_dbConnection.isClosed()){
				
				Parameters.close();
				m_dbConnection.close();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ILog.Error("Database disconnect error", this, e);
			throw e;
		}
		
	}
	
	public void SetStoreName(String _strStorName) throws SQLException, Exception{
		
		m_strStorName = _strStorName;
		
		if(m_dbConnection==null || m_dbConnection.isClosed()){
			
			ILog.Error("The connection was closed or not connected", this, null);
			throw new Exception("The connection was closed or not connected");
			
		}
		else{
			
			Parameters = m_dbConnection.prepareCall("CALL "+_strStorName);;
		}
		
	}
	
	public ResultSet ExecToResultSet(){
		
		ArrayList<ResultSet> lstResult=new ArrayList<ResultSet>();
		
		boolean hadResults = false;
		try {
			hadResults = Parameters.execute();
		
		    while (hadResults) {
		        
					ResultSet rs = Parameters.getResultSet();
					return rs;
					//lstResult.add(rs);
					//hadResults = Parameters.getMoreResults();
				
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ILog.Error("Execute store error: " + m_strStorName, this, e);
		}
		return null;
		//return lstResult;
	}
	
	public String ExecToString() throws Exception{
		
		try {

			boolean hadResults = Parameters.execute();
		
		    if (hadResults) {
		        
				ResultSet rs = Parameters.getResultSet();
				rs.next();
				return rs.getString(1);
				
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ILog.Error("Execute store error: " + m_strStorName, this, e);
			return null;
		}
		ILog.Error("No data to get: " + m_strStorName, this, null);
		return null;
	}

	public void ExecNoneQuery() throws SQLException {
		// TODO Auto-generated method stub
		Parameters.execute();
	}
	
	
}
