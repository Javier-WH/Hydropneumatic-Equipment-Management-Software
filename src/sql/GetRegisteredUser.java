package sql;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class GetRegisteredUser {
	
	public static ResultSet getRegister(int number) {
		
		Connection connection = SQLConnection.getConection();
		
		try {
			
			if(number == 0) {
				String SQL = "SELECT * FROM user_registered_daily_mantenance WHERE type > 0  order by id desc";
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				return rs;				
			}else  {
				String SQL = "SELECT * FROM user_registered_daily_mantenance WHERE type = "+number+" order by id desc";
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(SQL);
				return rs;				
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
		
	}

}
