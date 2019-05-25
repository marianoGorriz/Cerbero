package Formularios;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JTextField txtPromedio;

	/**
	 * Create the panel.
	 */
	public AltaProductos() {
		setLayout(null);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(10, 17, 76, 14);
		add(lblProducto);
		
		txtPromedio = new JTextField();
		txtPromedio.setBounds(261, 42, 96, 20);
		add(txtPromedio);
		txtPromedio.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(74, 14, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblPuntos = new JLabel("Puntos:");
		lblPuntos.setBounds(192, 17, 48, 14);
		add(lblPuntos);
		
		textField_1 = new JTextField();
		textField_1.setBounds(261, 14, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCargar = new JButton("Cargar");
		
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
					btnNewButton_1.setText("Habilitar");
					btnNewButton_1.setEnabled(false);
					btnCargar.setText("Cargar");
					textField.setText("");
					textField_1.setText("");
					txtPrecio.setText("");
					txtPromedio.setText("");
				} else {
					
					habilitar.habilitarProducto(valor, id);
					btnNewButton_1.setEnabled(false);
					btnCargar.setText("Cargar");
					textField.setText("");
					textField_1.setText("");
					txtPrecio.setText("");
					txtPromedio.setText("");
				}
				llenarTablaProductos();
			}
		});
		btnNewButton_1.setBounds(472, 144, 89, 23);
		add(btnNewButton_1);
		
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Producto producto = new Producto();
				if(btnCargar.getText() == "Cargar") {							
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "¿Desea agregar un nuevo producto?","Precaución",dialogButton);
					if(dialogResult == JOptionPane.YES_OPTION){
						
						if(textField.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Falta el campo Producto");
							textField_1.requestFocusInWindow();
							return;
						}else
						{
							if(textField_1.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "Falta el campo Puntos");
								textField_2.requestFocusInWindow();
								return;
							}else {
								if(txtPrecio.getText().equals("")) {
									JOptionPane.showMessageDialog(null, "Falta el campo Precio"); 
									txtPrecio.requestFocusInWindow();
									return;
								}else
								{
									if(txtPromedio.getText().equals("")) {
										JOptionPane.showMessageDialog(null, "Falta el campo Promedio"); 
										txtPromedio.requestFocusInWindow();
										return;
									} else {
										int precio = Integer.parseInt(txtPrecio.getText());
										producto.altaProducto(textField.getText(), Float.parseFloat(textField_1.getText()), precio, Float.parseFloat(txtPromedio.getText()));
										textField.setText("");
										textField_1.setText("");
										txtPrecio.setText("");
										txtPromedio.setText("");
										btnNewButton_1.setText("Habilitar");
										btnNewButton_1.setEnabled(false);
										JOptionPane.showMessageDialog(null, "Carga realizada correctamente."); 
									}
								}
							}
						}
					}	
				} else {
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "¿Desea actualizar el producto seleccionado?","Precaución",dialogButton);
					if(dialogResult == JOptionPane.YES_OPTION){
						
						if(textField.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Falta el campo Producto"); 
							textField_1.requestFocusInWindow();
							return;
						}else
						{
							if(textField_1.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "Falta el campo Puntos");
								textField_2.requestFocusInWindow();
								return;
							}else {
								if(txtPrecio.getText().equals("")) {
									JOptionPane.showMessageDialog(null, "Falta el campo Precio");
									txtPrecio.requestFocusInWindow();
									return;
								}else
								{
									if(txtPromedio.getText().equals("")) {
										JOptionPane.showMessageDialog(null, "Falta el campo Promedio"); 
										txtPromedio.requestFocusInWindow();
										return;
									} else {
										
										btnNewButton_1.setText("Habilitar");
										btnNewButton_1.setEnabled(false);
										int precio = Integer.parseInt(txtPrecio.getText());
										int column = 0;
										int row = table.getSelectedRow();
										int id = Integer.parseInt(table.getModel().getValueAt(row, column).toString());
										producto.modificarProducto(textField.getText(), Float.parseFloat(textField_1.getText()), id, precio,Float.parseFloat(txtPromedio.getText()));
										btnCargar.setText("Cargar");
										textField.setText("");
										textField_1.setText("");
										txtPrecio.setText("");
										txtPromedio.setText("");
										JOptionPane.showMessageDialog(null, "Actualización realizada correctamente."); 
									}
								}
							}
						}
					}

				}
				llenarTablaProductos();
			}
		});
		btnCargar.setBounds(10, 70, 96, 23);
		add(btnCargar);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 144, 452, 185);
		add(scrollPane);
		
		table = new JTable();

		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 113, 347, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarTablaProductos();
			}
		});
		btnNewButton.setBounds(373, 112, 89, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Precio:");
		lblNewLabel.setBounds(10, 45, 48, 14);
		add(lblNewLabel);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(74, 42, 96, 20);
		add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblPromedio = new JLabel("Promedio:");
		lblPromedio.setBounds(192, 45, 59, 14);
		add(lblPromedio);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnNewButton_1.setText("Habilitar");
				btnNewButton_1.setEnabled(false);
				btnCargar.setText("Cargar");
				textField.setText("");
				textField_1.setText("");
				txtPrecio.setText("");
				txtPromedio.setText("");
				
			}
		});
		btnCancelar.setBounds(116, 70, 89, 23);
		add(btnCancelar);
		
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int column1 = 1;
				int column2 = 2;
				int column3 = 3;
				int column4 = 4;
				int column5 = 5;
				btnCargar.setText("Actualizar");
				int row = table.getSelectedRow();
				
				String value1 = table.getModel().getValueAt(row, column1).toString();
				String value2 = table.getModel().getValueAt(row, column2).toString();
				String value3 = table.getModel().getValueAt(row, column3).toString();
				String value4 = table.getModel().getValueAt(row, column4).toString();
				String value5 = table.getModel().getValueAt(row, column5).toString();

				textField.setText(value1);
				textField_1.setText(value2);
				txtPrecio.setText(value3);
				txtPromedio.setText(value4);
				
				if(value5 == "true") {
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
		modelo.addColumn("Precio");
		modelo.addColumn("Porcentaje");
		modelo.addColumn("Estado");
		table.setModel(modelo);
		ResultSet rs;
		Producto busqueda = new Producto();
		rs = busqueda.buscarProducto(textField_2.getText());
		
		try {
			while(rs.next()) {
				
				modelo.addRow(new Object[]{rs.getObject("id"), rs.getObject("nombre"), rs.getObject("puntos_actual"), rs.getObject("precio"), rs.getObject("porcentaje_puntos"), rs.getObject("estado")});
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}
}
