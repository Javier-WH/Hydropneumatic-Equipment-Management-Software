package maintenanceSheet;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;

import auxiliar.GetFormatedDate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DailyBomb extends JPanel {
	private JTextField textCode;


	public DailyBomb() {
		setPreferredSize(new Dimension(600, 328));
		setBackground(Color.WHITE);
		setLayout(new MigLayout("", "[439.00px][][grow][][][][][]", "[5.00][37.00px][29.00px][29.00px][29.00px][29.00px][29.00px][29.00px][29.00px][]"));
		
		JLabel lblNewLabel = new JLabel("   BOMBA MONOBLOC");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 102, 255));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblNewLabel, "flowx,cell 0 1 7 1,grow");
		
		JCheckBox chckbxHabilitar = new JCheckBox("Habilitar");
	
		chckbxHabilitar.setBackground(new Color(0, 102, 255));
		chckbxHabilitar.setSelected(true);
		chckbxHabilitar.setForeground(Color.WHITE);
		add(chckbxHabilitar, "cell 7 1,grow");
		
		JLabel lbl1 = new JLabel("Validar el funcionamiento de la bomba");
		lbl1.setForeground(new Color(0, 102, 255));
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lbl1, "cell 0 2,grow");
		
		JCheckBox chckbx1 = new JCheckBox("");
		chckbx1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx1.isSelected()) {
					Sheet.setDailyBombVFB(new GetFormatedDate().getDate());
				}else {
					Sheet.setDailyBombVFB("");
				}
			}
		});
		chckbx1.setBackground(Color.WHITE);
		add(chckbx1, "cell 2 2");
		
		JLabel lbl2 = new JLabel("Inspección auditiva para determinar ruidos extraños");
		lbl2.setForeground(new Color(0, 102, 255));
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lbl2, "cell 0 3,grow");
		
		JCheckBox chckbx2 = new JCheckBox("");
		chckbx2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx2.isSelected()) {
					Sheet.setDailyBombIADRE(new GetFormatedDate().getDate());
				}else {
					Sheet.setDailyBombIADRE("");
				}
			}
		});
		chckbx2.setBackground(Color.WHITE);
		add(chckbx2, "cell 2 3");
		
		JLabel lbl3 = new JLabel("Inspección visual del manómetro de presión al activarse la bomba");
		lbl3.setForeground(new Color(0, 102, 255));
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lbl3, "cell 0 4,grow");
		
		JCheckBox chckbx3 = new JCheckBox("");
		chckbx3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx3.isSelected()) {
					Sheet.setDailyBombIVMPAB(new GetFormatedDate().getDate());
				}else {
					Sheet.setDailyBombIVMPAB("");
				}
			}
		});
		chckbx3.setBackground(Color.WHITE);
		add(chckbx3, "cell 2 4");
		
		JLabel lbl4 = new JLabel("Inspección táctil para determinar vibraciones excesivas");
		lbl4.setForeground(new Color(0, 102, 255));
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lbl4, "cell 0 5");
		
		JCheckBox chckbx4 = new JCheckBox("");
		chckbx4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chckbx4.isSelected()) {
					Sheet.setDailyBombITDVE(new GetFormatedDate().getDate());
				}else {
					Sheet.setDailyBombITDVE("");
				}
				
			}
		});
		chckbx4.setBackground(Color.WHITE);
		add(chckbx4, "cell 2 5");
		
		JLabel lbl5 = new JLabel("Inspección visual para detectar fugas en las tuberías de agua");
		lbl5.setForeground(new Color(0, 102, 255));
		lbl5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lbl5, "cell 0 6");
		
		JCheckBox chckbx5 = new JCheckBox("");
		chckbx5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chckbx5.isSelected()) {
					Sheet.setDailyBombIVDFTA(new GetFormatedDate().getDate());
				}else {
					Sheet.setDailyBombIVDFTA("");
				}
			}
		});
		chckbx5.setBackground(Color.WHITE);
		add(chckbx5, "cell 2 6");
		
		JLabel lbl6 = new JLabel("Medición consumo eléctrico del motor");
		lbl6.setForeground(new Color(0, 102, 255));
		lbl6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lbl6, "cell 0 7");
		
		JCheckBox chckbx6 = new JCheckBox("");
		chckbx6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx6.isSelected()) {
					Sheet.setDailyBombMCEM(new GetFormatedDate().getDate());
				}else {
					Sheet.setDailyBombMCEM("");
				}
				
				
			}
		});
		chckbx6.setBackground(Color.WHITE);
		add(chckbx6, "cell 2 7");
		
		JLabel lbl7 = new JLabel("Inspección de tuberia de succion para verificar que no haya pérdida de ceba");
		lbl7.setForeground(new Color(0, 102, 255));
		lbl7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lbl7, "cell 0 8");
		
		JCheckBox chckbx7 = new JCheckBox("");
		chckbx7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chckbx7.isSelected()) {
					Sheet.setDailyBombITDVPC(new GetFormatedDate().getDate());
				}else {
					Sheet.setDailyBombITDVPC("");
				}
				
			}
		});
		chckbx7.setBackground(Color.WHITE);
		add(chckbx7, "cell 2 8");
		
		JLabel lblcode = new JLabel("Codigo:");
		lblcode.setForeground(new Color(0, 102, 255));
		add(lblcode, "cell 0 9,alignx right");
		
		textCode = new JTextField();
		textCode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Sheet.setDailyBombICode(textCode.getText());
			}
		});
		add(textCode, "cell 2 9 6 1,growx");
		textCode.setColumns(10);
		
		
		chckbxHabilitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					chckbx1.setSelected(false);
					chckbx1.setEnabled(chckbxHabilitar.isSelected());
					chckbx2.setSelected(false);
					chckbx2.setEnabled(chckbxHabilitar.isSelected());
					chckbx3.setSelected(false);
					chckbx3.setEnabled(chckbxHabilitar.isSelected());
					chckbx4.setSelected(false);
					chckbx4.setEnabled(chckbxHabilitar.isSelected());
					chckbx5.setSelected(false);
					chckbx5.setEnabled(chckbxHabilitar.isSelected());
					chckbx6.setSelected(false);
					chckbx6.setEnabled(chckbxHabilitar.isSelected());
					chckbx7.setSelected(false);
					chckbx7.setEnabled(chckbxHabilitar.isSelected());
					lbl1.setEnabled(chckbxHabilitar.isSelected());
					lbl2.setEnabled(chckbxHabilitar.isSelected());
					lbl3.setEnabled(chckbxHabilitar.isSelected());
					lbl4.setEnabled(chckbxHabilitar.isSelected());
					lbl5.setEnabled(chckbxHabilitar.isSelected());
					lbl6.setEnabled(chckbxHabilitar.isSelected());
					lbl7.setEnabled(chckbxHabilitar.isSelected());
					lblcode.setEnabled(chckbxHabilitar.isSelected());
					textCode.setText("");
					textCode.setEnabled(chckbxHabilitar.isSelected());
					Sheet.setEnableBomb(chckbxHabilitar.isSelected());
			}
		});

	}
	

}
