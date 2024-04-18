package test;

import java.time.LocalDate;

import model.Director;

public class Test {

	public static void main(String[] args) {
		
		Director dr = new Director("Dire", 20, LocalDate.of(10, 10, 10), 20000.0, "Direccion", 20);
		
		System.out.println(dr.getNombre());
		System.out.println(dr.getSalario());
		
		dr.incentivar();
		
		System.out.println(dr.getSalario());
	}

}
