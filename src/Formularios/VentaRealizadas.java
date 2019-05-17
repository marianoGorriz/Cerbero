package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentaRealizadas extends JPanel {

	private JTable table;
	private JTable table_1;

	public VentaRealizadas() {
		setLayout(null);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 414, 405, -268);
		add(scrollPane);
		
		table = new JTable();
		table.setBounds(20, 391, 382, -233);
		add(table);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(91, 44, 117, 20);
		dateChooser.getCalendarButton().setBounds(96, 0, 21, 20);
		add(dateChooser);
		dateChooser.setLayout(null);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(285, 44, 117, 20);
		dateChooser_1.getCalendarButton().setBounds(96, 0, 21, 20);
		add(dateChooser_1);
		dateChooser_1.setLayout(null);
		
		JLabel lblFiltrarDesde = new JLabel("Filtrar Desde:");
		lblFiltrarDesde.setBounds(10, 50, 82, 14);
		lblFiltrarDesde.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblFiltrarDesde);
		
		JLabel lblHasta = new JLabel("Hasta:");
		lblHasta.setBounds(241, 50, 46, 14);
		add(lblHasta);
		
		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.setBounds(444, 44, 89, 23);
		add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 87, 394, 208);
		add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
	}
}
