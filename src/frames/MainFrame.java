package frames;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import panels.AlertPanel;
import sql.SQLConnection;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;

import actors.Alert;
import auxiliar.CalculateDailyAlerts;
import maintenanceSheet.Sheet;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;




@SuppressWarnings("serial")
public class MainFrame extends JFrame {
//Frames
	private RegisterFrame registerFrame  = new RegisterFrame();
	private ListEquipament listFrame = new ListEquipament();
	private Selection selectionFrame = new Selection();
	private Sheet maintenance = new Sheet();
	private static JPanel panel = new JPanel();
	private static int altertCounter = 0;
	private static JLabel lblAlertMessage = new JLabel("Alertas Pendientes");
	//Functrions
	
	//close all frames
	private void closeAllFrames() {
		
		registerFrame.setVisible(false);
		listFrame.setVisible(false);
		selectionFrame.dispose();
		maintenance.dispose();
		
	}

	public MainFrame() {
		getContentPane().setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/img/icono.png")));
		setTitle("Hydropneumatic Equipment Management Software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1056, 600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(Color.WHITE);
		getContentPane().add(panelMenu, BorderLayout.WEST);
		panelMenu.setLayout(new MigLayout("", "[236.00]", "[][][][][][][][]"));
		
		JButton btnRegister = new JButton("Registrar Equipo");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeAllFrames();
				selectionFrame.setLocationRelativeTo(getContentPane());
				selectionFrame.setVisible(true);
				//registerFrame.setLocationRelativeTo(getContentPane());
				//registerFrame.setVisible(true);
			}
		});
	
			
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setFont(new Font("Verdana", Font.BOLD, 16));
		btnRegister.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegister.setIcon(new ImageIcon(MainFrame.class.getResource("/img/add.png")));
		btnRegister.setBackground(new Color(0, 102, 204));
		panelMenu.add(btnRegister, "cell 0 0,growx");
		
		JButton btnMaintenance = new JButton("Mantenimiento");
		btnMaintenance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeAllFrames();
				maintenance.setLocationRelativeTo(getContentPane());
				maintenance.setVisible(true);
				
			}
		});
		btnMaintenance.setIcon(new ImageIcon(MainFrame.class.getResource("/img/wrench.png")));
		btnMaintenance.setHorizontalAlignment(SwingConstants.LEFT);
		btnMaintenance.setForeground(Color.WHITE);
		btnMaintenance.setFont(new Font("Verdana", Font.BOLD, 16));
		btnMaintenance.setBackground(new Color(0, 102, 204));
		panelMenu.add(btnMaintenance, "cell 0 1,growx");
		
		JButton btnList = new JButton("Equipos registrados");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				closeAllFrames();
				listFrame.setLocationRelativeTo(getContentPane());
				ListEquipament.loadList();
				listFrame.setVisible(true);
			}
		});
		btnList.setIcon(new ImageIcon(MainFrame.class.getResource("/img/list.png")));
		btnList.setHorizontalAlignment(SwingConstants.LEFT);
		btnList.setForeground(Color.WHITE);
		btnList.setFont(new Font("Verdana", Font.BOLD, 16));
		btnList.setBackground(new Color(0, 102, 204));
		panelMenu.add(btnList, "cell 0 2,grow");
		
		JButton btnCalendar = new JButton("Cronograma");
		btnCalendar.setIcon(new ImageIcon(MainFrame.class.getResource("/img/calendar.png")));
		btnCalendar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCalendar.setForeground(Color.WHITE);
		btnCalendar.setFont(new Font("Verdana", Font.BOLD, 16));
		btnCalendar.setBackground(new Color(0, 102, 204));
		panelMenu.add(btnCalendar, "cell 0 3,grow");
		
		JButton btnConfig = new JButton("Configuración");
		btnConfig.setIcon(new ImageIcon(MainFrame.class.getResource("/img/options.png")));
		btnConfig.setHorizontalAlignment(SwingConstants.LEFT);
		btnConfig.setForeground(Color.WHITE);
		btnConfig.setFont(new Font("Verdana", Font.BOLD, 16));
		btnConfig.setBackground(new Color(0, 102, 204));
		panelMenu.add(btnConfig, "cell 0 4,grow");
		
		JButton btnReport = new JButton("Reportes");
		btnReport.setIcon(new ImageIcon(MainFrame.class.getResource("/img/reports.png")));
		btnReport.setHorizontalAlignment(SwingConstants.LEFT);
		btnReport.setForeground(Color.WHITE);
		btnReport.setFont(new Font("Verdana", Font.BOLD, 16));
		btnReport.setBackground(new Color(0, 102, 204));
		panelMenu.add(btnReport, "cell 0 5,grow");
		
		JButton btnExit = new JButton("Salir");
		btnExit.setIcon(new ImageIcon(MainFrame.class.getResource("/img/exit.png")));
		btnExit.setHorizontalAlignment(SwingConstants.LEFT);
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Verdana", Font.BOLD, 16));
		btnExit.setBackground(new Color(0, 102, 204));
		panelMenu.add(btnExit, "cell 0 6,grow");
		
		JPanel panelWarning = new JPanel();
		panelWarning.setBackground(Color.WHITE);
		panelWarning.setForeground(SystemColor.textHighlight);
		panelWarning.setBorder(new TitledBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(0, 120, 215)), "Alertas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 120, 215)));
		getContentPane().add(panelWarning, BorderLayout.CENTER);
		panelWarning.setLayout(new BorderLayout(0, 0));
		
		
		

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
		panel.setBackground(Color.WHITE);
		panel.setLayout(boxlayout);
	
		JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBackground(Color.WHITE);
	
		panelWarning.add(scrollPane);

		
	

		
		JPanel panelMessage = new JPanel();
		panelMessage.setBackground(Color.WHITE);
		getContentPane().add(panelMessage, BorderLayout.NORTH);
		panelMessage.setLayout(new MigLayout("", "[119.00px][250.00][][][][][][201.00][311.00][381.00]", "[41.00px]"));
		
	
		lblAlertMessage.setForeground(new Color(139, 0, 0));
		lblAlertMessage.setFont(new Font("Vrinda", Font.ITALIC, 16));
		lblAlertMessage.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMessage.add(lblAlertMessage, "cell 9 0,alignx right,aligny center");
		
		JPanel panelEstado = new JPanel();
		panelEstado.setBackground(Color.WHITE);
		getContentPane().add(panelEstado, BorderLayout.SOUTH);
		panelEstado.setLayout(new MigLayout("", "[]", "[42.00]"));
		
		loadAlerts();
	}
	

	public static void loadAlerts() {
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
		altertCounter = 0;
		
		
		ArrayList<Alert> alertList = CalculateDailyAlerts.getAlertList();
		
		for(int i = 0 ; i < alertList.size() ; i++) {
			panel.add(new AlertPanel(alertList.get(i)));
			altertCounter++;
		}
		
		panel.setPreferredSize(new Dimension(1000, altertCounter * 125));
		lblAlertMessage.setText(altertCounter + " Alertas Pendientes");
		
		
	}

	
	
	
}
