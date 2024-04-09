package model;

import java.time.LocalDate;
import java.util.Date;

public class Pedido {
	
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

	private String nombre;
	private int unidades;
	private LocalDate fecha;
	
	public Pedido() {
		super();
	}

	public Pedido(String nombre, int unidades, LocalDate fecha) {
		super();
		this.nombre = nombre;
		this.unidades = unidades;
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}
