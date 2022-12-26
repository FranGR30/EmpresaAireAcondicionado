package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha {
    DateFormat formateador= new SimpleDateFormat("dd/M/yy");
    private Date fecha;
    Calendar calendario = new GregorianCalendar();

    public void setearFechaCalendar(String fecha1) {
        try {
            fecha = formateador.parse(fecha1);
            calendario.setTime(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public boolean validarFecha(String fechaString) {
    	try {
	    	Date fechaFormateada = formateador.parse(fechaString);
	    	Date fechaAux = new Date();
	    	if(fechaFormateada.compareTo(fechaAux) <= 0) {
	    		return false;
	    	}
	    	Calendar calendarioAux = new GregorianCalendar();
	    	calendarioAux.setTime(fechaFormateada);
	    	int diaInt = calendarioAux.get(Calendar.DAY_OF_WEEK);
	    	if(diaInt == 1) {
	    		return false;
	    	}
    	} catch (ParseException e) {
            e.printStackTrace();
        }
    	return true;
    	
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public DateFormat getFormateador() {
        return formateador;
    }

    @Override
    public String toString() {

        return  formateador.format(calendario.getTime());
    }

	public Calendar getCalendario() {
		return calendario;
	}

}
