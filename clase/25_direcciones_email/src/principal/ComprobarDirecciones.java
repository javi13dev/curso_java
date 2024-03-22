package principal;

public class ComprobarDirecciones {

	public static void main(String[] args) {
		
		String emails="aaa@gmail.com,bbb@tel.es,ccc@gmail.es,ddd@gmail.com,abc@hotmail.com,nuevomail@prueba.net,otromail@hola.org";
		// Mostrar cuántas direcciones de cada dominio hay.
		// Primero. Comprobar qué dominios tengo 
		String[] direcciones=emails.split(",");
		
		// Obtengo los dominios
		//String [] dominios = dominios(direcciones);
		String [] dominios = dominios2(direcciones);
		
		
		// recorro los dominios y con cada uno llamamos al segundo método
		// para que nos diga el número de veces que ese dominio aparece
		// en el aray de direcciones
		
		for(String d:dominios) {
			System.out.println("El dominio " + d + " aparece " + contarDominio(d, direcciones) + " veces.");
		}

	}
	
	
	static int contarDominio(String dominio, String [] dirs) {
		
		int cont = 0;
		for(String dir: dirs) {
			// Si la dirección termina en el dominio recibido, incrementamos el contador
			if(dir.endsWith(dominio)) {
				cont++;
			}
		}
		return cont;
	}
	
	
	
	static String[] dominios(String [] dirs) {
		
		// Guardar en string vacio e ir añadiendo
		String dom = "";
		String dominios = "";
		
		for(String dir: dirs) {
			dom = dir.substring(dir.indexOf(".")+1,dir.length());
			
			if(!dominios.contains(dom)) {
				dominios += dom + ",";
			}
			
			// Otra forma de compararlo, 2:
			if(dominios.indexOf(dom)==-1) {
				dominios = dominios+dom+1;
			}
		}
		
		// En la forma 2, quitamos la ultima coma:
		dominios = dominios.substring(0, dominios.length()-1);
		String [] doms = dominios.split(",");

		return doms;
	}
	
	static String[] dominios2(String [] dirs) {
		// uso de StringBuilder
		
		StringBuilder dominios = new StringBuilder("");
		
		for(String dir: dirs) {
			String dom = dir.substring(dir.indexOf(".")+1,dir.length());
	
			// Otra forma de compararlo:
			if(dominios.indexOf(dom)==-1) {
				dominios.append(dom);
				dominios.append(",");
			}
		}
		
		// quitamos la ultima coma:
		dominios.delete(dominios.length() -1, dominios.length());

		return dominios.toString().split(",");
	}
}
