package service;

public class view {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var s1 = SingletonService.getInstance();
		var s2 = SingletonService.getInstance();
		// Ambas variables apuntan al mismo objeto:
		System.out.println(s1==s2);
	}

}
