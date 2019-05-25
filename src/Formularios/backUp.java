package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class backUp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					backUp frame = new backUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		//});
	//}

	/**
	 * Create the frame.
	 */
	public backUp() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				frmPrincipal principal = new frmPrincipal();
				principal.setVisible(true);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 181);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(153, 11, 120, 20);
		contentPane.add(dateChooser);
		
		JButton btnNewButton = new JButton("BackUp");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				try {
					Date fecha = dateChooser.getDate();
					long d = fecha.getTime();
					java.sql.Date formatoFecha = new java.sql.Date(d);	
					String fechaActual = formatoFecha.toString();
					
					
					String dbUser = "root";
					String dbPass = "12345";
					String dbName = "cerbero";
				
					Process p = Runtime.getRuntime().exec("C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump  -u "+ dbUser + " -p"+ dbPass + " " + dbName);					
					InputStream is = p.getInputStream();
					File file = new File("C:\\Users\\mariano\\Desktop\\"+fechaActual+".sql");
					FileOutputStream fos = new FileOutputStream(file);
					byte[] buffer = new byte[1000];
					int leido = is.read(buffer);
					
					while (leido > 0) {		
						
						fos.write(buffer, 0, leido);
						leido = is.read(buffer);	
					}			
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(120, 69, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Seleccione Fecha");
		lblNewLabel.setBounds(10, 17, 133, 14);
		contentPane.add(lblNewLabel);
	}
}
