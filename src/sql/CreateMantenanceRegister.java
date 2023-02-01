package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import actors.BoardDailyMantenance;
import actors.BoardMonthlyMantenance;
import actors.BoardWeeklyMantenance;
import actors.BombDailyMantenance;
import actors.BombMonthlyMantenance;
import actors.BombWeeklyMantenance;
import actors.CompresorDailyMantenance;
import actors.CompresorMonthlyMantenance;
import actors.CompresorWeeklyMantenance;
import actors.PulmonDailyMantenance;
import actors.User;

public class CreateMantenanceRegister {
	
	public static void CreateDailyRegister(BombDailyMantenance bomb, CompresorDailyMantenance compresor, PulmonDailyMantenance pulmon, BoardDailyMantenance board, User user) {
		
		Random rand = new Random();
		int n = rand.nextInt(10000);
		String register = String.valueOf(n);
		
		/*
		String bombID = GetEquipamentID.byCode(bomb.getCode());
		String compresorID = GetEquipamentID.byCode(compresor.getCode());
		String pulmonID = GetEquipamentID.byCode(pulmon.getCode());
		String boardID = GetEquipamentID.byCode(board.getCode());
		*/
		
		
		Connection connection = SQLConnection.getConection();
		
		try {
			
			String SQLbomb = "INSERT INTO bomb_registered_daily_mantenance (bombid, bombCode, register, VFB, IADRE, IVMPAB, ITDVE, IVDFTA, MCEM, ITDVPC) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement stBomb = connection.prepareStatement(SQLbomb);
			stBomb.setString(1, "0");
			stBomb.setString(2, bomb.getCode());
			stBomb.setString(3, register);
			stBomb.setString(4, bomb.getVFB());
			stBomb.setString(5, bomb.getIADRE());
			stBomb.setString(6, bomb.getIVMPAB());
			stBomb.setString(7, bomb.getITDVE());
			stBomb.setString(8, bomb.getIVDFTA());
			stBomb.setString(9, bomb.getMCEM());
			stBomb.setString(10, bomb.getITDVPC());
			stBomb.execute();
			
			String SQLcompresor = "INSERT INTO compresor_registered_daily_mantenance (compresorID, compresorCode, register, VFC, VFA, IADRE, AAJ, VFP) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stCompresor = connection.prepareStatement(SQLcompresor);
			stCompresor.setString(1, "0");
			stCompresor.setString(2, compresor.getCode());
			stCompresor.setString(3, register);
			stCompresor.setString(4, compresor.getVFC());
			stCompresor.setString(5, compresor.getVFA());
			stCompresor.setString(6, compresor.getIADRE());
			stCompresor.setString(7, compresor.getAAJ());
			stCompresor.setString(8, compresor.getVFP());
			stCompresor.execute();
			
			String SQLpulmon = "INSERT INTO pulmon_registered_daily_mantenance (pulmonID, pulmonCode, register, VNA, VFM, MPBCAB, MPACAB) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stPulmon = connection.prepareStatement(SQLpulmon);
			stPulmon.setString(1, "0");
			stPulmon.setString(2, pulmon.getCode());
			stPulmon.setString(3, register);
			stPulmon.setString(4, pulmon.getVNA());
			stPulmon.setString(5, pulmon.getVFM());
			stPulmon.setString(6, pulmon.getMPBCAB());
			stPulmon.setString(7, pulmon.getMPACAB());
			stPulmon.execute();
			
			
			String SQLboard = "INSERT INTO board_registered_daily_mantenance (boardID, boardCode, register, MV, MA, VTTEC) VALUES (?, ?, ?, ?, ?, ?) ";
			PreparedStatement stBoard = connection.prepareStatement(SQLboard);
			stBoard.setString(1, "0");
			stBoard.setString(2, board.getCode());
			stBoard.setString(3,register);
			stBoard.setString(4, board.getMV());
			stBoard.setString(5, board.getMA());
			stBoard.setString(6, board.getVTTEC());
			stBoard.execute();
			
			String SQLuser = "INSERT INTO user_registered_daily_mantenance (register, mantenance_boss, operator, control_number, equioament, type) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement stUser = connection.prepareStatement(SQLuser);
			stUser.setString(1, register);
			stUser.setString(2, user.getMantenanceBoss());
			stUser.setString(3, user.getOperator());
			stUser.setString(4, user.getControlNumber());
			stUser.setString(5, user.getEquipament());
			stUser.setString(6, "1");
			stUser.execute();
			
			
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

	public static void CreateWeeklyRegister(BombWeeklyMantenance bomb, CompresorWeeklyMantenance compresor, BoardWeeklyMantenance board, User user) {

		Random rand = new Random();
		int n = rand.nextInt(10000);
		String register = String.valueOf(n);
		
		Connection connection = SQLConnection.getConection();
		
		try {
			
			String SQL = "INSERT INTO registered_weekly_mantenance (register, bombCode, compresorCode, boardCode, VTETS, LRPPAC, LEPP, ITDVE, MCE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, register);
			st.setString(2, bomb.getCode());
			st.setString(3, compresor.getCode());
			st.setString(4, board.getCode());
			st.setString(5,bomb.getVTETS());
			st.setString(6, bomb.getLRPPAC());
			st.setString(7, board.getLEPP());
			st.setString(8, compresor.getITDVE());
			st.setString(9, compresor.getMCE());
			st.execute();
			
			String SQLuser = "INSERT INTO user_registered_daily_mantenance (register, mantenance_boss, operator, control_number, equioament, type) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement stUser = connection.prepareStatement(SQLuser);
			stUser.setString(1, register);
			stUser.setString(2, user.getMantenanceBoss());
			stUser.setString(3, user.getOperator());
			stUser.setString(4, user.getControlNumber());
			stUser.setString(5, user.getEquipament());
			stUser.setString(6, "2");
			stUser.execute();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	
	public static void CreateMonthlyRegister(BombMonthlyMantenance bomb, CompresorMonthlyMantenance compresor, BoardMonthlyMantenance board, User user) {
		
		Random rand = new Random();
		int n = rand.nextInt(10000);
		String register = String.valueOf(n);
		
		Connection connection = SQLConnection.getConection();
		
		try {
			
			String SQL ="INSERT INTO registered_monthly_mantenance (register, bombCode, compresorCode, boardCode, APTAB, VCS, VTCT, VNA) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, register);
			st.setString(2, bomb.getCode());
			st.setString(3, compresor.getCode());
			st.setString(4, board.getCode());
			st.setString(5, bomb.getAPTAB());
			st.setString(6, board.getVCS());
			st.setString(7, compresor.getVTCT());
			st.setString(8, compresor.getVNA());
			st.execute();
			
			String SQLuser = "INSERT INTO user_registered_daily_mantenance (register, mantenance_boss, operator, control_number, equioament, type) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement stUser = connection.prepareStatement(SQLuser);
			stUser.setString(1, register);
			stUser.setString(2, user.getMantenanceBoss());
			stUser.setString(3, user.getOperator());
			stUser.setString(4, user.getControlNumber());
			stUser.setString(5, user.getEquipament());
			stUser.setString(6, "3");
			stUser.execute();
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}


}
