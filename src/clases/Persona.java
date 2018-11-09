package clases;

public class Persona {
	private int id;
	private String nombre;
	private String apellidoPat;
	private String apellidoMat;
	private String fechaNac;
	private String direccion;
	private String email;
	
	public Persona(int id, String nombre, String apellidoPat, String apellidoMat, String fechaNac, String direccion,
			String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidoPat = apellidoPat;
		this.apellidoMat = apellidoMat;
		this.fechaNac = fechaNac;
		this.direccion = direccion;
		this.email = email;
	}
	public Persona(String args[]) throws Exception{
		try {
			this.id =Integer.parseInt(args[0]);
			this.nombre =args[1];
			this.apellidoPat =args[2];
			this.apellidoMat =args[3];
			this.fechaNac =args[4];
			this.direccion =args[5];
			this.email =args[6];
		}catch(Exception e) {
			
		}
	}
	public Persona(){}
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
	public String getApellidoPat() {
		return apellidoPat;
	}
	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}
	public String getApellidoMat() {
		return apellidoMat;
	}
	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}
	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidoPat=" + apellidoPat + ", apellidoMat="
				+ apellidoMat + ", fechaNac=" + fechaNac + ", direccion=" + direccion + ", email=" + email + "]";
	}
	
	
}
