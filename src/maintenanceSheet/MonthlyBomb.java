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

public class MonthlyBomb extends JPanel {
	private static JTextField textCode = new JTextField();


	public MonthlyBomb() {
		setPreferredSize(new Dimension(600, 120));
		setBackground(Color.WHITE);
		setLayout(new MigLayout("", "[439.00px][][grow][][][][][]", "[-29.00][76.00px][42.00px][39.00][-10][-4.00px][-10.00px][-75.00px][-84.00px][-62.00px]"));
		
		JLabel lblNewLabel = new JLabel("   BOMBA MONOBLOC");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 102, 255));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblNewLabel, "flowx,cell 0 0 7 2,grow");
		
		JCheckBox chckbxHabilitar = new JCheckBox("Habilitar");
		chckbxHabilitar.setBackground(new Color(0, 102, 255));
		chckbxHabilitar.setSelected(true);
		chckbxHabilitar.setForeground(Color.WHITE);
		add(chckbxHabilitar, "cell 7 0 1 2,grow");
		
		JLabel lbl1 = new JLabel("Ajustar pernos y tornillos de anclaje de la base");
		lbl1.setForeground(new Color(0, 102, 255));
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lbl1, "cell 0 2,grow");
		
		JCheckBox chckbx1 = new JCheckBox("");
		chckbx1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx1.isSelected()) {
					Sheet.setMonthlyBombAPTAB(new GetFormatedDate().getDate());
				}else {
					Sheet.setMonthlyBombAPTAB("");
				}
			}
		});
		chckbx1.setBackground(Color.WHITE);
		add(chckbx1, "cell 2 2");
		
		JLabel lblCode = new JLabel("Codigo:");
		lblCode.setForeground(new Color(0, 102, 255));
		add(lblCode, "cell 0 3,alignx right");
		
	
		textCode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Sheet.setMonthlyBombCode(textCode.getText());
			}
		});
		textCode.setColumns(10);
		add(textCode, "cell 2 3 6 1,growx");

		chckbxHabilitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chckbx1.setSelected(false);
				chckbx1.setEnabled(chckbxHabilitar.isSelected());
				lbl1.setEnabled(chckbxHabilitar.isSelected());
				Sheet.setEnableBomb(chckbxHabilitar.isSelected());
				
				lblCode.setEnabled(chckbxHabilitar.isSelected());
				textCode.setText("");
				textCode.setEnabled(chckbxHabilitar.isSelected());
				Sheet.setMonthlyBombCode("");
			}
		});
	}

	public static void setTextcode(String code) {
		textCode.setText(code);
	}
}
