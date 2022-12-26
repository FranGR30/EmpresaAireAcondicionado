package models;

import java.util.ArrayList;

public class Agenda {
	private ArrayList<TurnoOcupado> turnosOcupados = new ArrayList<TurnoOcupado>();

	public boolean estaLibre(Fecha fecha, Turno turno) {
		for (TurnoOcupado to : turnosOcupados) {
			if (to.getTurno().equals(turno)) {
				if (to.getFecha().toString().equals(fecha.toString())) {
					if (to.getFranjasOcupadas() == 2) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public TurnoOcupado devolverTurnoConFranjaLibre(Fecha fecha, Turno turno) {
		if (this.estaLibre(fecha, turno)) {
			for (TurnoOcupado to : turnosOcupados) {
				if (to.getFecha().toString().equals(fecha.toString()) && to.getTurno().equals(turno)) {
					if (to.getFranjasOcupadas() == 1) {
						return to;
					}
				}
			}
		}
		return null;
	}

	public void ocuparTurno(Fecha fecha, Turno turno) {
		TurnoOcupado turnoAux = devolverTurnoConFranjaLibre(fecha, turno);
		if (turnoAux != null) {
			turnoAux.setFranjasOcupadas(turnoAux.getFranjasOcupadas() + 1);
		} else if (estaLibre(fecha, turno)) {
			TurnoOcupado nuevoTurno = new TurnoOcupado(fecha, turno);
			this.turnosOcupados.add(nuevoTurno);
			nuevoTurno.setFranjasOcupadas(nuevoTurno.getFranjasOcupadas() + 1);
		}
	}

	public void liberarTurno(Fecha fecha, Turno turno) {
		for (TurnoOcupado to : turnosOcupados) {
			if (to.getFecha().toString().equals(fecha.toString())) {
				if (to.getTurno().equals(turno)) {
					if (to.getFranjasOcupadas() == 2) {
						to.setFranjasOcupadas(to.getFranjasOcupadas() - 1);
					}
				}
			}
			else if (to.getFecha().toString().equals(fecha.toString())){
					if( to.getTurno().equals(turno)) { 
						if(to.getFranjasOcupadas() == 1) {
							to.setFranjasOcupadas(to.getFranjasOcupadas() - 1);
							turnosOcupados.remove(to);
						}
						}
					}
			}
		}
	
}
