package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import actors.BombMonthlyMantenance;

/*
 * APTAB = Ajustar pernos y tornillos de anclaje de la base
 * */

public class MonthlyBomb {
	
	public static boolean createData(long bombId) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String timeStamp = formatter.format(date);

		Connection connection = SQLConnection.getConection();

		try {

			String SQL = "INSERT INTO monthly_bomb (bombID, APTAB) VALUES (?, ?)";

			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, String.valueOf(bombId));
			st.setString(2, timeStamp);
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
	
	public static boolean updateData(BombMonthlyMantenance bomb) {

	
		Connection connection = SQLConnection.getConection();
		String id = GetEquipamentID.byCode(bomb.getCode());

		try {

			String SQL = "UPDATE monthly_bomb SET APTAB = ? WHERE bombID = ?";

			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, bomb.getAPTAB());
			st.setString(2, id);
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
