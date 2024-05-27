package model;

/*
	Ejercicio:
	Vamos a crear un JavaBean Curso😦nombre, duracion, fechaInicio). Despues, crearemmos una lista
	con cuatro cursos cualquiera (inventados) y la ordenaremos por fechaInicio. En caso
	de fechas iguales, se ordena por duracion. La clase Curso NO implementa Comparable 
 */

import java.time.LocalDate;

public class Curso {
	private String nombre;
	private int duracion;
	private LocalDate fechaInicio;
	
	public Curso(String nombre, int duracion, LocalDate fechaInicio) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.fechaInicio = fechaInicio;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
}
