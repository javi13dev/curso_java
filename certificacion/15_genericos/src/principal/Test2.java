package principal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

class A{
	public List<Serializable> get(Set<? extends Number> lst){return null;}
}
class B extends A{
	//Aquí
}
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}

A. public ArrayList<Serializable> get(Set<? extends Number> lst){return null;} // Si, sobreescritura. El tipo de devolución es un subtipo.
B. public ArrayList<Serializable> get(List<? extends Number> lst){return null;} // Si
C. public List<String> get(Set<? extends Number> lst){return null;} // No es sobreescritura válida.
D. public List<Serializable> get(Set<Number> lst){return null;} // No compila. 
E. public ArrayList<Serializable> get(HashSet<? extends Number> lst){return null;} // Si, no hay sobreescritura, valoramos la sobrecarga, que es válida.
F. public Vector<Serializable> get(Set<? super Number> lst){return null;} // No compila