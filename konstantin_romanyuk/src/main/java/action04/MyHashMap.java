package action04;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



public class MyHashMap{ //extends AbstractMap<Party,Product1> implements Map<Party,Product1>{
private int capacity=16;
private EntryList[] map; 	
	public MyHashMap(){
	map=new EntryList[16];
       }
public static void main(String[] args) {
	MyHashMap hMap=new MyHashMap();
	hMap.put(new Party(1,"f"), new Product1("cheese", TypeProduct.Bread) );
	hMap.put(new Party(2,"f"), new Product1("kovbaza", TypeProduct.Bread) );
	hMap.put(new Party(3,"f"), new Product1("caviar", TypeProduct.Bread) );
	System.out.println(hMap.get(new Party(1,"f")));
}
public boolean put(Party number, Product1 prod){
	int hash=number.hashCode()%capacity;
	if (map[hash]==null){map[hash].add(new Entry(hash,number,prod));
	return true;}
	if (map[hash].contains(new Entry(hash,number,prod)))
	return false;
	else map[hash].add(new Entry(hash,number,prod));
	return true;
}
public Product1 get(Party part){
	Product1 result=null;
	int hash=part.hashCode()%capacity;
	Iterator<Entry> iter1=map[hash].iterator();
	Iterator<Entry> iter2=map[hash].iterator();
	while (iter1.hasNext() && iter2.hasNext())
	{if(iter2.next().party.equals(part))
		result=iter1.next().prod;
		}		
		return result;
}
	class Entry{
		Party party;
		Product1 prod;
		Entry next;
		int hash;
		Entry(int hash, Party party, Product1 prod, Entry next){
			this.hash=hash;
			this.party=party;
			this.prod=prod;
			this.next=next;
		}
		Entry(int hash, Party party, Product1 prod){
				this.hash=hash;
				this.party=party;
				this.prod=prod;
				}
	}
		
	class EntryList extends LinkedList<Entry>{

		
		private static final long serialVersionUID = 1L;
		List<Entry> list;
	public EntryList(){
			list=new LinkedList<Entry>();
		}
		}
	
	
}		
	
	


	/*static class Entry<Party,Product1> implements Map.Entry<Party,Product1> {
        final int hash;
        final Party key;
        Product1 value;
        Entry<Party,Product1> next;

       Entry(int hash, Party key, Product1 value, Entry<Party,Product1>  next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final Party getKey()        { return key; }
        public final Product1 getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

		@Override
		public Product1 setValue(Product1 newvalue) {
			Product1 oldValue = value;
            value = newvalue;
            return oldValue;
			return null;
		}
	
	}
	@Override
	public Set<java.util.Map.Entry<action04.Party, action04.Product1>> entrySet() {
		  Set<Map.Entry<Party,Product1>> es;
	        return (es = entrySet) == null ? (entrySet = new EntrySet()) : es;
		
	}}*/
/*[25.11.2015 21:47:59] Кузменюк Максим: Коллеги, в качестве домашнего задания было закончить задания в классе и даю задачу 3.
[25.11.2015 21:48:00] Кузменюк Максим: Задача 3. Хэш карта
Написать собственную реализацию "Хэш карты", построенную на паре значений<Партия,Продукт>.
Написать для для этого классы:
 - класс Продукт(с полями String name и TypeProduct type)
 - класс Партия(с полями int number и String contructor(поставщик))

Реализовать методы:

1. boolean put(Party key, Product elem)
2. User get(Party key)
3. int size()
4. boolean remove(Party key)
5. Iterator<Product> iterator()

Наименование класса может звучать так: MyHashMap, при этом нельзя использовать HashMap.
Примечение: напоминаю, что карта состоит из массива, элементами которого являются односвязанные списки.*/
	