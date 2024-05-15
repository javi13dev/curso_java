package model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Municipio {
	@SerializedName("NOMBRE")
	private String nombreMunicipio;
	@SerializedName("POBLACION_MUNI")
	private int poblacion;
	@SerializedName("ALTITUD")
	private int altitud;
	@SerializedName("SUPERFICIE")
	private double superficie;
}
