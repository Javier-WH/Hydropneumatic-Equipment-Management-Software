package frames;
import java.awt.BorderLayout;
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




@SuppressWarnings("serial")
public class Parameters extends JDialog {
	private static JPanel listPanel = new JPanel();
	private static Cuantitative cuantitativePanel = new Cuantitative();
	private static int elementsCounter = 0;
	private static Container panel = null;

	public Parameters() {
		panel = getContentPane();
		setResizable(false);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Parameters.class.getResource("/img/icono.png")));
		setTitle("Lista de Parametros");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(800, 744);
		getContentPane().setLayout(null);
		

		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
		JScrollPane scrollPane = new JScrollPane(listPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 106, 764, 558);
		getContentPane().add(scrollPane);
		
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(685, 671, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Agregar Registro Cuantitativo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cuantitativePanel  = new Cuantitative();
				cuantitativePanel.setLocationRelativeTo(getContentPane());
				cuantitativePanel.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(18, 40, 227, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Agregar Registro Cualitativo");
		btnNewButton_1_1.setBounds(547, 40, 227, 23);
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
