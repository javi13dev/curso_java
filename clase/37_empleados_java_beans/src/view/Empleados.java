package view;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import model.Empleado;
import service.EmpleadoService;

public class Empleados {
	
	/**
	 * Realizar un programa para la gestión de empleados de una empresa. 
	 * Un empleado se caracteriza por un nombre, email, edad, y tiene asociado un código de empleado.
		al iniciar el programa, aparecerá el siguiente menú:
		1.- Nuevo empleado
		2.- Buscar empleado
		3.- Eliminar empleado
		4.- Mostrar datos de todos los empleados
		5.- Salir
		
		1: Se pide el nómbre, email, edad y código del empleado. Si no existe empleado con ese código, se guarda, pero si el código ya existe, no se guarda y se muestra advertencia al usuario
		2: Se pide el código del empleado y se muestra sus datos
		3: Se pìde el código del empleado y se borra, indicando un mensaje que diga el nombre del empleado que se ha borrado
		4.- Muestra datos de todos los empleados 
	 */
	
	static EmpleadoService service = new EmpleadoService();
	
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
		System.out.println("Email del empleado: ");
		String email = sc.nextLine();
		System.out.println("Edad del empleado: ");
		int edad = Integer.parseInt(sc.nextLine());
		
		Empleado empleado = new Empleado(codigo,nombre,email,edad);
		
		if(service.agregarEmpleado(empleado)) {
			System.out.println("Empleado : " + codigo + " " + nombre + " agregado.");
		}else {
			System.err.println("Código ya existente, no se añadió.");
		}		
	}
	
	static void buscarEmpleado() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Código del empleado: ");
		int codigo = Integer.parseInt(sc.nextLine());
		
		Empleado empleado = service.buscarEmpleado(codigo);
		
		if(empleado==null) {
			System.out.println("No existe empleado.");
		}else {
			System.out.println("El empleado es " + empleado.getNombre());
		}
	}
	
	
	static void eliminarEmpleado() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Código del empleado: ");
		int codigo = Integer.parseInt(sc.nextLine());
		
		Empleado empleado = service.eliminarEmpleado(codigo);
		
		if(empleado==null) {
			System.out.println("No existe empleado.");
		}else {
			System.out.println("El empleado eliminado es " + empleado.getNombre());
		}
	}
	
	static void mostrarEmpleados() {
		Empleado[] empleados = service.todosEmpleados();
		for(Empleado e : empleados) {
			System.out.println("Nombre: " + e.getNombre() + ", edad: " + e.getEdad());
		}
	}

}
