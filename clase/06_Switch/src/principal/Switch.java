package principal;

public class Switch {
	// clase comprobar nota
	public static void main(String[] args) {
		int nota = 6;
		// a partir de la nota indicará si
		// suspenso entre 1 y 4
		// aprobado entre 5-6
		// notable entre 7-8
		// sobresaliente 9-10
		
		switch(nota) {
			case 5: 
			case 6: System.out.println("aprobado");
				break;
			case 7:
			case 8: System.out.println("notable");
				break;
			case 9:
			case 10: System.out.println("sobresaliente");
				break;
			default:
				System.out.println("Suspenso");
		}
		
		// El ejercicio pedia indicar desde el 1 al 4, debería recogerlo
		
	}
}
