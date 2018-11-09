package clases;

public class Producto {
	private int id;
	private String nombre;
	private String color;
	private String talla;
	private String detalle;
	private int cantidad;
	private double precio;
	public Producto(int id, String nombre, String color, String talla, String detalle, int cantidad, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.color = color;
		this.talla = talla;
		this.detalle = detalle;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	public Producto(String args[]) throws Exception{
		this.id = Integer.parseInt(args[0]);
		this.nombre = args[1];
		this.color = args[2];
		this.talla = args[3];
		this.detalle = args[4];
		this.cantidad = Integer.parseInt(args[5]);
		this.precio = Double.parseDouble(args[6]);
	}
	public Producto(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", color=" + color + ", talla=" + talla + ", detalle="
				+ detalle + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}
	
}
