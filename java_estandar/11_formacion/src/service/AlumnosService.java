package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Alumno;
import model.Curso;

public class AlumnosService {
	
	String ruta="cursos.json";
	
	String cadenaConexion = "jdbc:mysql://localhost:3306/formacion";
	String usuario = "root";
	String password = "root";
	
	
	private Stream<Curso> getCursos(){
		try {
			Gson gson=new Gson();
			return 
			Arrays.stream(gson.fromJson(new FileReader(ruta), Curso[].class));
		}
		catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
			return Stream.empty();
		}
	} 
	
	// Leer cursos para añadir:
	
	public List<String> mostrarCursos(){
		
		return getCursos()
				.map( c -> c.getCurso())
				.distinct()
				.toList();
	}
	
	
	
	// Nuevo contacto:
	public boolean nuevoAlumno(Alumno alumno, int idCurso) {
		// comprobar alumno por dni
		if(existeDni(alumno.getDni())) {
			return false;
		}
		
		
		// Si hay un nuevo contacto con ese email, no se añadirá y devolverá false
		try(Connection conn = DriverManager.getConnection(cadenaConexion, usuario, password))  {

				// sustituimos parámetros por valores:
				String sqlInsert = "insert into alumnos (nombre, edad, dni, nota, idCurso) values (?, ?, ?, ?, ?)";
				PreparedStatement ps = conn.prepareStatement(sqlInsert);
				ps.setString(1, alumno.getNombre());
				ps.setInt(2, alumno.getEdad());
				ps.setString(3, alumno.getDni());
				ps.setDouble(4,  alumno.getNota());
				ps.setInt(5, idCurso);
				ps.execute();
				// la primera llamada que no haya next, no devuelve nada. No sería error.
				return true;
				
			// De esta forma la sql se ha proporcionado antes, no en la ejecución.
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	
	
	// Método si existe alumno:
	private boolean existeDni(String dni) {

		try(Connection conn = DriverManager.getConnection(cadenaConexion, usuario, password))  {
			String sql = "select * from alumnos where dni = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, dni);
			ResultSet rs = st.executeQuery();
			
			return rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean addAlumnos(int idCurso) {
		
		// Si hay un nuevo contacto con ese email, no se añadirá y devolverá false
		try(Connection conn = DriverManager.getConnection(cadenaConexion, usuario, password))  {
				
				List<Alumno> alumnos = getCursos()
				.flatMap(a -> a.getAlumnos().stream())
				.toList();
				
				alumnos.forEach(a -> {
					
					// sustituimos parámetros por valores:
					String sqlInsert = "insert into alumnos (nombre, edad, dni, nota, idCurso) values (?, ?, ?, ?, ?)";
					PreparedStatement ps;
					try {
						ps = conn.prepareStatement(sqlInsert);
						ps.setString(1, a.getNombre());
						ps.setInt(2, a.getEdad());
						ps.setString(3, a.getDni());
						ps.setDouble(4,  a.getNota());
						ps.setInt(5,  idCurso);
						
						ps.execute();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				});
				// la primera llamada que no haya next, no devuelve nada. No sería error.
				return true;
				
			// De esta forma la sql se ha proporcionado antes, no en la ejecución.
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	

}
