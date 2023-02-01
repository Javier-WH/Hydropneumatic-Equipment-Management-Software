package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import actors.PulmonDailyMantenance;

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
	//////////////////////
	
	public static boolean updateData(PulmonDailyMantenance pulmon) {

		Connection connection = SQLConnection.getConection();
		String id = GetEquipamentID.byCode(pulmon.getCode());
		
		
		try {

			String SQL = "UPDATE daily_pulmon SET VNA = ?, VFM = ?, MPBCAB = ?, MPACAB = ? WHERE pulmonID = ?  ";

			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, pulmon.getVNA());
			st.setString(2, pulmon.getVFM());
			st.setString(3, pulmon.getMPBCAB());
			st.setString(4, pulmon.getMPACAB());
			st.setString(5, id);
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
