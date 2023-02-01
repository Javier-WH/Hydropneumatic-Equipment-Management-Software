package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import actors.BombWeeklyMantenance;


/*
 * VTETS = Validar a través del tacto temperatura externa de tubería de succión.
 *  LRPPAC = Limpieza para retirar partículas de polvo y agentes contaminantes
 * */


public class WeeklyBomb {
	
	
	public static boolean createData(long bombId) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String timeStamp = formatter.format(date);

		Connection connection = SQLConnection.getConection();

		try {

			String SQL = "INSERT INTO weekly_bomb (bombID, VTETS, LRPPAC) VALUES (?, ?, ?) ";

			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, String.valueOf(bombId));
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
	
	
	public static boolean updateData(BombWeeklyMantenance bomb) {


		Connection connection = SQLConnection.getConection();
		String id = GetEquipamentID.byCode(bomb.getCode());

		try {

			String SQL = "UPDATE weekly_bomb SET VTETS = ?, LRPPAC = ? WHERE bombID = ?";

			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, bomb.getVTETS());
			st.setString(2, bomb.getLRPPAC());
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
