package frames;
import javax.swing.BoxLayout;
import javax.swing.JDialog;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;

import actors.User;
import panels.RegisterPanel;
import sql.GetRegisteredUser;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Container;




@SuppressWarnings("serial")
public class RegisterList extends JDialog {
private static JPanel ListPanel = new JPanel();
@SuppressWarnings("rawtypes")
private static JComboBox comboBox = new JComboBox();
private static int counter = 0;
private static JLabel lblCounter = new JLabel("New label");
private static Container panel = null;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RegisterList() {
		setResizable(false);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegisterList.class.getResource("/img/icono.png")));
		setTitle("Lista de Equipos");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(800, 744);
		getContentPane().setLayout(null);
		panel = getContentPane();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 764, 541);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(ListPanel);
		
		ListPanel.setLayout(new BoxLayout(ListPanel, BoxLayout.PAGE_AXIS));
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(new Color(0, 102, 255));
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillListPanel();
			}
		});
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Diarios", "Semanales", "Mensuales"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(44, 11, 243, 22);
		getContentPane().add(comboBox);
		

		lblCounter.setForeground(new Color(0, 102, 255));
		lblCounter.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCounter.setBounds(543, 45, 204, 14);
		getContentPane().add(lblCounter);
		
		

		
		
	}
	
	
	
	public static void fillListPanel() {
		
		ListPanel.removeAll();
		ListPanel.revalidate();
		ListPanel.repaint();
		counter = 0;
		
		
		ResultSet rs = null;
		
	
		rs = GetRegisteredUser.getRegister(comboBox.getSelectedIndex());	
		
		
		try {
			while(rs.next()) {
				String register = rs.getString("register");
				User user = new User();
				user.setMantenanceBoss(rs.getString("mantenance_boss"));
				user.setOperator(rs.getString("operator"));
				user.setControlNumber(rs.getString("control_number"));
				user.setEquipament(rs.getString("equioament"));
				user.setType(rs.getString("type"));
			
				ListPanel.add(new RegisterPanel(register, user, panel));
				counter++;
				ListPanel.setPreferredSize(new Dimension(600, counter*120));
			}
			lblCounter.setText(counter + " registros");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
