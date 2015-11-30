package action04;

public class MainForMyHashMap {
	public static void main(String[] args) {
		MyHashMap karta = new MyHashMap();
		karta.put(new Party(31,"Ygotunsky"), new Product("Slivki",TypeProduct.Yogurt));
		karta.put(new Party(31,"Ygotunsky"), new Product("Slivki",TypeProduct.Yogurt));
		karta.put(new Party(3433,"Bereg"), new Product("Tvorog",TypeProduct.Yogurt));
		
		 Product prod =karta.get(new Party(31,"Ygotunsky"));
		System.out.println("REZULT"+prod.getName());
		
		System.out.println("Size = "+karta.size());
		karta.remove(new Party(31,"Ygotunsky"));
		System.out.println("Size = "+karta.size());
	}
}

