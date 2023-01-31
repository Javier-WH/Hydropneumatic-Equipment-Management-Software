package sql;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * VFB = Validar funcionamiento de la bomba
 * IADRE = Inspección auditiva para determinar ruidos extraños
 * IVMPAB = Inspección visual del manómetro de presión al activarse la bomba
 * ITDVE =  Inspección táctil para determinar vibraciones excesivas
 * IVDFTA = Inspección visual para detectar fugas en las tuberías de agua
 * MCEM = Medición consumo eléctrico del motor
 * ITDVPC = Inspección de tuberia de succion para verificar que no haya pérdida de ceba
 * */

public class DailyBomb {

	public static boolean createData(long bombId) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String timeStamp = formatter.format(date);

		Connection connection = SQLConnection.getConection();

		try {

			String SQL = "INSERT INTO daily_bomb (bombID, VFB, IADRE, IVMPAB, ITDVE, IVDFTA, MCEM, ITDVPC) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";

			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, String.valueOf(bombId));
			st.setString(2, timeStamp);
			st.setString(3, timeStamp);
			st.setString(4, timeStamp);
			st.setString(5, timeStamp);
			st.setString(6, timeStamp);
			st.setString(7, timeStamp);
			st.setString(8, timeStamp);
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
