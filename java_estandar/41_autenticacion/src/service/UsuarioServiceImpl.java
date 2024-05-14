package service;

import dao.UserDao;
import dao.UserDaoFactory;
import model.Usuario;

public class UsuarioServiceImpl implements UsuarioService {
	
	UserDao userDao;
	
	// Teniendo ya ComunidadesDaoFactory:
	public UsuarioServiceImpl() {
		userDao = UserDaoFactory.getUserDao();
	}
	
	public boolean existeUsuario(String usuario, String password) {
		if(userDao.findUsuario(usuario)!=null) {
			return false;
		}
		if(!password.equals(userDao.findUsuario(usuario).getPassword())) {
			return false;
		}
		return true;
		
		// Usuario usuario = userDao.findUsuario(usuario);
		// return usuario!=null&&usuario.getPassword().equals(password);
	
	}



}
