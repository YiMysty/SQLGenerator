package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import configReader.ConfigReader;
public class DBTools {
	Connection m_Connection = null;
	public DBTools() {
		try {
			ConfigReader reader = new ConfigReader();
			Class.forName(reader.getConfigurationReader().getDriverName());
			m_Connection = DriverManager.getConnection(reader.getConfigurationReader().getURL()+reader.getConfigurationReader().getDbName(),reader.getConfigurationReader().getUserName(),reader.getConfigurationReader().getPasswd());
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean execute(String SQL){
		boolean result;
		try {
			Statement st = m_Connection.createStatement();
			 result =  st.execute(SQL);
			 st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return result;
	}
}
