package models;

import java.util.ArrayList;

public class Administrativo extends Empleado {
	
	public Administrativo(String nombre) {
		super(nombre);
		this.perfilAcceso = Acceso.ADMINISTRATIVO;
	}
	
	public Factura emitirFactura(Instalacion instalacion) {
		if (instalacion.getTipoFactura() == TipoFactura.B) {
			FacturaB facturaNueva = new FacturaB();
			double aux = facturaNueva.calcularTotalFactura(instalacion);
			facturaNueva.setTotal(aux);
			facturaNueva.asignarItems(instalacion);
			facturaNueva.setInstalacion(instalacion);
			return facturaNueva;
		}else {
			FacturaA facturaNueva = new FacturaA();
			facturaNueva.setTotal(facturaNueva.calcularTotalFactura(instalacion));
			facturaNueva.asignarItems(instalacion);
			facturaNueva.setInstalacion(instalacion);
			return facturaNueva;
		}
	}
	
	
	public ArrayList<Factura> revisarFacturas() {
		return Empresa.getInstancia().getFacturas();
	}
	
	@SuppressWarnings("unused")
	private void ajustarValorItem(int idFactura,int idItemFactura,double costo) {
		for(Factura f:Empresa.getInstancia().listarFacturasEmitidas()) {
			if(f.getIdFactura() == idFactura) {
				for(ItemFactura itf:f.getItems()) {
					if(itf.getIdItemFactura() == idItemFactura) {
						itf.setCosto(costo);
					}
					
				}
			}
		}
	}
	
}
