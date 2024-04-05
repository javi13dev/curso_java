package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import model.Pedido;

public class PedidoService {
	
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
	
	HashSet<Pedido> pedidos = new HashSet<Pedido>();
	
	// pedidos.add(new Pedido());
	
	public boolean addPedido(Pedido pedido) {
		if(pedidos.add(pedido)) {
			return true;
		}
		return false;
	}
	

	public HashSet<Pedido> buscarPedidos(Date fechaMin, Date fechaMax) {
		
		HashSet<Pedido> nuevos_pedidos = new HashSet<Pedido>();
		
		for(Pedido p:pedidos) {
			// Bien, pero no entran extremos incluidos, habria que haer el ArrayList del ejemplo
			if(p.getFecha().after(fechaMin) && p.getFecha().before(fechaMax)){				
				nuevos_pedidos.add(p);
			}
		}
		return nuevos_pedidos;
	}
	
	public ArrayList<Pedido> pedidosEntreFechas(Date f1, Date f2){
		ArrayList<Pedido> aux = new ArrayList<Pedido>();
		for(Pedido p:pedidos) {
			if(p.getFecha().compareTo(f1)>=0 && p.getFecha().compareTo(f2)<=0) {
				aux.add(p);
			}
		}
		return aux;
	}
	
	public Pedido buscarPedidoMasReciente() {
		
		Pedido pedido = null;
		Date fMax = new Date(0); // 1-1-1970
		
		// vamos a comparar las fechas 
		for(Pedido p:pedidos) {
			if(p.getFecha().after(fMax)){				
				fMax = p.getFecha();
				pedido = p;
			}
		}
		return pedido;
	}



}