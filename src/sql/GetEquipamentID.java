package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetEquipamentID {
	
	public static String byCode(String code) {
		Connection connection = SQLConnection.getConection();
		String id = null;
		try {
			String SQL = " SELECT * FROM pumpList WHERE code = ?";
			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, code);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				id = rs.getString("id");
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return id;
	}

}
