package model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Empleado {
	
	// Anotación de la librería json, para filtrar/volcar las palabras/claves de un json, 
	// para identificarla con la variable que queremos.
	
	@SerializedName(value="nombre")
	private String empleado;
	private String email;
	private double salario;
	private String departamento;
	
}
