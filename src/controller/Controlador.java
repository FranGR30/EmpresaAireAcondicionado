package controller;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import gui.AdministradorSistemaGUI;
import gui.CancelarInstalacionGUI;
import gui.MenuArticulosGUI;
import gui.MenuTecnicosGUI;
import gui.ModificarCostoViaje;
import gui.ModificarPrecioArticulos;
import gui.ModificarSalarioTecnico;
import gui.ModificarSeniority;
import gui.ModificarStockArticulos;
import gui.OperadorCallCenterGUI;
import gui.RegistrarClienteGUI;
import gui.RegistrarInstalacionGUI;
import gui.RegistrarTecnico;
import models.Acceso;
import models.AdministradorSistema;
import models.Administrativo;
import models.Articulo;
import models.Cliente;
import models.Empleado;
import models.Empresa;
import models.EstadoInstalacion;
import models.Factura;
import models.Fecha;
import models.Hora;
import models.Instalacion;
import models.Opcional;
import models.OperadorCallCenter;
import models.Seniority;
import models.Tecnico;
import models.TipoFactura;
import models.Turno;

public class Controlador {
	private static Controlador instancia;
	private Controlador(){
	}
	 public static Controlador getInstancia() {
	    	if (instancia==null)
	    		instancia = new Controlador();
	    	return instancia;
	    }
	 public void registrarInstalacion(int CUIT, Fecha fecha, Turno turno,TipoFactura tipoFactura,String nombreCliente, String domicilioCliente,int idEmpleado) {
		 Empresa.getInstancia().registrarInstalacion(CUIT, fecha, turno, tipoFactura,nombreCliente, domicilioCliente,idEmpleado);
	 }
	 public boolean informarFaltanteStock() {
		 return Empresa.getInstancia().informarFaltanteStock();
	 }
	 public void listarFacturasEmitidas() {
		 Empresa.getInstancia().listarFacturasEmitidas();
	 }
	 public ArrayList<Instalacion> listarInstalaciones(EstadoInstalacion estado, int idEmpleado) {
		 return Empresa.getInstancia().listarInstalacionesEstado(estado, idEmpleado);
	 }
	 public void altaArticulo(Articulo articuloBusqueda,int cantidad, int idEmpleado) {
		 Empresa.getInstancia().altaArticulo(articuloBusqueda, cantidad,idEmpleado);
	 }
	 public void bajaArticulo(Articulo articuloBusqueda,int cantidad, int idEmpleado) {
		 Empresa.getInstancia().bajaArticulo(articuloBusqueda, cantidad, idEmpleado);
	 }
	 public void modificarArticulo(Articulo articuloBusqueda,double precio, int idEmpleado) {
		 Empresa.getInstancia().modificarArticulo(articuloBusqueda, precio, idEmpleado);
	 }
	 public void altaTecnico(String nombre,int idEmpleadoAdmin, Seniority seniority,Turno turnoLaboral) {
		 Empresa.getInstancia().altaTecnico(nombre,idEmpleadoAdmin,seniority,turnoLaboral);	 
	}
	 public void bajaTecnico(int idEmpleadoTecnico,int idEmpleadoAdmin) {
		 Empresa.getInstancia().bajaTecnico(idEmpleadoTecnico, idEmpleadoAdmin);
	 }
	 public void cancelarInstalacion(int idInstalacion, int idEmpleado) {
		 Empresa.getInstancia().cancelarInstalacion(idInstalacion, idEmpleado);
	 }
	 public void modificareniorityTecnico(int idEmpleadoTecnico,int idEmpleadoAdmin,Seniority seniority) {
		 Empresa.getInstancia().modificareniorityTecnico(idEmpleadoTecnico,idEmpleadoAdmin, seniority);
	 }
	 
