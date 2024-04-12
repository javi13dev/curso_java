package view;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import model.Movimiento;
import service.CuentaMovimientos;


public class Banco {
	static CuentaMovimientos cm;
	public static void main(String[] args) {
		
		/**
		Pide el saldo inicial y limite, después:
		1.- Ingresar
		2.- Extraer
		3.- Saldo y movimientos
		4.- Salir 
		 */

		double saldo;
		double limite;
		
		
		Scanner sc = new Scanner(System.in);
		

		System.out.println("Saldo inicial: ");
		saldo = Double.parseDouble(sc.nextLine());
		System.out.println("Límite: ");
		limite = Double.parseDouble(sc.nextLine());
		
		cm = new CuentaMovimientos(saldo, limite);
		
		
		int opcion;
		do {
			presentarMenu();
			opcion=sc.nextInt();
			switch(opcion) {
				case 1:
					ingresar();
					break;
				case 2:
					extraer();
					break;
				case 3:
					verMovimientos();
					break;
				case 4:
					System.out.println("Adios!");
					break;
				default:
					System.out.println("Opción no válida!");
			}
		}while(opcion!=4);
	}
	
	static void presentarMenu() {
		System.out.println("""
				1.- Ingresar
				2.- Extraer
				3.- Saldo y movimientos 
				4.- Salir
				
				""");
	}

	
	static void ingresar() {
		Scanner sc = new Scanner(System.in);
		double cantidad;
		
		System.out.println("Ingresar cantidad: ");
		cantidad = Double.parseDouble(sc.nextLine());
		
		cm.ingresar(cantidad);
		System.out.println("Se ha ingresado: " + cantidad);
	}
	static void extraer() {
		Scanner sc = new Scanner(System.in);
		double cantidad;
		
		System.out.println("Extraer cantidad: ");
		cantidad = Double.parseDouble(sc.nextLine());
		
		cm.extraer(cantidad);
		System.out.println("Se ha extraido: " + cantidad);
	}
	static void verMovimientos() {
		
		/**
		 * toString en json: 
			@Override
			 
			public String toString() {
				return """
						{"cantidad" : %s, "fechaHora" : "%s", "tipo" : "%s"}""".stripIndent().formatted(cantidad, fechaHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), tipo);
			} 
		 */
		
		ArrayList<Movimiento> movimientos = cm.obtenerMovimientos();
		
		System.out.println("Saldo: " + cm.obtenerSaldo());
		System.out.println("Movimientos: ");
		for(Movimiento m:movimientos) {
			System.out.println( "Cantidad: " + m.getCantidad() + " Fecha: " + m.getFechaHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))+ " Tipo: " +  m.getTipo());
		}
	}
}
