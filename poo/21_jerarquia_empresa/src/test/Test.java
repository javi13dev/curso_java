package test;

import java.time.LocalDate;

import model.Director;
import model.Operario;

public class Test {

	public static void main(String[] args) {
		
		Director dr = new Director("Dire", 20, LocalDate.of(2000, 10, 10), 20000.0, "Direccion", 21);
		
		Operario op = new Operario("Ope", 35, LocalDate.of(10, 10, 10), 15000, 3);
		Operario op2 = new Operario("Ope", 35, LocalDate.of(10, 10, 10), 15000, 1);
		
		System.out.println("Director: ");
		System.out.println(dr.getNombre());
		System.out.println(dr.getSalario());
		dr.incentivar();
		System.out.println(dr.getSalario());
		
		System.out.println("Operario: ");
		System.out.println(op.getNombre());
		System.out.println(op.getSalario());
		op.incentivar();
		System.out.println(op.getSalario());
		
		System.out.println("Operario 2: ");
		System.out.println(op2.getNombre());
		System.out.println(op2.getSalario());
		op2.incentivar();
		System.out.println(op2.getSalario());
	}

}
