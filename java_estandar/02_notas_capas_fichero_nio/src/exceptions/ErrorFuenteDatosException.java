package exceptions;

public class ErrorFuenteDatosException extends RuntimeException{
	// Al heredar de Runtime no obligamos a la capa de presentación a capturarlas.
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "No se ha podido acceder al fichero.";
	}
	
}
