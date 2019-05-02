package Formularios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class Pedido extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JButton btnGenerarCodigo;
	private JButton btnImprimir;

	
	
	public Pedido() {
		setBounds(100, 100, 593, 440);
		setLayout(null);
		
		JLabel lblUltimoCodigo = new JLabel("Ultimo codigo:");
		lblUltimoCodigo.setBounds(10, 11, 83, 14);
		add(lblUltimoCodigo);
		
		textField = new JTextField();
		textField.setBounds(95, 8, 113, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblGenerarTarjeta = new JLabel("Generar tarjeta");
		lblGenerarTarjeta.setBounds(10, 44, 83, 14);
		add(lblGenerarTarjeta);
		
		textField_1 = new JTextField();
		textField_1.setBounds(95, 41, 113, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 560, 330);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CODIGO"
			}
		));
		scrollPane.setViewportView(table);
		
		btnGenerarCodigo = new JButton("Generar Codigo");
		btnGenerarCodigo.setBounds(291, 7, 122, 23);
		add(btnGenerarCodigo);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(291, 40, 122, 23);
		add(btnImprimir);

	}
}
