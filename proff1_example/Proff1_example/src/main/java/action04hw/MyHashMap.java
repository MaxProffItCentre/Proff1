package action04hw;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MyHashMap {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put(10, 20);
	}
}
interface Map1<K,V>{
	interface Entry1<K,V>{
		K getKey();
		V getValue();
	}
}
abstract class AbsractMap1<K,V> implements Map1<K,V>{
	transient volatile Set<K>        keySet;
    transient volatile Collection<V> values;
    public abstract Set<Entry1<K,V>> entrySet();
    public static class SimpleEntry1<K,V>{}
    public static class SimpleImmutableEntry1<K,V>{}
}
class HashMap1<K,V> extends AbsractMap1<K,V>{

	@Override
	public Set<Entry1<K, V>> entrySet() {
		return null;
	} 
	static class Node1<K,V> implements Map.Entry<K,V> {

		@Override
		public K getKey() {
				return null;
		}
		@Override
		public V getValue() {
			return null;
		}

		@Override
		public V setValue(V value) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	final class EntrySet1 extends AbstractSet<Map.Entry<K,V>> {

		@Override
		public Iterator<Entry<K, V>> iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
}



