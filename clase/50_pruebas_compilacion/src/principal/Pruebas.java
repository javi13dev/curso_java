package principal;

public class Pruebas {

	public static void main(String[] args) {
		// Ejemplos sobre compilación, 
		// En una parte del código, ejecutándose en orden, puede haber momentos de compilación, y posteriores errores.
		
		int b='f'; // Sí, se compila sin problema, conversión implícita, un char en un int
		// 2-int a=3.4f; // No
		char d=(char)5.7; // Sí, salvo el boolean puede hacerse cast explícita. Otra cosa es el caracter que se guarda.
		// 4-int a=3;byte c=a; // No, no se puede implícitamente, al ser el casteo un tamaño menor. Con un casteo explícito, todo es posible.
		// boolean r = false; int g = (int)r; // No, no puede usarse el casting si hay un boolean.
		
		
		// String s == "44";
		// int x = (int) s; // No puede convertirse un objeto en primitivo. Excepto las de envoltorio autoboxing que vimos, 
		// como Integer, ej:
		Integer x = 300; // Siendo esto autoboxing
		int a = x; // sí se puede, siendo este momento un unboxing
		
		
		// Compila? 
		/**
		 * 
		int a=20;
		int s=sc.nextInt();
		final int c=8;
		switch(s){ // Lo que le pasamos a evaluar debe ser un int o según ejemplos un string
			case 5:
				
			case '#':
				
			case "hello": // No, el string no al ser objeto
				
			case a: // No, no se puede poner variable en el case, solo literales conocidos por el compilador
				
			case c: // una constante sí puede ponerse. Porque no se puede modificar.
				
			
		} 
		 */
		
		// Error de compilación, porque tiene que devolver algo con el switch en expresiones, falta el default
		/**
		 * int a=20;
			int s=sc.nextInt(); //se introduce un 5
			final int c=8;
			String res=switch(s){
				case 5->"hola";
				case '#'->"adios";
				case c->"hasta mañana";
			}
			System.out.println(res); 
		 */
		
		
		// Error, generará un error(NubmerFormatException), por tanto, opción 1, volcado de error
		/**
		try{
			int a=Integer.parseInt(sc.nextLine());
		}catch(NullPointerException ex){
			print("Error");
		}
		
		suponiendo que se introuce una letra:
		1.-volcado de error
		2.-Se imprime error
		3.-No se muestra nada
		4.-Error de compilación 
		
		
		Se podria controlar ese error:
		try{
			int a=Integer.parseInt(sc.nextLine());
		}catch(NullPointerException ex){
			print("Error");
		}catch(NumberFormatException ex){
			print("otro error");
		}
		
		suponiendo que se introuce una letra:
		1.-volcado de error
		2.-Se imprime error
		3.-No se muestra nada
		4.-Error de compilación 
		5.-Imprime otro error  // Se imprime porque se ha controlado este error
		
		*/
		
		
		
		
		/**
		 *  a. LocalDate l1=LocalDate.of(2010,13,20);
			b. LocalDate l2=LocalDate.now();
			c. LocalDateTime ld3=LocalDateTime.of(LocalDate.now(),LocalTime.now());
			d. LocalTime lt4=LocalTime.of(20,80,20);
			e. LocaDate l5=new LocalDate();
			f. LocalDate l6=LocalDate.now().of(3000,10,10);
			
			¿Cuales compilan?
			a, compila, aunque dará un error de datetime porque el mes 13 no existe 
			e, no compila, no puede hacerse un constructor y hacer new
			f, los métodos estáticos se aplican sobre clases y objetos, asique es posible la compilación.
			
			a,b,c,d,f
			
			¿Cuáles ejecutan sin error?
			b,c,f
		 * 
		 */
		
		
		/**
		 * 
		 String a = "hello";
		 a.replace("h", "p");
		 System.Out.Println(a);
		 // imprime hello porque el String a es inmutable, el replace genera otro String.
		 */
		
		/**
		 * 	String a=new String("hola");
			String b=new String("hola");
			String c=new String("Hola");
			String d=a;
			
			System.out.println(a==b);  // false
			System.out.println(a.equals(c));  // false
			System.out.println(a==d); // true, apuntan al mismo objeto
			System.out.println(d==c); // false
		 */
		
		
		
		// ********************************* Arrays
		
		/**
		 * 	int[] m=new int[5];
			int[] z=m;
			z[0]=10;
			System.out.println(m[0]);
			
			// imprime 10, ya que apuntan z al mismo objeto m
			// A diferencia de la variables primitivas , si las igualara y cambian, serían independientes
			// Ej:
			 * 
			 * int a = 20;
			 * int b=a;
			 * b++;
			 * System.out.println(a); // 20
		 */
		
		
		
		
		/**
		 * main(){
			int x=10;
			int y=3;
			sumar(x,y);
			print(x);
		}
		
		void sumar(int a, int b){
			a=a+b;
		} 
		
		// x seguiría siendo 10
		// a seria 13
		*/
		
		/**
			main(){
				Integer x=10;
				Integer y=3;
				sumar(x,y);
				print(x);
			}
			
			void sumar(Integer a, Integer b){
				a=a+b;
			} 
			
			// x seguiría siendo 10
			// a al entrar como parámetro apunta a 10, pero al sumarle b seria 13 pero siendo un nuevo objeto.
		 */
		
		
		
		// *******************************************************************
		// *******************************************************************
		// *******************************************************************
		// *******************************************************************
		
		/**
		Given:
		class Test{
			var datas=new ArrayList<Integer>();
			public void print(){
				System.out.println(datas.get(0));
			}
		}
		
		Test t=new Test();
		t.print();
		
		
		a.) 0
		b.) null
		c.) error de compilación
		d.) excepción NullPointerException 
		
		// Seria error de compilacion porque var, no puede ser atributo de clase, solo puede usarse como variables locales.
		  
		  
		  
		 Given:
		class Test{
			ArrayList<Integer> datas=new ArrayList<Integer>();
			public void print(){
				System.out.println(datas.get(0));
			}
		}
		
		Test t=new Test();
		t.print();
		
		
		a.) 0
		b.) null
		c.) error de compilación
		d.) excepción NullPointerException 
		e.) excepción IndexOutOfBoundException
		
		
		// No puede ser NullPointerException, porque no es null el objeto, sí sería indexOutOfBoundException

		 */
		
		
		
		
		
		
	}
}


