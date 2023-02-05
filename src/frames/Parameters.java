package frames;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import actors.Mesure;
import panels.MesurePanel;
import sql.MesureList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.ImageIcon;




@SuppressWarnings("serial")
public class Parameters extends JDialog {
	private static JPanel listPanel = new JPanel();
	private static Cuantitative cuantitativePanel = new Cuantitative();
	private static Cualitative cualitativePanel = new Cualitative();
	private static int elementsCounter = 0;
	private static Container panel = null;

	public Parameters() {
		getContentPane().setBackground(Color.WHITE);
		panel = getContentPane();
		setResizable(false);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Parameters.class.getResource("/img/icono.png")));
		setTitle("Lista de Parametros");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(800, 744);
		getContentPane().setLayout(null);
		listPanel.setBackground(Color.WHITE);
		

		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
		JScrollPane scrollPane = new JScrollPane(listPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 106, 764, 532);
		getContentPane().add(scrollPane);
		
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.setIcon(new ImageIcon(Parameters.class.getResource("/img/puerta-cerrada.png")));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 102, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(663, 649, 111, 45);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Agregar Registro Cuantitativo");
		btnNewButton_1.setIcon(new ImageIcon(Parameters.class.getResource("/img/lista-del-portapapeles.png")));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 102, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cuantitativePanel  = new Cuantitative();
				cuantitativePanel.setLocationRelativeTo(getContentPane());
				cuantitativePanel.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 25, 227, 47);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Agregar Registro Cualitativo");
		btnNewButton_1_1.setIcon(new ImageIcon(Parameters.class.getResource("/img/lista-del-portapapeles.png")));
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setBackground(new Color(0, 102, 255));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cualitativePanel.setLocationRelativeTo(getContentPane());
				cualitativePanel.setVisible(true);
			}
		});
		btnNewButton_1_1.setBounds(547, 25, 227, 47);
		getContentPane().add(btnNewButton_1_1);

		fillListPanel();
	
	
	}
	
	public static void fillListPanel() {
		listPanel.removeAll();
		listPanel.revalidate();
		listPanel.repaint();
		elementsCounter = 0;
		
		ArrayList<Mesure> list = MesureList.getMesurelist();
		
		for(int i = 0 ; i < list.size() ; i++) {
			elementsCounter++;
			listPanel.add(new MesurePanel(list.get(i), panel));
		}
		
		listPanel.setPreferredSize(new Dimension(700, 125 * elementsCounter));
		
	}
	
}
