package PROYECTO;

public class Cliente {

	private int CodigoCliente;
	private String Nombres;
	private String Apellidos;
	private String Direccion;
	private String Telefono;
	private String DNI;
	
	
	
	public Cliente(String Nombres, String Apellidos, String Direccion, String Telefono, String DNI, int CodigoCliente) {
		this.CodigoCliente = CodigoCliente;
		this.Nombres = Nombres;
		this.Apellidos = Apellidos;
		this.Direccion = Direccion;
		this.Telefono = Telefono;
		this.DNI = DNI;
	}
	
	public Cliente() {
		
	}

	public int getCodigoCliente() {
		return CodigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		CodigoCliente = codigoCliente;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	
	
	
	
	
}
