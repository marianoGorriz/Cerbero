package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Vistas.Conexion;

public class Cliente {

	private int id_persona_cliente,id,edad;
	private String nombre, apellido, DNI, correo, telefono, sexo;
	
	
	
	public ResultSet buscarCliente(String nombre) {
		try {
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st =con.createStatement();
		    ResultSet rs = st.executeQuery("SELECT * FROM personas WHERE nombre LIKE '%" + nombre +"%';");
			return rs;

		}		 
		catch (SQLException e2) {
			//System.out.println("nope2");
			JOptionPane.showMessageDialog(null, "Error al buscar usuario!");
			System.out.println("SQLException: " + e2.getMessage());
		}
		return null;
	}
	public void altaCliente(String nombre,String apellido, String dni, String correo, String telefono, String sexo, int edad) {
		
		try {
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st =con.createStatement();
			st.executeUpdate("INSERT INTO personas (`nombre`, `apellido`,`dni`,`correo`,`telefono`,`sexo`) VALUES ('" + nombre + "', '" + apellido + "', '"+dni+"',"
					+ " '" + correo + "','" + telefono + "','"+ sexo +"',"+edad+");");
			
		}catch(SQLException e2) {
			//System.out.println("nope2");
			JOptionPane.showMessageDialog(null, "Error al dar de alta!");
			System.out.println("SQLException: " + e2.getMessage());		
			
		}
	}
}
