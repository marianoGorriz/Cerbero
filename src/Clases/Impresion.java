package Clases;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Impresion {
    public void imprimirTicket(String nombre, String apellido, String n_tarjeta, int puntos_acumulados, int total_puntos, int tipo){

        try {

            FileWriter fw = new FileWriter("C:\\Users\\mariano\\Desktop\\ggx2.docx");

            PrintWriter pw = new PrintWriter(fw);
            		
            pw.print("CERBERO RESTOBAR");
            pw.print("\r\n");
            pw.print("CUIL: 202020");
            pw.print("\r\n");
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

            File fileToPrint = new File("C:\\\\Users\\\\mariano\\\\Desktop\\\\ggx2.docx");
            Desktop.getDesktop().print(fileToPrint);

            pw.close();

            } catch (IOException e) {
            System.out.println(e);
            }

    }
}