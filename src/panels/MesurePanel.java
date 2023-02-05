package panels;

import javax.swing.JPanel;

import actors.Mesure;
import frames.Cualitative;
import frames.Cuantitative;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class MesurePanel extends JPanel {


	public MesurePanel(Mesure mesure, Container panel) {
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(mesure.getMesureType().equals("1")) {
					Cuantitative c = new Cuantitative(mesure.getId());
					c.setLocationRelativeTo(panel);
					c.setVisible(true);					
				}else if(mesure.getMesureType().equals("2")) {
					
					Cualitative c =  new Cualitative(mesure.getId());
					c.setLocationRelativeTo(panel);
					c.setVisible(true);	
					
				}
				
			}
		});
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fecha:");
		lblNewLabel.setBounds(169, 44, 46, 14);
		add(lblNewLabel);
		
		JLabel lblDate = new JLabel("Fecha:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDate.setBounds(169, 48, 616, 46);
		add(lblDate);
		
		JLabel lblBackGround = new JLabel("");
		lblBackGround.setBounds(0, 0, 840, 116);
		add(lblBackGround);
		
		lblBackGround.setBounds(0, 0, 840, 120);
		ImageIcon backgroundIcon = new ImageIcon(new ImageIcon("src/img/register.png").getImage().getScaledInstance(lblBackGround.getWidth(), lblBackGround.getHeight(), Image.SCALE_SMOOTH));
		lblBackGround.setIcon(backgroundIcon);
		
		lblDate.setText(mesure.getDate());
		
		
	}
}
