package models;

import java.util.ArrayList;
import java.util.Calendar;

public class Tecnico extends Empleado {
	private Agenda disponibilidad;
	private ArrayList<Instalacion> instalacionesProgramadas = new ArrayList<Instalacion>();
	private Seniority seniority;
	private Turno turnoLaboral;
	
	public Tecnico(String nombre,Seniority seniority,Turno turnoLaboral) {
		super(nombre);
		this.seniority = seniority;
		this.turnoLaboral = turnoLaboral;	
		this.perfilAcceso = Acceso.TECNICO;
	}
	
	public void modificarEstadoInstalacion(Instalacion instalacion, EstadoInstalacion estado) {
		instalacion.setEstado(estado);
	}
	
	public void setHoraInicioInstalacion(Instalacion instalacion,Hora hora) {
		instalacion.setHoraInicio(hora);
	}
	
	public void setHoraFinalizacionInstalacion(Instalacion instalacion,Hora hora) {
		instalacion.setHoraFin(hora);
	}
	
	public ArrayList<Instalacion> listarInstalaciones() {
		return instalacionesProgramadas;
	}
	
	public void ocuparTurno(Fecha fecha,Turno turno) {
		if(estaLibre(fecha,turno)) {
			this.disponibilidad.ocuparTurno(fecha, turno);
		}
	}
	
	public boolean estaLibre(Fecha fecha, Turno turno) {
		if(this.disponibilidad == null && this.turnoLaboral == turno) {
			Agenda agenda = new Agenda();
			this.disponibilidad = agenda;
			return true;
		}
		if(this.turnoLaboral == turno) {
			if(this.disponibilidad.estaLibre(fecha, turno)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Instalacion> getInstalacionesProgramadas() {
		return instalacionesProgramadas;
	}

	public void setInstalacionesProgramadas(ArrayList<Instalacion> instalacionesProgramadas) {
		this.instalacionesProgramadas = instalacionesProgramadas;
	}
	
	public void agregarInstalacion(Instalacion nuevaInstalacion) {
		this.instalacionesProgramadas.add(nuevaInstalacion);
	}
	
	public void liberarTurno(Fecha fecha, Turno turno) {
		this.disponibilidad.liberarTurno(fecha,turno);
	}

	public Seniority getSeniority() {
		return seniority;
	}

	public void setSeniority(Seniority seniority) {
		this.seniority = seniority;
	}
	public void agregarOpcional(Instalacion instalacion, Opcional opcional) {
		if(!instalacion.getOpcionales().contains(opcional)) {
			instalacion.getOpcionales().add(opcional);
		}
	}

	public Turno getTurnoLaboral() {
		return turnoLaboral;
	}
	public void setAlmuerzoInstalacion(Instalacion instalacion,boolean hayAlmuerzo) {
		instalacion.setAlmuerzo(hayAlmuerzo);
	}
	public void setDisponibilidad(Agenda agenda) {
		// TODO Auto-generated method stub		
	}
	public double calcularGastos(Instalacion instalacion) {
		return instalacion.calcularGastos();
	}
	public double calcularOtrosCostos(Instalacion instalacion) {
		double aux = instalacion.calcularTotalOpcionales() + Instalacion.getCostoViaje();
		return aux;
		
	}
	public double calcularHorasTrabajadas(Instalacion instalacion) {
		return instalacion.calcularHorasTrabajadas();
	}
	
}
