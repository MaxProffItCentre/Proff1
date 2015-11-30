package action04;

public class Links {
	
	
	private Nodu first;
	private Nodu last;
	
	
	public Nodu getFirst() {
		return first;
	}

	public void setFirst(Nodu first) {
		this.first = first;
	}

	public Nodu getLast() {
		return last;
	}

	public void setLast(Nodu last) {
		this.last = last;
	}
	
	public void addFront(Party key, Product product){       //вставляем в начало списка
		Nodu elem=new Nodu(key,product);
		if (first==null){
			first=elem;
			last=elem;
		} else {
			elem.next=first;
			first=elem;
		}
	}
	
	public Links() {
		
	}


	
	
	
	
	
}
