package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

public class FrmVentas1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmVentas1 frame = new FrmVentas1();
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
	public FrmVentas1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().setLayout(null);
		{
			lblNewLabel = new JLabel("Sistema de Ventas");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			lblNewLabel.setBounds(329, 11, 151, 20);
			contentPane.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setBounds(154, 55, 178, 20);
			contentPane.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(154, 99, 178, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(154, 141, 178, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			textField_3 = new JTextField();
			textField_3.setBounds(154, 182, 178, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);
		}
		{
			lblNewLabel_1 = new JLabel("Codigo cliente:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_1.setBounds(10, 53, 122, 20);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Codigo Producto:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_2.setBounds(10, 97, 140, 20);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("Precio Producto:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_3.setBounds(10, 141, 135, 20);
			contentPane.add(lblNewLabel_3);
		}
		{
			lblNewLabel_4 = new JLabel("Cantidad:");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_4.setBounds(9, 182, 79, 20);
			contentPane.add(lblNewLabel_4);
		}
		{
			btnNewButton = new JButton("Vender");
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnNewButton.setBounds(440, 79, 89, 23);
			contentPane.add(btnNewButton);
		}
		{
			btnNewButton_1 = new JButton("Volver");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnNewButton_1(e);
				}
			});
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnNewButton_1.setBounds(440, 121, 89, 23);
			contentPane.add(btnNewButton_1);
		}
		{
			textArea = new JTextArea();
			textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textArea.setBounds(35, 255, 738, 236);
			contentPane.add(textArea);
		}
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		frmInicio obj= new frmInicio();
		obj.setVisible(true);
		this.setVisible(false);
	}
}
