package Formularios;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
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

public class PanelUsuarios extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelUsuarios() {
		setLayout(null);
		
		JLabel lblIdDelUsuario = new JLabel("Id del Usuario:");
		lblIdDelUsuario.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 13));
		lblIdDelUsuario.setBounds(29, 26, 82, 14);
		add(lblIdDelUsuario);
		
		JLabel lblNombre = new JLabel("Usuario:");
		lblNombre.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 13));
		lblNombre.setBounds(29, 60, 82, 14);
		add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 13));
		lblContrasea.setBounds(29, 96, 82, 14);
		add(lblContrasea);
		
		JLabel lblRepetirContrasea = new JLabel("Repetir Contrase\u00F1a:");
		lblRepetirContrasea.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 13));
		lblRepetirContrasea.setBounds(29, 132, 98, 14);
		add(lblRepetirContrasea);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 13));
		lblRol.setBounds(29, 166, 82, 14);
		add(lblRol);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(154, 23, 130, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(154, 57, 130, 20);
		add(textField_1);
		
		JList list = new JList();
		list.setBounds(168, 221, 118, -31);
		add(list);
		
		textField_4 = new JTextField();
		textField_4.setBounds(79, 197, 177, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 239, 489, 155);
		add(scrollPane);
		table = new JTable();
		
		JButton btnEliminar = new JButton("Desabilitar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEliminar.setBounds(410, 128, 104, 23);
		add(btnEliminar);
		
		
		Choice choice = new Choice();
		choice.setBounds(154, 160, 130, 20);
		add(choice);
		choice.add("Administrador");
		choice.add("Moza");
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column = 0;
				int row = table.getSelectedRow();

				int id = Integer.parseInt(table.getModel().getValueAt(row, column).toString());
				Usuario usuario= new Usuario();
				char [] array = passwordField.getPassword();
				String pass = new String(array);
				usuario.modificarUsuario(textField_1.getText(), pass, id, choice.getSelectedItem());
				
				//btnActualizar.setText("Nuevo");
				//textField.setText("");
				//textField_1.setText("");
			}
		});
		
		btnActualizar.setBounds(410, 60, 104, 23);
		add(btnActualizar);
		
		JButton btnNewButton = new JButton("Habilitar");
		btnNewButton.setBounds(410, 92, 104, 23);
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
				String value3 = table.getModel().getValueAt(row, column3).toString();
				String value4 = table.getModel().getValueAt(row, column4).toString();
				String value5 = table.getModel().getValueAt(row, column5).toString();

				textField.setText(value1);
				textField_1.setText(value2);
				passwordField.setText(value3);
				choice.select(value4);
				choice.repaint();
				
				
				if(value5 == "true") {
					btnEliminar.setText("Deshabilitar");
					btnEliminar.setEnabled(true);
				}else {
					btnNewButton.setText("Habilitar");
					btnNewButton.setEnabled(false);
				}
				
				
			}
		});
		
		
		
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JButton btnBuscar = new JButton("Buscar");
		
		btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel modelo;
					modelo = new DefaultTableModel();
					modelo.addColumn("ID");
					modelo.addColumn("Usuario");
					modelo.addColumn("Contraseña");
					modelo.addColumn("Rol");
					modelo.addColumn("Estado");
					table.setModel(modelo);
				//	modelo.addRow(new Object[]{"ID", "Usuario", "Contraseña", "Rol","Estado"});
					ResultSet rs;
					Usuario usuario = new Usuario();
					rs = usuario.buscarUsuario(textField_4.getText());
					try {
						while(rs.next()) {
							modelo.addRow(new Object[]{rs.getObject("id"), rs.getObject("usuario"), rs.getObject("contraseña"), rs.getObject("rol"), rs.getObject("Estado")});
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
		});
		btnBuscar.setBounds(296, 197, 89, 23);
		add(btnBuscar);
		


		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario();
				
				
					char [] array = passwordField.getPassword();
					String pass = new String(array);
					usuario.altaUsuario(textField_1.getText(), pass, choice.getSelectedItem() );
					
				
					
				
			}
		});
		btnNuevo.setBounds(410, 26, 104, 23);
		add(btnNuevo);
		
		
		

		
		passwordField = new JPasswordField();
		passwordField.setBounds(154, 93, 130, 20);
		add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(154, 129, 130, 20);
		add(passwordField_1);
		
	
		
		
		
		
		


	}
}
