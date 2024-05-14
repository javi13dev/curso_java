package service;

import model.Usuario;

public interface UsuarioService {
	boolean existeUsuario(String usuario, String password);
}
