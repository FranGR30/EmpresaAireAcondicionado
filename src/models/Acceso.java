package models;

public enum Acceso {
TECNICO("Tecnico"),
OPERADOR_CALLCENTER("Operador de call center"),
ADMINISTRATIVO("Administrativo"),
ADMINISTRADOR_SISTEMA("Administrador de sistema");

private String nombre;

private Acceso(String nombre) {
	this.nombre = nombre;
}

public String getNombre() {
	return nombre;
}


}
