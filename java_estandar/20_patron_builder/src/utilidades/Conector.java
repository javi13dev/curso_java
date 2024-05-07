package utilidades;

public class Conector {
	private String modo;
	private int tipo;
	private String dir;
	private boolean estado;
	private String protocolo;
	
	// habrá unos métodos.
	
	// finalidad, quien use la clase, pueda crear objetos de forma felxible,
	// utilizando una o varias propiedades a su discreción.
	
	// Usaremos patrón builder:
	
	// 1) se establecen los setters y getters
	
	public String getModo() {
		return modo;
	}
	public void setModo(String modo) {
		this.modo = modo;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getProtocolo() {
		return protocolo;
	}
	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}
	
	// 2) pasa usarlo, creamos la clase ConectorBuilder
	
	public static class ConectorBuilder {
		// Va a tener una propiedad objeto Conector:
		Conector conector;
		public ConectorBuilder() {
			conector = new Conector();
		}
		
		// Y se establecen métodos, normalmente uno para cada propiedad.
		public ConectorBuilder modo(String modo) {
			conector.setModo(modo);
			return this; // retorna el propio ConectorBuilder
		}
		
		public ConectorBuilder tipo(int tipo) {
			if(tipo < 0) {
				tipo = 0;
			}
			conector.setTipo(tipo);
			return this;
		}
		
		public ConectorBuilder dir(String dir) {
			conector.setDir(dir);
			return this;
		}
		
		public ConectorBuilder estado(boolean estado) {
			conector.setEstado(estado);
			return this;
		}
		
		public ConectorBuilder protocolo(String protocolo) {
			conector.setProtocolo(protocolo);
			return this;
		}
		
		// Y faltaria un último método que devuelve el objeto conector construido:
		// se suele llamar builder();
		public Conector build() {
			return conector;
		}
		
	}
}
