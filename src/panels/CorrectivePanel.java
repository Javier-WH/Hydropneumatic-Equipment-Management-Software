package panels;

import javax.swing.JPanel;

import actors.CorrectiveMantenanceActor;
import frames.CorrectiveMantenanceReport;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class CorrectivePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CorrectivePanel(CorrectiveMantenanceActor corrective, Container panel) {
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CorrectiveMantenanceReport cm = new CorrectiveMantenanceReport(corrective);
				cm.setLocationRelativeTo(panel);
				cm.setVisible(true);
			}
		});
		setBackground(Color.WHITE);
		setLayout(null);
		
		setMinimumSize(new Dimension(800, 125));
		setMaximumSize(new Dimension(800, 125));
		
		JLabel lblNewLabel = new JLabel("Fecha:");
		lblNewLabel.setBounds(225, 23, 46, 14);
		add(lblNewLabel);
		
		JLabel lblDate = new JLabel("Fecha:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDate.setBounds(225, 49, 182, 20);
		add(lblDate);
		
		JLabel lblBackGround = new JLabel("");
		lblBackGround.setBounds(0, 0, 910, 118);
		add(lblBackGround);
		
		ImageIcon placeHolderIcon = new ImageIcon(new ImageIcon("src/img/register.png").getImage().getScaledInstance(lblBackGround.getWidth(), lblBackGround.getHeight(), Image.SCALE_SMOOTH));
		lblBackGround.setIcon(placeHolderIcon);
		
		lblDate.setText(corrective.getC_cambio_correa1());
		
		
	
	}
}
