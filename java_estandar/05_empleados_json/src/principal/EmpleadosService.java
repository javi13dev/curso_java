package principal;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Empleado;

public class EmpleadosService {
	
	/**
	 * 
	 * Implementar lógica de negocio de una aplicación que proporcione los siguientes métodos
		
		-Lista de empleados de un determinado departamento
		-Empleado con mayor salario
		-Lista de departamentos 
		
	 */
	String dir ="C:\\Users\\manana\\Desktop\\java\\java_estandar\\apuntes\\empleados.json";
	Gson gson = new Gson();
	List<Empleado> empleados;
	
	
	/**
	 * 
	 Para reducir codigo, y tener un stream de empleados:
	 
	 String ruta="empleados.json";
	private Stream<Empleado> getEmpleados(){
		try {
			Gson gson=new Gson();
			return 
			Arrays.stream(gson.fromJson(new FileReader(ruta), Empleado[].class));
		}
		catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
			return Stream.empty();
		}
	} 
	 */
	
	public List<Empleado> mostrarEmpledaos(String departamento){
		
		try {
			empleados = Arrays.asList(gson.fromJson(new FileReader(dir), Empleado[].class));
			return empleados.stream()
			.filter( e -> e.getDepartamento().equals(departamento))
			.toList();		
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return List.of();
		}
	}
	
	public Empleado empMayorSalario(){
		
		try {
			empleados = Arrays.asList(gson.fromJson(new FileReader(dir), Empleado[].class));
			return empleados.stream()
			.max(Comparator.comparing(e -> e.getSalario()))
			.orElse(null);		
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<String> departamentos(){
		
		try {
			empleados = Arrays.asList(gson.fromJson(new FileReader(dir), Empleado[].class));
			return empleados.stream()
			.map( e -> e.getDepartamento())
			.distinct()
			.toList();		
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return List.of();
		}
	}
}









