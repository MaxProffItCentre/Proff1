package myHashMap;

public interface myMap<K,V> extends Iterable<K> {
	boolean put(K key, V value);
	int size();
	boolean remove(K key);
	
}
