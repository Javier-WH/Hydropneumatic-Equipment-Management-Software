package panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import actors.WaterPump;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PumpPanel extends JPanel {

	private String defaultPictureAddress = "src/img/WaterPumpPlaceHolder.png";

	public PumpPanel(WaterPump waterPump) {
		setBackground(new Color(255, 255, 255));
		setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 102, 255)));
		setLayout(null);
		setMaximumSize(new Dimension(700, 120));
		setMinimumSize(new Dimension(700,120));
		JLabel lblPicture = new JLabel("");
		lblPicture.setBorder(new LineBorder(new Color(0, 102, 204)));
		lblPicture.setBounds(10, 11, 96, 92);
		add(lblPicture);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setForeground(new Color(0, 102, 204));
		lblNewLabel_1.setBounds(132, 11, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("Bomba 1");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setForeground(new Color(0, 102, 204));
		lblName.setBounds(132, 29, 188, 14);
		add(lblName);
		
		JLabel lblCode = new JLabel("3432-j");
		lblCode.setForeground(new Color(0, 102, 204));
		lblCode.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCode.setBounds(132, 71, 188, 14);
		add(lblCode);
		
		JLabel lblNewLabel_1_2 = new JLabel("Código");
		lblNewLabel_1_2.setForeground(new Color(0, 102, 204));
		lblNewLabel_1_2.setBounds(132, 53, 46, 14);
		add(lblNewLabel_1_2);
		
		JLabel lblMark = new JLabel("KSB");
		lblMark.setForeground(new Color(0, 102, 204));
		lblMark.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMark.setBounds(330, 29, 188, 14);
		add(lblMark);
		
		JLabel lblNewLabel_1_3 = new JLabel("Marca");
		lblNewLabel_1_3.setForeground(new Color(0, 102, 204));
		lblNewLabel_1_3.setBounds(330, 11, 46, 14);
		add(lblNewLabel_1_3);
		
		JLabel lblModel = new JLabel("HYDROBLOC C 3000NT");
		lblModel.setForeground(new Color(0, 102, 204));
		lblModel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblModel.setBounds(330, 72, 188, 14);
		add(lblModel);
		
		JLabel lblNewLabel_1_4 = new JLabel("Modelo");
		lblNewLabel_1_4.setForeground(new Color(0, 102, 204));
		lblNewLabel_1_4.setBounds(330, 54, 46, 14);
		add(lblNewLabel_1_4);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(waterPump.getId());
				
			}
		});
		btnNewButton.setBackground(new Color(0, 102, 204));
		btnNewButton.setIcon(new ImageIcon(PumpPanel.class.getResource("/img/search.png")));
		btnNewButton.setForeground(new Color(0, 102, 204));
		btnNewButton.setBounds(539, 19, 89, 81);
		add(btnNewButton);

		/////////////////////////
		
		lblName.setText(waterPump.getName());
		lblMark.setText(waterPump.getMark());
		lblCode.setText(waterPump.getCode());
		lblModel.setText(waterPump.getModel());
		
		//si la imagen es null coloca el placeholder
		String picAddress = waterPump.getPictureAddress() == null ? defaultPictureAddress : waterPump.getPictureAddress();
		ImageIcon placeHolderIcon = new ImageIcon(new ImageIcon(picAddress).getImage().getScaledInstance(lblPicture.getWidth(), lblPicture.getHeight(), Image.SCALE_SMOOTH));
		lblPicture.setIcon(placeHolderIcon);
		
		
		
	}
}
