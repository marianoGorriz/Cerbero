package Formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


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
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.ImageIcon;



public class frmLogin {

	private JFrame frame;
	private JPasswordField pwdUsuario;
	private JTextField txtUsuario;
	public static String rol;
	public static int id;
	
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("login3.png")); //imagen local
		frame.setResizable(false);
		frame.setBounds(100, 100, 425, 207);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Ingreso al Sistema de Ventas");
		
		pwdUsuario = new JPasswordField();
		pwdUsuario.setBounds(261, 81, 128, 20);
		frame.getContentPane().add(pwdUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(261, 27, 128, 20);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);		
		//INGRESAR Y COMPARAR USUARIO		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(txtUsuario.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Falta el campo USUARIO");  //validacion de USUARIOO
					txtUsuario.requestFocusInWindow();
					return;
				}else	
					{
					if(pwdUsuario.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Falta el campo CONTRASEÑA");  //validacion de USUARIO
						pwdUsuario.requestFocusInWindow();
						return;
					}else {
						String usuario = txtUsuario.getText();
						String password = new String (pwdUsuario.getPassword());
						
						Usuario user = new Usuario();
						int login = user.validacionLogin(usuario, password,0);
						rol = user.getRol();
						id = user.getId();
						
						if (login  == 1) {
							frmPrincipal window = new frmPrincipal();
							window.mostrarPrincipal();
							frame.setVisible(false);
						
						}else {
								JOptionPane.showMessageDialog(null, "Datos invalidos");
							
						}
						
						
					}
					
				}
				
				
				
				
			
				
				
				
				
				
				
				
			}
		});
		
		btnLogin.setBounds(176, 121, 100, 23);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblUsuario.setBounds(176, 29, 75, 14);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblContrasea.setBounds(176, 83, 87, 14);
		frame.getContentPane().add(lblContrasea);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(289, 121, 100, 23);
		frame.getContentPane().add(btnCancelar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("login 12.png"));
		label.setBounds(22, 11, 144, 133);
		frame.getContentPane().add(label);
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
