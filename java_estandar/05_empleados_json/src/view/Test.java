package view;

import java.text.ParseException;
import java.util.Scanner;

import principal.EmpleadosService;

public class Test {

	static EmpleadosService service = new EmpleadosService();

	public static void main(String[] args) throws ParseException {
		
		/**
		 * 
		 * Implementar lógica de negocio de una aplicación que proporcione los siguientes métodos
			
			-Lista de empleados de un determinado departamento
			-Empleado con mayor salario
			-Lista de departamentos 
			
		 */

		Scanner sc = new Scanner(System.in);
		
		int opcion;
		do {
			//presentar menu
			//leer opción y comprobar opcion elegida
			presentarMenu();
			opcion=sc.nextInt();
			switch(opcion) {
				case 1:
					buscarEmpleados();
					break;
				case 2:
					mayorSalario();
					break;
				case 3:
					mostrarDepartamentos();
					break;
				case 4:
					System.out.println("Adios!");
					break;
				default:
					System.out.println("Opción no válida!");
			}
		}while(opcion!=5);
	}
	
	static void presentarMenu() {
		System.out.println("""
				1.- Buscar empleados por departamento
				2.- Empleado mayor salario
				3.- Departamentos 
				4.- Salir
				
				""");
	}
	
	public static void mostrarDepartamentos() {
		System.out.println(service.departamentos());
	}
	
	public static void buscarEmpleados() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa el nombre del departamento: ");
		String departamento = sc.nextLine();
		System.out.println(service.mostrarEmpledaos(departamento));
	}
	
	public static void mayorSalario() {
		System.out.println(service.empMayorSalario());

	}
	
	
}
