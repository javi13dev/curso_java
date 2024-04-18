package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Director extends Empleado {
	private String departamento;
	private int personal;
	
	
	
	public Director(String nombre, int edad, LocalDate fechaIngreso, double salario, String departamento,int personal) {
		super(nombre, edad, fechaIngreso, salario);
		this.departamento = departamento;
		this.personal = personal;
	}



	public String getDepartamento() {
		return departamento;
	}



	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}



	public int getPersonal() {
		return personal;
	}



	public void setPersonal(int personal) {
		this.personal = personal;
	}



	public void incentivar() {
		/**
		 *  Si el lleva más de 30 meses en la empresa y tiene más de 20 personas a su cargo, se le
			incrementará su salario con el doble del bono. 
			Si cumple solo una de las condiciones anteriores, se le incrementará su salario con el bono 
			y si no cumple ninguna, no se hará nada
		 */
		LocalDate fecha_actual = LocalDate.now();
		
		
		if(ChronoUnit.MONTHS.between(fecha_actual, this.getFechaIngreso() ) > 30  && this.personal > 20) {
			setSalario(this.getSalario() + this.BONO*2);
		}else if(ChronoUnit.MONTHS.between(fecha_actual, this.getFechaIngreso() ) > 30  || this.personal > 20) {
			setSalario(this.getSalario() + this.BONO);
		}
	}
	
	
}
