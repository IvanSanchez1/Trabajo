package tarjetas;

import java.sql.Date;

public class Tarjeta {

	private MarcaTarjeta marca;
	private int numTarjeta;
	private Date vencimiento;
	private String nombre, apellido;
	private double saldo;
	
	//Constructor
	//Ejemplo: Tarjeta tarjeta1 = new Tarjeta(new Visa(), 1111, 2022, 8, 25, "Ivan", "Sanchez", 800);
	@SuppressWarnings("deprecation")
	public Tarjeta(MarcaTarjeta marca, int numTarjeta, int Anio, int mes, int dia, String nom, String ape, double saldo) {
		this.marca = marca;
		this.numTarjeta = numTarjeta;
		//Considero que el usuario no sera un experto por lo que decido ingresar los datos con formato date a pesar de estar obsoleto actualente
		this.vencimiento = new Date(Anio - 1900, mes - 1, dia);
		this.nombre = nom;
		this.apellido = ape;
		this.saldo = saldo;
	}
	
	//Basicamente un toString de los datos ingresados
	public void imprimirDatosTarjeta() {
		System.out.println("Marca: " + marca.devolverNombreTarjeta() + "\nNumero Tarjeta: " + numTarjeta + 
				"\nFecha de vencimiento: " + vencimiento + "\nNombre: " + nombre + "\nApellido: " + apellido + "\n");
	}
	
	//Verifica si una tarjeta esta vencida o no
	public boolean validarTarjeta() {
		if(vencimiento.getTime() > System.currentTimeMillis()) {
			return true;
		}
		return false;
	}
	
	//Realiza la operacion en caso de ser posible y muestra tanto importe total como marca y tasa de la operacion como pide el enunciado
	public void realizarOperacion(double monto, Tarjeta destinatario) {
		if(!validarTarjeta()) {
			System.out.println("No se puede realizar la operacion porque la tarjeta esta vencida");
			return;
		}else if(identificarSiEsIgual(destinatario)) {
			System.out.println("No se puede transferir a uno mismo");
			return;
		}else if(monto > 1000) {
			System.out.println("No se puede operar con montos mayores a $1000");
		}
		double importeTotal = monto + getTasaDeLaOperacion(monto);
		if(importeTotal > saldo) {
			System.out.println("Saldo insuficiente");
		}
		this.saldo -= (importeTotal);
		destinatario.agregarSaldo(monto);
		System.out.println("Operacion realizada correctamente\nTasa de la operacion: "
		+ getTasaDeLaOperacion(monto) + "\nMarca de tarjeta: " + marca.devolverNombreTarjeta() + "\nImporte total: " + importeTotal);
	}
	
	//Permite agregar saldo a cualquier cuenta bancaria
	public void agregarSaldo(double monto) {
		saldo += monto;
	}
	
	//No es necesario comparar por nada mas que el numero dde tarjeta ya que este es unico
		public boolean identificarSiEsIgual(Tarjeta tarjeta) { 
			if(this.numTarjeta != tarjeta.getNumtarjeta()) {
				return false;
			}else {
				return true;
			}
		}
	
	//Obtiene el porcentaje del monto segun la tasa correspondiente
	public double getTasaDeLaOperacion(double monto) {
		return (monto * getTasaPorServicio()) / 100;
	}
		
	//Calculo de la tasa por el servicio dado segun cada marca de tarjeta
	public double getTasaPorServicio () {
		return marca.calcularTasa(new Date(System.currentTimeMillis()));
	}
	
	//Unico getter necesario para nuesto trabajo
	public int getNumtarjeta() {
		return numTarjeta;
	}
	
	//No se usamos el toString y es redundante ya que esta la funcion imprimirDatosTarjeta pero siempre debe existir
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Marca: " + marca + "\nNumero Tarjeta: " + numTarjeta + 
				"\nFecha de vencimiento: " + vencimiento + "\nNombre: " + nombre + "\nApellido: " + apellido + "\n";
	}
}
