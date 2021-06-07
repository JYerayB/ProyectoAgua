package SupuestoExamen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class claseAguaCliente {
	//Declaramos las variables de la clase y el tipo TarifaCliente que apunta a la clase TarifaCliente
	
	private String nombre;
	protected double saldo;
	protected int tarifaselect;
	protected TarifaCliente tarifafinal;
	
	//creamos una variable de arraylist para generar la factura
	
	private ArrayList<Double> registroGastoAgua = new ArrayList<Double>();
	
	//declarar los parametros de las tarifas ( en este caso seran 2)
	
	final private static String nombreTarifa1 = "DIAAGUA";
	final private static String nombreTarifa2 = "NOCHEAGUA";
	final private static double precioTarifa1 = 20;
	final private static double precioTarifa2 = 10;
	
	//convertimos las variablesprivadas en publicas para meter datos
	
	public claseAguaCliente (String nom, double sald,int TS) {
	nombre= nom;
	saldo= sald;
	tarifaselect= TS;
	crearTarifa(tarifaselect);
	}
	
	// Metodos SET ( que no devuelven nada)
	
	// decirle los datos que estan dentrode cada tarifa ( en el if al ser 1 pues te daria lo del 1 y en el else pondrias lo de la tarifa 2)
	
	public void crearTarifa (int select) {
		if ( select == 1 )
			tarifafinal = new TarifaCliente(nombreTarifa1, precioTarifa1);
		else
			tarifafinal = new TarifaCliente(nombreTarifa2, precioTarifa2);
	}
	
	
	//Se utiliza para modificar nombre del cliente que ya esta declarado
	
	public void setnombre (String nom) {
	nombre = nom;
	}
	
	//Introducir una cantidad al saldo que ya se tiene ( se pondria asi por que se utilizaria el metodo para luego sumar mas cantidad al saldo total)
	
	public void setsaldo (double sald) {
		saldo = saldo+ sald;
	
	}
	
	//Declarar el coste del agua ( que sera la cantidad de agua por prefio tarifa haciendo referencia a la clase Tarifa) y se lo restamos al saldo
	
	public void GastoAgua(double cant) {
		
	double coste = cant * tarifafinal.getTarifaAgua();
		saldo = saldo - coste;
		registroGastoAgua.add(coste);//Esto se añade al metodo para que en el Array se añada cada vez que se realiza un gasto y poder generar la factura
	}
	
	
	//Metodos GET ( que devuelven cosas) return
	
	public String getnombre() {
		return nombre;
		
	}
	
	public double getsaldo() {
		return saldo;
	
	}
	
	public String getDatosClienteTarifa() {
		return tarifafinal.toString();
		
	}
	
	public String getDatosTotales() {
		String cadenaDatosFinales= ("\n Nombre" + getnombre() + "\n Saldo " + getsaldo() + "\n" +getDatosClienteTarifa());
		return cadenaDatosFinales;
	}
	
	//Metodo EXTRA
	
	//Este es el metodo que se copia del pdf de la ut6 de leer y escribir archivos, para que nos genere la factura con la arraylist de registro de agua y que la primera celda de cada linea sea +1
	//y en la siguiente el dinero que es lo que se guarda en la arraylist for(int i=0; i < registroGastoAgua.size(); i++){ output.println((i+1) + " " + registroGastoAgua.get(i) );}
	// hay que añadir el throws FileNotFoundException en el public void para que no tenga excepciones cuando no lo encuentra
	
	
	public void generaFactura() throws FileNotFoundException {
		
		String filenombre = "Factura.txt";
				 File file = new File(filenombre);
				 
				 PrintWriter output = new PrintWriter(file);
				 	for(int i=0; i < registroGastoAgua.size(); i++){
				 output.println((i+1) + " " + registroGastoAgua.get(i) );
				}
				 output.close();
		}
	
	public void generaGrafica() {
		// crea un DataSet para almacenar datos xy
		 XYSeries series = new XYSeries("series gasto agua");
		// agregue datos al conjunto de datos (aquí asuma que los datos están en ArrayLists x e y 
		for(int i = 0; i < registroGastoAgua.size(); i++){
		 series.add((i+1),registroGastoAgua.get(i));
		 }
		 
		XYSeriesCollection data = new XYSeriesCollection();
		 data.addSeries(series);
		// crear un gráfico utilizando el método createYLineChart ...
		JFreeChart chart = ChartFactory.createXYLineChart( "Line Chart","x","y", data);
		// mostrar el gráfico en un ChartFrame... 
		
		ChartFrame frame = new
		
		ChartFrame("XY graph using JFreeChart",chart);
		 frame.pack();
		 frame.setVisible(true);
		
		
		
	}
}