package PROYECTO;

public class Producto {


	private int Codigo;
	private String Nombre;
	private double Precio;
	private int StockActual;
	private int StockMinimo;
	private int StockMaximo;
	
	
	public Producto(int Codigo, String Nombre, double Precio, int StockActual, int StockMinimo, int StockMaximo) {
		this.Codigo = Codigo;
		this.Nombre = Nombre;
		this.Precio = Precio;
		this.StockActual = StockActual;
		this.StockMinimo = StockActual;
		this.StockMaximo = StockMaximo;
	}
	
	
	
	public Producto() {
		
	}

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigoProducto(int Codigo) {
		Codigo = Codigo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	public int getStockActual() {
		return StockActual;
	}

	public void setStockActual(int stockActual) {
		StockActual = stockActual;
	}

	public int getStockMinimo() {
		return StockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		StockMinimo = stockMinimo;
	}

	public int getStockMaximo() {
		return StockMaximo;
	}

	public void setStockMaximo(int stockMaximo) {
		StockMaximo = stockMaximo;
	}
	
	
	
}
