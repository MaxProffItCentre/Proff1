package myHashMap;

public class Product {
	private String name;
	private TypeProduct typeProduct;

	public Product(String name, TypeProduct typeProduct) {
		this.name = name;
		this.typeProduct = typeProduct;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("name is ");
		sb.append(name).append(", type is ").append(typeProduct);
		return sb.toString();
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((typeProduct == null) ? 0 : typeProduct.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (typeProduct != other.typeProduct)
			return false;
		return true;
	}

}
