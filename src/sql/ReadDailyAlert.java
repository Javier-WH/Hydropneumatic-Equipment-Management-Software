package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDailyAlert {

	public static ResultSet GetBombDailyAlerts() {

		Connection connection = SQLConnection.getConection();

		try {
			String SQL = "SELECT * FROM daily_bomb";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			return rs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static ResultSet GetCompresorDailyAlerts() {

		Connection connection = SQLConnection.getConection();

		try {
			String SQL = "SELECT * FROM daily_compresor";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			return rs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static ResultSet GetPulmonDailyAlerts() {

		Connection connection = SQLConnection.getConection();

		try {
			String SQL = "SELECT * FROM daily_pulmon";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			return rs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static ResultSet GetBoardDailyAlerts() {

		Connection connection = SQLConnection.getConection();

		try {
			String SQL = "SELECT * FROM daily_board";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			return rs;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
