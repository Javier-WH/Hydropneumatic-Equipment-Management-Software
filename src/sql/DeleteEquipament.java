package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEquipament {

	public static boolean delete(String id) {
		
		Connection conn = SQLConnection.getConection();
		
		try {
			String SQL = "DELETE FROM  pumpList WHERE ID = ?";
			PreparedStatement st = conn.prepareStatement(SQL);
			st.setString(1, id );
			st.execute();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
