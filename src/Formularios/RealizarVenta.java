package Formularios;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Clases.Producto;
import Clases.Venta;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;

public class RealizarVenta extends JPanel {
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JTextField txtPrecio;
	private JTextField tfNroTarjeta;

	/**
	 * Create the panel.
	 */
	public RealizarVenta() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Productos:");
		lblNewLabel.setBounds(10, 23, 75, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(80, 20, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 264, 151);		

		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(186, 19, 88, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarTablaProductos();
			}
		});
		add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(284, 49, 184, 14);
		add(lblNewLabel_1);

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
				
			}
		});
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 210, 264, 149);
		add(scrollPane2);
				
		table_1 = new JTable();
		scrollPane2.setViewportView(table_1);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		DefaultTableModel modelo;
		modelo = new DefaultTableModel();
		modelo.addColumn("Producto");
		modelo.addColumn("Precio");
		modelo.addColumn("Cantidad puntos");
		table_1.setModel(modelo);
		modelo.addRow(new Object[]{"Producto", "Precio", "Cantidad puntos"});

		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(284, 74, 96, 20);
		add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				float puntos = (float) table.getModel().getValueAt(row, 2);
				float precio = Float.parseFloat(txtPrecio.getText());
				modelo.addRow(new Object[]{table.getModel().getValueAt(row, 1).toString(),txtPrecio.getText(), precio*puntos});
			}
		});
		

		btnAgregar.setBounds(390, 73, 96, 23);
		add(btnAgregar);
		
		
		JLabel lblNewLabel_2 = new JLabel("Total puntos:");
		lblNewLabel_2.setBounds(284, 211, 184, 14);
		add(lblNewLabel_2);
		
		JButton btnRealizarVenta = new JButton("Realizar venta");
		btnRealizarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filas_tabla_1 = modelo.getRowCount();
				float puntos_total = 0;
				for(int i = 1; i < filas_tabla_1;i++)
				{
					puntos_total = puntos_total + Float.parseFloat(table_1.getModel().getValueAt(i, 2).toString()) ;
				}
				lblNewLabel_2.setText("Total puntos: ");
				System.out.println(puntos_total);
				lblNewLabel_2.setText(lblNewLabel_2.getText() + puntos_total);
				
				System.out.println(tfNroTarjeta.getText());

			}
		});
		btnRealizarVenta.setBounds(284, 276, 116, 23);
		add(btnRealizarVenta);
		
		tfNroTarjeta = new JTextField();
		tfNroTarjeta.setBounds(346, 236, 140, 20);
		add(tfNroTarjeta);
		tfNroTarjeta.setColumns(10);
		
		JLabel lblNTarjeta = new JLabel("N\u00B0 Tarjeta:");
		lblNTarjeta.setBounds(284, 236, 64, 14);
		add(lblNTarjeta);
		
		llenarTablaProductos();
	}
	
	public void llenarTablaProductos() {
		DefaultTableModel modelo;
		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Producto");
		modelo.addColumn("Puntos");
		table.setModel(modelo);
		modelo.addRow(new Object[]{"ID", "Producto", "Puntos"});
		ResultSet rs;
		Venta busqueda = new Venta();
		rs = busqueda.buscarProducto(textField.getText());
		try {
			while(rs.next()) {
				modelo.addRow(new Object[]{rs.getObject("id"), rs.getObject("nombre"), rs.getObject("puntos_actual")});
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
