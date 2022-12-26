package models;

import java.util.ArrayList;
import java.util.Calendar;

public class Instalacion {
	private EstadoInstalacion estado;
	private Fecha fecha;
	private Turno turno;
	private static double costoViaje = 20;
	private int idInstalacion;
	private Hora horaInicio;
	private Hora horaFin;
	private Cliente cliente;
	private Tecnico tecnico;
	private TipoFactura tipoFactura;
	private ArrayList<Articulo> articulos = new ArrayList<Articulo>();
	private ArrayList<Opcional> opcionales = new ArrayList<Opcional>(); 
	private boolean almuerzo;
	
	public Instalacion(Fecha fecha, Cliente cliente, Tecnico tecnico, TipoFactura tipoFactura) {
		super();
		this.idInstalacion = Herramientas.contadorIdInstalacion();
		this.estado = EstadoInstalacion.programada;
		this.fecha = fecha;
		this.cliente = cliente;
		this.tecnico = tecnico;
		this.tipoFactura = tipoFactura;
		this.turno = tecnico.getTurnoLaboral();
		this.articulos.add(new Evaporadora());
		this.articulos.add(new KitInstalacion());
		this.articulos.add(new Condensadora());
	}

	public EstadoInstalacion getEstado() {
		return estado;
	}
	public int getIdInstalacion() {
		return idInstalacion;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Tecnico getTecnico() {
		return tecnico;
	}
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	public void setEstado(EstadoInstalacion estado) {
		this.estado = estado;
	}
	public Fecha getFecha() {
		return fecha;
	}
	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}
	public Turno getTurno() {
		return turno;
	}
	public Hora getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Hora horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Hora getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(Hora horaFin) {
		this.horaFin = horaFin;
	}

	public static double getCostoViaje() {
		return costoViaje;
	}

	public static void setCostoViaje(double costoViaje) {
		Instalacion.costoViaje = costoViaje;
	}

	public ArrayList<Articulo> getArticulos() {
		return articulos;
	}

	public TipoFactura getTipoFactura() {
		return tipoFactura;
	}

	public void setTipoFactura(TipoFactura tipoFactura) {
		this.tipoFactura = tipoFactura;
	}
	public double calcularTotalMateriales() {
		double totalMateriales = 0;
		for(Articulo a:this.articulos) {
			totalMateriales = totalMateriales + a.getPrecio();
		}
		return totalMateriales;
	}
	public double calcularTotalOpcionales() {
		double totalMaterialesOpcionales = 0;
		for(Opcional o:this.opcionales) {
			totalMaterialesOpcionales = totalMaterialesOpcionales + o.getCosto();
		}
		return totalMaterialesOpcionales;
	}
	
	public double calcularTotalTiempo() {
		int horaInicio = this.getHoraInicio().getCalendario().get(Calendar.HOUR_OF_DAY);
		int minutoInicio = this.getHoraInicio().getCalendario().get(Calendar.MINUTE);
		int horaFin = this.getHoraFin().getCalendario().get(Calendar.HOUR_OF_DAY);
		int minutoFin = this.getHoraFin().getCalendario().get(Calendar.MINUTE);
		
		double restaTiempo = (horaFin + (minutoFin/60)) - (horaInicio + (minutoInicio/60));
		double totalTiempo;
		if (restaTiempo < 1) {
			totalTiempo = 1 * this.getTecnico().getSeniority().getSalarioHora();
		}else {
			totalTiempo = restaTiempo * this.getTecnico().getSeniority().getSalarioHora();
			}
		if(isAlmuerzo()) {
			totalTiempo = totalTiempo - calcularGastos();
		}
		
		return totalTiempo;
	}
	public double calcularHorasTrabajadas() {
		double horaInicio = this.getHoraInicio().getCalendario().get(Calendar.HOUR_OF_DAY);
		double minutoInicio = this.getHoraInicio().getCalendario().get(Calendar.MINUTE);
		double horaFin = this.getHoraFin().getCalendario().get(Calendar.HOUR_OF_DAY);
		double minutoFin = this.getHoraFin().getCalendario().get(Calendar.MINUTE);
		double horasTrabajadas = (horaFin + (minutoFin/60)) - (horaInicio + (minutoInicio/60));
		horasTrabajadas = Math.round(horasTrabajadas*100.0)/100.0;
		return horasTrabajadas;
		
	}
	
	public double calcularGastos() {
		double aux = 0;
		if(isAlmuerzo()) {
			aux = 0.5 * this.getTecnico().getSeniority().getSalarioHora();
		}
		return aux;
	}

	public boolean isAlmuerzo() {
		return almuerzo;
	}

	public void setAlmuerzo(boolean almuerzo) {
		this.almuerzo = almuerzo;
	}

	public ArrayList<Opcional> getOpcionales() {
		return opcionales;
	}

	public void setOpcionales(ArrayList<Opcional> opcionales) {
		this.opcionales = opcionales;
	}
	
	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public void setIdInstalacion(int idInstalacion) {
		this.idInstalacion = idInstalacion;
	}

	public void setArticulos(ArrayList<Articulo> articulos) {
		this.articulos = articulos;
	}

	@Override
	public String toString() {
		return "Detalle de instalacion:\n ID: "+ idInstalacion +"\n Estado: " +estado+ "\n Fecha: " + fecha + "\n Turno: " + turno + 
			  "\n Hora de inicio: " + horaInicio + "\n Hora de fin: " + horaFin + "\n Cliente:" + cliente
				+ "\n Tecnico" + tecnico + "\n Tipo de factura " + tipoFactura + "\n Cantidad de articulos: \n" + articulos + "\n Opcionales: "
				+ opcionales + "\n Almuerzo: " + almuerzo;
	}
	
}
