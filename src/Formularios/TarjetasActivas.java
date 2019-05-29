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

		/**table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int column1 = 0;
				int column2 = 1;
				int column3 = 2;
				int column4 = 3; 
				int row = table.getSelectedRow();
				
				String value1 = table.getModel().getValueAt(row, column1).toString();
				String value2 = table.getModel().getValueAt(row, column2).toString();
				String value3 = table.getModel().getValueAt(row, column3).toString();
				String value4 = table.getModel().getValueAt(row, column3).toString();


				lblNewLabel_1.setText(value2); 
				
			}
		});**/
		
	}
	public void llenarTablaTarjetas(String busquedatarjeta) {
		DefaultTableModel modelo;
		modelo = new DefaultTableModel();
		modelo.addColumn("DNI");
		modelo.addColumn("N° de Tarjeta");
		modelo.addColumn("Puntos Actuales");
		modelo.addColumn("Puntos acumulados");
		modelo.addColumn("Ultima Compra");
		table.setModel(modelo);
		//modelo.addRow(new Object[]{"ID", "Producto", "Puntos"});
		ResultSet rs;
		Tarjeta busqueda = new Tarjeta();
		rs = busqueda.buscarTarjetasActivas(busquedatarjeta);
		try {
			while(rs.next()) {
				modelo.addRow(new Object[]{rs.getObject("dni"), rs.getObject("n_tarjeta"), rs.getObject("puntos_acumulados"), rs.getObject("puntos_historicos"),rs.getObject("ultima_compra")});
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
