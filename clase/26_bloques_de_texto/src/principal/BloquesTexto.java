package principal;

public class BloquesTexto {

	public static void main(String[] args) {
		// String tutorial = "Probando el escape para caracteres \"html\" : \n para el salto de linea, y como hacemos para un texto muy largo...";
		
		// Desde java 14 se permite el uso de bloques de texto
		String bloqueTutorial = """ 
				Estas comillas respetarían todos los caracteres usados como comillas ""
				También respetan los saltos de línea
				Y se pueden eliminar los saltos de líneas con el escape \
				Vemos el no salto de linea
					Tabulaciones
				Y otros caracteres (!/%/·!=·)(/ """;
		
		System.out.println(bloqueTutorial);
	}

}
