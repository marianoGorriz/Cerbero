package Formularios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Pedido extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedido frame = new Pedido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pedido() {
		setBounds(100, 100, 593, 440);
		getContentPane().setLayout(null);
		
		JLabel lblUltimoCodigo = new JLabel("Ultimo codigo:");
		lblUltimoCodigo.setBounds(10, 11, 83, 14);
		getContentPane().add(lblUltimoCodigo);
		
		textField = new JTextField();
		textField.setBounds(95, 8, 113, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblGenerarTarjeta = new JLabel("Generar tarjeta");
		lblGenerarTarjeta.setBounds(10, 44, 83, 14);
		getContentPane().add(lblGenerarTarjeta);
		
		textField_1 = new JTextField();
		textField_1.setBounds(95, 41, 113, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 557, 330);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CODIGO"
			}
		));
		scrollPane.setViewportView(table);

	}
}
