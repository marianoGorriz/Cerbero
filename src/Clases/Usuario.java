package Clases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Formularios.frmPrincipal;
import Vistas.Conexion;

public class Usuario extends Persona {
	
	private String usuario, contraseņa, rol;
	private int id_personas_usuario,id;
	
	public int validacionLogin(String usuario, String password, int bandera) 
	{
		try {
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st =con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE usuario='"+usuario+"'AND contraseņa='"+password+"'AND estado='"+1+"'");
			if(rs.first() != false) {
					bandera = 1;
					this.rol = rs.getObject("rol").toString();
					this.id = (int) rs.getObject("id");
			}
			
		}
			
		 catch (SQLException e2) {
			System.out.println("nope2");
			System.out.println("SQLException: " + e2.getMessage());
		}
		return bandera;
		
		
	}
	
	public void altaUsuario(String usuario, String contraseņa, String rol) {
				
		try {
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st =con.createStatement();
			st.executeUpdate("INSERT INTO usuarios (`usuario`, `contraseņa`,`rol`) VALUES ('" + usuario + "', '" + contraseņa + "', '"+rol+"');");
			
		}catch(SQLException e2) {
			//System.out.println("nope2");
			JOptionPane.showMessageDialog(null, "Error al dar de alta!");
			System.out.println("SQLException: " + e2.getMessage());		
			
		}
	}
	public ResultSet buscarUsuario(String usuario) {
		try {
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st =con.createStatement();
		    ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE usuario LIKE '%" + usuario +"%';");
			return rs;

		}		 
		catch (SQLException e2) {
			//System.out.println("nope2");
			JOptionPane.showMessageDialog(null, "Error al buscar usuario!");
			System.out.println("SQLException: " + e2.getMessage());
		}
		return null;
	}
	public void modificarUsuario(String usuario, String contraseņa, int id, String rol) {
		try {
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st =con.createStatement();
			st.executeUpdate("UPDATE usuarios SET `usuario` = '" + usuario + "', `contraseņa` = '" + contraseņa + 
							 "',`rol` = '" + rol + "' WHERE id = " + id + ";");
			
		}		 
		catch (SQLException e2) {
			//System.out.println("nope2");
			JOptionPane.showMessageDialog(null, "Error al modificar el usuario!");
			System.out.println("SQLException: " + e2.getMessage());
		}
	}
	public void habilitarUsuario(String estado, int id) {
		int bandera;
		if (estado == "Deshabilitar") {
			bandera = 0;
		} else {
			bandera = 1;
		}
		try {
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st =con.createStatement();
			st.executeUpdate("UPDATE usuarios SET `estado` = " + bandera + " WHERE id = " + id + ";");
			
		}		 
		catch (SQLException e2) {
		//	System.out.println("nope2");
			JOptionPane.showMessageDialog(null, "Error al realizar lo solicitado");
			System.out.println("SQLException: " + e2.getMessage());
		}
	}
	
	public String getRol() {
		return this.rol;
	}
	
	public int getId() {
		return this.id;
	}
	

	

}
