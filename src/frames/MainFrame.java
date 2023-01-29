package frames;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




@SuppressWarnings("serial")
public class MainFrame extends JFrame {
//Frames
	private RegisterFrame registerFrame  = new RegisterFrame();
	private ListEquipament listFrame = new ListEquipament();
	private Selection selectionFrame = new Selection();

	//Functrions
	
	//close all frames
	private void closeAllFrames() {
		
		registerFrame.setVisible(false);
		listFrame.setVisible(false);
		selectionFrame.dispose();
		
	}

	public MainFrame() {
		getContentPane().setBackground(SystemColor.text);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/img/icono.png")));
		setTitle("Hydropneumatic Equipment Management Software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(800, 600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(SystemColor.text);
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
				listFrame.loadList();
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
		panelWarning.setBackground(SystemColor.text);
		panelWarning.setForeground(SystemColor.textHighlight);
		panelWarning.setBorder(new TitledBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(0, 120, 215)), "Alertas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 120, 215)));
		getContentPane().add(panelWarning, BorderLayout.CENTER);
		
		JPanel panelMessage = new JPanel();
		panelMessage.setBackground(SystemColor.text);
		getContentPane().add(panelMessage, BorderLayout.NORTH);
		panelMessage.setLayout(new MigLayout("", "[119.00px][381.00]", "[41.00px]"));
		
		JPanel panelEstado = new JPanel();
		panelEstado.setBackground(SystemColor.text);
		getContentPane().add(panelEstado, BorderLayout.SOUTH);
		panelEstado.setLayout(new MigLayout("", "[]", "[42.00]"));
	}
	

	
	
}
