package frames;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.Sizes;
import actors.User;
import sql.GetRegistered;

import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class ReportDaily extends JFrame implements Printable {

	private JPanel contentPane;
	private static JPanel panel = new JPanel();
	
	private static JLabel date1 = new JLabel("");
	private static JLabel date2 = new JLabel("");
	private static JLabel date3 = new JLabel("");
	private static JLabel date4 = new JLabel("");
	private static JLabel date5 = new JLabel("");
	private static JLabel date6 = new JLabel("");
	private static JLabel date7 = new JLabel("");
	private static JLabel date8 = new JLabel("");
	private static JLabel date9 = new JLabel("");
	private static JLabel date10 = new JLabel("");
	private static JLabel date11 = new JLabel("");
	private static JLabel date12 = new JLabel("");
	private static JLabel date13 = new JLabel("");
	private static JLabel date14 = new JLabel("");
	private static JLabel date15 = new JLabel("");
	private static JLabel date16 = new JLabel("");
	private static JLabel date17 = new JLabel("");
	private static JLabel date18 = new JLabel("");
	private static JLabel date19 = new JLabel("");
	private static JLabel date20 = new JLabel("");
	private static JLabel date21 = new JLabel("");
	private static JLabel date22 = new JLabel("");
	
	
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
	    if (pageIndex > 0)
	      return NO_SUCH_PAGE;
	    Graphics2D page = (Graphics2D) graphics;
        page.translate(pageFormat.getImageableX()+30, pageFormat.getImageableY()+30);
        page.scale(1.0, 1.0);
        
        panel.printAll(graphics);
	    return PAGE_EXISTS;
	  }

	public ReportDaily(String register, User user) {
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Reporte");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReportDaily.class.getResource("/img/icono.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 686);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		panel.setBackground(Color.WHITE);
		panel.setBounds(8, 3, 590, 643);
		contentPane.add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("138px:grow"),
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("1px", true), Sizes.constant("1px", true)), 0),
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("198dlu", true), Sizes.constant("250dlu", true)), 1),
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("43dlu", true), Sizes.constant("50dlu", true)), 1),
				ColumnSpec.decode("10dlu"),
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("17px"),
				RowSpec.decode("8px"),
				RowSpec.decode("15px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("4px", false), Sizes.constant("4px", false)), 0),
				RowSpec.decode("15px"),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("1px", false), Sizes.constant("1px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(37dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblNewLabel_1 = new JLabel("RUTINAS DE MANTENIMIENTO PREVENTIVO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel_1, "2, 2, 4, 1, center, top");
		
		JLabel lblNewLabel = new JLabel("Equipos:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblNewLabel, "2, 4, left, top");
		
		JLabel lblEquipaments = new JLabel("Bomba Monobloc, Compresor, Tablero de control, Pulmón Hidroneumático");
		lblEquipaments.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panel.add(lblEquipaments, "4, 4, 2, 1");
		
		JLabel lblJefeDeMantenimiento = new JLabel("Jefe de Mantenimiento:");
		lblJefeDeMantenimiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblJefeDeMantenimiento, "2, 6, fill, top");
		
		JLabel lblBoss = new JLabel("Juan perez");
		lblBoss.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblBoss, "4, 6");
		
		JLabel lblOperador = new JLabel("Operador:");
		lblOperador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblOperador, "2, 8, left, top");
		
		JLabel lblOperator = new JLabel("Simón Jose Antonio de la Trinidad, Bolivar y Palacios, Ponte y Blanco");
		lblOperator.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblOperator, "4, 8, 2, 1");
		
		JLabel lblNmeroDeControl = new JLabel("Número de Control:");
		lblNmeroDeControl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblNmeroDeControl, "2, 10, left, top");
		
		JLabel lblControlNumber = new JLabel("656165165165165651");
		lblControlNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblControlNumber, "4, 10");
		
		JLabel lblFrecuencia = new JLabel("Frecuencia:");
		lblFrecuencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblFrecuencia, "2, 12, left, top");
		
		JLabel lblFrecuency = new JLabel("Diario");
		lblFrecuency.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblFrecuency, "4, 12");
		
		JLabel lblEquipo = new JLabel("  EQUIPO");
		lblEquipo.setForeground(Color.WHITE);
		lblEquipo.setOpaque(true);
		lblEquipo.setBackground(new Color(0, 102, 255));
		lblEquipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblEquipo, "1, 14, 3, 1, fill, top");
		
		JLabel lblEquipo_1 = new JLabel("ACTIVIDAD DE MANTENIMIENTO");
		lblEquipo_1.setOpaque(true);
		lblEquipo_1.setForeground(Color.WHITE);
		lblEquipo_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEquipo_1.setBackground(new Color(0, 102, 255));
		panel.add(lblEquipo_1, "4, 14, fill, default");
		
		JLabel lblEquipo_1_1 = new JLabel("FECHA");
		lblEquipo_1_1.setOpaque(true);
		lblEquipo_1_1.setForeground(Color.WHITE);
		lblEquipo_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEquipo_1_1.setBackground(new Color(0, 102, 255));
		panel.add(lblEquipo_1_1, "5, 14");
		
		JLabel lblFrecuencia_1 = new JLabel("BANCADA COMPRESOR");
		lblFrecuencia_1.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_1, "2, 16");
		
		JLabel lblNewLabel_2 = new JLabel("Aplicar agua jabonosa en uniones para determinar fugas de aire");
		lblNewLabel_2.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2, "4, 16");
		

		date1.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date1, "5, 16, fill, default");
		
		JLabel lblFrecuencia_1_1 = new JLabel("BANCADA COMPRESOR");
		lblFrecuencia_1_1.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_1_1, "2, 18");
		
		JLabel lblNewLabel_2_1 = new JLabel("Inspección auditiva para determinar ruidos extraños");
		lblNewLabel_2_1.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_1, "4, 18");
		

		date2.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date2, "5, 18");
		
		JLabel lblFrecuencia_1_2 = new JLabel("BANCADA COMPRESOR");
		lblFrecuencia_1_2.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_1_2, "2, 20");
		
		JLabel lblNewLabel_2_2 = new JLabel("Inspección visual para verificar fugas de aceite");
		lblNewLabel_2_2.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_2, "4, 20");
		

		date3.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date3, "5, 20");
		
		JLabel lblFrecuencia_1_3 = new JLabel("BANCADA COMPRESOR");
		lblFrecuencia_1_3.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_1_3, "2, 22");
		
		JLabel lblNewLabel_2_3 = new JLabel("Verificar Funcionmamiento del compresor");
		lblNewLabel_2_3.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_3, "4, 22");
		
	
		date4.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date4, "5, 22");
		
		JLabel lblFrecuencia_1_4 = new JLabel("BANCADA COMPRESOR");
		lblFrecuencia_1_4.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_1_4, "2, 24");
		
		JLabel lblNewLabel_2_4 = new JLabel("Verificar funcionamiento del Presostato");
		lblNewLabel_2_4.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_4, "4, 24");
		
	
		date5.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date5, "5, 24");
		
		JLabel lblFrecuencia_1_5 = new JLabel("BANCADA COMPRESOR");
		lblFrecuencia_1_5.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_1_5, "2, 26");
		
		JLabel lblNewLabel_2_5 = new JLabel("Verificar manómetro del pulmón al activarse el compresor");
		lblNewLabel_2_5.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_5, "4, 26");
		
		
		date6.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date6, "5, 26");
		
		JLabel lblFrecuencia_1_6 = new JLabel("BANCADA COMPRESOR");
		lblFrecuencia_1_6.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_1_6, "2, 28");
		
		JLabel lblNewLabel_2_6 = new JLabel("Medición del consumo Eléctrico");
		lblNewLabel_2_6.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_6, "4, 28");
		
	
		date7.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date7, "5, 28");
		
		JLabel lblFrecuencia_8 = new JLabel("BOMBA");
		lblFrecuencia_8.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_8, "2, 30");
		
		JLabel lblNewLabel_2_7 = new JLabel("Inspección auditiva para determinar ruidos extraños");
		lblNewLabel_2_7.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_7, "4, 30");
		

		date8.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date8, "5, 30");
		
		JLabel lblFrecuencia_8_1 = new JLabel("BOMBA");
		lblFrecuencia_8_1.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_8_1, "2, 32");
		
		JLabel lblNewLabel_2_8 = new JLabel("Inspección de tubería de succión para verificar que no haya pérdida de ceba");
		lblNewLabel_2_8.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_8, "4, 32");
		

		date9.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date9, "5, 32");
		
		JLabel lblFrecuencia_8_2 = new JLabel("BOMBA");
		lblFrecuencia_8_2.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_8_2, "2, 34");
		
		JLabel lblNewLabel_2_9 = new JLabel("Inspección táctil para determinar vibraciones excesivas");
		lblNewLabel_2_9.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_9, "4, 34");
		
		
		date10.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date10, "5, 34");
		
		JLabel lblFrecuencia_8_3 = new JLabel("BOMBA");
		lblFrecuencia_8_3.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_8_3, "2, 36");
		
		JLabel lblNewLabel_2_10 = new JLabel("Inspección visual del manómetro de presión al activarse la bomba");
		lblNewLabel_2_10.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_10, "4, 36");
		
		
		date11.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date11, "5, 36");
		
		JLabel lblFrecuencia_8_4 = new JLabel("BOMBA");
		lblFrecuencia_8_4.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_8_4, "2, 38");
		
		JLabel lblNewLabel_2_11 = new JLabel("Inspección visual para detectar fugas en las tuberias de agua");
		lblNewLabel_2_11.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_11, "4, 38");
		
		
		date12.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date12, "5, 38");
		
		JLabel lblFrecuencia_8_5 = new JLabel("BOMBA");
		lblFrecuencia_8_5.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_8_5, "2, 40");
		
		JLabel lblNewLabel_2_12 = new JLabel("Medición consumo eléctrico");
		lblNewLabel_2_12.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_12, "4, 40");
		
	
		date13.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date13, "5, 40");
		
		JLabel lblFrecuencia_8_6 = new JLabel("BOMBA");
		lblFrecuencia_8_6.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_8_6, "2, 42");
		
		JLabel lblNewLabel_2_13 = new JLabel("Validar el funcionamiento de la bomba");
		lblNewLabel_2_13.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_13, "4, 42");
		
		
		date14.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date14, "5, 42");
		
		JLabel lblFrecuencia_8_7 = new JLabel("BOMBA");
		lblFrecuencia_8_7.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_8_7, "2, 44");
		
		JLabel lblNewLabel_2_14 = new JLabel("Validar a través del tacto termperatura externa de tubería de succión");
		lblNewLabel_2_14.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_14, "4, 44");
		
		
		date15.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date15, "5, 44");
		
		JLabel lblFrecuencia_16 = new JLabel("PULMÓN HIDRONEUMÁTICO");
		lblFrecuencia_16.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_16, "2, 46, left, default");
		
		JLabel lblNewLabel_2_14_1 = new JLabel("Medición de presión alta cuando está apagada la bomba");
		lblNewLabel_2_14_1.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_14_1, "4, 46");
		
	
		date16.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date16, "5, 46");
		
		JLabel lblFrecuencia_16_1 = new JLabel("PULMÓN HIDRONEUMÁTICO");
		lblFrecuencia_16_1.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_16_1, "2, 48");
		
		JLabel lblNewLabel_2_14_2 = new JLabel("Medición de presión baja cuando está activa la bomba");
		lblNewLabel_2_14_2.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_14_2, "4, 48");
		
		
		date17.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date17, "5, 48");
		
		JLabel lblFrecuencia_16_2 = new JLabel("PULMÓN HIDRONEUMÁTICO");
		lblFrecuencia_16_2.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_16_2, "2, 50");
		
		JLabel lblNewLabel_2_14_3 = new JLabel("Verificar nivel de agua");
		lblNewLabel_2_14_3.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_14_3, "4, 50");
		
		
		date18.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date18, "5, 50");
		
		JLabel lblFrecuencia_16_2_1 = new JLabel("PULMÓN HIDRONEUMÁTICO");
		lblFrecuencia_16_2_1.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_16_2_1, "2, 52");
		
		JLabel lblNewLabel_2_14_4 = new JLabel("Verificar funcionamiento del manómetro");
		lblNewLabel_2_14_4.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_14_4, "4, 52, fill, default");
		
		
		date19.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date19, "5, 52");
		
		JLabel lblFrecuencia_16_3 = new JLabel("TABLERO DE CONTROL");
		lblFrecuencia_16_3.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_16_3, "2, 54");
		
		JLabel lblNewLabel_2_14_5 = new JLabel("Medición del amperaje");
		lblNewLabel_2_14_5.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_14_5, "4, 54");
		
	
		date20.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date20, "5, 54");
		
		JLabel lblFrecuencia_16_3_1 = new JLabel("TABLERO DE CONTROL");
		lblFrecuencia_16_3_1.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_16_3_1, "2, 56");
		
		JLabel lblNewLabel_2_14_6 = new JLabel("Medición del voltaje");
		lblNewLabel_2_14_6.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_14_6, "4, 56");
		
	
		date21.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date21, "5, 56");
		
		JLabel lblFrecuencia_16_3_2 = new JLabel("TABLERO DE CONTROL");
		lblFrecuencia_16_3_2.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_16_3_2, "2, 58");
		
		JLabel lblNewLabel_2_14_7 = new JLabel("Verificar a través del tacto temperatura la de los elementos de control");
		lblNewLabel_2_14_7.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_14_7, "4, 58");
		
		
		date22.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date22, "5, 58");
		
		JTextPane textObservations = new JTextPane();
		textObservations.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Observaciones", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		textObservations.setEditable(false);
		panel.add(textObservations, "2, 60, 4, 1, fill, fill");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, "2, 62, 4, 1, fill, fill");
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Recibido  por:");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_3.setBounds(0, 3, 194, 42);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Firma:");
		lblNewLabel_3_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_3_1.setBounds(204, 3, 188, 42);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Fecha:");
		lblNewLabel_3_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_3_2.setBounds(402, 3, 134, 42);
		panel_1.add(lblNewLabel_3_2);
		
		JButton btnNewButton = new JButton("Imprimir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  PrinterJob job = PrinterJob.getPrinterJob();
				    job.setPrintable(new ReportDaily(register, user));
				    if (job.printDialog()) {
				      try {
				        job.print();
				      } catch (PrinterException e1) {
				      }
				    }
			}
		});
		btnNewButton.setBounds(608, 39, 89, 55);
		contentPane.add(btnNewButton);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(608, 575, 89, 55);
		contentPane.add(btnCerrar);
		

		ArrayList<String> list = GetRegistered.getDaily(register);
		date1.setText(list.get(0));
		date2.setText(list.get(1));
		date3.setText(list.get(2));
		date4.setText(list.get(3));
		date5.setText(list.get(4));
		date6.setText(list.get(5));
		date7.setText(list.get(6));
		date8.setText(list.get(7));
		date9.setText(list.get(8));
		date10.setText(list.get(9));
		date11.setText(list.get(10));
		date12.setText(list.get(11));
		date13.setText(list.get(12));
		date14.setText(list.get(13));
		date15.setText(list.get(14));
		date16.setText(list.get(15));
		date17.setText(list.get(16));
		date18.setText(list.get(17));
		date19.setText(list.get(18));
		date20.setText(list.get(19));
		date21.setText(list.get(20));
		date22.setText(list.get(21));
	}
	

	
}
