package SupuestoExamen;

public class TarifaCliente {

	//Declaramos las variables de la clase
	private String nombreT;
	private double precioT;

	//convertimos las variablesprivadas en publicas para meter datos
	public TarifaCliente( String nomT, double preT) {
	
		nombreT = nomT;
		precioT = preT;
		
	}

// Metodos SET
	
	public void setTarifaNombre (String nom) {
		nombreT=nom;
		
	}

	public void setTarifaPrecio (double pre) {
		precioT= pre;
		
	}
	
	
//Metodos GET


	public String getTarifaNombre() {
		return nombreT;
	}

	public double getTarifaAgua() {
		return precioT;
	}
	
	@Override
	
	public String toString() {
		String cadenaTarifa = (" NOMBRE TARIFA:" + getTarifaNombre() + " - PRECIO TARIFA: " + getTarifaAgua()); 
	
		return cadenaTarifa;
		}
}

