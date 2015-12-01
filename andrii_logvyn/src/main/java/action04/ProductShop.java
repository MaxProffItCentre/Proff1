package action04;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
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
		shop.printNameProductByParty(TypeProduct.Milk);
	}

	/*
	 * + 1) Вывести уникальный список фирм в алфавитном порядке + 2) Вывести
	 * уникальный список фирм в обратном порядке + 3) Вывести уникальные
	 * наименования товаров по типу продуктов + *
	 */
	public void printContructor() {
		TreeSet<String> treeSet = new TreeSet<String>();

		for (Entry<Product, String> entry : contructors.entrySet()) {
			treeSet.add(entry.getValue());
		}
		Iterator iter = treeSet.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	public void printReverseContructor() {
		System.out.println("\n Print Revese:");
		/*
		 * TreeSet<String> treeSet = new TreeSet<String>(new
		 * Comparator<String>() {
		 * 
		 * @Override public int compare(String o1, String o2) { return
		 * o2.compareTo(o1); } });
		 */
		TreeSet<String> treeSet = new TreeSet<String>((o1, o2) -> o2.compareTo(o1));

		for (Entry<Product, String> entry : contructors.entrySet()) {
			treeSet.add(entry.getValue());
		}
		Iterator iter = treeSet.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

	}

	public void printNameProductByParty(TypeProduct type) {

		System.out.println("\n Print products by Type:");

		TreeSet<String> treeSet = new TreeSet<String>();

		for (Entry<Product, String> prod : contructors.entrySet()) {
			if (prod.getKey().getType().equals(type)) {
				treeSet.add(prod.getKey().getName());
			}
		}

		if (treeSet.size() > 0) {
			Iterator iter = treeSet.iterator();
			while (iter.hasNext()) {
				System.out.println(iter.next());
			}
		} else {
			System.out.println("No found product for TypeProduct " + type.toString());
		}

	}
}
