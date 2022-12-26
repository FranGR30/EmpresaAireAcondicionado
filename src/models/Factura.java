package models;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Factura {
	protected int idFactura;
	protected double total;
	protected Instalacion instalacion;
	protected ArrayList<ItemFactura> items = new ArrayList<ItemFactura>();
	public Factura() {
		super();
		this.idFactura = Herramientas.contadorIdFactura();
	}

	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public int getIdFactura() {
		return idFactura;
	}
	
	
	public Instalacion getInstalacion() {
		return instalacion;
	}

	public void setInstalacion(Instalacion instalacion) {
		this.instalacion = instalacion;
	}

	public ArrayList<ItemFactura> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemFactura> items) {
		this.items = items;
	}

	public double calcularTotalFactura(Instalacion instalacion) {
		double totalFactura = instalacion.calcularTotalTiempo() + instalacion.calcularTotalMateriales() + Instalacion.getCostoViaje();
		return totalFactura;
	}
	public void asignarItems(Instalacion instalacion) {
		for(Articulo a:instalacion.getArticulos()) {
			ItemFactura nuevoItem = new ItemFactura(a.getNombreArticulo(),a.getPrecio(),1);
			this.items.add(nuevoItem);
		}
		for(Opcional o:instalacion.getOpcionales()) {
			ItemFactura nuevoItem = new ItemFactura(o.getNombreOpcional(),o.getCosto(),1);
			this.items.add(nuevoItem);
		}
		ItemFactura nuevoItem = new ItemFactura("Horas trabajadas",instalacion.calcularTotalTiempo(),instalacion.calcularHorasTrabajadas());
		this.items.add(nuevoItem);
	}

	@Override
	public String toString() {
		return "Factura id: " + idFactura + " Total: " + total+ " " + instalacion + "Items: "
				+ items;
	}
}
