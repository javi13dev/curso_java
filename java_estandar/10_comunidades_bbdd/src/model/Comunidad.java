package model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Comunidad {
	@SerializedName(value="CODAUTON")
	private int codigo;
	@SerializedName(value="COMUNIDAD_CIUDAD_AUTONOMA")
	private String nombre;
}
