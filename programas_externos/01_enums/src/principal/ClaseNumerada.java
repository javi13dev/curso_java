package principal;

public enum ClaseNumerada {
	// ClaseEnumerada
	
	// Le damos un valor numérico, y hay que crear un constructor
	BAJO(0),MEDIO(1),ALTO(2);
	
	private int valor;
	
	ClaseNumerada(int i) {
		this.valor = i;
	}
	
	// Para poder coger el valor en otras clases, hacemos un get
	
	public int getValor() {
		return this.valor;
	}
}
