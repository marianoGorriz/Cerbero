package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

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
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			Date date = new Date(System.currentTimeMillis());  
			String fechaActual = formatter.format(date);
			//Logica para obtener la fecha actual.
			//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			//Date date = new Date();
			//String fechaActual = dateFormat.format(date);
			//Fin logica
	
			Conexion cn = new Conexion(); 
			Connection con = cn.conectarDB();
			Statement st =con.createStatement();
			st.executeUpdate("INSERT INTO tarjetas (cantidad_tarjeta,`ultima_tarjeta`,`n_tarjeta`,`puntos_acumulados`,`fecha_alta`, id_tarjeta_cliente, `ultima_compra`) VALUES ("+1+",'"+tarjeta+"','"+tarjeta+"',"+0 +", '"+ fechaActual+"',"+id+",'"+fechaActual+"');");	
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error al dar de alta tarjeta!");
			System.out.println("SQLException: " + e2.getMessage());	
		}
	}
	public ResultSet perdidaTarjeta(String tarjeta) {
		try{ 
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery( "SELECT * FROM clientes INNER JOIN tarjetas ON clientes.id = tarjetas.id_tarjeta_cliente WHERE clientes.dni = '"+tarjeta+"'");
			return rs;
		}
		catch (SQLException e2) {
			//System.out.println("nope2");
			JOptionPane.showMessageDialog(null, "Error");
			System.out.println("SQLException: " + e2.getMessage());
			
	}
		return null;
	}
	
	public ResultSet tarjetasActivas() {
		try{ 
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery( "SELECT * FROM clientes INNER JOIN tarjetas ON clientes.id = tarjetas.id_tarjeta_cliente WHERE tarjetas.estado = 1");
			return rs;
		}
		catch (SQLException e2) {
			//System.out.println("nope2");
			JOptionPane.showMessageDialog(null, "Error");
			System.out.println("SQLException: " + e2.getMessage());
			
	}
		return null;
	}
	
	public ResultSet busquedaTarjetaVenta(int n_tarjeta) {
		try{ 
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery( "SELECT * FROM clientes INNER JOIN tarjetas ON clientes.id = tarjetas.id_tarjeta_cliente WHERE tarjetas.n_tarjeta = " + n_tarjeta + ";");
			return rs;
		}
		catch (SQLException e2) {
			//System.out.println("nope2");
			JOptionPane.showMessageDialog(null, "Error");
			System.out.println("SQLException: " + e2.getMessage());
			
	}
		return null;
	}
	public ResultSet buscarTarjetasActivas(String busquedatarjeta) {
		try{ 
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery( "SELECT * FROM clientes INNER JOIN tarjetas ON clientes.id = tarjetas.id_tarjeta_cliente WHERE tarjetas.n_tarjeta LIKE '%" + busquedatarjeta +"%' AND tarjetas.estado = 1;");
			return rs;
		}
		catch (SQLException e2) {
			//System.out.println("nope2");
			JOptionPane.showMessageDialog(null, "Error");
			System.out.println("SQLException: " + e2.getMessage());
			
	}
		return null;
	}
	
	public int modificarDatos(String numeroTarjeta,String nuevaTarjeta) 
	{
		try {
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();	
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery( "SELECT * FROM tarjetas WHERE `ultima_tarjeta` ='"+numeroTarjeta+"'");			
			if(rs.next()) {
				int id = rs.getInt("id");
				st.executeUpdate("UPDATE tarjetas SET `ultima_tarjeta` = `n_tarjeta` , n_tarjeta="+nuevaTarjeta+", cantidad_tarjeta = `cantidad_tarjeta` +"+1+" WHERE id="+id);			
				return 1;
			}			
		} catch (Exception e) {
			System.out.println("SQLException: " + e.getMessage());	
		}
		
		return 0;
	}
	
	public void activarTarjeta(String numeroTarjeta) 
	{
		try {
			Conexion cn = new Conexion();
			Connection con = cn.conectarDB();	
			Statement st = con.createStatement();
			st.executeUpdate("UPDATE tarjetas SET `estado` = 1 WHERE `n_tarjeta` = '" + numeroTarjeta + "';");			
		} catch (Exception e) {
			System.out.println("SQLException: " + e.getMessage());	
		}

	}
	


}