package action04;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum TypeProduct {
	
	Bread, Yogurt, Milk;
	
	public static void main(String[] args) {
		TypeProduct obj = TypeProduct.Bread;
//		System.out.println(obj.toString());
		String str = obj.toString(); 
		TypeProduct obj1 = TypeProduct.valueOf(str);
		TypeProduct[] arr = TypeProduct.values(); 
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(10, "sth");
		map.put(20, "ssd898");
		
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		for(Map.Entry<Integer, String> entry: set){
			System.out.println(entry.getKey() +"="+ entry.getValue());
			
		}
	}

}
