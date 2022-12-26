package models;

public class Cliente {
	private int CUIT;
	private String nombre;
	private String domicilio;
	private Instalacion instalacion;
	private String correoElectronico;
	
	public Cliente(int CUIT, String nombre, String domicilio, String correoElectronico) {
		super();
		this.CUIT = CUIT;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.correoElectronico = correoElectronico;
	}
	
	public int getCUIT() {
		return CUIT;
	}
	public void setCUIT(int CUIT) {
		this.CUIT = CUIT;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public void setInstalacion(Instalacion instalacion) {
		this.instalacion = instalacion;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	@Override
	public String toString() {
		return " "+ nombre + " CUIT: " +CUIT;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public Instalacion getInstalacion() {
		return instalacion;
	}
	
	
}
