package Clases;

import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Vistas.Conexion;

public class Tarjeta {

	private String ultima_tarjeta, n_tarjeta, fecha_alta,ultima_compraa;
	private int cantidad_tarjeta, puntos_acumulados,estado, id_tarjeta_cliente;
	public String getUltima_tarjeta() {
		return ultima_tarjeta;
	}
	public void setUltima_tarjeta(String ultima_tarjeta) {
		this.ultima_tarjeta = ultima_tarjeta;
	}
	public String getN_tarjeta() {
		return n_tarjeta;
	}
	public void setN_tarjeta(String n_tarjeta) {
		this.n_tarjeta = n_tarjeta;
	}
	public String getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(String fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public String getUltima_compraa() {
		return ultima_compraa;
	}
	public void setUltima_compraa(String ultima_compraa) {
		this.ultima_compraa = ultima_compraa;
	}
	public int getCantidad_tarjeta() {
		return cantidad_tarjeta;
	}
	public void setCantidad_tarjeta(int cantidad_tarjeta) {
		this.cantidad_tarjeta = cantidad_tarjeta;
	}
	public int getPuntos_acumulados() {
		return puntos_acumulados;
	}
	public void setPuntos_acumulados(int puntos_acumulados) {
		this.puntos_acumulados = puntos_acumulados;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getId_tarjeta_cliente() {
		return id_tarjeta_cliente;
	}
	public void setId_tarjeta_cliente(int id_tarjeta_cliente) {
		this.id_tarjeta_cliente = id_tarjeta_cliente;
	}
	
	public void altaTarjeta(int id, String tarjeta)
	{
		
		try {
			String fecha2 = "2018-02-02";
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st =con.createStatement();
			st.executeUpdate("INSERT INTO tarjetas (cantidad_tarjeta,`ultima_tarjeta`,`n_tarjeta`,`puntos_acumulados`,`fecha_alta`,estado,`ultima_compra`, id_tarjeta_cliente) VALUES ("+1+",'"+tarjeta+"','"+tarjeta+"',"+0+",'"+fecha2+"',"+1+",'"+fecha2+"',"+id+");");	
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error al dar de alta tarjeta!");
			System.out.println("SQLException: " + e2.getMessage());	
		}
	}
	
	
	
	
	
	
	
	
}
