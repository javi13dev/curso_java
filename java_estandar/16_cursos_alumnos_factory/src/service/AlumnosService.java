package service;

import model.Alumno;

public interface AlumnosService {

	Alumno alumnoPorDni(String dni);

	boolean guardarAlumno(Alumno alumno);
	
	
	/*
	// En lugar de tener el archivo AlumnosServiceFactory
	// La misma interfaz puede tener métodos que devuelvan una instancia con un método estático:
	 * 
	static AlumnosService of() {
		return new AlumnosServiceImpl();
	}
	
	*/

}