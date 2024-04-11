package service;

public class Punto3D extends Punto{
	private int z;
	public Punto3D(int z) {
		this.z=z;
	}
	
	public Punto3D(int x, int y, int z) {
		super(x,y);
		this.z=z;
	}
	
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}

	// para sobreescribir métodos, en source>override/implementsmethods
	@Override
	public void imprimir() {
		
		// Llamada a super porque primero llama al método del padre si es nbecesario y después lo modificamos/añadimos
		super.imprimir();
		System.out.println(","+z);
	}
}


