package models;

public abstract class Empleado {
	protected int idEmpleado;
	protected String nombre;
	protected Acceso perfilAcceso;
	public Empleado(String nombre) {
		super();
		this.idEmpleado = Herramientas.contadorIdEmpleado();
		this.nombre = nombre;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public Acceso getPerfilAcceso() {
		return perfilAcceso;
	}
	public void setPerfilAcceso(Acceso perfilAcceso) {
		this.perfilAcceso = perfilAcceso;
	}
	public String getNombre() {
		return nombre;
	}
	@Override
	public String toString() {
		return   " "+nombre + "\n ID de empleado: " + idEmpleado;
	}
	
	
}
