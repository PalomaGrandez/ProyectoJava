package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmReProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextArea textArea;
	private JLabel lblNewLabel_3;
	private JButton btnVolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmReProductos frame = new frmReProductos();
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
	public frmReProductos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().setLayout(null);
		{
			lblNewLabel = new JLabel("REPORTES");
			lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 25));
			lblNewLabel.setBounds(204, 11, 135, 32);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("---------------");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
			lblNewLabel_1.setBounds(204, 70, 135, 26);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("PRODUCTOS");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_2.setBounds(220, 36, 103, 20);
			contentPane.add(lblNewLabel_2);
		}
		{
			textArea = new JTextArea();
			textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textArea.setBounds(10, 99, 524, 286);
			contentPane.add(textArea);
		}
		{
			lblNewLabel_3 = new JLabel("Stock");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_3.setBounds(249, 57, 45, 20);
			contentPane.add(lblNewLabel_3);
		}
		{
			btnVolver = new JButton("VOLVER");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnVolver(e);
				}
			});
			btnVolver.setBounds(39, 25, 107, 23);
			contentPane.add(btnVolver);
		}
	}
	protected void actionPerformedBtnVolver(ActionEvent e) {
		frmInicio obj= new frmInicio();
		obj.setVisible(true);
		this.setVisible(false);
	}
}
