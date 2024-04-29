package view;

import java.util.Scanner;

import model.Contacto;
import service.AgendaService;
import service.ContactosService;

public class Agenda {
	static AgendaService service = new AgendaService();
	static ContactosService cservice = new ContactosService();

	public static void main(String[] args) {
		
		/**
		1.-Nuevo Contacto
		2.-Eliminar Contacto
		3.-Actualizar edad
		4.-Salir
		
		1: Se piden los datos del nuevo contacto y se guarda
		2: Solicita el email y borra el contacto con dicho email
		3: Solicita email y nueva edad, y sustituye la edad anterior por la nueva en ese contacto 
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
					agregarContacto();
					break;
				case 2:
					eliminarContacto();
					break;
				case 3:
					actualizarContacto();
					break;
				case 4:
					buscarId();
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
				
				1.- Nuevo contacto
				2.- Eliminar contacto
				3.- Actualizar edad en contacto
				4.- Buscar por Id
				5.- Salir
				""");
	}
		

	static void agregarContacto() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Agregar nombre: ");
		String nombre = sc.nextLine();
		System.out.println("email: ");
		String email = sc.nextLine();
		System.out.println("edad: ");
		int edad = Integer.parseInt(sc.nextLine());

		Contacto contacto = new Contacto(nombre, email, edad);
		
		if(cservice.nuevoContacto(contacto)) {
			System.out.println("Contacto agregado");
		}
	
	}
	
	static void eliminarContacto() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el email del contacto: ");
		String email = sc.nextLine();
		
		cservice.eliminarContactoPrivado(email);
		//service.eliminarContacto(email);
		System.out.println("Contacto eliminado");
		
	}
	
	static void actualizarContacto() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el email del contacto: ");
		String email = sc.nextLine();
		System.out.println("Nueva edad: ");
		int edad = Integer.parseInt(sc.nextLine());

		service.actualizarEdad(email, edad);
		System.out.println("Contacto actualizado");
		
	}
	
	static void buscarId() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el id: ");
		int idContacto = Integer.parseInt(sc.nextLine());

		//cservice.buscarContactoPorId(idContacto);
		System.out.println("Nombre del contacto: " + cservice.buscarContactoPorId(idContacto).getNombre());
		
	}
	

}
