package models;
import java.util.ArrayList;
public class Empresa {
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	private ArrayList<Articulo> articulos = new ArrayList<Articulo>();
	private ArrayList<Factura> facturas = new ArrayList<Factura>();
	private static Empresa empresa;

	public static Empresa getInstancia() {
		if (empresa == null) {
			empresa = new Empresa();
		}
		return empresa;
	}

	private Empresa() {
		super();
		articulos.add(new Condensadora());
		articulos.add(new KitInstalacion());
		articulos.add(new Evaporadora());
	}

//----------------------ADMINISTRADOR DE SISTEMA---------------------------------
	public void agregarCondensadora(int cantAAgregar,int idEmpleado) {
		Condensadora condensadora = new Condensadora();
		altaArticulo((Articulo)condensadora,cantAAgregar,idEmpleado);
	}
	
	public void agregarEvaporadora(int cantAAgregar,int idEmpleado) {
		Evaporadora evaporadora = new Evaporadora();
		altaArticulo((Articulo)evaporadora,cantAAgregar,idEmpleado);
	}
	
	public void agregarKitInstalacion(int cantAAgregar,int idEmpleado) {
		KitInstalacion kitInstalacion = new KitInstalacion();
		altaArticulo((Articulo)kitInstalacion,cantAAgregar,idEmpleado);
	}
	
	public void quitarCondensadora(int cantAAgregar,int idEmpleado) {
		Condensadora condensadora = new Condensadora();
		bajaArticulo((Articulo)condensadora,cantAAgregar,idEmpleado);
	}
	
	public void quitarEvaporadora(int cantAAgregar,int idEmpleado) {
		Evaporadora evaporadora = new Evaporadora();
		bajaArticulo((Articulo)evaporadora,cantAAgregar,idEmpleado);
	}
	
	public void quitarKitInstalacion(int cantAAgregar,int idEmpleado) {
		KitInstalacion kitInstalacion = new KitInstalacion();
		bajaArticulo((Articulo)kitInstalacion,cantAAgregar,idEmpleado);
	}
	
	public void modificarPrecioCondensadora(double nuevoPrecio,int idEmpleado) {
		Condensadora condensadora = new Condensadora();
		modificarArticulo((Articulo)condensadora,nuevoPrecio,idEmpleado);
	}
	
	public void modificarPrecioEvaporadora(double nuevoPrecio,int idEmpleado) {
		Evaporadora evaporadora = new Evaporadora();
		modificarArticulo((Articulo)evaporadora,nuevoPrecio,idEmpleado);
	}
	
	public void modificarPrecioKitInstalacion(double nuevoPrecio,int idEmpleado) {
		KitInstalacion kitInstalacion = new KitInstalacion();
		modificarArticulo((Articulo)kitInstalacion,nuevoPrecio,idEmpleado);
	}
	public String getStockCondensadora() {
		for(Articulo a:articulos) {
			if(a.getClass().equals(Condensadora.class)) {
				return String.valueOf(a.getCantidad());
			}
		}
		return null;
	}
	
	public String getPrecioCondensadora() {
		for(Articulo a:articulos) {
			if(a.getClass().equals(Condensadora.class)) {
				return String.valueOf(a.getPrecio());
			}
		}
		return null;
	}
	
	public String getStockEvaporadora() {
		for(Articulo a:articulos) {
			if(a.getClass().equals(Evaporadora.class)) {
				return String.valueOf(a.getCantidad());
			}
		}
		return null;
	}
	
	public String getPrecioEvaporadora() {
		for(Articulo a:articulos) {
			if(a.getClass().equals(Evaporadora.class)) {
				return String.valueOf(a.getPrecio());
			}
		}
		return null;
	}
	
	public String getStockKitInstalacion() {
		for(Articulo a:articulos) {
			if(a.getClass().equals(KitInstalacion.class)) {
				return String.valueOf(a.getCantidad());
			}
		}
		return null;
	}
	
	public String getPrecioKitInstalacion() {
		for(Articulo a:articulos) {
			if(a.getClass().equals(KitInstalacion.class)) {
				return String.valueOf(a.getPrecio());
			}
		}
		return null;
	}
	
