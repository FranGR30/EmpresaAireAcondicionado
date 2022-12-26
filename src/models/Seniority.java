package models;

public enum Seniority {
	Junior("Junior",30),
	Senior("Senior",70),
	SemiSenior("SemiSenior",45);
	
	private String nombreSeniority;
	private double salarioHora;
	
	private Seniority(String nombreSeniority, double salarioHora) {
		this.nombreSeniority = nombreSeniority;
		this.salarioHora = salarioHora;
	}

	public String getNombreSeniority() {
		return nombreSeniority;
	}

	public void setNombreSeniority(String nombreSeniority) {
		this.nombreSeniority = nombreSeniority;
	}

	public double getSalarioHora() {
		return salarioHora;
	}

	public void setSalarioHora(double salarioHora) {
		this.salarioHora = salarioHora;
	}

}
