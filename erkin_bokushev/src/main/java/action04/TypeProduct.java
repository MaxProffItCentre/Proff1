package action04;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum TypeProduct {
	Bread, Yogurt, Milk; 
	public void main(String[] args) {
		TypeProduct obj = TypeProduct.Bread;
		String str = obj.toString();
		TypeProduct obj1 = TypeProduct.valueOf(str);
		TypeProduct[] arr = TypeProduct.values();
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(10, "Stroka1");
		map.put(20, "Stroka2");
		
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		for (Map.Entry<Integer, String> entry: set) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
}
