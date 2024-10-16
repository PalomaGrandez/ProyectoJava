package PROYECTO;

public class Cliente {

	private int Codigo;
	private String Nombres;
	private String Apellidos;
	private String Direccion;
	private String Telefono;
	private String DNI;
	
	
	
	public Cliente(int Codigo ,String Nombres, String Apellidos, String Direccion, String Telefono, String DNI) {
		this.Codigo = Codigo;
		this.Nombres = Nombres;
		this.Apellidos = Apellidos;
		this.Direccion = Direccion;
		this.Telefono = Telefono;
		this.DNI = DNI;
	}
	
	public Cliente() {
		
	}

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int Codigo) {
		this.Codigo = Codigo;
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

	
	@Override
	public String toString() {
		return "Cliente [Codigo=" + Codigo + ", Nombres=" + Nombres + ", Apellidos=" + Apellidos + ", Direccion="
				+ Direccion + ", Telefono=" + Telefono + ", DNI=" + DNI + "]";
	}

	
	
	
	
}
