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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Choice;
import java.awt.List;
import java.awt.ComponentOrientation;

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
		lblIdDelUsuario.setBounds(33, 50, 82, 14);
		add(lblIdDelUsuario);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 13));
		lblNombre.setBounds(33, 84, 82, 14);
		add(lblNombre);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 13));
		lblContrasea.setBounds(33, 120, 82, 14);
		add(lblContrasea);
		
		JLabel lblRepetirContrasea = new JLabel("Repetir Contrase\u00F1a:");
		lblRepetirContrasea.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 13));
		lblRepetirContrasea.setBounds(33, 156, 98, 14);
		add(lblRepetirContrasea);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 13));
		lblRol.setBounds(33, 190, 82, 14);
		add(lblRol);
		
		textField = new JTextField();
		textField.setBounds(158, 47, 130, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(158, 81, 130, 20);
		add(textField_1);
		
		JList list = new JList();
		list.setBounds(168, 221, 118, -31);
		add(list);
		
		textField_4 = new JTextField();
		textField_4.setBounds(83, 221, 177, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(300, 221, 89, 23);
		add(btnBuscar);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(410, 46, 104, 23);
		add(btnNuevo);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(410, 80, 104, 23);
		add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(410, 116, 104, 23);
		add(btnEliminar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(410, 152, 104, 23);
		add(btnCancelar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 117, 130, 20);
		add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(158, 153, 130, 20);
		add(passwordField_1);
		
		Choice choice = new Choice();
		choice.setBounds(158, 184, 130, 20);
		add(choice);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Rol", "Contrase\u00F1a", "Nombre"
			}
		));
		table.setBounds(33, 414, 502, -129);
		add(table);

	}
}
