package auxiliar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Calculator {

	public static boolean needAlert(String datex) {


		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(datex);
			int currenDayOfYear = LocalDate.now().getDayOfYear();
			int dataDate = date.toInstant() .atZone(ZoneId.systemDefault()).toLocalDate().getDayOfYear();
			return currenDayOfYear > dataDate;
		} catch (ParseException e) {
			System.err.println(e.getMessage());
			return false;
		}  
	}
	

	
	public static boolean needWeeklyAlert(String datex) {


		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(datex);
			int currenDayOfYear = LocalDate.now().getDayOfYear();
			int dataDate = date.toInstant() .atZone(ZoneId.systemDefault()).toLocalDate().getDayOfYear();
			return currenDayOfYear > dataDate + 7; ///alerta se activa al pasar una semana
		} catch (ParseException e) {
			System.err.println(e.getMessage());
			return false;
		}  
	}
	
	public static boolean needMonthlyAlert(String datex) {


		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(datex);
			int currenDayOfYear = LocalDate.now().getDayOfYear();
			int dataDate = date.toInstant() .atZone(ZoneId.systemDefault()).toLocalDate().getDayOfYear();
			return currenDayOfYear > dataDate + 30; ///alerta se activa al pasar un mes
		} catch (ParseException e) {
			System.err.println(e.getMessage());
			return false;
		}  
	}



}
