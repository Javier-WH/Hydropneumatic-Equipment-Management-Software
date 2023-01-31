package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


/*
 * VFC = Validar el funcionamiento del compresor
 * VFA = Verificar fugas de aceite
 * IADRE = Inspección auditiva para determinar ruidos extraños
 * AAJ = Aplicar agua jabonosa en uniones para determinar fugas de aire
 * VFP = Verificar funcionamiento de presostato
 * */

public class DailyCompresor {

	public static boolean createData(long compresorId) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String timeStamp = formatter.format(date);

		Connection connection = SQLConnection.getConection();

		try {

			String SQL = "INSERT INTO daily_compresor (compresorID, VFC, VFA, IADRE, AAJ, VFP) VALUES (?, ?, ?, ?, ?, ?) ";

			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, String.valueOf(compresorId));
			st.setString(2, timeStamp);
			st.setString(3, timeStamp);
			st.setString(4, timeStamp);
			st.setString(5, timeStamp);
			st.setString(6, timeStamp);
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
