package auxiliar;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import actors.Alert;
import sql.ConfigManager;
import sql.GetEquipamentById;
import sql.ReadDailyAlert;
import sql.ReadMonthlyAlert;
import sql.ReadWeeklyAlert;

public class CalculateDailyAlerts {
	private static ArrayList<Alert> dailyAlerts = new ArrayList<Alert>();
	
	public static ArrayList<Alert> getAlertList(){
		dailyAlerts.clear();
		
		ArrayList<String> config = ConfigManager.getConfig();
		
		if(config.get(0).equals("1")) {
			getDailyAlerts();			
		}
		if(config.get(1).equals("1")) {
			getWeeklyAlerts();			
		}
		if(config.get(0).equals("1")) {
			getMonthlyAlerts();						
		}
		
		
		
		return dailyAlerts;
	}
	
	private static void addAlert(String alertText, String equipamentID, String frecuency, String type) {
		ResultSet rsEquipament = GetEquipamentById.getById(equipamentID);
		try {
			rsEquipament.next();
			
			Alert alert = new Alert(alertText);
			alert.setCode(rsEquipament.getString("code"));
			alert.setName(rsEquipament.getString("name"));
			alert.setArea(rsEquipament.getString("area"));
			alert.setModel(rsEquipament.getString("model"));
			alert.setMark(rsEquipament.getString("mark"));
			alert.setFunction(rsEquipament.getString("function"));
			alert.setPictureAddress(rsEquipament.getString("picture"));
			alert.setId(equipamentID);
			alert.setFrecuency(frecuency);
			alert.setType(type);
			
			dailyAlerts.add(alert);
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		
	}
	
	private static void getDailyAlerts() {
		
		ResultSet rsDailyBomb = ReadDailyAlert.GetBombDailyAlerts();
		ResultSet rsDailyCompresor = ReadDailyAlert.GetCompresorDailyAlerts();
		ResultSet rsDailyBoard = ReadDailyAlert.GetBoardDailyAlerts();
		ResultSet rsDailyPulmon = ReadDailyAlert.GetPulmonDailyAlerts();
		
		try {
			while(rsDailyBomb.next()) {
				String id = rsDailyBomb.getString("bombID"); //el id del producto
				String VFB = rsDailyBomb.getString("VFB"); //Validar el funcionamiento de la bomba
				String IADRE = rsDailyBomb.getString("IADRE"); //Inspecci??n auditiva para determinar ruidos extra??os
				String IVMPAB = rsDailyBomb.getString("IVMPAB"); //Inspecci??n visual del man??metro de presi??n al activarse la bomba
				String ITDVE = rsDailyBomb.getString("ITDVE"); // Inspecci??n t??ctil para determinar vibraciones excesivas
				String IVDFTA = rsDailyBomb.getString("IVDFTA"); //Inspecci??n visual para detectar fugas en las tuber??as de agua
				String MCEM = rsDailyBomb.getString("MCEM"); //Medici??n consumo el??ctrico del motor
				String ITDVPC = rsDailyBomb.getString("ITDVPC"); //Inspecci??n de tuberia de succion para verificar que no haya p??rdida de cebaInspecci??n de tuberia de succion para verificar que no haya p??rdida de ceba
			
				if(Calculator.needAlert(VFB)) {
					addAlert("Validar el funcionamiento de la bomba", id, "1", "1");
				}
				if(Calculator.needAlert(IADRE)) {
					addAlert("Inspecci??n auditiva para determinar ruidos extra??os", id, "1", "1");
				}
			
				if(Calculator.needAlert(IVMPAB)) {
					addAlert("Inspecci??n visual del man??metro de presi??n al activarse la bomba", id, "1", "1");
				}
				
				if(Calculator.needAlert(ITDVE)) {
					addAlert("Inspecci??n t??ctil para determinar vibraciones excesivas", id, "1", "1");
				}
				
				if(Calculator.needAlert(IVDFTA)) {
					addAlert("Inspecci??n visual para detectar fugas en las tuber??as de agua", id, "1", "1");
				}
				
				if(Calculator.needAlert(IVDFTA)) {
					addAlert("Inspecci??n visual para detectar fugas en las tuber??as de agua", id, "1", "1");
				}
				
				if(Calculator.needAlert(MCEM)) {
					addAlert("Medici??n consumo el??ctrico del motor", id, "1", "1");
				}
				if(Calculator.needAlert(ITDVPC)) {
					addAlert("Inspecci??n de tuberia de succion para verificar que no haya p??rdida de cebaInspecci??n de tuberia de succion para verificar que no haya p??rdida de ceba", id, "1", "1");
				}
			
			}//end while
			rsDailyBomb.close();
			
			while (rsDailyCompresor.next()) {
				String id = rsDailyCompresor.getString("compresorID");
				String VFC = rsDailyCompresor.getString("VFC"); // Validar el funcionamiento del compresor
				String VFA = rsDailyCompresor.getString("VFA");// Verificar fugas de aceite
				String IADRE = rsDailyCompresor.getString("IADRE"); // Inspecci??n auditiva para determinar ruidos extra??os
				String AAJ = rsDailyCompresor.getString("AAJ");// Aplicar agua jabonosa en uniones para determinar fugas de aire
				String VFP = rsDailyCompresor.getString("VFP");// Verificar funcionamiento de presostato
			
				if(Calculator.needAlert(VFC)) {
					addAlert("Validar el funcionamiento del compresor", id, "1", "2");
				}
				
				if(Calculator.needAlert(VFA)) {
					addAlert("Verificar fugas de aceite", id, "1", "2");
				}
				
				if(Calculator.needAlert(IADRE)) {
					addAlert("Inspecci??n auditiva para determinar ruidos extra??os", id, "1", "2");
				}
				
				if(Calculator.needAlert(AAJ)) {
					addAlert("Aplicar agua jabonosa en uniones para determinar fugas de aire", id, "1", "2");
				}
				
				if(Calculator.needAlert(VFP)) {
					addAlert("Verificar funcionamiento de presostato", id, "1", "2");
				}
				
			}
			rsDailyCompresor.close();
			
			while (rsDailyBoard.next()) {
				String id = rsDailyBoard.getString("boardID");
				String MV = rsDailyBoard.getString("MV"); // Medici??n voltaje
				String MA = rsDailyBoard.getString("MA"); // Medici??n amperaje
				String VTTEC = rsDailyBoard.getString("VTTEC"); // Verificar a trav??s del tacto temperatura de los elementos de control
				
				if(Calculator.needAlert(MV)) {
					addAlert("Medici??n voltaje", id, "1", "3");
				}
				if(Calculator.needAlert(MA)) {
					addAlert("Medici??n amperaje", id, "1", "3");
				}
				if(Calculator.needAlert(VTTEC)) {
					addAlert("Verificar a trav??s del tacto temperatura de los elementos de control", id, "1", "3");
				}
		
			}
			rsDailyBoard.close();
			
			
			while (rsDailyPulmon.next()) {
				String id = rsDailyPulmon.getString("pulmonID");
				String VNA = rsDailyPulmon.getString("VNA"); // Verificar el nivel del agua
				String VFM = rsDailyPulmon.getString("VFM");// Verificar funcionamiento del man??metro
				String MPBCAB = rsDailyPulmon.getString("MPBCAB");// Medici??n de presi??n baja cuando activa la bomba
				String MPACAB = rsDailyPulmon.getString("MPACAB");// Medici??n de presi??n alta cuando apaga la bomba
				
				if(Calculator.needAlert(VNA)) {
					addAlert("Verificar el nivel del agua", id, "1", "4");
				}
				if(Calculator.needAlert(VFM)) {
					addAlert("Verificar funcionamiento del man??metro", id, "1", "4");
				}
				if(Calculator.needAlert(MPBCAB)) {
					addAlert("Medici??n de presi??n baja cuando activa la bomba", id, "1", "4");
				}
				if(Calculator.needAlert(MPACAB)) {
					addAlert("Medici??n de presi??n alta cuando apaga la bomba", id, "1", "4");
				}
				
			}
			rsDailyPulmon.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	///end daily alterts
	
	
	private static void getWeeklyAlerts() {
		
		ResultSet rsWeeklyBomb = ReadWeeklyAlert.GetBombWeeklyAlerts();
		ResultSet rsWeeklyCompresor = ReadWeeklyAlert.GetCompresorWeeklyAlerts();
		ResultSet rsWeeklyBoard = ReadWeeklyAlert.GetBoardWeeklyAlerts();
		
		try {
			
			while(rsWeeklyBomb.next()) {
				
				String id = rsWeeklyBomb.getString("bombID");
				String VTETS =  rsWeeklyBomb.getString("VTETS"); // Validar a trav??s del tacto temperatura externa de tuber??a de succi??n.
				String LRPPAC =  rsWeeklyBomb.getString("LRPPAC"); // Limpieza para retirar part??culas de polvo y agentes contaminantes
				
				if(Calculator.needWeeklyAlert(VTETS)) {
					addAlert("Validar a trav??s del tacto temperatura externa de tuber??a de succi??n.", id, "2", "1");
				}
				if(Calculator.needWeeklyAlert(LRPPAC)) {
					addAlert("Limpieza para retirar part??culas de polvo y agentes contaminantes.", id, "2", "1");
				}
			}
			
			while (rsWeeklyCompresor.next()) {
				String id = rsWeeklyCompresor.getString("compresorID");
				String ITDVE =  rsWeeklyCompresor.getString("ITDVE"); // Inspecci??n t??ctil para determinar vibraciones excesivas
				String MCE = rsWeeklyCompresor.getString("MCE"); // Medici??n de consumo el??ctrico 
				
				if(Calculator.needWeeklyAlert(ITDVE)) {
					addAlert("Inspecci??n t??ctil para determinar vibraciones excesivas.", id, "2", "2");
				}
				
				if(Calculator.needWeeklyAlert(MCE)) {
					addAlert("Medici??n de consumo el??ctrico ", id, "2", "2");
				}
				
			}
			
			while(rsWeeklyBoard.next()) {
				String id = rsWeeklyBoard.getString("boardID");
				String LEPP = rsWeeklyBoard.getString("LEPP");  // Limpieza para eliminar part??culas de polvo y agentes contaminantes
				
				if(Calculator.needWeeklyAlert(LEPP)) {
					addAlert("Limpieza para eliminar part??culas de polvo y agentes contaminantes.", id, "2", "3");
				}
				
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	//end weekly alerts
	
	private static void getMonthlyAlerts() {
		
		ResultSet rsMonthlyBomb = ReadMonthlyAlert.GetBombMonthlyAlerts();
		ResultSet rsMonthlyCompresor = ReadMonthlyAlert.GetCompresorMonthlyAlerts();
		ResultSet rsMonthlyBoard = ReadMonthlyAlert.GetBoardMonthlyAlerts();
		
		try {
			while(rsMonthlyBomb.next()) {
				String id = rsMonthlyBomb.getString("bombID"); 
				String APTAB = rsMonthlyBomb.getString("APTAB"); // Ajustar pernos y tornillos de anclaje de la base
				
				if(Calculator.needMonthlyAlert(APTAB)) {
					addAlert("Ajustar pernos y tornillos de anclaje de la base", id, "3", "1");
				}
			}
			
			while(rsMonthlyCompresor.next()) {
				String id = rsMonthlyCompresor.getString("compresorID");
				String VTCT = rsMonthlyCompresor.getString("VTCT"); // Verificar tensi??n de correa de transmisi??n
				String VNA = rsMonthlyCompresor.getString("VNA");  // Verificar nivel de aceite
				
				if(Calculator.needMonthlyAlert(VTCT)) {
					addAlert("Verificar tensi??n de correa de transmisi??n", id, "3", "2");
				}
				if(Calculator.needMonthlyAlert(VNA)) {
					addAlert("Verificar nivel de aceite", id, "3", "2");
				}
			}
			
			while(rsMonthlyBoard.next()) {
				String id = rsMonthlyBoard.getString("boardID");
				String VCS = rsMonthlyBoard.getString("VCS"); // Verificar que no haya cables sulfatados
				
				if(Calculator.needMonthlyAlert(VCS)) {
					addAlert("Verificar que no haya cables sulfatados", id, "3", "3");
				}
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
