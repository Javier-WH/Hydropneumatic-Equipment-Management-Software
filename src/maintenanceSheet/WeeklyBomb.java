package maintenanceSheet;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class WeeklyBomb extends JPanel {
	private JTextField textCode;


	public WeeklyBomb() {
		setPreferredSize(new Dimension(600, 148));
		setBackground(Color.WHITE);
		setLayout(new MigLayout("", "[439.00px][][grow][][][][][]", "[5.00][37.00px][29.00px][29.00px][-8.00px][23.00][-2.00px][-4.00px][-22.00px][-12.00px]"));
		
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
		
		JLabel lbl1 = new JLabel("Validar a través del tacto temperatura externa de tubería de succión");
		lbl1.setForeground(new Color(0, 102, 255));
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lbl1, "cell 0 2,grow");
		
		JCheckBox chckbx1 = new JCheckBox("");
		chckbx1.setBackground(Color.WHITE);
		add(chckbx1, "cell 2 2");
		
		JLabel lbl2 = new JLabel("Limpieza para retirar partículas de polvo y agentes contaminantes");
		lbl2.setForeground(new Color(0, 102, 255));
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lbl2, "cell 0 3,grow");
		
		JCheckBox chckbx2 = new JCheckBox("");
		chckbx2.setBackground(Color.WHITE);
		add(chckbx2, "cell 2 3");
		
		JLabel lblCode = new JLabel("Codigo:");
		lblCode.setForeground(new Color(0, 102, 255));
		add(lblCode, "cell 0 5,alignx right");
		
		textCode = new JTextField();
		textCode.setColumns(10);
		add(textCode, "cell 2 5 6 1,growx");

		chckbxHabilitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbx1.setSelected(false);
				chckbx1.setEnabled(chckbxHabilitar.isSelected());
				chckbx2.setSelected(false);
				chckbx2.setEnabled(chckbxHabilitar.isSelected());
				lbl1.setEnabled(chckbxHabilitar.isSelected());
				lbl2.setEnabled(chckbxHabilitar.isSelected());
				Sheet.setEnableBomb(chckbxHabilitar.isSelected());
				lblCode.setEnabled(chckbxHabilitar.isSelected());
				textCode.setText("");
				textCode.setEnabled(chckbxHabilitar.isSelected());
			}
		});
	}

}
