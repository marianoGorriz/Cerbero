package Vistas;

import java.awt.EventQueue;
import java.sql.Statement;

import javax.swing.JFrame;

import Formularios.frmLogin;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		frmLogin login= new frmLogin();
		login.mostrarLogin();
		
	}//comentario

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		Conexion gg = new Conexion();
		gg.conectarDB();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(99, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	

}
