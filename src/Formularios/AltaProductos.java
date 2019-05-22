package Formularios;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Clases.Producto;
import Vistas.Conexion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class AltaProductos extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JTextField txtPrecio;

	/**
	 * Create the panel.
	 */
	public AltaProductos() {
		setLayout(null);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(10, 11, 76, 14);
		add(lblProducto);
		
		textField = new JTextField();
		textField.setBounds(74, 8, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblPuntos = new JLabel("Puntos:");
		lblPuntos.setBounds(10, 42, 48, 14);
		add(lblPuntos);
		
		textField_1 = new JTextField();
		textField_1.setBounds(74, 39, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int precio = Integer.parseInt(txtPrecio.getText());
				Producto producto = new Producto();
				if(btnCargar.getText() == "Cargar") {
					producto.altaProducto(textField.getText(), Float.parseFloat(textField_1.getText()), precio);
				} else {
					int column = 0;
					int row = table.getSelectedRow();
					int id = Integer.parseInt(table.getModel().getValueAt(row, column).toString());
					producto.modificarProducto(textField.getText(), Float.parseFloat(textField_1.getText()), id, precio);
					btnCargar.setText("Cargar");
					textField.setText("");
					textField_1.setText("");
					txtPrecio.setText("");
				}
				llenarTablaProductos();
			}
		});
		btnCargar.setBounds(10, 110, 96, 23);
		add(btnCargar);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 175, 401, 185);
		add(scrollPane);
		
		table = new JTable();

		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 144, 271, 20);
		add(textField_2);
		textField_2.setColumns(10);
		

		
		JButton btnNewButton_1 = new JButton("Habilitar");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column = 0;
				int row = table.getSelectedRow();
				int id = Integer.parseInt(table.getModel().getValueAt(row, column).toString());
				String valor = btnNewButton_1.getText();
				Producto habilitar = new Producto();				
				if(valor == "Deshabilitar") {
					habilitar.habilitarProducto(valor, id);
				} else {
					habilitar.habilitarProducto(valor, id);
				}
				llenarTablaProductos();
			}
		});
		btnNewButton_1.setBounds(421, 172, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarTablaProductos();
			}
		});
		btnNewButton.setBounds(291, 143, 89, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Precio");
		lblNewLabel.setBounds(10, 73, 48, 14);
		add(lblNewLabel);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(74, 70, 96, 20);
		add(txtPrecio);
		txtPrecio.setColumns(10);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int column1 = 1;
				int column2 = 2;
				int column3 = 3;
				int column4 = 4;
				btnCargar.setText("Actualizar");
				int row = table.getSelectedRow();
				String value1 = table.getModel().getValueAt(row, column1).toString();
				String value2 = table.getModel().getValueAt(row, column2).toString();
				String value3 = table.getModel().getValueAt(row, column3).toString();
				String value4 = table.getModel().getValueAt(row, column4).toString();

				textField.setText(value1);
				textField_1.setText(value2);
				txtPrecio.setText(value4);
				if(value3 == "true") {
					btnNewButton_1.setText("Deshabilitar");
					btnNewButton_1.setEnabled(true);
				}else {
					btnNewButton_1.setText("Habilitar");
					btnNewButton_1.setEnabled(true);
				}
			}
		});
		
		llenarTablaProductos();
	}
	
	public void llenarTablaProductos() {
		DefaultTableModel modelo;
		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Producto");
		modelo.addColumn("Puntos");
		modelo.addColumn("Estado");
		modelo.addColumn("Precio");
		table.setModel(modelo);
		ResultSet rs;
		Producto busqueda = new Producto();
		rs = busqueda.buscarProducto(textField_2.getText());
		try {
			while(rs.next()) {
				modelo.addRow(new Object[]{rs.getObject("id"), rs.getObject("nombre"), rs.getObject("puntos_actual"), rs.getObject("estado"), rs.getObject("precio")});
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
