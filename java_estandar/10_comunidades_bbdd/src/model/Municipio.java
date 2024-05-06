package model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Municipio {
	
	// municipios(cod, nombre, superficie, poblacion, altura, codprovincia)
	
	@SerializedName(value="COD_GEO")
	private int codigo;
	@SerializedName(value="NOMBRE")
	private String nombre;
	@SerializedName(value="SUPERFICIE")
	private double superficie;
	@SerializedName(value="POBLACION_MUNI")
	private int poblacion;
	@SerializedName(value="ALTITUD")
	private int altura;
	@SerializedName(value="NOMBRE_PROVINCIA")
	private String provincia;

}
