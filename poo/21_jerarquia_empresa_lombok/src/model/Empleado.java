package model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public abstract class Empleado {
	private String nombre;
	private int edad;
	private LocalDate fechaIngreso;
	private double salario;
	public static final double BONO = 600.0; // tiene sentido que una constante sea static, ya que es la misma para todos
	// Y public, porque suele ser utilizable fuera de la clase. Y al ser constante no ser necesario getter y setter.
	
	public abstract void incentivar();
}
