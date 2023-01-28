package frames;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.Toolkit;




@SuppressWarnings("serial")
public class frameTemplate extends JDialog {


	public frameTemplate() {
		setResizable(false);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(frameTemplate.class.getResource("/img/icono.png")));
		setTitle("Lista de Equipos");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(800, 744);
		getContentPane().setLayout(new BorderLayout());

	
	}
	





	
	




}
