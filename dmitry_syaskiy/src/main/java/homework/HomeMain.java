package homework;

import action04.TypeProduct;

public class HomeMain {
	public static void main(String[] args){
		MyHashMap myMap = new MyHashMap();
		System.out.println(myMap.put(new Consignment(1, "Danone"), new Product("Super Yogurt", TypeProduct.Yogurt)));
		System.out.println(myMap.put(new Consignment(1, "Danone"), new Product("Super Yogurt", TypeProduct.Yogurt)));
		System.out.println(myMap.put(new Consignment(2, "Danone"), new Product("Super Yogurt", TypeProduct.Yogurt)));
		System.out.println(myMap.get(new Consignment(2, "Danone")).toString());
		System.out.println(myMap.size());
		System.out.println(myMap.remove(new Consignment(1, "Danone")));
		System.out.println(myMap.remove(new Consignment(3, "Danone")));
	}
}
