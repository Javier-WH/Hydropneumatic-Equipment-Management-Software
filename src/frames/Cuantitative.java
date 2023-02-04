package frames;
import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.jgoodies.forms.layout.Sizes;
import actors.CuantitativeActor;
import sql.MesureList;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.awt.event.ActionEvent;





@SuppressWarnings("serial")
public class Cuantitative extends JDialog implements Printable {
	private static JPanel panel = new JPanel();
	private static JTextField textBoss;
	private static JTextField textOperator;
	private static JTextField textControlNumber;
	private static JTextField dateA1;
	private static JTextField dateA2;
	private static JTextField dateA3;
	private static JTextField dateA4;
	private static JTextField dateA5;
	private static JTextField dateA6;
	private static JTextField dateB1;
	private static JTextField dateB2;
	private static JTextField dateB3;
	private static JTextField dateB4;
	private static JTextField dateB5;
	private static JTextField dateB6;
	private static JTextField dateC1;
	private static JTextField dateC2;
	private static JTextField dateC3;
	private static JTextField dateC4;
	private static JTextField dateC5;
	private static JTextField dateC6;
	private static JTextField dateD1;
	private static JTextField dateD2;
	private static JTextField dateD3;
	private static JTextField dateD4;
	private static JTextField dateD5;
	private static JTextField dateD6;
	private static JTextField dateE1;
	private static JTextField dateE2;
	private static JTextField dateE3;
	private static JTextField dateE4;
	private static JTextField dateE5;
	private static JTextField dateE6;
	private static JTextField dateF1;
	private static JTextField dateF2;
	private static JTextField dateF3;
	private static JTextField dateF4;
	private static JTextField dateF5;
	private static JTextField dateF6;
	private static JTextField dateG6;
	private static JTextField dateG5;
	private static JTextField dateG4;
	private static JTextField dateG3;
	private static JTextField dateG2;
	private static JTextField dateG1;
	private static JFormattedTextField dateA = new JFormattedTextField();
	private static JFormattedTextField dateB = new JFormattedTextField();
	private static JFormattedTextField dateC = new JFormattedTextField();
	private static JFormattedTextField dateD = new JFormattedTextField();
	private static JFormattedTextField dateE = new JFormattedTextField();
	private static JFormattedTextField dateF = new JFormattedTextField();
	private static JFormattedTextField dateG = new JFormattedTextField();
	private static JLabel average1 = new JLabel("");
	private static JLabel average2 = new JLabel("");
	private static JLabel average3 = new JLabel("");
	private static JLabel average4 = new JLabel("");
	private static JLabel average5 = new JLabel("");
	private static JLabel average6 = new JLabel("");
	private static JPanel panel_1;
	private static JLabel lblNewLabel_5;
	private static JPanel panel_1_2;
	private static JLabel lblNewLabel_5_2;
	private static JTextArea observetions;
	private static JLabel lblNewLabel_6;
	private static JButton btnNewButton = new JButton("Registrar");
	private static String idx = "0";
	
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
	    if (pageIndex > 0)
	      return NO_SUCH_PAGE;
	    Graphics2D page = (Graphics2D) graphics;
        page.translate(pageFormat.getImageableX()+30, pageFormat.getImageableY()+30);
        page.scale(1.0, 1.0);
        
