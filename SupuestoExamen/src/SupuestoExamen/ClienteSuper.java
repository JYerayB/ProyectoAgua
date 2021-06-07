package SupuestoExamen;

public class ClienteSuper  extends claseAguaCliente {
	
	public ClienteSuper(String nom, double sal, int TS) {
		super(nom, sal, TS);
		
	}
	public void GastoAgua(double cant) {
		
		double coste = cant * tarifafinal.getTarifaAgua();
			saldo = saldo - coste;
		}

}