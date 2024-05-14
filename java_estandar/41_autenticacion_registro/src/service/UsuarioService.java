package service;

import model.Usuario;

public interface UsuarioService {
	boolean existeUsuario(String usuario, String password);
	boolean saveUser(String usuario, String password, String email, int telefono);
}
