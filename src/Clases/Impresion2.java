package Clases;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;

public class Impresion2 {
	public void imprimirTicket(String nombre, String apellido, String n_tarjeta, int puntos_acumulados, int total_puntos, int tipo){

        PrinterMatrix printer = new PrinterMatrix();

        Extenso e = new Extenso();

        e.setNumber(101.85);


        //Definir el tamanho del papel para la impresion  aca 25 lineas y 80 columnas
        printer.setOutSize(10, 40);
        //Imprimir * de la 2da linea a 25 en la columna 1;
        //printer.printCharAtLin(2, 25, 1, "*");
        //Imprimir * 1ra linea de la columa de 1 a 80
      /* printer.printCharAtCol(1, 1, 40, "=");
        //Imprimir Encabezado nombre del La EMpresa
       printer.printTextWrap(1, 1, 1, 40, "CERBERO RESTO BAR");
       
       
       //printer.printTextWrap(linI, linE, colI, colE, null);
       printer.printTextWrap(2, 2, 1, 40, "CUIT: 30-71120932-4");
       printer.printCharAtCol(4, 1, 40, "=");
       printer.printTextWrap(4, 4, 1, 80, "Maximiliano Servera");
       printer.printTextWrap(5, 5, 1, 80, "Tarjeta N° 0001");
       printer.printTextWrap(6, 6, 1, 80, "Puntos: 5241");
       printer.printTextWrap(7, 7, 1, 80, "Puntos por su compra: 321");
       printer.printTextWrap(8, 8, 1, 80, "Total puntos: 6000");
       
       printer.printCharAtCol(10, 1, 40, "=");*/
      //Imprimir * 1ra linea de la columa de 1 a 80
        printer.printCharAtCol(1, 1, 40, "=");
        //Imprimir Encabezado nombre del La EMpresa
       printer.printTextWrap(1, 1, 1, 40, printer.centralizar(20, "CERBERO RESTO BAR"));
       
       //printer.printTextWrap(linI, linE, colI, colE, null);
       printer.printTextWrap(2, 2, 1, 40, printer.centralizar(20, "CUIT: 30-71120932-4"));
       
       printer.printCharAtCol(4, 1, 40, "=");
       printer.printTextWrap(4, 4, 1, 40, printer.centralizar(20, nombre + " " + apellido));
       if(tipo == 0) {
	       printer.printTextWrap(5, 5, 1, 40, printer.centralizar(20,"Tarjeta N° " + n_tarjeta));
	       printer.printTextWrap(6, 6, 1, 40, printer.centralizar(20,"Puntos acumulados: " + puntos_acumulados));
	       printer.printTextWrap(7, 7, 1, 40, printer.centralizar(20,"Puntos por su compra: " + total_puntos));
	       printer.printTextWrap(8, 8, 1, 40, printer.centralizar(20,"Total puntos: " + (total_puntos + puntos_acumulados)));
       } else {
    	   printer.printTextWrap(5, 5, 1, 40, printer.centralizar(20,"Tarjeta N° " + n_tarjeta));
	       printer.printTextWrap(6, 6, 1, 40, printer.centralizar(20,"Puntos acumulados: " + puntos_acumulados));
	       printer.printTextWrap(7, 7, 1, 40, printer.centralizar(20,"Puntos descontados: " + total_puntos));
	       printer.printTextWrap(8, 8, 1, 40, printer.centralizar(20,"Total puntos: " + (puntos_acumulados - total_puntos)));
       }
       printer.printCharAtCol(10, 1, 40, "=");

       
       printer.toFile("impresion.txt");
       
        //Si no funciona probar esto
        /*try {
        	FileWriter fw = new FileWriter("impresion.docx");
        	printer.toFile("impresion.docx");
        	File fileToPrint = new File("impresion.docx");
        	
			Desktop.getDesktop().print(fileToPrint);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}*/
       
      FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("impresion.txt");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        if (inputStream == null) {
            return;
        }

        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc document = new SimpleDoc(inputStream, docFormat, null);

        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();

        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();


        if (defaultPrintService != null) {
            DocPrintJob printJob = defaultPrintService.createPrintJob();
            try {
                printJob.print(document, attributeSet);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.err.println("No existen impresoras instaladas");
        }

        /* Si no corta papel probar esto
        try {
			inputStream.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
        /*public String CortarHoja() {
        	return (char)27+ "m";
        	}*/
     
    }
}
