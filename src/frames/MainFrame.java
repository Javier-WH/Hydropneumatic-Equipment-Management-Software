package frames;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JLabel;




@SuppressWarnings("serial")
public class MainFrame extends JFrame {


	public MainFrame() {
		setTitle("Hydropneumatic Equipment Management Software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(800, 600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(SystemColor.menu);
		getContentPane().add(panelMenu, BorderLayout.WEST);
		panelMenu.setLayout(new MigLayout("", "[236.00]", "[][][][][][][][]"));
		
		JButton btnNewButton = new JButton("Registrar Equipo");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 16));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(MainFrame.class.getResource("/img/add.png")));
		btnNewButton.setBackground(new Color(0, 102, 204));
		panelMenu.add(btnNewButton, "cell 0 0,growx");
		
		JButton btnNewButton_1 = new JButton("Mantenimiento");
		btnNewButton_1.setIcon(new ImageIcon(MainFrame.class.getResource("/img/wrench.png")));
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(0, 102, 204));
		panelMenu.add(btnNewButton_1, "cell 0 1,growx");
		
		JButton btnNewButton_1_1 = new JButton("Equipos registrados");
		btnNewButton_1_1.setIcon(new ImageIcon(MainFrame.class.getResource("/img/list.png")));
		btnNewButton_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Verdana", Font.BOLD, 16));
		btnNewButton_1_1.setBackground(new Color(0, 102, 204));
		panelMenu.add(btnNewButton_1_1, "cell 0 2,grow");
		
		JButton btnNewButton_1_1_2 = new JButton("Cronograma");
		btnNewButton_1_1_2.setIcon(new ImageIcon(MainFrame.class.getResource("/img/calendar.png")));
		btnNewButton_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1_2.setForeground(Color.WHITE);
		btnNewButton_1_1_2.setFont(new Font("Verdana", Font.BOLD, 16));
		btnNewButton_1_1_2.setBackground(new Color(0, 102, 204));
		panelMenu.add(btnNewButton_1_1_2, "cell 0 3,grow");
		
		JButton btnNewButton_1_1_1_1 = new JButton("Configuración");
		btnNewButton_1_1_1_1.setIcon(new ImageIcon(MainFrame.class.getResource("/img/options.png")));
		btnNewButton_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 16));
		btnNewButton_1_1_1_1.setBackground(new Color(0, 102, 204));
		panelMenu.add(btnNewButton_1_1_1_1, "cell 0 4,grow");
		
		JButton btnNewButton_1_1_1_2 = new JButton("Reportes");
		btnNewButton_1_1_1_2.setIcon(new ImageIcon(MainFrame.class.getResource("/img/reports.png")));
		btnNewButton_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1_1_2.setForeground(Color.WHITE);
		btnNewButton_1_1_1_2.setFont(new Font("Verdana", Font.BOLD, 16));
		btnNewButton_1_1_1_2.setBackground(new Color(0, 102, 204));
		panelMenu.add(btnNewButton_1_1_1_2, "cell 0 5,grow");
		
		JButton btnNewButton_1_1_1 = new JButton("Salir");
		btnNewButton_1_1_1.setIcon(new ImageIcon(MainFrame.class.getResource("/img/exit.png")));
		btnNewButton_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setFont(new Font("Verdana", Font.BOLD, 16));
		btnNewButton_1_1_1.setBackground(new Color(0, 102, 204));
		panelMenu.add(btnNewButton_1_1_1, "cell 0 6,grow");
		
		JPanel panelWarning = new JPanel();
		panelWarning.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panelWarning, BorderLayout.CENTER);
		
		JPanel panelMessage = new JPanel();
		panelMessage.setBackground(SystemColor.menu);
		getContentPane().add(panelMessage, BorderLayout.NORTH);
		panelMessage.setLayout(new MigLayout("", "[119.00px][381.00]", "[41.00px]"));
		
		JPanel panelEstado = new JPanel();
		panelEstado.setBackground(SystemColor.menu);
		getContentPane().add(panelEstado, BorderLayout.SOUTH);
		panelEstado.setLayout(new MigLayout("", "[]", "[42.00]"));
	}
}
