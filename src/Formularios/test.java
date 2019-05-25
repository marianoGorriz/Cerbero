package Formularios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.awt.event.ActionEvent;

public class test extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			test dialog = new test();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public test() {
		setBounds(100, 100, 326, 186);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(56, 34, 220, 20);
		contentPanel.add(dateChooser);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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
							
							while (leido > 0) 
							{										
								fos.write(buffer, 0, leido);
								leido = is.read(buffer);	
							}
							JOptionPane.showMessageDialog(null, "Backup exitoso!");
							fos.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "Error de BackUp");
						}
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
			
			}
		}
	}
}
