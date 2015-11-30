package action04;

public class Nodu  {
	Nodu next;
	private Product product;
	private Party party;
	private int hash;
	
	
	public Nodu(Party party,Product product) {
		super();
		this.product = product;
		this.party = party;
		hash=this.party.hashCode();
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Party getParty() {
		return party;
	}


	public void setParty(Party party) {
		this.party = party;
	}
	

	
	public int getHash(){
		return hash;
	}
	
	
//	 @Override
//	  public int compareTo(Object compNode) {
//	   Nodu node = (Nodu) compNode;
//	   return this.data - node.data;
//	  }
	 
}
