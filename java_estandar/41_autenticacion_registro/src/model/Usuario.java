package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Usuario {
	
	private int idCliente;
	private String usuario;
	private String password;
	private String email;
	private int telefono;


}
