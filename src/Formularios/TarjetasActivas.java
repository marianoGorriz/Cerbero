package Formularios;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clases.Tarjeta;
import Clases.Venta;

import javax.swing.JTextField;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

public class TarjetasActivas extends JPanel{
	private JTable table;
	private JTextField textField;
	

	
	public TarjetasActivas() {
		setBounds(100, 100, 628, 430);
	
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero de Tarjetas:");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel.setBounds(30, 82, 133, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(191, 80, 181, 20);
		add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 107, 540, 184);

		add(scrollPane);
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

       
		scrollPane.setViewportView(table);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
		llenarTablaTarjetas("");
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnBuscar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
			}
		});
		btnBuscar.setBounds(437, 78, 133, 23);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarTablaTarjetas(textField.getText());
			}
		
		});
		add(btnBuscar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(449, 143, 88, 14);
		add(lblNewLabel_1);
		
		JLabel lblTarjetaActicas = new JLabel("Tarjeta activas");
		lblTarjetaActicas.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblTarjetaActicas.setBounds(20, 11, 133, 14);
		add(lblTarjetaActicas);
		
		JLabel lblTarjetaSeleccionada = new JLabel("Tarjeta seleccionada: ");
		lblTarjetaSeleccionada.setBounds(30, 302, 200, 14);
		add(lblTarjetaSeleccionada);
		
		JButton btnActivarVip = new JButton("Activar VIP");
		btnActivarVip.setEnabled(false);
		btnActivarVip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int id = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
				Tarjeta tarjeta = new Tarjeta();
				tarjeta.hacerVip(id);
				System.out.println(id);
				llenarTablaTarjetas("");
				btnActivarVip.setEnabled(false);
				lblTarjetaSeleccionada.setText("Tarjeta seleccionada: ");
			}
		});
		btnActivarVip.setBounds(240, 298, 132, 23);
		add(btnActivarVip);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnActivarVip.setEnabled(true);
				int row = table.getSelectedRow();
				String nroTarjeta = table.getModel().getValueAt(row, 2).toString();
				lblTarjetaSeleccionada.setText("Tarjeta seleccionada: " + nroTarjeta);				
				
			}
		});

		
	}
	public void llenarTablaTarjetas(String busquedatarjeta) {
		DefaultTableModel modelo;
		modelo = new DefaultTableModel();
		modelo.addColumn("Id");
		modelo.addColumn("DNI");
		modelo.addColumn("N° de Tarjeta");
		modelo.addColumn("Puntos Actuales");
		modelo.addColumn("Puntos acumulados");
		modelo.addColumn("Ultima Compra");
		modelo.addColumn("Vip");
		table.setModel(modelo);
		//modelo.addRow(new Object[]{"ID", "Producto", "Puntos"});
		ResultSet rs;
		Tarjeta busqueda = new Tarjeta();
		rs = busqueda.buscarTarjetasActivas(busquedatarjeta);
		try {
			while(rs.next()) {
				modelo.addRow(new Object[]{rs.getObject("tarjetas.id"),rs.getObject("dni"), rs.getObject("n_tarjeta"), rs.getObject("puntos_acumulados"), rs.getObject("puntos_historicos"),rs.getObject("ultima_compra"),rs.getObject("vip")});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public class MiModelo extends DefaultTableModel{
		public boolean isCellEditable(int row, int column) {
				
				return false;	
		}
	}
}
