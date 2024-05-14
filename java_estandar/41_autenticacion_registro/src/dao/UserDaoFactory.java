package dao;

public class UserDaoFactory {
	public static UserDao getUserDao() {
		return new UserDaoImpl();
	}
}
