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

public class frmReProUnidades extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmReProUnidades frame = new frmReProUnidades();
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
	public frmReProUnidades() {
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
			textArea = new JTextArea();
			textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			textArea.setBounds(10, 99, 524, 286);
			contentPane.add(textArea);
		}
		{
			btnNewButton_1 = new JButton("VOLVER");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnNewButton_1(e);
				}
			});
			btnNewButton_1.setBounds(37, 27, 107, 23);
			contentPane.add(btnNewButton_1);
		}
		{
			lblNewLabel = new JLabel("REPORTES");
			lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 25));
			lblNewLabel.setBounds(204, 0, 135, 32);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("PRODUCTOS");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_1.setBounds(220, 25, 103, 20);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("Unidades");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_2.setBounds(234, 46, 75, 20);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel_3 = new JLabel("---------------");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 21));
			lblNewLabel_3.setBounds(204, 59, 135, 26);
			contentPane.add(lblNewLabel_3);
		}
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		frmInicio obj= new frmInicio();
		obj.setVisible(true);
		this.setVisible(false);
	}
}
