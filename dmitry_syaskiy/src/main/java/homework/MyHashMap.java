package homework;

public class MyHashMap {
	
	ListEntries[] table;
	int arraySize;
	public MyHashMap(){
		table = new ListEntries[16];
		arraySize = 0;
	}
	public MyHashMap(int capacity){
		table = new ListEntries[capacity];
		arraySize = 0;
	}
	public boolean put(Consignment key, Product element){
		
		if(key == null){
			return putForNullKey(element);
		}
		return addEntry(key, element, indexFor(hash(key.hashCode()),table.length));
	}
	public boolean putForNullKey(Product element){
		return true;
	}
	public int hash(int hashCode){
		hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
	    return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 4);
	}
	public int indexFor(int hashCode, int length){
		return hashCode & (length - 1);
	}
	public boolean addEntry(Consignment key, Product element, int index){
		Entry entry = new Entry(key, element);
		if(table[index] == null){
			table[index] = new ListEntries();
			table[index].addFront(entry);
			arraySize++;
			if(arraySize == table.length){
				resize(table.length*2);
			}
			return true;
		}else{
			if(table[index].checkEntry(entry)){
				table[index].addFront(entry);
				return true;
			}
		}
		return false;
	}
	public Product get(Consignment key){
		if(key == null){
			return null;
		}
		return getEntry(key, indexFor(hash(key.hashCode()),table.length)).getProduct();
	}
	public Entry getEntry(Consignment key, int index){
		if(table[index] != null){
			return table[index].getEntry(key);
		}
		return null;
	}
	public int size(){
		int size = 0;
		for(int i = 0; i <table.length; i++){
			if(table[i] != null)
			{
				size += table[i].getListSize();
			}
		}
		return size;
	}
	public boolean remove(Consignment key){
		if(key==null){
			return false;
		}
		int index = indexFor(hash(key.hashCode()),table.length);
		Entry entry = getEntry(key, index);
		if(entry != null){
			return table[index].deleteElement(entry);
		}
		return false;
	}
	public void resize(int newSize){
		ListEntries[] newTable = new ListEntries[newSize];
		transfer(newTable);
		table = newTable;
	}
	public void transfer(ListEntries[] newTable){
		
	}
//	public Iterator<Product> iterator(){
//		
//	}
}
