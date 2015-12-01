package action04;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum TypeProduct {
	Bread, Yogurt, Milk;
	
	public static void main(String[] args) {
		TypeProduct obj = TypeProduct.Bread;
		System.out.println(obj.toString());
		TypeProduct.valueOf(obj.toString());
		TypeProduct[] arr = TypeProduct.values();
		
		Map <Integer, String> map = new HashMap <>();
		map.put(10, "sth");
		map.put(20, "sth2");
		
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		for (Map.Entry<Integer, String> entry: set){
			System.out.println(entry);
		}
}
	
}
