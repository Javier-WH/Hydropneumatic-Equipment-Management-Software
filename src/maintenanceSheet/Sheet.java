package maintenanceSheet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import sql.CreateMantenanceRegister;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import actors.Alert;
import actors.BoardDailyMantenance;
import actors.BoardMonthlyMantenance;
import actors.BoardWeeklyMantenance;
import actors.BombDailyMantenance;
import actors.BombMonthlyMantenance;
import actors.BombWeeklyMantenance;
import actors.CompresorDailyMantenance;
import actors.CompresorMonthlyMantenance;
import actors.CompresorWeeklyMantenance;
import actors.PulmonDailyMantenance;
import actors.User;

import frames.MainFrame;
import frames.RegisterList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class Sheet extends JFrame {

	private static JPanel contentPane;
	private static JTextField textBoss;
	private static JTextField textOperator;
	private static JTextField textControlNumber;
	private static JPanel panelAlert  = new JPanel();;
	
	
	@SuppressWarnings("rawtypes")
	private static JComboBox comboBox = new JComboBox();
	private JLabel lblFecha = new JLabel("");
	private static JLabel lblEquipaments = new JLabel("Bomba Monobloc, Compresor, Tablero de control, Pulmon Hitroneumatico");
	private static boolean enabledBomb = false;
	private static boolean enabledCompresor = false;
	private static boolean enabledPulmon = false;
	private static boolean enabledBoard = false;

	///////
	
	private static BombDailyMantenance bombDaily = new BombDailyMantenance();
	private static CompresorDailyMantenance compresorDaily = new CompresorDailyMantenance();
	private static PulmonDailyMantenance pulmonDaily = new PulmonDailyMantenance();
	private static BoardDailyMantenance boardDaily = new BoardDailyMantenance();
	///
	private static BombWeeklyMantenance bombWeekly = new BombWeeklyMantenance();
	private static CompresorWeeklyMantenance compresorWeekly = new CompresorWeeklyMantenance();
	private static BoardWeeklyMantenance boardWeekly = new BoardWeeklyMantenance();
	///
	
	private static BombMonthlyMantenance bombMonthly = new BombMonthlyMantenance();
	private static CompresorMonthlyMantenance compresorMonthly = new CompresorMonthlyMantenance();
	private static BoardMonthlyMantenance boardMonthly = new BoardMonthlyMantenance();
	
	//
	
	private static User user = new User();
	


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Sheet(Alert alert) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sheet.class.getResource("/img/icono.png")));
		setTitle("Mantenimiento Preventivo");
		setBounds(100, 100, 676, 762);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelData = new JPanel();
		panelData.setAlignmentY(Component.TOP_ALIGNMENT);
		panelData.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelData.setBackground(Color.WHITE);
		contentPane.add(panelData);
		panelData.setLayout(new MigLayout("", "[][grow]", "[][][][][][46.00][520.00][-53.00][30.00]"));
		
		JLabel lblNewLabel = new JLabel("Equipos:");
		lblNewLabel.setForeground(new Color(0, 102, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelData.add(lblNewLabel, "cell 0 0");
		

		lblEquipaments.setForeground(new Color(0, 102, 255));
		lblEquipaments.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelData.add(lblEquipaments, "cell 1 0");
		
		JLabel lblJefeDeMantenimiento = new JLabel("Jefe de Mantenimiento:");
		lblJefeDeMantenimiento.setForeground(new Color(0, 102, 255));
		lblJefeDeMantenimiento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelData.add(lblJefeDeMantenimiento, "cell 0 1,alignx left");
		
		textBoss = new JTextField();
		textBoss.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		textBoss.setForeground(new Color(0, 102, 255));
		panelData.add(textBoss, "cell 1 1,growx");
		textBoss.setColumns(10);
		
		JLabel lblOperador = new JLabel("Operador:");
		lblOperador.setForeground(new Color(0, 102, 255));
		lblOperador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelData.add(lblOperador, "cell 0 2,alignx left");
		
		textOperator = new JTextField();
		textOperator.setForeground(new Color(0, 102, 255));
		textOperator.setColumns(10);
		textOperator.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		panelData.add(textOperator, "cell 1 2,growx");
		
		JLabel lblNmeroDeControl = new JLabel("Número de Control:");
		lblNmeroDeControl.setForeground(new Color(0, 102, 255));
		lblNmeroDeControl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelData.add(lblNmeroDeControl, "cell 0 3,alignx left");
		
		textControlNumber = new JTextField();
		textControlNumber.setForeground(new Color(0, 102, 255));
		textControlNumber.setColumns(10);
		textControlNumber.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		panelData.add(textControlNumber, "cell 1 3,growx");
		
		JLabel lblFrecuencia = new JLabel("Frecuencia:");
		lblFrecuencia.setForeground(new Color(0, 102, 255));
		lblFrecuencia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelData.add(lblFrecuencia, "cell 0 4,alignx left");
		
		comboBox = new JComboBox();
		comboBox.setBorder(null);
		comboBox.setOpaque(false);
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(new Color(0, 102, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Diaria", "Semanal", "Mensual"}));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putDailyAlerts();
				changeEquipaments();
			}
		});
		comboBox.setSelectedIndex(0);

		panelData.add(comboBox, "cell 1 4,growx");
		
		
		lblFecha.setForeground(new Color(0, 102, 255));
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelData.add(lblFecha, "cell 1 5,alignx right,aligny center");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelData.add(scrollPane, "cell 0 6 2 1,grow");
		
		
		panelAlert = new JPanel();
		panelAlert.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane.setViewportView(panelAlert);
		putDailyAlerts();
		changeEquipaments();
		
		JButton btnCancelar = new JButton("Cancelar");
		panelData.add(btnCancelar, "cell 0 8");
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createUser();
				if(checkCodes()) {
					
					if(comboBox.getSelectedIndex() == 0) {
					
						if(enabledBomb) {
							sql.DailyBomb.updateData(bombDaily);
						}
						if(enabledCompresor) {
							sql.DailyCompresor.updateData(compresorDaily);
						}
						if(enabledPulmon) {
							sql.DailyPulmon.updateData(pulmonDaily);
						}
						if(enabledBoard) {
							sql.DailyBoard.updateData(boardDaily);
						}
						
						CreateMantenanceRegister.CreateDailyRegister(bombDaily, compresorDaily, pulmonDaily, boardDaily, user);
					
					}else if (comboBox.getSelectedIndex() == 1) {
					
						if(enabledBomb) {
							sql.WeeklyBomb.updateData(bombWeekly);
						}
						if(enabledCompresor) {
							sql.WeeklyCompresor.updateData(compresorWeekly);
						}
						if(enabledBoard) {
							sql.Weekly_board.updateData(boardWeekly);
						}
						CreateMantenanceRegister.CreateWeeklyRegister(bombWeekly, compresorWeekly, boardWeekly, user);
					
					}else if(comboBox.getSelectedIndex() == 2) {
					
						if(enabledBomb) {
							sql.MonthlyBomb.updateData(bombMonthly);
						}
						if(enabledCompresor) {
							sql.MonthlyCompresor.updateData(compresorMonthly);
						}
						if(enabledBoard) {
							sql.MonthyBoard.updateData(boardMonthly);
						}
						CreateMantenanceRegister.CreateMonthlyRegister(bombMonthly, compresorMonthly, boardMonthly, user);
					}
					JOptionPane.showMessageDialog(getContentPane(), "Se ha creado satisfactoriamente el registro del mantenimiento", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(getContentPane(), "Debe suministrar un coldigo para los equipos", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				
				
				MainFrame.loadAlerts();
				RegisterList.fillListPanel();
			}
		});
		panelData.add(btnAceptar, "cell 1 8,alignx right");
		cleanCodes();

		
		if(alert.getAlertName() != "void") {
			
			if(alert.getFrecuency().equals("1")) {
				comboBox.setSelectedIndex(0);
				if(alert.getType().equals("1")) {
					DailyBomb.setTextcode(alert.getCode());
					setDailyBombICode(alert.getCode());
				}
				else if(alert.getType().equals("2")) {
					DailyCompresor.setTextcode(alert.getCode());
					setDailyCompresorCode(alert.getCode());
				}
				else if(alert.getType().equals("3")) {
					DailyBoard.setTextcode(alert.getCode());
					setDailyBoardCode(alert.getCode());
				}
				else if(alert.getType().equals("4")) {
					DailyPulmon.setTextcode(alert.getCode());
					setDailyPulmonCode(alert.getCode());
				}
			}else if(alert.getFrecuency().equals("2")) {
				comboBox.setSelectedIndex(1);
				if(alert.getType().equals("1")) {
					WeeklyBomb.setTextcode(alert.getCode());
					setWeeklyBombCode(alert.getCode());
				}
				else if(alert.getType().equals("2")) {
					WeeklyCompresor.setTextcode(alert.getCode());
					setWeeklyCompresorCode(alert.getCode());
				}
				else if(alert.getType().equals("3")) {
					WeeklyBoard.setTextcode(alert.getCode());
					setWeeklyBoardCode(alert.getCode());
				}
			}else if(alert.getFrecuency().equals("3")) {
				comboBox.setSelectedIndex(2);
				if(alert.getType().equals("1")) {
					MonthlyBomb.setTextcode(alert.getCode());
					setMonthlyBombCode(alert.getCode());
				}
				else if(alert.getType().equals("2")) {
					MonthlyCompresor.setTextcode(alert.getCode());
					setMonthlyCompresorCode(alert.getCode());
				}
				else if(alert.getType().equals("3")) {
					MonthlyBoard.setTextcode(alert.getCode());
					setMonthlyBoardCode(alert.getCode());
				}
			}
			
			
		}


		
	}
	//end constructor 1
		

	//end constructor 2
	
	
	
	
	
	public static void cleanCodes() {
		DailyBomb.setTextcode("");
		DailyCompresor.setTextcode("");
		DailyBoard.setTextcode("");
		DailyPulmon.setTextcode("");
		WeeklyBomb.setTextcode("");
		WeeklyCompresor.setTextcode("");
		WeeklyBoard.setTextcode("");
		MonthlyBomb.setTextcode("");
		MonthlyCompresor.setTextcode("");
		MonthlyCompresor.setTextcode("");
		MonthlyBoard.setTextcode("");
		
		setDailyBombICode("");
		setDailyCompresorCode("");
		setDailyBoardCode("");
		setDailyPulmonCode("");
		setWeeklyBombCode("");
		setWeeklyCompresorCode("");
		setWeeklyBoardCode("");
		setMonthlyBombCode("");
		setMonthlyCompresorCode("");
		setMonthlyBoardCode("");
	}
	
		
	private void cleanAlerts() {
		panelAlert.removeAll();
		panelAlert.revalidate();
		panelAlert.repaint();
	}
	
	private void putDailyAlerts() {
	
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		String stringDate= DateFor.format(date);
		lblFecha.setText("Fecha: " + stringDate);
		
		cleanAlerts();
		cleanCodes();
	
		if(comboBox.getSelectedIndex() == 0) {
			panelAlert.add(new DailyBomb());
			panelAlert.add(new DailyCompresor());
			panelAlert.add(new DailyBoard());
			panelAlert.add(new DailyPulmon());
			panelAlert.setPreferredSize(new Dimension(600, 1170));
			enabledBomb = true;
			enabledCompresor = true;
			enabledBoard = true;
			enabledPulmon = true;
		}else if(comboBox.getSelectedIndex() == 1) {
			panelAlert.add(new WeeklyBomb());
			panelAlert.add(new WeeklyCompresor());
			panelAlert.add(new WeeklyBoard());
			panelAlert.setPreferredSize(new Dimension(600, 700));
			enabledBomb = true;
			enabledCompresor = true;
			enabledBoard = true;
			enabledPulmon = false;
		}else {
			panelAlert.add(new MonthlyBomb());
			panelAlert.add(new MonthlyCompresor());
			panelAlert.add(new MonthlyBoard());
			panelAlert.setPreferredSize(new Dimension(600, 600));
			enabledBomb = true;
			enabledCompresor = true;
			enabledBoard = true;
			enabledPulmon = false;
		}
		
		panelAlert.add(new notes());
		
	}
	
	private static void changeEquipaments() {
		lblEquipaments.setText("");
		String Text = "";
		
		if(enabledBomb) {
			Text += " <Bomba Monobloc>";
		}
				
		if(enabledCompresor) {
			Text += " <Compresor>";
		}
		if(enabledBoard) {
			Text += " <Tablero de control> ";
		}
		if(enabledPulmon) {
			Text += " <Pulmón Hidroneumático> ";
		}
		lblEquipaments.setText(Text);
	}
	
	///dailyBomb
	public static void setEnableBomb(boolean enable) {
		enabledBomb = enable;
		changeEquipaments();
	}
	
	public static void setEnableCompresor(boolean enable) {
		enabledCompresor = enable;
		changeEquipaments();
	}
	
	public static void setEnablePulmon(boolean enable) {
		enabledPulmon = enable;
		changeEquipaments();
	}
	
	public static void setEnableBoard(boolean enable) {
		enabledBoard = enable;
		changeEquipaments();
	}
	
	public static void setDailyBombVFB(String VFB) {
		bombDaily.setVFB(VFB);
	}
	
	public static void setDailyBombIADRE(String IADRE) {
		bombDaily.setIADRE(IADRE);
	}
	public static void setDailyBombIVMPAB(String IVMPAB) {
		bombDaily.setIVMPAB(IVMPAB);
	}
	public static void setDailyBombITDVE(String ITDVE) {
		bombDaily.setITDVE(ITDVE);
	}
	public static void setDailyBombIVDFTA(String IVDFTA) {
		bombDaily.setIVDFTA(IVDFTA);
	}
	public static void setDailyBombMCEM(String MCEM) {
		bombDaily.setMCEM(MCEM);
	}
	public static void setDailyBombITDVPC(String ITDVPC) {
		bombDaily.setITDVPC(ITDVPC);
	}
	public static void setDailyBombICode(String code) {
		bombDaily.setCode(code);
	}
	
	//daily compresor
	
	public static void setDailyCompresorVFC(String VFC) {
		compresorDaily.setVFC(VFC);
	}
	
	public static void setDailyCompresorVFA(String VFA) {
		compresorDaily.setVFA(VFA);
	}
	public static void setDailyCompresorIADRE(String IADRE) {
		compresorDaily.setIADRE(IADRE);
	}
	public static void setDailyCompresorAAJ(String AJJ) {
		compresorDaily.setAAJ(AJJ);;
	}
	public static void setDailyCompresorVFP(String VFP) {
		compresorDaily.setVFP(VFP);
	}
	public static void setDailyCompresorCode(String code) {
		compresorDaily.setCode(code);;
	}
	
	///daily pulmon
	
	public static void setDailyPulmonVNA(String VNA) {
		pulmonDaily.setVNA(VNA);
	}
	
	public static void setDailyPulmonVFM(String VFM) {
		pulmonDaily.setVFM(VFM);
	}
	
	public static void setDailyPulmonMPBCAB(String MPBCAB) {
		pulmonDaily.setMPBCAB(MPBCAB);;
	}
	public static void setDailyPulmonMPACAB(String MPACAB) {
		pulmonDaily.setMPACAB(MPACAB);
	}
	
	public static void setDailyPulmonCode(String code) {
		pulmonDaily.setCode(code);
	}
	
	//daily board
	
	public static void setDailyBoardMV(String MV) {
		boardDaily.setMV(MV);
	}
	
	public static void setDailyBoardMA(String MA) {
		boardDaily.setMA(MA);
	}
	public static void setDailyBoardVTTEC(String VTTEC) {
		boardDaily.setVTTEC(VTTEC);
	}
	public static void setDailyBoardCode(String code) {
		boardDaily.setCode(code);
	}
	
	//weekly bomb
	
	public static void setWeeklyBombVTETS(String VTETS) {
		bombWeekly.setVTETS(VTETS);
	}
	public static void setWeeklyBombLRPPAC(String LRPPAC) {
		bombWeekly.setLRPPAC(LRPPAC);
	}
	public static void setWeeklyBombCode(String code) {
		bombWeekly.setCode(code);
	}
	
	//weekly compresor
	
	public static void setWeeklyCompresorITDVE(String ITDVE) {
		compresorWeekly.setITDVE(ITDVE);
	}
	public static void setWeeklyCompresorMCE(String MCE) {
		compresorWeekly.setMCE(MCE);
	}
	public static void setWeeklyCompresorCode(String code) {
		compresorWeekly.setCode(code);
	}
	
	//weekly board
	
	public static void setWeeklyBoardLEPP(String LEPP) {
		boardWeekly.setLEPP(LEPP);
	}
	
	public static void setWeeklyBoardCode(String code) {
		boardWeekly.setCode(code);
	}

	// monthly bomb
	
	public static void setMonthlyBombAPTAB(String APTAB) {
		bombMonthly.setAPTAB(APTAB);
	}
	public static void setMonthlyBombCode(String code) {
		bombMonthly.setCode(code);
	}
	
	//monthly compresor
	
	public static void setMonthlyCompresorVTCT(String VTCT) {
		compresorMonthly.setVTCT(VTCT);
	}
	public static void setMonthlyCompresorVNA(String VNA) {
		compresorMonthly.setVNA(VNA);
	}
	public static void setMonthlyCompresorCode(String code) {
		compresorMonthly.setCode(code);
	}
	
	///monthly board
	
	public static void setMonthlyBoardVCS(String VCS) {
		boardMonthly.setVCS(VCS);
	}
	
	public static void setMonthlyBoardCode(String code) {
		boardMonthly.setCode(code);
	}
	
	///
	private static boolean checkCodes() {
		
		if(enabledBomb && comboBox.getSelectedIndex() == 0 && bombDaily.getCode() =="") {
			return false;
		}
		if(enabledCompresor && comboBox.getSelectedIndex() == 0 && compresorDaily.getCode() =="") {
			return false;
		}
		if(enabledPulmon && comboBox.getSelectedIndex() == 0 && pulmonDaily.getCode() =="") {
			return false;
		}
		if(enabledBoard && comboBox.getSelectedIndex() == 0 && boardDaily.getCode() =="") {
			return false;
		}
		//
		if(enabledBomb && comboBox.getSelectedIndex() == 1 && bombWeekly.getCode() =="") {
			return false;
		}
		if(enabledCompresor && comboBox.getSelectedIndex() == 1 && compresorWeekly.getCode() =="") {
			return false;
		}
		if(enabledBoard && comboBox.getSelectedIndex() == 1 && boardWeekly.getCode() =="") {
			return false;
		}
		//
		if(enabledBomb && comboBox.getSelectedIndex() == 2 && bombMonthly.getCode() == "") {
			return false;
		}
		if(enabledCompresor && comboBox.getSelectedIndex() == 2 && compresorMonthly.getCode() == "") {
			return false;
		}
		if(enabledBoard && comboBox.getSelectedIndex() == 2 && boardMonthly.getCode() == "") {
			return false;
		}
		
		return true;
	}
	
	private static void createUser() {
		
		user.setEquipament(lblEquipaments.getText());
		user.setMantenanceBoss(textBoss.getText());
		user.setOperator(textOperator.getText());
		user.setControlNumber(textControlNumber.getText());
	
	}
	
}
