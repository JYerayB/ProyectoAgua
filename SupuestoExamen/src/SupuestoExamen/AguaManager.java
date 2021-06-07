package SupuestoExamen;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

public class AguaManager {

	public static void main(String[] args) throws FileNotFoundException {
		
		String nombreUsuario;
		double saldo;
		int tipotarifa;
		// para el Switch
		char opcion;
		
		
		//Do while para declarar el nombr del cliente, su saldo inicial y tipo de tarifa
		
		nombreUsuario = JOptionPane.showInputDialog ("Introduzca Usuario: ");
		
		do {
		saldo = Double.parseDouble(JOptionPane.showInputDialog ("Introduzca saldo mayor a 20€: "));
			
		}
		while (saldo<20);
		
		tipotarifa = Integer.parseInt(JOptionPane.showInputDialog ("Introduzca Tipo Tarifa: "));

		//Para crear un cliente supper
		//ClienteSuper cliente2 = new ClienteSuper ((nombreUsuario, saldo, tipotarifa);
		
		claseAguaCliente cliente1 = new claseAguaCliente (nombreUsuario, saldo, tipotarifa);
	
		
		// Crear menu con opcion usando Do While y dentro un SwitchCase
		
		do {
			
		opcion=JOptionPane.showInputDialog ("Introduzca opcion, para salir s \n 1)Introduzca recarga \n 2)Introduzca agua gastada \n 3)Obtener saldo \n 4) Obtener datos totales \n 5)Obtener factura \n 6)Obtener grafica \n 7) s= Salir ").charAt(0);
		
		
		// opciones menu
		
		switch(opcion) {
	//Declaramos el saldo inicial
		case '1':
			saldo = Double.parseDouble(JOptionPane.showInputDialog ("Introduzca recarga"));
			cliente1.setsaldo(saldo);
		break;
	//Declaramos el agua gastada
		case '2':
			double aguagastada = Double.parseDouble(JOptionPane.showInputDialog ("Introduzca agua gastada"));
			cliente1.GastoAgua(aguagastada);
			
		break;
	// Nos apunta a getnombre y getsaldo para entregar el resultado de los mismos		
		case '3':
			JOptionPane.showMessageDialog(null, " El saldo de: " + cliente1.getnombre() + " es " + cliente1.getsaldo()); 
			
		break;
	//Este caso te entrega losdatos del cliente de manera detallada
		case '4':
			JOptionPane.showMessageDialog(null, "Los datos del cliente detallados son: \n " + cliente1.getDatosTotales());
			
			break;
		// Para generar la factura con el metodo de generaFactura de la clase principal
		case '5':
			cliente1.generaFactura();
			JOptionPane.showMessageDialog(null, "Se ha generado la factura");
			break;
	// Para generar la grafica con el metodo de generaFactura de la clase principal	
		case '6':
			cliente1.generaGrafica();
			JOptionPane.showMessageDialog(null, "Se ha generado la Grafica");
			break;
	//Salir del bucle y terminar
		case 's':
			
			break;
			
		}
		}
		
		while (opcion != 's');
			
	}

}