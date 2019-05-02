package Formularios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
				"Numero", "Cliente", "Estado"
			}
		));
		scrollPane.setViewportView(table);

	}
}
