package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Hora {
	private Date fecha;
	Calendar calendario = new GregorianCalendar();
	DateFormat formateadorHora= new SimpleDateFormat("HH:mm:ss");
	DateFormat formateadorH = new SimpleDateFormat("HH");
	public void setearHoraCalendar(String hora1) {
		try {
			fecha = formateadorHora.parse(hora1);
			calendario.setTime(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean validarHoraMañana(String hora) {
		try {
			Date auxiliarDate = fecha;
			auxiliarDate = formateadorHora.parse(hora);
			String horaAuxiliarOcho = "08:00:00";
			String horaAuxiliarCatorce = "14:00:00";
			Date auxiliarOcho = formateadorHora.parse(horaAuxiliarOcho);
			Date auxiliarCatorce = formateadorHora.parse(horaAuxiliarCatorce);
			if(auxiliarDate.compareTo(auxiliarOcho) > 0 && auxiliarDate.compareTo(auxiliarCatorce) < 0) {
				return true;
			}
			else {
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean validarHoraTarde(String hora) {
		try {
			Date auxiliarDate = fecha;
			auxiliarDate = formateadorHora.parse(hora);
			String horaAuxiliarCatorce = "14:00:00";
			String horaAuxiliarVeinte = "20:00:00";
			Date auxiliarCatorce = formateadorHora.parse(horaAuxiliarCatorce);
			Date auxiliarVeinte = formateadorHora.parse(horaAuxiliarVeinte);
			if(auxiliarDate.compareTo(auxiliarCatorce) > 0 && auxiliarDate.compareTo(auxiliarVeinte) < 0) {
				return true;
			}
			else {
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Calendar getCalendario() {
		return calendario;
	}
	public void setCalendario(Calendar calendario) {
		this.calendario = calendario;
	}
	@Override
	public String toString() {

		return  formateadorHora.format(calendario.getTime());
	}
}