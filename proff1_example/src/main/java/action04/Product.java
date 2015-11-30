package action04;

public class Product{
	private String name;
	private TypeProduct type;
	private int party;
	
	public Product(String name, TypeProduct type, int party) {
		this.name = name;
		this.type = type;
		this.party = party;
	}
	@Override
	public String toString() {
		return name + " " + party;
	}
	@Override
	public int hashCode() {
		return party+name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (party != other.party)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	public TypeProduct getType() {
		return type;
	}
	public String getName() {
		return name;
	}	
}
