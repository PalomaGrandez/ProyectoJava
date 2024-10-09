package PROYECTO;

public class Producto {

	
	private int CodigoProducto;
	private String Nombre;
	private double Precio;
	private int StockActual;
	private int StockMinimo;
	private int StockMaximo;
	
	
	public Producto(int CodigoProducto, String Nombre, double Precio, int StockActual, int StockMinimo, int StockMaximo) {
		this.CodigoProducto = CodigoProducto;
		this.Nombre = Nombre;
		this.Precio = Precio;
		this.StockActual = StockActual;
		this.StockMinimo = StockActual;
		this.StockMaximo = StockMaximo;
	}
	
	
	
	public Producto() {
		
	}

	public int getCodigoProducto() {
		return CodigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		CodigoProducto = codigoProducto;
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
