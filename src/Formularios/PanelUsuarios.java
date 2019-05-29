package Formularios;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clases.Producto;
import Clases.Usuario;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Choice;
import java.awt.List;
import java.awt.ComponentOrientation;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.UIManager;

public class PanelUsuarios extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTable table;
	private JButton btnEliminar,btnNuevo,btnCancelar,btnActualizar,btnNewButton;
	
	public PanelUsuarios() {
		setFont(new Font("Unispace", Font.BOLD, 14));
	
		addComponentListener(new ComponentAdapter() {
			
		});
		setLayout(null);
		
		DefaultTableModel modelo;
		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Usuario");
		modelo.addColumn("Contraseña");
		modelo.addColumn("Rol");
		modelo.addColumn("Estado");
		
		
		JLabel lblIdDelUsuario = new JLabel("Id del Usuario:");
		lblIdDelUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblIdDelUsuario.setBounds(27, 77, 118, 14);
		add(lblIdDelUsuario);
		
		JLabel lblNombre = new JLabel("Usuario:");
		lblNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNombre.setBounds(27, 108, 82, 14);
		add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblContrasea.setBounds(27, 142, 82, 14);
		add(lblContrasea);
		
		JLabel lblRepetirContrasea = new JLabel("Repetir Contrase\u00F1a:");
		lblRepetirContrasea.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblRepetirContrasea.setBounds(27, 173, 152, 14);
		add(lblRepetirContrasea);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblRol.setBounds(27, 206, 82, 14);
		add(lblRol);

				
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblBuscar.setBounds(56, 231, 53, 17);
		add(lblBuscar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(210, 139, 130, 20);
		add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(210, 170, 130, 20);
		add(passwordField_1);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(210, 74, 130, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(210, 105, 130, 20);
		add(textField_1);
		
		JList list = new JList();
		list.setBounds(168, 221, 118, -31);
		add(list);
		
		textField_4 = new JTextField();
		textField_4.setBounds(119, 229, 201, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 259, 489, 155);
		add(scrollPane);
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		
		Choice choice = new Choice();
		choice.setBounds(210, 196, 130, 20);
		add(choice);
		
		choice.add("Administrador");
		choice.add("Moza");
		
		JButton btnEliminar = new JButton("Guardar");
		btnEliminar.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnEliminar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "¿Desea agregar un nuevo usuario?","Precaución",dialogButton); //pregunta 
				
				if(dialogResult == JOptionPane.YES_OPTION){
				
				if(textField_1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Falta el campo Usuario"); //validacion de campo
					textField_1.requestFocusInWindow();
					return;
				}
				
				String con = new String (passwordField.getPassword());
				String conpass = new String(passwordField_1.getPassword());
				
				if(con.contentEquals("") ) {
					JOptionPane.showMessageDialog(null, "Falta ingresar el campo Contraseña");//validacion de campo
					passwordField.requestFocusInWindow();
					return;
				}
				if(conpass.equals("") ) {
					JOptionPane.showMessageDialog(null, "Falta confirmar la Contraseña");//validacion de campo
					passwordField_1.requestFocusInWindow();
					return;
				}
				
				if(!con.equals(conpass)) {
					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");//validacion de campo
					passwordField.setText("");
					passwordField_1.setText("");
					passwordField.requestFocusInWindow();
					return;
				}
				
				
				Usuario usuario = new Usuario();
				
				
				char [] array = passwordField.getPassword();
				String pass = new String(array);
				usuario.altaUsuario(
						textField_1.getText(),
						pass,
						choice.getSelectedItem() 
						);
				}
				textField_1.setText("");
				passwordField.setText("");  //limpieza de los campos
				passwordField_1.setText("");
				btnEliminar.setEnabled(false);
				//btnCancelar.setEnabled(false);
				cargaTabla();
				
			
				if(dialogResult == JOptionPane.NO_OPTION) {
						
							textField_1.setEnabled(false);
							passwordField.setEnabled(false);  //bloqueo de los botones
							passwordField_1.setEnabled(false);
							choice.setEnabled(false);
							
							textField_1.setText("");
							passwordField.setText("");  //limpieza de los campos
							passwordField_1.setText("");
												
				}
						
			cargaTabla();		//Carga de la variable 
			}
		});
		
		btnEliminar.setBounds(408, 96, 104, 23);
		add(btnEliminar);
				
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "¿Desea actualizar este usuario?","Precaución",dialogButton); //pregunta
				
				if(dialogResult == JOptionPane.YES_OPTION){
				  
					int column = 0;
					int row = table.getSelectedRow();

					int id = Integer.parseInt(table.getModel().getValueAt(row, column).toString());
					Usuario usuario= new Usuario();
					char [] array = passwordField.getPassword();
					String pass = new String(array);
					usuario.modificarUsuario(textField_1.getText(), pass, id, choice.getSelectedItem());
					
					
					cargaTabla(); 					//variable para recargar la tabla
					textField_1.setText("");
					passwordField.setText(""); //limpieza del formulario
					passwordField_1.setText("");
				}
				
				if(dialogResult == JOptionPane.NO_OPTION) {
						
							textField_1.setEnabled(false);
							passwordField.setEnabled(false); //bloqueo de los botones
							passwordField_1.setEnabled(false);
							choice.setEnabled(false);
														
							textField_1.setText("");
							passwordField.setText("");//limpieza del formulario
							passwordField_1.setText("");
						}
				}
		}
		);
		
		btnActualizar.setBounds(408, 163, 104, 23);
		add(btnActualizar);
		
		JButton btnNewButton = new JButton("Habilitar");
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					int column = 0;
					int row = table.getSelectedRow();
					int id = Integer.parseInt(table.getModel().getValueAt(row, column).toString());
					String valor = btnNewButton.getText();
					Usuario habilitar = new Usuario();	
					
					if(valor == "Deshabilitar") {
						habilitar.habilitarUsuario(valor, id);					//habilitacion del usario 

					} else {
						habilitar.habilitarUsuario(valor, id);

					}
					cargaTabla();										//Llama a la variable de abajo y recarga la tabla 
					
					
		
						
					}	

				

			
			

			}
		
		);
		btnNewButton.setBounds(408, 197, 104, 23);
		add(btnNewButton);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int column1 = 0;
				int column2 = 1;
				int column3 = 2;
				int column4 = 3;
				int column5 = 4;
				
				btnActualizar.setText("Actualizar");
				int row = table.getSelectedRow();
				String value1 = table.getModel().getValueAt(row, column1).toString();
				String value2 = table.getModel().getValueAt(row, column2).toString();
				String value3 = table.getModel().getValueAt(row, column3).toString();    //carga de los datos
				String value4 = table.getModel().getValueAt(row, column4).toString();
				String value5 = table.getModel().getValueAt(row, column5).toString();

				textField.setText(value1);
				textField_1.setText(value2);
				passwordField.setText(value3);
				choice.select(value4);
				choice.repaint();
				
				btnActualizar.setEnabled(true);
				textField_1.setEnabled(true);
				passwordField.setEnabled(true);
				passwordField_1.setEnabled(false);
				
												
				if(value5 == "true") {
					btnNewButton.setText("Deshabilitar");
					btnNewButton.setEnabled(true);
				}else {
					btnNewButton.setText("Habilitar");
					btnNewButton.setEnabled(true);
				}
			}
		}
		);
				
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		
		btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				cargaTabla();
				}
			}
		);
		btnBuscar.setBounds(348, 228, 89, 23);
		add(btnBuscar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnCancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				textField_1.setEnabled(false);
				passwordField.setEnabled(false);
				passwordField_1.setEnabled(false);
				
				//btnNuevo.setEnabled(true);
				btnCancelar.setEnabled(false);
				btnActualizar.setEnabled(false);
				btnEliminar.setEnabled(false); 	//bloqueo de los botones
				btnNewButton.setEnabled(false);
				choice.setEnabled(false);
				
				textField_1.setText("");
				passwordField.setText("");  //limpieza del formulario
				passwordField_1.setText("");
				}
			}
		);
		btnCancelar.setBounds(408, 130, 104, 23);
		add(btnCancelar);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setEnabled(true);
				passwordField.setEnabled(true);			//habilitacion de los botones
				passwordField_1.setEnabled(true);
				choice.setEnabled(true);
				
				btnNuevo.setEnabled(true);
			
				btnCancelar.setEnabled(true);
				btnActualizar.setEnabled(false);
				btnEliminar.setEnabled(true);
				btnNewButton.setEnabled(false);
				textField_1.setText("");
				passwordField.setText("");			//limpieza del formulario
				passwordField_1.setText("");
				}
			}
		);
		
		btnNuevo.setBounds(408, 66, 104, 23);
		add(btnNuevo);
				


		cargaTabla();	//variable para cargar la tabla en el inicio

		
		table.setModel(modelo);

		ResultSet rs;
		
		Usuario usuario = new Usuario();
		rs = usuario.buscarUsuario(textField_4.getText());
		try {
			while(rs.next()) {
				modelo.addRow(new Object[]{
						rs.getObject("id"),
						rs.getObject("usuario"),
						rs.getObject("contraseña"),
						rs.getObject("rol"),
						rs.getObject("Estado")
						}
				);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}


		textField_1.setEnabled(false);
		passwordField.setEnabled(false);
		passwordField_1.setEnabled(false);
		choice.setEnabled(false);
		
		//btnNuevo.setEnabled(true);
		btnCancelar.setEnabled(false);
		btnActualizar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnNewButton.setEnabled(false);
		choice.setEnabled(false);
		
		textField_1.setText("");
		passwordField.setText("");
		passwordField_1.setText("");
		
		JLabel lblAltamodificacinUsuarios = new JLabel("Alta/Modificaci\u00F3n usuarios");
		lblAltamodificacinUsuarios.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblAltamodificacinUsuarios.setBounds(27, 23, 238, 14);
		add(lblAltamodificacinUsuarios);
		
	
	}
	public void cargaTabla() {				//Variable para recargar la tabla 

		DefaultTableModel modelo;
		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Usuario");
		modelo.addColumn("Contraseña");
		modelo.addColumn("Rol");
		modelo.addColumn("Estado");
		table.setModel(modelo);
	
		ResultSet rs;
		
		
		Usuario usuario2 = new Usuario();
		rs = usuario2.buscarUsuario(textField_4.getText());
		try {
			while(rs.next()) {
				modelo.addRow(new Object[]{
						rs.getObject("id"),
						rs.getObject("usuario"),
						rs.getObject("contraseña"),
						rs.getObject("rol"), 
						rs.getObject("Estado")});
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}
	
}
