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

public class DailyPulmon extends JPanel {
	private JTextField textCode;


	public DailyPulmon() {
		setPreferredSize(new Dimension(600, 208));
		setBackground(Color.WHITE);
		setLayout(new MigLayout("", "[439.00px][][grow][][][][][]", "[5.00][37.00px][29.00px][29.00px][29.00px][29.00px][21.00][-16.00px][0.00px][-2.00px]"));
		
		JLabel lblNewLabel = new JLabel("  PULMÓN HIDRONEUMÁTICO ");
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
		
		JLabel lbl1 = new JLabel("Verificar el nivel del agua");
		lbl1.setForeground(new Color(0, 102, 255));
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lbl1, "cell 0 2,grow");
		
		JCheckBox chckbx1 = new JCheckBox("");
		chckbx1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chckbx1.isSelected()) {
					Sheet.setDailyPulmonVNA(new GetFormatedDate().getDate());
				}else {
					Sheet.setDailyPulmonVNA("");
				}
				
				
			}
		});
		chckbx1.setBackground(Color.WHITE);
		add(chckbx1, "cell 2 2");
		
		JLabel lbl2 = new JLabel("Verificar funcionamiento del manómetro");
		lbl2.setForeground(new Color(0, 102, 255));
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lbl2, "cell 0 3,grow");
		
		JCheckBox chckbx2 = new JCheckBox("");
		chckbx2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx2.isSelected()) {
					Sheet.setDailyPulmonVFM(new GetFormatedDate().getDate());
				}else {
					Sheet.setDailyPulmonVFM("");
				}
			}
		});
		chckbx2.setBackground(Color.WHITE);
		add(chckbx2, "cell 2 3");
		
		JLabel lbl3 = new JLabel("Medición de presión baja cuando activa la bomba");
		lbl3.setForeground(new Color(0, 102, 255));
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lbl3, "cell 0 4,grow");
		
		JCheckBox chckbx3 = new JCheckBox("");
		chckbx3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx3.isSelected()) {
					Sheet.setDailyPulmonMPBCAB(new GetFormatedDate().getDate());
				}else {
					Sheet.setDailyPulmonMPBCAB("");
				}
			}
		});
		chckbx3.setBackground(Color.WHITE);
		add(chckbx3, "cell 2 4");
		
		JLabel lbl4 = new JLabel("Medición de presión alta cuando apaga la bomba");
		lbl4.setForeground(new Color(0, 102, 255));
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lbl4, "cell 0 5");
		
		JCheckBox chckbx4 = new JCheckBox("");
		chckbx4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chckbx4.isSelected()) {
					Sheet.setDailyPulmonMPACAB(new GetFormatedDate().getDate());
				}else {
					Sheet.setDailyPulmonMPACAB("");
				}
				
				
			}
		});
		chckbx4.setBackground(Color.WHITE);
		add(chckbx4, "cell 2 5");
		
		JLabel lblCode = new JLabel("Codigo:");
		lblCode.setForeground(new Color(0, 102, 255));
		add(lblCode, "cell 0 6,alignx right");
		
		textCode = new JTextField();
		textCode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Sheet.setDailyPulmonCode(textCode.getText());
			}
		});
		textCode.setColumns(10);
		add(textCode, "cell 2 6 6 1,growx");

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
				lbl1.setEnabled(chckbxHabilitar.isSelected());
				lbl2.setEnabled(chckbxHabilitar.isSelected());
				lbl3.setEnabled(chckbxHabilitar.isSelected());
				lbl4.setEnabled(chckbxHabilitar.isSelected());
				Sheet.setEnablePulmon(chckbxHabilitar.isSelected());
				
				lblCode.setEnabled(chckbxHabilitar.isSelected());
				textCode.setText("");
				textCode.setEnabled(chckbxHabilitar.isSelected());
				
			}
		});
	}

}
