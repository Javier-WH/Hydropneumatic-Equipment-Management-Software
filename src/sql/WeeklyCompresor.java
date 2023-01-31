package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * ITDVE = Inspección táctil para determinar vibraciones excesivas
 * MCE = Medición de consumo eléctrico 
 * */


public class WeeklyCompresor {
	

	public static boolean createData(long compresorID) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String timeStamp = formatter.format(date);

		Connection connection = SQLConnection.getConection();

		try {

			String SQL = "INSERT INTO weekly_compresor (compresorID, ITDVE, MCE) VALUES (?, ?, ?) ";

			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, String.valueOf(compresorID));
			st.setString(2, timeStamp);
			st.setString(3, timeStamp);
			st.execute();
			st.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}finally {
			//SQLConnection.resetConection();
		}

		return true;
	}
	
	
	
	
	

}
