package clases;

import dao.DaoPersona;

public class Usuario {
	private Persona persona;
	private String usr;
	private String pwd;
	private int tipoUsuario;
	public Usuario(Persona persona, String usr, String pwd, int tipoUsuario) {
		super();
		this.persona = persona;
		this.usr = usr;
		this.pwd = pwd;
		this.tipoUsuario = tipoUsuario;
	}
	public Usuario(String args[]) throws Exception{
		try {
			this.persona = (Persona) new DaoPersona().getObject(args[0]);
			this.usr = args[1];
			this.pwd = args[2];
			this.tipoUsuario = Integer.parseInt(args[3]);
		}catch(Exception e) {
			
		}
	}
	public Usuario(){}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public String getUsr() {
		return usr;
	}
	public void setUsr(String usr) {
		this.usr = usr;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	@Override
	public String toString() {
		return "Usuario [persona=" + persona + ", usr=" + usr + ", pwd=" + pwd + ", tipoUsuario=" + tipoUsuario + "]";
	}

	
}
