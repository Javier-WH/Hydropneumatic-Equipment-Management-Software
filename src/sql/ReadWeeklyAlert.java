package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadWeeklyAlert {
	
	
	public static ResultSet GetBombWeeklyAlerts() {

		Connection connection = SQLConnection.getConection();

		try {
			String SQL = "SELECT * FROM weekly_bomb";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			return rs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static ResultSet GetCompresorWeeklyAlerts() {

		Connection connection = SQLConnection.getConection();

		try {
			String SQL = "SELECT * FROM weekly_compresor";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			return rs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}



	public static ResultSet GetBoardWeeklyAlerts() {

		Connection connection = SQLConnection.getConection();

		try {
			String SQL = "SELECT * FROM weekly_board";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			return rs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
