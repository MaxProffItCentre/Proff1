package action04;

import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

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
Примечение: напоминаю, что карта состоит из массива, элементами которого являются односвязанные списки.*/

public class MyHashMap {
	private int capacity;
	private Node <Party, Product> table[];

	public MyHashMap(int capacity) {
		super();
		if (capacity > 16) {
			this.capacity = capacity;
		}
		if (capacity < 16) this.capacity = 16;
	}
	public MyHashMap () {
		this.capacity = 16;
	}
	
	static class Node <Party, Product>  {
		Party key;
		Product value;
		Node<Party, Product> next;
		
		public Node (Party key, Product val, Node<Party, Product> next) {
			this.key = key;
			this.value = val;
			this.next = next;
		}		
	}
	
	
	public Product get(Party key) {
		
		
		return null;
		
	}
	
	

}
	

