package clases;

import dao.DaoCliente;
import dao.DaoUsuario;

public class Compra {
	private int id;
	private Cliente cliente;
	private Usuario vendedor;
	private double total;
	private String fecha;
	public Compra(int id, Cliente cliente, Usuario vendedor, double total, String fecha) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.total = total;
		this.fecha = fecha;
	}
	public Compra(String args[]) throws Exception{
		this.id = Integer.parseInt(args[0]);
		this.cliente =(Cliente)new DaoCliente().getObject(args[1]);
		this.vendedor =(Usuario)new DaoUsuario().getObject(args[2]);
		this.total = Double.parseDouble(args[3]);
		this.fecha = args[4];
	}
	public Compra(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Usuario getVendedor() {
		return vendedor;
	}
	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Compra [id=" + id + ", cliente=" + cliente + ", vendedor=" + vendedor + ", total=" + total + ", fecha="
				+ fecha + "]";
	}
	
}