	public void altaArticulo(Articulo articuloBusqueda,int cantidad, int idEmpleado) {
		AdministradorSistema admin = buscarAdministradorSistema(idEmpleado);
		admin.altaArticulo(articuloBusqueda, cantidad);
	}
	
	public void bajaArticulo(Articulo articuloBusqueda,int cantidad, int idEmpleado) {
		AdministradorSistema admin = buscarAdministradorSistema(idEmpleado);
		admin.bajaArticulo(articuloBusqueda, cantidad);
	}
	
	public void modificarArticulo(Articulo articuloBusqueda,double precio, int idEmpleado) {
		AdministradorSistema admin = buscarAdministradorSistema(idEmpleado);
		admin.modificarArticulo(articuloBusqueda, precio);
	}
	
	public void altaTecnico(String nombre,int idEmpleadoAdmin, Seniority seniority,Turno turnoLaboral) {
		AdministradorSistema admin = buscarAdministradorSistema(idEmpleadoAdmin);
		admin.altaTecnico(nombre, seniority,turnoLaboral);
	}
	
	public void bajaTecnico(int idEmpleadoTecnico,int idEmpleadoAdmin) {
		AdministradorSistema admin = buscarAdministradorSistema(idEmpleadoAdmin);
		admin.bajaTecnico(idEmpleadoTecnico);
	}
	
	public void modificareniorityTecnico(int idEmpleadoTecnico,int idEmpleadoAdmin,Seniority seniority) {
		AdministradorSistema admin = buscarAdministradorSistema(idEmpleadoAdmin);
		admin.modificareniorityTecnico(idEmpleadoTecnico, seniority);
	}
	public void modificarSalario(int idEmpleadoAdmin,Seniority seniority,double nuevoSalario) {
		AdministradorSistema admin = buscarAdministradorSistema(idEmpleadoAdmin);
		admin.modificarSalario(seniority, nuevoSalario);
	}
	
	public void modificarCostoViaje(double nuevoCostoViaje, int idEmpleadoAdmin) {
		AdministradorSistema admin = buscarAdministradorSistema(idEmpleadoAdmin);
		admin.modificarCostoViaje(nuevoCostoViaje);
	}

//-----------------------------OPERADOR DE CALL CENTER-----------------------------------
	public void restarStock() {
		for (Articulo a : articulos) {
			a.setCantidad(a.getCantidad() - 1);
		}
	}

	public void restaurarStock() {
		for (Articulo a : articulos) {
			a.setCantidad(a.getCantidad() + 1);
		}
	}

	public String devolverNombreCliente(int CUIT) {
		Cliente cliente = devolverCliente(CUIT);
		return cliente.getNombre();
	}

	public boolean existeInstalacionProgramada(int CUIT) {
		Cliente cliente = devolverCliente(CUIT);
		if (cliente.getInstalacion() != null && cliente.getInstalacion().getEstado() == EstadoInstalacion.programada) {
			return true;
		}
		return false;
	}

	public String devolverFechaInstalacion(int CUIT) {
		Cliente cliente = devolverCliente(CUIT);
		return cliente.getInstalacion().getFecha().toString();
	}

	public String devolverEstadoInstalacion(int CUIT) {
		Cliente cliente = devolverCliente(CUIT);
		return cliente.getInstalacion().getEstado().toString();
	}

	public boolean validarFecha(String fechaString) {
		Fecha fecha = new Fecha();
		return fecha.validarFecha(fechaString);
	}

	public Fecha pasarStringAFecha(String fechaString) {
		Fecha fecha = new Fecha();
		fecha.setearFechaCalendar(fechaString);
		return fecha;
	}

	public int devolverIdInstalacion(int CUIT) {
		Cliente cliente = devolverCliente(CUIT);
		return cliente.getInstalacion().getIdInstalacion();
	}

	public void registrarCliente(int CUIT, String nombre, String domicilio, String correoElectronico,
			int idEmpleadoOperador) {
		OperadorCallCenter operador = buscarOperador(idEmpleadoOperador);
		operador.crearCliente(CUIT, nombre, domicilio, correoElectronico);
	}

	public void registrarInstalacion(int CUIT, Fecha fecha, Turno turno, TipoFactura tipoFactura, String nombreCliente,
			String domicilioCliente, int idEmpleadoOperador) {
		OperadorCallCenter operador = buscarOperador(idEmpleadoOperador);
		operador.registrarInstalacion(CUIT, fecha, turno, tipoFactura, nombreCliente, domicilioCliente);
	}

