package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtStockActual;
	private JTextField txtStockMinimo;
	private JTextField txtStockMaximo;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioProducto frame = new FormularioProducto();
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
	public FormularioProducto() {
		setTitle("Mantenimiento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().setLayout(null);
	
	    
		JLabel lblNewLabel = new JLabel("Mantenimiento Producto");
		lblNewLabel.setBounds(248, 10, 221, 21);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 64, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 100, 63, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Precio");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(10, 141, 63, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Stock Actual");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(10, 176, 99, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Stock Minino");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4.setBounds(10, 213, 85, 13);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Stock Maximo");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_5.setBounds(10, 252, 92, 13);
		contentPane.add(lblNewLabel_1_5);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(134, 62, 121, 19);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(134, 98, 121, 19);
		contentPane.add(txtNombre);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(134, 139, 121, 19);
		contentPane.add(txtPrecio);
		
		txtStockActual = new JTextField();
		txtStockActual.setColumns(10);
		txtStockActual.setBounds(134, 176, 121, 19);
		contentPane.add(txtStockActual);
		
		txtStockMinimo = new JTextField();
		txtStockMinimo.setColumns(10);
		txtStockMinimo.setBounds(134, 211, 121, 19);
		contentPane.add(txtStockMinimo);
		
		txtStockMaximo = new JTextField();
		txtStockMaximo.setColumns(10);
		txtStockMaximo.setBounds(134, 250, 121, 19);
		contentPane.add(txtStockMaximo);
		
		JButton btnIngreso = new JButton("Ingreso");
		btnIngreso.setBounds(424, 100, 85, 21);
		contentPane.add(btnIngreso);
		
		JButton btnModificacion = new JButton("Modificacion");
		btnModificacion.setBounds(556, 97, 113, 21);
		contentPane.add(btnModificacion);
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.setBounds(424, 173, 85, 21);
		contentPane.add(btnConsulta);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(556, 173, 85, 21);
		contentPane.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 296, 663, 138);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Precio", "Stock Actual", "Stock Minimo", "Stock Maximo"
			}
		));
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnNewButton(e);
			}
		});
		btnNewButton.setBounds(488, 137, 89, 23);
		contentPane.add(btnNewButton);
		
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		frmInicio obj=new frmInicio();
		obj.setVisible(true);
		this.setVisible(false);
	}
}

