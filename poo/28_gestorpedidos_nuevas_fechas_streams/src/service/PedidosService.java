package service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import model.Pedido;

public class PedidosService {
	HashSet<Pedido> pedidos=new HashSet<>();
	
	public void nuevoPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	public Pedido pedidoMasReciente() {
		/**
		Pedido pAux=null;
		LocalDate fMax=LocalDate.of(0,1,1); //1/1/1970
		for(Pedido p:pedidos) {
			if(p.getFechaPedido().isAfter(fMax)) {
				fMax=p.getFechaPedido();
				pAux=p;
			}
		}
		return pAux;
		*/
		
		return pedidos.stream()
		.max((a,b) -> a.getFechaPedido().compareTo(b.getFechaPedido()))
		.orElse(null);
		
		/**
		return pedidos.stream()
				.max(Comparator.comparing(p -> p.getFechaPedido()))
				.orElse(null);
		*/
	}
	
	// Lo mejor seria devolver un optional
	
	/**
	public Optional<Pedido> pedidoMasReciente() {
		
		return pedidos.stream()
		.max((a,b) -> a.getFechaPedido().compareTo(b.getFechaPedido()));
		
	}
	*/
	
	// Si hay más de un pedido, que devuelva la que tenga más unidades.
	// La solución es encadenando comparaciones.
	// Ej: thenComparing()
	
	
	public Optional<Pedido> pedidoMasRecienteUnico() {
		
		return pedidos.stream()
				.max(Comparator.comparing((Pedido p) -> p.getFechaPedido()).thenComparingInt((Pedido p) -> p.getUnidades()));
				
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Pedido> pedidosEntreFechas(LocalDate f1, LocalDate f2) {
		/**
		ArrayList<Pedido> aux=new ArrayList<Pedido>();
		for(Pedido p:pedidos) {
			//si fecha del pedido es posterior o igual a f1 y anterior o igual a f2, se incluye
			if(p.getFechaPedido().compareTo(f1)>=0&&p.getFechaPedido().compareTo(f2)<=0) {
				aux.add(p);
			}
		}
		return aux;
		*/
		
		return pedidos.stream()
				.filter(p -> p.getFechaPedido().compareTo(f1)>=0&&p.getFechaPedido().compareTo(f2)<=0)
				.collect(Collectors.toList());
	}
	
	public Pedido pedidoProximoFecha(LocalDate fecha) {
		/**
		Pedido pAux=new Pedido();
		pAux.setFechaPedido(LocalDate.of(1, 1, 1));
		//comparamos la diferencia de días entre la fecha de cada pedido y la 
		//parámetro, con la diferencia de días entre la fecha auxiliar y la parámetro
		//si la del pedido es inferior, actualizamos la variable pedido auxiliar
		 
		for(Pedido p:pedidos) {
			if(Math.abs(ChronoUnit.DAYS.between(p.getFechaPedido(), fecha))<
					Math.abs(ChronoUnit.DAYS.between(pAux.getFechaPedido(), fecha))) {
				pAux=p;
			}
		}
		return pAux;
		*/
		
		// Al ser la diferencia entre dias, es una comparación de enteros.
		// Entre la fecha recibida como parámetro,y la fecha del pedido.
		return pedidos.stream()
				.min(Comparator.comparingLong(p -> Math.abs(ChronoUnit.DAYS.between(p.getFechaPedido(), fecha))))
				//.min((a,b) -> Long.compare(Math.abs(ChronoUnit.DAYS.between(a.getFechaPedido(), fecha)) , 
				//Math.abs(ChronoUnit.DAYS.between(b.getFechaPedido(), fecha))))
				.orElse(null);
				
		
	}
	
	
	
	// Método que devuelve la lista de pedidos del producto recibido como parámetro
	
	public List<Pedido> listaPedidos(String producto){
		return pedidos.stream()
				.filter( p -> p.getProducto().equals(producto))
				.toList();
	}
	
	// Método que devuelve el pedido con menor número de unidades. Si hay más de uno, el primero que encuentre.
	
	public Pedido menosUnidades() {
		return pedidos.stream()
				.min(Comparator.comparingInt((Pedido p) -> p.getUnidades()).thenComparing(p -> p.getProducto()))
				.orElse(null);
	}
	
	public Optional<Pedido> pedidoMenorUnidades() {
		return pedidos.stream()
				.min(Comparator.comparingInt((Pedido p) -> p.getUnidades()));
	}
	
	
	// Sobre joining, de Collectors
	
	// Devuelve una cadena con los nombres de todos los productos sin duplicar,
	// separados por un guión.
	
	public String nombreProductos() {
		return pedidos.stream() // Stream<Pedido>
				.map(p->p.getProducto()) // Stream<String>
				.distinct() // Stream<String>
				.collect(Collectors.joining("-"));
	}
	
}
