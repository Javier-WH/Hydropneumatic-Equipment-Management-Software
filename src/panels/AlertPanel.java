package panels;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import actors.Alert;
import maintenanceSheet.Sheet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class AlertPanel extends JPanel {


	public AlertPanel(Alert alert) {
		setForeground(new Color(153, 0, 0));
		setLayout(null);
		
		setMinimumSize(new Dimension(1000, 125));
		JPanel panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Sheet sheet = new Sheet(alert);
				sheet.setLocationRelativeTo(null);
				sheet.setVisible(true);
				
			}
		});
		panel.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 754, 124);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblPicture = new JLabel("");
		lblPicture.setBorder(null);
		lblPicture.setBounds(10, 11, 90, 100);
		panel.add(lblPicture);
		
		JLabel lblAlert = new JLabel("Validar el funcionamiento de la bomba");
		lblAlert.setBackground(new Color(0, 102, 255));
		lblAlert.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblAlert.setForeground(new Color(0, 102, 255));
		lblAlert.setBounds(126, 0, 512, 54);
		panel.add(lblAlert);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(0, 102, 255));
		lblNombre.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblNombre.setBounds(122, 65, 52, 26);
		panel.add(lblNombre);
		
		JLabel lblName = new JLabel("Bomba 1");
		lblName.setForeground(new Color(0, 102, 255));
		lblName.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblName.setBounds(126, 85, 152, 26);
		panel.add(lblName);
		
		JLabel lblCdigo = new JLabel("Código");
		lblCdigo.setForeground(new Color(0, 102, 255));
		lblCdigo.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblCdigo.setBounds(307, 65, 52, 26);
		panel.add(lblCdigo);
		
		JLabel lblCode = new JLabel("h415456");
		lblCode.setForeground(new Color(0, 102, 255));
		lblCode.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		lblCode.setBounds(307, 85, 152, 26);
		panel.add(lblCode);

		lblAlert.setText(alert.getAlertName());
		lblName.setText(alert.getName());
		lblCode.setText(alert.getCode());
		
		
		ImageIcon placeHolderIcon = new ImageIcon(new ImageIcon(alert.getPictureAddress()).getImage().getScaledInstance(lblPicture.getWidth(), lblPicture.getHeight(), Image.SCALE_SMOOTH));
		lblPicture.setIcon(placeHolderIcon);
		
		JLabel lblBackGround = new JLabel("");
		lblBackGround.setBorder(new LineBorder(new Color(0, 102, 255)));
		lblBackGround.setBounds(0, 0, 754, 124);
		ImageIcon backGroundIcon = new ImageIcon(new ImageIcon("src/img/alertBackground.png").getImage().getScaledInstance(lblBackGround.getWidth(), lblBackGround.getHeight(), Image.SCALE_SMOOTH));
		lblBackGround.setIcon(backGroundIcon);
		panel.add(lblBackGround);
		
		
		
		
		
	}
}
