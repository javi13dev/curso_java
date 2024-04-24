package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Pedido;
import utilidades.Util;

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
	
	String fichero = "pedidos.csv";
	
	Path pt = Path.of(fichero);
	// cada pedido se graba:
	// producto, unidades, fechaPedido
	
	public void borrarPedidos() {
		// Creamos un objeto File apuntando al fichero y llamar al método delete
		try {
			Files.deleteIfExists(pt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean addPedido(Pedido pedido) {
		
		try{
			Files.writeString(pt, Util.convertirPedidoACadena(pedido)+System.lineSeparator() , StandardOpenOption.APPEND, StandardOpenOption.CREATE);
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	
	public List<Pedido> buscarPedido(LocalDate fechaMin, LocalDate fechaMax) {
		
		try {
			return Files.lines(pt)
			.map(l -> Util.convertirCadenaAPedido(l))
			.filter(p -> p.getFecha().isAfter(fechaMin) && p.getFecha().isBefore(fechaMax))
			.toList();
		} catch (IOException e) {
			e.printStackTrace();
			return List.of();
		}
	}
	
	

	public List<Pedido> pedidosEntreFechas(LocalDate f1, LocalDate f2){

		try {
			return Files.lines(pt)
			.map(l -> Util.convertirCadenaAPedido(l))
			.filter(l -> l.getFecha().compareTo(f1)>=0 && l.getFecha().compareTo(f2)<=0)
			.toList();
		} catch (IOException e) {
			e.printStackTrace();
			return List.of();
		}
		
	
	}
	
	public Pedido pedidoProximoFecha(LocalDate fecha) {
		
		Pedido pAux=new Pedido();
		pAux.setFecha(LocalDate.of(1, 1, 1));
		try(FileReader fr=new FileReader(fichero);
				BufferedReader bf=new BufferedReader(fr);){
			String linea;
			while((linea=bf.readLine())!=null) {
				Pedido p=Util.convertirCadenaAPedido(linea);
				if(Math.abs(ChronoUnit.DAYS.between(p.getFecha(), fecha))<
						Math.abs(ChronoUnit.DAYS.between(pAux.getFecha(), fecha))) {
					pAux=p;
				}
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return pAux;
	}
	
	public Pedido buscarPedidoMasReciente() {
		
		Pedido pedido = null;
		LocalDate fMax = LocalDate.of(0,1,1); // 1-1-1970
		
		ArrayList<Pedido> aux = new ArrayList<Pedido>();
		String linea;
		
		try(FileReader fr=new FileReader(fichero);
			BufferedReader bf=new BufferedReader(fr);){
			while((linea=bf.readLine())!=null) {
				// Tengo que hacer un split de la linea
				pedido = Util.convertirCadenaAPedido(linea);
				if(pedido.getFecha().compareTo(fMax)>=0){
				// if(pedido.getFecha().isAfter(fMax)){
					fMax = pedido.getFecha();
					// pAux = pedido; y devuelvo pedido
					aux.add(pedido);

				}
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return aux.get(0);
	}
	
	public Pedido pedidoMasReciente() {
		
		Files.lines(pt)
		.max(Comparator.comparingLong(Period.between(LocalDate.now(), (LocalDate p) -> p.getFechaPedido()))
		.map(p -> Util.convertirCadenaAPedido(p))
		.orElse(null);
		

	}
	
	
	// Nuevos métodos:
	public void eliminarPedido(String producto) {
		return Files.lines(pt)
				.filter(l -> l.contains(producto))
				.
	
	}
	
	
	public List<Pedido> pedidos(){
		return Files.lines(pt)
		.
	}
}