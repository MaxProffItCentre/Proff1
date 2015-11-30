package homework;

import action04.TypeProduct;

public class Product {
	private String name;
	private TypeProduct typeProduct;
	public Product(){}
	public Product(String name, TypeProduct typeProduct){
		this.name = name;
		this.typeProduct = typeProduct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TypeProduct getTypeProduct() {
		return typeProduct;
	}
	public void setTypeProduct(TypeProduct typeProduct) {
		this.typeProduct = typeProduct;
	}
	@Override
	public int hashCode(){
		return (name.hashCode() + typeProduct.hashCode());
	}
	@Override
	public String toString(){
		return ("Product name: " + name + ". Type: " + typeProduct.name());
	}
}
