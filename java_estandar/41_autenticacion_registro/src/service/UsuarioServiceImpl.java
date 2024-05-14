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
		/*
		if(userDao.findUsuario(usuario)!=null) {
			return false;
		}
		if(!password.equals(userDao.findUsuario(usuario).getPassword())) {
			return false;
		}
		return true;
		*/
		
		Usuario user = userDao.findUsuario(usuario);
		return user!=null&&user.getPassword().equals(password);
	
	}

	@Override
	public boolean saveUser(String usuario, String password, String email, int telefono) {
		
		if(userDao.findUsuario(usuario)!=null) {
			return false;
		}
		
		userDao.save(new Usuario(0,usuario, password,email,telefono));
		return true;
		
	}



}
