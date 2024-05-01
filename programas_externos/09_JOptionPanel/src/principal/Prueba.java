package principal;

import javax.swing.JOptionPane;

public class Prueba {

	public static void main(String[] args) {
		// Sirve para mostrar ventanas de diálogo:
		
		// FuncionalidadeS:
		
		// mostrar un mensaje:
		JOptionPane.showMessageDialog(null, "Probando saludo");
		
		// Para introducir cosas mediante la ventana:
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre");
		// Permite introducir String, o parseo de String
		
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce tu edad"));
		
		// Para mostrar el mensaje, podemos usaer el Message y concatenar:
		JOptionPane.showMessageDialog(null, "NOmbre " + nombre + " edad: " + edad);
		
		
		// Para menú de confirmación:
		//  devuelve 1 o 0
		
		int respuesta = JOptionPane.showConfirmDialog(null, "Mensaje de confirmación", "confirmar", JOptionPane.YES_NO_OPTION);
		
		if(respuesta == JOptionPane.YES_OPTION) {
			System.out.println("Se ha confirmado");
		}else {
			System.out.println("No seha confirmado");
		}
		
		
		
		// Para usar JOption y mostrar varias opciones podemos usar un array:
		
		String [] opciones= {"Opcion 1",  "Opcion 2", "Opcion 3"};
		
		// Al final se le pasa el array de opciones, y por defecto la primera posisción seleccionada.
		int seleccion = JOptionPane.showOptionDialog(null, "Elige una copción", "selecciona", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		
		if(seleccion == 0) {
			System.out.println("Has escogido la opcion 1");
		}else if(seleccion == 1){
			System.out.println("Has escogido la opcion 2");
		}else if(seleccion == 2) {
			System.out.println("Has escogido la opcion 3");
		}else {
			
			System.out.println("No has seleccionado opcion");
		}
		

	}

}
