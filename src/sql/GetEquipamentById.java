package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetEquipamentById {

	public static ResultSet getById(String id) {
		Connection connection = SQLConnection.getConection();
		Statement st = null;
		ResultSet rs = null;
		try {
			String SQL = "SELECT * FROM pumpList where id = "+ id;	
			st = connection.createStatement();
			rs = st.executeQuery(SQL);
			
			return rs;	
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
}
