package sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {

	public static void createPump() {
		
		String SQL = "CREATE TABLE  IF NOT EXISTS \"pumpList\" (\r\n"
				+ "	\"id\"	INTEGER,\r\n"
				+ "	\"code\"	TEXT NOT NULL UNIQUE,\r\n"
				+ "	\"name\"	TEXT,\r\n"
				+ "	\"area\"	TEXT,\r\n"
				+ "	\"model\"	TEXT,\r\n"
				+ "	\"mark\"	TEXT,\r\n"
				+ "	\"function\"	TEXT,\r\n"
				+ "	\"year\"	TEXT,\r\n"
				+ "	\"protection_grade\"	TEXT,\r\n"
				+ "	\"isolation_class\"	TEXT,\r\n"
				+ "	\"potency\"	TEXT,\r\n"
				+ "	\"succion_pipe\"	TEXT,\r\n"
				+ "	\"discharge_pipe\"	TEXT,\r\n"
				+ "	\"flow\"	TEXT,\r\n"
				+ "	\"max_height\"	TEXT,\r\n"
				+ "	\"rotation\"	TEXT,\r\n"
				+ "	\"succion_presure\"	TEXT,\r\n"
				+ "	\"working_temp\"	TEXT,\r\n"
				+ "	\"motor\"	TEXT,\r\n"
				+ "	\"other\"	TEXT,\r\n"
				+ "	\"picture\"	TEXT,\r\n"
				+ "	\"max_presure\"	TEXT,\r\n"
				+ "	\"frecuency\"	TEXT,\r\n"
				+ "	\"rotation_speed\"	TEXT,\r\n"
				+ "	\"tension_power\"	TEXT,\r\n"
				+ "	\"enviroment_temp\"	TEXT,\r\n"
				+ "	\"weigth\"	TEXT,\r\n"
				+ "	\"serial\"	TEXT,\r\n"
				+ "	\"service_presure\"	TEXT,\r\n"
				+ "	\"test_presure\"	TEXT,\r\n"
				+ "	\"capacity\"	TEXT,\r\n"
				+ "	\"type\"	TEXT,\r\n"
				+ "	PRIMARY KEY(\"id\" AUTOINCREMENT)\r\n"
				+ ")";
		
		try {
			Connection connection = SQLConnection.getConection();
			Statement st = connection.createStatement();
			st.execute(SQL);
			st.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
}
