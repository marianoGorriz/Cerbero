package Formularios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AltaTarjeta extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaTarjeta frame = new AltaTarjeta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AltaTarjeta() {
		setBounds(100, 100, 625, 382);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(33, 9, 86, 17);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCantidadDeTarjetas = new JLabel("Cantidad de Tarjetas:");
		lblCantidadDeTarjetas.setBounds(10, 42, 109, 14);
		getContentPane().add(lblCantidadDeTarjetas);
		
		textField_1 = new JTextField();
		textField_1.setBounds(129, 39, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ultima Tarjeta:");
		lblNewLabel_1.setBounds(10, 71, 86, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(106, 67, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Numero de tarjeta:");
		lblNewLabel_2.setBounds(10, 104, 104, 14);
		getContentPane().add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(106, 101, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(106, 129, 86, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(106, 160, 86, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblPuntos = new JLabel("Puntos:");
		lblPuntos.setBounds(10, 139, 46, 14);
		getContentPane().add(lblPuntos);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha alta:");
		lblNewLabel_3.setBounds(10, 170, 70, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(291, 11, 46, 14);
		getContentPane().add(lblEstado);
		
		textField_6 = new JTextField();
		textField_6.setBounds(429, 8, 86, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(429, 39, 86, 20);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Ultima compra:");
		lblNewLabel_4.setBounds(291, 42, 83, 14);
		getContentPane().add(lblNewLabel_4);

	}
}
