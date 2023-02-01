package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import actors.CompresorMonthlyMantenance;

public class MonthlyCompresor {
	
	public static boolean createData(long compresorID) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String timeStamp = formatter.format(date);

		Connection connection = SQLConnection.getConection();

		try {

			String SQL = "INSERT INTO monthly_compresor (compresorID, VTCT, VNA) VALUES (?, ?, ?) ";

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
	/////
	
	public static boolean updateData(CompresorMonthlyMantenance compresor) {

		Connection connection = SQLConnection.getConection();
		String id = GetEquipamentID.byCode(compresor.getCode());

		try {

			String SQL = "UPDATE monthly_compresor SET VTCT = ?, VNA = ? WHERE compresorID = ?";

			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, compresor.getVTCT());
			st.setString(2, compresor.getVNA());
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
