package dao;

import model.Usuario;

public interface UserDao {
	Usuario findUsuario(String usuario);
	void save(Usuario usuario);
}
