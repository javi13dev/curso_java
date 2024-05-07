package dao;



public class ComunidadesDaoFactory {
	// Finalidad: crear las instancias Dao, para uqe no las cree el service.
	// Nos dan implementaciones de las interfaces
	
	public static ComunidadesDao getComunidadesDao() {
		return new ComunidadesDaoImpl();
	}
	
	public static ProvinciasDao getProvinciasDao() {
		return new ProvinciasDaoImpl();
	}
	
	public static MunicipiosDao getMunicipiosDao() {
		return new MunicipiosDaoImpl();
	}
}
