package Formularios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Clases.Cliente;
import Clases.Tarjeta;

import javax.swing.JButton;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class perdidaTarjeta extends JPanel {
	private JTextField txtCantidadTarjetas;
	private JTextField txtUltimaTarjeta;
	private JTextField txtNuemeroTarjeta;
	private JTextField txtPuntos;
	private JTextField txtFechaAlta;
	private JTextField txtUltimaCompra;
	private JTextField txtBuscarTarjeta;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public perdidaTarjeta() {
		setBounds(100, 100, 677, 550);
		setLayout(null);
		
		JButton btnModificarTarjeta = new JButton("Modificar Tarjeta");
		
		btnModificarTarjeta.setBounds(166, 148, 132, 23);
		add(btnModificarTarjeta);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(337, 148, 132, 23);
		add(btnCancelar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					String numeroTarjeta = txtBuscarTarjeta.getText().toString();
					
				if (numeroTarjeta.equals("")) {
					Tarjeta todasTarjetas = new Tarjeta();
					ResultSet tarjetasEncontradas = todasTarjetas.tarjetasActivas();
					
					DefaultTableModel modelo;
					modelo = new DefaultTableModel();
					modelo.addColumn("DNI");
					modelo.addColumn("Cantidad de Tarjeta");				//completado de la tabla
					modelo.addColumn("Ultima Tarjeta");
					modelo.addColumn("N° de Tarjeta");
					modelo.addColumn("Fecha de Alta");
					modelo.addColumn("Puntos");
					modelo.addColumn("Ultima Compra");
					table.setModel(modelo);
					try {
						while(tarjetasEncontradas.next()) {
							modelo.addRow(new Object[]{
									tarjetasEncontradas.getObject("dni"), 
									tarjetasEncontradas.getObject("cantidad_tarjeta"),
									tarjetasEncontradas.getObject("ultima_tarjeta"),
									tarjetasEncontradas.getObject("n_tarjeta"),
									tarjetasEncontradas.getObject("fecha_alta"),
									tarjetasEncontradas.getObject("puntos_acumulados"),
									tarjetasEncontradas.getObject("ultima_compra"),
									
								}
							);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
						}
					
				}else
				{
					Tarjeta buscarTarjeta = new Tarjeta();
					ResultSet tarjetaEncontrada = buscarTarjeta.buscarTarjetasActivas(numeroTarjeta);
					
					DefaultTableModel modelo;
					modelo = new DefaultTableModel();
					modelo.addColumn("DNI");
					modelo.addColumn("Cantidad de Tarjeta");				//completado de la tabla
					modelo.addColumn("Ultima Tarjeta");
					modelo.addColumn("N° de Tarjeta");
					modelo.addColumn("Fecha de Alta");
					modelo.addColumn("Puntos");
					modelo.addColumn("Ultima Compra");
					table.setModel(modelo);
					try {
						while(tarjetaEncontrada.next()) {
							modelo.addRow(new Object[]{
									tarjetaEncontrada.getObject("dni"), 
									tarjetaEncontrada.getObject("cantidad_tarjeta"),
									tarjetaEncontrada.getObject("ultima_tarjeta"),
									tarjetaEncontrada.getObject("n_tarjeta"),
									tarjetaEncontrada.getObject("fecha_alta"),
									tarjetaEncontrada.getObject("puntos_acumulados"),
									tarjetaEncontrada.getObject("ultima_compra"),
									
								}
							);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
						}

				}
			}
		});
		btnBuscar.setBounds(474, 185, 89, 23);
		add(btnBuscar);
		
		JLabel lblCantidadDeTarjetas = new JLabel("Cantidad de Tarjetas:");
		lblCantidadDeTarjetas.setBounds(10, 42, 147, 14);
		lblCantidadDeTarjetas.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblCantidadDeTarjetas);
		
		txtCantidadTarjetas = new JTextField();
		txtCantidadTarjetas.setBounds(149, 40, 109, 20);
		txtCantidadTarjetas.setEnabled(false);
		txtCantidadTarjetas.setEditable(false);
		add(txtCantidadTarjetas);
		txtCantidadTarjetas.setColumns(10);
		
		JLabel lblUltimaTarjeta = new JLabel("Ultima Tarjeta:");
		lblUltimaTarjeta.setBounds(10, 71, 104, 14);
		lblUltimaTarjeta.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblUltimaTarjeta);
		
		txtUltimaTarjeta = new JTextField();
		txtUltimaTarjeta.setBounds(149, 71, 109, 20);
		txtUltimaTarjeta.setEnabled(false);
		txtUltimaTarjeta.setEditable(false);
		add(txtUltimaTarjeta);
		txtUltimaTarjeta.setColumns(10);
		
		JLabel lblNumeroTarjeta = new JLabel("Numero de tarjeta:");
		lblNumeroTarjeta.setBounds(10, 104, 129, 14);
		lblNumeroTarjeta.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblNumeroTarjeta);
		
		txtNuemeroTarjeta = new JTextField();
		txtNuemeroTarjeta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (c<'0' || c>'9') e.consume();  //validacion de que solo se escriban número 
			}
		});
		txtNuemeroTarjeta.setBounds(149, 102, 109, 20);
		add(txtNuemeroTarjeta);
		txtNuemeroTarjeta.setColumns(10);
		
		txtPuntos = new JTextField();
		txtPuntos.setBounds(472, 69, 109, 20);
		txtPuntos.setEnabled(false);
		txtPuntos.setEditable(false);
		add(txtPuntos);
		txtPuntos.setColumns(10);
		
		txtFechaAlta = new JTextField();
		txtFechaAlta.setBounds(472, 102, 109, 20);
		txtFechaAlta.setEnabled(false);
		txtFechaAlta.setEditable(false);
		add(txtFechaAlta);
		txtFechaAlta.setColumns(10);
		
		JLabel lblPuntos = new JLabel("Puntos:");
		lblPuntos.setBounds(352, 71, 70, 14);
		lblPuntos.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblPuntos);
		
		JLabel lblFechaAlta = new JLabel("Fecha alta:");
		lblFechaAlta.setBounds(352, 104, 70, 14);
		lblFechaAlta.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblFechaAlta);
		
		txtUltimaCompra = new JTextField();
		txtUltimaCompra.setBounds(472, 40, 109, 20);
		txtUltimaCompra.setEnabled(false);
		txtUltimaCompra.setEditable(false);
		add(txtUltimaCompra);
		txtUltimaCompra.setColumns(10);
		
		JLabel lblUltimaCompra = new JLabel("Ultima compra:");
		lblUltimaCompra.setBounds(352, 42, 104, 14);
		lblUltimaCompra.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblUltimaCompra);
		
		JLabel lblPerdidasDeTarjetas = new JLabel("Perdidas de Tarjetas");
		lblPerdidasDeTarjetas.setBounds(25, 11, 132, 20);
		lblPerdidasDeTarjetas.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblPerdidasDeTarjetas);
		
		JLabel lblBucarClientePor = new JLabel("Buscar cliente con DNI:");
		lblBucarClientePor.setBounds(25, 188, 155, 14);
		lblBucarClientePor.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(lblBucarClientePor);
		
		txtBuscarTarjeta = new JTextField();
		txtBuscarTarjeta.setBounds(192, 186, 274, 20);
		add(txtBuscarTarjeta);
		txtBuscarTarjeta.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
											
			}
		});
		scrollPane.setBounds(25, 219, 556, 179);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int column1 = 0;
				int column2 = 1;
				int column3 = 2;
				int column4 = 3;
				int column5 = 4;
				int column6 = 5;
				int column7 = 6;
				int column8 = 7;
				
				int row = table.getSelectedRow();
				
				String value1 = table.getModel().getValueAt(row, column1).toString();
				String value2 = table.getModel().getValueAt(row, column2).toString();
				String value3 = table.getModel().getValueAt(row, column3).toString(); //envio de los datos a la tabla
				String value4 = table.getModel().getValueAt(row, column4).toString();
				String value5 = table.getModel().getValueAt(row, column5).toString();
				String value6 = table.getModel().getValueAt(row, column6).toString();
				String value7 = table.getModel().getValueAt(row, column7).toString();
				
				txtCantidadTarjetas.setText(value2);
				txtUltimaTarjeta.setText(value3);
				txtNuemeroTarjeta.setText(value4);
				txtUltimaCompra.setText(value5);
				txtPuntos.setText(value6);
				txtFechaAlta.setText(value7);

			}
		});
		scrollPane.setViewportView(table);
		
		
		DefaultTableModel modelo;
		modelo = new DefaultTableModel();
		modelo.addColumn("DNI");
		modelo.addColumn("Cantidad de Tarjeta");				//completado de la tabla
		modelo.addColumn("Ultima Tarjeta");
		modelo.addColumn("N° de Tarjeta");
		modelo.addColumn("Fecha de Alta");
		modelo.addColumn("Puntos");
		modelo.addColumn("Ultima Compra");
		table.setModel(modelo);
		ResultSet rs;
		Tarjeta perdida = new Tarjeta();
		rs = perdida.perdidaTarjeta();
		try {
			while(rs.next()) {
				modelo.addRow(new Object[]{
						rs.getObject("dni"), 
						rs.getObject("cantidad_tarjeta"),
						rs.getObject("ultima_tarjeta"),
						rs.getObject("n_tarjeta"),
						rs.getObject("fecha_alta"),
						rs.getObject("puntos_acumulados"),
						rs.getObject("ultima_compra"),
						
					}
				);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			}

		btnModificarTarjeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String numeroTarjeta = txtUltimaTarjeta.getText().toString();
				String nuevaTarjeta = txtNuemeroTarjeta.getText().toString();
				
				Tarjeta modificarTarjeta = new Tarjeta();
							
				int estado = modificarTarjeta.modificarDatos(numeroTarjeta,nuevaTarjeta);
				
				if (estado == 1) {
					JOptionPane.showMessageDialog(null, "Edicion exitosa");
					
					DefaultTableModel modelo;
					modelo = new DefaultTableModel();
					modelo.addColumn("DNI");
					modelo.addColumn("Cantidad de Tarjeta");				//completado de la tabla
					modelo.addColumn("Ultima Tarjeta");
					modelo.addColumn("N° de Tarjeta");
					modelo.addColumn("Fecha de Alta");
					modelo.addColumn("Puntos");
					modelo.addColumn("Ultima Compra");
					table.setModel(modelo);
					ResultSet rs;
					Tarjeta perdida = new Tarjeta();
					rs = perdida.perdidaTarjeta();
					try {
						while(rs.next()) {
							modelo.addRow(new Object[]{
									rs.getObject("dni"), 
									rs.getObject("cantidad_tarjeta"),
									rs.getObject("ultima_tarjeta"),
									rs.getObject("n_tarjeta"),
									rs.getObject("fecha_alta"),
									rs.getObject("puntos_acumulados"),
									rs.getObject("ultima_compra"),
									
								}
							);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
						}
					
				} else {
					JOptionPane.showMessageDialog(null, "Edicion fallida");
				}
				}
				
			
		});	
		
		
		
		
	}
	
	
}
