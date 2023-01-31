package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import actors.WaterPump;

public class RegisterPump {
	
	private static long insertedID = 0;

	public static boolean register(WaterPump pump) {
		Connection connection = SQLConnection.getConection();

		try {

			String SQL = "INSERT INTO pumpList (" + "code, " + "name, " + "area, " + "model, " + "mark, " + "function, "
					+ "year, " + "protection_grade, " + "isolation_class, " + "potency, " + "succion_pipe, "
					+ "discharge_pipe, " + "flow, " + "max_height, " + "rotation, " + "succion_presure, "
					+ "working_temp, " + "motor, " + "other, " + "picture, "
					//////////////
					+ "max_presure, " + "frecuency, " + "rotation_speed, " + "tension_power, " + "enviroment_temp, "
					+ "weigth, " + "serial, " + "service_presure, " + "test_presure, " + "capacity, "
					+ "type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, pump.getCode());
			statement.setString(2, pump.getName());
			statement.setString(3, pump.getArea());
			statement.setString(4, pump.getModel());
			statement.setString(5, pump.getMark());
			statement.setString(6, pump.getFunction());
			statement.setString(7, pump.getYear());
			statement.setString(8, pump.getProtectionGrade());
			statement.setString(9, pump.getIsolationClass());
			statement.setString(10, pump.getPotencty());
			statement.setString(11, pump.getSuccionPipe());
			statement.setString(12, pump.getDischagePipe());
			statement.setString(13, pump.getFlowsTo());
			statement.setString(14, pump.getMaxHeight());
			statement.setString(15, pump.getRotation());
			statement.setString(16, pump.getSuccionPresureTo());
			statement.setString(17, pump.getWorkingTempTo());
			statement.setString(18, pump.getMotor());
			statement.setString(19, pump.getOthers());
			statement.setString(20, pump.getPictureAddress());
			statement.setString(21, pump.getMaxPresure());
			statement.setString(22, pump.getFrecuency());
			statement.setString(23, pump.getRotationSpeed());
			statement.setString(24, pump.getTensionPower());
			statement.setString(25, pump.getEnviromentTemp());
			statement.setString(26, pump.getWeigth());
			statement.setString(27, pump.getSerial());
			statement.setString(28, pump.getServisePresure());
			statement.setString(29, pump.getTestPresure());
			statement.setString(30, pump.getCapacity());
			statement.setString(31, pump.getType());
			statement.execute();
			ResultSet rs = statement.getGeneratedKeys();
			statement.close();

			if (rs.next()) {
				insertedID = rs.getLong(1);
				rs.close();
				//SQLConnection.resetConection();
				
				if(pump.getType().equals("1")) {
					DailyBomb.createData(insertedID);
					WeeklyBomb.createData(insertedID);
					MonthlyBomb.createData(insertedID);
				}else if(pump.getType().equals("2")) {
					DailyCompresor.createData(insertedID);
					WeeklyCompresor.createData(insertedID);
					MonthlyCompresor.createData(insertedID);
				}else if(pump.getType().equals("3")) {
					DailyPulmon.createData(insertedID);
				}else if(pump.getType().equals("4")) {
					DailyBoard.createData(insertedID);
					Weekly_board.createData(insertedID);
					MonthyBoard.createData(insertedID);
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;

		} finally {
			//SQLConnection.resetConection();
		}

		return true;
	}

}
