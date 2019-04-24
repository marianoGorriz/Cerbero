package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Formularios.frmPrincipal;
import Vistas.Conexion;

public class Usuario extends Persona {
	
	private String usuario, contraseña, rol;
	private int id_personas_usuario,id;
	
	public int validacionLogin(String usuario, String password, int bandera) 
	{
		try {
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st =con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE usuario='"+usuario+"'AND contraseña='"+password+"'");

			if(rs.first() != false) {
					bandera = 1;
			}
			
		}
			
		 catch (SQLException e2) {
			System.out.println("nope2");
			System.out.println("SQLException: " + e2.getMessage());
		}
		return bandera;
		
		
	}
	
	public void altaUsuario(String usuario, String contraseña, String rol) {
				
		try {
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st =con.createStatement();
			st.executeUpdate("INSERT INTO usuarios (`usuario`, `contraseña`,`rol`, estado) VALUES ('" + usuario + "', '" + contraseña + "', '"+rol+"');");
			
		}catch(SQLException e2) {
			System.out.println("nope2");
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
			System.out.println("nope2");
			System.out.println("SQLException: " + e2.getMessage());
		}
		return null;
	}
	public void modificarUsuario(String usuario, String contraseña, int id, String rol) {
		try {
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st =con.createStatement();
			st.executeUpdate("UPDATE usuarios SET `usuario` = '" + usuario + "', `contraseña` = '" + contraseña + 
							 "',`rol` = '" + rol + "' WHERE id = " + id + ";");
			
		}		 
		catch (SQLException e2) {
			System.out.println("nope2");
			System.out.println("SQLException: " + e2.getMessage());
		}
	}
    
	

}
