package Formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Clases.Usuario;
import Vistas.Conexion;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;



public class frmLogin {

	private JFrame frame;
	private JPasswordField pwdUsuario;
	private JTextField txtUsuario;


	/**
	 * Create the application.
	 */
	public frmLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 422, 199);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		pwdUsuario = new JPasswordField();
		pwdUsuario.setBounds(125, 80, 172, 20);
		frame.getContentPane().add(pwdUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(125, 27, 172, 20);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		
		//INGRESAR Y COMPARAR USUARIO
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usuario = txtUsuario.getText();
				String password = new String (pwdUsuario.getPassword());
				
				Usuario user = new Usuario();
				int login = user.validacionLogin(usuario, password,0);
				
				if (login == 1) {
					frmPrincipal window = new frmPrincipal();
					window.mostrarPrincipal();
					frame.setVisible(false);
				
				}else {
					System.out.println("ok2");
				}
				
				
				
				
				
			}
		});
		
		btnLogin.setBounds(162, 111, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(28, 30, 75, 14);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(28, 83, 87, 14);
		frame.getContentPane().add(lblContrasea);
	}
	
		public void mostrarLogin() {
			try {
				frmLogin window = new frmLogin();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		

		
	
}
