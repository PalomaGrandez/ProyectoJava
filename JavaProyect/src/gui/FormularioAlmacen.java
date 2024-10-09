package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioAlmacen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoProducto;
	private JTextField txtUnidades;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioAlmacen frame = new FormularioAlmacen();
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
	public FormularioAlmacen() {
		setTitle("Almacen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Almacen");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(263, 10, 92, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo Producto");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(24, 78, 119, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Unidades");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(24, 121, 119, 13);
		contentPane.add(lblNewLabel_1_1);
		
		txtCodigoProducto = new JTextField();
		txtCodigoProducto.setBounds(166, 76, 96, 19);
		contentPane.add(txtCodigoProducto);
		txtCodigoProducto.setColumns(10);
		
		txtUnidades = new JTextField();
		txtUnidades.setBounds(166, 119, 96, 19);
		contentPane.add(txtUnidades);
		txtUnidades.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(461, 94, 85, 21);
		contentPane.add(btnIngresar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(131, 191, 347, 113);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CodigoProducto", "Unidades"
			}
		));
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnNewButton(e);
			}
		});
		btnNewButton.setBounds(457, 44, 89, 23);
		contentPane.add(btnNewButton);
	}

	protected void actionPerformedBtnNewButton(ActionEvent e) {
		frmInicio obj=new frmInicio();
		obj.setVisible(true);
		this.setVisible(false);
	}
}
