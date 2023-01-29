package frames;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import sql.RegisterPump;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import actors.WaterPump;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class RegisterCompresorFrame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCode;
	private JTextField textArea;
	private JTextField textMark;
	private JTextField textFunction;
	private JTextField textName;
	private JTextField textModel;
	private JTextField textPotency;
	private JTextField textRotationSpeed;
	private JTextField textMaxPresure;
	private JTextField textFrecuency;
	private JTextField textTension;
	private JTextField textEnviromentTemp;
	private JTextField textWeigth;
	private JTextField textOther;

	///
	String filePath = "src/img/compresorPlaceholder.png";
	private JLabel lblPhoto = new JLabel("");

	public RegisterCompresorFrame() {
		setResizable(false);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegisterCompresorFrame.class.getResource("/img/icono.png")));
		setTitle("Registrar Compresor");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setSize(800, 744);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 120, 215)));

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				closeWindow();
			}
		});

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel topPanel = new JPanel();
			topPanel.setBounds(0, 0, 784, 128);
			topPanel.setForeground(UIManager.getColor("Button.background"));
			topPanel.setBackground(new Color(255, 255, 255));
			contentPanel.add(topPanel);
			topPanel.setLayout(new MigLayout("", "[47px][258.00px,grow][17px][117px][4px][311.00px,grow]",
					"[26.00px][20px][20px][20px]"));
			{
				JLabel lblCode = new JLabel("Código:");
				lblCode.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
				lblCode.setForeground(SystemColor.textHighlight);
				topPanel.add(lblCode, "cell 0 0,alignx right,growy");
			}
			{
				textCode = new JTextField();
				textCode.setCaretColor(SystemColor.textHighlight);
				textCode.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
				textCode.setFont(new Font("Arial Narrow", Font.BOLD, 18));
				textCode.setForeground(SystemColor.textHighlight);
				topPanel.add(textCode, "cell 1 0,grow");
				textCode.setColumns(10);
			}
			{
				JLabel lblNombreDelEquipo = new JLabel("Nombre del equipo");
				lblNombreDelEquipo.setForeground(SystemColor.textHighlight);
				lblNombreDelEquipo.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
				topPanel.add(lblNombreDelEquipo, "cell 3 0,alignx right,aligny center");
			}
			{
				textName = new JTextField();
				textName.setForeground(SystemColor.textHighlight);
				textName.setFont(new Font("Arial Narrow", Font.BOLD, 18));
				textName.setColumns(10);
				textName.setCaretColor(SystemColor.textHighlight);
				textName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
				topPanel.add(textName, "cell 5 0,grow");
			}
			{
				JLabel lblCode = new JLabel("Área");
				lblCode.setForeground(SystemColor.textHighlight);
				lblCode.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
				topPanel.add(lblCode, "cell 0 1,alignx trailing,growy");
			}
			{
				textArea = new JTextField();
				textArea.setForeground(SystemColor.textHighlight);
				textArea.setFont(new Font("Arial Narrow", Font.BOLD, 18));
				textArea.setColumns(10);
				textArea.setCaretColor(SystemColor.textHighlight);
				textArea.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
				topPanel.add(textArea, "cell 1 1,grow");
			}

			JLabel lblModelo = new JLabel("Modelo");
			lblModelo.setForeground(SystemColor.textHighlight);
			lblModelo.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
			topPanel.add(lblModelo, "cell 3 1,alignx right,aligny center");
			{
				textModel = new JTextField();
				textModel.setForeground(SystemColor.textHighlight);
				textModel.setFont(new Font("Arial Narrow", Font.BOLD, 18));
				textModel.setColumns(10);
				textModel.setCaretColor(SystemColor.textHighlight);
				textModel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
				topPanel.add(textModel, "cell 5 1,grow");
			}
			{
				JLabel lblMarca = new JLabel("Marca");
				lblMarca.setForeground(SystemColor.textHighlight);
				lblMarca.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
				topPanel.add(lblMarca, "cell 0 2,alignx trailing,growy");
			}
			{
				textMark = new JTextField();
				textMark.setForeground(SystemColor.textHighlight);
				textMark.setFont(new Font("Arial Narrow", Font.BOLD, 18));
				textMark.setColumns(10);
				textMark.setCaretColor(SystemColor.textHighlight);
				textMark.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
				topPanel.add(textMark, "cell 1 2,grow");
			}
			{
				JLabel lblCode = new JLabel("Función");
				lblCode.setForeground(SystemColor.textHighlight);
				lblCode.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
				topPanel.add(lblCode, "cell 0 3,alignx trailing,growy");
			}
			{
				textFunction = new JTextField();
				textFunction.setForeground(SystemColor.textHighlight);
				textFunction.setFont(new Font("Arial Narrow", Font.BOLD, 18));
				textFunction.setColumns(10);
				textFunction.setCaretColor(SystemColor.textHighlight);
				textFunction.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
				topPanel.add(textFunction, "cell 1 3 5 1,grow");
			}
		}
		{
			JPanel leftPanel = new JPanel();
			leftPanel.setBounds(0, 129, 285, 373);
			leftPanel.setForeground(UIManager.getColor("Button.background"));
			leftPanel.setBackground(new Color(255, 255, 255));
			contentPanel.add(leftPanel);
			leftPanel.setLayout(null);
			{
				JLabel lblFoto = new JLabel("FOTO");
				lblFoto.setBounds(132, 11, 40, 21);
				lblFoto.setForeground(SystemColor.textHighlight);
				lblFoto.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
				leftPanel.add(lblFoto);
			}
			{
				lblPhoto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

				lblPhoto.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						changePicture(lblPhoto);

					}
				});
				lblPhoto.setBounds(34, 39, 232, 252);
				lblPhoto.setBorder(new LineBorder(SystemColor.textHighlight));
				putPlaceHolderPicture();
				leftPanel.add(lblPhoto);
			}
			{
				JButton btnRetorePicture = new JButton("Restaurar Imagen");
				btnRetorePicture.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						putPlaceHolderPicture();
					}
				});
				btnRetorePicture.setBounds(34, 310, 232, 23);
				btnRetorePicture.setForeground(new Color(255, 255, 255));
				btnRetorePicture.setBackground(SystemColor.textHighlight);
				leftPanel.add(btnRetorePicture);
			}
		}
		{
			JPanel midlePanel = new JPanel();
			midlePanel.setBorder(
					new TitledBorder(new LineBorder(new Color(0, 120, 215)), "Datos / Modificaciones T\u00E9cnicas",
							TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 120, 215)));
			midlePanel.setBounds(295, 129, 489, 373);
			midlePanel.setForeground(UIManager.getColor("Button.background"));
			midlePanel.setBackground(new Color(255, 255, 255));
			contentPanel.add(midlePanel);
			midlePanel.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][][][][][]"));
			{
				JLabel lblAo = new JLabel("Potencia:");
				lblAo.setForeground(SystemColor.textHighlight);
				lblAo.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
				midlePanel.add(lblAo, "cell 0 0,alignx left,growy");
			}
			{
				textPotency = new JTextField();
				textPotency.setForeground(SystemColor.textHighlight);
				textPotency.setFont(new Font("Arial Narrow", Font.BOLD, 18));
				textPotency.setColumns(10);
				textPotency.setCaretColor(SystemColor.textHighlight);
				textPotency.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
				midlePanel.add(textPotency, "cell 1 0,growx");
			}
			{
				JLabel lblGradoDeProteccin = new JLabel("Presión Máxima:");
				lblGradoDeProteccin.setForeground(SystemColor.textHighlight);
				lblGradoDeProteccin.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
				midlePanel.add(lblGradoDeProteccin, "cell 0 1,alignx left,aligny center");
			}
			{
				textMaxPresure = new JTextField();
				textMaxPresure.setForeground(SystemColor.textHighlight);
				textMaxPresure.setFont(new Font("Arial Narrow", Font.BOLD, 18));
				textMaxPresure.setColumns(10);
				textMaxPresure.setCaretColor(SystemColor.textHighlight);
				textMaxPresure.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
				midlePanel.add(textMaxPresure, "cell 1 1,growx");
			}
			{
				JLabel lblAislamientoClase = new JLabel("Frecuencia (Hz):");
				lblAislamientoClase.setForeground(SystemColor.textHighlight);
				lblAislamientoClase.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
				midlePanel.add(lblAislamientoClase, "cell 0 2,alignx left,aligny center");
			}
			{
				textFrecuency = new JTextField();
				textFrecuency.setForeground(SystemColor.textHighlight);
				textFrecuency.setFont(new Font("Arial Narrow", Font.BOLD, 18));
				textFrecuency.setColumns(10);
				textFrecuency.setCaretColor(SystemColor.textHighlight);
				textFrecuency.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
				midlePanel.add(textFrecuency, "cell 1 2,growx");
			}
			{
				JLabel lblPotecy = new JLabel("Velocidad de Rotación:");
				lblPotecy.setForeground(SystemColor.textHighlight);
				lblPotecy.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
				midlePanel.add(lblPotecy, "cell 0 3,alignx left,aligny center");
			}
			{
				textRotationSpeed = new JTextField();
				textRotationSpeed.setForeground(SystemColor.textHighlight);
				textRotationSpeed.setFont(new Font("Arial Narrow", Font.BOLD, 18));
				textRotationSpeed.setColumns(10);
				textRotationSpeed.setCaretColor(SystemColor.textHighlight);
				textRotationSpeed.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
				midlePanel.add(textRotationSpeed, "cell 1 3,growx");
			}
			{
				JLabel lblTuberaDeSuccin = new JLabel("V (Tensión de Alimentación):");
				lblTuberaDeSuccin.setForeground(SystemColor.textHighlight);
				lblTuberaDeSuccin.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
				midlePanel.add(lblTuberaDeSuccin, "cell 0 4,alignx left,aligny center");
			}
			{
				textTension = new JTextField();
				textTension.setForeground(SystemColor.textHighlight);
				textTension.setFont(new Font("Arial Narrow", Font.BOLD, 18));
				textTension.setColumns(10);
				textTension.setCaretColor(SystemColor.textHighlight);
				textTension.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
				midlePanel.add(textTension, "cell 1 4,growx");
			}
			{
				JLabel lblCdigo = new JLabel("Temperatura Ambiente:");
				lblCdigo.setForeground(SystemColor.textHighlight);
				lblCdigo.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
				midlePanel.add(lblCdigo, "cell 0 5,alignx left,aligny center");
			}
			{
				textEnviromentTemp = new JTextField();
				textEnviromentTemp.setForeground(SystemColor.textHighlight);
				textEnviromentTemp.setFont(new Font("Arial Narrow", Font.BOLD, 18));
				textEnviromentTemp.setColumns(10);
				textEnviromentTemp.setCaretColor(SystemColor.textHighlight);
				textEnviromentTemp.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
				midlePanel.add(textEnviromentTemp, "cell 1 5,growx");
			}
			{
				JLabel lblCaudalesHasta = new JLabel("Peso:");
				lblCaudalesHasta.setForeground(SystemColor.textHighlight);
				lblCaudalesHasta.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
				midlePanel.add(lblCaudalesHasta, "cell 0 6,alignx left,aligny center");
			}
			{
				textWeigth = new JTextField();
				textWeigth.setForeground(SystemColor.textHighlight);
				textWeigth.setFont(new Font("Arial Narrow", Font.BOLD, 18));
				textWeigth.setColumns(10);
				textWeigth.setCaretColor(SystemColor.textHighlight);
				textWeigth.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
				midlePanel.add(textWeigth, "cell 1 6,growx");
			}

			JLabel lblAlturaMax = new JLabel("Otros:");
			lblAlturaMax.setForeground(SystemColor.textHighlight);
			lblAlturaMax.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
			midlePanel.add(lblAlturaMax, "cell 0 7,alignx left,aligny center");
			{
				textOther = new JTextField();
				textOther.setForeground(SystemColor.textHighlight);
				textOther.setFont(new Font("Arial Narrow", Font.BOLD, 18));
				textOther.setColumns(10);
				textOther.setCaretColor(SystemColor.textHighlight);
				textOther.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
				midlePanel.add(textOther, "cell 1 7,growx");
			}
		}
		{
			JPanel botPanel = new JPanel();
			botPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 120, 215)), "Repuestos Importantes",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 120, 215)));
			botPanel.setBounds(0, 513, 784, 137);
			botPanel.setForeground(UIManager.getColor("Button.background"));
			botPanel.setBackground(new Color(255, 255, 255));
			contentPanel.add(botPanel);
			botPanel.setLayout(new MigLayout("", "[67.00][grow]", "[26.00][28.00][][]"));
			{
				JLabel lblImpulsor = new JLabel("Correa de Polea");
				lblImpulsor.setForeground(SystemColor.textHighlight);
				lblImpulsor.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
				botPanel.add(lblImpulsor, "cell 0 0,alignx left");
			}
			{
				JLabel lblSelloMecnico = new JLabel("Aceite");
				lblSelloMecnico.setForeground(SystemColor.textHighlight);
				lblSelloMecnico.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
				botPanel.add(lblSelloMecnico, "cell 0 1,alignx left");
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 661, 784, 33);
			contentPanel.add(buttonPane);
			buttonPane.setForeground(UIManager.getColor("Button.background"));
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton btnAccept = new JButton("Aceptar");
				btnAccept.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if (areDataComplete()) {
							WaterPump pump = new WaterPump();
							pump.setCode(textCode.getText());
							pump.setName(textName.getText());
							pump.setArea(textArea.getText());
							pump.setMark(textMark.getText());
							pump.setModel(textModel.getText());
							pump.setFunction(textFunction.getText());
							pump.setPictureAddress(filePath);
							
							pump.setPotencty(textPotency.getText());
							pump.setMaxPresure(textMaxPresure.getText());
							pump.setFrecuency(textFrecuency.getText());
							pump.setRotationSpeed(textRotationSpeed.getText());
							pump.setTensionPower(textTension.getText());
							pump.setEnviromentTemp(textEnviromentTemp.getText());
							pump.setWeigth(textWeigth.getText());
							pump.setOthers(textOther.getText());
							
							boolean isRegistered = RegisterPump.register(pump);
							
							if(isRegistered) {
								JOptionPane.showMessageDialog(contentPanel, "Se ha registrado correctamente el equipo", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
								cleanAllFields();
							}else {
								JOptionPane.showMessageDialog(contentPanel, "Ocurrió un error al intentar registrar el equipo", "ERROR", JOptionPane.ERROR_MESSAGE);
							}
							
						} else {
							JOptionPane.showMessageDialog(contentPanel, "Debe llenar todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
						}

					}
				});
				btnAccept.setForeground(SystemColor.text);
				btnAccept.setBackground(SystemColor.textHighlight);
				btnAccept.setActionCommand("OK");
				buttonPane.add(btnAccept);
				getRootPane().setDefaultButton(btnAccept);
			}
			{
				JButton btnCancel = new JButton("Cancelar");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						closeWindow();
					}
				});
				btnCancel.setBackground(SystemColor.textHighlight);
				btnCancel.setForeground(SystemColor.text);
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}

	private void closeWindow() {

		if (!areAllFieldsClean()) {
			int opt = JOptionPane.showConfirmDialog(this, "¿Desea descartar los cambios?",
					"No ha terminado con el registro", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

			if (opt == JOptionPane.YES_OPTION) {
				putPlaceHolderPicture();
				cleanAllFields();
				dispose();
			}
		} else {
			putPlaceHolderPicture();
			cleanAllFields();
			dispose();
		}

	}
/////////////////////////////

	private void putPlaceHolderPicture() {

		ImageIcon placeHolderIcon = new ImageIcon(new ImageIcon("src/img/compresorPlaceholder.png").getImage()
				.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH));
		lblPhoto.setIcon(placeHolderIcon);
	}

	/////
	// revisa que todos los campos esten limpios por si existe informacion por guardar
	private boolean areAllFieldsClean() {
		if (!textCode.getText().isEmpty() || !textArea.getText().isEmpty() || !textMark.getText().isEmpty()
				|| !textFunction.getText().isEmpty() || !textName.getText().isEmpty() || !textModel.getText().isEmpty()
				|| !textRotationSpeed.getText().isEmpty() || !textMaxPresure.getText().isEmpty()
				|| !textFrecuency.getText().isEmpty() || !textRotationSpeed.getText().isEmpty()
				|| !textTension.getText().isEmpty() || !textEnviromentTemp.getText().isEmpty()
				|| !textWeigth.getText().isEmpty() || !textOther.getText().isEmpty() ){

			return false;
		}

		return true;
	}
