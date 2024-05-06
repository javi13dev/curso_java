package principal;

import java.util.List;

import model.Curso;
import service.FormacionServiceFactory;

public class ProcesoVolcado {
	
	
	public static void main(String[] args) {
		
		// Estas rutas me llevan a poder acceder a los métodos con las variables
		// Ej : cService.cursoPorId(c.getIdCurso())==null)
		
		var aService=FormacionServiceFactory.getAlumnosService();
		var cService=FormacionServiceFactory.getCursosService();
		var cjService=FormacionServiceFactory.getCursosJsonService();
		
		//lista de cursos del fichero
		List<Curso> cursos=cjService.cursosAlumnos();
		//por cada curso, comprobamos si está. Si no está, lo añadimos
		//y también sus alumnos. Si el curso está, no lo añadimos y recorremos sus alumnos
		//para ver si hay alguno nuevo que añadir
		cursos.forEach(c->{
			// Comprueba si el curso ya está en la bbdd
			if(cService.cursoPorId(c.getIdCurso())==null) {
				cService.altaCurso(c);
				c.getAlumnos().forEach(a->{
					//le asignamos al alumno el idCurso al que pertenece
					a.setIdCurso(c.getIdCurso());
					aService.guardarAlumno(a);
				});
			}else {
				c.getAlumnos().forEach(a->{
					// En este caso como el  curso no es nuevo, comprueba primero si el alumno está ya inscrito
					if(aService.alumnoPorDni(a.getDni())==null) {
						//le asignamos al alumno el idCurso al que pertenece
						a.setIdCurso(c.getIdCurso());
						aService.guardarAlumno(a);
					}
				});
			}
		});
	}

}
