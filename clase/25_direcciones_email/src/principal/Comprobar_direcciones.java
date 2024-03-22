package principal;

public class Comprobar_direcciones {
	// Funciones separadas del main

	public static void main(String[] args) {
		String emails="aaa@gmail.com ,bbb@tel.es,ccc@gmail.es,ddd@gmail.com,abc@hotmail.com";
		//indicar cuantas direcciones hay de cada dominio
		int contEs=0,contCom=0;
		String[] direcciones=emails.split(",");
		
		contEs = contarDominio("es", direcciones);
		contCom = contarDominio("com", direcciones);
		
		System.out.println("Direcciones .es: " + contEs);
		System.out.println("Direcciones .com: " + contCom);
		
		// o bien, para no almacenar en variables innecesariamente
		System.out.println("Direcciones .es: " + contarDominio("es", direcciones));
	}
	
	static int contarDominio(String dominio, String [] dirs) {
		int contador = 0;
		for(String dir: dirs) {
			// Si la dirección termina en el dominio recibido, incrementamos el contador
			if(dir.endsWith(dominio)) {
				contador++;
			}
		}
		return contador;
	}

}
