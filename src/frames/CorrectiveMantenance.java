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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;





@SuppressWarnings("serial")
public class CorrectiveMantenance extends JDialog {

	private Boolean areValidDates = true;

	public CorrectiveMantenance() {
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CorrectiveMantenance.class.getResource("/img/icono.png")));
		setTitle("Mantenimiento Correctivo");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(952, 386);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("10px", true), Sizes.constant("10px", true)), 0),
				ColumnSpec.decode("max(100dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(195dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("50dlu", true), Sizes.constant("50dlu", true)), 1),
				FormSpecs.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("50dlu", true), Sizes.constant("50dlu", true)), 1),
				FormSpecs.RELATED_GAP_COLSPEC,
				new ColumnSpec(ColumnSpec.FILL, Sizes.bounded(Sizes.DEFAULT, Sizes.constant("100dlu", true), Sizes.constant("100dlu", true)), 0),
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.PREFERRED, Sizes.constant("20dlu", false), Sizes.constant("20dlu", false)), 0),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_3 = new JLabel("RUTINAS DE MANTENIMIENTO CORRECTIVO");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel_3, "2, 4, 9, 1");
		
		JLabel lblNewLabel_1 = new JLabel("EQUIPO");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBackground(new Color(0, 102, 255));
		getContentPane().add(lblNewLabel_1, "2, 8, 2, 1, fill, fill");
		
		JLabel lblNewLabel_1_1 = new JLabel("ACTIVIDAD DE MANTENIMIENTO");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBackground(new Color(0, 102, 255));
		getContentPane().add(lblNewLabel_1_1, "4, 8, 2, 1");
		
		JLabel lblNewLabel_1_2 = new JLabel("FECHA 1");
		lblNewLabel_1_2.setOpaque(true);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBackground(new Color(0, 102, 255));
		getContentPane().add(lblNewLabel_1_2, "6, 8, 2, 1");
		
		JLabel lblNewLabel_1_3 = new JLabel("FECHA 2");
		lblNewLabel_1_3.setOpaque(true);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBackground(new Color(0, 102, 255));
		getContentPane().add(lblNewLabel_1_3, "8, 8, 2, 1");
		
		JLabel lblNewLabel_1_4 = new JLabel("RANGO DE TIEMPO");
		lblNewLabel_1_4.setOpaque(true);
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBackground(new Color(0, 102, 255));
		getContentPane().add(lblNewLabel_1_4, "10, 8");
		
		JLabel lblNewLabel = new JLabel("BANCADA COMPRESOR");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(0, 102, 255));
		getContentPane().add(lblNewLabel, "2, 10");
		
		JLabel lblCambioDeAceite = new JLabel("Cambio de aceite de bancada compresor");
		lblCambioDeAceite.setForeground(new Color(0, 102, 255));
		lblCambioDeAceite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblCambioDeAceite, "4, 10, left, default");
		
		JFormattedTextField dateA1 = new JFormattedTextField();
		getContentPane().add(dateA1, "6, 10, fill, default");
		
		JFormattedTextField dateB1 = new JFormattedTextField();
		getContentPane().add(dateB1, "8, 10, fill, default");
		
		JLabel range1 = new JLabel("");
		range1.setForeground(new Color(0, 102, 255));
		range1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(range1, "10, 10");
		
		JLabel lblNewLabel_2 = new JLabel("BANCADA COMPRESOR");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(new Color(0, 102, 255));
		getContentPane().add(lblNewLabel_2, "2, 12");
		
		JLabel lblCambioDeCorrea = new JLabel("Cambio de correa del compresor");
		lblCambioDeCorrea.setForeground(new Color(0, 102, 255));
		lblCambioDeCorrea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblCambioDeCorrea, "4, 12, left, default");
		
		JFormattedTextField dateA2 = new JFormattedTextField();
		getContentPane().add(dateA2, "6, 12, fill, default");
		
		JFormattedTextField dateB2 = new JFormattedTextField();
		getContentPane().add(dateB2, "8, 12, fill, default");
		
		JLabel range2 = new JLabel("");
		range2.setForeground(new Color(0, 102, 255));
		range2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(range2, "10, 12");
		
		JLabel lblBomba = new JLabel("BOMBA");
		lblBomba.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBomba.setForeground(new Color(0, 102, 255));
		getContentPane().add(lblBomba, "2, 14");
		
		JLabel lblCambioDeSellos = new JLabel("Cambio de sellos mecánicos");
		lblCambioDeSellos.setForeground(new Color(0, 102, 255));
		lblCambioDeSellos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblCambioDeSellos, "4, 14, left, default");
		
		JFormattedTextField dateA3 = new JFormattedTextField();
		getContentPane().add(dateA3, "6, 14, fill, default");
		
		JFormattedTextField dateB3 = new JFormattedTextField();
		getContentPane().add(dateB3, "8, 14, fill, default");
		
		JLabel range3 = new JLabel("");
		range3.setForeground(new Color(0, 102, 255));
		range3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(range3, "10, 14");
		
		JLabel lblBomba_1 = new JLabel("BOMBA");
		lblBomba_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBomba_1.setForeground(new Color(0, 102, 255));
		getContentPane().add(lblBomba_1, "2, 16");
		
		JLabel lblCambioDeRodamientos = new JLabel("Cambio de rodamientos");
		lblCambioDeRodamientos.setForeground(new Color(0, 102, 255));
		lblCambioDeRodamientos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblCambioDeRodamientos, "4, 16, left, default");
		
		JFormattedTextField dateA4 = new JFormattedTextField();
		getContentPane().add(dateA4, "6, 16, fill, default");
		
		JFormattedTextField dateB4 = new JFormattedTextField();
		getContentPane().add(dateB4, "8, 16, fill, default");
		
		JLabel range4 = new JLabel("");
		range4.setForeground(new Color(0, 102, 255));
		range4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(range4, "10, 16");
		
		JLabel lblBomba_2 = new JLabel("BOMBA");
		lblBomba_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBomba_2.setForeground(new Color(0, 102, 255));
		getContentPane().add(lblBomba_2, "2, 18");
		
		JLabel lblCambioDeImpulsor = new JLabel("Cambio de impulsor");
		lblCambioDeImpulsor.setForeground(new Color(0, 102, 255));
		lblCambioDeImpulsor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblCambioDeImpulsor, "4, 18, left, default");
		
		JFormattedTextField dateA5 = new JFormattedTextField();
		getContentPane().add(dateA5, "6, 18, fill, default");
		
		JFormattedTextField dateB5 = new JFormattedTextField();
		getContentPane().add(dateB5, "8, 18, fill, default");
		
		JLabel range5 = new JLabel("");
		range5.setForeground(new Color(0, 102, 255));
		range5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(range5, "10, 18");
		
		JLabel lblTableroDeControl = new JLabel("TABLERO DE CONTROL");
		lblTableroDeControl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTableroDeControl.setForeground(new Color(0, 102, 255));
		getContentPane().add(lblTableroDeControl, "2, 20");
		
		JLabel lblCambioDeBobinas = new JLabel("Cambio de bobinas del sistema eléctrico");
		lblCambioDeBobinas.setForeground(new Color(0, 102, 255));
		lblCambioDeBobinas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblCambioDeBobinas, "4, 20, left, default");
		
		JFormattedTextField dateA6 = new JFormattedTextField();
		getContentPane().add(dateA6, "6, 20, fill, default");
		
		JFormattedTextField dateB6 = new JFormattedTextField();
		getContentPane().add(dateB6, "8, 20, fill, default");
		
		JLabel range6 = new JLabel("");
		range6.setForeground(new Color(0, 102, 255));
		range6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(range6, "10, 20");

		InstallFormater(dateA1);
		InstallFormater(dateA2);
		InstallFormater(dateA3);
		InstallFormater(dateA4);
		InstallFormater(dateA5);
		InstallFormater(dateA6);
		InstallFormater(dateB1);
		InstallFormater(dateB2);
		InstallFormater(dateB3);
		InstallFormater(dateB4);
		InstallFormater(dateB5);
		InstallFormater(dateB6);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setIcon(new ImageIcon(CorrectiveMantenance.class.getResource("/img/puerta-cerrada.png")));
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCerrar.setBackground(new Color(0, 102, 255));
		getContentPane().add(btnCerrar, "2, 24, fill, fill");
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setIcon(new ImageIcon(CorrectiveMantenance.class.getResource("/img/add.png")));
		btnNewButton.setBackground(new Color(0, 102, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(Color.WHITE);
		getContentPane().add(btnNewButton, "10, 24, fill, fill");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CorrectiveMantenanceActor  CM = new CorrectiveMantenanceActor();
				CM.setC_cambio_aceite1(dateA1.getText());
				CM.setC_cambio_aceite2(dateB1.getText());
				CM.setC_cambio_correa1(dateA2.getText());
				CM.setC_cambio_correa2(dateB2.getText());
				CM.setB_cambio_sellos1(dateA3.getText());
				CM.setB_cambio_sellos2(dateB3.getText());
				CM.setB_cambio_rodamientos1(dateA4.getText());
				CM.setB_cambio_rodamientos2(dateB4.getText());
				CM.setB_cambio_impulsor1(dateA5.getText());
				CM.setB_cambio_impulsor2(dateB5.getText());
				CM.setT_cambio_bobina1(dateA6.getText());
				CM.setT_cambio_bobina2(dateB6.getText());
				
				if(areValidDates) {
					Corrective.save(CM);
					CorrectiveMantenanceList.fillList();
				}else {
					JOptionPane.showMessageDialog(getContentPane(), "Debe suministrar fechas validas", "advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		dateA1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				range1.setText(calculateRange(dateA1.getText(), dateB1.getText()));
			}
		});
		dateB1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				range1.setText(calculateRange(dateA1.getText(), dateB1.getText()));
			}
		});
		dateA2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				range2.setText(calculateRange(dateA2.getText(), dateB2.getText()));
			}
		});
		dateB2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				range2.setText(calculateRange(dateA2.getText(), dateB2.getText()));
			}
		});
		dateA3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				range3.setText(calculateRange(dateA3.getText(), dateB3.getText()));
			}
		});
		dateB3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				range3.setText(calculateRange(dateA3.getText(), dateB3.getText()));
			}
		});
		
		dateA4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				range4.setText(calculateRange(dateA4.getText(), dateB4.getText()));
			}
		});
		dateB4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				range4.setText(calculateRange(dateA4.getText(), dateB4.getText()));
			}
		});
		
		dateA5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				range5.setText(calculateRange(dateA5.getText(), dateB5.getText()));
			}
		});
		dateB5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				range5.setText(calculateRange(dateA5.getText(), dateB5.getText()));
			}
		});
		
		dateA6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				range6.setText(calculateRange(dateA6.getText(), dateB6.getText()));
			}
		});
		dateB6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				range6.setText(calculateRange(dateA6.getText(), dateB6.getText()));
			}
		});
		
		
	}
	
	private void InstallFormater(JFormattedTextField text) {
		
		 try {
	            MaskFormatter dateMask = new MaskFormatter("##/##/####");
	            dateMask.install(text);
	        } catch (ParseException ex) {
	            ex.printStackTrace();
	        }	
		
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
		    return  daysDiff + " dias de diferencia";
		}catch(Exception e){
		   // e.printStackTrace();
			areValidDates = false;
		    return "Fecha invalida";
		}
		
		

	}
	
	
}
