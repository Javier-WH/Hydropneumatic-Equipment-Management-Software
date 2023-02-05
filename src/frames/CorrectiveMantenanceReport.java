package frames;
import javax.swing.JDialog;
import java.awt.Toolkit;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.Sizes;

import actors.CorrectiveMantenanceActor;
import sql.Corrective;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;





@SuppressWarnings("serial")
public class CorrectiveMantenanceReport extends JDialog implements Printable{
	private static JPanel panel = new JPanel();
	private Boolean areValidDates = true;

	
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
	    if (pageIndex > 0)
	      return NO_SUCH_PAGE;
	    Graphics2D page = (Graphics2D) graphics;
        page.translate(pageFormat.getImageableX()+30, pageFormat.getImageableY()+30);
        page.scale(1.0, 1.0);
        
        panel.printAll(graphics);
	    return PAGE_EXISTS;
	  }
	
	
	
	public CorrectiveMantenanceReport(CorrectiveMantenanceActor correctiveData ) {
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CorrectiveMantenanceReport.class.getResource("/img/icono.png")));
		setTitle("Mantenimiento Correctivo");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(710, 383);
		getContentPane().setLayout(null);
		
		
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 694, 267);
		getContentPane().add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("85dlu", true), Sizes.constant("85dlu", true)), 0),
				FormSpecs.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("120dlu", true), Sizes.constant("120dlu", true)), 0),
				FormSpecs.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("50dlu", true), Sizes.constant("50dlu", true)), 0),
				FormSpecs.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("50dlu", true), Sizes.constant("50dlu", true)), 0),
				FormSpecs.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("70dlu", true), Sizes.constant("70dlu", true)), 0),},
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_3 = new JLabel("RUTINAS DE MANTENIMIENTO CORRECTIVO");
		panel.add(lblNewLabel_3, "2, 2, 9, 1");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("EQUIPO");
		panel.add(lblNewLabel_1, "2, 6, 2, 1");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBackground(new Color(0, 102, 255));
		
		JLabel lblNewLabel_1_1 = new JLabel("ACTIVIDAD");
		panel.add(lblNewLabel_1_1, "4, 6, 2, 1");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBackground(new Color(0, 102, 255));
		
		JLabel lblNewLabel_1_2 = new JLabel("FECHA 1");
		panel.add(lblNewLabel_1_2, "6, 6, 2, 1");
		lblNewLabel_1_2.setOpaque(true);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBackground(new Color(0, 102, 255));
		
		JLabel lblNewLabel_1_3 = new JLabel("FECHA 2");
		panel.add(lblNewLabel_1_3, "8, 6, 2, 1");
		lblNewLabel_1_3.setOpaque(true);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBackground(new Color(0, 102, 255));
		
		JLabel lblNewLabel_1_4 = new JLabel("RANGO");
		panel.add(lblNewLabel_1_4, "10, 6");
		lblNewLabel_1_4.setOpaque(true);
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBackground(new Color(0, 102, 255));
		
		JLabel lblNewLabel = new JLabel("BANCADA COMPRESOR");
		panel.add(lblNewLabel, "2, 8");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		lblNewLabel.setForeground(new Color(0, 102, 255));
		
		JLabel lblCambioDeAceite = new JLabel("Cambio de aceite de bancada compresor");
		panel.add(lblCambioDeAceite, "4, 8");
		lblCambioDeAceite.setForeground(new Color(0, 102, 255));
		lblCambioDeAceite.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		
		JFormattedTextField dateA1 = new JFormattedTextField();
		dateA1.setForeground(new Color(0, 102, 255));
		dateA1.setBackground(Color.WHITE);
		dateA1.setEditable(false);
		dateA1.setBorder(null);
		panel.add(dateA1, "6, 8");
		
		JFormattedTextField dateB1 = new JFormattedTextField();
		dateB1.setForeground(new Color(0, 102, 255));
		dateB1.setBackground(Color.WHITE);
		dateB1.setEditable(false);
		dateB1.setBorder(null);
		panel.add(dateB1, "8, 8");
		
		JLabel range1 = new JLabel("");
		panel.add(range1, "10, 8");
		range1.setForeground(new Color(0, 102, 255));
		range1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("BANCADA COMPRESOR");
		panel.add(lblNewLabel_2, "2, 10");
		lblNewLabel_2.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(new Color(0, 102, 255));
		
		JLabel lblCambioDeCorrea = new JLabel("Cambio de correa del compresor");
		panel.add(lblCambioDeCorrea, "4, 10");
		lblCambioDeCorrea.setForeground(new Color(0, 102, 255));
		lblCambioDeCorrea.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		
		JFormattedTextField dateA2 = new JFormattedTextField();
		dateA2.setForeground(new Color(0, 102, 255));
		dateA2.setBackground(Color.WHITE);
		dateA2.setEditable(false);
		dateA2.setBorder(null);
		panel.add(dateA2, "6, 10");
		
		JFormattedTextField dateB2 = new JFormattedTextField();
		dateB2.setForeground(new Color(0, 102, 255));
		dateB2.setBackground(Color.WHITE);
		dateB2.setEditable(false);
		dateB2.setBorder(null);
		panel.add(dateB2, "8, 10");
		
		JLabel range2 = new JLabel("");
		panel.add(range2, "10, 10");
		range2.setForeground(new Color(0, 102, 255));
		range2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblBomba = new JLabel("BOMBA");
		panel.add(lblBomba, "2, 12");
		lblBomba.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		lblBomba.setForeground(new Color(0, 102, 255));
		
		JLabel lblCambioDeSellos = new JLabel("Cambio de sellos mecánicos");
		panel.add(lblCambioDeSellos, "4, 12");
		lblCambioDeSellos.setForeground(new Color(0, 102, 255));
		lblCambioDeSellos.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		
		JFormattedTextField dateA3 = new JFormattedTextField();
		dateA3.setForeground(new Color(0, 102, 255));
		dateA3.setBackground(Color.WHITE);
		dateA3.setEditable(false);
		dateA3.setBorder(null);
		panel.add(dateA3, "6, 12");
		
		JFormattedTextField dateB3 = new JFormattedTextField();
		dateB3.setForeground(new Color(0, 102, 255));
		dateB3.setBackground(Color.WHITE);
		dateB3.setEditable(false);
		dateB3.setBorder(null);
		panel.add(dateB3, "8, 12");
		
		JLabel range3 = new JLabel("");
		panel.add(range3, "10, 12");
		range3.setForeground(new Color(0, 102, 255));
		range3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblBomba_1 = new JLabel("BOMBA");
		panel.add(lblBomba_1, "2, 14");
		lblBomba_1.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		lblBomba_1.setForeground(new Color(0, 102, 255));
		
		JLabel lblCambioDeRodamientos = new JLabel("Cambio de rodamientos");
		panel.add(lblCambioDeRodamientos, "4, 14");
		lblCambioDeRodamientos.setForeground(new Color(0, 102, 255));
		lblCambioDeRodamientos.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		
		JFormattedTextField dateA4 = new JFormattedTextField();
		dateA4.setForeground(new Color(0, 102, 255));
		dateA4.setBackground(Color.WHITE);
		dateA4.setEditable(false);
		dateA4.setBorder(null);
		panel.add(dateA4, "6, 14");
		
		JFormattedTextField dateB4 = new JFormattedTextField();
		dateB4.setForeground(new Color(0, 102, 255));
		dateB4.setBackground(Color.WHITE);
		dateB4.setEditable(false);
		dateB4.setBorder(null);
		panel.add(dateB4, "8, 14");
		
		JLabel range4 = new JLabel("");
		panel.add(range4, "10, 14");
		range4.setForeground(new Color(0, 102, 255));
		range4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblBomba_2 = new JLabel("BOMBA");
		panel.add(lblBomba_2, "2, 16");
		lblBomba_2.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		lblBomba_2.setForeground(new Color(0, 102, 255));
		
		JLabel lblCambioDeImpulsor = new JLabel("Cambio de impulsor");
		panel.add(lblCambioDeImpulsor, "4, 16");
		lblCambioDeImpulsor.setForeground(new Color(0, 102, 255));
		lblCambioDeImpulsor.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		
		JFormattedTextField dateA5 = new JFormattedTextField();
		dateA5.setForeground(new Color(0, 102, 255));
		dateA5.setBackground(Color.WHITE);
		dateA5.setEditable(false);
		dateA5.setBorder(null);
		panel.add(dateA5, "6, 16");
		
		JFormattedTextField dateB5 = new JFormattedTextField();
		dateB5.setForeground(new Color(0, 102, 255));
		dateB5.setBackground(Color.WHITE);
		dateB5.setEditable(false);
		dateB5.setBorder(null);
		panel.add(dateB5, "8, 16");
		
		JLabel range5 = new JLabel("");
		panel.add(range5, "10, 16");
		range5.setForeground(new Color(0, 102, 255));
		range5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTableroDeControl = new JLabel("TABLERO DE CONTROL");
		panel.add(lblTableroDeControl, "2, 18");
		lblTableroDeControl.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		lblTableroDeControl.setForeground(new Color(0, 102, 255));
		
		JLabel lblCambioDeBobinas = new JLabel("Cambio de bobinas del sistema eléctrico");
		panel.add(lblCambioDeBobinas, "4, 18");
		lblCambioDeBobinas.setForeground(new Color(0, 102, 255));
		lblCambioDeBobinas.setFont(new Font("Arial Narrow", Font.PLAIN, 12));
		
		JFormattedTextField dateA6 = new JFormattedTextField();
		dateA6.setForeground(new Color(0, 102, 255));
		dateA6.setBackground(Color.WHITE);
		dateA6.setEditable(false);
		dateA6.setBorder(null);
		panel.add(dateA6, "6, 18");
		
		JFormattedTextField dateB6 = new JFormattedTextField();
		dateB6.setForeground(new Color(0, 102, 255));
		dateB6.setBackground(Color.WHITE);
		dateB6.setEditable(false);
		dateB6.setBorder(null);
		panel.add(dateB6, "8, 18");
		
		JLabel range6 = new JLabel("");
		panel.add(range6, "10, 18");
		range6.setForeground(new Color(0, 102, 255));
		range6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnPrint = new JButton("Imprimir");
		btnPrint.setIcon(new ImageIcon(CorrectiveMantenanceReport.class.getResource("/img/imprimir.png")));
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setBackground(new Color(0, 102, 255));
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  PrinterJob job = PrinterJob.getPrinterJob();
				    job.setPrintable(new CorrectiveMantenanceReport(correctiveData));
				    if (job.printDialog()) {
				      try {
				        job.print();
				      } catch (PrinterException e1) {
				      }
				    }
			}
		});
		btnPrint.setBounds(489, 292, 125, 41);
		getContentPane().add(btnPrint);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(CorrectiveMantenanceReport.class.getResource("/img/puerta-cerrada.png")));
		btnCancelar.setBackground(new Color(0, 102, 255));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(59, 292, 125, 41);
		getContentPane().add(btnCancelar);
		

		dateA1.setText(correctiveData.getC_cambio_aceite1());
		dateB1.setText(correctiveData.getC_cambio_aceite2());
		range1.setText(calculateRange(correctiveData.getC_cambio_aceite1(), correctiveData.getC_cambio_aceite2()));
		dateA2.setText(correctiveData.getC_cambio_correa1());
		dateB2.setText(correctiveData.getC_cambio_correa2());
		range2.setText(calculateRange(correctiveData.getC_cambio_correa1(), correctiveData.getC_cambio_correa2()));
		dateA3.setText(correctiveData.getB_cambio_sellos1());
		dateB3.setText(correctiveData.getB_cambio_sellos2());
		range3.setText(calculateRange(correctiveData.getB_cambio_sellos1(), correctiveData.getB_cambio_sellos2()));
		dateA4.setText(correctiveData.getB_cambio_rodamientos1());
		dateB4.setText(correctiveData.getB_cambio_rodamientos2());
		range4.setText(calculateRange(correctiveData.getB_cambio_rodamientos1(), correctiveData.getB_cambio_rodamientos2()));
		dateA5.setText(correctiveData.getB_cambio_impulsor1());
		dateB5.setText(correctiveData.getB_cambio_impulsor2());
		range5.setText(calculateRange(correctiveData.getB_cambio_impulsor1(), correctiveData.getB_cambio_impulsor2()));
		dateA6.setText(correctiveData.getT_cambio_bobina1());
		dateB6.setText(correctiveData.getT_cambio_bobina2());
		range6.setText(calculateRange(correctiveData.getT_cambio_bobina1(), correctiveData.getT_cambio_bobina2()));
	
		
	}
	

	
	private String calculateRange(String date1, String date2) {
		

		String[] array1 = date1.split("/");
		String day1 = array1[0];
		String month1 = array1[1];
		String year1 = array1[2];
		
		String[] array2 = date2.split("/");
		String day2 = array2[0];
		String month2 = array2[1];
		String year2 = array2[2];
		
		
		try {
		    LocalDate dateBefore = LocalDate.parse(year1 + "-" + month1  + "-" + day1 );
		    LocalDate dateAfter = LocalDate.parse(year2 + "-" + month2 + "-" + day2);

		    long daysDiff = ChronoUnit.DAYS.between(dateBefore, dateAfter);
		      areValidDates = true;
		    return  daysDiff + " dias";
		}catch(Exception e){
		   // e.printStackTrace();
			areValidDates = false;
		    return "Fecha invalida";
		}
		
		

	}
}
