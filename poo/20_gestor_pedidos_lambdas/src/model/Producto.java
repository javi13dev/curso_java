package model;

public class Producto {
	
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
	private String nombre;
	private double precio;
	public String categoria;
	
	
	public Producto(String nombre, double precio, String categoria) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}
	public Producto() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
}
