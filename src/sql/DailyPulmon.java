package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyPulmon {
	
	
	public static boolean createData(long pulmonID) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String timeStamp = formatter.format(date);

		Connection connection = SQLConnection.getConection();

		try {

			String SQL = "INSERT INTO daily_pulmon (pulmonID, VNA, VFM, MPBCAB, MPACAB) VALUES (?, ?, ?, ?, ?) ";

			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, String.valueOf(pulmonID));
			st.setString(2, timeStamp);
			st.setString(3, timeStamp);
			st.setString(4, timeStamp);
			st.setString(5, timeStamp);
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
