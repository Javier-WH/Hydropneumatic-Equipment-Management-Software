package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import actors.CuantitativeActor;
import actors.Mesure;

public class MesureList {

	public static Connection connection = SQLConnection.getConection();
	
	
	public static void saveCuantitativeMesure(CuantitativeActor data) {
	
		String SQL = "REPLACE  INTO mesuresList ( "
				+ "type,"
				+ "boss, "
				+ "operator, "
				+ "controlNumber, "
				+ "observations, "
				+ "date, "
				+ "Cvoltaje,"
				+ "Bvoltaje, "
				+ "Camperaje, "
				+ "Bamperaje, "
				+ "PpresionAlta, "
				+ "Ppresionbaja, "
				+ "dates ) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
		
		try {
			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, data.getMesureType());
			st.setString(2, data.getUser().getMantenanceBoss());
			st.setString(3, data.getUser().getOperator());
			st.setString(4, data.getUser().getControlNumber());
			st.setString(5, data.getObservations());
			st.setString(6, data.getDate());
			st.setString(7, data.getCvoltaje());
			st.setString(8, data.getBvoltaje());
			st.setString(9, data.getCamperaje());
			st.setString(10, data.getBamperaje());
			st.setString(11, data.getPpresionAlta());
			st.setString(12, data.getPpresionBaja());
			st.setString(13, data.getDates());

			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	//
	
	public static ArrayList<Mesure> getMesurelist(){
		
		ArrayList<Mesure> list = new ArrayList<Mesure>();
		
		String SQL = "SELECT * FROM mesuresList ORDER BY id DESC";
		
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			
			while (rs.next()) {
				Mesure m = new Mesure();
				m.setMesureType(rs.getString("type"));
				m.getUser().setMantenanceBoss(rs.getString("boss"));
				m.getUser().setOperator(rs.getString("operator"));
				m.getUser().setControlNumber(rs.getString("controlNumber"));
				m.setObservations(rs.getString("observations"));
				m.setDate(rs.getString("date"));
				m.setId(rs.getString("id"));
				list.add(m);
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	public static CuantitativeActor getCuantitativeByid(String id){
				
		String SQL = "SELECT * FROM mesuresList WHERE id = ?";
		
		CuantitativeActor data = new CuantitativeActor();
		
		try {
			PreparedStatement st = connection.prepareStatement(SQL);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				data.setId(rs.getString("id"));
				data.setMesureType(rs.getString("type"));
				data.getUser().setMantenanceBoss(rs.getString("boss"));
				data.getUser().setOperator(rs.getString("operator"));
				data.getUser().setControlNumber(rs.getString("controlNumber"));
				data.setObservations(rs.getString("observations"));
				data.setDate(rs.getString("date"));
				data.setCvoltaje(rs.getString("Cvoltaje"));
				data.setBvoltaje(rs.getString("Bvoltaje"));
				data.setCamperaje(rs.getString("Camperaje"));
				data.setBamperaje(rs.getString("Bamperaje"));
				data.setPpresionAlta(rs.getString("PpresionAlta"));
				data.setPpresionBaja(rs.getString("Ppresionbaja"));
				data.setDates(rs.getString("dates"));
			}
			
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	
	}
}
