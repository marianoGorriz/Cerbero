package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Vistas.Conexion;

public class Cliente {

	private int id;
	private String nombre, apellido, DNI, correo, telefono, fecha;
	
	
	
	public ResultSet buscarCliente(String nombre) {
		try {
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st =con.createStatement();
		    ResultSet rs = st.executeQuery("SELECT * FROM clientes WHERE `nombre` LIKE '%" + nombre +"%';");
			return rs;

		}		 
		catch (SQLException e2) {
			//System.out.println("nope2");
			JOptionPane.showMessageDialog(null, "Error al buscar usuario!");
			System.out.println("SQLException: " + e2.getMessage());
		}
		return null;
	}
	public int altaCliente(String nombre,String apellido, String dni, String correo, String telefono, String sexo, String fecha, String tarjeta) {
		int id = 0;
		try {	
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st =con.createStatement();
			st.executeUpdate("INSERT INTO clientes (`nombre`, `apellido`,`dni`,`correo`,`telefono`,`sexo`,`fecha_nacimiento` ) VALUES ('"+nombre+"','"+apellido +"','"+dni+"','"+correo+"','" +telefono+"','"+sexo+"','"+fecha+"');");
			ResultSet rs =st.executeQuery("SELECT * FROM clientes WHERE `dni`='"+dni+"';");
			if (rs.next()) {
			id = rs.getInt("id");
			}else{
				JOptionPane.showMessageDialog(null, "Error de cliente ID!");
			}
			JOptionPane.showMessageDialog(null, "Alta de cliente exitosa!");			
		}catch(SQLException e2) {
			//System.out.println("nope2");
			JOptionPane.showMessageDialog(null, "Error al dar de alta!");
			System.out.println("SQLException: " + e2.getMessage());		
			
		}
		return id;
	}

	
	
}
