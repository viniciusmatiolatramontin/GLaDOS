package glados.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import glados.DB;
import glados.model.entities.Quote;

public class QuoteDAO implements QuoteDAOInterface{
	public Quote findById(int id) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Quote q = null;
		
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from quotes where idquotes = " + id);
			
			while(rs.next()) {
				q = new Quote(rs.getString("quotes"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return q;
	}
}
