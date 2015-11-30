package action04;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum TypeProduct {
	Bread, Yogurt, Milk;
	public static void main(String[] args) {
		TypeProduct obj = TypeProduct.Bread;
		String str = obj.toString();
		System.out.println(obj.toString());
		TypeProduct objl = TypeProduct.valueOf(str);
		TypeProduct [] arr = TypeProduct.values();
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(10, "Str 1");
		map.put(20, "Str 2");
		
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		for(Map.Entry<Integer, String> entry: set){
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
}
