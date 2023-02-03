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
			
			String SQLdailyBomb = "DELETE FROM daily_bomb WHERE bombID = ?";
			PreparedStatement stDaily_bomb = conn.prepareStatement(SQLdailyBomb);
			stDaily_bomb.setString(1, id );
			stDaily_bomb.execute();
			
			String SQLdailyCompresor = "DELETE FROM daily_compresor WHERE compresorID = ?";
			PreparedStatement stDailyCompresor= conn.prepareStatement(SQLdailyCompresor);
			stDailyCompresor.setString(1, id );
			stDailyCompresor.execute();
			
			String SQLdailyPulmon = "DELETE FROM daily_pulmon WHERE pulmonID = ?";
			PreparedStatement stDailyPulmon= conn.prepareStatement(SQLdailyPulmon);
			stDailyPulmon.setString(1, id );
			stDailyPulmon.execute();
			
			String SQLdailyBoard = "DELETE FROM daily_board WHERE boardID = ?";
			PreparedStatement stDailyBoard= conn.prepareStatement(SQLdailyBoard);
			stDailyBoard.setString(1, id );
			stDailyBoard.execute();
			
			String SQLweeklyBomb = "DELETE FROM weekly_bomb WHERE bombID = ?";
			PreparedStatement stWeeklyBomb= conn.prepareStatement(SQLweeklyBomb);
			stWeeklyBomb.setString(1, id );
			stWeeklyBomb.execute();
			
			String SQLweeklyCompresor = "DELETE FROM weekly_compresor WHERE compresorID = ?";
			PreparedStatement stWeeklyCompresor= conn.prepareStatement(SQLweeklyCompresor);
			stWeeklyCompresor.setString(1, id );
			stWeeklyCompresor.execute();
			
			String SQLweeklyBoard = "DELETE FROM weekly_board WHERE boardID = ?";
			PreparedStatement stWeeklyBoard= conn.prepareStatement(SQLweeklyBoard);
			stWeeklyBoard.setString(1, id );
			stWeeklyBoard.execute();
			
			String SQLmonthlyBomb = "DELETE FROM monthly_bomb WHERE bombID = ?";
			PreparedStatement stMonthlyBomb= conn.prepareStatement(SQLmonthlyBomb);
			stMonthlyBomb.setString(1, id );
			stMonthlyBomb.execute();
			
			String SQLmonthlyCompresor = "DELETE FROM monthly_compresor WHERE compresorID = ?";
			PreparedStatement stMonthlyCompresor= conn.prepareStatement(SQLmonthlyCompresor);
			stMonthlyCompresor.setString(1, id );
			stMonthlyCompresor.execute();
			
			String SQLmonthlyBoard = "DELETE FROM monthly_board WHERE boardID = ?";
			PreparedStatement stMonthlyBoard= conn.prepareStatement(SQLmonthlyBoard);
			stMonthlyBoard.setString(1, id );
			stMonthlyBoard.execute();
			
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
