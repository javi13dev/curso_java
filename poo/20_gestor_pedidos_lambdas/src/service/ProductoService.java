package service;
import java.util.ArrayList;
import java.util.List;

import model.Producto;

public class ProductoService {
	List<Producto> lst = new ArrayList<Producto>();

	/**
	 *  Programa para gestión de productos.

		Cada producto tendrá: nombre, precio, categoria
		
		La lógica de negocio, expondrá los siguientes métodos:
		
		-eliminarPorCategoria: elimina de la lista aquellos productos que pertenezcan a la categoría indicada
		
		-bajarPrecio: Baja el precio de todos productos en el porcentaje indicado
		
		-subirPrecioCategoria: Sube el precio a todos los productos de la categoría indicada, en el porcentaje indicado
		
		-obtenerProductos: Devuelve la lista de productos existentes
		-agregarProducto: Añade el producto recibido 
	 */
	
	public void eliminarPorCategoria( String categoria) {
		
		lst.removeIf(p -> p.getCategoria().equals(categoria));	
	}
	
	public void bajarPrecio(int porcentaje) {
		lst.forEach(p -> p.setPrecio(p.getPrecio() - p.getPrecio()*porcentaje/100));
	}
	
	public void subirPrecioCategoria(int porcentaje, String categoria) {
		
		lst.replaceAll(p -> {
			if(p.getCategoria().equals(categoria)) {
				 p.setPrecio(p.getPrecio() + p.getPrecio()*porcentaje/100);
			}
			return p;
		});
		
		lst.forEach(p -> p.setPrecio(p.getPrecio() + p.getPrecio()*porcentaje/100));	
	}
	
	
	public List<Producto> obtenerProductos(){
		return lst;
	}
	
	public void altaProdcuto(Producto producto){
		lst.add(producto);
	}
	
	// Visto en método sort(),
	// Añadimos método para ordenar por Precio.
	public void ordenarPorPrecio() {
		
		lst.sort((a,b)->Double.compare(a.getPrecio(),b.getPrecio()));
		
	}
	 
}



