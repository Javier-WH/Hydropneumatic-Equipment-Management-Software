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
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class ReportWeekly extends JFrame implements Printable {

	private JPanel contentPane;
	private static JPanel panel = new JPanel();
	private static JLabel date1 = new JLabel("");
	private static JLabel date2 = new JLabel("");
	private static JLabel date3 = new JLabel("");
	
	private static JLabel lblEquipaments = new JLabel("");
	private static JLabel lblBoss = new JLabel("");
	private static JLabel lblOperator = new JLabel("");
	private static JLabel lblControlNumber = new JLabel("");
	private static JLabel lblFrecuency = new JLabel("");
	
	
	
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
	    if (pageIndex > 0)
	      return NO_SUCH_PAGE;
	    Graphics2D page = (Graphics2D) graphics;
        page.translate(pageFormat.getImageableX()+30, pageFormat.getImageableY()+30);
        page.scale(1.0, 1.0);
        
        panel.printAll(graphics);
	    return PAGE_EXISTS;
	  }

	public ReportWeekly(String register, User user) {
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Reporte");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReportWeekly.class.getResource("/img/icono.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 686);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
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
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("25px", false), Sizes.constant("25px", false)), 0),
				RowSpec.decode("15px"),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("1px", false), Sizes.constant("1px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("160dlu", false), Sizes.constant("160dlu", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("2px", false), Sizes.constant("2px", false)), 0),
				RowSpec.decode("max(37dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblNewLabel_1 = new JLabel("RUTINAS DE MANTENIMIENTO PREVENTIVO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel_1, "2, 2, 4, 1, center, top");
		
		JLabel lblNewLabel = new JLabel("Equipos:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblNewLabel, "2, 4, left, top");
		
	
		lblEquipaments.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panel.add(lblEquipaments, "4, 4, 2, 1");
		
		JLabel lblJefeDeMantenimiento = new JLabel("Jefe de Mantenimiento:");
		lblJefeDeMantenimiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblJefeDeMantenimiento, "2, 6, fill, top");
		
		
		lblBoss.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblBoss, "4, 6");
		
		JLabel lblOperador = new JLabel("Operador:");
		lblOperador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblOperador, "2, 8, left, top");
		
		
		lblOperator.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblOperator, "4, 8, 2, 1");
		
		JLabel lblNmeroDeControl = new JLabel("Número de Control:");
		lblNmeroDeControl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblNmeroDeControl, "2, 10, left, top");
		
	
		lblControlNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblControlNumber, "4, 10");
		
		JLabel lblFrecuencia = new JLabel("Frecuencia:");
		lblFrecuencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblFrecuencia, "2, 12, left, top");
		
	
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
		
		JLabel lblNewLabel_2 = new JLabel("Inspección táctil para determinar vibraciones excesivas");
		lblNewLabel_2.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2, "4, 16");
		

		date1.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date1, "5, 16, fill, default");
		
		JLabel lblFrecuencia_8 = new JLabel("BOMBA");
		lblFrecuencia_8.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_8, "2, 18");
		
		JLabel lblNewLabel_2_1 = new JLabel("Limpieza para retirar partículas de polvo y agentes contaminantes");
		lblNewLabel_2_1.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_1, "4, 18");
		

		date2.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date2, "5, 18");
		
		JLabel lblFrecuencia_16_3 = new JLabel("TABLERO DE CONTROL");
		lblFrecuencia_16_3.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblFrecuencia_16_3, "2, 20");
		
		JLabel lblNewLabel_2_2 = new JLabel("Realizar limpieza para eliminar particulas de polvo y agentes contaminantes");
		lblNewLabel_2_2.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		panel.add(lblNewLabel_2_2, "4, 20");
		

		date3.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		panel.add(date3, "5, 20");
		
		JTextPane textObservations = new JTextPane();
		textObservations.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Observaciones", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		textObservations.setEditable(false);
		panel.add(textObservations, "2, 41, 4, 1, fill, fill");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, "2, 43, 4, 1, fill, fill");
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
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(ReportWeekly.class.getResource("/img/imprimir.png")));
		btnNewButton.setBackground(new Color(0, 102, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  PrinterJob job = PrinterJob.getPrinterJob();
				    job.setPrintable(new ReportWeekly(register, user));
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
		
		JButton btnCerrar = new JButton("");
		btnCerrar.setBackground(new Color(0, 102, 255));
		btnCerrar.setIcon(new ImageIcon(ReportWeekly.class.getResource("/img/puerta-cerrada.png")));
		btnCerrar.setBounds(608, 575, 89, 55);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnCerrar);
		
		lblEquipaments.setText(user.getEquipament());
		lblBoss.setText(user.getMantenanceBoss());
		lblOperator.setText(user.getOperator());
		lblControlNumber.setText(user.getControlNumber());
		lblFrecuency.setText("Semanal");
		

		ArrayList<String> list = GetRegistered.getWeekly(register);
		date1.setText(list.get(0));
		date2.setText(list.get(1));
		date3.setText(list.get(2));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(new Color(0, 102, 255));
		lblNewLabel_4.setBounds(600, 0, 1, 643);
		contentPane.add(lblNewLabel_4);
		
	}
}
