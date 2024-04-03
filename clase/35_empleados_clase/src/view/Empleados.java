package view;

import java.util.Arrays;
import java.util.Scanner;
import service.EmpleadosService;

public class Empleados {
	
	static EmpleadosService service = new EmpleadosService();
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int opcion;
		do {
			//presentar menu
			//leer opción y comprobar opcion elegida
			presentarMenu();
			opcion=sc.nextInt();
			switch(opcion) {
				case 1:
					agregarEmpleado();
					break;
				case 2:
					buscarEmpleado();
					break;
				case 3:
					eliminarEmpleado();
					break;
				case 4:
					mostrarEmpleados();
					break;
				case 5:
					System.out.println("Adios!");
					break;
				default:
					System.out.println("Opción no válida!");
			}
		}while(opcion!=5);

	}
	
	static void presentarMenu() {
		System.out.println("""
				1.- Agregar empleado
				2.- Buscar empleado
				3.- Eliminar empleado
				4.- Ver empleados
				5.- Salir
				
				""");
	}
	
	static void agregarEmpleado() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Código del empleado: ");
		int codigo = Integer.parseInt(sc.nextLine());
		System.out.println("Nombre del empleado: ");
		String nombre = sc.nextLine();
		
		if(service.agregarEmpleado(codigo, nombre)) {
			System.out.println("Empleado : " + codigo + " " + nombre + " agregado.");
		}else {
			System.err.println("Código ya existente, no se añadió.");
		}		
	}
	
	static void buscarEmpleado() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Código del empleado: ");
		int codigo = Integer.parseInt(sc.nextLine());
		String nombre = service.buscarEmpleado(codigo);
		
		if(nombre ==null) {
			System.out.println("No existe empleado.");
		}else {
			System.out.println("El empleado es " + nombre);
		}
	}
	
	
	static void eliminarEmpleado() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Código del empleado: ");
		int codigo = Integer.parseInt(sc.nextLine());
		String nombre = service.eliminarEmpleado(codigo);
		
		if(nombre ==null) {
			System.out.println("No existe empleado.");
		}else {
			System.out.println("El empleado eliminado es " + nombre);
		}

	}
	
	static void mostrarEmpleados() {
		String [] empleados = service.todosEmpleados();
		System.out.println("Empleados: " + Arrays.toString(empleados));
	}

}
