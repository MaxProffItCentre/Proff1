package action04;

public class MainForMyHashMap {
	public static void main(String[] args) {
		MyHashMap karta = new MyHashMap();
		karta.put(new Party(3,"OAO otunsky"), new Product("Kolba",TypeProduct.Yogurt));
		karta.put(new Party(3433,"OAO Gotunsky"), new Product("Kolbass",TypeProduct.Yogurt));
		
	}
}
