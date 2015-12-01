package myHashMap;

import java.util.Iterator;

public class MyHashMain {
	public static void main(String[] args) {
		
		MyHashMap<String, Integer> map1 = new MyHashMap<>();
//		map1.put(new Product("Bread White", TypeProduct.Bread), new Party(20, "Ukraine"));
//		map1.put(new Product("Mandarines", TypeProduct.Mandarine), new Party(11, "Spain"));
//		map1.put(new Product("Milk", TypeProduct.Milk), new Party(15, "Ukraine"));
//		map1.put(new Product("Honey", TypeProduct.Honey), new Party(57, "Ukraine"));
//		map1.put(new Product("Mandarines from Turkey", TypeProduct.Mandarine), new Party(10, "Turkey"));
//		map1.put(new Product("Bread Black", TypeProduct.Bread), new Party(86, "Ukraine"));
//		map1.put(new Product("Bread White", TypeProduct.Bread), new Party(21, "Ukraine"));
		
		map1.put("sth", 2);
		map1.put("sth", 3);
		map1.put("sb", 3);
		map1.put("sb", 2);

		
		
		System.out.println(map1) ;
		Iterator<String> iter = map1.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
//	
	
}
