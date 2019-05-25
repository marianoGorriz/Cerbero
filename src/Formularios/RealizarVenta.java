package Formularios;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Clases.Producto;
import Clases.Tarjeta;
import Clases.Venta;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import java.awt.Font;

public class RealizarVenta extends JPanel {
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JTextField txtCantidad;
	private JTextField txtNroTarjeta;
	private JTextField txtDNI;
	private JTextField txtNombre;
	private JButton btnNewButton;
	private JButton btnAgregar;
	private JButton btnRealizarVenta;
	private JButton btnEliminarProducto;

	/**
	 * Create the panel.
	 */
	public RealizarVenta() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Productos:");
		lblNewLabel.setBounds(10, 92, 75, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(72, 89, 133, 20);
		add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 308, 120);		

		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(215, 88, 103, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarTablaProductos();
			}
		});
		add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(477, 117, 133, 14);
		add(lblNewLabel_1);



		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 248, 308, 120);
		add(scrollPane2);
				
		table_1 = new JTable();
		scrollPane2.setViewportView(table_1);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		DefaultTableModel modelo;
		modelo = new DefaultTableModel();
		modelo.addColumn("id");
		modelo.addColumn("Producto");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio");
		modelo.addColumn("Cantidad puntos");
		table_1.setModel(modelo);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(390, 140, 37, 20);
		add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JButton btnRealizarVenta = new JButton("Realizar venta");
		
		JButton btnEliminarProducto = new JButton("Eliminar");
		
		JLabel lblNewLabel_2 = new JLabel("Total puntos:");

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if(txtCantidad.getText().equals("")) {
						
						JOptionPane.showMessageDialog(null, "Por favor, seleccione la cantidad.");
						txtCantidad.requestFocusInWindow();
						return;
					}else
					{
						int row = table.getSelectedRow();
						float puntos = (float) table.getModel().getValueAt(row, 2);
						int cantidad = Integer.parseInt(txtCantidad.getText());
						int precio = Integer.parseInt(table.getModel().getValueAt(row, 3).toString());
						modelo.addRow(new Object[]{table.getModel().getValueAt(row, 0).toString(),table.getModel().getValueAt(row, 1).toString(),txtCantidad.getText(), table.getModel().getValueAt(row, 3).toString(),cantidad*precio*puntos});
						int filas_tabla_1 = modelo.getRowCount();
						int puntos_total = 0;

						for(int i = 0; i < filas_tabla_1;i++)
						{
							puntos_total = (int) (puntos_total + Float.parseFloat(table_1.getModel().getValueAt(i, 4).toString())) ;
						}
						
						lblNewLabel_2.setText("Total puntos: " + puntos_total);
						txtCantidad.setText("");
						btnAgregar.setEnabled(false);
						btnRealizarVenta.setEnabled(true);
						btnEliminarProducto.setEnabled(true);
						lblNewLabel_1.setText("");
					}
				}
		});
		

		btnAgregar.setBounds(437, 139, 96, 23);
		add(btnAgregar);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				int column1 = 0;
				int column2 = 1;
				int column3 = 2;
				int row = table.getSelectedRow();
				
				String value1 = table.getModel().getValueAt(row, column1).toString();
				String value2 = table.getModel().getValueAt(row, column2).toString();
				String value3 = table.getModel().getValueAt(row, column3).toString();

				lblNewLabel_1.setText(value2); 
				btnAgregar.setEnabled(true);
			}
		});
		
		lblNewLabel_2.setBounds(328, 258, 184, 14);
		add(lblNewLabel_2);
		
		
		btnRealizarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "�Desea realizar una nueva venta?","Precauci�n",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					
					if(txtNroTarjeta.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Falta el campo N� Tarjeta.");
						txtNroTarjeta.requestFocusInWindow();
						return;
					}else
					{
						if(txtDNI.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "La tarjeta ingresada no existe.");
							txtDNI.requestFocusInWindow();
							return;
						}else
						{
							if(modelo.getRowCount() == 0) {
								JOptionPane.showMessageDialog(null, "No has agregado ning�n producto.");
								return;
							}else {
								int filas_tabla_1 = modelo.getRowCount();
								float puntos_total = 0;
	
								for(int i = 0; i < filas_tabla_1;i++)
								{
									puntos_total = puntos_total + Float.parseFloat(table_1.getModel().getValueAt(i, 4).toString()) ;
								}
								
								frmLogin idUser = new frmLogin();
								
								Tarjeta tarjeta = new Tarjeta();
								ResultSet rs;
								rs = tarjeta.busquedaTarjetaVenta(Integer.parseInt(txtNroTarjeta.getText()));
								int id_ventas_tarjetas = 0;
								try {
									while(rs.next()) {
										id_ventas_tarjetas = (int) rs.getObject("tarjetas.id");
									}
								}catch (SQLException e1) {
									e1.printStackTrace();
								}
								
								int id_ventas_usuarios = idUser.id;
								
								int total_puntos = (int) puntos_total;
								Venta venta = new Venta();
								int tipo = 1; //VENTA
								SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
								Date date = new Date(System.currentTimeMillis());  
								String fecha = formatter.format(date);
								venta.realizarVenta(id_ventas_usuarios, id_ventas_tarjetas, total_puntos, tipo, fecha);
								
								int filas = modelo.getRowCount();
								for(int i = 0; i<filas; i++) {
									int id_detalleVenta_venta = venta.ultimaVenta();
									int id_detalleVenta_producto = Integer.parseInt(modelo.getValueAt(i, 0).toString());
									int cantidad = Integer.parseInt(modelo.getValueAt(i, 2).toString());
									venta.insertarDetalleVenta(id_detalleVenta_venta, id_detalleVenta_producto, cantidad);
								}
								JOptionPane.showMessageDialog(null, "Venta realizada exitosamente.");
								btnRealizarVenta.setEnabled(false);
								btnEliminarProducto.setEnabled(false);
								for(int i = filas; i>0; i--) {
									modelo.removeRow(i-1);
								}
								txtDNI.setText("");
								txtNroTarjeta.setText("");
								txtNombre.setText("");
								lblNewLabel_2.setText("Total puntos: 0");
							}
						}
					}
				}
			}
		});
		btnRealizarVenta.setBounds(328, 283, 116, 23);
		add(btnRealizarVenta);
		
		txtNroTarjeta = new JTextField();
		txtNroTarjeta.setBounds(72, 11, 147, 20);
		add(txtNroTarjeta);
		txtNroTarjeta.setColumns(10);
		
		JLabel lblNTarjeta = new JLabel("N\u00B0 Tarjeta:");
		lblNTarjeta.setBounds(10, 11, 64, 14);
		add(lblNTarjeta);
		
		JLabel lblProductoSeleccionado = new JLabel("Producto seleccionado:");
		lblProductoSeleccionado.setBounds(328, 118, 139, 14);
		add(lblProductoSeleccionado);
		
		
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table_1.getSelectedRow();
				modelo.removeRow(row);
				int filas_tabla_1 = modelo.getRowCount();
				int puntos_total = 0;

				for(int i = 0; i < filas_tabla_1;i++)
				{
					puntos_total = (int) (puntos_total + Float.parseFloat(table_1.getModel().getValueAt(i, 4).toString())) ;
				}
				
				lblNewLabel_2.setText("Total puntos: " + puntos_total);
			}
		});
		btnEliminarProducto.setBounds(328, 317, 111, 23);
		add(btnEliminarProducto);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(328, 143, 66, 14);
		add(lblCantidad);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 45, 48, 14);
		add(lblDni);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(41, 42, 96, 20);
		txtDNI.setEnabled(false);
		add(txtDNI);
		txtDNI.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(150, 45, 62, 14);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(205, 42, 113, 20);
		txtNombre.setEnabled(false);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if(txtNroTarjeta.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Falta el campo N� Tarjeta.");
					txtNroTarjeta.requestFocusInWindow();
					return;
				}else {
					
					Tarjeta tarjeta = new Tarjeta();
					ResultSet rs;
					rs = tarjeta.busquedaTarjetaVenta(Integer.parseInt(txtNroTarjeta.getText()));
					try {
						if (rs.next() == false) {
							JOptionPane.showMessageDialog(null, "No se encontr� la tarjeta ingresada.");
							txtNroTarjeta.requestFocusInWindow();
							txtNombre.setText("");
							txtDNI.setText("");
						}else
							if(rs.first()) {
							
							txtNombre.setText(rs.getObject("nombre").toString());
							txtDNI.setText(rs.getObject("dni").toString());
							llenarTablaProductos();
						}		

					}catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnBuscar.setBounds(229, 10, 89, 23);
		add(btnBuscar);
		
		btnAgregar.setEnabled(false);
		btnRealizarVenta.setEnabled(false);
		btnEliminarProducto.setEnabled(false);
		
		
	}
	
	public void llenarTablaProductos() {
		DefaultTableModel modelo;
		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Producto");
		modelo.addColumn("Porcentaje");
		modelo.addColumn("Precio");
		table.setModel(modelo);
		ResultSet rs;
		Venta busqueda = new Venta();
		rs = busqueda.buscarProducto(textField.getText());
		try {
			while(rs.next()) {
				modelo.addRow(new Object[]{rs.getObject("id"), rs.getObject("nombre"), rs.getObject("porcentaje_puntos"), rs.getObject("precio")});
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
}