	public void cancelarInstalacion(int idInstalacion, int idEmpleado) {
		OperadorCallCenter opCallCenter = buscarOperador(idEmpleado);
		opCallCenter.cancelarInstalacion(idInstalacion);
	}
	public boolean existeInstalacion(int CUIT) {
		Cliente cliente = devolverCliente(CUIT);
		if (cliente.getInstalacion() == null) {
			return false;
		}
		return true;
	}

	public void agregarStockInstalacion(Instalacion instalacion) {
		for (Articulo a : instalacion.getArticulos()) {
			a.setCantidad(a.getCantidad() + 1);
		}
	}

	//
//-------------------------------------ADMINISTRATIVO-------------------------------------
	public boolean informarFaltanteStock() {
		if (!articulos.isEmpty()) {
			if (!hayEvaporadora()) {
				return true;
			}
			if (!hayCondensadora()) {
				return true;
			}
			if (!hayKitInstalacion()) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Instalacion> listarInstalacionesEstado(EstadoInstalacion estado, int idEmpleado) {
		ArrayList<Instalacion> instalaciones = new ArrayList<Instalacion>();
		for (Tecnico t : listarTecnicos()) {
			if (t.getIdEmpleado() == idEmpleado) {
				for (Instalacion i : t.getInstalacionesProgramadas()) {
					if (i.getEstado().equals(estado)) {
						instalaciones.add(i);
					}
				}
			}
		}
		return instalaciones;
	}

	public ArrayList<Instalacion> listarInstalacionesEstadoSinEmpleado(EstadoInstalacion estado) {
		ArrayList<Instalacion> instalaciones = new ArrayList<Instalacion>();
		for (Instalacion i : listarInstalacion()) {
			if (i.getEstado().equals(estado)) {
				instalaciones.add(i);
			}
		}
		return instalaciones;
	}

	public ArrayList<Instalacion> listarInstalacionesSinEstado(int idEmpleado) {
		ArrayList<Instalacion> instalaciones = new ArrayList<Instalacion>();
		for (Tecnico t : listarTecnicos()) {
			if (t.getIdEmpleado() == idEmpleado) {
				for (Instalacion i : t.listarInstalaciones()) {
					instalaciones.add(i);
				}
			}
		}
		return instalaciones;
	}

	public ArrayList<Instalacion> listarInstalacion() {
		ArrayList<Instalacion> instalaciones = new ArrayList<Instalacion>();
		for (Tecnico t : listarTecnicos()) {
			for (Instalacion i : t.listarInstalaciones()) {
				instalaciones.add(i);
			}
		}
		return instalaciones;
	}

	public ArrayList<Tecnico> listarTecnicos() {
		ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();
		for (Empleado e : empleados) {
			if (e.getClass().equals(Tecnico.class)) {
				tecnicos.add((Tecnico) e);
			}
		}
		return tecnicos;
	}

	public boolean hayEvaporadora() {
		for (Articulo a : articulos) {
			if (a.getClass().equals(Evaporadora.class)) {
				if (a.getCantidad() > 0) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean hayCondensadora() {
		for (Articulo a : articulos) {
			if (a.getClass().equals(Condensadora.class)) {
				if (a.getCantidad() > 0) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean hayKitInstalacion() {
		for (Articulo a : articulos) {
			if (a.getClass().equals(KitInstalacion.class)) {
				if (a.getCantidad() > 0) {
					return true;
				}
			}
		}
		return false;
	}

	public Cliente devolverCliente(int CUIT) {
		for (Cliente c : clientes) {
			if (c.getCUIT() == CUIT) {
				return c;
			}
		}
		return null;
	}

	public boolean buscarCliente(int CUIT) {
		for (Cliente c : clientes) {
			if (c.getCUIT() == CUIT) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Factura> listarFacturasEmitidas() {
		return facturas;
	}

	public OperadorCallCenter buscarOperador(int idEmpleado) {
		for (Empleado e : empleados) {
			if (e.getIdEmpleado() == idEmpleado) {
				return (OperadorCallCenter) e;
			}
		}
		return null;
	}

	public AdministradorSistema buscarAdministradorSistema(int idEmpleado) {
		for (Empleado e : empleados) {
			if (e.getIdEmpleado() == idEmpleado) {
				return (AdministradorSistema) e;
			}
		}
		return null;
	}

	public Tecnico devolverTecnicoDisponible(Fecha fecha, Turno turno) {
		System.out.println(turno);
		ArrayList<Tecnico> tecnicos = listarTecnicos();
		for (Tecnico t : tecnicos) {
			if (t.estaLibre(fecha, turno)) {
				return t;
			}
		}
		return null;
	}

	public boolean hayFechaDisponible(Fecha fecha, Turno turno) {
		Tecnico tecnico = devolverTecnicoDisponible(fecha, turno);
		if (tecnico != null) {
			return true;
		}
		return false;
	}

	public Factura devolverFactura(int idFactura) {
		for (Factura f : facturas) {
			if (f.getIdFactura() == idFactura) {
				return f;
			}
		}
		return null;
	}

	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public String getNombreEmpleado(int idEmpleado) {
		for (Empleado e : empleados) {
			if (e.getIdEmpleado() == idEmpleado) {
				return e.getNombre();
			}
		}
		return null;
	}

	public String toStringEmpleado(int idEmpleado) {
		if (buscarTecnico(idEmpleado) != null) {
			return buscarTecnico(idEmpleado).toString();
		}
		return null;
	}

	public String toStringInstalacion(int idEmpleado) {
		for (Instalacion i : buscarTecnico(idEmpleado).listarInstalaciones()) {
			i.toString();
		}
		return null;
	}

	public String StringInstalacion(Instalacion instalacion) {
		return "Instalacion n°" + instalacion.getIdInstalacion() + " Estado: " + instalacion.getEstado().toString()
				+ " Fecha: " + instalacion.getFecha().toString();
	}

	public String toStringEmisionFactura(Factura factura) {
		return "Id Factura: "+factura.getIdFactura()+"\nTotal: "+factura.getTotal()+"\nItems: "+factura.getItems()+"\nOtros costos: "+factura.getInstalacion().getTecnico().calcularOtrosCostos(factura.getInstalacion())+"\nInstalacion n�" + factura.getInstalacion().getIdInstalacion() + " \nEstado: " + factura.getInstalacion().getEstado().toString()
				+ " \nFecha: " + factura.getInstalacion().getFecha().toString()+" \nCliente: "+factura.getInstalacion().getCliente();

	}

	public String StringInstalacionDetalle(Instalacion instalacion) {
		return instalacion.toString();
	}

	public void setInstalacionTecnico(Instalacion instalacion, Tecnico tecnico) {
		tecnico.agregarInstalacion(instalacion);
	}

	public void setInstalacionCliente(Instalacion instalacion, Cliente cliente) {
		cliente.setInstalacion(instalacion);
	}

	// ---------Setear estado de instalacion-----------
	public void setEstadoInstalacion(int idEmpleado, Instalacion instalacion, EstadoInstalacion estado) {
		if (estado == EstadoInstalacion.cancelada) {
			restaurarStock();
		}
		if (estado == EstadoInstalacion.programada) {
			restarStock();
		}
		buscarTecnico(idEmpleado).modificarEstadoInstalacion(instalacion, estado);
	}

	// -----------GET HORA INICIO Y FIN DE LA INSTALACION*---------------
	public boolean tieneHoraInicioYFin(Instalacion instalacion) {
		if (instalacion.getHoraInicio() != null && instalacion.getHoraFin() != null)
			return true;
		else
			return false;

	}

	// ---------Setear hora de instalacion inicio-----------
	public void setHoraInicioInstalacion(int idEmpleado, Instalacion instalacion, String hora) {
		Hora horaDate = new Hora();
		horaDate.setearHoraCalendar(hora);
		for (Instalacion i : buscarTecnico(idEmpleado).listarInstalaciones()) {
			if (i == instalacion) {
				buscarTecnico(idEmpleado).setHoraInicioInstalacion(i, horaDate);
			}
		}
	}

	public void setHoraFinInstalacion(int idEmpleado, Instalacion instalacion, String hora) {
		Hora horaDate = new Hora();
		horaDate.setearHoraCalendar(hora);
		for (Instalacion i : buscarTecnico(idEmpleado).listarInstalaciones()) {
			if (i == instalacion) {
				buscarTecnico(idEmpleado).setHoraFinalizacionInstalacion(i, horaDate);
			}
		}
	}

	public boolean validarHora(int idEmpleado, String hora) {
		Hora horaDate = new Hora();
		if (buscarTecnico(idEmpleado).getTurnoLaboral() == Turno.tarde) {
			if (horaDate.validarHoraTarde(hora)) {
				return true;
			}
		} else if (buscarTecnico(idEmpleado).getTurnoLaboral() == Turno.mañana) {
			if (horaDate.validarHoraMañana(hora)) {
				return true;
			}
		}
		return false;
	}

	// -------Tecnico agrega opcionales-------
	public void agregarOpcionales(int idEmpleado, Instalacion instalacion, Opcional opcional) {
		buscarTecnico(idEmpleado).agregarOpcional(instalacion, opcional);
	}

	// -----------Tecnico modifica el almuerzo-------------
	public void modificarAlmuerzo(int idEmpleado, Instalacion instalacion, boolean hayAlmuerzo) {
		buscarTecnico(idEmpleado).setAlmuerzoInstalacion(instalacion, hayAlmuerzo);
	}

	public Tecnico buscarTecnico(int idEmpleado) {
		for (Tecnico t : listarTecnicos()) {
			if (t.getIdEmpleado() == idEmpleado) {
				return t;
			}
		}
		return null;
	}

	public Instalacion crearInstalacion(Fecha fecha, Cliente cliente, Tecnico tecnico, TipoFactura tipoFactura) {
		Instalacion nuevaInstalacion = new Instalacion(fecha, cliente, tecnico, tipoFactura);
		return nuevaInstalacion;
	}
	public void ocuparTurnoTecnico(Fecha fecha, Turno turno, Tecnico tecnico) {
		tecnico.ocuparTurno(fecha, turno);
	}
	public TipoFactura getTipoFacturaInstalacion(Instalacion instalacion) {
		return instalacion.getTipoFactura();
	}
	public Cliente getClienteInstalacion(Instalacion instalacion) {
		return instalacion.getCliente();
	}
	public double getGastosInstalacion(Instalacion instalacion) {
		return instalacion.getTecnico().calcularGastos(instalacion);	
	}
	public double getOtrosCostosInstalacion(Instalacion instalacion) {
		return instalacion.getTecnico().calcularGastos(instalacion);	
	}
	public double getTotalMaterialesOpcionales(Instalacion instalacion) {
		return instalacion.getTecnico().calcularOtrosCostos(instalacion);
	}
	public double getTotalHorasTrabajadas(Instalacion instalacion) {
		return instalacion.getTecnico().calcularHorasTrabajadas(instalacion);
	}
	public Factura emitirFacturaAdministrativo(int idEmpleado, Instalacion instalacion) {
		Factura auxiliarFactura = buscarAdministrativo(idEmpleado).emitirFactura(instalacion);
		facturas.add(auxiliarFactura);
		return auxiliarFactura;
	}
	public Factura emitirFacturaAdministrativoModificacion(int idEmpleado, Instalacion instalacion,double otrosCostos) {
		Factura auxiliarFactura = buscarAdministrativo(idEmpleado).emitirFactura(instalacion);
		auxiliarFactura.setTotal(auxiliarFactura.getTotal()-instalacion.getTecnico().calcularOtrosCostos(instalacion)+otrosCostos);
		facturas.add(auxiliarFactura);
		return auxiliarFactura;
		}
	
	public Administrativo buscarAdministrativo(int idEmpleado) {
		for (Empleado e : empleados) {
			if (e.getIdEmpleado() == idEmpleado) {
				return (Administrativo) e;
			}
		}
		return null;
	}
	public boolean validarFactura(Instalacion instalacion) {
		for(Factura f: facturas) {		
				if(f.getInstalacion() == instalacion) {
					return false;
				}
		}
		return true;
	}
	public String StringTecnico(Tecnico tecnico) {	
		return "Tecnico id:"+tecnico.getIdEmpleado()+" Nombre: "+tecnico.getNombre()+" Seniority: "+tecnico.getSeniority().getNombreSeniority();
	}
}
