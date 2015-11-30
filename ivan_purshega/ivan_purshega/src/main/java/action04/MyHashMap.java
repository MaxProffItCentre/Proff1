package action04;

public class MyHashMap {
	
	private Links []table=new Links[16];
	private int capacity =16;

	
	
	public int size(){
		int size=0;
		for(int i=0; i<capacity;i++){
			if(table[i]==null){}
			else {Nodu pervui=table[i].getFirst();
			while (pervui!=null){
				size++;
				pervui=pervui.next;}
			}
		} return size;
	}
	
	boolean put(Party key, Product product){
			System.out.println(key.hashCode());
				int hash=key.hashCode()%capacity;
				System.out.println(hash);
				if (table[hash]==null){
					table[hash]=new Links();
					table[hash].addFront(key,product);
				return true;
				} else if(table[hash]!=null){
					Nodu pervui=table[hash].getFirst();
					while (pervui!=null){
						if (product.equals(pervui.getProduct()))return false;
							pervui=pervui.next;
					} 
				}
				else {
					System.out.println("Добавляем уже существующий Список");
					table[hash].addFront(key,product);
					return true;
				} return true;

		
	}
	
	public boolean remove(Party key){
		for(int i=0; i<capacity;i++){
			if(table[i]==null){}
			else {
				Nodu pervui=table[i].getFirst();
				while (pervui!=null){
				System.out.println(pervui.getProduct().getName());
				if(pervui.getHash()==key.hashCode()){
					if (pervui.next==null && pervui==table[i].getFirst()) {     
			            table[i].setFirst(null);        
			            table[i].setLast(null);
			            return true;            
			        } else if (pervui==table[i].getFirst() && pervui.next!=null) {   
			            pervui=pervui.next;       
			            return true;                 
			        } else if(pervui!=table[i].getFirst() && pervui!=table[i].getLast()){
			        	pervui=pervui.next; return true;
			    } else if(pervui==table[i].getLast()){
			    	pervui=null;
					}
					else pervui=pervui.next.next;	return true;
				} pervui=pervui.next;
				}
			}
		} return false;
	}
	
	public Product get(Party party){
		for(int i=0; i<capacity;i++){
			if(table[i]==null){}
			else {
				Nodu pervui=table[i].getFirst();
				while (pervui!=null){
				System.out.println(pervui.getProduct().getName());
//				System.out.println("hash 4to prishel =" kod.);
				if(pervui.getHash()==party.hashCode()){
					return pervui.getProduct();	
				}
				pervui=pervui.next;
			}	 
		}
		} return null;
	} 

	
	public MyHashMap() {
		super();
	}

}
