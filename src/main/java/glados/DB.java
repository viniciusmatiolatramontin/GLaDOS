package glados;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import glados.exceptions.DbException;

public class DB {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		if(conn == null) {
			Properties props = loadProperties();
			String url = props.getProperty("dburl");
			try {
				conn = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DbException(e.getMessage());
			}
			
		}
		return conn;
	}
	
	private static Properties loadProperties() {
		try {
			FileInputStream fs = new FileInputStream("C:\\temp\\db.properties");
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch(IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DbException(e.getMessage());
			}
		}
	}
}
