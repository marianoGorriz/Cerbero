package Formularios;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clases.Tarjeta;

public class TarjetasActivas extends JPanel{
	private JTable table;

	
	public TarjetasActivas() {
		setBounds(100, 100, 628, 430);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 560, 397);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Numero", "DNI", "Cantidad de Puntos", "Ultima Compra "
			}
		));
		scrollPane.setViewportView(table);
		DefaultTableModel modelo;
		modelo = new DefaultTableModel();
		modelo.addColumn("Numero"); 
		modelo.addColumn("DNI");
		modelo.addColumn("Cantidad de Puntos");
		modelo.addColumn("Ultima Compra");
		

		table.setModel(modelo);
		ResultSet rs;
		Tarjeta activas = new Tarjeta();
		rs = activas.tarjetasActivas();
		try {
			while(rs.next()) {
				modelo.addRow(new Object[]{
						rs.getObject("n_tarjeta"), 
						rs.getObject("cantidad_tarjeta"),
						rs.getObject("puntos_acumulados"),
						rs.getObject("ultima_compra"),
						
					}
				);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			}
	}
}

