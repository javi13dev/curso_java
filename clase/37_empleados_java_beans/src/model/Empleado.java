package model;

public class Empleado {
	
	/**
	 * Realizar un programa para la gestión de empleados de una empresa. 
	 * Un empleado se caracteriza por un nombre, email, edad, y tiene asociado un código de empleado.
		al iniciar el programa, aparecerá el siguiente menú:
		1.- Nuevo empleado
		2.- Buscar empleado
		3.- Eliminar empleado
		4.- Mostrar datos de todos los empleados
		5.- Salir
		
		1: Se pide el nómbre, email, edad y código del empleado. Si no existe empleado con ese código, se guarda, pero si el código ya existe, no se guarda y se muestra advertencia al usuario
		2: Se pide el código del empleado y se muestra sus datos
		3: Se pìde el código del empleado y se borra, indicando un mensaje que diga el nombre del empleado que se ha borrado
		4.- Muestra datos de todos los empleados 
	 */
	
	private int codigo;
	private String nombre;
	private String email;
	private int edad;
	
	
	
	public Empleado(int codigo, String nombre, String email, int edad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
	}

	public Empleado() {
		super();
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	

}
