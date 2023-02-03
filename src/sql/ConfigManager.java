package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConfigManager {
	
	private static Connection connection = SQLConnection.getConection();
	
	public static ArrayList<String> getConfig() {
		
		ArrayList<String> config = new ArrayList<>();
			
		try {
			String SQL = "SELECT * FROM config";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			if(rs.next()) {
				String daily = rs.getString("daily");
				String weekly = rs.getString("weekly");
				String monthly = rs.getString("monthly");
				config.add(daily);
				config.add(weekly);
				config.add(monthly);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return config;
	}
	
	////
	
	public static void setConfig(String daily, String weekly, String monthly) {
		try {
			String SQL = "UPDATE config SET daily = ?, weekly = ?, monthly = ? WHERE id = 1";
			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, daily);
			st.setString(2, weekly);
			st.setString(3, monthly);
			st.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
