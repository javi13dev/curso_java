package principal;

public class Universidad {
	// Tenemos una clase y dentro otra.
	
	// La clase interior cambia de modificador porque tiene que hacer referencia al nombre del paquete
	
	private class Estudiante {
		private String nombre;
		private int edad;
		public Estudiante(String nombre, int edad) {
			this.nombre = nombre;
			this.edad = edad;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getEdad() {
			return edad;
		}
		public void setEdad(int edad) {
			this.edad = edad;
		}
		
	}
	
	// Ahora dentro de la clase Universidad debemos declarar un constructor de  Estudiante a través de un método que devolverá ese mismo estudiante
	public Estudiante nuevoEstudiante(String nombre, int edad) {
		return new Estudiante(nombre, edad);
	}
	
	
	// Y ya podemos tener un main
	public static void main(String [] args) {
		Universidad universidad = new Universidad();
		
		Universidad.Estudiante estudiante = universidad.nuevoEstudiante("Vaneas", 22);
		
		
		System.out.println("Estudiante: " + estudiante.getNombre());
		System.out.println("Edad : " + estudiante.getEdad());
	}
}
