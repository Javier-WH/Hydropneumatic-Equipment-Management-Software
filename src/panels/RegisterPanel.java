package panels;

import javax.swing.JPanel;

import actors.User;
import frames.ReportDaily;
import frames.ReportMonthly;
import frames.ReportWeekly;

import javax.swing.JLabel;

import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class RegisterPanel extends JPanel {


	public RegisterPanel(String register, User user, Container panel) {
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(173, 11, 58, 14);
		add(lblNewLabel);
		setMaximumSize(new Dimension(1500,120));
		
		JLabel lblRegistro = new JLabel("65564");
		lblRegistro.setForeground(Color.WHITE);
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegistro.setBounds(263, 11, 504, 14);
		add(lblRegistro);
		
		JLabel lblFrecuencia1 = new JLabel("Frecuencia:");
		lblFrecuencia1.setForeground(Color.WHITE);
		lblFrecuencia1.setBounds(173, 36, 68, 14);
		add(lblFrecuencia1);
		
		JLabel lblFrecuencia = new JLabel("Diario");
		lblFrecuencia.setForeground(Color.WHITE);
		lblFrecuencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFrecuencia.setBounds(267, 36, 554, 14);
		add(lblFrecuencia);
		
		JLabel lblOperador = new JLabel("Operador:");
		lblOperador.setForeground(Color.WHITE);
		lblOperador.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOperador.setBounds(263, 61, 554, 14);
		add(lblOperador);
		
		JLabel lblRegistro_1_1 = new JLabel("Operador:");
		lblRegistro_1_1.setForeground(Color.WHITE);
		lblRegistro_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRegistro_1_1.setBounds(173, 61, 68, 14);
		add(lblRegistro_1_1);
		
		JLabel lblRegistro_1_2 = new JLabel("Equipos:");
		lblRegistro_1_2.setForeground(Color.WHITE);
		lblRegistro_1_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRegistro_1_2.setBounds(173, 86, 52, 14);
		add(lblRegistro_1_2);
		
		JLabel lblEquipos = new JLabel("Equipos:");
		lblEquipos.setForeground(Color.WHITE);
		lblEquipos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEquipos.setBounds(263, 86, 554, 14);
		add(lblEquipos);
		JLabel lblBackGround = new JLabel("");
		lblBackGround.setBounds(0, 0, 840, 120);
		ImageIcon backgroundIcon = new ImageIcon(new ImageIcon("src/img/register.png").getImage().getScaledInstance(lblBackGround.getWidth(), lblBackGround.getHeight(), Image.SCALE_SMOOTH));
		lblBackGround.setIcon(backgroundIcon);
		add(lblBackGround);	
		lblRegistro.setText(register);
		lblOperador.setText(user.getOperator());
		lblEquipos.setText(user.getEquipament());
		
		switch (Integer.parseInt(user.getType())) {
			case 1:
				lblFrecuencia.setText("Diario");
			break;
			case 2:
				lblFrecuencia.setText("Semanal");
			break;
			case 3:
				lblFrecuencia.setText("Mensual");
			break;
			default:
			break;
		}
		
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(user.getType().equals("1")) {					
					ReportDaily RD = new ReportDaily(register,user);
					RD.setLocationRelativeTo(panel);
					RD.setVisible(true);
				}else if(user.getType().equals("2")) {
					ReportWeekly RW = new ReportWeekly(register,user);
					RW.setLocationRelativeTo(panel);
					RW.setVisible(true);
				}else if(user.getType().equals("3")) {
					ReportMonthly RM = new ReportMonthly(register, user);
					RM.setLocationRelativeTo(panel);
					RM.setVisible(true);
					
				}
				
			}
		});
		
		
		
		
		
	}
}
