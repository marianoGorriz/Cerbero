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
import javax.swing.JLabel;
import java.awt.Toolkit;

public class frmPrincipal extends JFrame {

	private JFrame frame;
	private JDesktopPane jdpEscritorio; //permite abrir ventanass


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
		
		frmLogin rolUser = new frmLogin();
		
		String rol = rolUser.rol;
		
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\faku6\\Documents\\Proyectos JAVA\\sis reserva res\\bin\\Imgenes\\reserva.png")); //imagen local 
		frame.setResizable(false);
		frame.setBounds(100, 100, 675, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("...:Sistema de ventas de puntos:..."); //titulo de la ventana 
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 23));
		menuBar.setEnabled(false);
		frame.setJMenuBar(menuBar);
		
		JMenu mnVentas = new JMenu("Ventas"); //mnMenu- ventana del menu 
		mnVentas.setIcon(new ImageIcon("C:\\Users\\faku6\\git\\Cerbero\\bin\\Iconos\\productos.png")); //imagen local 
		mnVentas.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14)); //tipo de formato
		mnVentas.setHorizontalAlignment(SwingConstants.CENTER); //alineacion 
		menuBar.add(mnVentas);
		
		JMenuItem mntmRealizarVenta = new JMenuItem("Realizar Venta"); //mntmMenu- submenu del menu VENTAS
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
		mntmRealizarVenta.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14)); //mntmMenu- submenu del menu VENTAS
		mnVentas.add(mntmRealizarVenta);
		



		JMenuItem mntmVentasRealizadas = new JMenuItem("Ventas Realizadas");   //mntmMenu- submenu del menu VENTAS
		mntmVentasRealizadas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				VentaRealizadas ventas = new VentaRealizadas();
				ventas.setBounds(10,11,620,413);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(ventas);
				frame.repaint();
			}
		});

		mntmVentasRealizadas.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14)); //tipo de letra y tamaño
		mnVentas.add(mntmVentasRealizadas);
		
		JMenuItem mntmRealizarCanjes = new JMenuItem("Realizar Canjes ");//mntmMenu- submenu del menu VENTAS-Canjes de puntos 
		mntmRealizarCanjes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				realizarCanje canjes = new realizarCanje();					//LLamado de la ventana 
				canjes.setBounds(10,11,620,413);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(canjes);
				frame.repaint();		
			}
		});
		mntmRealizarCanjes.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnVentas.add(mntmRealizarCanjes);
		
		JMenuItem mntmCanjesRealizados = new JMenuItem("Canjes Realizados");			//submenu de la ventana ventas- historial del canjes realizados
		mntmCanjesRealizados.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnVentas.add(mntmCanjesRealizados);
		
		JMenu mnProductos = new JMenu("Productos"); 							//menú productos
		mnProductos.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));			//tipo de letra y tamaño
		menuBar.add(mnProductos);
		if (rol.equals("Administrador")) {
			mnProductos.setVisible(true);
		} else {
			mnProductos.setVisible(false);
		}
		JMenuItem mntmAltaDeProductos = new JMenuItem("Alta de Productos");		//mntmMenu- submenu del menu VENTAS
		mntmAltaDeProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {							//Evento para abrir el panel ALTAS PRODUCTOS
				AltaProductos panel = new AltaProductos();
				panel.setBounds(10,11,620,413);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(panel);
				frame.repaint();
			}
		});
		mntmAltaDeProductos.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14)); //mntmMenu- submenu del menu productos 
		mnProductos.add(mntmAltaDeProductos);
		
		JMenu mnTarjetas = new JMenu("Tarjetas");							 	//MNMENU- Menu de TARJETAS
		mnTarjetas.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));			//Tipo de letra y orientacion
		mnTarjetas.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnTarjetas);
		
		JMenuItem mntmAltasDeTarjetas = new JMenuItem("Perdida De Tarjeta"); 	//mntmALTAS- submenu de menu TARJETAS
		mntmAltasDeTarjetas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {							//Eventos para abrir el panel 
				perdidaTarjeta alta = new perdidaTarjeta();
				alta.setBounds(10, 11, 620, 413);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(alta);
				frame.repaint();
			}
		});
		mntmAltasDeTarjetas.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));	//tipo de letra y tamaño
		mnTarjetas.add(mntmAltasDeTarjetas);
		
		JMenuItem mntmTarjetasActivas = new JMenuItem("Tarjetas Activas");			//MNTM MENU- Submenu del menu TARJETAS
		mntmTarjetasActivas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {								//Evento para poder abrir el panel 
				TarjetasActivas activas = new TarjetasActivas();
				activas.setBounds(10, 11, 620, 413);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(activas);
				frame.repaint();
			}
		});
		mntmTarjetasActivas.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnTarjetas.add(mntmTarjetasActivas);
		
		JMenu mnClientes = new JMenu("Clientes");									//MNMenu- Menu de clientes
		mnClientes.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));				//Tipo de letra y tamaño
		menuBar.add(mnClientes);
		
		JMenuItem mntmAltaDeClientes = new JMenuItem("Alta de Clientes");			//Submenu del menu CLIENTES
		mntmAltaDeClientes.addMouseListener(new MouseAdapter() {
				
			public void mousePressed(MouseEvent arg0) {								//Evento para poder traer la ventana 
				altaCliente alta = new altaCliente();
				alta.setBounds(10,11,620,413);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(alta);
				frame.repaint();
			}
		});
		mntmAltaDeClientes.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
		mnClientes.add(mntmAltaDeClientes);
		
		JMenuItem mntmClientesInactivos = new JMenuItem("Clientes Inactivos");			//Submenu del menu CLIENTES
		mntmClientesInactivos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {									//Evento para poder abrir la ventana 
				Clientes_inactivos clientes = new Clientes_inactivos();
				clientes.setBounds(10,11,620,413);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(clientes);
				frame.repaint();
					
			}
		});
		mntmClientesInactivos.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));		//Tipo de letra y tamaño
		mnClientes.add(mntmClientesInactivos);
		
		JMenu mnUsuarios = new JMenu("Usuarios");										//Menu de usuarios
		if (rol.equals("Administrador")) {
			mnUsuarios.setVisible(true);
		} else {
			mnUsuarios.setVisible(false);
		}
		mnUsuarios.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));					//Tipo de letra y tamaño 
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
		

		JMenuItem mntmAdminUsuarios = new JMenuItem("Admin Usuarios");			//Submenu del menu Usuarios
		mntmAdminUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {							//Evento para traer la ventana 
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
		mntmAdminUsuarios.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14)); 			//Tipo de letra y tamaño 
		mnUsuarios.add(mntmAdminUsuarios);
		
		JMenu mnMantenimiento = new JMenu("Mantenimiento"); 							//Menu Mantenimiento.
		if (rol.equals("Administrador")) {
			mnMantenimiento.setVisible(true);
		} else {
			mnMantenimiento.setVisible(false);
		}
		mnMantenimiento.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));				//Tipo de letra y tamaño
		menuBar.add(mnMantenimiento);
		
		JMenuItem mntmCambiosDeDias = new JMenuItem("Cambios de dias de bajas");		//Submenu del menu MANTENIMIENTO
		mntmCambiosDeDias.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));			//Tipo de letra y tamaño
		mnMantenimiento.add(mntmCambiosDeDias);
		
		JMenuItem mntmCambiosDePorsentaje = new JMenuItem("Cambios de porsentaje de puntos");	//Submenu del menu MANTENIMIENTO
		mntmCambiosDePorsentaje.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));			//Tipo de letra y tamaño
		mnMantenimiento.add(mntmCambiosDePorsentaje);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Backup de los datos");						//Submenu del menu MANTENIMIENTO
		mntmNewMenuItem.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));					//Tipo de letra y tamaño
		mnMantenimiento.add(mntmNewMenuItem);
		
		JMenu mnSalir = new JMenu("Cerrar Sesion");									//Menu para cerrar sesion
		mnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {								//Evento de cerrar ventana 
				System.exit(0);
			}
		});
		mnSalir.setFont(new Font("Segoe UI Emoji", Font.BOLD, 14));				//tipo de letra y tamaño
		menuBar.add(mnSalir);
		frame.getContentPane().setLayout(null);
		

		

	}
	
	private void title(String string) {
		// TODO Auto-generated method stub
		
	}

	public void mostrarPrincipal() {								//evento para mostrar la ventana 
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
