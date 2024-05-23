import java.io.Serializable;

public class testSerializable {

	public static void main(String[] args) {
		Serializable s = 20;
		
		System.out.println(s instanceof Number); // true
		System.out.println(s instanceof Integer); // true
		System.out.println(s instanceof String); // false

	}

}
