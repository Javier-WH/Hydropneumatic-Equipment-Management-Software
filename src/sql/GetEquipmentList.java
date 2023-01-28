package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetEquipmentList {

	public static ResultSet getList() {
		Connection connection = SQLConnection.getConection();
		
		try {
			
			String SQL = "SELECT * FROM pumpList";	
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			return rs;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		
	} 
	
}
