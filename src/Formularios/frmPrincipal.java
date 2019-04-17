package Formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.SwingConstants;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class frmPrincipal extends JFrame {

	private JFrame frame;
	private JDesktopPane jdpEscritorio; //permite abrir ventanas 

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public frmPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 711, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 23));
		menuBar.setEnabled(false);
		frame.setJMenuBar(menuBar);
		
		JMenu mnVentas = new JMenu("Ventas");
		mnVentas.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnVentas.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnVentas);
		
		JMenuItem mntmRealizarVenta = new JMenuItem("Realizar Venta");
		mntmRealizarVenta.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnVentas.add(mntmRealizarVenta);
		
		JMenuItem mntmVentasRealizadas = new JMenuItem("Ventas Realizadas");
		mntmVentasRealizadas.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnVentas.add(mntmVentasRealizadas);
		
		JMenu mnProductos = new JMenu("Productos");
		mnProductos.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		menuBar.add(mnProductos);
		
		JMenuItem mntmAltaDeProductos = new JMenuItem("Alta de Productos");
		mntmAltaDeProductos.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnProductos.add(mntmAltaDeProductos);
		
		JMenu mnTarjetas = new JMenu("Tarjetas");
		mnTarjetas.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnTarjetas.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnTarjetas);
		
		JMenuItem mntmAltasDeTarjetas = new JMenuItem("Altas de Tarjetas");
		mntmAltasDeTarjetas.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnTarjetas.add(mntmAltasDeTarjetas);
		
		JMenuItem mntmTarjetasActivas = new JMenuItem("Tarjetas Activas");
		mntmTarjetasActivas.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnTarjetas.add(mntmTarjetasActivas);
		
		JMenuItem mntmPedidoDeTarjetas = new JMenuItem("Pedido de Tarjetas");
		mntmPedidoDeTarjetas.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnTarjetas.add(mntmPedidoDeTarjetas);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		menuBar.add(mnClientes);
		
		JMenuItem mntmAltaDeClientes = new JMenuItem("Alta de Clientes");
		mntmAltaDeClientes.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnClientes.add(mntmAltaDeClientes);
		
		JMenuItem mntmClientesInactivos = new JMenuItem("Clientes Inactivos");
		mntmClientesInactivos.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnClientes.add(mntmClientesInactivos);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		mnUsuarios.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		menuBar.add(mnUsuarios);
		
		mntmAltaDeClientes.addActionListener(new ActionListener() {				//trae la ventana y la relaciona al menu
			public void actionPerformed(ActionEvent evt) {

				PanelUsuarios gg = new PanelUsuarios();
				gg.setBounds(10,11,620,413);
				frame.getContentPane().add(gg);
				frame.repaint();


			}
		}); 
		

		JMenuItem mntmAdminUsuarios = new JMenuItem("Admin Usuarios");
		/**mntmAdminUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frmUsuario gg = new frmUsuario();
				jdpEscritorio.add(gg);
				gg.show();

			} 
		});*/
		mntmAdminUsuarios.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnUsuarios.add(mntmAdminUsuarios);
		frame.getContentPane().setLayout(null);
		

		

	}
	
	public void mostrarPrincipal() {
		try {
			frmPrincipal window = new frmPrincipal();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void jmItemUsuariosActionPerformed(ActionEvent evt) {
		frmUsuario2 misUsuarios = new frmUsuario2();
		jdpEscritorio.add(misUsuarios);
		misUsuarios.show();
	}
}
