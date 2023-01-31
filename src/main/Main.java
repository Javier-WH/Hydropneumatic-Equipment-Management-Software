/*
 * Software creado por Francisco Javier Rodríguez Hernández
 * 1/26/2023 Altagracia de Orituco, Estado Guarico, Venezuela.
 * Sistema de administración de equipos hidroelectricos
  */

package main;



import frames.*;
import sql.CreateTables;
import sql.SQLConnection;


public class Main {

	private static MainFrame mainFrame = new MainFrame();

	public static void main(String[] args) {
		

		
	CreateTables.createPump();
		
		
		

		

		
		mainFrame.setVisible(true);

	}

}


