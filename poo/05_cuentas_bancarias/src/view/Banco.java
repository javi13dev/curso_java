package view;

import java.util.ArrayList;
import java.util.Scanner;

import service.CuentaLimite;
import service.CuentaMovimientos;
import model.Movimiento;


public class Banco {
	static CuentaMovimientos service = new CuentaMovimientos(0, 0);
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
		
		CuentaLimite cuenta = new CuentaLimite(saldo, limite);
		
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
		service.ingresar(cantidad);
	}
	static void extraer() {
		Scanner sc = new Scanner(System.in);
		double cantidad;
		
		System.out.println("Extraer cantidad: ");
		cantidad = Double.parseDouble(sc.nextLine());
		service.extraer(cantidad);
		
		System.out.println("Se ha extraido: " + cantidad);
	}
	static void verMovimientos() {
		
		ArrayList<Movimiento> movimientos = service.obtenerMovimientos();
		
		for(Movimiento m:movimientos) {
			System.out.println(m.getCantidad() + " " + m.getFechaHora()+ " " +  m.getTipo() );
		}
	}
}
