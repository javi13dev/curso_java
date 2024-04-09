package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

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
	// cada pedido se graba:
	// producto, unidades, fechaPedido
	
	public void borrarPedidos() {
		// Creamos un objeto File apuntando al fichero y llamar al método delete
		File file = new File("fichero");
		file.delete();
	}
	
	public boolean addPedido(Pedido pedido) {
		
		// Escribir en el fichero la nota que recibo
		// Método append
		String pedidoString;
		try(FileOutputStream fos=new FileOutputStream(fichero, true);
			PrintStream out=new PrintStream(fos);){
			pedidoString = pedido.producto()+","+pedido.unidades()+","+pedido.fechaPedido();
			out.println(pedidoString);
			// out.println(pedido.Util.convertirObjetoAString(pedido));
			return true;
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	

	public HashSet<Pedido> buscarPedidos(LocalDate fechaMin, LocalDate fechaMax) {
		
		HashSet<Pedido> nuevos_pedidos = new HashSet<Pedido>();
		Pedido p = null;
		String linea;
		
		try(FileReader fr=new FileReader(fichero);
			BufferedReader bf=new BufferedReader(fr);){
			while((linea=bf.readLine())!=null) {
				// Tengo que hacer un split de la linea
				p = Util.convertirCadenaAPedido(linea);
				if(p.fechaPedido().isAfter(fechaMin) && p.fechaPedido().isBefore(fechaMax)){				
					nuevos_pedidos.add(p);
				}
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return nuevos_pedidos;
	}
	
	
	
	public ArrayList<Pedido> pedidosEntreFechas(LocalDate f1, LocalDate f2){
		ArrayList<Pedido> aux = new ArrayList<Pedido>();
		Pedido p = null;
		String linea;
		
		try(FileReader fr=new FileReader(fichero);
			BufferedReader bf=new BufferedReader(fr);){
			while((linea=bf.readLine())!=null) {
				// Tengo que hacer un split de la linea
				p = Util.convertirCadenaAPedido(linea);
				if(p.fechaPedido().compareTo(f1)>=0 && p.fechaPedido().compareTo(f2)<=0) {
					aux.add(p);
				}
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return aux;
	}
	
	public Pedido pedidoMasReciente() {
		
		Pedido pedido = null;
		LocalDate fMax = LocalDate.of(0,1,1); // 1-1-1970
		
		ArrayList<Pedido> aux = new ArrayList<Pedido>();
		String linea;
		
		try(FileReader fr=new FileReader(fichero);
			BufferedReader bf=new BufferedReader(fr);){
			while((linea=bf.readLine())!=null) {
				// Tengo que hacer un split de la linea
				pedido = Util.convertirCadenaAPedido(linea);
				if(pedido.fechaPedido().compareTo(fMax)>=0){
				// if(pedido.getFecha().isAfter(fMax)){
					fMax = pedido.fechaPedido();
					// pAux = pedido; y devuelvo pedido
					aux.add(pedido);

				}
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		/**
		 * 
		String linea;
		String [] producto = new String[3];
		
		// Leo la nota, la guardo en un array
		try(FileReader fr=new FileReader(fichero);
				BufferedReader bf=new BufferedReader(fr);){
			while((linea=bf.readLine())!=null) {
				// Tengo que hacer un split de la linea
				producto = linea.split(",");
				
				// Formato a partir de un String
				DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dateFromString=LocalDate.parse(producto[2], format);
				
				if(dateFromString.compareTo(fMax) >=0){
					fMax= dateFromString;
					pedido.setNombre(producto[0]);
					pedido.setUnidades(Integer.parseInt(producto[1]));
					pedido.setFecha(dateFromString);
				}
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
		 */
		
		return aux.get(0);
	}
	
	
	public Pedido pedidoProximoFecha(LocalDate fecha) {
		Pedido pAux=new Pedido();
		//pAux.setFechaPedido(LocalDate.of(1, 1, 1));
		try(FileReader fr=new FileReader(fichero);
				BufferedReader bf=new BufferedReader(fr);){
			String linea;
			while((linea=bf.readLine())!=null) {
				Pedido p=Util.convertirCadenaAPedido(linea);
				if(Math.abs(ChronoUnit.DAYS.between(p.fechaPedido(), fecha))<
						Math.abs(ChronoUnit.DAYS.between(pAux.fechaPedido(), fecha))) {
					pAux=p;
				}
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return pAux;
	}



}