package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import actors.WaterPump;

public class RegisterPump {

	public static boolean register(WaterPump pump) {

		try {

			Connection connection = SQLConnection.getConection();

			String SQL = "INSERT INTO pumpList (code, name, area, model, mark, function, year, protection_grade, isolation_class, potency, succion_pipe, discharge_pipe, flow, max_height, rotation, succion_presure, working_temp, motor, other, picture) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement(SQL);
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
			statement.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

		return true;
	}

}
