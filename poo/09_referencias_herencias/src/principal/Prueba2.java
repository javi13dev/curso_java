package principal;

public class Prueba2 {
	
	public static void main(String [] args) {
		Object ob = "hello";
		String s = (String)ob; // Conversión explícita de la superclase en una subclase. 
		// Sólo cuando hay relación de herencia.
		
		
		/**
		 * 
			String s = "100";
			Integer r = (Integer) s;
			System.out.println(r);
			
			Error de compilación, no hay relación de herencia entre String e Integer
		 */
		
		/**
		 * 
			Object s = "100";
			Integer r = (Integer) s;
			System.out.println(r);
			
			Excepción: ClassCastException
			
			Hay relación de herencia.
			No es error de compilación, pero la exception surge en la ejecución.
		 */
		
		/**
		 * 
			Number s = 4.5;
			Integer r = (Integer) s;
			System.out.println(r);
			
			Excepción: ClassCastException
			
			Hay relación de herencia.
			No es error de compilación, pero la exception surge en la ejecución.
		 */
		
		
		/**
		 * 
		 * 
		 *  class C1{
	
			}
			
			class C2 extends C1{
				
			}
			class C3 extends C2{
				
			}
			C1 c = new C3();
			C2 x = (C3)c;
			
			Sí es posible porque C2 es superclase de C3
			
		 */
		
		
		/**
		 * 
		 Object ob = 100;
		 Number n = (Integer)ob;
		 
		 Sí es posible
		 
		 
		 Object ob = 100;
		 Number n = (Object)ob;
		 
		 Error de compilación, no se puede castear de hijo a padre.
		 
		 Object ob = 100;
		 Number n = (Integer) ((Object)ob);
		 
		 Sí es válido.
		 */
	}
}
