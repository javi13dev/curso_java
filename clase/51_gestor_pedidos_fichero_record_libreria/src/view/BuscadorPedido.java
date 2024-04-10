package view;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;

import curso.io.LectorTeclado;
import model.Pedido;
import service.PedidoService;

public class BuscadorPedido {
	
	static HashSet<Pedido> pedidos = new HashSet<Pedido>();
	static PedidoService service = new PedidoService();

	public static void main(String[] args) throws ParseException {
		
		LectorTeclado lector = new LectorTeclado();
		/**
		 * Programa para manejar pedidos. Un pedido se caracteriza por producto,unidades,fechaPedido.
		Se presenta el siguiente menú:
		1.- Nuevo pedido
		2.- Pedido más reciente
		3.- Pedidos entre dos fechas
		4.- Salir
		
		2: Muestra los datos del pedido más reciente
		3: Se solicitan dos fechas, y se muestran los pedidos realizados
		en ese rango de fechas 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int opcion;
		do {
			//presentar menu
			//leer opción y comprobar opcion elegida
			presentarMenu();
			opcion=lector.readInt();
			switch(opcion) {
				case 1:
					agregarPedido();
					break;
				case 2:
					pedidoMasReciente();
					break;
				case 3:
					entreDosFechas();
					break;
				case 4:
					System.out.println("Adios!");
					break;
				default:
					System.out.println("Opción no válida!");
			}
		}while(opcion!=4);
	}
	
	static void presentarMenu() {
		System.out.println("""
				1.- Agregar pedido
				2.- Mostrar pedido más reciente
				3.- Buscar pedidos 
				4.- Salir
				
				""");
	}
	
	static void agregarPedido() throws ParseException {
	
		LectorTeclado lector = new LectorTeclado();
		
		System.out.println("Agregar producto: ");
		String producto = lector.readString();
		System.out.println("Número de unidades: ");
		int unidades = lector.readInt();
		System.out.println("Fecha: dd/mm/yyyy ");
		DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateFromString=LocalDate.parse(lector.readString(), format);
		
		Pedido pedido = new Pedido(producto, unidades, dateFromString);
		
		if(service.addPedido(pedido)) {
			System.out.println("Pedido agregado");
		}
	}
	
	static void pedidoMasReciente() {
	
		Pedido pedido = service.pedidoMasReciente();
		DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Pedido: " + pedido.producto());
		//System.out.println("Fecha " + format.format(pedido.getFecha()));
	}
	
	static void entreDosFechas() throws ParseException {
		LectorTeclado lector = new LectorTeclado();
		DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Introduce una fecha inicial: ");
		LocalDate dateInicio=LocalDate.parse(lector.readString(), format);
	
		System.out.println("Introduce una fecha final: ");
		LocalDate dateFinal=LocalDate.parse(lector.readString(), format);

		
		pedidos = service.buscarPedidos(dateInicio, dateFinal);
		// El otro método de ejemplo devolvia un arraylist que también habría que recorrer y mostrar
		
		for(Pedido p:pedidos) {
			System.out.print("Producto: "+p.producto()+" ");
			System.out.print("Unidades: "+p.unidades()+" ");
			System.out.println("Fecha pedido: "+p.fechaPedido().format(format)+" ");
		}
	}

}
