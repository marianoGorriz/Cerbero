package Formularios;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Clientes_inactivos extends JPanel {
	private JTable table;
	private JTextField txtBuscar;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public Clientes_inactivos() {
		setLayout(null);
		
		JLabel lblClientesInactivos = new JLabel("Clientes inactivos");
		lblClientesInactivos.setBounds(25, 11, 160, 20);
		lblClientesInactivos.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblClientesInactivos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 116, 574, 225);
		add(scrollPane);
		table = new JTable();
		
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setBounds(58, 87, 50, 14);
		lblBuscar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		add(lblBuscar);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(118, 85, 295, 20);
		add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(423, 82, 89, 23);
		add(btnBuscar);

	}
}
