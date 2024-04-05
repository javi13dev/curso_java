package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

import model.Pedido;
import service.PedidoService;

public class BuscadorPedido {
	
	static HashSet<Pedido> pedidos = new HashSet<Pedido>();
	static PedidoService service = new PedidoService();

	public static void main(String[] args) throws ParseException {
		
		
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
			opcion=sc.nextInt();
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
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Agregar producto: ");
		String producto = sc.nextLine();
		System.out.println("Número de unidades: ");
		int unidades = Integer.parseInt(sc.nextLine());
		System.out.println("Fecha: dd/mm/yyyy ");
		String fecha = sc.nextLine();
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaPedido = format.parse(fecha);
		
		
		Pedido pedido = new Pedido(producto, unidades, fechaPedido);
		
		if(service.addPedido(pedido)) {
			System.out.println("Pedido agregado");
		}
	}
	
	static void pedidoMasReciente() {
	
		Pedido pedido = service.buscarPedidoMasReciente();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Pedido: " + pedido.getNombre());
		System.out.println("Fecha " + format.format(pedido.getFecha()));
	}
	
	static void entreDosFechas() throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una fecha inicial: ");
		String fechaInicial = sc.nextLine();
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date fInicial = format.parse(fechaInicial);
	
		System.out.println("Introduce una fecha final: ");
		String fechaFinal = sc.nextLine();
		
		Date fFinal = format.parse(fechaFinal);
		
		pedidos = service.buscarPedidos(fInicial, fFinal);
		// El otro método de ejemplo devolvia un arraylist que también habría que recorrer y mostrar
		
		for(Pedido p:pedidos) {
			System.out.print("Pedido: " + p.getNombre() +  " ");
			System.out.print("Unidades: " + p.getNombre() + " ");
			System.out.println("Fecha del pedido: " + format.format(p.getFecha()));
		}
	}

}
