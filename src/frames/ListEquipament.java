package frames;

import javax.swing.JDialog;

import sql.GetEquipmentList;

import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JScrollPane;

import actors.WaterPump;
import panels.PumpPanel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;



@SuppressWarnings("serial")
public class ListEquipament extends JDialog {
	private static int elementsCounter = 0;
	private static JPanel listPanel = new JPanel();
	private static JLabel lblInfo = new JLabel("New label");
	
	private static Container container = null;
	
	public ListEquipament() {
		container = getContentPane();
		getContentPane().setBackground(new Color(255, 255, 255));
		setResizable(false);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListEquipament.class.getResource("/img/icono.png")));
		setTitle("Lista de Equipos");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(800, 744);
		getContentPane().setLayout(null);
		BoxLayout boxlayout = new BoxLayout(listPanel, BoxLayout.PAGE_AXIS);
		listPanel.setBackground(new Color(255, 255, 255));
		listPanel.setBorder(null);
		listPanel.setLayout(boxlayout);
		JScrollPane scrollPane = new JScrollPane(listPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		scrollPane.setBounds(0, 52, 762, 627);
		getContentPane().add(scrollPane);
		
	
		lblInfo.setForeground(new Color(0, 102, 255));
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInfo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInfo.setBounds(184, 27, 578, 14);
		getContentPane().add(lblInfo);

	}

	public static void addItem(WaterPump pump) {
			
		listPanel.add(new PumpPanel(pump, container));
		elementsCounter ++;
	}
	

	
	public static void loadList() {
		//limpia la lista antes de agregar nuevos elementos
		listPanel.removeAll();
		listPanel.revalidate();
		listPanel.repaint();
		elementsCounter = 0;
		//
		ResultSet list = GetEquipmentList.getList();
		try {
			while (list.next()) {
				
				WaterPump pump = new WaterPump();
				pump.setCode(list.getString("code"));
				pump.setName(list.getString("name"));
				pump.setModel(list.getString("model"));
				pump.setMark(list.getString("mark"));
				pump.setId(list.getString("id"));
				pump.setPictureAddress(list.getString("picture"));
				addItem(pump);
			
			}
			
			lblInfo.setText(String.valueOf(elementsCounter)+ " Equipos registrados");
			listPanel.setPreferredSize(new Dimension(800, elementsCounter * 120));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
