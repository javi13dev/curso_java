package principal;

public class Test {

	public static void main(String[] args) {
		// 

		for(ClaseNumerada en :  ClaseNumerada.values()) {
			// Recoreremos a través de los values() que es un método ya construido.
			System.out.println(en);
		}
		
		// Si tenemos una variable enumerada y queremos compararla con otras
		// Creamos un objeto y usamos un switch
		ClaseNumerada nivel = ClaseNumerada.ALTO;
		
		switch(nivel) {
		case ALTO: {
			System.out.println("El nivel es alto"); break;
		}
		case MEDIO: {
			System.out.println("El nivel es medio"); break;
		}
		case BAJO: {
			System.out.println("El nivel es bajo");
		}
		default:
			throw new IllegalArgumentException("Unexpected value "+ nivel);
		}
	}

}
