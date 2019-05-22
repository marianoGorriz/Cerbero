package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Vistas.Conexion;

public class Venta extends Producto {
	
	private int id_ventas_usuarios, id_ventas_tarjetas, total_puntos, cantidad;
	
	

	public int getId_ventas_usuarios() {
		return id_ventas_usuarios;
	}

	public void setId_ventas_usuarios(int id_ventas_usuarios) {
		this.id_ventas_usuarios = id_ventas_usuarios;
	}

	public int getId_ventas_tarjetas() {
		return id_ventas_tarjetas;
	}

	public void setId_ventas_tarjetas(int id_ventas_tarjetas) {
		this.id_ventas_tarjetas = id_ventas_tarjetas;
	}

	public int getTotal_puntos() {
		return total_puntos;
	}

	public void setTotal_puntos(int total_puntos) {
		this.total_puntos = total_puntos;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void realizarVenta(int id_ventas_usuarios, int id_ventas_tarjetas, int total_puntos) {
		try {
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st =con.createStatement();
			st.executeUpdate("INSERT INTO ventas (`id_ventas_usuarios`, `id_ventas_tarjetas`, `total_puntos`) VALUES ('" + id_ventas_usuarios + "', '" + id_ventas_tarjetas + "', " + total_puntos + ");");
		}		 
		catch (SQLException e2) {
			System.out.println("nope2");
			System.out.println("SQLException: " + e2.getMessage());
		}
	}

}
