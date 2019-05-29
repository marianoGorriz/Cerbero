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
import Formularios.altaCliente.MiModelo;

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
		lblFiltrarDesde.setBounds(20, 67, 220, 14);
		lblFiltrarDesde.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		add(lblFiltrarDesde);
		
		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				llenartabla(txtBusqueda.getText());
				
			}
		});
		btnNewButton.setBounds(496, 63, 89, 23);
		add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFont(new Font("Unispace", Font.PLAIN, 11));
		scrollPane_1.setBounds(20, 109, 565, 208);
		add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table_1);
		
		txtBusqueda = new JTextField();
		txtBusqueda.setBounds(262, 64, 218, 20);
		add(txtBusqueda);
		txtBusqueda.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ventas realizadas");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblNewLabel.setBounds(20, 22, 196, 14);
		add(lblNewLabel);
		
		llenartabla();
	}
	
	public void llenartabla() {
		MiModelo modelo = new MiModelo();
		modelo.addColumn("ID");
		modelo.addColumn("Productos");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Usuario");
		modelo.addColumn("Cliente");
		modelo.addColumn("Fecha venta");
		modelo.addColumn("Tipo venta");
		table_1.setModel(modelo);
			
		table_1.setModel(modelo);
		ResultSet rs;
		
		Venta busqueda = new Venta();
	
		rs = busqueda.buscarProductoVenta();

		try {
			while(rs.next()) {
				modelo.addRow(new Object[]{rs.getObject("clientes.id"), rs.getObject("productos.nombre"),rs.getObject("detalleventa.cantidad"),rs.getObject("usuarios.usuario"),rs.getObject("clientes.dni"),rs.getObject("ventas.fecha_venta"),rs.getObject("tipo_venta.tipo")});
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		
	}
	
	public void llenartabla(String nombreProducto) {
		MiModelo modelo = new MiModelo();
		modelo.addColumn("ID");
		modelo.addColumn("Productos");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Usuario");
		modelo.addColumn("Cliente");
		modelo.addColumn("Fecha venta");
		modelo.addColumn("Tipo venta");
		table_1.setModel(modelo);
			
		table_1.setModel(modelo);
		ResultSet rs;
		
		Venta busqueda = new Venta();
	
		rs = busqueda.buscarProductoVenta(nombreProducto);

		try {
			while(rs.next()) {
				modelo.addRow(new Object[]{rs.getObject("clientes.id"), rs.getObject("productos.nombre"),rs.getObject("detalleventa.cantidad"),rs.getObject("usuarios.usuario"),rs.getObject("clientes.dni"),rs.getObject("ventas.fecha_venta"),rs.getObject("tipo_venta.tipo")});
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
