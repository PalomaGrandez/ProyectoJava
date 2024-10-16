package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import PROYECTO.ArrayListCliente;
import PROYECTO.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtDNI;
	private JComboBox cboOperaciones;
	private JTable miTabla;
	private JScrollPane scrollPane;
	boolean ok = false, ok1 = true;
	
	// Declaración de objeto que permite escribir en el control JTable
	DefaultTableModel miLista;
	// Declarar el objeto de la clase ArregloAlumnos
	ArrayListCliente Obj = new ArrayListCliente();
	// Declarar e Inicializar los nombres de las columnas a visualizar
	String Columnas[] = {"CODIGO","NOMBRES","APELLIDOS", "DIRECCION","TELEFONO","DNI"};
	// Declarar e Inicializar las filas a visualizar
	Object Filas[][];
	private JButton btnGrabar;
	private JButton btnBuscar;
	private JButton btnConfirmar;

	
	// Realiza la carga de datos en el contro JTable
	void CargarDatos() {
		miLista = new DefaultTableModel();
		Filas = new Object[Obj.tamaño()][6];
		// Carga de nombres columnas
		for(String col:Columnas)miLista.addColumn(col);
		// Carga de Filas
		for(int i = 0; i < Filas.length; i++) {
			Filas[i][0] = Obj.obtener(i).getCodigo();
			Filas[i][1] = Obj.obtener(i).getNombres();
			Filas[i][2] = Obj.obtener(i).getApellidos();
			Filas[i][3] = Obj.obtener(i).getDireccion();
			Filas[i][4] = Obj.obtener(i).getTelefono();
			Filas[i][5] = Obj.obtener(i).getDNI();
			miLista.addRow(Filas[i]);
		}
		// Cargar el control JTable con los datos del objeto miLista
		miTabla.setModel(miLista);
	}

	// Método para guardar en un archivo de tipo texto
	void grabarClientes() {
		try {
				PrintWriter pw;	// Archivo Lógico
				Cliente x;
				String linea;
				pw = new PrintWriter(new FileWriter("clientes.txt")); // Archivo Fisico
				for(int i = 0; i < Obj.tamaño(); i++) {
					x = Obj.obtener(i);
					linea = x.getCodigo() + ";" +
							x.getNombres() + ";" +
							x.getApellidos() + ";" +
							x.getDireccion() + ";" +
							x.getTelefono() + ";" +
							x.getDNI();
					pw.println(linea);
				}
				pw.close();
		} catch (Exception e) {
				System.out.println("*** ERROR:" + e.getMessage());
		}
	}
	
	// Método leerAlumnos
	// Método leerClientes, siguiendo el mismo estilo que leerAlumnos
	void leerClientes() {
	    BufferedReader br;
	    String linea;
	    String[] s;
	    try {
	    	java.io.File archivo = new java.io.File("clientes.txt");
	        if (!archivo.exists()) {
	            archivo.createNewFile(); // Crea el archivo si no existe
	        }
	        br = new BufferedReader(new FileReader("clientes.txt"));
	        while ((linea = br.readLine()) != null) {
	            s = linea.split(";");
	            // Agregar cliente utilizando los datos de la línea
	            Obj.adicionar(new Cliente(
	                Integer.parseInt(s[0]),  // Código
	                s[1],                    // Nombres
	                s[2],                    // Apellidos
	                s[3],                    // Dirección
	                s[4],                    // Teléfono
	                s[5]                     // DNI
	            ));
	        }
	        br.close();
	    } catch (Exception e) {
	        System.out.println("*** ERROR: " + e.getMessage());
	    }
	}

	
	// Método para habilitar o desabilitar los controles del formulario
	void HabilitaControles(boolean estado) {
		txtCodigo.setEnabled(estado);
		txtNombres.setEnabled(estado);
		txtApellidos.setEnabled(estado);
		txtDireccion.setEnabled(estado);
		txtTelefono.setEnabled(estado);
		txtDNI.setEnabled(estado);
		btnBuscar.setVisible(estado);
		btnConfirmar.setVisible(estado);
		btnGrabar.setVisible(estado);
	}
	
	// Método para limpiar las cajas e inicializar el formulario
	void LimpiarFormulario() {
		txtCodigo.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtDNI.setText("");
		btnBuscar.setVisible(false);
		btnConfirmar.setVisible(false);
		btnGrabar.setVisible(false);
		cboOperaciones.setSelectedIndex(0);
	}
	
	// Método Prinicipal del Formulario
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

	// Método para obtener el siguiente codigo a registrar
	int ObtenerCodigo() {
	    if (Obj.tamaño() == 0) {
	        return 1; // Si la lista está vacía, iniciar con el código 1
	    }
	    int cod = Obj.obtener(Obj.tamaño() - 1).getCodigo();
	    return ++cod; // Devolver el siguiente código disponible
	}
	
	// Método Constructor del formulario
	public FormularioCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			txtCodigo = new JTextField();
			txtCodigo.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedTxtCodigo(e);
				}
			});
			txtCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
			txtCodigo.setBounds(82, 315, 274, 23);
			contentPane.add(txtCodigo);
			txtCodigo.setColumns(10);
		}
		{
			txtNombres = new JTextField();
			
			txtNombres.setFont(new Font("Tahoma", Font.BOLD, 14));
			txtNombres.setBounds(82, 348, 274, 23);
			contentPane.add(txtNombres);
			txtNombres.setColumns(10);
		}
		{
			txtApellidos = new JTextField();
			
			txtApellidos.setFont(new Font("Tahoma", Font.BOLD, 14));
			txtApellidos.setBounds(82, 381, 274, 23);
			contentPane.add(txtApellidos);
			txtApellidos.setColumns(10);
		}
		{
			txtDireccion = new JTextField();
			
			
			txtDireccion.setFont(new Font("Tahoma", Font.BOLD, 14));
			txtDireccion.setBounds(82, 414, 274, 23);
			contentPane.add(txtDireccion);
			txtDireccion.setColumns(10);
		}
		{
			cboOperaciones = new JComboBox();
			cboOperaciones.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CboOperaciones(e);
				}
			});
			cboOperaciones.setFont(new Font("Tahoma", Font.BOLD, 14));
			cboOperaciones.setModel(new DefaultComboBoxModel(new String[] {"-- Seleccionar --", "Adicionar", "Consultar", "Modificar", "Eliminar"}));
			cboOperaciones.setBounds(390, 327, 117, 23);
			contentPane.add(cboOperaciones);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(82, 26, 678, 225);
			contentPane.add(scrollPane);
			{
				miTabla = new JTable();
				scrollPane.setViewportView(miTabla);
			}
		}
		{
			btnGrabar = new JButton("Grabar");
			btnGrabar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BtnGrabar(e);
				}
			});
			btnGrabar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnGrabar.setBounds(390, 380, 117, 25);
			contentPane.add(btnGrabar);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BtnBuscar(e);
				}
			});
			btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnBuscar.setBounds(390, 380, 117, 25);
			contentPane.add(btnBuscar);
		}
		{
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BtnConfirmar(e);
				}
			});
			btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnConfirmar.setBounds(390, 380, 117, 25);
			contentPane.add(btnConfirmar);
		}
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTelefono.setEnabled(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(82, 447, 274, 23);
		contentPane.add(txtTelefono);
		
		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtDNI.setEnabled(false);
		txtDNI.setColumns(10);
		txtDNI.setBounds(82, 480, 274, 23);
		contentPane.add(txtDNI);
		
		JLabel a = new JLabel("Codigo");
		a.setBounds(10, 315, 45, 13);
		contentPane.add(a);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(10, 348, 45, 13);
		contentPane.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 381, 45, 13);
		contentPane.add(lblApellidos);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 414, 45, 13);
		contentPane.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 447, 45, 13);
		contentPane.add(lblTelefono);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(10, 480, 45, 13);
		contentPane.add(lblDni);
		leerClientes();
		CargarDatos();
		HabilitaControles(false);
	}
	
	// Validación Codigo
	protected void keyTypedTxtCodigo(KeyEvent e) {
		int key = e.getKeyChar();

	    boolean numeros = key >= 48 && key <= 57; // 48 = VALOR ASCII digito 0, 57 = VALOR ASCII digito 9
	    // SOLO DIGITOS    
	    if (!numeros)
	    {
	        e.consume();
	    }
	    // LONGITUD MAYOR A 6
		if(txtCodigo.getText().length() == 4)
	    {
	        e.consume();
	    }
	}
	
	
	
	// Seleccion del combo
	protected void CboOperaciones(ActionEvent e) {
		int op = cboOperaciones.getSelectedIndex();
		switch (op) {
			// Adicionar
			case 1: HabilitaControles(true);
					LimpiarFormulario();
					btnGrabar.setVisible(true);
					btnBuscar.setVisible(false);
					btnConfirmar.setVisible(false);
					txtCodigo.setText(ObtenerCodigo()+"");
					txtCodigo.setEnabled(false);					
					break;
			// Consultar
			case 2: HabilitaControles(true);
					btnGrabar.setVisible(false);
					btnBuscar.setVisible(true);
					btnConfirmar.setVisible(false);
					txtNombres.setEnabled(false);
					txtApellidos.setEnabled(false);
					txtDireccion.setEnabled(false);
					txtTelefono.setEnabled(false);
					txtDNI.setEnabled(false);
					break;
			// Modificar
			case 3: HabilitaControles(true);
					btnGrabar.setVisible(false);
					btnBuscar.setVisible(true);
					btnConfirmar.setVisible(false);
					ok = true;
					break;
			// Eliminar
			case 4: HabilitaControles(true);
					btnGrabar.setVisible(false);
					btnBuscar.setVisible(true);
					btnConfirmar.setVisible(false);
					txtNombres.setEnabled(false);
					txtApellidos.setEnabled(false);
					txtDireccion.setEnabled(false);
					txtTelefono.setEnabled(false);
					txtDNI.setEnabled(false);
					break;
		}
	}
	
	// Método para grabar el nuevo registro en el control JTable y en el archivo de texto
	protected void BtnGrabar(ActionEvent e) {
	    if (!ok) {
	        // Crear un nuevo cliente y agregarlo
	        Obj.adicionar(new Cliente(
	            Integer.parseInt(txtCodigo.getText()),   // Código
	            txtNombres.getText(),                        // Nombres
	            txtApellidos.getText(),                  // Apellidos
	            txtDireccion.getText(),                  // Dirección
	            txtTelefono.getText(),                   // Teléfono
	            txtDNI.getText()                         // DNI
	        ));
	    } else {
	        // Modificar el cliente existente
	        int codigo = Integer.parseInt(txtCodigo.getText());
	        int pos = Obj.posicion(codigo);
	        Cliente x = Obj.buscar(codigo);

	        if (x != null) {
	            x.setNombres(txtNombres.getText());
	            x.setApellidos(txtApellidos.getText());
	            x.setDireccion(txtDireccion.getText());
	            x.setTelefono(txtTelefono.getText());
	            x.setDNI(txtDNI.getText());

	            Obj.modificar(pos, x);
	            ok = false;
	        }
	    }
	    // Recargar la tabla y guardar los datos en el archivo
	    CargarDatos();
	    grabarClientes();
	    LimpiarFormulario();
	}

	
	// Método para consultar un registro
	protected void BtnBuscar(ActionEvent e) {
		int codigo = Integer.parseInt(txtCodigo.getText());
		if(Obj.buscar(codigo) != null) {
			txtNombres.setText(Obj.buscar(codigo).getNombres());
			txtApellidos.setText(Obj.buscar(codigo).getApellidos() + "");
			txtDireccion.setText(Obj.buscar(codigo).getDireccion() + "");
			txtTelefono.setText(Obj.buscar(codigo).getTelefono() + "");
			txtDNI.setText(Obj.buscar(codigo).getDNI() + "");
			// En el caso de modificar
			if(ok) {
				btnBuscar.setVisible(false);
				btnGrabar.setVisible(true);
			}
			// En el caso de eliminar
			if(ok1) {
				btnBuscar.setVisible(false);
				btnConfirmar.setVisible(true);
			}
		}else JOptionPane.showMessageDialog(null, "*** ERROR, CODIGO NO EXISTE ***");		
	}
	
	// Método para eliminar un registro
	protected void BtnConfirmar(ActionEvent e) {
		Cliente x = new Cliente();
		int codigo = Integer.parseInt(txtCodigo.getText());
		x = Obj.buscar(codigo);
		if(x != null) {
			Obj.eliminar(x);
			CargarDatos();
			grabarClientes();
			LimpiarFormulario();
		}
		else 
			JOptionPane.showMessageDialog(null, "*** ERROR, CODIGO NO EXISTE ***");					
	}
}
