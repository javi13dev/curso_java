package view;

import java.util.List;

import model.Curso;
import service.AlumnosService;
import service.CursosService;

public class Formacion {

	static AlumnosService service = new AlumnosService();
	static CursosService cservice = new CursosService();
	
	public static void main(String[] args) {
		
		/*
		Alumno alumno = new Alumno("Juan", 26, "2234A", 6.5);
		int idCurso = 111;
		
		System.out.println(service.mostrarCursos());
		
		if(service.nuevoAlumno(alumno, idCurso)) {
			System.out.println("Alumno agregado");
		}else {
			System.out.println("El alumno ya estaba registrado");
		}
		*/
		
		List<Integer> cursos = cservice.mostrarCursos();
		
		
		for(Integer i: cursos) {
			
			service.getAlumnos(i)
			.forEach(a -> System.out.println(a));
		}



		//.forEach(c -> service.getAlumnos(c))
		//.toList();
		
		
		// Volcar todos los alumnos
		// cservice.addCursos();
		//service.addAlumnos();
	}

}
