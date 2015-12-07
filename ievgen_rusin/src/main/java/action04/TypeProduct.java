package action04;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum TypeProduct {
	Bread("BREAD!!"), Yogurt("Yog"), Milk("MILK!");
	
	private String descr;
	
	private TypeProduct(String descr) {
		this.descr = descr;
	}
	
	public String toString() {
		return descr;
	}
	// методы в классе Enum
	public static void main(String[] args) {
		TypeProduct obj = TypeProduct.Bread;
//		System.out.println(obj.toString());
		String str = obj.toString();
		TypeProduct obj1 = TypeProduct.valueOf(str);
		TypeProduct[] arr = TypeProduct.values();
		
		Map<Integer, String> map = new HashMap<>();
		map.put(10, "stroka1");
		map.put(20, "stroka2");
		
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		for(Map.Entry<Integer, String> entry: set) {
			System.out.println(entry.getValue() + "=" + entry.getKey());
		}
	}
	
}
