package model;

import java.time.LocalDate;

public abstract class Empleado {
	private String nombre;
	private int edad;
	private LocalDate fechaIngreso;
	private double salario;
	public static final double BONO = 600.0; // tiene sentido que una constante sea static, ya que es la misma para todos
	// Y public, porque suele ser utilizable fuera de la clase. Y al ser constante no ser necesario getter y setter.
	
	public Empleado(String nombre, int edad, LocalDate fechaIngreso, double salario) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.fechaIngreso = fechaIngreso;
		this.salario = salario;
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

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public abstract void incentivar();
}
