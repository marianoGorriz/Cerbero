package Formularios;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Clases.Cliente;
import Clases.Tarjeta;

import java.awt.Choice;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.ComponentOrientation;

public class altaCliente extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtFecha;
	
	private JTextField textField_6;
	private JTable table_1;
	private JTextField txtTarjeta;
	public JButton  btnNuevo, btnActualizar, btnGuardar;

	/**
	 * Create the panel.
	 */
	public altaCliente() {
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setLayout(null);
		
		JLabel lblIdDeCliente = new JLabel("ID de Cliente:");
		lblIdDeCliente.setBounds(10, 23, 102, 25);
		lblIdDeCliente.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblIdDeCliente);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 59, 102, 25);
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 95, 102, 25);
		lblApellido.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblApellido);
		
		JLabel lblDni = new JLabel("D.N.I");
		lblDni.setBounds(10, 131, 102, 25);
		lblDni.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblDni);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(343, 59, 132, 25);
		lblCorreo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblCorreo);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(343, 95, 120, 25);
		lblTelfono.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblTelfono);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(343, 131, 120, 25);
		lblSexo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblSexo);
		
		JLabel lblEdad = new JLabel("Fecha de Nacimiento:");
		lblEdad.setBounds(343, 167, 132, 25);
		lblEdad.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblEdad);
		
		textField = new JTextField();
		textField.setBounds(122, 26, 136, 20);
		textField.setEditable(false);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(122, 62, 136, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(122, 98, 136, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("NN.NNN.NNN");
		textField_3.setBounds(122, 134, 136, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("ejemplo@ejemplo.com");
		textField_4.setBounds(473, 62, 136, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(473, 98, 136, 20);
		add(textField_5);
		textField_5.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setToolTipText("DD/MM/AAAA");
		txtFecha.setBounds(473, 170, 136, 20);
		add(txtFecha);
		txtFecha.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 269, 599, 151);
		add(scrollPane_1);
		table_1 = new JTable();
		
	
		
		Choice choice = new Choice();
		choice.setBounds(473, 131, 136, 20);
		add(choice);
		choice.add("Masculino");
		choice.add("Femenino");
		
	
		

		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog (null, "¿Desea agregar un nuevo Cliente?","Precaución",dialogButton);
			if(dialogResult == JOptionPane.YES_OPTION){
				
				if(textField_1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Falta el campo Nombre");
					textField_1.requestFocusInWindow();
					return;
				}
				if(textField_2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Falta el campo Apellido");
					textField_2.requestFocusInWindow();
					return;
				}
				if(textField_3.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Falta el campo DNI");
					textField_3.requestFocusInWindow();
					return;
				}
				if(txtTarjeta.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Falta agregar la Tarjeta");
					txtTarjeta.requestFocusInWindow();
					return;
				}
				if(textField_4.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Falta el campo Correo");
					textField_4.requestFocusInWindow();
					return;
				}
				if(textField_5.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Falta el campo TELEFONO");
					textField_5.requestFocusInWindow();
					return;
				}
				if(txtFecha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Falta el campo Ingrese la FECHA DE NACIMIENTO");
					txtFecha.requestFocusInWindow();
					return;
				}
			
			Cliente cliente = new Cliente();
			
				int id = cliente.altaCliente(textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(),
						textField_5.getText(),choice.getSelectedItem(),txtFecha.getText(),txtTarjeta.getText());
			Tarjeta tarjeta = new Tarjeta();
			String t = txtTarjeta.getText();
			tarjeta.altaTarjeta(id, t);
				
			
			}
			
			if(dialogResult == JOptionPane.NO_OPTION) {
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				txtFecha.setText("");
				txtTarjeta.setText("");
				textField_1.setEnabled(false);
				textField_2.setEnabled(false);
				textField_3.setEnabled(false);
				txtTarjeta.setEnabled(false);
				textField_4.setEnabled(false);
				textField_5.setEnabled(false);
				textField_6.setEnabled(false);
				txtFecha.setEnabled(false);
				 
				JOptionPane.showMessageDialog(null,"Alta de usuario CANCELADA");
				
				btnGuardar.setEnabled(false);
				
				
			
	
			}
		
			
		}});
		btnGuardar.setBounds(222, 204, 89, 23);
		add(btnGuardar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "¿Desea actualizar a este cliente?","Precaución",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					
					if(textField_1.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Falta el campo Nombre");
						textField_1.requestFocusInWindow();
						return;
					}
					if(textField_2.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Falta el campo Apellido");
						textField_2.requestFocusInWindow();
						return;
					}
					if(textField_3.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Falta el campo DNI");
						textField_3.requestFocusInWindow();
						return;
					}
				
					if(textField_4.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Falta el campo Correo");
						textField_4.requestFocusInWindow();
						return;
					}
					if(textField_5.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Falta el campo TELEFONO");
						textField_5.requestFocusInWindow();
						return;
					}
					if(txtFecha.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Falta el campo Ingrese la FECHA DE NACIMIENTO");
						txtFecha.requestFocusInWindow();
						return;
					}
					
					Cliente cliente = new Cliente();
					int id = Integer.parseInt(textField.getText());
					
					cliente.modificarCliente(id, textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(),
								textField_5.getText(),choice.getSelectedItem(),txtFecha.getText());
					
					DefaultTableModel modelo;
					modelo = new DefaultTableModel();
					modelo.addColumn("ID");
					modelo.addColumn("Nombre");
					modelo.addColumn("Apellido");
					modelo.addColumn("DNI");
					modelo.addColumn("Correo");
					modelo.addColumn("Telefono");
					modelo.addColumn("Sexo");
					modelo.addColumn("Fecha Nacimiento");
					table_1.setModel(modelo);
				//	modelo.addRow(new Object[]{"ID", "Usuario", "Contraseña", "Rol","Estado"});
					ResultSet rs;
					Cliente clientes = new Cliente();
					rs = cliente.buscarCliente(textField_6.getText());
					try {
						while(rs.next()) {
							modelo.addRow(new Object[]{rs.getObject("id"), 
									rs.getObject("nombre"), rs.getObject("apellido"), rs.getObject("DNI"), rs.getObject("correo"),
									rs.getObject("telefono"),rs.getObject("sexo"),rs.getObject("fecha_nacimiento")});
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					txtFecha.setText("");
					txtTarjeta.setText("");
					textField_1.setEnabled(false);
					textField_2.setEnabled(false);
					textField_3.setEnabled(false);
					txtTarjeta.setEnabled(false);
					textField_4.setEnabled(false);
					textField_5.setEnabled(false);
					textField_6.setEnabled(false);
					txtFecha.setEnabled(false);
					
				}
				if(dialogResult == JOptionPane.NO_OPTION) {
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					txtFecha.setText("");
					txtTarjeta.setText("");
					textField_1.setEnabled(false);
					textField_2.setEnabled(false);
					textField_3.setEnabled(false);
					txtTarjeta.setEnabled(false);
					textField_4.setEnabled(false);
					textField_5.setEnabled(false);
					textField_6.setEnabled(false);
					txtFecha.setEnabled(false);
					 
					JOptionPane.showMessageDialog(null,"Modificacion de usuario Cancelada");
		
					
				
				}
			}
			}
			
		);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnModificar.setEnabled(false);
				
				textField_1.setEnabled(true);
				textField_2.setEnabled(true);
				textField_3.setEnabled(true);
				txtTarjeta.setEnabled(false);
				textField_4.setEnabled(true);
				textField_5.setEnabled(true);
				textField_6.setEnabled(true);
				txtFecha.setEnabled(true);
				
				
				btnActualizar.setEnabled(true);
				
			
				
			}
		});
		btnModificar.setBounds(333, 203, 89, 23);
		add(btnModificar);
		
	
		
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setBounds(87, 238, 47, 20);
		lblBuscar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblBuscar);
		
		textField_6 = new JTextField();
		textField_6.setBounds(138, 239, 284, 20);
		add(textField_6);
		textField_6.setColumns(10);
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int column1 = 0;
				int column2 = 1;
				int column3 = 2;
				int column4 = 3;
				int column5 = 4;
				int column6 = 5;
				int column7 = 6;
				int column8 = 7;
				btnGuardar.setText("Guardar");
				int row = table_1.getSelectedRow();
				String value1 = table_1.getModel().getValueAt(row, column1).toString();
				String value2 = table_1.getModel().getValueAt(row, column2).toString();
				String value3 = table_1.getModel().getValueAt(row, column3).toString();
				String value4 = table_1.getModel().getValueAt(row, column4).toString();
				String value5 = table_1.getModel().getValueAt(row, column5).toString();
				String value6 = table_1.getModel().getValueAt(row, column6).toString();
				String value7 = table_1.getModel().getValueAt(row, column7).toString();
				String value8 = table_1.getModel().getValueAt(row, column8).toString();
				

				textField.setText(value1);
				textField_1.setText(value2);
				textField_2.setText(value3);
				textField_3.setText(value4);
				textField_4.setText(value5);
				textField_5.setText(value6);
				choice.select(value7);
				choice.repaint();
				txtFecha.setText(value8);	
				btnModificar.setEnabled(true);
				
			}
		});
		
		
		scrollPane_1.setViewportView(table_1);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(441, 240, 89, 23);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelo;
				modelo = new DefaultTableModel();
				modelo.addColumn("ID");
				modelo.addColumn("Nombre");
				modelo.addColumn("Apellido");
				modelo.addColumn("DNI");
				modelo.addColumn("Correo");
				modelo.addColumn("Telefono");
				modelo.addColumn("Sexo");
				modelo.addColumn("Fecha Nacimiento");
				table_1.setModel(modelo);
			//	modelo.addRow(new Object[]{"ID", "Usuario", "Contraseña", "Rol","Estado"});
				ResultSet rs;
				Cliente cliente = new Cliente();
				rs = cliente.buscarCliente(textField_6.getText());
				try {
					while(rs.next()) {
						modelo.addRow(new Object[]{rs.getObject("id"), 
								rs.getObject("nombre"), rs.getObject("apellido"), rs.getObject("DNI"), rs.getObject("correo"),
								rs.getObject("telefono"),rs.getObject("sexo"),rs.getObject("fecha_nacimiento")});
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		add(btnBuscar);
		
		JLabel lblNDeTarjeta = new JLabel("N\u00BA de tarjeta:");
		lblNDeTarjeta.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNDeTarjeta.setBounds(10, 171, 102, 25);
		add(lblNDeTarjeta);
		
		txtTarjeta = new JTextField();
		txtTarjeta.setBounds(122, 174, 136, 20);
		add(txtTarjeta);
		txtTarjeta.setColumns(10);
		
	
		btnActualizar.setBounds(442, 203, 102, 23);
		add(btnActualizar);
		
	
		DefaultTableModel modelo;
		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("DNI");
		modelo.addColumn("Correo");
		modelo.addColumn("Telefono");
		modelo.addColumn("Sexo");
		modelo.addColumn("Fecha Nacimiento");
		table_1.setModel(modelo);
	//	modelo.addRow(new Object[]{"ID", "Usuario", "Contraseña", "Rol","Estado"});
		ResultSet rs;
		Cliente cliente = new Cliente();
		rs = cliente.buscarCliente(textField_6.getText());
		try {
			while(rs.next()) {
				modelo.addRow(new Object[]{rs.getObject("id"), 
						rs.getObject("nombre"), rs.getObject("apellido"), rs.getObject("DNI"), rs.getObject("correo"),
						rs.getObject("telefono"),rs.getObject("sexo"),rs.getObject("fecha_nacimiento")});
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				btnActualizar.setEnabled(false);

				btnGuardar.setEnabled(true);
				btnNuevo.setEnabled(true);
				textField_1.setEnabled(true);
				textField_2.setEnabled(true);
				textField_3.setEnabled(true);
				txtTarjeta.setEnabled(true);
				textField_4.setEnabled(true);
				textField_5.setEnabled(true);
				textField_6.setEnabled(true);
				txtFecha.setEnabled(true);
				
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				txtFecha.setText("");
				txtTarjeta.setText("");
				
			}
		});
		btnNuevo.setBounds(103, 204, 89, 23);
		add(btnNuevo);
		
		btnNuevo.setEnabled(true);
		btnModificar.setEnabled(false);
		btnActualizar.setEnabled(false);
		btnGuardar.setEnabled(false);
		textField_1.setEnabled(false);
		textField_2.setEnabled(false);
		textField_3.setEnabled(false);
		txtTarjeta.setEnabled(false);
		textField_4.setEnabled(false);
		textField_5.setEnabled(false);
		textField_6.setEnabled(false);
		txtFecha.setEnabled(false);
		
	
		
		
		
		
		
		
	

	}
}
