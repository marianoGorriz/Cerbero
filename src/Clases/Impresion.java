package Clases;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Impresion {
	public void imprimirTicket(String nombre, String apellido, String n_tarjeta, int puntos_acumulados, int total_puntos, int tipo){

		try {
			// cambiar archivo de texto por puerto de impresora ej: COM4:
			FileWriter fw = new FileWriter("C:\\Users\\mariano\\Desktop\\gg.txt");
			//FileWriter fw = new FileWriter("COM4:");
			PrintWriter pw = new PrintWriter(fw);
			/**String s = "PROBANDO PROBANDO PROBANDO PROBANDO PROBANDO PROBANDOPROBANDO PROBANDO PROBANDOPROBANDO PROBANDO PROBANDOPROBANDO PROBANDO PROBANDOPROBANDO PROBANDO PROBANDOPROBANDO PROBANDO PROBANDOPROBANDO PROBANDO PROBANDO";

			int i, len = s.length();*/
			pw.print("Gilada cerbero");
			pw.print("\r\n");
			pw.print("CUIL");
			pw.print("\r\n");
			if(tipo == 0) {
				pw.print(nombre + " " + apellido);
				pw.print("\r\n");
				pw.print("Tarjeta N° " + n_tarjeta);
				pw.print("\r\n");
				pw.print("Puntos acumulados: " + puntos_acumulados);
				pw.print("\r\n");
				pw.print("Puntos por su compra: " + total_puntos);
				pw.print("\r\n");
				pw.print("Total puntos: " + (puntos_acumulados + total_puntos));
				pw.print("\r\n");
			} else {
				pw.print(nombre + " " + apellido);
				pw.print("\r\n");
				pw.print("Tarjeta N° " + n_tarjeta);
				pw.print("\r\n");
				pw.print("Puntos acumulados: " + puntos_acumulados);
				pw.print("\r\n");
				pw.print("Puntos descontados: -" + total_puntos);
				pw.print("\r\n");
				pw.print("Total puntos: " + (puntos_acumulados - total_puntos));
				pw.print("\r\n");
			}
			
			/**for (i = 0; len > 80; i += 80) {
			pw.print(s.substring(i, i + 80));
			pw.print("\r\n");
			len -= 80;
			}

			if (len > 0) {
			pw.print(s.substring(i));
			pw.print("\r\n");
			}*/

			pw.close();
			
			} catch (IOException e) {
			System.out.println(e);
			}
     
    }
}
