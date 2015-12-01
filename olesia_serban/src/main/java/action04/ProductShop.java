package action04;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ProductShop {
	Map<Product, String> contructors = new HashMap<Product, String>();

	public ProductShop() {
		contructors.put(new Product("Bread White", TypeProduct.Bread, 10), "Firma 3");
		contructors.put(new Product("Super Yogurt", TypeProduct.Yogurt, 10), "Firma 3");

		contructors.put(new Product("Bread Grey", TypeProduct.Bread, 12), "Firma 3");
		contructors.put(new Product("Yogurt for Java Developers", TypeProduct.Yogurt, 12), "Firma 3");

		contructors.put(new Product("Milk with Shokolate", TypeProduct.Milk, 14), "Firma 1");
		contructors.put(new Product("Simple Yogurt", TypeProduct.Yogurt, 14), "Firma 1");
		contructors.put(new Product("Bread Grey", TypeProduct.Bread, 16), "Firma 1");
		contructors.put(new Product("Yogurt for Java Developers", TypeProduct.Yogurt, 16), "Firma 1");
		contructors.put(new Product("Milk with Shokolate", TypeProduct.Milk, 14), "Firma 1");
		contructors.put(new Product("Simple Yogurt", TypeProduct.Yogurt, 14), "Firma 1");
		contructors.put(new Product("Bread Grey", TypeProduct.Bread, 16), "Firma 1");
		contructors.put(new Product("Bread Grey", TypeProduct.Bread, 18), "Firma 1");

		contructors.put(new Product("Bread White", TypeProduct.Bread, 20), "Firma 2");
		contructors.put(new Product("Super Yogurt", TypeProduct.Yogurt, 20), "Firma 2");
		contructors.put(new Product("Bread Grey", TypeProduct.Bread, 20), "Firma 2");
		contructors.put(new Product("Yogurt for Java Developers", TypeProduct.Yogurt, 20), "Firma 2");

	}

	public static void main(String[] args) {
		ProductShop shop = new ProductShop();
		shop.printContructor();
		shop.printReverseContructor();
		shop.printNameProductByParty(TypeProduct.Yogurt);
	}

	/*
	 * 1) Вывести уникальный список фирм в алфавитном порядке 2) Вывести
	 * уникальный список фирм в обратном порядке 3) Вывести уникальные
	 * наименования товаров по типу продуктов
	 */
	public void printContructor() {
		Collection<String> firms = contructors.values();
		TreeSet<String> set = new TreeSet<>();
		set.addAll(firms);
		System.out.println(set);
	}

	public void printReverseContructor() {
		Collection<String> firms = contructors.values();
		TreeSet<String> set = new TreeSet<>();
		set.addAll(firms);
		System.out.println(set.descendingSet());
	}

	public void printNameProductByParty(TypeProduct type) {
		Set<Product> set = contructors.keySet();
		Set<String> set2 = new TreeSet <>();
		for(Product p: set){
			if(p.getType().equals(type)){
				set2.add(p.getName());
			}
		}
		System.out.println(set2);
	}
}
