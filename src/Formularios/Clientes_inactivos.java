package Formularios;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Clientes_inactivos extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Clientes_inactivos() {
		setLayout(null);
		
		JLabel lblClientesInactivos = new JLabel("Clientes inactivos");
		lblClientesInactivos.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblClientesInactivos.setBounds(10, 11, 117, 20);
		add(lblClientesInactivos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(516, 78, -468, 176);
		add(scrollPane);
		
		table = new JTable();
		table.setBounds(0, 0, 1, 1);
		add(table);

	}
}