        panel.printAll(graphics);
	    return PAGE_EXISTS;
	  }


	public Cuantitative() {
		idx= "0";
		setResizable(false);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cuantitative.class.getResource("/img/icono.png")));
		setTitle("Lista de Equipos");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(1014, 618);
		getContentPane().setLayout(null);
		initComponents();
		
	}
	//
	
	public Cuantitative(String id) {
		idx = id;
		setResizable(false);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cuantitative.class.getResource("/img/icono.png")));
		setTitle("Lista de Equipos");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(1014, 618);
		getContentPane().setLayout(null);
		initComponents();
		
		CuantitativeActor data = MesureList.getCuantitativeByid(id);
		
		textBoss.setText(data.getUser().getMantenanceBoss());
		textOperator.setText(data.getUser().getOperator());
		textControlNumber.setText(data.getUser().getControlNumber());
		observetions.setText(data.getObservations());
		
		
		
		

		
		String[] Cvoltaje = data.getCvoltaje().split("<<>>");
		String[] Bvoltaje = data.getBvoltaje().split("<<>>");
		String[] Camperaje = data.getCamperaje().split("<<>>");
		String[] Bamperaje = data.getBamperaje().split("<<>>");
		String[] PpresionAlta = data.getPpresionAlta().split("<<>>");
		String[] PpresionBaja = data.getPpresionBaja().split("<<>>");
		String[] dates = data.getDates().split("<<>>");
		

		if(Cvoltaje.length > 0) {
			
			dateA1.setText(Cvoltaje[0]);
			dateB1.setText(Cvoltaje[1]);
			dateC1.setText(Cvoltaje[2]);
			dateD1.setText(Cvoltaje[3]);
			dateE1.setText(Cvoltaje[4]);
			dateF1.setText(Cvoltaje[5]);
			dateG1.setText(Cvoltaje[6]);
			average1.setText(Cvoltaje[7]);
		}
		
		if(Bvoltaje.length > 0) {
			dateA2.setText(Bvoltaje[0]);
			dateB2.setText(Bvoltaje[1]);
			dateC2.setText(Bvoltaje[2]);
			dateD2.setText(Bvoltaje[3]);
			dateE2.setText(Bvoltaje[4]);
			dateF2.setText(Bvoltaje[5]);
			dateG2.setText(Bvoltaje[6]);
			average2.setText(Bvoltaje[7]);			
		}
		
		if(Camperaje.length > 0) {
			dateA3.setText(Camperaje[0]);
			dateB3.setText(Camperaje[1]);
			dateC3.setText(Camperaje[2]);
			dateD3.setText(Camperaje[3]);
			dateE3.setText(Camperaje[4]);
			dateF3.setText(Camperaje[5]);
			dateG3.setText(Camperaje[6]);
			average3.setText(Camperaje[7]);			
		}
		
		
		if(Bamperaje.length > 0) {
			dateA4.setText(Bamperaje[0]);
			dateB4.setText(Bamperaje[1]);
			dateC4.setText(Bamperaje[2]);
			dateD4.setText(Bamperaje[3]);
			dateE4.setText(Bamperaje[4]);
			dateF4.setText(Bamperaje[5]);
			dateG4.setText(Bamperaje[6]);
			average4.setText(Bamperaje[7]);			
		}
		
		if(PpresionAlta.length > 0) {
			dateA5.setText(PpresionAlta[0]);
			dateB5.setText(PpresionAlta[1]);
			dateC5.setText(PpresionAlta[2]);
			dateD5.setText(PpresionAlta[3]);
			dateE5.setText(PpresionAlta[4]);
			dateF5.setText(PpresionAlta[5]);
			dateG5.setText(PpresionAlta[6]);
			average5.setText(PpresionAlta[7]);			
		}
		
		if(PpresionBaja.length > 0) {
			dateA6.setText(PpresionBaja[0]);
			dateB6.setText(PpresionBaja[1]);
			dateC6.setText(PpresionBaja[2]);
			dateD6.setText(PpresionBaja[3]);
			dateE6.setText(PpresionBaja[4]);
			dateF6.setText(PpresionBaja[5]);
			dateG6.setText(PpresionBaja[6]);
			average6.setText(PpresionBaja[7]);
						
		}
		
		if(dates.length > 0) {
			dateA.setText(dates[0]);
			dateB.setText(dates[1]);
			dateC.setText(dates[2]);
			dateD.setText(dates[3]);
			dateE.setText(dates[4]);
			dateF.setText(dates[5]);
			dateG.setText(dates[6]);			
		}
	}
	
	
	
	
	//
	private String getMedia(ArrayList<String> data) {
		Double total = 0.0;
		
		for(int i = 0 ; i < data.size() ; i++) {
			try {
				total += Double.parseDouble(data.get(i));				
			} catch (Exception e) {
			}
		}
		return   String.valueOf( Math.round(  total / data.size() * 100.0)/100.0);
		
	}
	
	private void saveData() {
		
		String messaje = "Falta";
		
		String c1 = dateA1.getText().isEmpty() ? messaje : dateA1.getText();
		String c2 = dateB1.getText().isEmpty() ? messaje : dateB1.getText();
		String c3 = dateC1.getText().isEmpty() ? messaje : dateC1.getText();
		String c4 = dateD1.getText().isEmpty() ? messaje : dateD1.getText();
		String c5 = dateE1.getText().isEmpty() ? messaje : dateE1.getText();
		String c6 = dateF1.getText().isEmpty() ? messaje : dateF1.getText();
		String c7 = dateG1.getText().isEmpty() ? messaje : dateG1.getText();
		String c8 = average1.getText().isEmpty() ? messaje : average1.getText();
		
		String c9 = dateA2.getText().isEmpty() ? messaje : dateA2.getText();
		String c10 = dateB2.getText().isEmpty() ? messaje : dateB2.getText();
		String c11 = dateC2.getText().isEmpty() ? messaje : dateC2.getText();
		String c12 = dateD2.getText().isEmpty() ? messaje : dateD2.getText();
		String c13 = dateE2.getText().isEmpty() ? messaje : dateE2.getText();
		String c14 = dateF2.getText().isEmpty() ? messaje : dateF2.getText();
		String c15 = dateG2.getText().isEmpty() ? messaje : dateG2.getText();
		String c16 = average2.getText().isEmpty() ? messaje : average2.getText();
		
		String c17 = dateA3.getText().isEmpty() ? messaje : dateA3.getText();
		String c18 = dateB3.getText().isEmpty() ? messaje : dateB3.getText();
		String c19 = dateC3.getText().isEmpty() ? messaje : dateC3.getText();
		String c20 = dateD3.getText().isEmpty() ? messaje : dateD3.getText();
		String c21 = dateE3.getText().isEmpty() ? messaje : dateE3.getText();
		String c22 = dateF3.getText().isEmpty() ? messaje : dateF3.getText();
		String c23 = dateG3.getText().isEmpty() ? messaje : dateG3.getText();
		String c24 = average3.getText().isEmpty() ? messaje : average3.getText();
		
		String c25 = dateA4.getText().isEmpty() ? messaje : dateA4.getText();
		String c26 = dateB4.getText().isEmpty() ? messaje : dateB4.getText();
		String c27 = dateC4.getText().isEmpty() ? messaje : dateC4.getText();
		String c28 = dateD4.getText().isEmpty() ? messaje : dateD4.getText();
		String c29 = dateE4.getText().isEmpty() ? messaje : dateE4.getText();
		String c30 = dateF4.getText().isEmpty() ? messaje : dateF4.getText();
		String c31 = dateG4.getText().isEmpty() ? messaje : dateG4.getText();
		String c32 = average4.getText().isEmpty() ? messaje : average4.getText();
		
		String c33 = dateA5.getText().isEmpty() ? messaje : dateA5.getText();
		String c34 = dateB5.getText().isEmpty() ? messaje : dateB5.getText();
		String c35 = dateC5.getText().isEmpty() ? messaje : dateC5.getText();
		String c36 = dateD5.getText().isEmpty() ? messaje : dateD5.getText();
		String c37 = dateE5.getText().isEmpty() ? messaje : dateE5.getText();
		String c38 = dateF5.getText().isEmpty() ? messaje : dateF5.getText();
		String c39 = dateG5.getText().isEmpty() ? messaje : dateG5.getText();
		String c40 = average5.getText().isEmpty() ? messaje : average5.getText();
		
		String c41 = dateA6.getText().isEmpty() ? messaje : dateA6.getText();
		String c42 = dateB6.getText().isEmpty() ? messaje : dateB6.getText();
		String c43 = dateC6.getText().isEmpty() ? messaje : dateC6.getText();
		String c44 = dateD6.getText().isEmpty() ? messaje : dateD6.getText();
		String c45 = dateE6.getText().isEmpty() ? messaje : dateE6.getText();
		String c46 = dateF6.getText().isEmpty() ? messaje : dateF6.getText();
		String c47 = dateG6.getText().isEmpty() ? messaje : dateG6.getText();
		String c48 = average6.getText().isEmpty() ? messaje : average6.getText();
		
		String c49 = dateA.getText().isEmpty() ? messaje : dateA.getText();
		String c50 = dateB.getText().isEmpty() ? messaje : dateB.getText();
		String c51 = dateC.getText().isEmpty() ? messaje : dateC.getText();
		String c52 = dateD.getText().isEmpty() ? messaje : dateD.getText();
		String c53 = dateE.getText().isEmpty() ? messaje : dateE.getText();
		String c54 = dateF.getText().isEmpty() ? messaje : dateF.getText();
		String c55 = dateG.getText().isEmpty() ? messaje : dateG.getText();
		
		
		String cVoltaje = c1 + "<<>>" + c2 + "<<>>" + c3 + "<<>>" + c4 + "<<>>" + c5 + "<<>>" + c6 + "<<>>" + c7 + "<<>>" +c8;
		String bVoltaje = c9 + "<<>>" + c10 + "<<>>" + c11 + "<<>>" + c12 + "<<>>" + c13 + "<<>>" + c14 + "<<>>" + c15 + "<<>>" +c16;
		String cAmperaje = c17 + "<<>>" +c18 + "<<>>" + c19 + "<<>>" + c20 + "<<>>" + c21 + "<<>>" + c22 + "<<>>" + c23 + "<<>>" + c24;
		String bAmperaje = c25 + "<<>>" + c26 + "<<>>" + c27 + "<<>>" + c28 + "<<>>" + c29 + "<<>>" + c30 + "<<>>" + c31 + "<<>>" + c32;
		String pPresionAlta = c33 + "<<>>" + c34 + "<<>>" +c35 + "<<>>" + c36 + "<<>>" + c37 + "<<>>" + c38 + "<<>>" + c39 + "<<>>" + c40;
		String pPresionBaja = c41 + "<<>>" + c42 + "<<>>" + c43 + "<<>>" +c44 + "<<>>" + c45 + "<<>>" + c46 + "<<>>" + c47 + "<<>>" +c48;
		String dates = c49 + "<<>>" + c50 + "<<>>" + c51 + "<<>>" + c52 + "<<>>" + c53 + "<<>>" + c54 + "<<>>" + c55;
		
		CuantitativeActor ca = new CuantitativeActor();
		ca.setMesureType("1");
		ca.getUser().setMantenanceBoss(textBoss.getText());
		ca.getUser().setOperator(textOperator.getText());
		ca.getUser().setControlNumber(textControlNumber.getText());
		ca.setObservations(observetions.getText());
		ca.setDate( new Date().toString());
		ca.setCvoltaje(cVoltaje);
		ca.setBvoltaje(bVoltaje);
		ca.setCamperaje(cAmperaje);
		ca.setBamperaje(bAmperaje);
		ca.setPpresionAlta(pPresionAlta);
		ca.setPpresionBaja(pPresionBaja);
		ca.setDates(dates);
		
		MesureList.saveCuantitativeMesure(ca);
		Parameters.fillListPanel();
		
		
	}
	
	private void initComponents() {
		average1 = new JLabel("");
		average2 = new JLabel("");
		average3 = new JLabel("");
		average4 = new JLabel("");
		average5 = new JLabel("");
		average6 = new JLabel("");

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1028, 518);
		getContentPane().add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("130px", true), Sizes.constant("130px", true)), 1),
				FormSpecs.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("180px", true), Sizes.constant("180px", true)), 1),
				FormSpecs.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("67px", true), Sizes.constant("67px", true)), 1),
				FormSpecs.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("67px", true), Sizes.constant("67px", true)), 1),
				FormSpecs.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("67px", true), Sizes.constant("67px", true)), 1),
				FormSpecs.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("67px", true), Sizes.constant("67px", true)), 1),
				FormSpecs.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("67px", true), Sizes.constant("67px", true)), 1),
				FormSpecs.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("67px", true), Sizes.constant("67px", true)), 1),
				FormSpecs.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("67px", true), Sizes.constant("67px", true)), 1),
				FormSpecs.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("67px", true), Sizes.constant("67px", true)), 0),
				FormSpecs.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("20dlu", true), Sizes.constant("20dlu", true)), 0),},
			new RowSpec[] {
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
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("10dlu", false), Sizes.constant("10dlu", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("1px", false), Sizes.constant("1px", false)), 0),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("10dlu", false), Sizes.constant("10dlu", false)), 0),
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
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("5dlu", false), Sizes.constant("5dlu", false)), 0),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblNewLabel = new JLabel("MEDICIÓN DE PARÁMETROS DE FUNCIONAMIENTO DEL SISTEMA HIDRONEUMÁTICO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, "2, 2, 19, 1");
		
		lblNewLabel_6 = new JLabel("New label");
		panel.add(lblNewLabel_6, "22, 2");
		
		JLabel lblNewLabel_2_4 = new JLabel("Equipos:");
		lblNewLabel_2_4.setForeground(new Color(0, 102, 255));
		panel.add(lblNewLabel_2_4, "2, 6");
		
		JLabel lblNewLabel_3 = new JLabel("Bomba hydrobloc, Compresor, Tablero de control, Pulmón Hidroneumático");
		lblNewLabel_3.setForeground(new Color(0, 102, 255));
		panel.add(lblNewLabel_3, "4, 6, 13, 1");
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Jefe de Mantenimiento:");
		lblNewLabel_2_4_1.setForeground(new Color(0, 102, 255));
		panel.add(lblNewLabel_2_4_1, "2, 8, left, default");
		
		textBoss = new JTextField();
		textBoss.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		textBoss.setCaretColor(new Color(0, 102, 255));
		textBoss.setForeground(new Color(0, 102, 255));
		panel.add(textBoss, "4, 8, 17, 1, fill, default");
		textBoss.setColumns(10);
		
		JLabel lblNewLabel_2_4_2 = new JLabel("Operador:");
		lblNewLabel_2_4_2.setForeground(new Color(0, 102, 255));
		panel.add(lblNewLabel_2_4_2, "2, 10, left, default");
		
		textOperator = new JTextField();
		textOperator.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		textOperator.setCaretColor(new Color(0, 102, 255));
		textOperator.setForeground(new Color(0, 102, 255));
		textOperator.setColumns(10);
		panel.add(textOperator, "4, 10, 17, 1, fill, default");
		
		JLabel lblNewLabel_2_4_3 = new JLabel("Número de Control:");
		lblNewLabel_2_4_3.setForeground(new Color(0, 102, 255));
		panel.add(lblNewLabel_2_4_3, "2, 12, left, default");
		
		textControlNumber = new JTextField();
		textControlNumber.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		textControlNumber.setCaretColor(new Color(0, 102, 255));
		textControlNumber.setForeground(new Color(0, 102, 255));
		textControlNumber.setColumns(10);
		panel.add(textControlNumber, "4, 12, 17, 1, fill, default");
		
		JLabel lblNewLabel_1 = new JLabel("EQUIPO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0, 102, 255));
		lblNewLabel_1.setForeground(Color.WHITE);
		panel.add(lblNewLabel_1, "2, 16, 2, 3, fill, fill");
		
		JLabel lblNewLabel_1_1 = new JLabel("EVALUACIÓN");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBackground(new Color(0, 102, 255));
		panel.add(lblNewLabel_1_1, "4, 16, 2, 3, default, fill");
		
		JLabel lblNewLabel_1_1_1 = new JLabel("FECHA:");
		lblNewLabel_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBackground(new Color(0, 102, 255));
		panel.add(lblNewLabel_1_1_1, "6, 16, 2, 2, default, fill");
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("FECHA:");
		lblNewLabel_1_1_1_2.setOpaque(true);
		lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_2.setBackground(new Color(0, 102, 255));
		panel.add(lblNewLabel_1_1_1_2, "8, 16, 2, 2");
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("FECHA:");
		lblNewLabel_1_1_1_3.setOpaque(true);
		lblNewLabel_1_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_3.setBackground(new Color(0, 102, 255));
		panel.add(lblNewLabel_1_1_1_3, "10, 16, 2, 2");
		
		JLabel lblNewLabel_1_1_1_4 = new JLabel("FECHA:");
		lblNewLabel_1_1_1_4.setOpaque(true);
		lblNewLabel_1_1_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_4.setBackground(new Color(0, 102, 255));
		panel.add(lblNewLabel_1_1_1_4, "12, 16, 2, 2");
		
		JLabel lblNewLabel_1_1_1_5 = new JLabel("FECHA:");
		lblNewLabel_1_1_1_5.setOpaque(true);
		lblNewLabel_1_1_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_5.setBackground(new Color(0, 102, 255));
		panel.add(lblNewLabel_1_1_1_5, "14, 16, 2, 2");
		
		JLabel lblNewLabel_1_1_1_6 = new JLabel("FECHA:");
		lblNewLabel_1_1_1_6.setOpaque(true);
		lblNewLabel_1_1_1_6.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_6.setBackground(new Color(0, 102, 255));
		panel.add(lblNewLabel_1_1_1_6, "16, 16, 2, 2");
		
		JLabel lblNewLabel_1_1_1_7 = new JLabel("FECHA:");
		lblNewLabel_1_1_1_7.setOpaque(true);
		lblNewLabel_1_1_1_7.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_7.setBackground(new Color(0, 102, 255));
		panel.add(lblNewLabel_1_1_1_7, "18, 16, 2, 2");
		
		JLabel lblNewLabel_1_1_1_8 = new JLabel("PROMEDIO");
		lblNewLabel_1_1_1_8.setOpaque(true);
		lblNewLabel_1_1_1_8.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_8.setBackground(new Color(0, 102, 255));
		panel.add(lblNewLabel_1_1_1_8, "20, 16, 1, 3");
		

		dateA.setCaretColor(Color.WHITE);
		dateA.setBorder(null);
		dateA.setBackground(new Color(0, 102, 255));
		dateA.setForeground(Color.WHITE);
		panel.add(dateA, "6, 18, 2, 1, default, fill");
		
		
		dateB.setCaretColor(Color.WHITE);
		dateB.setForeground(Color.WHITE);
		dateB.setBorder(null);
		dateB.setBackground(new Color(0, 102, 255));
		panel.add(dateB, "8, 18, 2, 1, fill, fill");
		
	
		dateC.setCaretColor(Color.WHITE);
		dateC.setForeground(Color.WHITE);
		dateC.setBorder(null);
		dateC.setBackground(new Color(0, 102, 255));
		panel.add(dateC, "10, 18, 2, 1, fill, fill");
		

		dateD.setCaretColor(Color.WHITE);
		dateD.setForeground(Color.WHITE);
		dateD.setBorder(null);
		dateD.setBackground(new Color(0, 102, 255));
		panel.add(dateD, "12, 18, 2, 1, fill, fill");
		

		dateE.setCaretColor(Color.WHITE);
		dateE.setForeground(Color.WHITE);
		dateE.setBorder(null);
		dateE.setBackground(new Color(0, 102, 255));
		panel.add(dateE, "14, 18, 2, 1, fill, fill");
		

		dateF.setCaretColor(Color.WHITE);
		dateF.setForeground(Color.WHITE);
		dateF.setBorder(null);
		dateF.setBackground(new Color(0, 102, 255));
		panel.add(dateF, "16, 18, 2, 1, fill, fill");
		

		dateG.setCaretColor(Color.WHITE);
		dateG.setForeground(Color.WHITE);
		dateG.setBorder(null);
		dateG.setBackground(new Color(0, 102, 255));
		panel.add(dateG, "18, 18, 2, 1, fill, fill");
		
		JLabel lblNewLabel_2 = new JLabel("COMPRESOR");
		lblNewLabel_2.setForeground(new Color(0, 102, 204));
		panel.add(lblNewLabel_2, "2, 20");
		
		JLabel lblNewLabel_2_3 = new JLabel("Voltaje");
		lblNewLabel_2_3.setForeground(new Color(0, 102, 204));
		panel.add(lblNewLabel_2_3, "4, 20, left, default");
		
		dateA1 = new JTextField();

		dateA1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateA1.setCaretColor(new Color(0, 102, 255));
		dateA1.setForeground(new Color(0, 102, 255));
		panel.add(dateA1, "6, 20, fill, default");
		dateA1.setColumns(10);
		
		dateB1 = new JTextField();
		dateB1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateB1.setCaretColor(new Color(0, 102, 255));
		dateB1.setForeground(new Color(0, 102, 255));
		dateB1.setColumns(10);
		panel.add(dateB1, "8, 20, fill, default");
		
		dateC1 = new JTextField();
		dateC1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateC1.setCaretColor(new Color(0, 102, 255));
		dateC1.setForeground(new Color(0, 102, 255));
		dateC1.setColumns(10);
		panel.add(dateC1, "10, 20, fill, default");
		
		dateD1 = new JTextField();
		dateD1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateD1.setCaretColor(new Color(0, 102, 255));
		dateD1.setForeground(new Color(0, 102, 255));
		dateD1.setColumns(10);
		panel.add(dateD1, "12, 20, fill, default");
		
		dateE1 = new JTextField();
		dateE1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateE1.setCaretColor(new Color(0, 102, 255));
		dateE1.setForeground(new Color(0, 102, 255));
		dateE1.setColumns(10);
		panel.add(dateE1, "14, 20, fill, default");
		
		dateF1 = new JTextField();
		dateF1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateF1.setCaretColor(new Color(0, 102, 255));
		dateF1.setForeground(new Color(0, 102, 255));
		dateF1.setColumns(10);
		panel.add(dateF1, "16, 20, fill, default");
		
		dateG1 = new JTextField();
		dateG1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateG1.setCaretColor(new Color(0, 102, 255));
		dateG1.setForeground(new Color(0, 102, 255));
		dateG1.setColumns(10);
		panel.add(dateG1, "18, 20, fill, default");
		

		average1.setForeground(new Color(0, 102, 255));
		panel.add(average1, "20, 20");
		
		JLabel lblNewLabel_2_1 = new JLabel("BOMBA");
		lblNewLabel_2_1.setForeground(new Color(0, 102, 204));
		panel.add(lblNewLabel_2_1, "2, 22");
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Voltaje");
		lblNewLabel_2_3_1.setForeground(new Color(0, 102, 204));
		panel.add(lblNewLabel_2_3_1, "4, 22, left, default");
		
		dateA2 = new JTextField();
		dateA2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateA2.setCaretColor(new Color(0, 102, 255));
		dateA2.setForeground(new Color(0, 102, 255));
		dateA2.setColumns(10);
		panel.add(dateA2, "6, 22, fill, default");
		
		dateB2 = new JTextField();
		dateB2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateB2.setCaretColor(new Color(0, 102, 255));
		dateB2.setForeground(new Color(0, 102, 255));
		dateB2.setColumns(10);
		panel.add(dateB2, "8, 22, fill, default");
		
		dateC2 = new JTextField();
		dateC2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateC2.setCaretColor(new Color(0, 102, 255));
		dateC2.setForeground(new Color(0, 102, 255));
		dateC2.setColumns(10);
		panel.add(dateC2, "10, 22, fill, default");
		
		dateD2 = new JTextField();
		dateD2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateD2.setCaretColor(new Color(0, 102, 255));
		dateD2.setForeground(new Color(0, 102, 255));
		dateD2.setColumns(10);
		panel.add(dateD2, "12, 22, fill, default");
		
		dateE2 = new JTextField();
		dateE2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateE2.setCaretColor(new Color(0, 102, 255));
		dateE2.setForeground(new Color(0, 102, 255));
		dateE2.setColumns(10);
		panel.add(dateE2, "14, 22, fill, default");
		
		dateF2 = new JTextField();
		dateF2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateF2.setCaretColor(new Color(0, 102, 255));
		dateF2.setForeground(new Color(0, 102, 255));
		dateF2.setColumns(10);
		panel.add(dateF2, "16, 22, fill, default");
		
		dateG2 = new JTextField();
		dateG2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateG2.setCaretColor(new Color(0, 102, 255));
		dateG2.setForeground(new Color(0, 102, 255));
		dateG2.setColumns(10);
		panel.add(dateG2, "18, 22, fill, default");
		

		average2.setForeground(new Color(0, 102, 255));
		panel.add(average2, "20, 22");
		
		JLabel lblNewLabel_2_2 = new JLabel("COMPRESOR");
		lblNewLabel_2_2.setForeground(new Color(0, 102, 204));
		panel.add(lblNewLabel_2_2, "2, 24");
		
		JLabel lblNewLabel_2_3_2 = new JLabel("Amperaje");
		lblNewLabel_2_3_2.setForeground(new Color(0, 102, 204));
		panel.add(lblNewLabel_2_3_2, "4, 24, left, default");
		
		dateA3 = new JTextField();
		dateA3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateA3.setCaretColor(new Color(0, 102, 255));
		dateA3.setForeground(new Color(0, 102, 255));
		dateA3.setColumns(10);
		panel.add(dateA3, "6, 24, fill, default");
		
		dateB3 = new JTextField();
		dateB3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateB3.setCaretColor(new Color(0, 102, 255));
		dateB3.setForeground(new Color(0, 102, 255));
		dateB3.setColumns(10);
		panel.add(dateB3, "8, 24, fill, default");
		
		dateC3 = new JTextField();
		dateC3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateC3.setCaretColor(new Color(0, 102, 255));
		dateC3.setForeground(new Color(0, 102, 255));
		dateC3.setColumns(10);
		panel.add(dateC3, "10, 24, fill, default");
		
		dateD3 = new JTextField();
		dateD3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateD3.setCaretColor(new Color(0, 102, 255));
		dateD3.setForeground(new Color(0, 102, 255));
		dateD3.setColumns(10);
		panel.add(dateD3, "12, 24, fill, default");
		
		dateE3 = new JTextField();
		dateE3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateE3.setCaretColor(new Color(0, 102, 255));
		dateE3.setForeground(new Color(0, 102, 255));
		dateE3.setColumns(10);
		panel.add(dateE3, "14, 24, fill, default");
		
		dateF3 = new JTextField();
		dateF3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateF3.setCaretColor(new Color(0, 102, 255));
		dateF3.setForeground(new Color(0, 102, 255));
		dateF3.setColumns(10);
		panel.add(dateF3, "16, 24, fill, default");
		
		dateG3 = new JTextField();
		dateG3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateG3.setCaretColor(new Color(0, 102, 255));
		dateG3.setForeground(new Color(0, 102, 255));
		dateG3.setColumns(10);
		panel.add(dateG3, "18, 24, fill, default");
		

		average3.setForeground(new Color(0, 102, 255));
		panel.add(average3, "20, 24");
		
		JLabel lblNewLabel_2_1_1 = new JLabel("BOMBA");
		lblNewLabel_2_1_1.setForeground(new Color(0, 102, 204));
		panel.add(lblNewLabel_2_1_1, "2, 26");
		
		JLabel lblNewLabel_2_3_3 = new JLabel("Amperaje");
		lblNewLabel_2_3_3.setForeground(new Color(0, 102, 204));
		panel.add(lblNewLabel_2_3_3, "4, 26, left, default");
		
		dateA4 = new JTextField();
		dateA4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateA4.setCaretColor(new Color(0, 102, 255));
		dateA4.setForeground(new Color(0, 102, 255));
		dateA4.setColumns(10);
		panel.add(dateA4, "6, 26, fill, default");
		
		dateB4 = new JTextField();
		dateB4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateB4.setCaretColor(new Color(0, 102, 255));
		dateB4.setForeground(new Color(0, 102, 255));
		dateB4.setColumns(10);
		panel.add(dateB4, "8, 26, fill, default");
		
		dateC4 = new JTextField();
		dateC4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateC4.setCaretColor(new Color(0, 102, 255));
		dateC4.setForeground(new Color(0, 102, 255));
		dateC4.setColumns(10);
		panel.add(dateC4, "10, 26, fill, default");
		
		dateD4 = new JTextField();
		dateD4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateD4.setCaretColor(new Color(0, 102, 255));
		dateD4.setForeground(new Color(0, 102, 255));
		dateD4.setColumns(10);
		panel.add(dateD4, "12, 26, fill, default");
		
		dateE4 = new JTextField();
		dateE4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateE4.setCaretColor(new Color(0, 102, 255));
		dateE4.setForeground(new Color(0, 102, 255));
		dateE4.setColumns(10);
		panel.add(dateE4, "14, 26, fill, default");
		
		dateF4 = new JTextField();
		dateF4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateF4.setCaretColor(new Color(0, 102, 255));
		dateF4.setForeground(new Color(0, 102, 255));
		dateF4.setColumns(10);
		panel.add(dateF4, "16, 26, fill, default");
		
		dateG4 = new JTextField();
		dateG4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateG4.setCaretColor(new Color(0, 102, 255));
		dateG4.setForeground(new Color(0, 102, 255));
		dateG4.setColumns(10);
		panel.add(dateG4, "18, 26, fill, default");
		

		average4.setForeground(new Color(0, 102, 255));
		panel.add(average4, "20, 26");
		
		JLabel lblNewLabel_2_1_2 = new JLabel("PULMÓN HIDRONEUMÁTICO");
		lblNewLabel_2_1_2.setForeground(new Color(0, 102, 204));
		panel.add(lblNewLabel_2_1_2, "2, 28");
		
		JLabel lblNewLabel_2_3_4 = new JLabel("Presión alta para activar el compresor");
		lblNewLabel_2_3_4.setForeground(new Color(0, 102, 204));
		panel.add(lblNewLabel_2_3_4, "4, 28, left, default");
		
		dateA5 = new JTextField();
		dateA5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateA5.setCaretColor(new Color(0, 102, 255));
		dateA5.setForeground(new Color(0, 102, 255));
		dateA5.setColumns(10);
		panel.add(dateA5, "6, 28, fill, default");
		
		dateB5 = new JTextField();
		dateB5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateB5.setCaretColor(new Color(0, 102, 255));
		dateB5.setForeground(new Color(0, 102, 255));
		dateB5.setColumns(10);
		panel.add(dateB5, "8, 28, fill, default");
		
		dateC5 = new JTextField();
		dateC5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateC5.setCaretColor(new Color(0, 102, 255));
		dateC5.setForeground(new Color(0, 102, 255));
		dateC5.setColumns(10);
		panel.add(dateC5, "10, 28, fill, default");
		
		dateD5 = new JTextField();
		dateD5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateD5.setCaretColor(new Color(0, 102, 255));
		dateD5.setForeground(new Color(0, 102, 255));
		dateD5.setColumns(10);
		panel.add(dateD5, "12, 28, fill, default");
		
		dateE5 = new JTextField();
		dateE5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateE5.setCaretColor(new Color(0, 102, 255));
		dateE5.setForeground(new Color(0, 102, 255));
		dateE5.setColumns(10);
		panel.add(dateE5, "14, 28, fill, default");
		
		dateF5 = new JTextField();
		dateF5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateF5.setCaretColor(new Color(0, 102, 255));
		dateF5.setForeground(new Color(0, 102, 255));
		dateF5.setColumns(10);
		panel.add(dateF5, "16, 28, fill, default");
		
		dateG5 = new JTextField();
		dateG5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateG5.setCaretColor(new Color(0, 102, 255));
		dateG5.setForeground(new Color(0, 102, 255));
		dateG5.setColumns(10);
		panel.add(dateG5, "18, 28, fill, default");
		

		average5.setForeground(new Color(0, 102, 255));
		panel.add(average5, "20, 28");
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("PULMÓN HIDRONEUMÁTICO");
		lblNewLabel_2_1_2_1.setForeground(new Color(0, 102, 204));
		panel.add(lblNewLabel_2_1_2_1, "2, 30");
		
		JLabel lblNewLabel_2_3_5 = new JLabel("Presión baja para activar el compresor");
		lblNewLabel_2_3_5.setForeground(new Color(0, 102, 204));
		panel.add(lblNewLabel_2_3_5, "4, 30, left, default");
		
		dateA6 = new JTextField();
		dateA6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateA6.setCaretColor(new Color(0, 102, 255));
		dateA6.setForeground(new Color(0, 102, 255));
		dateA6.setColumns(10);
		panel.add(dateA6, "6, 30, fill, default");
		
		dateB6 = new JTextField();
		dateB6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateB6.setCaretColor(new Color(0, 102, 255));
		dateB6.setForeground(new Color(0, 102, 255));
		dateB6.setColumns(10);
		panel.add(dateB6, "8, 30, fill, default");
		
		dateC6 = new JTextField();
		dateC6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateC6.setCaretColor(new Color(0, 102, 255));
		dateC6.setForeground(new Color(0, 102, 255));
		dateC6.setColumns(10);
		panel.add(dateC6, "10, 30, fill, default");
		
		dateD6 = new JTextField();
		dateD6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateD6.setCaretColor(new Color(0, 102, 255));
		dateD6.setForeground(new Color(0, 102, 255));
		dateD6.setColumns(10);
		panel.add(dateD6, "12, 30, fill, default");
		
		dateE6 = new JTextField();
		dateE6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateE6.setCaretColor(new Color(0, 102, 255));
		dateE6.setForeground(new Color(0, 102, 255));
		dateE6.setColumns(10);
		panel.add(dateE6, "14, 30, fill, default");
		
		dateF6 = new JTextField();
		dateF6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateF6.setCaretColor(new Color(0, 102, 255));
		dateF6.setForeground(new Color(0, 102, 255));
		dateF6.setColumns(10);
		panel.add(dateF6, "16, 30, fill, default");
		
		dateG6 = new JTextField();
		dateG6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		dateG6.setCaretColor(new Color(0, 102, 255));
		dateG6.setForeground(new Color(0, 102, 255));
		dateG6.setColumns(10);
		panel.add(dateG6, "18, 30, fill, default");
		

		average6.setForeground(new Color(0, 102, 255));
		panel.add(average6, "20, 30");
		
		observetions = new JTextArea();
		observetions.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Observaciones:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 255)));
		panel.add(observetions, "2, 34, 19, 1, fill, fill");
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, "2, 36, 3, 1, fill, fill");
		panel_1.setLayout(null);
		
		lblNewLabel_5 = new JLabel("Recibido por:");
		lblNewLabel_5.setForeground(new Color(0, 102, 255));
		lblNewLabel_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		lblNewLabel_5.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_5.setBounds(10, 0, 286, 57);
		panel_1.add(lblNewLabel_5);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setLayout(null);
		panel.add(panel_1_1, "6, 36, 7, 1, fill, fill");
		
		JLabel lblNewLabel_5_1 = new JLabel("Firma");
		lblNewLabel_5_1.setForeground(new Color(0, 102, 255));
		lblNewLabel_5_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_5_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		lblNewLabel_5_1.setBounds(10, 0, 244, 57);
		panel_1_1.add(lblNewLabel_5_1);
		
		panel_1_2 = new JPanel();
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setLayout(null);
		panel.add(panel_1_2, "16, 36, 5, 1, fill, fill");
		
		lblNewLabel_5_2 = new JLabel("Fecha:");
		lblNewLabel_5_2.setForeground(new Color(0, 102, 255));
		lblNewLabel_5_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_5_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		lblNewLabel_5_2.setBounds(10, 0, 168, 57);
		panel_1_2.add(lblNewLabel_5_2);
		

		btnNewButton.setBounds(824, 529, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnCerrar = new JButton("cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(56, 529, 89, 23);
		getContentPane().add(btnCerrar);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!idx.equals("0")) {
					PrinterJob job = PrinterJob.getPrinterJob();
					job.setPrintable(new Cuantitative(idx));
					if (job.printDialog()) {
						try {
							job.print();
						} catch (PrinterException e1) {
						}
					}					
				}
				
			}
		});
		btnImprimir.setBounds(435, 529, 89, 23);
		getContentPane().add(btnImprimir);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveData();
		
			}
		});
		
		dateA1.addKeyListener(new regulate());
		dateB1.addKeyListener(new regulate());
		dateC1.addKeyListener(new regulate());
		dateD1.addKeyListener(new regulate());
		dateE1.addKeyListener(new regulate());
		dateF1.addKeyListener(new regulate());
		dateG1.addKeyListener(new regulate());
		dateA2.addKeyListener(new regulate());
		dateB2.addKeyListener(new regulate());
		dateC2.addKeyListener(new regulate());
		dateD2.addKeyListener(new regulate());
		dateE2.addKeyListener(new regulate());
		dateF2.addKeyListener(new regulate());
		dateG2.addKeyListener(new regulate());
		dateA3.addKeyListener(new regulate());
		dateB3.addKeyListener(new regulate());
		dateC3.addKeyListener(new regulate());
		dateD3.addKeyListener(new regulate());
		dateE3.addKeyListener(new regulate());
		dateF3.addKeyListener(new regulate());
		dateG3.addKeyListener(new regulate());
		dateA4.addKeyListener(new regulate());
		dateB4.addKeyListener(new regulate());
		dateC4.addKeyListener(new regulate());
		dateD4.addKeyListener(new regulate());
		dateE4.addKeyListener(new regulate());
		dateF4.addKeyListener(new regulate());
		dateG4.addKeyListener(new regulate());
		dateA5.addKeyListener(new regulate());
		dateB5.addKeyListener(new regulate());
		dateC5.addKeyListener(new regulate());
		dateD5.addKeyListener(new regulate());
		dateE5.addKeyListener(new regulate());
		dateF5.addKeyListener(new regulate());
		dateG5.addKeyListener(new regulate());
		dateA6.addKeyListener(new regulate());
		dateB6.addKeyListener(new regulate());
		dateC6.addKeyListener(new regulate());
		dateD6.addKeyListener(new regulate());
		dateE6.addKeyListener(new regulate());
		dateF6.addKeyListener(new regulate());
		dateG6.addKeyListener(new regulate());
	}
	
	class regulate extends KeyAdapter{
		
		@Override
		public void keyReleased(KeyEvent e) {
			
			ArrayList<String> m1 = new ArrayList<String>(Arrays.asList(dateA1.getText(), dateB1.getText(), dateC1.getText(), dateD1.getText(), dateE1.getText(), dateF1.getText(), dateG1.getText()));
			ArrayList<String> m2 = new ArrayList<String>(Arrays.asList(dateA2.getText(), dateB2.getText(), dateC2.getText(), dateD2.getText(), dateE2.getText(), dateF2.getText(), dateG2.getText()));
			ArrayList<String> m3 = new ArrayList<String>(Arrays.asList(dateA3.getText(), dateB3.getText(), dateC3.getText(), dateD3.getText(), dateE3.getText(), dateF3.getText(), dateG3.getText()));
			ArrayList<String> m4 = new ArrayList<String>(Arrays.asList(dateA4.getText(), dateB4.getText(), dateC4.getText(), dateD4.getText(), dateE4.getText(), dateF4.getText(), dateG4.getText()));
			ArrayList<String> m5 = new ArrayList<String>(Arrays.asList(dateA5.getText(), dateB5.getText(), dateC5.getText(), dateD5.getText(), dateE5.getText(), dateF5.getText(), dateG5.getText()));
			ArrayList<String> m6 = new ArrayList<String>(Arrays.asList(dateA6.getText(), dateB6.getText(), dateC6.getText(), dateD6.getText(), dateE6.getText(), dateF6.getText(), dateG6.getText()));
			
			average1.setText(getMedia(m1));
			average2.setText(getMedia(m2));
			average3.setText(getMedia(m3));
			average4.setText(getMedia(m4));
			average5.setText(getMedia(m5));
			average6.setText(getMedia(m6));
		}
		
	}
}
