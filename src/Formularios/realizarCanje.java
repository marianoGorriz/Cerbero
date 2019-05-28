package Formularios;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Clases.Producto;
import Clases.Tarjeta;
import Clases.Venta;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class realizarCanje extends JPanel {
	private JTextField txtNumeroTarjeta;
	private JTextField txtDni;
	private JTextField txtPuntos;
	private JTable table;
	private JTextField txtCantidad;
	private JTable table_1;
	private int puntos_total;

	/**
	 * Create the panel.
	 */
	public realizarCanje() {
		setLayout(null);
		
		JLabel lblTotalPuntos = new JLabel("Total Puntos: ");
		lblTotalPuntos.setFont(new Font("Unispace", Font.PLAIN, 11));
		lblTotalPuntos.setBounds(369, 306, 127, 14);
		add(lblTotalPuntos);
		
		JLabel lblTitulo = new JLabel("Realizar Canjes de puntos");
		lblTitulo.setFont(new Font("Unispace", Font.BOLD, 14));
		lblTitulo.setBounds(10, 11, 262, 29);
		add(lblTitulo);
		
		JLabel lblNumeroDeTarjeta = new JLabel("Numero de tarjeta:");
		lblNumeroDeTarjeta.setFont(new Font("Unispace", Font.BOLD, 11));
		lblNumeroDeTarjeta.setBounds(10, 51, 142, 20);
		add(lblNumeroDeTarjeta);
		
		txtNumeroTarjeta = new JTextField();
		txtNumeroTarjeta.setBounds(140, 51, 113, 20);
		add(txtNumeroTarjeta);
		txtNumeroTarjeta.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Unispace", Font.BOLD, 11));
		lblDni.setBounds(10, 82, 35, 20);
		add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setEnabled(false);
		txtDni.setEditable(false);
		txtDni.setBounds(43, 82, 119, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblPuntos = new JLabel("Puntos:");
		lblPuntos.setFont(new Font("Unispace", Font.BOLD, 11));
		lblPuntos.setBounds(172, 85, 67, 14);
		add(lblPuntos);
		
		txtPuntos = new JTextField();
		txtPuntos.setEnabled(false);
		txtPuntos.setEditable(false);
		txtPuntos.setBounds(224, 82, 119, 20);
		add(txtPuntos);
		txtPuntos.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 133, 334, 119);
		add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JLabel lblProductosDisponibles = new JLabel("Productos disponibles:");
		lblProductosDisponibles.setFont(new Font("Unispace", Font.BOLD, 11));
		lblProductosDisponibles.setBounds(10, 113, 186, 14);
		add(lblProductosDisponibles);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Unispace", Font.BOLD, 11));
		lblCantidad.setBounds(354, 157, 86, 14);
		add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(422, 154, 46, 20);
		add(txtCantidad);
		txtCantidad.setColumns(10);
			
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 281, 338, 132);
		add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table_1);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		
		
		MiModelo modelo = new MiModelo();
		modelo.addColumn("id");
		modelo.addColumn("Producto");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Cantidad puntos");
		table_1.setModel(modelo);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Unispace", Font.PLAIN, 11));
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Unispace", Font.PLAIN, 11));

		JButton btnRealizar = new JButton("Realizar canje");
		btnRealizar.setFont(new Font("Unispace", Font.PLAIN, 11));
		btnRealizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "¿Desea realizar el canje?","Precaución",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					
					if(txtNumeroTarjeta.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Falta el campo N° Tarjeta.");
						txtNumeroTarjeta.requestFocusInWindow();
						return;
					}else
					{
						if(txtDni.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "La tarjeta ingresada no existe.");
							txtDni.requestFocusInWindow();
							return;
						}else
						{
							if(modelo.getRowCount() == 0) {
								JOptionPane.showMessageDialog(null, "No has agregado ningún producto.");
								return;
							}else {
								int filas_tabla_1 = modelo.getRowCount();
								int puntos_total = 0;

								for(int i = 0; i < filas_tabla_1;i++)
								{
									puntos_total = (int) (puntos_total + Float.parseFloat(table_1.getModel().getValueAt(i, 3).toString())) ;
								}
								
								frmLogin idUser = new frmLogin();
								
								Tarjeta tarjeta = new Tarjeta();
								ResultSet rs;
								rs = tarjeta.busquedaTarjetaVenta(Integer.parseInt(txtNumeroTarjeta.getText()));
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
								int tipo = 2; //CANJE
								SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
								Date date = new Date(System.currentTimeMillis());  
								String fecha = formatter.format(date);
								venta.realizarCanje(id_ventas_usuarios, id_ventas_tarjetas, total_puntos, tipo, fecha);

								lblTotalPuntos.setText("Total puntos: ");
								lblTotalPuntos.setText(lblTotalPuntos.getText() + puntos_total);
								
								int filas = modelo.getRowCount();
								
								for(int i = 0; i<filas; i++) {
									int id_detalleVenta_venta = venta.ultimaVenta();
									int id_detalleVenta_producto = Integer.parseInt(modelo.getValueAt(i, 0).toString());
									int cantidad = Integer.parseInt(modelo.getValueAt(i, 2).toString());
									venta.insertarDetalleVenta(id_detalleVenta_venta, id_detalleVenta_producto, cantidad);
								}
								JOptionPane.showMessageDialog(null, "Canje realizado exitosamente.");
								btnBuscar.doClick();
								btnRealizar.setEnabled(false);
								btnEliminar.setEnabled(false);
								for(int i = filas; i>0; i--) {
									modelo.removeRow(i-1);
								}
								lblTotalPuntos.setText("Total puntos: 0");
							}
						}
					}
				}
			}
		});
		btnRealizar.setBounds(369, 331, 142, 23);
		add(btnRealizar);
		
		JLabel lblProductosAgrados = new JLabel("Productos Agregados:");
		lblProductosAgrados.setFont(new Font("Unispace", Font.BOLD, 11));
		lblProductosAgrados.setBounds(10, 263, 207, 14);
		add(lblProductosAgrados);
		
		DefaultTableModel modelo_1;
		modelo_1 = new DefaultTableModel();
		modelo_1.addColumn("ID");
		modelo_1.addColumn("Producto");
		modelo_1.addColumn("Puntos");
		table.setModel(modelo_1);
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtNumeroTarjeta.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Falta el campo N° Tarjeta.");
					txtNumeroTarjeta.requestFocusInWindow();
					return;
				}else {
					Tarjeta tarjeta = new Tarjeta();
					ResultSet rs;
					rs = tarjeta.busquedaTarjetaVenta(Integer.parseInt(txtNumeroTarjeta.getText()));
					try {
						if (rs.next() == false) {
							JOptionPane.showMessageDialog(null, "No se encontró la tarjeta ingresada.");
							txtNumeroTarjeta.requestFocusInWindow();
							txtPuntos.setText("");
							txtDni.setText("");
							int filas = modelo_1.getRowCount();
							for(int i = filas; i>0; i--) {
								modelo_1.removeRow(i-1);
							}
							table.setModel(modelo_1);
						}else {
							if(rs.first()) {
							
								txtPuntos.setText(rs.getObject("puntos_acumulados").toString());
								txtDni.setText(rs.getObject("dni").toString());
								llenarTablaProductos();
							}		
						}
					}catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnBuscar.setBounds(263, 51, 80, 23);
		add(btnBuscar);
		
		JLabel lblProducto = new JLabel("Producto: ");
		lblProducto.setFont(new Font("Unispace", Font.PLAIN, 11));
		lblProducto.setBounds(354, 134, 71, 14);
		add(lblProducto);
		
		JLabel lblProductoSeleccionado = new JLabel("");
		lblProductoSeleccionado.setBounds(435, 134, 123, 14);
		add(lblProductoSeleccionado);
		

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Unispace", Font.PLAIN, 11));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int puntos_total_2 = 0;
				if(txtCantidad.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Por favor, seleccione la cantidad.");
					txtCantidad.requestFocusInWindow();
					return;
				}else 
				{
					int filas_tabla_1 = modelo.getRowCount();
					puntos_total_2 = 0;
					int cantidad = Integer.parseInt(txtCantidad.getText());
					int row = table.getSelectedRow();
					puntos_total_2 = (int) (puntos_total_2 + (Float.parseFloat(table.getModel().getValueAt(row, 2).toString())*cantidad)) ;
					for(int i = 0; i < filas_tabla_1;i++)
					{
						puntos_total_2 = (int) (puntos_total_2 + (Float.parseFloat(table_1.getModel().getValueAt(i, 3).toString()))) ;
					}
				}
					if(Integer.parseInt(txtPuntos.getText()) < puntos_total_2) {
						
						JOptionPane.showMessageDialog(null, "No posee puntos suficientes.");
						txtPuntos.requestFocusInWindow();
						btnAgregar.setEnabled(false);
						lblProductoSeleccionado.setText("");
						txtCantidad.setText("");
						return;
					}else {
						int row = table.getSelectedRow();
						
						float puntos = (float) table.getModel().getValueAt(row, 2);
						int cantidad = Integer.parseInt(txtCantidad.getText());
						String producto_seleccionado = table.getModel().getValueAt(row, 1).toString();
						modelo.addRow(new Object[]{table.getModel().getValueAt(row, 0).toString(),producto_seleccionado, cantidad, cantidad*puntos});
						
						int filas_tabla_1 = modelo.getRowCount();
						puntos_total = 0;
	
						for(int i = 0; i < filas_tabla_1;i++)
						{
							puntos_total = (int) (puntos_total + Float.parseFloat(table_1.getModel().getValueAt(i, 3).toString())) ;
						}
						
						lblTotalPuntos.setText("Total puntos: " + puntos_total);
						txtCantidad.setText("");
						btnAgregar.setEnabled(false);
						btnRealizar.setEnabled(true);
						lblProductoSeleccionado.setText("");
				}
			}
		});
		btnAgregar.setBounds(478, 153, 89, 23);
		add(btnAgregar);
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table_1.getSelectedRow();
				modelo.removeRow(row);
				int filas_tabla_1 = modelo.getRowCount();
				int puntos_total = 0;

				for(int i = 0; i < filas_tabla_1;i++)
				{
					puntos_total = (int) (puntos_total + Float.parseFloat(table_1.getModel().getValueAt(i, 3).toString())) ;
				}
				
				lblTotalPuntos.setText("Total puntos: " + puntos_total);
				btnEliminar.setEnabled(false);
			}
		});
		btnEliminar.setBounds(369, 365, 89, 23);
		add(btnEliminar);
		
	
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String producto_seleccionado = table.getModel().getValueAt(row, 1).toString();
				lblProductoSeleccionado.setText(producto_seleccionado);
				
				btnAgregar.setEnabled(true);
			}
		});
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnEliminar.setEnabled(true);
			}
		});
		btnAgregar.setEnabled(false);
		btnRealizar.setEnabled(false);
		btnEliminar.setEnabled(false);
	}
	
	public void llenarTablaProductos() {
		
		MiModelo modelo=new MiModelo();
		
		
		modelo.addColumn("ID");
		modelo.addColumn("Producto");
		modelo.addColumn("Puntos");
		table.setModel(modelo);
		
		ResultSet rs;
		Producto busqueda = new Producto();
		rs = busqueda.buscarProducto(Integer.parseInt(txtPuntos.getText()));
		try {
			while(rs.next()) {
				modelo.addRow(new Object[]{rs.getObject("id"), rs.getObject("nombre"), rs.getObject("puntos_actual"), rs.getObject("estado"), rs.getObject("precio"), rs.getObject("porcentaje_puntos")});
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public class MiModelo extends DefaultTableModel{
		public boolean isCellEditable(int row, int column) {
			
			
			return false;
		}
	}
}
