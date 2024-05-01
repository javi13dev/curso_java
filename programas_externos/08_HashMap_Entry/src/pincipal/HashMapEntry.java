package pincipal;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapEntry {

	public static void main(String[] args) {
		// Usaré Entry para recorrerlo:
		
		HashMap<Integer, String> hs = new HashMap<>();
		
		hs.put(1, "Tontin");
		hs.put(2, "Kenke");
		hs.put(3, "Tina");
		
		for(Entry<Integer, String> entry : hs.entrySet()) {
			System.out.println( entry.getKey() + " " +entry.getValue());
		}

	}

}
