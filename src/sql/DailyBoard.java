package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import actors.BoardDailyMantenance;

public class DailyBoard {

	
	public static boolean createData(long boardId) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String timeStamp = formatter.format(date);

		Connection connection = SQLConnection.getConection();

		try {

			String SQL = "INSERT INTO daily_board (boardID, MV, MA, VTTEC) VALUES (?, ?, ?, ?) ";

			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, String.valueOf(boardId));
			st.setString(2, timeStamp);
			st.setString(3, timeStamp);
			st.setString(4, timeStamp);
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
	//////////////////
	

	public static boolean updateData(BoardDailyMantenance board) {

	
		Connection connection = SQLConnection.getConection();
		String id = GetEquipamentID.byCode(board.getCode());

		try {

			String SQL = "UPDATE daily_board SET MV = ?, MA = ?, VTTEC = ? WHERE boardID =? ";

			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, board.getMV());
			st.setString(2, board.getMA());
			st.setString(3, board.getVTTEC());
			st.setString(4, id);
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
