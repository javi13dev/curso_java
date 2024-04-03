package service;

import java.util.Collection;
import java.util.HashMap;

public class EmpleadosService {
	
	HashMap<Integer,String> empleados=new HashMap<Integer, String>();
	
	public boolean agregarEmpleado(int codigo, String nombre) {
		if(!empleados.containsKey(codigo)) {
			empleados.put(codigo, nombre);
			return true;
		}
		return false;
	}
	
	public String buscarEmpleado(int codigo) {
		return empleados.get(codigo);
	}
	
	public String eliminarEmpleado(int codigo) {
		return empleados.remove(codigo);
	}
	
	public String[] todosEmpleados() {
		Collection<String> todos = empleados.values();
		// Le damos un array vacio y lo redimensiona con el tamaño adecuado
		return todos.toArray(new String[0]);
	}
}
