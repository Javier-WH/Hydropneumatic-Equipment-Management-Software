package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import actors.BoardWeeklyMantenance;

public class Weekly_board {
	
	public static boolean createData(long boardId) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String timeStamp = formatter.format(date);

		Connection connection = SQLConnection.getConection();

		try {

			String SQL = "INSERT INTO weekly_board (boardID, LEPP) VALUES (?, ?) ";

			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, String.valueOf(boardId));
			st.setString(2, timeStamp);
			st.execute();
			st.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}finally {
		//	SQLConnection.resetConection();
		}
		return true;
	}
	
	//
	
	public static boolean updateData(BoardWeeklyMantenance board) {


		Connection connection = SQLConnection.getConection();
		String id = GetEquipamentID.byCode(board.getCode());

		try {

			String SQL = "UPDATE weekly_board SET LEPP = ? WHERE boardID =? ";

			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, board.getLEPP());
			st.setString(2, id);
			st.execute();
			st.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}finally {
		//	SQLConnection.resetConection();
		}
		return true;
	}

}
