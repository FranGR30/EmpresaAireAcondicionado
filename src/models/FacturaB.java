package models;

public class FacturaB extends Factura {

	private double iva = 21;
	
	public FacturaB() {
		super();
	}
	@Override
	public double calcularTotalFactura(Instalacion instalacion) {
		double auxi = instalacion.calcularTotalTiempo() + instalacion.calcularTotalMateriales() + Instalacion.getCostoViaje();
		double totalFactura = (auxi * this.iva)/100 + auxi ;
		this.setTotal(totalFactura);
		return totalFactura;
	}

}
