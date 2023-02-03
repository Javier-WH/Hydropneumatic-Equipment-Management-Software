package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import actors.CorrectiveMantenanceActor;

public class Corrective {

	private static Connection connection = SQLConnection.getConection();
	
	public static void save(CorrectiveMantenanceActor data) {
		
		String SQL = "INSERT INTO correctiveMantenance (\"C-cambioAceite1\", \"C-cambioAceite2\", \"C-cambioCorrea1\", \"C-cambioCorrea2\", \"B-cambioSellos1\", \"B-cambioSellos2\", \"B-cambioRodamientos1\", \"B-cambioRodamientos2\", \"B-cambioImpulsor1\", \"B-cambioImpulsor2\", \"T-cambioBobina1\", \"T-cambioBobina2\" ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, data.getC_cambio_aceite1());
			st.setString(2, data.getC_cambio_aceite2());
			st.setString(3, data.getC_cambio_correa1());
			st.setString(4, data.getC_cambio_correa2());
			st.setString(5, data.getB_cambio_sellos1());
			st.setString(6, data.getB_cambio_sellos2());
			st.setString(7, data.getB_cambio_rodamientos1());
			st.setString(8, data.getB_cambio_rodamientos2());
			st.setString(9, data.getB_cambio_impulsor1());
			st.setString(10, data.getB_cambio_impulsor2());
			st.setString(11, data.getT_cambio_bobina1());
			st.setString(12, data.getT_cambio_bobina2());
			st.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
}
