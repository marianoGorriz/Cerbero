package Vistas;
import java.sql.*;

import javax.swing.JOptionPane;

public class Conexion {
	public Conexion () {
		
	}
	public Connection conectarDB() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/cerbero?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT-3", "root", "12345");
			//JOptionPane.showMessageDialog(null, "Conexíon realizada con exito");

			
		}catch(ClassNotFoundException | SQLException ex){
			JOptionPane.showMessageDialog(null,ex);
		}
		
		return cn;
	}
	

}
