package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Operario extends Empleado{
	
	private int nivel;
	
	public Operario(String nombre, int edad, LocalDate fechaIngreso, double salario, int nivel) {
		super(nombre, edad, fechaIngreso, salario);
		this.setNivel(nivel);
	}
	
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		if(nivel<=5&&nivel>=1) {
			this.nivel = nivel;			
		}else {
			this.nivel = 1;
		}
	}
	
	@Override
	public void incentivar() {
		/**
		 *  Si tiene más de 30 años de edad y su nivel es superior a 2, se le incrementará su salario con el doble del bono. 
			Si cumple solo una de las condiciones anteriores, se le incrementará su salario con el bono 
			y si no cumple ninguna, no se hará nada.
		 */
		
		if( getEdad() > 30  && this.getNivel() > 2) {
			this.setSalario(this.getSalario() + Empleado.BONO*2);
		}else if(getEdad() > 30  || this.getNivel() > 2) {
			this.setSalario(this.getSalario() + Empleado.BONO);
		}
	}
	
	public void actualizarNivel() {
		
		/**
		 * Dispondrá además de un método actualizarNivel(), que en caso de que el empleado lleve más
		de dos años en la empresa se le subirá un nivel de seguridad. Si ya está en nivel 5 no se hará
		nada
		 */
		LocalDate fecha_actual = LocalDate.now();
		
		if(ChronoUnit.YEARS.between(fecha_actual, this.getFechaIngreso() ) > 2 && this.getNivel() <5) {
			this.setNivel(this.getNivel()+1);
		}
	}

}
