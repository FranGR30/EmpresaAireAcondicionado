package models;

public class Articulo {
	protected String nombreArticulo;
	protected int cantidad;
	protected double precio;
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Articulo() {
		super();
		this.cantidad = 0;
	}
	public String getNombreArticulo() {
		return nombreArticulo;
	}
	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}
	@Override
	public String toString() {
		return  nombreArticulo + " " + cantidad +" ";
	}
	
}
