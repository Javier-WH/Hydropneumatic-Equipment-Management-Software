package frames;
import javax.swing.JDialog;
import java.awt.Toolkit;
import java.util.ArrayList;

import net.miginfocom.swing.MigLayout;
import sql.ConfigManager;

import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




@SuppressWarnings("serial")
public class ConfigFrame extends JDialog {

	private String daily = "";
	private String weekly = "";
	private String monthly = "";

	public ConfigFrame() {
		setResizable(false);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigFrame.class.getResource("/img/icono.png")));
		setTitle("Configuración");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(322, 254);
		getContentPane().setLayout(new MigLayout("", "[][][]", "[][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Configuración");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 102, 255));
		getContentPane().add(lblNewLabel, "cell 0 0 3 1");
		
		JCheckBox chkDaily = new JCheckBox("Mostrar Alertas Diarias");
		chkDaily.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkDaily.isSelected()) {
					daily = "1";					
				}else {
					daily = "0";
				}
				saveConfig();
			}
		});
		chkDaily.setSelected(true);
		chkDaily.setFont(new Font("Vrinda", Font.PLAIN, 18));
		chkDaily.setForeground(new Color(0, 102, 255));
		getContentPane().add(chkDaily, "cell 2 2");
		
		JCheckBox chkWeekly = new JCheckBox("Mostrar Alertas Semanales");
		chkWeekly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkWeekly.isSelected()) {
					weekly = "1";					
				}else {
					weekly = "0";
				}
				saveConfig();
			}
		});
		chkWeekly.setSelected(true);
		chkWeekly.setForeground(new Color(0, 102, 255));
		chkWeekly.setFont(new Font("Vrinda", Font.PLAIN, 18));
		getContentPane().add(chkWeekly, "cell 2 3,alignx center,aligny baseline");
		
		JCheckBox chkMonthly = new JCheckBox("Mostrar Alertas Mensuales");
		chkMonthly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkMonthly.isSelected()) {
					monthly = "1";					
				}else {
					monthly = "0";
				}
				saveConfig();
			}
		});
		chkMonthly.setSelected(true);
		chkMonthly.setForeground(new Color(0, 102, 255));
		chkMonthly.setFont(new Font("Vrinda", Font.PLAIN, 18));
		getContentPane().add(chkMonthly, "cell 2 4");
		
		ArrayList<String> config = ConfigManager.getConfig();
		
		chkDaily.setSelected(config.get(0).equals("1") ? true : false);
		chkWeekly.setSelected(config.get(1).equals("1") ? true : false);
		chkMonthly.setSelected(config.get(2).equals("1") ? true : false);
		
		daily = config.get(0);
		weekly = config.get(1);
		monthly = config.get(2);
	}
	
	

	private void saveConfig() {
		ConfigManager.setConfig(daily, weekly, monthly);
		MainFrame.loadAlerts();
	}


	
	




}
