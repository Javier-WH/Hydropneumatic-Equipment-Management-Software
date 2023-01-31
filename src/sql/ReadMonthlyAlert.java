package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadMonthlyAlert {

	public static ResultSet GetBombMonthlyAlerts() {

		Connection connection = SQLConnection.getConection();

		try {
			String SQL = "SELECT * FROM monthly_bomb";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			return rs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static ResultSet GetCompresorMonthlyAlerts() {

		Connection connection = SQLConnection.getConection();

		try {
			String SQL = "SELECT * FROM monthly_compresor";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			return rs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}


	public static ResultSet GetBoardMonthlyAlerts() {

		Connection connection = SQLConnection.getConection();

		try {
			String SQL = "SELECT * FROM monthly_board";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			return rs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
}
