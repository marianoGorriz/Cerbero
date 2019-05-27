package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;

import Clases.Venta;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class VentaRealizadas extends JPanel {
	private JTable table_1;
	private JTextField txtBusqueda;

	public VentaRealizadas() {
		setLayout(null);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 414, 405, -268);
		add(scrollPane);
		
		JLabel lblFiltrarDesde = new JLabel("Filtrar por productos vendidos:");
		lblFiltrarDesde.setBounds(10, 50, 164, 14);
		lblFiltrarDesde.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblFiltrarDesde);
		
		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				llenartabla(txtBusqueda.getText());
				
			}
		});
		btnNewButton.setBounds(313, 46, 89, 23);
		add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 87, 394, 208);
		add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table_1);
		
		txtBusqueda = new JTextField();
		txtBusqueda.setBounds(161, 47, 125, 20);
		add(txtBusqueda);
		txtBusqueda.setColumns(10);
		
		llenartabla();
	}
	
	public void llenartabla() {
		DefaultTableModel model;
		model = new DefaultTableModel();
		model.addColumn("Fecha Venta");
		model.addColumn("Producto");
		model.addColumn("Cantidad");
		model.addColumn("Usuario");
		model.addColumn("DNI");
			
		table_1.setModel(model);
		ResultSet rs;
		
		Venta busqueda = new Venta();
	
		rs = busqueda.buscarProductoVenta();

		try {
			while(rs.next()) {
				model.addRow(new Object[]{rs.getObject("clientes.id"), rs.getObject("productos.nombre"),rs.getObject("detalleventa.cantidad"),rs.getObject("usuarios.usuario"),rs.getObject("clientes.dni")});
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		
	}
	
	public void llenartabla(String nombreProducto) {
		DefaultTableModel model;
		model = new DefaultTableModel();
		model.addColumn("Fecha Venta");
		model.addColumn("Producto");
		model.addColumn("Cantidad");
		model.addColumn("Usuario");
		model.addColumn("DNI");
			
		table_1.setModel(model);
		ResultSet rs;
		
		Venta busqueda = new Venta();
	
		rs = busqueda.buscarProductoVenta(nombreProducto);

		try {
			while(rs.next()) {
				model.addRow(new Object[]{rs.getObject("clientes.id"), rs.getObject("productos.nombre"),rs.getObject("detalleventa.cantidad"),rs.getObject("usuarios.usuario"),rs.getObject("clientes.dni")});
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		
	}
	
	
}