	 public Acceso chequearAcceso(int idEmpleado) {
			for(Empleado e: Empresa.getInstancia().getEmpleados()) {
				if(e.getIdEmpleado() == idEmpleado) {
					if(e.getClass().equals(Tecnico.class)) {
						return e.getPerfilAcceso();
					}
					else if(e.getClass().equals(OperadorCallCenter.class)) {
						return e.getPerfilAcceso(); 
					}
					else if(e.getClass().equals(Administrativo.class)) {
						return e.getPerfilAcceso(); 
					}
					else if(e.getClass().equals(AdministradorSistema.class)) {
						return e.getPerfilAcceso(); 
					}
				}
			}
		 return null;
	 }
	 public String getNombreEmpleado(int idEmpleado) {
		 return Empresa.getInstancia().getNombreEmpleado(idEmpleado);
	 }
	public ArrayList<Empleado> getEmpleados() {
			return Empresa.getInstancia().getEmpleados();
	} 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void agregarInstalacionesListado(DefaultListModel modelo, int idEmpleado) {
		for(Instalacion i:Empresa.getInstancia().listarInstalacionesSinEstado(idEmpleado)) {
			modelo.addElement(Empresa.getInstancia().StringInstalacion(i));
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void agregarTecnicosListado(DefaultListModel modelo, int idEmpleado) {
		for(Tecnico t:Empresa.getInstancia().listarTecnicos()) {
			modelo.addElement(Empresa.getInstancia().StringTecnico(t));
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void agregarInstalacionesListadoEstado(DefaultListModel modelo, int idEmpleado,EstadoInstalacion estado) {
		for(Instalacion i:Empresa.getInstancia().listarInstalacionesEstado(estado,idEmpleado)) {
			modelo.addElement(Empresa.getInstancia().StringInstalacion(i));
		}
	}
	public String detalleInstalacion(String instalacion) {
		for(Instalacion i:Empresa.getInstancia().listarInstalacion()) {
			String auxiliar = Empresa.getInstancia().StringInstalacion(i);
			if(auxiliar.equals(instalacion)) {
				String detalle = Empresa.getInstancia().StringInstalacionDetalle(i);
				return detalle;
			}
		}
		return null;
	}
	public boolean buscarCliente(int CUIT) {
		return Empresa.getInstancia().buscarCliente(CUIT);
	}
	public void registrarCliente(int CUIT, String nombre, String domicilio,String correoElectronico, int idEmpleado) {
		Empresa.getInstancia().registrarCliente(CUIT, nombre, domicilio, correoElectronico,idEmpleado);
	}
	public String devolverNombreCliente(int CUIT) {
		return Empresa.getInstancia().devolverNombreCliente(CUIT);
	}
	public void SetearEstadoInstalacion(int idEmpleado, String instalacion,EstadoInstalacion estado) {
		for(Instalacion i:Empresa.getInstancia().listarInstalacion()) {
			String auxiliar = Empresa.getInstancia().StringInstalacion(i);
			if(auxiliar.equals(instalacion)) {
				Empresa.getInstancia().setEstadoInstalacion(idEmpleado,i,estado);
			}
		}
	}
	public void SetearHoraInicioInstalacion(int idEmpleado,String instalacion,String hora) {
		for(Instalacion i:Empresa.getInstancia().listarInstalacion()) {
			String auxiliar = Empresa.getInstancia().StringInstalacion(i);
			if(auxiliar.equals(instalacion)) {
						Empresa.getInstancia().setHoraInicioInstalacion(idEmpleado,i, hora);
					}
				}
	}
	public void SetearHoraFinInstalacion(int idEmpleado,String instalacion,String hora) {
		for(Instalacion i:Empresa.getInstancia().listarInstalacion()) {
			String auxiliar = Empresa.getInstancia().StringInstalacion(i);
				if(auxiliar.equals(instalacion)) {
							Empresa.getInstancia().setHoraFinInstalacion(idEmpleado,i, hora);
					}
			}

	}
	public boolean validarHora(int idEmpleado, String hora) {
			if(Empresa.getInstancia().validarHora(idEmpleado,hora)) {
				return true;
			}
			else{
				return false;
			}
		}
	public boolean tieneHoraInicioYFin(String instalacion) {
		for(Instalacion i:Empresa.getInstancia().listarInstalacion()) {
			String auxiliar = Empresa.getInstancia().StringInstalacion(i);
				if(auxiliar.equals(instalacion)) {
							return Empresa.getInstancia().tieneHoraInicioYFin(i);
					}
			}
		return false;
	}

	public void registrarInstalacionGUI(JLabel idEmpleadoConectado) {
		RegistrarInstalacionGUI registrarInstalacion = new RegistrarInstalacionGUI();
		registrarInstalacion.setVisible(true);
		registrarInstalacion.getIdEmpleadoConectado().setText(idEmpleadoConectado.getText());
		registrarInstalacion.getNombreEmpleado().setText("Nombre: " + Controlador.getInstancia().getNombreEmpleado(Integer.parseInt(idEmpleadoConectado.getText())));
	}
	
	public void registrarClienteGUI(JLabel idEmpleadoConectado,JTextField CUITCliente) {
		RegistrarClienteGUI registrarCliente = new RegistrarClienteGUI();
		registrarCliente.setVisible(true);
		registrarCliente.getIdEmpleadoConectado().setText(idEmpleadoConectado.getText());
		registrarCliente.getNombreEmpleado().setText("Nombre: " + Controlador.getInstancia().getNombreEmpleado(Integer.parseInt(idEmpleadoConectado.getText())));
		registrarCliente.getCUITCliente().setText(CUITCliente.getText());
	}
	
	public void registrarInstalacionGUI(JLabel idEmpleadoConectado,JTextField CUITCliente) {
		RegistrarInstalacionGUI registrarInstalacion = new RegistrarInstalacionGUI();
		registrarInstalacion.setVisible(true);
		registrarInstalacion.getIdEmpleadoConectado().setText(idEmpleadoConectado.getText());
		registrarInstalacion.getNombreEmpleado().setText("Nombre: " + Controlador.getInstancia().getNombreEmpleado(Integer.parseInt(idEmpleadoConectado.getText())));
		registrarInstalacion.getCUITCliente().setText(CUITCliente.getText());
	}
	
	public void volverRegistrarInstalacion(JLabel idEmpleadoConectado) {
		RegistrarInstalacionGUI registrarInstalacion = new RegistrarInstalacionGUI();
		registrarInstalacion.setVisible(true);
		registrarInstalacion.getIdEmpleadoConectado().setText(idEmpleadoConectado.getText());
		registrarInstalacion.getNombreEmpleado().setText("Nombre: " + Controlador.getInstancia().getNombreEmpleado(Integer.parseInt(idEmpleadoConectado.getText())));
	}
	
	public void volverOperadorCallCenterGUI(JLabel idEmpleadoConectado) {
		OperadorCallCenterGUI op = new OperadorCallCenterGUI();
		op.setVisible(true);  
		op.getIdEmpleadoConectado().setText(idEmpleadoConectado.getText());
		op.getNombreEmpleado().setText("Nombre Empleado: " + Controlador.getInstancia().getNombreEmpleado(Integer.parseInt(idEmpleadoConectado.getText())));
	}

	
	public void cancelarInstalacionGUI(JLabel idEmpleadoConectado) {
		CancelarInstalacionGUI cancelarInstalacion = new CancelarInstalacionGUI();
		cancelarInstalacion.setVisible(true);
		cancelarInstalacion.getIdEmpleadoConectado().setText(idEmpleadoConectado.getText());
		cancelarInstalacion.getNombreEmpleado().setText("Nombre: " + Controlador.getInstancia().getNombreEmpleado(Integer.parseInt(idEmpleadoConectado.getText())));
	}
	
	public boolean existeInstalacionProgramada(int CUIT) {
		return Empresa.getInstancia().existeInstalacionProgramada(CUIT);
	}
	
	public String devolverFechaInstalacion(int CUIT) {
		return Empresa.getInstancia().devolverFechaInstalacion(CUIT);
	}
	
	public String devolverEstadoInstalacion(int CUIT) {
		return Empresa.getInstancia().devolverEstadoInstalacion(CUIT);
	}
	
	public int devolverIdInstalacion(int CUIT) {
		return Empresa.getInstancia().devolverIdInstalacion(CUIT);
	}
	
	public boolean validarFecha(String fechaString) {
		return Empresa.getInstancia().validarFecha(fechaString);
	}
	
	public Fecha pasarStringAFecha(String fechaString) {
		return Empresa.getInstancia().pasarStringAFecha(fechaString);
	}
	
	public void registrarInstalacionFromGUI(int CUIT, String date, String turnoString,String tipoFacturaString,int idEmpleado) {
		Fecha fecha = pasarStringAFecha(date);
		Turno turno;
		if(turnoString.equals("Tarde")) {
			turno = Turno.tarde;
		}else {
			turno = Turno.mañana;
		}
		TipoFactura tipoFactura;
		if(tipoFacturaString.equals("A")) {
			tipoFactura = TipoFactura.A;
		}else {
			tipoFactura = TipoFactura.B;
		}
		Cliente cliente = Empresa.getInstancia().devolverCliente(CUIT);
		String domicilioCliente = cliente.getDomicilio();
		String nombreCliente = devolverNombreCliente(CUIT);
		Empresa.getInstancia().registrarInstalacion(CUIT,fecha,turno,tipoFactura,nombreCliente,domicilioCliente,idEmpleado);
	}
	
	public boolean hayFechaDisponible(String dateString, String turnoString) {
		Fecha fecha = pasarStringAFecha(dateString);
		if(turnoString.equals("tarde")) {
			return Empresa.getInstancia().hayFechaDisponible(fecha, Turno.tarde);
		}else if(turnoString.equals("mañana")){;
			return Empresa.getInstancia().hayFechaDisponible(fecha, Turno.mañana);
		}
		return false;
	}
	
	public void agregarOpcionales(int idEmpleado,String instalacion,Opcional opcional) {
		for(Instalacion i:Empresa.getInstancia().listarInstalacion()) {
			String auxiliar = Empresa.getInstancia().StringInstalacion(i);
			if(auxiliar.equals(instalacion)) {
				Empresa.getInstancia().agregarOpcionales(idEmpleado,i, opcional);
			}
		}
	}
	public void modificarAlmuerzo(int idEmpleado,String instalacion,boolean hayAlmuerzo) {
		for(Instalacion i:Empresa.getInstancia().listarInstalacion()) {
			String auxiliar = Empresa.getInstancia().StringInstalacion(i);
			if(auxiliar.equals(instalacion)) {
				Empresa.getInstancia().modificarAlmuerzo(idEmpleado, i, hayAlmuerzo);
			}
		}
	}
	public boolean existeInstalacion(int CUIT) {
		return Empresa.getInstancia().existeInstalacion(CUIT);
	}
	@SuppressWarnings("unchecked")
	public void agregarFacturasModelo(DefaultListModel modelo) {
		for(Factura f:Empresa.getInstancia().getFacturas()) {
			modelo.addElement(f.toString());
		}
	}
	public void agregarInstalacionesFinalizadas(JComboBox<String> combo,EstadoInstalacion estado) {
		for(Instalacion i:Empresa.getInstancia().listarInstalacionesEstadoSinEmpleado(estado)) {
			String detalle = Empresa.getInstancia().StringInstalacion(i);
			combo.addItem(detalle);
		}
	}
	public TipoFactura getTipoFacturaInstalacion(String instalacion) {
		for(Instalacion i:Empresa.getInstancia().listarInstalacion()) {
			String auxiliar = Empresa.getInstancia().StringInstalacion(i);
			if(auxiliar.equals(instalacion)) {
				return Empresa.getInstancia().getTipoFacturaInstalacion(i);
			}
		}
		return null;
	}
	public Cliente getClienteInstalacion(String instalacion) {
		for(Instalacion i:Empresa.getInstancia().listarInstalacion()) {
			String auxiliar = Empresa.getInstancia().StringInstalacion(i);
			if(auxiliar.equals(instalacion)) {
				return Empresa.getInstancia().getClienteInstalacion(i);
			}
		}
		return null;
	}
	public String getClienteCorreoInstalacion(String instalacion) {
		for(Instalacion i:Empresa.getInstancia().listarInstalacion()) {
			String auxiliar = Empresa.getInstancia().StringInstalacion(i);
			if(auxiliar.equals(instalacion)) {
				return Empresa.getInstancia().getClienteInstalacion(i).getCorreoElectronico();
			}
		}
		return null;
	}
	
	public double getGastosInstalacion(String instalacion) {
		for(Instalacion i:Empresa.getInstancia().listarInstalacion()) {
			String auxiliar = Empresa.getInstancia().StringInstalacion(i);
			if(auxiliar.equals(instalacion)) {
				return Empresa.getInstancia().getGastosInstalacion(i);
			}
		}
		return 0;
	}
	
	public double getTotalMaterialesOpcionales(String instalacion) {
		for(Instalacion i:Empresa.getInstancia().listarInstalacion()) {
			String auxiliar = Empresa.getInstancia().StringInstalacion(i);
			if(auxiliar.equals(instalacion)) {
				return Empresa.getInstancia().getTotalMaterialesOpcionales(i);
			}
		}
		return 0;
	}
	public double getTotalHorasTrabajadas(String instalacion){
		for(Instalacion i:Empresa.getInstancia().listarInstalacion()) {
			String auxiliar = Empresa.getInstancia().StringInstalacion(i);
			if(auxiliar.equals(instalacion)) {
				return Empresa.getInstancia().getTotalHorasTrabajadas(i);
			}
		}
		return 0;
	}
	public void llenarComboEquipoInstalacion(JComboBox<String> combo,String instalacion){
		for(Instalacion i:Empresa.getInstancia().listarInstalacion()) {
			String auxiliar = Empresa.getInstancia().StringInstalacion(i);
			if(auxiliar.equals(instalacion)) {
				for(Articulo a:i.getArticulos()) {
				combo.addItem(a.toString());			
				}
			}
		}
	}
	public Factura emitirFacturaAdministrativo(int idEmpleado,String instalacion) {
		for(Instalacion i:Empresa.getInstancia().listarInstalacion()) {
			String auxiliar = Empresa.getInstancia().StringInstalacion(i);
			if(auxiliar.equals(instalacion)) {
				return Empresa.getInstancia().emitirFacturaAdministrativo(idEmpleado, i);
			}
		}
		return null;
	}
	public boolean validarFactura(String instalacion) {
		for(Instalacion i:Empresa.getInstancia().listarInstalacion()) {
			String auxiliar = Empresa.getInstancia().StringInstalacion(i);
			if(auxiliar.equals(instalacion)) {
				return Empresa.getInstancia().validarFactura(i);
			}
		}
		return false;
	}
	public Factura emitirFacturaAdministrativoConModificacion(int idEmpleado,String instalacion,double otrosCostos) {
		for(Instalacion i:Empresa.getInstancia().listarInstalacion()) {
			String auxiliar = Empresa.getInstancia().StringInstalacion(i);
			if(auxiliar.equals(instalacion)) {
				Factura auxiliarFactu =  Empresa.getInstancia().emitirFacturaAdministrativoModificacion(idEmpleado, i,otrosCostos);
				return auxiliarFactu;
			}
		}
		return null;
	}
		public String detalleFactura(String factura) {
			for(Factura f:Empresa.getInstancia().getFacturas()) {
				String auxiliar = f.toString();
				if(auxiliar.equals(factura)) {
					String detalle = Empresa.getInstancia().toStringEmisionFactura(f);
					return detalle;
				}
			}
			return null;
		}
		public void administradorSistemaGUI(JLabel idEmpleadoConectado) {
			AdministradorSistemaGUI administradorSistemaGUI = new AdministradorSistemaGUI();
			administradorSistemaGUI.setVisible(true);
			administradorSistemaGUI.getIdEmpleadoConectado().setText(idEmpleadoConectado.getText());
			administradorSistemaGUI.getNombreEmpleado().setText("Nombre: " + Controlador.getInstancia().getNombreEmpleado(Integer.parseInt(idEmpleadoConectado.getText())));
		}
		
		public void menuArticuloGUI(JLabel idEmpleadoConectado) {
			MenuArticulosGUI menuArticulosGUI = new MenuArticulosGUI();
			menuArticulosGUI.setVisible(true);
			menuArticulosGUI.getIdEmpleadoConectado().setText(idEmpleadoConectado.getText());
			menuArticulosGUI.getNombreEmpleado().setText("Nombre: " + Controlador.getInstancia().getNombreEmpleado(Integer.parseInt(idEmpleadoConectado.getText())));
		} 
		
		public void menuTecnicosGUI(JLabel idEmpleadoConectado) {
			MenuTecnicosGUI menuTecnicosGUI = new MenuTecnicosGUI();
			menuTecnicosGUI.setVisible(true);
			menuTecnicosGUI.getIdEmpleadoConectado().setText(idEmpleadoConectado.getText());
			menuTecnicosGUI.getNombreEmpleado().setText("Nombre: " + Controlador.getInstancia().getNombreEmpleado(Integer.parseInt(idEmpleadoConectado.getText())));
		} 
		
		public void menuModificarStockArticulos(JLabel idEmpleadoConectado) {
			ModificarStockArticulos modificarArticulosGUI = new ModificarStockArticulos();
			modificarArticulosGUI.setVisible(true);
			modificarArticulosGUI.getIdEmpleadoConectado().setText(idEmpleadoConectado.getText());
			modificarArticulosGUI.getNombreEmpleado().setText("Nombre: " + Controlador.getInstancia().getNombreEmpleado(Integer.parseInt(idEmpleadoConectado.getText())));
			modificarArticulosGUI.getStockCondensadora().setText(getStockCondensadora());
			modificarArticulosGUI.getStockEvaporadora().setText(getStockEvaporadora());
			modificarArticulosGUI.getStockKitInstalacion().setText(getStockKitInstalacion());
		} 
		
		public void modificarPrecioArticulos(JLabel idEmpleadoConectado) {
			ModificarPrecioArticulos modificarPrecioArticulos = new ModificarPrecioArticulos();
			modificarPrecioArticulos.setVisible(true);
			modificarPrecioArticulos.getIdEmpleadoConectado().setText(idEmpleadoConectado.getText());
			modificarPrecioArticulos.getNombreEmpleado().setText("Nombre: " + Controlador.getInstancia().getNombreEmpleado(Integer.parseInt(idEmpleadoConectado.getText())));
			modificarPrecioArticulos.getPrecioCondensadora() .setText(getPrecioCondensadora());
			modificarPrecioArticulos.getPrecioEvaporadora().setText(getPrecioEvaporadora());
			modificarPrecioArticulos.getPrecioKitInstalacion().setText(getPrecioKitInstalacion());
		} 
		
		public String getPrecioCondensadora() {
			return Empresa.getInstancia().getPrecioCondensadora();
		}
		
		public String getPrecioEvaporadora() {
			return Empresa.getInstancia().getPrecioEvaporadora();
		}
		
		public String getPrecioKitInstalacion() {
			return Empresa.getInstancia().getPrecioKitInstalacion();
		}
		
		public String getStockCondensadora() {
			return Empresa.getInstancia().getStockCondensadora();
		}
		
		public String getStockEvaporadora() {
			return Empresa.getInstancia().getStockEvaporadora();
		}
		
		public String getStockKitInstalacion() {
			return Empresa.getInstancia().getStockKitInstalacion();
		}
		
		public void agregarCondensadora(int cantAAgregar,int idEmpleado) {
			Empresa.getInstancia().agregarCondensadora(cantAAgregar,idEmpleado);
		}
		
		public void agregarEvaporadora(int cantAAgregar,int idEmpleado) {
			Empresa.getInstancia().agregarEvaporadora(cantAAgregar,idEmpleado);
		}
		
		public void agregarKitInstalacion(int cantAAgregar,int idEmpleado) {
			Empresa.getInstancia().agregarKitInstalacion(cantAAgregar,idEmpleado);
		}
		
		public void modificarPrecioCondensadora(double nuevoPrecio,int idEmpleado) {
			Empresa.getInstancia().modificarPrecioCondensadora(nuevoPrecio,idEmpleado);
		}
		
		public void modificarPrecioEvaporadora(double nuevoPrecio,int idEmpleado) {
			Empresa.getInstancia().modificarPrecioEvaporadora(nuevoPrecio,idEmpleado);
		}
		
		public void modificarPrecioKitInstalacion(double nuevoPrecio,int idEmpleado) {
			Empresa.getInstancia().modificarPrecioKitInstalacion(nuevoPrecio,idEmpleado);
		}
		
		public void quitarCondensadora(int cantAAgregar,int idEmpleado) {
			Empresa.getInstancia().quitarCondensadora(cantAAgregar,idEmpleado);
		}
		
		public void quitarEvaporadora(int cantAAgregar,int idEmpleado) {
			Empresa.getInstancia().quitarEvaporadora(cantAAgregar,idEmpleado);
		}
		
		public void quitarKitInstalacion(int cantAAgregar,int idEmpleado) {
			Empresa.getInstancia().quitarKitInstalacion(cantAAgregar,idEmpleado);
		}
		
		public void editarTecnico(JLabel idEmpleadoConectado,String tecnicoString) {
			Tecnico tecnico = devolverTecnico(tecnicoString);
			ModificarSeniority registrarTecnicoGUI = new ModificarSeniority();
			registrarTecnicoGUI.setVisible(true);
			registrarTecnicoGUI.getIdEmpleadoConectado().setText(idEmpleadoConectado.getText());
			registrarTecnicoGUI.getNombreEmpleado().setText("Nombre: " + Controlador.getInstancia().getNombreEmpleado(Integer.parseInt(idEmpleadoConectado.getText())));
			registrarTecnicoGUI.getTurnoTecnicoLabel().setText(tecnico.getTurnoLaboral().toString());
			registrarTecnicoGUI.getIdTecnico().setText(Integer.toString(tecnico.getIdEmpleado()));
			registrarTecnicoGUI.getNombreTecnicoLabel().setText(tecnico.getNombre());
		}
		
		public Tecnico devolverTecnico(String tecnico) {
			for(Tecnico t:Empresa.getInstancia().listarTecnicos()) {
				String auxiliar = Empresa.getInstancia().StringTecnico(t);
				if(auxiliar.equals(tecnico)) {
					return t;
				}
			}
			return null;
		}
		
		public void modificarSeniority(int idTecnico,String seniorityTecnicoString,int idEmpleado) {
			if(seniorityTecnicoString.equals(Seniority.Junior.toString())) {
				Empresa.getInstancia().modificareniorityTecnico(idTecnico,idEmpleado,Seniority.Junior);
			}
			if(seniorityTecnicoString.equals(Seniority.SemiSenior.toString())) {
				Empresa.getInstancia().modificareniorityTecnico(idTecnico,idEmpleado,Seniority.SemiSenior);
			}
			if(seniorityTecnicoString.equals(Seniority.Senior.toString())) {
				Empresa.getInstancia().modificareniorityTecnico(idTecnico,idEmpleado,Seniority.Senior);
			}
		}
		
		public void registrarTecnico(JLabel idEmpleadoConectado) {
			RegistrarTecnico registrarTecnico = new RegistrarTecnico();
			registrarTecnico.setVisible(true);
			registrarTecnico.getIdEmpleadoConectado().setText(idEmpleadoConectado.getText());
			registrarTecnico.getNombreEmpleado().setText("Nombre: " + Controlador.getInstancia().getNombreEmpleado(Integer.parseInt(idEmpleadoConectado.getText())));
		}
		
		public void altaTecnico(String nombre, int idAdministrador, String seniorityString, String turnoString) {
			Turno turno;
			if(turnoString.equals("Tarde")) {
				turno = Turno.tarde;
			}else {
				turno = Turno.mañana;
			}
			Seniority seniority;
			if(seniorityString.equals(Seniority.Junior.toString())) {
				seniority = Seniority.Junior;
			}
			if(seniorityString.equals(Seniority.SemiSenior.toString())) {
				seniority = Seniority.SemiSenior;
			} else {
				seniority = Seniority.Senior;
			}
			Empresa.getInstancia().altaTecnico(nombre, idAdministrador, seniority, turno);
		}
		
		public void eliminarTecnico(int idAdministrador,String tecnicoString) {
			Tecnico tecnico = devolverTecnico(tecnicoString);
			Empresa.getInstancia().bajaTecnico(tecnico.getIdEmpleado(),idAdministrador);
		}
		
		public void modificarSalarioTecnico(JLabel idEmpleadoConectado) {
			ModificarSalarioTecnico modificarSalarioTecnico = new ModificarSalarioTecnico();
			modificarSalarioTecnico.setVisible(true);
			modificarSalarioTecnico.getIdEmpleadoConectado().setText(idEmpleadoConectado.getText());
			modificarSalarioTecnico.getNombreEmpleado().setText("Nombre: " + Controlador.getInstancia().getNombreEmpleado(Integer.parseInt(idEmpleadoConectado.getText())));
			modificarSalarioTecnico.getSalarioJunior().setText(String.valueOf(Seniority.Junior.getSalarioHora()));
			modificarSalarioTecnico.getSalarioSemiSenior().setText(String.valueOf(Seniority.SemiSenior.getSalarioHora()));
			modificarSalarioTecnico.getSalarioSenior().setText(String.valueOf(Seniority.Senior.getSalarioHora()));
		}
		
		public void modificarSalarioSenior(double nuevoSalario,int idAdministrativo) {
			Empresa.getInstancia().modificarSalario(idAdministrativo, Seniority.Senior, nuevoSalario);
		}
		
		public void modificarSalarioSemiSenior(double nuevoSalario,int idAdministrativo) {
			Empresa.getInstancia().modificarSalario(idAdministrativo, Seniority.SemiSenior, nuevoSalario);
		}
		
		public void modificarSalarioJunior(double nuevoSalario,int idAdministrativo) {
			Empresa.getInstancia().modificarSalario(idAdministrativo, Seniority.Junior, nuevoSalario);
		}
		
		public void modificarCostoViaje(JLabel idEmpleadoConectado) {
			ModificarCostoViaje modificarCostoViaje = new ModificarCostoViaje();
			modificarCostoViaje.setVisible(true);
			modificarCostoViaje.getIdEmpleadoConectado().setText(idEmpleadoConectado.getText());
			modificarCostoViaje.getNombreEmpleado().setText("Nombre: " + Controlador.getInstancia().getNombreEmpleado(Integer.parseInt(idEmpleadoConectado.getText())));
			double costoViaje = Instalacion.getCostoViaje();
			modificarCostoViaje.getCostoViajeActual().setText(String.valueOf(costoViaje));
		}
		
		public void modificarCostoViaje(double nuevoCostoViaje,int idAdministrativo) {
			Empresa.getInstancia().modificarCostoViaje(nuevoCostoViaje, idAdministrativo);
		}
}
