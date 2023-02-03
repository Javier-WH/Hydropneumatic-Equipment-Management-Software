package sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {

	public static void createPump() {

		String SQL = "CREATE TABLE  IF NOT EXISTS \"pumpList\" (\r\n" + "	\"id\"	INTEGER,\r\n"
				+ "	\"code\"	TEXT NOT NULL UNIQUE,\r\n" + "	\"name\"	TEXT,\r\n" + "	\"area\"	TEXT,\r\n"
				+ "	\"model\"	TEXT,\r\n" + "	\"mark\"	TEXT,\r\n" + "	\"function\"	TEXT,\r\n"
				+ "	\"year\"	TEXT,\r\n" + "	\"protection_grade\"	TEXT,\r\n" + "	\"isolation_class\"	TEXT,\r\n"
				+ "	\"potency\"	TEXT,\r\n" + "	\"succion_pipe\"	TEXT,\r\n" + "	\"discharge_pipe\"	TEXT,\r\n"
				+ "	\"flow\"	TEXT,\r\n" + "	\"max_height\"	TEXT,\r\n" + "	\"rotation\"	TEXT,\r\n"
				+ "	\"succion_presure\"	TEXT,\r\n" + "	\"working_temp\"	TEXT,\r\n" + "	\"motor\"	TEXT,\r\n"
				+ "	\"other\"	TEXT,\r\n" + "	\"picture\"	TEXT,\r\n" + "	\"max_presure\"	TEXT,\r\n"
				+ "	\"frecuency\"	TEXT,\r\n" + "	\"rotation_speed\"	TEXT,\r\n" + "	\"tension_power\"	TEXT,\r\n"
				+ "	\"enviroment_temp\"	TEXT,\r\n" + "	\"weigth\"	TEXT,\r\n" + "	\"serial\"	TEXT,\r\n"
				+ "	\"service_presure\"	TEXT,\r\n" + "	\"test_presure\"	TEXT,\r\n" + "	\"capacity\"	TEXT,\r\n"
				+ "	\"type\"	TEXT,\r\n" + "	PRIMARY KEY(\"id\" AUTOINCREMENT)\r\n" + ")";

		try {
			Connection connection = SQLConnection.getConection();
			Statement st = connection.createStatement();
			st.execute(SQL);
			st.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void createBoard_registered_daily_mantenance() {

		String SQL = "CREATE TABLE IF NOT EXISTS \"board_registered_daily_mantenance\" (\r\n"
				+ "	\"id\"	INTEGER,\r\n" + "	\"boardID\"	INTEGER NOT NULL,\r\n"
				+ "	\"boardCode\"	TEXT NOT NULL,\r\n" + "	\"register\"	INTEGER NOT NULL UNIQUE,\r\n"
				+ "	\"MV\"	TEXT DEFAULT 'No Suministrado',\r\n" + "	\"MA\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"VTTEC\"	TEXT DEFAULT 'No Suministrado',\r\n" + "	PRIMARY KEY(\"id\" AUTOINCREMENT)\r\n"
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

	public static void createBomb_registered_daily_mantenance() {

		String SQL = "CREATE TABLE IF NOT EXISTS \"bomb_registered_daily_mantenance\" (\r\n"
				+ "	\"id\"	INTEGER,\r\n" + "	\"bombid\"	INTEGER NOT NULL,\r\n"
				+ "	\"bombCode\"	TEXT NOT NULL,\r\n" + "	\"register\"	INTEGER NOT NULL UNIQUE,\r\n"
				+ "	\"VFB\"	TEXT DEFAULT 'No Suministrado',\r\n" + "	\"IADRE\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"IVMPAB\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"ITDVE\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"IVDFTA\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"MCEM\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"ITDVPC\"	TEXT DEFAULT 'No Suministrado',\r\n" + "	PRIMARY KEY(\"id\" AUTOINCREMENT)\r\n"
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

	public static void createCompresor_registered_daily_mantenance() {

		String SQL = "CREATE TABLE IF NOT EXISTS \"compresor_registered_daily_mantenance\" (\r\n"
				+ "	\"id\"	INTEGER,\r\n" + "	\"compresorID\"	INTEGER,\r\n" + "	\"compresorCode\"	TEXT,\r\n"
				+ "	\"register\"	INTEGER NOT NULL UNIQUE,\r\n" + "	\"VFC\"	INTEGER DEFAULT 'No Suministrado',\r\n"
				+ "	\"VFA\"	INTEGER DEFAULT 'No Suministrado',\r\n"
				+ "	\"IADRE\"	INTEGER DEFAULT 'No Suministrado',\r\n"
				+ "	\"AAJ\"	INTEGER DEFAULT 'No Suministrado',\r\n" + "	\"VFP\"	INTEGER DEFAULT 'No Suministrado',\r\n"
				+ "	PRIMARY KEY(\"id\" AUTOINCREMENT)\r\n" + ")";

		try {
			Connection connection = SQLConnection.getConection();
			Statement st = connection.createStatement();
			st.execute(SQL);
			st.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	
	public static void createPulmon_registered_daily_mantenance() {

		String SQL = "CREATE TABLE IF NOT EXISTS \"pulmon_registered_daily_mantenance\" (\r\n"
				+ "	\"id\"	INTEGER,\r\n"
				+ "	\"pulmonID\"	INTEGER NOT NULL,\r\n"
				+ "	\"pulmonCode\"	TEXT NOT NULL,\r\n"
				+ "	\"register\"	TEXT NOT NULL UNIQUE,\r\n"
				+ "	\"VNA\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"VFM\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"MPBCAB\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"MPACAB\"	TEXT DEFAULT 'No Suministrado',\r\n"
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
	
	public static void createDailyBoard() {

		String SQL = "CREATE TABLE IF NOT EXISTS \"daily_board\" (\r\n"
				+ "	\"id\"	INTEGER,\r\n"
				+ "	\"boardID\"	INTEGER NOT NULL UNIQUE,\r\n"
				+ "	\"MV\"	TEXT,\r\n"
				+ "	\"MA\"	TEXT,\r\n"
				+ "	\"VTTEC\"	TEXT,\r\n"
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
	
	public static void createDailyBomb() {

		String SQL = "CREATE TABLE IF NOT EXISTS \"daily_bomb\" (\r\n"
				+ "	\"id\"	INTEGER,\r\n"
				+ "	\"bombID\"	INTEGER NOT NULL UNIQUE,\r\n"
				+ "	\"VFB\"	TEXT,\r\n"
				+ "	\"IADRE\"	TEXT,\r\n"
				+ "	\"IVMPAB\"	TEXT,\r\n"
				+ "	\"ITDVE\"	TEXT,\r\n"
				+ "	\"IVDFTA\"	TEXT,\r\n"
				+ "	\"MCEM\"	TEXT,\r\n"
				+ "	\"ITDVPC\"	TEXT,\r\n"
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
	
	public static void createDailyCompresor() {

		String SQL = "CREATE TABLE IF NOT EXISTS \"daily_compresor\" (\r\n"
				+ "	\"id\"	INTEGER,\r\n"
				+ "	\"compresorID\"	INTEGER NOT NULL UNIQUE,\r\n"
				+ "	\"VFC\"	TEXT,\r\n"
				+ "	\"VFA\"	TEXT,\r\n"
				+ "	\"IADRE\"	TEXT,\r\n"
				+ "	\"AAJ\"	TEXT,\r\n"
				+ "	\"VFP\"	TEXT,\r\n"
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
	
	public static void createDailyPulmon() {

		String SQL = "CREATE TABLE IF NOT EXISTS \"daily_pulmon\" (\r\n"
				+ "	\"id\"	INTEGER,\r\n"
				+ "	\"pulmonID\"	INTEGER NOT NULL UNIQUE,\r\n"
				+ "	\"VNA\"	TEXT,\r\n"
				+ "	\"VFM\"	TEXT,\r\n"
				+ "	\"MPBCAB\"	TEXT,\r\n"
				+ "	\"MPACAB\"	TEXT,\r\n"
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
	
	public static void createMonthlyBoard() {

		String SQL = "CREATE TABLE IF NOT EXISTS \"monthly_board\" (\r\n"
				+ "	\"id\"	INTEGER,\r\n"
				+ "	\"boardID\"	INTEGER NOT NULL UNIQUE,\r\n"
				+ "	\"VCS\"	TEXT,\r\n"
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
	
	public static void createMonthlyBomb() {

		String SQL = "CREATE TABLE IF NOT EXISTS \"monthly_bomb\" (\r\n"
				+ "	\"id\"	INTEGER,\r\n"
				+ "	\"bombID\"	INTEGER NOT NULL UNIQUE,\r\n"
				+ "	\"APTAB\"	TEXT,\r\n"
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
	
	public static void createMonthlyCompresor() {

		String SQL = "CREATE TABLE IF NOT EXISTS \"monthly_compresor\" (\r\n"
				+ "	\"id\"	INTEGER,\r\n"
				+ "	\"compresorID\"	INTEGER NOT NULL UNIQUE,\r\n"
				+ "	\"VTCT\"	TEXT,\r\n"
				+ "	\"VNA\"	TEXT,\r\n"
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
	
	public static void createRegisteredMonthlyMantenance() {

		String SQL = "CREATE TABLE IF NOT EXISTS \"registered_monthly_mantenance\" (\r\n"
				+ "	\"id\"	INTEGER,\r\n"
				+ "	\"register\"	INTEGER,\r\n"
				+ "	\"bombCode\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"compresorCode\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"boardCode\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"APTAB\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"VCS\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"VTCT\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"VNA\"	TEXT DEFAULT 'No Suministrado',\r\n"
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
	
	public static void createRegisteredWeeklyMantenance() {

		String SQL = "CREATE TABLE IF NOT EXISTS \"registered_weekly_mantenance\" (\r\n"
				+ "	\"id\"	INTEGER,\r\n"
				+ "	\"register\"	INTEGER,\r\n"
				+ "	\"bombCode\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"compresorCode\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"boardCode\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"VTETS\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"LRPPAC\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"LEPP\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"ITDVE\"	TEXT DEFAULT 'No Suministrado',\r\n"
				+ "	\"MCE\"	TEXT DEFAULT 'No Suministrado',\r\n"
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
	
	
	public static void createUserRegisteredDailyMantenance() {

		String SQL = "CREATE TABLE IF NOT EXISTS user_registered_daily_mantenance (\"id\" INTEGER, \"register\"  TEXT, \"mantenance_boss\" TEXT, \"operator\" TEXT, \"control_number\" TEXT, \"equioament\" TEXT, \"type\" INTEGER,	PRIMARY KEY(\"id\" AUTOINCREMENT)"
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
	
	public static void createWeeklyBoard() {

		String SQL = "CREATE TABLE IF NOT EXISTS \"weekly_board\" (\r\n"
				+ "	\"id\"	INTEGER,\r\n"
				+ "	\"boardID\"	INTEGER NOT NULL UNIQUE,\r\n"
				+ "	\"LEPP\"	TEXT,\r\n"
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
	
	public static void createWeeklyBomb() {

		String SQL = "CREATE TABLE IF NOT EXISTS \"weekly_bomb\" (\r\n"
				+ "	\"id\"	INTEGER UNIQUE,\r\n"
				+ "	\"bombID\"	INTEGER NOT NULL UNIQUE,\r\n"
				+ "	\"VTETS\"	TEXT,\r\n"
				+ "	\"LRPPAC\"	TEXT,\r\n"
				+ "	PRIMARY KEY(\"id\")\r\n"
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
	
	public static void createWeeklyCompresor() {

		String SQL = "CREATE TABLE IF NOT EXISTS \"weekly_compresor\" (\r\n"
				+ "	\"id\"	INTEGER,\r\n"
				+ "	\"compresorID\"	INTEGER NOT NULL UNIQUE,\r\n"
				+ "	\"ITDVE\"	TEXT,\r\n"
				+ "	\"MCE\"	TEXT,\r\n"
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
	
	
	public static boolean createTables() {
		createUserRegisteredDailyMantenance();
		createBoard_registered_daily_mantenance();
		createBomb_registered_daily_mantenance();
		createCompresor_registered_daily_mantenance();
		createPulmon_registered_daily_mantenance();
		createDailyBoard();
		createDailyBomb();
		createDailyCompresor();
		createDailyPulmon();
		createWeeklyBoard();
		createWeeklyBomb();
		createWeeklyCompresor();
		createMonthlyBoard();
		createMonthlyBomb();
		createMonthlyCompresor();
		createPump();
		createRegisteredWeeklyMantenance();
		createRegisteredMonthlyMantenance();
		createUserRegisteredDailyMantenance();
		return true;
	}
	
	

}//
