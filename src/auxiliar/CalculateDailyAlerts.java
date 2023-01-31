package auxiliar;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import actors.Alert;
import sql.GetEquipamentById;
import sql.ReadDailyAlert;
import sql.ReadMonthlyAlert;
import sql.ReadWeeklyAlert;

public class CalculateDailyAlerts {
	private static ArrayList<Alert> dailyAlerts = new ArrayList<Alert>();
	
	public static ArrayList<Alert> getAlertList(){
		dailyAlerts.clear();
		
		getDailyAlerts();
		getWeeklyAlerts();
		
		return dailyAlerts;
	}
	
	private static void addAlert(String alertText, String equipamentID) {
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
				String IADRE = rsDailyBomb.getString("IADRE"); //Inspección auditiva para determinar ruidos extraños
				String IVMPAB = rsDailyBomb.getString("IVMPAB"); //Inspección visual del manómetro de presión al activarse la bomba
				String ITDVE = rsDailyBomb.getString("ITDVE"); // Inspección táctil para determinar vibraciones excesivas
				String IVDFTA = rsDailyBomb.getString("IVDFTA"); //Inspección visual para detectar fugas en las tuberías de agua
				String MCEM = rsDailyBomb.getString("MCEM"); //Medición consumo eléctrico del motor
				String ITDVPC = rsDailyBomb.getString("ITDVPC"); //Inspección de tuberia de succion para verificar que no haya pérdida de cebaInspección de tuberia de succion para verificar que no haya pérdida de ceba
			
				if(Calculator.needAlert(VFB)) {
					addAlert("Validar el funcionamiento de la bomba", id);
				}
				if(Calculator.needAlert(IADRE)) {
					addAlert("Inspección auditiva para determinar ruidos extraños", id);
				}
			
				if(Calculator.needAlert(IVMPAB)) {
					addAlert("Inspección visual del manómetro de presión al activarse la bomba", id);
				}
				
				if(Calculator.needAlert(ITDVE)) {
					addAlert("Inspección táctil para determinar vibraciones excesivas", id);
				}
				
				if(Calculator.needAlert(IVDFTA)) {
					addAlert("Inspección visual para detectar fugas en las tuberías de agua", id);
				}
				
				if(Calculator.needAlert(IVDFTA)) {
					addAlert("Inspección visual para detectar fugas en las tuberías de agua", id);
				}
				
				if(Calculator.needAlert(MCEM)) {
					addAlert("Medición consumo eléctrico del motor", id);
				}
				if(Calculator.needAlert(ITDVPC)) {
					addAlert("Inspección de tuberia de succion para verificar que no haya pérdida de cebaInspección de tuberia de succion para verificar que no haya pérdida de ceba", id);
				}
			
			}//end while
			rsDailyBomb.close();
			
			while (rsDailyCompresor.next()) {
				String id = rsDailyCompresor.getString("compresorID");
				String VFC = rsDailyCompresor.getString("VFC"); // Validar el funcionamiento del compresor
				String VFA = rsDailyCompresor.getString("VFA");// Verificar fugas de aceite
				String IADRE = rsDailyCompresor.getString("IADRE"); // Inspección auditiva para determinar ruidos extraños
				String AAJ = rsDailyCompresor.getString("AAJ");// Aplicar agua jabonosa en uniones para determinar fugas de aire
				String VFP = rsDailyCompresor.getString("VFP");// Verificar funcionamiento de presostato
			
				if(Calculator.needAlert(VFC)) {
					addAlert("Validar el funcionamiento del compresor", id);
				}
				
				if(Calculator.needAlert(VFA)) {
					addAlert("Verificar fugas de aceite", id);
				}
				
				if(Calculator.needAlert(IADRE)) {
					addAlert("Inspección auditiva para determinar ruidos extraños", id);
				}
				
				if(Calculator.needAlert(AAJ)) {
					addAlert("Aplicar agua jabonosa en uniones para determinar fugas de aire", id);
				}
				
				if(Calculator.needAlert(VFP)) {
					addAlert("Verificar funcionamiento de presostato", id);
				}
				
			}
			rsDailyCompresor.close();
			
