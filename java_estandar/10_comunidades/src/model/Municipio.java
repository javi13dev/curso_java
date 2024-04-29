package model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
/**
 * Proyecto comunidades:

	Realizar una aplicación que muestre el nombre de cada comunidad autónoma, y para cada una
	mostrará sus provincias y dentro de esta, sus municipios.
	
	Datos:
	
	- Provincia:
		nombre
		int codigo
		CCAA
		
	- Municipio:
		nombre
		provincia
		poblacion
		
		
	Ej:
	
	Comunidad Madrid:
		Madrid:
			municipio 1
			municipio 2
			....
			
 */

public class Municipio {
	
	@SerializedName(value="NOMBRE")
	private String nombre;
	@SerializedName(value="NOMBRE_PROVINCIA")
	private String provincia;
	@SerializedName(value="POBLACION_MUNI")
	private int poblacion;

}
