package homework;

public class Entry{
	private Consignment consignment;
	private Product product;
	
	public Entry(Consignment consignment, Product product){
		this.consignment = consignment;
		this.product = product;
	}
	public Consignment getConsignment() {
		return consignment;
	}
	public void setConsignment(Consignment consignment) {
		this.consignment = consignment;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public int hashCode(){
		return consignment.hashCode() + product.hashCode();
	}
	@Override
	public boolean equals(Object entry){
		if(entry == null) return false;
		if(entry.getClass() != Entry.class) return false;
		Entry other = (Entry)entry;
		return this.hashCode() == other.hashCode();
	}
}
