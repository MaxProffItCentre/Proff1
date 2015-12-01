package action04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class ProductShop {
	Map<Product,String> contructors = new HashMap<Product,String>();
	public ProductShop(){
		contructors.put(new Product("Bread White",TypeProduct.Bread, 10),"Firma 3");
		contructors.put(new Product("Super Yogurt",TypeProduct.Yogurt, 10),"Firma 3");
		
		contructors.put(new Product("Bread Grey",TypeProduct.Bread, 12),"Firma 3");
		contructors.put(new Product("Yogurt for Java Developers",TypeProduct.Yogurt, 12),"Firma 3");
		
		contructors.put(new Product("Milk with Shokolate",TypeProduct.Milk, 14),"Firma 1");
		contructors.put(new Product("Simple Yogurt",TypeProduct.Yogurt, 14),"Firma 1");
		contructors.put(new Product("Bread Grey",TypeProduct.Bread, 16),"Firma 1");
		contructors.put(new Product("Yogurt for Java Developers",TypeProduct.Yogurt, 16),"Firma 1");
		contructors.put(new Product("Milk with Shokolate",TypeProduct.Milk, 14),"Firma 1");
		contructors.put(new Product("Simple Yogurt",TypeProduct.Yogurt, 14),"Firma 1");
		contructors.put(new Product("Bread Grey",TypeProduct.Bread, 16),"Firma 1");
		contructors.put(new Product("Bread Grey",TypeProduct.Bread, 18),"Firma 1");

		contructors.put(new Product("Bread White",TypeProduct.Bread, 20),"Firma 2");
		contructors.put(new Product("Super Yogurt",TypeProduct.Yogurt, 20),"Firma 2");
		contructors.put(new Product("Bread Grey",TypeProduct.Bread, 20),"Firma 2");
		contructors.put(new Product("Yogurt for Java Developers",TypeProduct.Yogurt, 20),"Firma 2");
		
	}
	public static void main(String[] args) {
		ProductShop shop = new ProductShop();
		shop.printContructor();
		shop.printReverseContructor();
		shop.printNameProductByParty(TypeProduct.Yogurt);
	}
	public void printContructor(){
		Set<Map.Entry<Product,String>> set = contructors.entrySet();
		List<String> firmsList = new ArrayList<>();
		for(Map.Entry<Product,String> entery: set){
			firmsList.add(entery.getValue());
		}
		Set<String> firms = new TreeSet<String>(firmsList);
		System.out.println(firms);
	}
	public void printReverseContructor(){
		Set<Map.Entry<Product, String>> set = contructors.entrySet();
		Set <String> uniqNames = new TreeSet<String>(new Comparator<String>(){
			@Override public int compare(String e1, String e2) {
				return e2.compareTo(e1);
            }
		});
		for (Map.Entry<Product, String> entry: set) {
			uniqNames.add(entry.getValue());
		}
		System.out.println(uniqNames);
	}
	public void printNameProductByParty(TypeProduct type){
		Set<Map.Entry<Product, String>> set = contructors.entrySet();
		Set<String> uniqNames = new TreeSet<>();
		for (Map.Entry<Product, String> entry: set) {
			if (entry.getKey().getType().equals(type)) {
				uniqNames.add(entry.getKey().getName());
			}
		}
		System.out.println(uniqNames);
	}
}

