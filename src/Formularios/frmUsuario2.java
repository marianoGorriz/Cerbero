package Formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Choice;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class frmUsuario2 extends JPanel {

	private JFrame frame;
	private JTextField txtId;
	private JTextField txtUsuario;
	private JTextField txtContrasea;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JLabel lblId;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JLabel lblRol;
	private JButton button_1;
	private JTable table;
	private JTable table_1;
	

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmUsuario window = new frmUsuario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 */
	public frmUsuario2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame. dasdsada
	 */
	private void initialize() {
		
		
			
		frame = new JFrame();
		frame.setBounds(100, 100, 561, 398);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Usuario", "Contrase\u00F1a", "Rol"
			}
		));
		table.setBounds(443, 330, -417, -90);
		frame.getContentPane().add(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 545, 359);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(0, 56, 40, 14);
		panel.add(lblUsuario);
		
		lblId = new JLabel("ID:");
		lblId.setBounds(0, 11, 15, 14);
		panel.add(lblId);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(0, 102, 65, 14);
		panel.add(lblContrasea);
		
		lblRol = new JLabel("Rol:");
		lblRol.setBounds(0, 137, 46, 14);
		panel.add(lblRol);
		
		txtId = new JTextField();
		txtId.setBounds(114, 11, 86, 20);
		panel.add(txtId);
		txtId.setText("");
		txtId.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(114, 53, 86, 20);
		panel.add(txtUsuario);
		txtUsuario.setText("");
		txtUsuario.setColumns(10);
		
		table_1 = new JTable();
		table_1.setBounds(0, 329, 435, -104);
		panel.add(table_1);
		
		
		Choice choice = new Choice();
		choice.setBounds(114, 131, 86, 20);
		panel.add(choice);
		
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.setBounds(0, 175, 89, 23);
		panel.add(btnNewButton);
		
		JButton button = new JButton("Actualizar");
		button.setBounds(111, 175, 89, 23);
		panel.add(button);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(221, 175, 89, 23);
		panel.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(332, 175, 89, 23);
		panel.add(btnCancelar);
		
		txtContrasea = new JTextField();
		txtContrasea.setBounds(114, 99, 86, 20);
		panel.add(txtContrasea);
		txtContrasea.setText("");
		txtContrasea.setColumns(10);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		choice.add("Mozo");
		choice.add("Depsosito");
		}
	public void mostrarUsuario() {
		try {
			frmUsuario2 window = new frmUsuario2();
			window.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}

