package action04;

public class MyHashMap {
	private Links []table=new Links[16];
	private int capacity =16;
	
	
	boolean put(Party key, Product elem){
			System.out.println(key.hashCode());
				int hash=key.hashCode()%capacity;
				System.out.println(hash);
				return true;
//				if (table[hash]==null){table[hash].add(new Entry(hash,number,prod));
//				return true;}
//				if (map[hash].contains(new Entry(hash,number,prod)))
//				return false;
//				else map[hash].add(new Entry(hash,number,prod));
//				return true;
//			}
		
	}
	
	
	public MyHashMap() {
		super();
	}


	
	
	
	
	
}
