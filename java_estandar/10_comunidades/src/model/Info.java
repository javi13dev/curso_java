package model;

import java.util.stream.Stream;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Info {
	@SerializedName(value="provincias")
	private Provincia [] provincias;
}