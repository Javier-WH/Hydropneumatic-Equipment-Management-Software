package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import actors.CompresorWeeklyMantenance;

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
	///
	
	public static boolean updateData(CompresorWeeklyMantenance compresor) {

		Connection connection = SQLConnection.getConection();
		String id = GetEquipamentID.byCode(compresor.getCode());

		try {

			String SQL = "UPDATE weekly_compresor SET ITDVE = ?, MCE = ? WHERE compresorID = ?";

			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, compresor.getITDVE());
			st.setString(2, compresor.getMCE());
			st.setString(3, id);
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
