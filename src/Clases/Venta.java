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
	
	public void realizarVenta(int id_ventas_usuarios, int id_ventas_tarjetas, int total_puntos, int tipo) {
		try {
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st =con.createStatement();
			st.executeUpdate("INSERT INTO ventas (`id_ventas_usuarios`, `id_ventas_tarjetas`, `total_puntos`, `tipo_venta`) VALUES ('" + id_ventas_usuarios + "', '" + id_ventas_tarjetas + "', " + total_puntos + ", + " + tipo + ");");
			st.executeUpdate("UPDATE tarjetas SET puntos_acumulados = " + total_puntos + " + puntos_acumulados WHERE id = " + id_ventas_tarjetas + ";");
		}		 
		catch (SQLException e2) {
			System.out.println("nope2");
			System.out.println("SQLException: " + e2.getMessage());
		}
	}
	
	public void insertarDetalleVenta(int id_detalleVenta_venta, int id_detalleVenta_producto, int cantidad) {
		try {
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st =con.createStatement();
			st.executeUpdate("INSERT INTO detalleventa (`id_detalleVenta_venta`, `id_detalleVenta_producto`, `cantidad`) VALUES (" + id_detalleVenta_venta + ", " + id_detalleVenta_producto + ", " + cantidad + ");");
		}		 
		catch (SQLException e2) {
			System.out.println("nope2");
			System.out.println("SQLException: " + e2.getMessage());
		}
	}
	
	public int ultimaVenta() {
		int id_ultima_venta = 0;
		try {
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st =con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM ventas ORDER BY ID DESC LIMIT 1");
			try {
				while(rs.next()) {
					id_ultima_venta = Integer.parseInt(rs.getObject("id").toString());
					
				}
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
		}catch (SQLException e2) {
			System.out.println("nope2");
			System.out.println("SQLException: " + e2.getMessage());
		}
		return id_ultima_venta;
	}

}
