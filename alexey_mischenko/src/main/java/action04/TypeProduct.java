package action04;

public enum TypeProduct {
	Bread, Yoqurt, Milk;
	
	public static void main(String[] args){
		
		TypeProduct obj = TypeProduct.Bread;
		String str = obj.toString();
		System.out.println(str);
		
		TypeProduct obj1 = TypeProduct.valueOf(str);
		TypeProduct obj2 = obj1;
		TypeProduct [] arr = TypeProduct.values();
		System.out.println(obj2);
		
	}
}
