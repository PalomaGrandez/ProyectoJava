package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import PROYECTO.ArrayListProducto;
import PROYECTO.Producto;

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

public class FormularioProducto extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombres;
	private JTextField txtPrecio;
	private JTextField txtStockActual;
	private JTextField txtStockMinimo;
	private JTextField txtStockMaximo;
	private JComboBox cboOperaciones;
	private JTable miTabla;
	private JScrollPane scrollPane;
	boolean ok = false, ok1 = true;
	
	// Declaración de objeto que permite escribir en el control JTable
	DefaultTableModel miLista;
	// Declarar el objeto de la clase ArregloAlumnos
	ArrayListProducto Obj = new ArrayListProducto();
	// Declarar e Inicializar los nombres de las columnas a visualizar
	String Columnas[] = {"CODIGO","NOMBRE","PRECIO", "STOCK ACTUAL","STOCK MINIMO","STOCK MAXIMO"};
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
			Filas[i][1] = Obj.obtener(i).getNombre();
			Filas[i][2] = Obj.obtener(i).getPrecio();
			Filas[i][3] = Obj.obtener(i).getStockActual();
			Filas[i][4] = Obj.obtener(i).getStockMinimo();
			Filas[i][5] = Obj.obtener(i).getStockMaximo();
			miLista.addRow(Filas[i]);
		}
		// Cargar el control JTable con los datos del objeto miLista
		miTabla.setModel(miLista);
	}

	// Método para guardar en un archivo de tipo texto
	void grabarProductos() {
		try {
				PrintWriter pw;	// Archivo Lógico
				Producto x;
				String linea;
				pw = new PrintWriter(new FileWriter("productos.txt")); // Archivo Fisico
				for(int i = 0; i < Obj.tamaño(); i++) {
					x = Obj.obtener(i);
					linea = x.getCodigo() + ";" +
							x.getNombre() + ";" +
							x.getPrecio() + ";" +
							x.getStockActual() + ";" +
							x.getStockMinimo() + ";" +
							x.getStockMaximo();
					pw.println(linea);
				}
				pw.close();
		} catch (Exception e) {
				System.out.println("*** ERROR:" + e.getMessage());
		}
	}
	
	// Método leerAlumnos
	// Método leerClientes, siguiendo el mismo estilo que leerAlumnos
	void leerProductos() {
	    BufferedReader br;
	    String linea;
	    String[] s;
	    try {
	    	java.io.File archivo = new java.io.File("productos.txt");
	        if (!archivo.exists()) {
	            archivo.createNewFile(); // Crea el archivo si no existe
	        }
	        br = new BufferedReader(new FileReader("productos.txt"));
	        while ((linea = br.readLine()) != null) {
	            s = linea.split(";");
	            // Agregar cliente utilizando los datos de la línea
	            Obj.adicionar(new Producto(
	                Integer.parseInt(s[0]),    // Código
	                s[1],                      // Nombre
	                Double.parseDouble(s[2]),  // Precio
	                Integer.parseInt(s[3]),    // Stock Actual
	                Integer.parseInt(s[4]),	   //  Stock Minimo
	                Integer.parseInt(s[5])	   //  Stock Maximo
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
		txtPrecio.setEnabled(estado);
		txtStockActual.setEnabled(estado);
		txtStockMinimo.setEnabled(estado);
		txtStockMaximo.setEnabled(estado);
		btnBuscar.setVisible(estado);
		btnConfirmar.setVisible(estado);
		btnGrabar.setVisible(estado);
	}
	
	// Método para limpiar las cajas e inicializar el formulario
	void LimpiarFormulario() {
		txtCodigo.setText("");
		txtNombres.setText("");
		txtPrecio.setText("");
		txtStockActual.setText("");
		txtStockMinimo.setText("");
		txtStockMaximo.setText("");
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
					FormularioProducto frame = new FormularioProducto();
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
	public FormularioProducto() {
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
			txtPrecio = new JTextField();
			
			txtPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
			txtPrecio.setBounds(82, 381, 274, 23);
			contentPane.add(txtPrecio);
			txtPrecio.setColumns(10);
		}
		{
			txtStockActual = new JTextField();
			
			
			txtStockActual.setFont(new Font("Tahoma", Font.BOLD, 14));
			txtStockActual.setBounds(82, 414, 274, 23);
			contentPane.add(txtStockActual);
			txtStockActual.setColumns(10);
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
		
		txtStockMinimo = new JTextField();
		txtStockMinimo.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtStockMinimo.setEnabled(false);
		txtStockMinimo.setColumns(10);
		txtStockMinimo.setBounds(82, 447, 274, 23);
		contentPane.add(txtStockMinimo);
		
		txtStockMaximo = new JTextField();
		txtStockMaximo.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtStockMaximo.setEnabled(false);
		txtStockMaximo.setColumns(10);
		txtStockMaximo.setBounds(82, 480, 274, 23);
		contentPane.add(txtStockMaximo);
		
		JLabel a = new JLabel("Codigo");
		a.setBounds(10, 315, 45, 13);
		contentPane.add(a);
		
		JLabel lblNombres = new JLabel("Nombre");
		lblNombres.setBounds(10, 348, 45, 13);
		contentPane.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Precio");
		lblApellidos.setBounds(10, 381, 45, 13);
		contentPane.add(lblApellidos);
		
		JLabel lblDireccion = new JLabel("Stock Actual");
		lblDireccion.setBounds(10, 414, 45, 13);
		contentPane.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Stock Minimo");
		lblTelefono.setBounds(10, 447, 45, 13);
		contentPane.add(lblTelefono);
		
		JLabel lblDni = new JLabel("Stock Maximo");
		lblDni.setBounds(10, 480, 45, 13);
		contentPane.add(lblDni);
		leerProductos();
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
					txtPrecio.setEnabled(false);
					txtStockActual.setEnabled(false);
					txtStockMinimo.setEnabled(false);
					txtStockMaximo.setEnabled(false);
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
					txtPrecio.setEnabled(false);
					txtStockActual.setEnabled(false);
					txtStockMinimo.setEnabled(false);
					txtStockMaximo.setEnabled(false);
					break;
		}
	}
	
	// Método para grabar el nuevo registro en el control JTable y en el archivo de texto
	protected void BtnGrabar(ActionEvent e) {
	    if (!ok) {
	        // Crear un nuevo cliente y agregarlo
	        Obj.adicionar(new Producto(
	            Integer.parseInt(txtCodigo.getText()),   // Código
	            txtNombres.getText(),                        // Nombres
	            Double.parseDouble(txtPrecio.getText()),                  // Apellidos
	            Integer.parseInt(txtStockActual.getText()),                  // Dirección
	            Integer.parseInt(txtStockMinimo.getText()),                   // Teléfono
	            Integer.parseInt(txtStockMaximo.getText())                         // DNI
	        ));
	    } else {
	        // Modificar el cliente existente
	        int codigo = Integer.parseInt(txtCodigo.getText());
	        int pos = Obj.posicion(codigo);
	        Producto x = Obj.buscar(codigo);

	        if (x != null) {
	            x.setNombre(txtNombres.getText());
	            x.setPrecio(Double.parseDouble(txtPrecio.getText()));
	            x.setStockActual( Integer.parseInt(txtStockActual.getText()));
	            x.setStockMinimo( Integer.parseInt(txtStockMinimo.getText()));
	            x.setStockMaximo( Integer.parseInt(txtStockMaximo.getText()));

	            Obj.modificar(pos, x);
	            ok = false;
	        }
	    }
	    // Recargar la tabla y guardar los datos en el archivo
	    CargarDatos();
	    grabarProductos();
	    LimpiarFormulario();
	}

	
	// Método para consultar un registro
	protected void BtnBuscar(ActionEvent e) {
		int codigo = Integer.parseInt(txtCodigo.getText());
		if(Obj.buscar(codigo) != null) {
			txtNombres.setText(Obj.buscar(codigo).getNombre());
			txtPrecio.setText(Obj.buscar(codigo).getPrecio() + "");
			txtStockActual.setText(Obj.buscar(codigo).getStockActual() + "");
			txtStockMinimo.setText(Obj.buscar(codigo).getStockMinimo() + "");
			txtStockMaximo.setText(Obj.buscar(codigo).getStockMaximo() + "");
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
		Producto x = new Producto();
		int codigo = Integer.parseInt(txtCodigo.getText());
		x = Obj.buscar(codigo);
		if(x != null) {
			Obj.eliminar(x);
			CargarDatos();
			grabarProductos();
			LimpiarFormulario();
		}
		else 
			JOptionPane.showMessageDialog(null, "*** ERROR, CODIGO NO EXISTE ***");					
	}
}

