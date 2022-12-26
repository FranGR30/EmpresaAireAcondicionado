package models;

public class AdministradorSistema extends Empleado {
	public AdministradorSistema(String nombre) {
		super(nombre);
		this.perfilAcceso = Acceso.ADMINISTRADOR_SISTEMA;
	}

	public void altaArticulo(Articulo articuloBusqueda,int cantidad) {
		for(Articulo a:Empresa.getInstancia().getArticulos()) {
			if (a.getClass().equals(articuloBusqueda.getClass())){
				a.setCantidad(a.getCantidad() + cantidad);
			}
		}
	}
	
	public void bajaArticulo(Articulo articuloBusqueda,int cantidad) {
		for(Articulo a:Empresa.getInstancia().getArticulos()) {
			if (a.getClass().equals(articuloBusqueda.getClass())){
				if(a.getCantidad() - cantidad < 0) {
					a.setCantidad(0);
				}else {
					a.setCantidad(a.getCantidad() - cantidad);
				}
			}
		}
	}

	public void modificarArticulo(Articulo articuloBusqueda,double precio) {
		for(Articulo a:Empresa.getInstancia().getArticulos()) {
			if (a.getClass().equals(articuloBusqueda.getClass())){
				a.setPrecio(precio);
			}
		}
	}
	public void altaTecnico(String nombre, Seniority seniority,Turno turnoLaboral) {
		Tecnico nuevoTecnico = new Tecnico(nombre,seniority,turnoLaboral);
		Empresa.getInstancia().getEmpleados().add(nuevoTecnico);
	}
	public void bajaTecnico(int idEmpleadoTecnico) {
		for (Tecnico t:Empresa.getInstancia().listarTecnicos()) {
			if (t.getIdEmpleado() == idEmpleadoTecnico) {
				Empresa.getInstancia().getEmpleados().remove(t);
				t = null;
			}
		}
	}
	public void modificareniorityTecnico(int idEmpleadoTecnico,Seniority seniority) {
		for (Tecnico t:Empresa.getInstancia().listarTecnicos()) {
			if (t.getIdEmpleado() == idEmpleadoTecnico) {
				t.setSeniority(seniority);
			}
		}
	}
	
	public void modificarSalario(Seniority seniority,double nuevoSalario) {
		seniority.setSalarioHora(nuevoSalario);
	}
	public void modificarCostoViaje(double nuevoCostoViaje ) {
		Instalacion.setCostoViaje(nuevoCostoViaje);
	}
	
}
