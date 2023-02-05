package frames;

import javax.swing.JDialog;
import java.awt.Toolkit;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import com.jgoodies.forms.layout.Sizes;
import actors.CualitativeActor;
import sql.MesureList;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;




@SuppressWarnings("serial")
public class Cualitative extends JDialog implements Printable{
	private static JTextField textBoss;
	private static JTextField textOperator;
	private static JTextField textControlNumber;
	private static JCheckBox chk1;
	private static JCheckBox chk2;
	private static JCheckBox chk3;
	private static JCheckBox chk4;
	private static JCheckBox chk5;
	private static JCheckBox chk6;
	private static JCheckBox chk7;
	private static JCheckBox chk8;
	private static JFormattedTextField dateA;
	private static JTextArea observetions;
	private static JPanel panel;
	private static String idx = "0";
	private JButton btnImprimir;

	
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
	    if (pageIndex > 0)
	      return NO_SUCH_PAGE;
	    Graphics2D page = (Graphics2D) graphics;
        page.translate(pageFormat.getImageableX()+30, pageFormat.getImageableY()+30);
        page.scale(1.0, 1.0);
        
        panel.printAll(graphics);
	    return PAGE_EXISTS;
	  }


	public Cualitative() {
		getContentPane().setBackground(Color.WHITE);
		idx = "0";
		setResizable(false);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cualitative.class.getResource("/img/icono.png")));
		setTitle("Registro Cualitativo");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(800, 700);
		getContentPane().setLayout(null);
		initComponents();	
	}
	
	public Cualitative(String id) {
		idx=id;
		setResizable(false);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cualitative.class.getResource("/img/icono.png")));
		setTitle("Registro Cualitativo");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(800, 700);
		getContentPane().setLayout(null);
		initComponents();	
		
		CualitativeActor ca = MesureList.getCualitativeByid(id);
		textBoss.setText(ca.getUser().getMantenanceBoss());
		textOperator.setText(ca.getUser().getOperator());
		textControlNumber.setText(ca.getUser().getControlNumber());
		observetions.setText(ca.getObservations());
		chk1.setSelected(Boolean.parseBoolean(ca.getBtactoTuveriaSuccion()));
		chk2.setSelected(Boolean.parseBoolean(ca.getTfuncionamientoAutomaticos()));
		chk3.setSelected(Boolean.parseBoolean(ca.getTtemperaturaEquipos()));
		chk4.setSelected(Boolean.parseBoolean(ca.getBruidos()));
		chk5.setSelected(Boolean.parseBoolean(ca.getCruidos()));
		chk6.setSelected(Boolean.parseBoolean(ca.getBfugas()));
		chk7.setSelected(Boolean.parseBoolean(ca.getBvibraciones()));
		chk8.setSelected(Boolean.parseBoolean(ca.getCvibraciones()));		
		dateA.setText(ca.getDocumentDate());
		
		
	
		
	}
	
	
	private void initComponents() {
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(4, 1, 764, 572);
		getContentPane().add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("1mm", true), Sizes.constant("1mm", true)), 0),
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("15mm", true), Sizes.constant("15mm", true)), 1),
				FormSpecs.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("15mm", true), Sizes.constant("15mm", true)), 0),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("1mm", false), Sizes.constant("1mm", false)), 0),
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(51dlu;default):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(1dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("40dlu", false), Sizes.constant("40dlu", false)), 1),}));
		
		JLabel lblNewLabel = new JLabel("MEDICIÓN DE PARÁMETROS DE FUNCIONAMIENTO DEL SISTEMA HIDRONEUMÁTICO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblNewLabel, "2, 2, 7, 1, fill, default");
		
		JLabel lblNewLabel_2_4 = new JLabel("Equipos:");
		panel.add(lblNewLabel_2_4, "2, 4, left, default");
		lblNewLabel_2_4.setForeground(new Color(0, 102, 255));
		
		JLabel lblNewLabel_3 = new JLabel("Bomba hydrobloc, Compresor, Tablero de control, Pulmón Hidroneumático");
		panel.add(lblNewLabel_3, "4, 4, 6, 1, fill, default");
		lblNewLabel_3.setForeground(new Color(0, 102, 255));
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Jefe de Mantenimiento:");
		panel.add(lblNewLabel_2_4_1, "2, 6, left, default");
		lblNewLabel_2_4_1.setForeground(new Color(0, 102, 255));
		
		textBoss = new JTextField();
		panel.add(textBoss, "4, 6, 6, 1, fill, default");
		textBoss.setForeground(new Color(0, 102, 255));
		textBoss.setColumns(10);
		textBoss.setCaretColor(new Color(0, 102, 255));
		textBoss.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		
		JLabel lblNewLabel_2_4_2 = new JLabel("Operador:");
		panel.add(lblNewLabel_2_4_2, "2, 8, left, default");
		lblNewLabel_2_4_2.setForeground(new Color(0, 102, 255));
		
		textOperator = new JTextField();
		panel.add(textOperator, "4, 8, 6, 1, fill, default");
		textOperator.setForeground(new Color(0, 102, 255));
		textOperator.setColumns(10);
		textOperator.setCaretColor(new Color(0, 102, 255));
		textOperator.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		
		JLabel lblNewLabel_2_4_3 = new JLabel("Número de Control:");
		panel.add(lblNewLabel_2_4_3, "2, 10, left, default");
		lblNewLabel_2_4_3.setForeground(new Color(0, 102, 255));
		
		textControlNumber = new JTextField();
		panel.add(textControlNumber, "4, 10, 6, 1, fill, default");
		textControlNumber.setForeground(new Color(0, 102, 255));
		textControlNumber.setColumns(10);
		textControlNumber.setCaretColor(new Color(0, 102, 255));
		textControlNumber.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		
		JLabel lblNewLabel_1 = new JLabel("EQUIPO");
		panel.add(lblNewLabel_1, "2, 14, 2, 1, fill, fill");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBackground(new Color(0, 102, 255));
		
		JLabel lblNewLabel_1_1 = new JLabel("EVALUACIÓN");
		panel.add(lblNewLabel_1_1, "4, 14, 2, 1, fill, fill");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBackground(new Color(0, 102, 255));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("FECHA:");
		panel.add(lblNewLabel_1_1_1, "6, 14, 2, 1, fill, fill");
		lblNewLabel_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBackground(new Color(0, 102, 255));
		
		dateA = new JFormattedTextField();
		dateA.setForeground(Color.WHITE);
		dateA.setCaretColor(Color.WHITE);
		dateA.setBorder(null);
		dateA.setBackground(new Color(0, 102, 255));
		panel.add(dateA, "8, 14, 2, 1, fill, fill");
		
		JLabel lblNewLabel_2_1 = new JLabel("BOMBA");
		panel.add(lblNewLabel_2_1, "2, 16, left, default");
		lblNewLabel_2_1.setForeground(new Color(0, 102, 204));
		
		JLabel lblNewLabel_2_3 = new JLabel("Validar a través del tacto la tubería de succión");
		panel.add(lblNewLabel_2_3, "4, 16");
		lblNewLabel_2_3.setForeground(new Color(0, 102, 204));
		
		chk1 = new JCheckBox("Hecho");
		chk1.setForeground(new Color(0, 102, 255));
		chk1.setBackground(Color.WHITE);
		panel.add(chk1, "6, 16, 3, 1, center, default");
		
		JLabel lblNewLabel_2_2_1 = new JLabel("TABLERO DE CONTROL");
		panel.add(lblNewLabel_2_2_1, "2, 18");
		lblNewLabel_2_2_1.setForeground(new Color(0, 102, 204));
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Validar funcionamientos de automáticos");
		panel.add(lblNewLabel_2_3_1, "4, 18");
		lblNewLabel_2_3_1.setForeground(new Color(0, 102, 204));
		
		chk2 = new JCheckBox("Hecho");
		chk2.setForeground(new Color(0, 102, 255));
		chk2.setBackground(Color.WHITE);
		panel.add(chk2, "6, 18, 3, 1, center, default");
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("TABLERO DE CONTROL");
		panel.add(lblNewLabel_2_2_1_1, "2, 20");
		lblNewLabel_2_2_1_1.setForeground(new Color(0, 102, 204));
		
		JLabel lblNewLabel_2_3_2 = new JLabel("Validar mediante el tacto la temperatura de los equipos: Relé, breakers, etc.");
		panel.add(lblNewLabel_2_3_2, "4, 20, left, default");
		lblNewLabel_2_3_2.setForeground(new Color(0, 102, 204));
		
		chk3 = new JCheckBox("Hecho");
		chk3.setForeground(new Color(0, 102, 255));
		chk3.setBackground(Color.WHITE);
		panel.add(chk3, "6, 20, 3, 1, center, default");
		
		JLabel lblNewLabel_2_1_1 = new JLabel("BOMBA");
		panel.add(lblNewLabel_2_1_1, "2, 22");
		lblNewLabel_2_1_1.setForeground(new Color(0, 102, 204));
		
		JLabel lblNewLabel_2_3_2_1 = new JLabel("Verificación auditiva de ruidos extraños");
		panel.add(lblNewLabel_2_3_2_1, "4, 22, left, default");
		lblNewLabel_2_3_2_1.setForeground(new Color(0, 102, 204));
		
		chk4 = new JCheckBox("Hecho");
		chk4.setForeground(new Color(0, 102, 255));
		chk4.setBackground(Color.WHITE);
		panel.add(chk4, "6, 22, 3, 1, center, default");
		
		JLabel lblNewLabel_2_2 = new JLabel("COMPRESOR HIRDRONEUMÁTICO");
		panel.add(lblNewLabel_2_2, "2, 24");
		lblNewLabel_2_2.setForeground(new Color(0, 102, 204));
		
		JLabel lblNewLabel_2_3_2_1_1 = new JLabel("Verificación auditiva de ruidos extraños");
		panel.add(lblNewLabel_2_3_2_1_1, "4, 24, left, default");
		lblNewLabel_2_3_2_1_1.setForeground(new Color(0, 102, 204));
		
		chk5 = new JCheckBox("Hecho");
		chk5.setForeground(new Color(0, 102, 255));
		chk5.setBackground(Color.WHITE);
		panel.add(chk5, "6, 24, 3, 1, center, default");
		
		JLabel lblNewLabel_2_1_2 = new JLabel("BOMBA");
		panel.add(lblNewLabel_2_1_2, "2, 26");
		lblNewLabel_2_1_2.setForeground(new Color(0, 102, 204));
		
		JLabel lblNewLabel_2_3_2_1_1_1 = new JLabel("Verifdicar que no existan fugas en el presostato");
		panel.add(lblNewLabel_2_3_2_1_1_1, "4, 26, left, default");
		lblNewLabel_2_3_2_1_1_1.setForeground(new Color(0, 102, 204));
		
		chk6 = new JCheckBox("Hecho");
		chk6.setForeground(new Color(0, 102, 255));
		chk6.setBackground(Color.WHITE);
		panel.add(chk6, "6, 26, 3, 1, center, default");
		
		JLabel lblNewLabel_2_1_3 = new JLabel("BOMBA");
		panel.add(lblNewLabel_2_1_3, "2, 28");
		lblNewLabel_2_1_3.setForeground(new Color(0, 102, 204));
		
		JLabel lblNewLabel_2_3_2_1_1_2 = new JLabel("Verificar vibraciones");
		panel.add(lblNewLabel_2_3_2_1_1_2, "4, 28, left, default");
		lblNewLabel_2_3_2_1_1_2.setForeground(new Color(0, 102, 204));
		
		chk7 = new JCheckBox("Hecho");
		chk7.setForeground(new Color(0, 102, 255));
		chk7.setBackground(Color.WHITE);
		panel.add(chk7, "6, 28, 3, 1, center, default");
		
		JLabel lblNewLabel_2_2_2 = new JLabel("COMPRESOR HIRDRONEUMÁTICO");
		panel.add(lblNewLabel_2_2_2, "2, 30");
		lblNewLabel_2_2_2.setForeground(new Color(0, 102, 204));
		
		JLabel lblNewLabel_2_3_2_1_1_2_1 = new JLabel("Verificar vibraciones");
		panel.add(lblNewLabel_2_3_2_1_1_2_1, "4, 30, left, default");
		lblNewLabel_2_3_2_1_1_2_1.setForeground(new Color(0, 102, 204));
		
		chk8 = new JCheckBox("Hecho");
		chk8.setForeground(new Color(0, 102, 255));
		chk8.setBackground(Color.WHITE);
		panel.add(chk8, "6, 30, 3, 1, center, default");
		
		observetions = new JTextArea();
		observetions.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Observaciones:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 255)));
		panel.add(observetions, "2, 34, 7, 1, fill, fill");
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, "2, 38, fill, fill");
		
		JLabel lblNewLabel_5 = new JLabel("Recibido por:");
		lblNewLabel_5.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_5.setForeground(new Color(0, 102, 255));
		lblNewLabel_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		lblNewLabel_5.setBounds(10, 0, 286, 57);
		panel_1.add(lblNewLabel_5);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel.add(panel_1_1, "4, 38, fill, fill");
		
		JLabel lblNewLabel_5_1 = new JLabel("Firma");
		lblNewLabel_5_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_5_1.setForeground(new Color(0, 102, 255));
		lblNewLabel_5_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		lblNewLabel_5_1.setBounds(10, 0, 244, 57);
		panel_1_1.add(lblNewLabel_5_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(Color.WHITE);
		panel.add(panel_1_2, "6, 38, 5, 1, fill, fill");
		
		JLabel lblNewLabel_5_2 = new JLabel("Fecha:");
		lblNewLabel_5_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_5_2.setForeground(new Color(0, 102, 255));
		lblNewLabel_5_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		lblNewLabel_5_2.setBounds(10, 0, 148, 57);
		panel_1_2.add(lblNewLabel_5_2);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setIcon(new ImageIcon(Cualitative.class.getResource("/img/add.png")));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 102, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CualitativeActor ca = new CualitativeActor();
				ca.getUser().setMantenanceBoss(textBoss.getText());
				ca.getUser().setOperator(textOperator.getText());
				ca.getUser().setControlNumber(textControlNumber.getText());
				ca.setObservations(observetions.getText());
				ca.setDate( new Date().toString());
				ca.setBtactoTuveriaSuccion( String.valueOf( chk1.isSelected()));
				ca.setTfuncionamientoAutomaticos(String.valueOf( chk2.isSelected()));
				ca.setTtemperaturaEquipos(String.valueOf( chk3.isSelected()));
				ca.setBruidos(String.valueOf( chk4.isSelected()));
				ca.setCruidos(String.valueOf( chk5.isSelected()));
				ca.setBfugas(String.valueOf( chk6.isSelected()));
				ca.setBvibraciones(String.valueOf( chk7.isSelected()));
				ca.setCvibraciones(String.valueOf( chk8.isSelected()));
				ca.setMesureType("2");
				ca.setDocumentDate(dateA.getText());
				MesureList.saveCualitativeMesure(ca);
				Parameters.fillListPanel();
			}
		});
		btnNewButton.setBounds(625, 598, 125, 41);
		getContentPane().add(btnNewButton);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setBackground(new Color(0, 102, 255));
		btnCerrar.setIcon(new ImageIcon(Cualitative.class.getResource("/img/puerta-cerrada.png")));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(31, 598, 125, 41);
		getContentPane().add(btnCerrar);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.setBackground(new Color(0, 102, 255));
		btnImprimir.setForeground(Color.WHITE);
		btnImprimir.setIcon(new ImageIcon(Cualitative.class.getResource("/img/imprimir.png")));
		btnImprimir.setBounds(319, 598, 125, 41);
		getContentPane().add(btnImprimir);
		/////////////
		
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					PrinterJob job = PrinterJob.getPrinterJob();
					job.setPrintable(new Cualitative(idx));
					if (job.printDialog()) {
						try {
							job.print();
						} catch (PrinterException e1) {
						}
					}					
				}
		});


		
	}
}
