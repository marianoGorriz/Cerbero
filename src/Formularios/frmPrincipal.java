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
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Point;

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
		frame.setBounds(100, 100, 780, 596);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("...:Sistema de ventas de puntos:...");
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 23));
		menuBar.setEnabled(false);
		frame.setJMenuBar(menuBar);
		
		JMenu mnVentas = new JMenu("Ventas");
		mnVentas.setIcon(new ImageIcon("C:\\Users\\faku6\\git\\Cerbero\\bin\\Iconos\\productos.png"));
		mnVentas.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnVentas.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnVentas);
		
		JMenuItem mntmRealizarVenta = new JMenuItem("Realizar Venta");
		mntmRealizarVenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				RealizarVenta panel = new RealizarVenta();
				panel.setBounds(10,11,620,413);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(panel);
				frame.repaint();
			}
		});
		mntmRealizarVenta.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnVentas.add(mntmRealizarVenta);
		
		JMenuItem mntmVentasRealizadas = new JMenuItem("Ventas Realizadas");
		mntmVentasRealizadas.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnVentas.add(mntmVentasRealizadas);
		
		JMenu mnProductos = new JMenu("Productos");
		mnProductos.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		menuBar.add(mnProductos);
		
		JMenuItem mntmAltaDeProductos = new JMenuItem("Alta de Productos");
		mntmAltaDeProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AltaProductos panel = new AltaProductos();
				panel.setBounds(10,11,620,413);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(panel);
				frame.repaint();
			}
		});
		mntmAltaDeProductos.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnProductos.add(mntmAltaDeProductos);
		
		JMenu mnTarjetas = new JMenu("Tarjetas");
		mnTarjetas.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnTarjetas.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnTarjetas);
		
		JMenuItem mntmAltasDeTarjetas = new JMenuItem("Altas de Tarjetas");
		mntmAltasDeTarjetas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				AltaTarjeta alta = new AltaTarjeta();
				alta.setBounds(10, 11, 620, 413);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(alta);
				frame.repaint();
			}
		});
		mntmAltasDeTarjetas.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnTarjetas.add(mntmAltasDeTarjetas);
		
		JMenuItem mntmTarjetasActivas = new JMenuItem("Tarjetas Activas");
		mntmTarjetasActivas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				TarjetasActivas activas = new TarjetasActivas();
				activas.setBounds(10, 11, 620, 413);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(activas);
				frame.repaint();
			}
		});
		mntmTarjetasActivas.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnTarjetas.add(mntmTarjetasActivas);
		
		JMenuItem mntmPedidoDeTarjetas = new JMenuItem("Pedido de Tarjetas");
		mntmPedidoDeTarjetas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Pedido pedido = new Pedido();
				pedido.setBounds(10, 11, 620, 413);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(pedido);
				frame.repaint();
				
			}
		});
		mntmPedidoDeTarjetas.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnTarjetas.add(mntmPedidoDeTarjetas);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		menuBar.add(mnClientes);
		
		JMenuItem mntmAltaDeClientes = new JMenuItem("Alta de Clientes");
		mntmAltaDeClientes.addMouseListener(new MouseAdapter() {
				
			public void mousePressed(MouseEvent arg0) {
				altaCliente alta = new altaCliente();
				alta.setBounds(10,11,620,413);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(alta);
				frame.repaint();
			}
		});
		mntmAltaDeClientes.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnClientes.add(mntmAltaDeClientes);
		
		JMenuItem mntmClientesInactivos = new JMenuItem("Clientes Inactivos");
		mntmClientesInactivos.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnClientes.add(mntmClientesInactivos);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		mnUsuarios.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		menuBar.add(mnUsuarios);
		
		/*mntmAltaDeClientes.addActionListener(new ActionListener() {				//trae la ventana y la relaciona al menu
			public void actionPerformed(ActionEvent evt) {

				PanelUsuarios gg = new PanelUsuarios();
				gg.setBounds(10,11,620,413);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(gg);
				frame.repaint();


			}
		}); */
		

		JMenuItem mntmAdminUsuarios = new JMenuItem("Admin Usuarios");
		mntmAdminUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				PanelUsuarios adminUser = new PanelUsuarios();
				adminUser.setBounds(10, 11, 620, 413);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(adminUser);
				frame.repaint();
				
			}
			
		});
		/*mntmAdminUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PanelUsuarios adminUser = new PanelUsuarios();
				adminUser.setBounds(10,11,620,413);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(adminUser);
				frame.repaint();
			}
			
		});*/
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
	
	private void title(String string) {
		// TODO Auto-generated method stub
		
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
