package Formularios;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class realizarCanje extends JPanel {
	private JTextField txtNumero;
	private JTextField txtDni;
	private JTextField txtPuntos;
	private JTable table;
	private JTextField txtCantidad;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public realizarCanje() {
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("Realizar Canjes de puntos");
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTitulo.setBounds(10, 11, 167, 29);
		add(lblTitulo);
		
		JLabel lblNumeroDeTarjeta = new JLabel("Numero de tarjeta:");
		lblNumeroDeTarjeta.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNumeroDeTarjeta.setBounds(20, 51, 102, 20);
		add(lblNumeroDeTarjeta);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(122, 51, 127, 20);
		add(txtNumero);
		txtNumero.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(259, 50, 89, 23);
		add(btnBuscar);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDni.setBounds(30, 82, 35, 20);
		add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setEnabled(false);
		txtDni.setEditable(false);
		txtDni.setBounds(58, 82, 119, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblPuntos = new JLabel("Puntos:");
		lblPuntos.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblPuntos.setBounds(203, 85, 46, 14);
		add(lblPuntos);
		
		txtPuntos = new JTextField();
		txtPuntos.setEnabled(false);
		txtPuntos.setEditable(false);
		txtPuntos.setBounds(259, 82, 119, 20);
		add(txtPuntos);
		txtPuntos.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 133, 334, 119);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JLabel lblProductosDisponibles = new JLabel("Productos disponibles:");
		lblProductosDisponibles.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblProductosDisponibles.setBounds(10, 113, 127, 14);
		add(lblProductosDisponibles);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCantidad.setBounds(354, 157, 60, 14);
		add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(413, 154, 46, 20);
		add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(469, 153, 89, 23);
		add(btnAgregar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 281, 338, 132);
		add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setColumnHeaderView(table_1);
		
		JButton btnRealizar = new JButton("Realizar");
		btnRealizar.setBounds(369, 331, 89, 23);
		add(btnRealizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(469, 331, 89, 23);
		add(btnCancelar);
		
		JLabel lblProductosAgrados = new JLabel("Productos Agrados:");
		lblProductosAgrados.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblProductosAgrados.setBounds(10, 263, 127, 14);
		add(lblProductosAgrados);

	}
}
