package controller;

import java.util.Calendar;

import gui.Principal;
import gui.TecnicoGUI;
import models.AdministradorSistema;
import models.Administrativo;
import models.Agenda;
import models.Cliente;
import models.Empresa;
import models.EstadoInstalacion;
import models.Factura;
import models.FacturaA;
import models.Fecha;
import models.Hora;
import models.Instalacion;
import models.OperadorCallCenter;
import models.Seniority;
import models.Tecnico;
import models.TipoFactura;
import models.Turno;

public class Test {

	public static void main(String[] args) {
		Tecnico tecnico1 = new Tecnico("Juan",Seniority.Junior,Turno.mañana);
		OperadorCallCenter operador1 = new OperadorCallCenter("Pepe");
		Administrativo administrativo1 = new Administrativo("Carlos Daniel");
		AdministradorSistema administradorSistema1 = new AdministradorSistema("Gary");
		Tecnico tecnico2 = new Tecnico("Lince",Seniority.Senior,Turno.mañana);
		Cliente cliente = new Cliente(987878,"Isa","Sillon 873 PB","isa@gmail.com");
		Fecha fecha = new Fecha();
		fecha.setearFechaCalendar("20/11/2022");
		Instalacion instalacionIsa = new Instalacion(fecha,cliente,tecnico1,TipoFactura.A);
		instalacionIsa.setEstado(EstadoInstalacion.finalizada);
		Hora hora = new Hora();
		hora.setearHoraCalendar("11:00:00");
		Hora hora2 = new Hora();
		hora2.setearHoraCalendar("08:54:00");
		instalacionIsa.setHoraInicio(hora2);
		instalacionIsa.setHoraFin(hora);
		Agenda agenda = new Agenda();
        tecnico1.setDisponibilidad(agenda);
        Empresa.getInstancia().restaurarStock();
        Empresa.getInstancia().restaurarStock();
        Empresa.getInstancia().restaurarStock();
        Empresa.getInstancia().restaurarStock();
        Empresa.getInstancia().restaurarStock();
        Empresa.getInstancia().restaurarStock();
        Empresa.getInstancia().restaurarStock();
		Empresa.getInstancia().getEmpleados().add(tecnico1);
		Empresa.getInstancia().getEmpleados().add(operador1);
		Empresa.getInstancia().getEmpleados().add(administrativo1);
		Empresa.getInstancia().getEmpleados().add(administradorSistema1);
		Empresa.getInstancia().getEmpleados().add(tecnico2);
		Empresa.getInstancia().getClientes().add(cliente);
		Empresa.getInstancia().setInstalacionTecnico(instalacionIsa, tecnico1);	
		Principal principal = new Principal();


	}

}
