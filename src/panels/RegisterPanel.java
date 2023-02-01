package panels;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class RegisterPanel extends JPanel {


	public RegisterPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro:");
		lblNewLabel.setBounds(173, 11, 58, 14);
		add(lblNewLabel);
		setMaximumSize(new Dimension(1500,120));
		
		JLabel lblRegistro = new JLabel("65564");
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegistro.setBounds(241, 11, 58, 14);
		add(lblRegistro);
		
		JLabel lblFrecuencia = new JLabel("Frecuencia");
		lblFrecuencia.setBounds(173, 36, 58, 14);
		add(lblFrecuencia);
		
		JLabel lblRegistro_1 = new JLabel("Diario");
		lblRegistro_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegistro_1.setBounds(239, 36, 58, 14);
		add(lblRegistro_1);
		
		JLabel lblOperador = new JLabel("Operador:");
		lblOperador.setBounds(173, 61, 58, 14);
		add(lblOperador);
		
		JLabel lblRegistro_1_1 = new JLabel("Juan Perez");
		lblRegistro_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegistro_1_1.setBounds(241, 61, 282, 14);
		add(lblRegistro_1_1);
		
		JLabel lblRegistro_1_2 = new JLabel(" <Bomba Monobloc> <Compresor> <Tablero de control>  <Pulmón Hidroneumático> ");
		lblRegistro_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegistro_1_2.setBounds(241, 86, 548, 14);
		add(lblRegistro_1_2);
		
		JLabel lblEquipos = new JLabel("Equipos:");
		lblEquipos.setBounds(173, 86, 58, 14);
		add(lblEquipos);
		JLabel lblBackGround = new JLabel("");
		lblBackGround.setBounds(0, 0, 840, 120);
		ImageIcon backgroundIcon = new ImageIcon(new ImageIcon("src/img/register.png").getImage().getScaledInstance(lblBackGround.getWidth(), lblBackGround.getHeight(), Image.SCALE_SMOOTH));
		lblBackGround.setIcon(backgroundIcon);
		add(lblBackGround);
		
		
		
		
	}
}
