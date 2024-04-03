package principal;

import java.util.ArrayList;

import model.Ciudad;

public class Prueba {

	public static void main(String[] args) {
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
		
		Ciudad ciudad_vacia = new Ciudad();
		Ciudad ciudad = new Ciudad("Madrid", 6000000, 24.5);
		
		// Podemos crear arraylist de los objetos que hemos definido
		ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
		
		ciudades.add(ciudad);
	}

}
