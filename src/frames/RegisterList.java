package frames;
import javax.swing.BoxLayout;
import javax.swing.JDialog;

import java.awt.Dimension;
import java.awt.Toolkit;



import javax.swing.JScrollPane;

import panels.RegisterPanel;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;




@SuppressWarnings("serial")
public class RegisterList extends JDialog {
private static JPanel ListPanel = new JPanel();

	public RegisterList() {
		setResizable(false);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegisterList.class.getResource("/img/icono.png")));
		setTitle("Lista de Equipos");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(800, 744);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 764, 541);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(ListPanel);
		
		ListPanel.setLayout(new BoxLayout(ListPanel, BoxLayout.PAGE_AXIS));
		
		ListPanel.setPreferredSize(new Dimension(600, 60000));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Diarios", "Semanales", "Mensuales"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(44, 11, 243, 22);
		getContentPane().add(comboBox);
		
		fillListPanel();
		
		
	}
	
	
	
	public static void fillListPanel() {
		ListPanel.add(new RegisterPanel());
	}
}
