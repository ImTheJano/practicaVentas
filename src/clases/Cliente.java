package clases;

import dao.DaoPersona;

public class Cliente {
	private Persona persona;
	private double saldo;
	private int nCompras;
	public Cliente(Persona persona, double saldo, int nCompras) {
		super();
		this.persona = persona;
		this.saldo = saldo;
		this.nCompras = nCompras;
	}
	public Cliente(String args[]) throws Exception{
		this.persona = (Persona) new DaoPersona().getObject(args[0]);
		this.saldo = Double.parseDouble(args[1]);
		this.nCompras = Integer.parseInt(args[2]);
	}
	public Cliente(){}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public int getnCompras() {
		return nCompras;
	}
	public void setnCompras(int nCompras) {
		this.nCompras = nCompras;
	}
	
}
