package frames;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;




@SuppressWarnings("serial")
public class Selection extends JDialog {
	private RegisterFrame registerPump = new RegisterFrame();
	private RegisterCompresorFrame registerCompresor = new RegisterCompresorFrame();
	private RegisterPulmonFrame registerPulmon = new RegisterPulmonFrame();
	private RegisterControlBoard registerControl = new RegisterControlBoard();

	public Selection() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setResizable(false);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Selection.class.getResource("/img/icono.png")));
		setTitle("Selecciona que desea inscribir");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(762, 306);
		getContentPane().setLayout(null);
		
		JLabel lblBomba = new JLabel("");
		lblBomba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registerPump.setLocationRelativeTo(getContentPane());
				registerPump.setVisible(true);
				setVisible(false);
			}
		});
		lblBomba.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBomba.setBorder(null);
		lblBomba.setBounds(22, 11, 157, 202);
		getContentPane().add(lblBomba);
		
		ImageIcon bombaIcon = new ImageIcon(new ImageIcon("src/img/WaterPumpPlaceHolder.png").getImage()
				.getScaledInstance(lblBomba.getWidth(), lblBomba.getHeight(), Image.SCALE_SMOOTH));
		lblBomba.setIcon(bombaIcon);
		
		
		JLabel lblCompresor = new JLabel("");
		lblCompresor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registerCompresor.setLocationRelativeTo(getContentPane());
				registerCompresor.setVisible(true);
				setVisible(false);
				
			}
		});
		lblCompresor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCompresor.setBorder(null);
		lblCompresor.setBounds(203, 11, 157, 202);
		getContentPane().add(lblCompresor);
		
		ImageIcon compresorIcon = new ImageIcon(new ImageIcon("src/img/compresorPlaceholder.png").getImage()
				.getScaledInstance(lblCompresor.getWidth(), lblCompresor.getHeight(), Image.SCALE_SMOOTH));
		lblCompresor.setIcon(compresorIcon);
		
		
		JLabel lblPulmon = new JLabel("");
		lblPulmon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registerPulmon.setLocationRelativeTo(getContentPane());
				registerPulmon.setVisible(true);
				setVisible(false);
			}
		});
		lblPulmon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPulmon.setBorder(null);
		lblPulmon.setBounds(381, 11, 157, 202);
		getContentPane().add(lblPulmon);
		
		ImageIcon pulmonIcon = new ImageIcon(new ImageIcon("src/img/pulmonPlaceHolder.png").getImage()
				.getScaledInstance(lblPulmon.getWidth(), lblPulmon.getHeight(), Image.SCALE_SMOOTH));
		lblPulmon.setIcon(pulmonIcon);
		
		
		JLabel lblControl = new JLabel("");
		lblControl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registerControl.setLocationRelativeTo(getContentPane());
				registerControl.setVisible(true);
				setVisible(false);
				
			}
		});
		lblControl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblControl.setBorder(null);
		lblControl.setBounds(558, 11, 157, 202);
		getContentPane().add(lblControl);
		
		ImageIcon controlIcon = new ImageIcon(new ImageIcon("src/img/tableroPlaceHolder.png").getImage()
				.getScaledInstance(lblControl.getWidth(), lblControl.getHeight(), Image.SCALE_SMOOTH));
		lblControl.setIcon(controlIcon);
		
		
		JLabel lblNewLabel = new JLabel("Bomba Hidraulica");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(0, 102, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(22, 221, 159, 17);
		getContentPane().add(lblNewLabel);
			
		
		
		JLabel lblCompresor_1 = new JLabel("Compresor");
		lblCompresor_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompresor_1.setForeground(new Color(0, 102, 255));
		lblCompresor_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCompresor_1.setBounds(201, 221, 159, 17);
		getContentPane().add(lblCompresor_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Pulmón Hidroneumático");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(0, 102, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(381, 221, 159, 17);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tablero de Control");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(new Color(0, 102, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(556, 221, 159, 17);
		getContentPane().add(lblNewLabel_1_2);
	
		this.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent we) {
				registerPump.dispose();
				registerCompresor.dispose();
				registerPulmon.dispose();
				registerControl.dispose();
			}
		});
		
	}
	
	
	
}
