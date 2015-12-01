package MyHashMap;

import java.util.Objects;

public class MyHashMap <K, V>{
	private Node<K,V>[] table = new Node[16];
	private int size = 0;
	public MyHashMap(){
		
	}
	
	public void put(K key, V elem){
		int hash = key.hashCode();
		int pozition = indexFor(hash(hash), table.length);
		Node<K, V> tmpNode = new Node(hash, key, elem, null);
		Node<K, V> first, next, e;
		if(table[pozition] == null){
			table[pozition] = tmpNode;
			++size;
		}else{
			first = table[pozition];
			if((next = first.nextNode) != null){
				while(next.nextNode != null){
					if(next.hash == tmpNode.hash){
						next.setValue(elem);
						break;
					}
					
					next = next.nextNode;
				}
				if(next.hash == tmpNode.hash){
					next.setValue(elem);
				}else {next.nextNode = tmpNode; ++size;}
			}else{
				if(first.hash == tmpNode.hash){
					first.setValue(elem);
				}else{
					first.nextNode = tmpNode;
				}
			}
		}
		//table[pozition] = tmpNode;
	}
	
	public V get(K key){
		int pozition = indexFor(hash(key.hashCode()), table.length);
		Node fNode = table[pozition], next;
		next = fNode;
		if(fNode == null){ return null;}
		while(next.nextNode != null){
			next = next.nextNode;
		}
		return (V) next.getValue();
		
	}
	
	public int size(){
		return size;
	}
	public int hash(int h)
	{
	    h ^= (h >>> 20) ^ (h >>> 12);
	    return h ^ (h >>> 7) ^ (h >>> 4);
	}
	
	public int indexFor(int h, int length) {
		return h & (length - 1);
	}
	
}

class Node<K,V>{
	final K key;
	final int hash;
	V value;
	Node<K,V> nextNode;
	
	public Node(int hash, K key, V value, Node<K,V> next){
		this.hash = hash;
		this.key = key;
		this.value = value;
		this.nextNode = next;
	}
	
	public final K getKey()        { return key; }
    public final V getValue()      { return value; }
    public final String toString() { return key + "=" + value; }

    public final int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }

    public final V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

}
/*Задача 3. Хэш карта
Написать собственную реализацию "Хэш карты", построенную на паре значений<Партия,Продукт>.
Написать для для этого классы:
 - класс Продукт(с полями String name и TypeProduct type)
 - класс Партия(с полями int number и String contructor(поставщик))

Реализовать методы:

1. boolean put(Party key, Product elem)
2. Product get(Party key)
3. int size()
4. boolean remove(Party key)
5. Iterator<Product> iterator()

Наименование класса может звучать так: MyHashMap, при этом нельзя использовать HashMap.
Примечение: напоминаю, что карта состоит из массива, элементами которого являются односвязанные списки.
*/