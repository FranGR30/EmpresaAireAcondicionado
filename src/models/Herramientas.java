package models;

public class Herramientas {
	public static int idEmpleado;
	public static int idInstalacion;
	public static int idFactura;
	public static int idItemFactura;
	
	public static int contadorIdEmpleado() {
		int aux = idEmpleado + 1;
		idEmpleado ++;
		return aux;
	}
	
	public static int contadorIdInstalacion() {
		int aux = idInstalacion + 1;
		idInstalacion ++;
		return aux;
	}
	
	public static int contadorIdFactura() {
		int aux = idFactura + 1;
		idFactura ++;
		return aux;
	}
	public static int contadorIdItemFactura() {
		int aux = idItemFactura + 1;
		idItemFactura ++;
		return aux;
	}
}
