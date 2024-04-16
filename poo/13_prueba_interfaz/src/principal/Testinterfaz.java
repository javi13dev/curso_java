package principal;

import java.util.List;

public class Testinterfaz {

	public static void main(String[] args) {
		// Al ser métodos static, puedo llamarlos directamente desde la interfaz
		
		//List<Integer>  nums = MiInterfaz.ofPares(20,30,15,7,40);
		System.out.println(MiInterfaz.ofPares(7));
		List<Integer>  nums = MiInterfaz.ofPares(7);
		for(Integer n:nums) {
			System.out.println(n);
		}
		
		
		List<Integer>  nums2 = MiInterfaz.ofPositivos(20,-4,15,-1,40);
		for(Integer n:nums2) {
			System.out.println(n);
		}
	}
}
