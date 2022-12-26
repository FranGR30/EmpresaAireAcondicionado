package models;

public class ItemFactura {
	private int idItemFactura;
	private String nombreItem;
	private double costo;
	private double cantidad;
	public ItemFactura(String nombreItem, double costo, double cantidad) {
		super();
		this.nombreItem = nombreItem;
		this.costo = costo;
		this.cantidad = cantidad;
		this.idItemFactura = Herramientas.contadorIdItemFactura();
	}
	public int getIdItemFactura() {
		return idItemFactura;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	@Override
	public String toString() {
		return "\nItem: " +nombreItem + "\nCosto: " + costo
				+ "\nCantidad: " + cantidad;
	}

}
