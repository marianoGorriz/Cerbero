package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Vistas.Conexion;

public class Producto {

	private String nombre;
	private int puntos_actual,estado;
	
	public void altaProducto(String nombre, int puntos_actual) {
		try {
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st =con.createStatement();
			st.executeUpdate("INSERT INTO productos (`nombre`, `puntos_actual`) VALUES ('" + nombre + "', " + puntos_actual + ");");
		}		 
		catch (SQLException e2) {
			System.out.println("nope2");
			System.out.println("SQLException: " + e2.getMessage());
		}
	}
	
	public void modificarProducto(String nombre, int puntos_actual, int id) {
		try {
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st =con.createStatement();
			st.executeUpdate("UPDATE productos SET `nombre` = '" + nombre + "', `puntos_actual` = " + puntos_actual + 
							 " WHERE id = " + id + ";");
			
		}		 
		catch (SQLException e2) {
			System.out.println("nope2");
			System.out.println("SQLException: " + e2.getMessage());
		}
	}
	
	public void habilitarProducto(String estado, int id) {
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
			st.executeUpdate("UPDATE productos SET `estado` = " + bandera + " WHERE id = " + id + ";");
			
		}		 
		catch (SQLException e2) {
			System.out.println("nope2");
			System.out.println("SQLException: " + e2.getMessage());
		}
	}
    
	public ResultSet buscarProducto(String producto) {
		try {
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st =con.createStatement();
		    ResultSet rs = st.executeQuery("SELECT * FROM productos WHERE nombre LIKE '%" + producto +"%';");
			return rs;

		}		 
		catch (SQLException e2) {
			System.out.println("nope2");
			System.out.println("SQLException: " + e2.getMessage());
		}
		return null;
	}
    
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntos_actual() {
		return puntos_actual;
	}
	public void setPuntos_actual(int puntos_actual) {
		this.puntos_actual = puntos_actual;
	}
	
	
}
