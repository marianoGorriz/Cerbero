package Formularios;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class canjesRealizados extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public canjesRealizados() {
		setLayout(null);
		
		JLabel lblCanjesRealizados = new JLabel("Canjes realizados");
		lblCanjesRealizados.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCanjesRealizados.setBounds(20, 11, 130, 26);
		add(lblCanjesRealizados);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setBounds(84, 0, 21, 20);
		dateChooser.setBounds(101, 60, 105, 20);
		add(dateChooser);
		dateChooser.setLayout(null);
		
		JLabel lblFiltrarDesde = new JLabel("Filtrar desde:");
		lblFiltrarDesde.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblFiltrarDesde.setBounds(30, 60, 85, 20);
		add(lblFiltrarDesde);
		
		JLabel lblHasta = new JLabel("Hasta:");
		lblHasta.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblHasta.setBounds(214, 60, 68, 20);
		add(lblHasta);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.getCalendarButton().setBounds(84, 0, 21, 20);
		dateChooser_1.setBounds(259, 60, 105, 20);
		add(dateChooser_1);
		dateChooser_1.setLayout(null);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(373, 57, 89, 23);
		add(btnFiltrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 90, 470, 249);
		add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setColumnHeaderView(table);

	}
}
