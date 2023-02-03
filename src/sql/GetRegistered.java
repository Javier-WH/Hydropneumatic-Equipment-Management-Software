package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GetRegistered {
	

	public static ArrayList<String> getDaily(String register){
		
		ArrayList<String> list = new ArrayList<String>();
		String gg = "No realizado";
		
		
		Connection connection = SQLConnection.getConection();
		
		
			String SQLcompresor = "SELECT * FROM  compresor_registered_daily_mantenance WHERE register = ?";
			String SQLbomb = "SELECT * FROM  bomb_registered_daily_mantenance WHERE register = ?";
			String SQLpulmon = "SELECT * FROM  pulmon_registered_daily_mantenance WHERE register = ?";
			String SQLboard = "SELECT * FROM  board_registered_daily_mantenance WHERE register = ?";

			try {
				PreparedStatement stCompresor = connection.prepareStatement(SQLcompresor);
				stCompresor.setString(1, register);
				ResultSet rsCompresor =stCompresor.executeQuery();
				
				PreparedStatement stBomb = connection.prepareStatement(SQLbomb);
				stBomb.setString(1, register);
				ResultSet rsBomb =stBomb.executeQuery();
				
				PreparedStatement stPulmon = connection.prepareStatement(SQLpulmon);
				stPulmon.setString(1, register);
				ResultSet rsPulmon =stPulmon.executeQuery();
				
				PreparedStatement stBoard = connection.prepareStatement(SQLboard);
				stBoard.setString(1, register);
				ResultSet rsBoard =stPulmon.executeQuery();
				
				if(rsCompresor.next()) {
					String AAJ = rsCompresor.getString("AAJ");
					String IADRE = rsCompresor.getString("IADRE");
					String VFA = rsCompresor.getString("VFA");
					String VFC = rsCompresor.getString("VFC");
					String VFP = rsCompresor.getString("VFP");
					String otro1 = rsCompresor.getString("AAJ");
					String otro2 =rsCompresor.getString("AAJ");

					list.add(AAJ.length() > 0 ? AAJ: gg);
					list.add(IADRE.length() > 0 ? IADRE: gg);
					list.add(VFA.length() > 0 ? VFA: gg);
					list.add(VFC.length() > 0 ? VFC: gg);
					list.add(VFP.length() > 0 ? VFP: gg);
					list.add(otro1.length() > 0 ? otro1: gg);
					list.add(otro2.length() > 0 ? otro2: gg);
				}else {
					ArrayList<String>placeholders = new ArrayList<>(Arrays.asList(gg, gg, gg, gg, gg, gg, gg));
					list.addAll(placeholders);
				}
				
				if(rsBomb.next()) {
					String IADRE = rsBomb.getString("IADRE");
					String ITDVPC = rsBomb.getString("ITDVPC");
					String ITDVE = rsBomb.getString("ITDVE");
					String IVMPAB = rsBomb.getString("IVMPAB");
					String IVDFTA = rsBomb.getString("IVDFTA");
					String MCEM = rsBomb.getString("MCEM");
					String VFB = rsBomb.getString("VFB");
					String otro = rsBomb.getString("VFB");
					
					list.add(IADRE.length() > 0 ? IADRE: gg);
					list.add(ITDVPC.length() > 0 ? ITDVPC: gg);
					list.add(ITDVE.length() > 0 ? ITDVE: gg);
					list.add(IVMPAB.length() > 0 ? IVMPAB: gg);
					list.add(IVDFTA.length() > 0 ? IVDFTA: gg);
					list.add(MCEM.length() > 0 ? MCEM: gg);
					list.add(VFB.length() > 0 ? VFB: gg);
					list.add(otro.length() > 0 ? otro: gg);
				}else {
					ArrayList<String>placeholders = new ArrayList<>(Arrays.asList(gg, gg, gg, gg, gg, gg, gg, gg));
					list.addAll(placeholders);
				}
					
				if(rsPulmon.next()) {
					String MPACAB = rsPulmon.getString("MPACAB");
					String MPBCAB = rsPulmon.getString("MPBCAB");
					String VNA = rsPulmon.getString("VNA");
					String VFM = rsPulmon.getString("VFM");
					
					list.add(MPACAB.length() > 0 ? MPACAB: gg);
					list.add(MPBCAB.length() > 0 ? MPBCAB: gg);
					list.add(VNA.length() > 0 ? VNA: gg);
					list.add(VFM.length() > 0 ? VFM: gg);
				}else {
					ArrayList<String>placeholders = new ArrayList<>(Arrays.asList(gg, gg, gg, gg));
					list.addAll(placeholders);
				}
				
				if(rsBoard.next()) {
					
					String MA = rsBoard.getString("MA");
					String MV = rsBoard.getString("MV");
					String VTTEC = rsBoard.getString("VTTEC");
					
					list.add(MA.length() > 0 ? MA: gg);
					list.add(MV.length() > 0 ? MV: gg);
					list.add(VTTEC.length() > 0 ? VTTEC: gg);
				}else {
					ArrayList<String>placeholders = new ArrayList<>(Arrays.asList(gg, gg, gg));
					list.addAll(placeholders);
				}
				
			} catch (SQLException e) {
				e.getStackTrace();
			}
	
			
		
		
		return list;
	}
	
}
