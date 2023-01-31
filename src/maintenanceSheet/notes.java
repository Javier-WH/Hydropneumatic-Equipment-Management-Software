package maintenanceSheet;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class notes extends JPanel {


	public notes() {
		setPreferredSize(new Dimension(592, 208));
		setBackground(Color.WHITE);
		setLayout(new MigLayout("", "[579.00px,grow][][][][][][][]", "[5.00][37.00px][134.00px,grow][-19.00px][-29.00px][-29.00px][-16.00px][0.00px][-2.00px]"));
		
		JLabel lblNewLabel = new JLabel("    Observaciones");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 102, 255));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblNewLabel, "flowx,cell 0 1,grow");
		
		JTextPane textPane = new JTextPane();
		textPane.setForeground(new Color(0, 102, 255));
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textPane.setCaretColor(new Color(0, 102, 255));
		textPane.setBorder(new LineBorder(new Color(0, 102, 255)));
		add(textPane, "cell 0 2,grow");

	}

}
