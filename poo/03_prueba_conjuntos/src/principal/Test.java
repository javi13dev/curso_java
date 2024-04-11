package principal;

import java.util.HashSet;
import java.util.Objects;


class Ciudad {
	private String nombre;
	private int poblacion;
	
	public Ciudad(String nombre, int poblacion) {
		super();
		this.nombre = nombre;
		this.poblacion = poblacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombre, poblacion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciudad other = (Ciudad) obj;
		return Objects.equals(nombre, other.nombre) && poblacion == other.poblacion;
	}
	@Override
	public String toString() {
		// return "Ciudad [nombre=" + nombre + ", poblacion=" + poblacion + "]";
		return "{\"nombre\":"+nombre+",\"poblacion\":"+poblacion+"}";
	}
	
	/**
	
	@Override
	public boolean equals(Object obj) {
	
		// Aqui vamos a modificar el método equals
		// Se puede castear de padres a hijos, para compararlos
		Ciudad aux = (Ciudad) obj;
		// Una vez tengo el objeto, comparamos nombre y población
		 
		if(nombre.equals(aux.getNombre()) && poblacion==aux.getPoblacion()) {
			return true;
		}
		return false;
	}
	
	
	// Además para comparar los objetos la igualdad la detemrinan equals() y el Hashcode debe ser el mismo.
	// hay un método hasCode()
	
	@Override
	public int hashCode() {
		// Si determinamos que una ciudad tiene mismo nombre y población van a ser iguales.
		return nombre.length()+poblacion;
	}
	
	*/
	
	
	
}

public class Test {

	public static void main(String[] args) {
		// Creamos un conjunto de objetos ciudad
		HashSet<Ciudad> ciudades = new HashSet<Ciudad>();
		
		ciudades.add(new Ciudad("ciudadA",20000));
		ciudades.add(new Ciudad("ciudadB",35000));
		ciudades.add(new Ciudad("ciudadA",20000));
		
		System.out.println(ciudades.size());
		
		for(Ciudad c:ciudades) {
			System.out.println(c.getNombre() + " Población: " +c.getPoblacion());
		}
		
		for(Ciudad c:ciudades) {
			System.out.println(c);
		}
		
		System.out.println(ciudades);
		

	}
}
