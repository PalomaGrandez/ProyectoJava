package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import java.awt.Component;
import javax.swing.DebugGraphics;
import java.awt.Insets;
import java.awt.Frame;
import javax.swing.JMenuItem;

public class frmInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JButton btnVentas;
	private JButton btnAlmacen;
	private JLabel lblNewLabel;
	private JMenu mnNewMenu;
	private JMenuItem mntmCliente;
	private JMenuItem mntmProducto;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmGeneral;
	private JMenuItem mntmStock;
	private JMenuItem mntmUnidades;
	private JMenuItem mntmImporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmInicio frame = new frmInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public frmInicio() {
		setExtendedState(Frame.MAXIMIZED_HORIZ);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 349, 287);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().setLayout(null);
		
		{
			lblNewLabel = new JLabel("LAP STORE");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
			lblNewLabel.setBounds(84, 70, 165, 78);
			getContentPane().add(lblNewLabel);
		}
		{
			menuBar = new JMenuBar();
			menuBar.setMargin(new Insets(0, 50, 0, 9));
			menuBar.setInheritsPopupMenu(true);
			menuBar.setFocusable(false);
			menuBar.setAutoscrolls(true);
			menuBar.setBorder(null);
			menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			menuBar.setBackground(Color.WHITE);
			setJMenuBar(menuBar);
			{
				btnVentas = new JButton("Ventas");
				btnVentas.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BtnVentas(e);
						
					}
				});
				{
					mnNewMenu = new JMenu("Mantenimiento");
					mnNewMenu.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							actionPerformed(e);
						}
					});
					menuBar.add(mnNewMenu);
					{
						mntmCliente = new JMenuItem("Cliente");
						mntmCliente.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								actionPerformedMntmNewMenuItem(e);
							}
						});
						mnNewMenu.add(mntmCliente);
					}
					{
						mntmProducto = new JMenuItem("Producto");
						mntmProducto.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								actionPerformedMntmNewMenuItem_1(e);
							}
						});
						mnNewMenu.add(mntmProducto);
					}
				}
				btnVentas.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
				menuBar.add(btnVentas);
				
				}
			{
				btnAlmacen = new JButton("Almacén");
				btnAlmacen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						actionPerformedBtnAlmacen(e);
					}
				});
				btnAlmacen.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
				menuBar.add(btnAlmacen);
			}
			{
				mnNewMenu_1 = new JMenu("Reportes");
				menuBar.add(mnNewMenu_1);
				{
					mntmGeneral = new JMenuItem("Lista General");
					mntmGeneral.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							actionPerformedMntmGeneral(e);
						}
					});
					mnNewMenu_1.add(mntmGeneral);
				}
				{
					mntmStock = new JMenuItem("Productos Stock");
					mntmStock.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							actionPerformedMntmStock(e);
						}
					});
					mnNewMenu_1.add(mntmStock);
				}
				{
					mntmUnidades = new JMenuItem("Productos Unidades");
					mntmUnidades.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							actionPerformedMntmUnidades(e);
						}
					});
					mnNewMenu_1.add(mntmUnidades);
				}
				{
					mntmImporte = new JMenuItem("Productos Importe");
					mntmImporte.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							actionPerformedMntmImporte(e);
						}
					});
					mnNewMenu_1.add(mntmImporte);
				}
			}
		}
		
		
	}
	protected void BtnVentas(ActionEvent e) {
		FrmVentas1 obj=new FrmVentas1();
		obj.setVisible(true);
		this.setVisible(false);
	}

	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		// pones el nombre de jframe
		FormularioCliente obj=new FormularioCliente();
		obj.setVisible(true);
		this.setVisible(false);
	}
	protected void actionPerformedMntmNewMenuItem_1(ActionEvent e) {
		//pones el nombre de jframe
				FormularioProducto obj=new FormularioProducto();
				obj.setVisible(true);
				this.setVisible(false);
	}
	protected void actionPerformedMntmGeneral(ActionEvent e) {
		frmReportes obj=new frmReportes();
		obj.setVisible(true);
		this.setVisible(false);
	}
	protected void actionPerformedMntmStock(ActionEvent e) {
		frmReProductos obj=new frmReProductos();
		obj.setVisible(true);
		this.setVisible(false);
	}
	protected void actionPerformedMntmUnidades(ActionEvent e) {
		frmReProUnidades obj=new frmReProUnidades();
		obj.setVisible(true);
		this.setVisible(false);
	}
	
	protected void actionPerformedMntmImporte(ActionEvent e) {
		frmReProImporTotal obj=new frmReProImporTotal();
		obj.setVisible(true);
		this.setVisible(false);
	}
	protected void actionPerformedBtnAlmacen(ActionEvent e) {
		FormularioAlmacen obj=new FormularioAlmacen();
		obj.setVisible(true);
		this.setVisible(false);
	}
}
