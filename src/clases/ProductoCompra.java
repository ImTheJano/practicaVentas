package clases;

import dao.DaoCompra;
import dao.DaoProducto;

public class ProductoCompra {
	private Compra compra;
	private Producto producto;
	private int cantidad;
	public ProductoCompra(Compra compra, Producto producto, int cantidad) {
		super();
		this.compra = compra;
		this.producto = producto;
		this.cantidad = cantidad;
	}
	public ProductoCompra(String args[]) throws Exception{
		this.compra = (Compra)new DaoCompra().getObject(args[0]);
		this.producto =(Producto)new DaoProducto().getObject(args[1]);
		this.cantidad = Integer.parseInt(args[2]);
	}
	public ProductoCompra(){}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "ProductoCompra [compra=" + compra + ", producto=" + producto + ", cantidad=" + cantidad + "]";
	}
	
}
