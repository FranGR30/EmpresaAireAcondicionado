package models;

public enum Opcional {
	SeguroTrabajoAltura("Seguro de trabajo en altura",10),
	SoportePared("Soporte de pared",5);
	
	private String nombreOpcional;
	private double costo;
	
	private Opcional(String nombreOpcional, double costo) {
		this.nombreOpcional = nombreOpcional;
		this.costo = costo;
	}

	public double getCosto() {
		return costo;
	}

	public String getNombreOpcional() {
		return nombreOpcional;
	}

}
