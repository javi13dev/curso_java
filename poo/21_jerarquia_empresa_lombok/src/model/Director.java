package model;

import java.time.LocalDate;
import java.time.Period;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Director extends Empleado {
	private String departamento;
	private int personal;
	
	
	@Builder
	public Director(String nombre, int edad, LocalDate fechaIngreso, double salario, String departamento,int personal) {
		super(nombre, edad, fechaIngreso, salario);
		this.departamento = departamento;
		this.personal = personal;
	}

	
	/**
	    Si el lleva más de 30 meses en la empresa y tiene más de 20 personas a su cargo, se le
		incrementará su salario con el doble del bono. 
		Si cumple solo una de las condiciones anteriores, se le incrementará su salario con el bono 
		y si no cumple ninguna, no se hará nada
	 
	@Override
	public void incentivar() {
		 
		LocalDate fecha_actual = LocalDate.now();
		
		if(ChronoUnit.MONTHS.between(fecha_actual, getFechaIngreso() ) > 30  && this.getPersonal() > 20) {
			this.setSalario(this.getSalario() + Empleado.BONO*2);
		}else if(ChronoUnit.MONTHS.between(fecha_actual, getFechaIngreso() ) > 30  || this.getPersonal() > 20) {
			this.setSalario(this.getSalario() + Empleado.BONO);
		}
	}
	
	*/
	
	/**
	@Override
	public void incentivar() {
		Period period=Period.between(getFechaIngreso(), LocalDate.now().plusDays(1));
		if(period.toTotalMonths()>30&&this.getPersonal()>20) {
			this.setSalario(this.getSalario()+2*Empleado.BONO);
		}else if(period.toTotalMonths()>30||this.getPersonal()>20) {
			this.setSalario(this.getSalario()+Empleado.BONO);
		}

	}
	
	*/
	
	
	
}
