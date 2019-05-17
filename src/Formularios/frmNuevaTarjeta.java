package Formularios;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Clases.Tarjeta;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmNuevaTarjeta extends JPanel {
	private JTextField txtNTarjeta;
	private JTextField txtFechaAlta;
	private JTextField txtPuntosTarjeta;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTextField txtSexo;
	private JTextField txtEdad;

	/**
	 * Create the panel.
	 */
	public frmNuevaTarjeta() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero tarjeta");
		lblNewLabel.setBounds(279, 33, 112, 14);
		add(lblNewLabel);
		
		JLabel label = new JLabel("Fecha alta");
		label.setBounds(293, 58, 80, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Puntos");
		label_1.setBounds(303, 83, 46, 14);
		add(label_1);
		
		txtNTarjeta = new JTextField();
		txtNTarjeta.setBounds(405, 30, 137, 20);
		add(txtNTarjeta);
		txtNTarjeta.setColumns(10);
		
		txtFechaAlta = new JTextField();
		txtFechaAlta.setColumns(10);
		txtFechaAlta.setBounds(405, 55, 137, 20);
		add(txtFechaAlta);
		
		txtPuntosTarjeta = new JTextField();
		txtPuntosTarjeta.setColumns(10);
		txtPuntosTarjeta.setBounds(405, 80, 137, 20);
		add(txtPuntosTarjeta);
		
		JButton btnNewButton = new JButton("Nueva tarjeta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tarjeta tarjeta = new Tarjeta();
				String nombre = txtNombre.getText();
				String apellido = txtApellido.getText();
				String dni = txtDni.getText();
				String correo = txtCorreo.getText();
				String telefono = txtTelefono.getText();
				String sexo = txtSexo.getText();
				
				//tarjeta.nuevaTarjeta(nombre,apellido, dni, correo, telefono, sexo);
				//tarjeta.altaTarjeta(id, tarjeta);
				
				
			}
		});
		btnNewButton.setBounds(330, 127, 137, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(10, 33, 46, 14);
		add(lblNewLabel_1);
		
		JLabel label_3 = new JLabel("Apellido");
		label_3.setBounds(10, 58, 46, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel("DNI");
		label_4.setBounds(10, 83, 46, 14);
		add(label_4);
		
		JLabel label_5 = new JLabel("Correo");
		label_5.setBounds(10, 108, 46, 14);
		add(label_5);
		
		JLabel label_6 = new JLabel("Telefono");
		label_6.setBounds(10, 131, 46, 14);
		add(label_6);
		
		JLabel label_7 = new JLabel("Sexo");
		label_7.setBounds(10, 156, 46, 14);
		add(label_7);
		
		
		
		txtNombre = new JTextField();
		txtNombre.setBounds(66, 30, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(66, 55, 86, 20);
		add(txtApellido);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(66, 80, 86, 20);
		add(txtDni);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(66, 105, 86, 20);
		add(txtCorreo);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(66, 128, 86, 20);
		add(txtTelefono);
		
		txtSexo = new JTextField();
		txtSexo.setColumns(10);
		txtSexo.setBounds(66, 153, 86, 20);
		add(txtSexo);
		
		JLabel label_8 = new JLabel("Edad");
		label_8.setBounds(10, 181, 46, 14);
		add(label_8);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(66, 178, 86, 20);
		add(txtEdad);
		
		

	}

}
