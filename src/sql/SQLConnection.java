package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class SQLConnection {

	public static Connection getConection() {

		Icon errorIcon = UIManager.getIcon("OptionPane.errorIcon");//este es el icono de error
		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:src/dataBase/data.db");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurrió un error al conectarse con la base de datos", "Error", JOptionPane.ERROR_MESSAGE, errorIcon);
			System.out.println(e.getMessage());
		}

		return connection;
	}
	
	

}
