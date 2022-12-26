package models;

public class OperadorCallCenter extends Empleado {

	public OperadorCallCenter(String nombre) {
		super(nombre);
		this.perfilAcceso = Acceso.OPERADOR_CALLCENTER;
	}
	
	public void crearCliente(int CUIT, String nombre, String domicilio,String correoElectronico) {
		Cliente nuevoCliente = new Cliente(CUIT,nombre,domicilio,correoElectronico);
		Empresa.getInstancia().getClientes().add(nuevoCliente);
	}
	public void registrarInstalacion(int CUIT, Fecha fecha, Turno turno,TipoFactura tipoFactura, String nombreCliente, String domicilioCliente) {
//		if (!Empresa.getInstancia().buscarCliente(CUIT)) {
//			crearCliente(CUIT, nombreCliente, domicilioCliente);
//		}
		if (Empresa.getInstancia().devolverTecnicoDisponible(fecha,turno) != null) {
			Cliente cliente = Empresa.getInstancia().devolverCliente(CUIT);
				if(Empresa.getInstancia().hayCondensadora() && Empresa.getInstancia().hayEvaporadora() && Empresa.getInstancia().hayKitInstalacion()) {
					Tecnico tecnico = Empresa.getInstancia().devolverTecnicoDisponible(fecha,turno);
					Instalacion nuevaInstalacion = Empresa.getInstancia().crearInstalacion(fecha, cliente, tecnico, tipoFactura);
					Empresa.getInstancia().agregarStockInstalacion(nuevaInstalacion);
					Empresa.getInstancia().setInstalacionCliente(nuevaInstalacion, cliente);
					Empresa.getInstancia().setInstalacionTecnico(nuevaInstalacion, tecnico);
					Empresa.getInstancia().ocuparTurnoTecnico(fecha, turno, tecnico);
					Empresa.getInstancia().restarStock();
				}
			}
	}
	
	public void cancelarInstalacion(int idInstalacion) {
		for(Instalacion i:Empresa.getInstancia().listarInstalacion()) {
			if(i.getIdInstalacion() == idInstalacion) {
				i.getTecnico().liberarTurno(i.getFecha(), i.getTurno());
				i.setEstado(EstadoInstalacion.cancelada);
				Empresa.getInstancia().restaurarStock();
				i.getCliente().setInstalacion(null);
			}
		}
	}
	
}
