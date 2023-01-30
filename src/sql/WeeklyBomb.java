package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


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
			SQLConnection.resetConection();
		}

		return true;
	}
	

}
