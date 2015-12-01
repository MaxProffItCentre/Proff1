package MyHashMap;

import java.util.Objects;
import java.util.Scanner;

public class TestHashMap {

	public static void main(String[] args) {

		/*
		 * String key = "0"; int tmp; System.out.println(key.hashCode()); tmp =
		 * key.hashCode(); tmp = hash(tmp); tmp = indexFor(tmp,16);
		 * System.out.println(tmp);
		 */

		MyHashMap<Party, Product> map = new MyHashMap<Party, Product>();
		Product prod = new Product("Kefir", TypeProduct.MILK);
		Party party = new Party(10, "Billa");
		Product prod1 = new Product("Bulka", TypeProduct.BREAD);
		Party party1 = new Party(10, "Ashan");
		Party party2 = new Party(150, "Ashana");
		System.out.println(party.hashCode());
		map.put(party, prod);
		map.put(party, prod);
		map.put(party1, prod1);
		prod = map.get(party1);
		System.out.println(map.get(party));
		
//		Party p = new Party(987987,"OAYgotunsky");
//		String t = "OAOYgotunsky";
//		System.out.println(t.hashCode());

	}

	/*
	 * static final int hashCode(String key, String value) { return
	 * Objects.hashCode(key) ^ Objects.hashCode(value); }
	 */

	/*
	 * static int indexFor(int h, int length) { return h & (length - 1); }
	 * 
	 * static int hash(int h) { h ^= (h >>> 20) ^ (h >>> 12); return h ^ (h >>>
	 * 7) ^ (h >>> 4); }
	 */

	/*
	 * static final int hash(Object key) { int h; return (key == null) ? 0 : (h
	 * = key.hashCode()) ^ (h >>> 16); }
	 */

	// }
}
