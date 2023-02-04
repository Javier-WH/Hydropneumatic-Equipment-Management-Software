package frames;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import actors.Alert;
import actors.CorrectiveMantenanceActor;
import panels.AlertPanel;
import panels.CorrectivePanel;
import sql.Corrective;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;




@SuppressWarnings("serial")
public class CorrectiveMantenanceList extends JDialog {

	private static JPanel listPanel = new JPanel();
	private static int counter = 0;
	private static Container panel = null;

	public CorrectiveMantenanceList() {
		panel = getContentPane();
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CorrectiveMantenanceList.class.getResource("/img/icono.png")));
		setTitle("Lista de Equipos");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(800, 744);
		getContentPane().setLayout(new BorderLayout());
		
		JLabel lblNewLabel = new JLabel("REGISTROS DE MANTENIMIENTO CORRECTIVO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		listPanel.setBackground(Color.WHITE);
		
		JScrollPane scrollPane =  new JScrollPane(listPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
	
		fillList();
	}
	
	
	public static void fillList() {
		listPanel.removeAll();
		listPanel.revalidate();
		listPanel.repaint();
		counter = 0;
		
		ArrayList<CorrectiveMantenanceActor> list = Corrective.getCorrectiveObjects();
		
		for(int i = 0; i < list.size() ; i++) {
			
			listPanel.add(new CorrectivePanel(list.get(i), panel));
			
			listPanel.setPreferredSize(new Dimension(600, counter  * 125));
		}
		
		

	}





	
	




}
