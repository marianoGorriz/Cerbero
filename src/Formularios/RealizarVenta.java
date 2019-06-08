package Formularios;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Clases.Cliente;
import Clases.Producto;
import Clases.Tarjeta;
import Clases.Venta;
import Clases.Impresion;

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
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel.setBounds(26, 95, 75, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(101, 92, 127, 20);
		add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 143, 308, 120);		

		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnNewButton.setBounds(231, 91, 103, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarTablaProductos();
			}
		});
		add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel_1.setBounds(183, 120, 151, 14);
		add(lblNewLabel_1);



		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(26, 274, 308, 120);
		add(scrollPane2);
				
		table_1 = new JTable();
		scrollPane2.setViewportView(table_1);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		MiModelo modelo = new MiModelo();
		modelo.addColumn("id");
		modelo.addColumn("Producto");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio");
		modelo.addColumn("Cantidad puntos");
		table_1.setModel(modelo);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(408, 208, 37, 20);
		add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JButton btnRealizarVenta = new JButton("Realizar venta");
		btnRealizarVenta.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		
		JButton btnEliminarProducto = new JButton("Eliminar");
		btnEliminarProducto.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		
		JLabel lblNewLabel_2 = new JLabel("Total puntos:");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 13));

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
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
		

		btnAgregar.setBounds(453, 207, 96, 23);
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
		
		lblNewLabel_2.setBounds(344, 303, 184, 14);
		add(lblNewLabel_2);
		
		
		btnRealizarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "¿Desea realizar una nueva venta?","Precaución",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					
					if(txtNroTarjeta.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Falta el campo N° Tarjeta.");
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
								JOptionPane.showMessageDialog(null, "No has agregado ningún producto.");
								return;
							}else {
								Tarjeta tarjeta = new Tarjeta();
								ResultSet rs;
								rs = tarjeta.busquedaTarjetaVenta(Integer.parseInt(txtNroTarjeta.getText()));
								int filas_tabla_1 = modelo.getRowCount();
								float puntos_total = 0;
	
								for(int i = 0; i < filas_tabla_1;i++)
								{
									puntos_total = puntos_total + Float.parseFloat(table_1.getModel().getValueAt(i, 4).toString()) ;
								}
								
								frmLogin idUser = new frmLogin();
								
								
								int id_ventas_tarjetas = 0;
								int puntos_acumulados = 0;
								try {
									if(rs.first()) {
										id_ventas_tarjetas = (int) rs.getObject("tarjetas.id");
										puntos_acumulados = (int) rs.getObject("tarjetas.puntos_acumulados");
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
								
								long tsTime2 = 0;
								try {
									if(rs.first()) {
									java.sql.Timestamp ts2 = java.sql.Timestamp.valueOf(rs.getString("ultima_compra"));
									tsTime2 = ts2.getTime();
									}
									
								}catch (SQLException e1) {
									e1.printStackTrace();
								}
								
								long x = 2592000000L;
														
								Tarjeta tarjeta2 = new Tarjeta();
								ResultSet rs2;
								rs2 = tarjeta2.buscarTarjetasActivas(txtNroTarjeta.getText());
								String vip = "nada";
								try {
									while(rs2.next()) {
										vip = rs2.getObject("tarjetas.vip").toString();
									}
								} catch (SQLException e1) {
									
									e1.printStackTrace();
								}
								
								if (System.currentTimeMillis() >= tsTime2 + x && vip.equals("0")) {
									JOptionPane.showMessageDialog(null, "No has realizado una compra en los últimos 30 días. Sus puntos se restablecieron a 0.");
									venta.eliminarPuntos(id_ventas_usuarios, id_ventas_tarjetas, total_puntos, tipo, fecha);
								} else {
									venta.realizarVenta(id_ventas_usuarios, id_ventas_tarjetas, total_puntos, tipo, fecha);
									JOptionPane.showMessageDialog(null, "Venta realizada exitosamente.");
									int dialogButton2 = JOptionPane.YES_NO_OPTION;
									int dialogResult2 = JOptionPane.showConfirmDialog (null, "¿Desea imprimir un ticket de venta?","Precaución",dialogButton2);
									if(dialogResult2 == JOptionPane.YES_OPTION){
										Cliente cliente = new Cliente();
										ResultSet rs3;
										rs3 = cliente.buscarCliente(txtNroTarjeta.getText());
										String nombre = "";
										String apellido = "";
										try {
											while(rs3.next()) {
												nombre = rs3.getObject("clientes.nombre").toString();
												apellido = rs3.getObject("clientes.apellido").toString();
											}
										}catch (SQLException e1) {
											e1.printStackTrace();
										}
										//ENVIAR ESTOS DATOS A imprimirTicket()
										Impresion imp = new Impresion();										
										imp.imprimirTicket(nombre, apellido, txtNroTarjeta.getText(), puntos_acumulados, total_puntos, 0);
										/**System.out.println("Gilada de cerbero " );
										System.out.println("CUIL " );
										
										System.out.println(nombre + " " + apellido);
										System.out.println("Tarjeta N° " + txtNroTarjeta.getText() );
										
										System.out.println("Puntos acumulados: " + puntos_acumulados);
										System.out.println("Puntos por su compra: " + total_puntos);
										System.out.println("Total puntos: " + (puntos_acumulados + total_puntos));*/
										
									} else {
										
									}
								}
								
								int filas = modelo.getRowCount();
								for(int i = 0; i<filas; i++) {
									int id_detalleVenta_venta = venta.ultimaVenta();
									int id_detalleVenta_producto = Integer.parseInt(modelo.getValueAt(i, 0).toString());
									int cantidad = Integer.parseInt(modelo.getValueAt(i, 2).toString());
									venta.insertarDetalleVenta(id_detalleVenta_venta, id_detalleVenta_producto, cantidad);
								}
								
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
		btnRealizarVenta.setBounds(344, 328, 133, 23);
		add(btnRealizarVenta);
		
		txtNroTarjeta = new JTextField();
		txtNroTarjeta.setBounds(152, 36, 147, 20);
		add(txtNroTarjeta);
		txtNroTarjeta.setColumns(10);
		
		JLabel lblNTarjeta = new JLabel("N\u00B0 Tarjeta:");
		lblNTarjeta.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNTarjeta.setBounds(26, 39, 116, 14);
		add(lblNTarjeta);
		
		JLabel lblProductoSeleccionado = new JLabel("Producto seleccionado:");
		lblProductoSeleccionado.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblProductoSeleccionado.setBounds(26, 120, 184, 14);
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
		btnEliminarProducto.setBounds(344, 362, 133, 23);
		add(btnEliminarProducto);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblCantidad.setBounds(344, 211, 66, 14);
		add(lblCantidad);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblDni.setBounds(26, 70, 48, 14);
		add(lblDni);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(60, 67, 96, 20);
		txtDNI.setEnabled(false);
		add(txtDNI);
		txtDNI.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNombre.setBounds(166, 67, 62, 14);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(231, 67, 113, 20);
		txtNombre.setEnabled(false);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if(txtNroTarjeta.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Falta el campo N° Tarjeta.");
					txtNroTarjeta.requestFocusInWindow();
					return;
				}else {
					
					Tarjeta tarjeta = new Tarjeta();
					ResultSet rs;
					rs = tarjeta.busquedaTarjetaVenta(Integer.parseInt(txtNroTarjeta.getText()));
					try {
						if (rs.next() == false) {
							JOptionPane.showMessageDialog(null, "No se encontró la tarjeta ingresada.");
							txtNroTarjeta.requestFocusInWindow();
							txtNombre.setText("");
							txtDNI.setText("");
						}else
							if(rs.first()) {
								if(rs.getObject("estado").equals(0)) {
									
									java.sql.Timestamp ts2 = java.sql.Timestamp.valueOf(rs.getString("fecha_alta"));
									long tsTime2 = ts2.getTime();
									
									// Check time elapsed
									if (System.currentTimeMillis() >= tsTime2 + 24 * 60 * 60 * 1000) {
									    // time has elapsed
										tarjeta.activarTarjeta(txtNroTarjeta.getText());
										
										txtNombre.setText(rs.getObject("nombre").toString());
										txtDNI.setText(rs.getObject("dni").toString());
										llenarTablaProductos();

									} else {
										JOptionPane.showMessageDialog(null, "Tarjeta inactiva. Deben transcurrir 24 horas desde el alta de la misma.");
										txtNombre.setText("");
										txtDNI.setText("");
										return;
									}
								} else {
							
									txtNombre.setText(rs.getObject("nombre").toString());
									txtDNI.setText(rs.getObject("dni").toString());
									llenarTablaProductos();
								}
						}		

					}catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnBuscar.setBounds(309, 35, 89, 23);
		add(btnBuscar);
		
		btnAgregar.setEnabled(false);
		btnRealizarVenta.setEnabled(false);
		btnEliminarProducto.setEnabled(false);
		
		JLabel lblRealizarVenta = new JLabel("Realizar Venta");
		lblRealizarVenta.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblRealizarVenta.setBounds(26, 11, 173, 14);
		add(lblRealizarVenta);
		
		
	}
	
	public void llenarTablaProductos() {
		
		MiModelo modelo = new MiModelo();
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
	
	public class MiModelo extends DefaultTableModel{
		public boolean isCellEditable(int row, int column) {
			
			return false;
		}
	}
	
}
