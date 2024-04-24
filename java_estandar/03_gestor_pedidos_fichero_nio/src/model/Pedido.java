package model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// Ponemos anotaciones de lombok:
@AllArgsConstructor
@NoArgsConstructor
@Data

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

	private String producto;
	private int unidades;
	private LocalDate fecha;

}
