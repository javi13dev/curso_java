package principal;

/*
Ejercicio:
Vamos a crear un JavaBean Curso😦nombre, duracion, fechaInicio). Despues, crearemmos una lista
con cuatro cursos cualquiera (inventados) y la ordenaremos por fechaInicio. En caso
de fechas iguales, se ordena por duracion. La clase Curso NO implementa Comparable 
*/

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Curso;

public class Test {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<>(List.of(
				new Curso("php", 250, LocalDate.of(2024, 8, 10)),
				new Curso("bbdd", 300, LocalDate.of(2024, 1, 05)),
				new Curso("python", 400, LocalDate.of(2024, 1, 05)),
				new Curso("aws", 150, LocalDate.of(2024, 7, 1)),
				new Curso("java ee", 250, LocalDate.of(2024, 6, 13)))
				);
		
		
		// Ordenar listas sin stream
		cursos.sort(Comparator.comparing( c -> c.getFechaInicio()));
		cursos.forEach(c -> System.out.println(c.getFechaInicio()));
		
		
		// usando una clase anónima, y le indicamos cómo queremos que ordene
		
		Collections.sort(cursos, new Comparator<Curso>() {

			@Override
			public int compare(Curso o1, Curso o2) {
				if(o1.getFechaInicio().equals(o2.getFechaInicio())) { // Si las fechas son iguales, compara duración.
					return Integer.compare(o1.getDuracion(), o2.getDuracion());
				}else { // sino, compara fechas
					return o1.getFechaInicio().compareTo(o2.getFechaInicio());
				}
			}
			
		});
		
		
		cursos.forEach(c -> System.out.println(c.getNombre()));
	}
	
	
	

}
