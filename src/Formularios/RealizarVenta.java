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
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public RealizarVenta() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Productos:");
		lblNewLabel.setBounds(26, 23, 59, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(95, 20, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 259, 92);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(201, 19, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(330, 43, 68, 14);
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
				System.out.println(value1);
				System.out.println(value2);
				lblNewLabel_1.setText(value2); 
				System.out.println(value3);

				
			}
		});
		
				
		table_1 = new JTable();
		table_1.setBounds(5, 210, 264, 79);
		add(table_1);
		DefaultTableModel modelo;
		modelo = new DefaultTableModel();
		modelo.addColumn("Producto");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Puntos");
		table_1.setModel(modelo);
		modelo.addRow(new Object[]{"Producto", "Cantidad", "Puntos"});

		
		textField_1 = new JTextField();
		textField_1.setBounds(408, 40, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				modelo.addRow(new Object[]{table.getModel().getValueAt(row, 1).toString(),textField_1.getText(), "Puntos"});
			}
		});
		

		btnAgregar.setBounds(320, 68, 78, 23);
		add(btnAgregar);
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(332, 191, 48, 14);
		add(lblNewLabel_2);
		
		JButton btnRealizarVenta = new JButton("Realizar venta");
		btnRealizarVenta.setBounds(320, 216, 116, 23);
		add(btnRealizarVenta);
	}
}
