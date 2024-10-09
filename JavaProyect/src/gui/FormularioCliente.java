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

public class FormularioCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtDNI;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioCliente frame = new FormularioCliente();
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
	public FormularioCliente() {
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
		
		JLabel lblNewLabel = new JLabel("Mantenimiento Cliente");
		lblNewLabel.setBounds(248, 10, 200, 21);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 64, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombres");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 100, 63, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Apellidos");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(10, 141, 63, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Direccion");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(10, 176, 71, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Telefono");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4.setBounds(10, 213, 63, 13);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("DNI");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_5.setBounds(10, 252, 45, 13);
		contentPane.add(lblNewLabel_1_5);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(134, 62, 121, 19);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(134, 98, 121, 19);
		contentPane.add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(134, 139, 121, 19);
		contentPane.add(txtApellidos);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(134, 176, 121, 19);
		contentPane.add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(134, 211, 121, 19);
		contentPane.add(txtTelefono);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(134, 250, 121, 19);
		contentPane.add(txtDNI);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 302, 658, 128);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombres", "Apellidos", "Direccion", "Telefono", "DNI"
			}
		));
		
		JButton btnIngreso = new JButton("Ingreso");
		btnIngreso.setBounds(424, 100, 85, 21);
		contentPane.add(btnIngreso);
		
		JButton btnModificacion = new JButton("Modificacion");
		btnModificacion.setBounds(556, 97, 114, 21);
		contentPane.add(btnModificacion);
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.setBounds(424, 173, 85, 21);
		contentPane.add(btnConsulta);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(556, 173, 85, 21);
		contentPane.add(btnEliminar);
		
		JButton btnNewButton_1 = new JButton("VOLVER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnNewButton_1(e);
			}
		});
		btnNewButton_1.setBounds(480, 137, 107, 23);
		contentPane.add(btnNewButton_1);
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		frmInicio obj=new frmInicio();
		obj.setVisible(true);
		this.setVisible(false);
	}
}

