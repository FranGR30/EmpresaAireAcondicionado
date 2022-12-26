package models;

import java.util.ArrayList;

public class TurnoOcupado {
	private Fecha fecha;
	private Turno turno;
	private int franjasOcupadas;

	public TurnoOcupado(Fecha fecha, Turno turno) {
		super();
		this.fecha = fecha;
		this.turno = turno;
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
	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public int getFranjasOcupadas() {
		return franjasOcupadas;
	}

	public void setFranjasOcupadas(int franjasOcupadas) {
		this.franjasOcupadas = franjasOcupadas;
	}

	
	
	
	
	
}
