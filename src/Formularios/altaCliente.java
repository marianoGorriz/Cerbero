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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.demo.DateChooserPanel;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JCalendar;
import javax.swing.border.BevelBorder;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class altaCliente extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	private JTextField textField_6;
	private JTable table_1;
	private JTextField txtTarjeta;
	public JButton  btnNuevo, btnActualizar, btnGuardar, btnCancelar;

		public altaCliente() {
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setLayout(null);
		
		JLabel lblIdDeCliente = new JLabel("ID de Cliente:");
		lblIdDeCliente.setBounds(10, 26, 102, 25);
		lblIdDeCliente.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblIdDeCliente);
		
		JLabel lblNDeTarjeta = new JLabel("N\u00BA de tarjeta:");
		lblNDeTarjeta.setBounds(10, 174, 102, 25);
		lblNDeTarjeta.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblNDeTarjeta);
		
				
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 62, 102, 25);
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 98, 102, 25);
		lblApellido.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblApellido);
		
		JLabel lblDni = new JLabel("D.N.I");
		lblDni.setBounds(10, 134, 102, 25);
		lblDni.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblDni);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(343, 62, 132, 25);
		lblCorreo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblCorreo);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(343, 98, 120, 25);
		lblTelfono.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblTelfono);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(343, 134, 120, 25);
		lblSexo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblSexo);
		
		JLabel lblEdad = new JLabel("Fecha de Nacimiento:");
		lblEdad.setBounds(339, 170, 136, 25);
		lblEdad.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblEdad);
		
		JDateChooser dateChooser = new JDateChooser();	
		
		String fechaEstatica = "Seleccionar";
		dateChooser.getCalendarButton().setText(fechaEstatica);
	
		dateChooser.getCalendarButton().setBounds(0, 0, 136, 20);
		dateChooser.setBounds(473, 174, 136, 20);
		add(dateChooser);
		dateChooser.setLayout(null);
		
		String a = "";
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(343, 26, 67, 14);
		add(lblNewLabel);
		lblNewLabel.setEnabled(false);
		
		textField = new JTextField();
		textField.setBounds(122, 29, 136, 20);
		textField.setEditable(false);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(122, 65, 136, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(122, 101, 136, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(122, 137, 136, 20);
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if (c<'0' || c>'9') e.consume();  //validacion de que solo se escriban número 
			}
		}
	);
		
		textField_3.setToolTipText("NN.NNN.NNN");
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(473, 65, 136, 20);
		textField_4.setToolTipText("ejemplo@ejemplo.com");
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(473, 101, 136, 20);
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
						if ( c<'0' || c>'9') e.consume(); // solo numero en en campo telefono
			}
		}
	);
		txtTarjeta = new JTextField();
		txtTarjeta.setBounds(122, 177, 136, 20);
		txtTarjeta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				if ( c<'0' || c>'9') e.consume(); // solo numero en en campo tarjeta
			}
		}
	);
		add(txtTarjeta);
		txtTarjeta.setColumns(10);
		add(textField_5);
		textField_5.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 272, 599, 151);
		add(scrollPane_1);
		table_1 = new JTable();
				
		Choice choice = new Choice();
		choice.setBounds(473, 134, 136, 20);
		add(choice);
		
		choice.add("Masculino");
		choice.add("Femenino");
				
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(231, 207, 89, 23);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			Date fecha = dateChooser.getDate();
			long d = fecha.getTime();
			java.sql.Date formatoFecha = new java.sql.Date(d);	
			String fecha2 = formatoFecha.toString();
			dateChooser.getCalendarButton().setText(fecha2);	
	
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog (null, "¿Desea agregar un nuevo Cliente?","Precaución",dialogButton);
			if(dialogResult == JOptionPane.YES_OPTION){
				
				if(textField_1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Falta el campo Nombre");  //validacion de formulario
					textField_1.requestFocusInWindow();
					return;
				}
				if(textField_2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Falta el campo Apellido"); //validacion de formulario
					textField_2.requestFocusInWindow();
					return;
				}
				if(textField_3.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Falta el campo DNI"); //validacion de formulario
					textField_3.requestFocusInWindow();
					return;
				}
				if(txtTarjeta.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Falta agregar la Tarjeta");//validacion de formulario
					txtTarjeta.requestFocusInWindow();
					return;
				}
				if(textField_4.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Falta el campo Correo");//validacion de formulario
					textField_4.requestFocusInWindow();
					return;
				}
				if(textField_5.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Falta el campo TELEFONO");//validacion de formulario
					textField_5.requestFocusInWindow();
					return;
				}
				
			
			Cliente cliente = new Cliente();
			
				int id = cliente.altaCliente(textField_1.getText(),
						textField_2.getText(),
						textField_3.getText(),
						textField_4.getText(),
						textField_5.getText(),
						choice.getSelectedItem()
					//	formatoFecha		
						);
				
			Tarjeta tarjeta = new Tarjeta();
			String t = txtTarjeta.getText();
			tarjeta.altaTarjeta(id, t);
						
			}
			
			if(dialogResult == JOptionPane.NO_OPTION) {
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");    //limpieza del formulario en opcion "no"
				textField_4.setText("");
				textField_5.setText("");
				txtTarjeta.setText("");
				textField_1.setEnabled(false);
				textField_2.setEnabled(false);
				textField_3.setEnabled(false);
				txtTarjeta.setEnabled(false);
				textField_4.setEnabled(false);
				textField_5.setEnabled(false);
				textField_6.setEnabled(false);
				
				 
				JOptionPane.showMessageDialog(null,"Alta de usuario CANCELADA");
				
				btnGuardar.setEnabled(false);
					}
				}
			}
		);
		add(btnGuardar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(430, 207, 102, 23);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Date fecha = jdcFechaNacimiento.getDate();
				//long d = fecha.getTime();
				//java.sql.Date formatoFecha = new java.sql.Date(d);
								
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "¿Desea actualizar a este cliente?","Precaución",dialogButton); //pregunta 
				if(dialogResult == JOptionPane.YES_OPTION){
					
					if(textField_1.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Falta el campo Nombre"); //validacion de formulario
						textField_1.requestFocusInWindow();
						return;
					}
					if(textField_2.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Falta el campo Apellido");//validacion de formulario
						textField_2.requestFocusInWindow();
						return;
					}
					if(textField_3.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Falta el campo DNI"); //validacion de formulario
						textField_3.requestFocusInWindow();
						return;
					}
				
					if(textField_4.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Falta el campo Correo"); //validacion de formulario
						textField_4.requestFocusInWindow();
						return;
					}
					if(textField_5.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Falta el campo TELEFONO"); //validacion de formulario
						textField_5.requestFocusInWindow();
						return;
					}
				
					
					Cliente cliente = new Cliente();
					int id = Integer.parseInt(textField.getText());
					//MODIFICAR FUNCION
					cliente.modificarCliente(
							id,
							textField_1.getText(),
							textField_2.getText(),
							textField_3.getText(),						//envio de los datos 
							textField_4.getText(),
							textField_5.getText(),
						    choice.getSelectedItem() //sexo persona
							);			 
					
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
					
				//	recarga de los datos de la tabla
					ResultSet rs;
					Cliente clientes = new Cliente();
					rs = cliente.buscarCliente(textField_6.getText());
					try {
						while(rs.next()) {
							modelo.addRow(new Object[]{rs.getObject("id"), 
									rs.getObject("nombre"),
									rs.getObject("apellido"),
									rs.getObject("DNI"),
									rs.getObject("correo"),
									rs.getObject("telefono"),
									rs.getObject("sexo"),
									rs.getObject("fecha_nacimiento")});
						}
					} catch (SQLException e1) {
					e1.printStackTrace();
					}
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText(""); //limpieza del formulario
					textField_4.setText("");
					textField_5.setText("");
					//jdcFechaNacimiento.setText("");
					txtTarjeta.setText("");
					textField_1.setEnabled(false);
					textField_2.setEnabled(false);
					textField_3.setEnabled(false);
					txtTarjeta.setEnabled(false);
					textField_4.setEnabled(false);
					textField_5.setEnabled(false);
					textField_6.setEnabled(false);
					
					btnActualizar.setEnabled(false);
					choice.setEnabled(false);
					
					
				}
				if(dialogResult == JOptionPane.NO_OPTION) {
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					//txtFecha.setText("");
					txtTarjeta.setText("");
					textField_1.setEnabled(false); //bloque de los btn cuando la opcion  es no
					textField_2.setEnabled(false);
					textField_3.setEnabled(false);
					txtTarjeta.setEnabled(false);
					textField_4.setEnabled(false);
					textField_5.setEnabled(false);
					textField_6.setEnabled(false);
					
					choice.setEnabled(false);
					 
					JOptionPane.showMessageDialog(null,"Modificacion de usuario Cancelada");
						
					}
				}
			}
		);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(330, 207, 89, 23);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnModificar.setEnabled(false);
				
				textField_1.setEnabled(true);
				textField_2.setEnabled(true);
				textField_3.setEnabled(true);
				txtTarjeta.setEnabled(false); //habilitacion de los btn 
				textField_4.setEnabled(true);
				textField_5.setEnabled(true);
				textField_6.setEnabled(true);		
				choice.setEnabled(true);
				dateChooser.setEnabled(true);
								
				btnActualizar.setEnabled(true);
			}
		}
	);
		add(btnModificar);
				
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setBounds(80, 236, 47, 20);
		lblBuscar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblBuscar);
		
		textField_6 = new JTextField();
		textField_6.setBounds(138, 242, 284, 20);
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
				String value3 = table_1.getModel().getValueAt(row, column3).toString(); //envio de los datos a la tabla
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
				//jdcFechaNacimiento.setText(value8);	
				btnModificar.setEnabled(true);
				btnGuardar.setEnabled(false);
				textField_1.setEnabled(false);
				textField_2.setEnabled(false);
				textField_3.setEnabled(false); // comienzo de la ventana
				txtTarjeta.setEnabled(false);
				textField_4.setEnabled(false);
				textField_5.setEnabled(false);
				textField_6.setEnabled(false);
				choice.setEnabled(false);
				dateChooser.setEnabled(false);
			
				}
			}
		);
		
		scrollPane_1.setViewportView(table_1);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(441, 243, 89, 23);
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
			
				ResultSet rs;
				Cliente cliente = new Cliente();
				rs = cliente.buscarCliente(textField_6.getText());
				try {
					while(rs.next()) {
						modelo.addRow(new Object[]{
								rs.getObject("id"), 
								rs.getObject("nombre"),
								rs.getObject("apellido"),
								rs.getObject("DNI"), 
								rs.getObject("correo"),
								rs.getObject("telefono"),
								rs.getObject("sexo"),
								rs.getObject("fecha_nacimiento")});
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(btnBuscar);
		
	
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
		ResultSet rs;
		Cliente cliente = new Cliente();
		rs = cliente.buscarCliente(textField_6.getText());
		try {
			while(rs.next()) {
				modelo.addRow(new Object[]{
						rs.getObject("id"), 
						rs.getObject("nombre"),
						rs.getObject("apellido"),
						rs.getObject("DNI"),
						rs.getObject("correo"),
						rs.getObject("telefono"),
						rs.getObject("sexo"),
						rs.getObject("fecha_nacimiento")
					}
				);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			}
		
		
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(132, 207, 89, 23);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				btnActualizar.setEnabled(false);

				btnGuardar.setEnabled(true);
				btnNuevo.setEnabled(false);
				textField_1.setEnabled(true);
				textField_2.setEnabled(true);
				textField_3.setEnabled(true);
				txtTarjeta.setEnabled(true);
				textField_4.setEnabled(true);
				textField_5.setEnabled(true);
				textField_6.setEnabled(true); //habilitacion de los botones 
				choice.setEnabled(true);
				dateChooser.setEnabled(true);
				
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				//jdcFechaNacimiento.setText("");
				txtTarjeta.setText("");
				
				}
			}
		);
		add(btnNuevo);
		add(btnActualizar);
		btnNuevo.setEnabled(true);
		btnModificar.setEnabled(false);
		btnActualizar.setEnabled(false);
		btnGuardar.setEnabled(false);
		textField_1.setEnabled(false);
		textField_2.setEnabled(false);
		textField_3.setEnabled(false); // comienzo de la ventana
		txtTarjeta.setEnabled(false);
		textField_4.setEnabled(false);
		textField_5.setEnabled(false);
		textField_6.setEnabled(false);
		choice.setEnabled(false);
		dateChooser.setEnabled(false);
	
		
		
		
		
		
	
		
		//jdcFechaNacimiento.setEnabled(false);
	//	jdcFechaNacimiento.getCalendarButton().setEnabled(true);
		
		
		
		}
	}