////////////////////////

	//revisa que todos los datos esten completos
	private boolean areDataComplete() {
		if (!textCode.getText().isEmpty() && !textArea.getText().isEmpty() && !textMark.getText().isEmpty()
				&& !textFunction.getText().isEmpty() && !textName.getText().isEmpty() && !textModel.getText().isEmpty()
				&& !textRotationSpeed.getText().isEmpty() && !textMaxPresure.getText().isEmpty()
				&& !textFrecuency.getText().isEmpty() && !textRotationSpeed.getText().isEmpty()
				&& !textTension.getText().isEmpty() && !textEnviromentTemp.getText().isEmpty()
				&& !textWeigth.getText().isEmpty() && !textOther.getText().isEmpty()) {

			return true;
		}

		return false;
	}
	
	
	// limpia todos los campos
	private void cleanAllFields() {

		textCode.setText("");
		textArea.setText("");
		textMark.setText("");
		textFunction.setText("");
		textName.setText("");
		textModel.setText("");
		textRotationSpeed.setText("");
		textMaxPresure.setText("");
		textFrecuency.setText("");
		textRotationSpeed.setText("");
		textTension.setText("");
		textEnviromentTemp.setText("");
		textWeigth.setText("");
		textOther.setText("");

	

	}

	//////////////

	private void changePicture(JLabel lblPhoto) {

		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(contentPanel);
		try {
			File file = chooser.getSelectedFile();
			filePath = file.getAbsolutePath();

			ImageIcon newPicture = new ImageIcon(new ImageIcon(filePath).getImage()
					.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH));
			lblPhoto.setIcon(newPicture);

		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
	}

}
