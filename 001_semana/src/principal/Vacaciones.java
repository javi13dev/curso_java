package principal;

public class Vacaciones {
	
	/*
	 * Segundo ejercicio vacaciones: 
	 * String facturacion="ventas-20800,administracion-17900,informatica-35000,RRHH-10350";
	 * 
		El programa mostrará:
		
		Nombre del departamento que más ha facturado
		Nombres de todos los departamentos, ordenados de menos a más facturación 

	 

	public static void main(String[] args) {
		
		String facturacion="ventas-20800,administracion-17900,informatica-35000,RRHH-10350";
		
		String [][] departamentos = new String[4][2];
		String [] dep;
		String [] fac;
		dep = facturacion.split(",");
		
		// Separados y ordenados
		for(int i=0; i<dep.length; i++) {
			fac = dep[i].split("-");
			
			departamentos[i][0] = fac[0];
			departamentos[i][1] = fac[1];
		}
		
        // El departamento que más ha facturado
        String departamentoMaxFacturado = "";
        int maxFacturacion = 0;
        for (int i = 0; i < departamentos.length; i++) {
            int facturacionActual = Integer.parseInt(departamentos[i][1]);
            if (facturacionActual > maxFacturacion) {
                maxFacturacion = facturacionActual;
                departamentoMaxFacturado = departamentos[i][0];
            }
        }
        System.out.println("Departamento que más ha facturado: " + departamentoMaxFacturado);

        // Orden por facturación de menor a mayor(burbuja)
        for (int i = 0; i < departamentos.length - 1; i++) {
            for (int j = i + 1; j < departamentos.length; j++) {
                if (Integer.parseInt(departamentos[i][1]) > Integer.parseInt(departamentos[j][1])) {
                    String[] aux = departamentos[i];
                    departamentos[i] = departamentos[j];
                    departamentos[j] = aux;
                }
            }
        }
		
        System.out.println("Departamentos por orden de facturación:");
        for (int i = 0; i < departamentos.length; i++) {
            System.out.println(departamentos[i][0]);
        }
	}
	
	*/
	
	public static void main(String[] args) {
		
		String facturacion="ventas-20800,administracion-17900,informatica-35000,RRHH-10350";
		
		String [] datos = facturacion.split(",");
		
		ordenarFacturacion(datos);
		
		// El departamento que más ha facturado
		System.out.println("Departamento con mayor facturación: " + datos[datos.length -1].split("-")[0]);
		
		// Orden por facturación de menor a mayor
		System.out.println("Departamentos en orden de facturación:");
		for(String n:datos) {
			System.out.println(n.split("-")[0]);
		}
		
	}
	
	static void ordenarFacturacion(String [] datos) {
		String aux;
        for (int i = 0; i < datos.length; i++) {
            for (int j = i+1; j < datos.length; j++) {
            	int numI = Integer.parseInt(datos[i].split("-")[1]);
            	int numJ = Integer.parseInt(datos[j].split("-")[1]);
            	
            	if(numI > numJ) {
            		aux = datos[i];
            		datos[i] = datos[j];
            		datos[j] = aux;
            	}
            }
        }
	}

}