			while (rsDailyBoard.next()) {
				String id = rsDailyBoard.getString("boardID");
				String MV = rsDailyBoard.getString("MV"); // Medición voltaje
				String MA = rsDailyBoard.getString("MA"); // Medición amperaje
				String VTTEC = rsDailyBoard.getString("VTTEC"); // Verificar a través del tacto temperatura de los elementos de control
				
				if(Calculator.needAlert(MV)) {
					addAlert("Medición voltaje", id);
				}
				if(Calculator.needAlert(MA)) {
					addAlert("Medición amperaje", id);
				}
				if(Calculator.needAlert(VTTEC)) {
					addAlert("Verificar a través del tacto temperatura de los elementos de control", id);
				}
		
			}
			rsDailyBoard.close();
			
			
			while (rsDailyPulmon.next()) {
				String id = rsDailyPulmon.getString("pulmonID");
				String VNA = rsDailyPulmon.getString("VNA"); // Verificar el nivel del agua
				String VFM = rsDailyPulmon.getString("VFM");// Verificar funcionamiento del manómetro
				String MPBCAB = rsDailyPulmon.getString("MPBCAB");// Medición de presión baja cuando activa la bomba
				String MPACAB = rsDailyPulmon.getString("MPACAB");// Medición de presión alta cuando apaga la bomba
				
				if(Calculator.needAlert(VNA)) {
					addAlert("Verificar el nivel del agua", id);
				}
				if(Calculator.needAlert(VFM)) {
					addAlert("Verificar funcionamiento del manómetro", id);
				}
				if(Calculator.needAlert(MPBCAB)) {
					addAlert("Medición de presión baja cuando activa la bomba", id);
				}
				if(Calculator.needAlert(MPACAB)) {
					addAlert("Medición de presión alta cuando apaga la bomba", id);
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
				String VTETS =  rsWeeklyBomb.getString("VTETS"); // Validar a través del tacto temperatura externa de tubería de succión.
				String LRPPAC =  rsWeeklyBomb.getString("LRPPAC"); // Limpieza para retirar partículas de polvo y agentes contaminantes
				
				if(Calculator.needWeeklyAlert(VTETS)) {
					addAlert("Validar a través del tacto temperatura externa de tubería de succión.", id);
				}
				if(Calculator.needWeeklyAlert(LRPPAC)) {
					addAlert("Limpieza para retirar partículas de polvo y agentes contaminantes.", id);
				}
			}
			
			while (rsWeeklyCompresor.next()) {
				String id = rsWeeklyCompresor.getString("compresorID");
				String ITDVE =  rsWeeklyCompresor.getString("ITDVE"); // Inspección táctil para determinar vibraciones excesivas
				String MCE = rsWeeklyCompresor.getString("MCE"); // Medición de consumo eléctrico 
				
				if(Calculator.needWeeklyAlert(ITDVE)) {
					addAlert("Inspección táctil para determinar vibraciones excesivas.", id);
				}
				
				if(Calculator.needWeeklyAlert(MCE)) {
					addAlert("Medición de consumo eléctrico ", id);
				}
				
			}
			
			while(rsWeeklyBoard.next()) {
				String id = rsWeeklyBoard.getString("boardID");
				String LEPP = rsWeeklyBoard.getString("LEPP");  // Limpieza para eliminar partículas de polvo y agentes contaminantes
				
				if(Calculator.needWeeklyAlert(LEPP)) {
					addAlert("Limpieza para eliminar partículas de polvo y agentes contaminantes.", id);
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
					addAlert("Ajustar pernos y tornillos de anclaje de la base", id);
				}
			}
			
			while(rsMonthlyCompresor.next()) {
				String id = rsMonthlyCompresor.getString("compresorID");
				String VTCT = rsMonthlyCompresor.getString("VTCT"); // Verificar tensión de correa de transmisión
				String VNA = rsMonthlyCompresor.getString("VNA");  // Verificar nivel de aceite
				
				if(Calculator.needMonthlyAlert(VTCT)) {
					addAlert("Verificar tensión de correa de transmisión", id);
				}
				if(Calculator.needMonthlyAlert(VNA)) {
					addAlert("Verificar nivel de aceite", id);
				}
			}
			
			while(rsMonthlyBoard.next()) {
				String id = rsMonthlyBoard.getString("boardID");
				String VCS = rsMonthlyBoard.getString("VCS"); // Verificar que no haya cables sulfatados
				
				if(Calculator.needMonthlyAlert(VCS)) {
					addAlert("Verificar que no haya cables sulfatados", id);
				}
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}