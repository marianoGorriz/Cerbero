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

public class VentaRealizadas extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentaRealizadas frame = new VentaRealizadas();
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
	public VentaRealizadas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 414, 405, -268);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBounds(20, 391, 382, -233);
		contentPane.add(table);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(102, 44, 117, 20);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(285, 44, 117, 20);
		contentPane.add(dateChooser_1);
		
		JLabel lblFiltrarDesde = new JLabel("Filtrar Desde:");
		lblFiltrarDesde.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFiltrarDesde.setBounds(10, 50, 82, 14);
		contentPane.add(lblFiltrarDesde);
		
		JLabel lblHasta = new JLabel("Hasta:");
		lblHasta.setBounds(241, 50, 46, 14);
		contentPane.add(lblHasta);
		
		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.setBounds(444, 44, 89, 23);
		contentPane.add(btnNewButton);
	}
}
