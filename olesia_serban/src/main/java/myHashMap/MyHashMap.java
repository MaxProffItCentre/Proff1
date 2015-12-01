package myHashMap;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * myHashmap allows to store data with methods hashcode(); and equals();
 * 
 * @author Olesia Serban
 * @param <User>
 * 
 **/
public class MyHashMap<K, V> implements myMap<K, V> {
	private static final int DEFAULT_CAPACITY = 75;
	private Bar<K, V>[] data;
	private int size;
	private int indexInBar;

	@SuppressWarnings("unchecked")
	public MyHashMap() {
		data = new Bar[DEFAULT_CAPACITY];
	}

	/**
	 * puts the data into the map
	 * 
	 * @param K
	 *            key
	 * @param V
	 *            value
	 **/
	@Override
	public boolean put(K key, V value) {
		int idx = Math.abs(key.hashCode() % data.length);

		if (key != null && value != null) {
			if (data[idx] == null) {
				data[idx] = new Bar<K, V>();

				data[idx].head = data[idx].tail = new Node<K, V>(key, value, null);
				data[idx].barSize++;
				size++;
				return true;

			} else {
				if (findIfEqualsInBar(idx, key)) {
					findEqualAndChangeValue(idx, value);
					return true;
				} else {
					Node<K, V> node = new Node<>(key, value, null);
					data[idx].tail.next = node;
					data[idx].tail = node;
					data[idx].barSize++;
					size++;
					return true;
				}

			}

		} else {
			return false;
		}

	}

	private void findEqualAndChangeValue(int idx, V value) {
		Node<K, V> res = data[idx].head;
		for (int i = 0; i < indexInBar; i++) {
			res = res.next;
		}
		res.value = value;
		indexInBar = 0;
	}

	private boolean findIfEqualsInBar(int idx, K key) {
		Node<K, V> tmp = data[idx].head;
		while (tmp != null) {

			if (tmp.key.equals(key)) {
				return true;
			}
			indexInBar++;
			tmp = tmp.next;
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	private void findInBarAndRemove(int idx, K key) {

		if (data[idx].barSize == 1) {
			data[idx].head = data[idx].tail = null;
		} else {
			if (data[idx].head.key.equals(key)) {
				data[idx].head = data[idx].head.next;
			} else if (data[idx].tail.key.equals(key)) {
				data[idx].tail = null;
			} else {
				for (Node<K, V> tmp = data[idx].head; tmp != null; tmp = tmp.next) {
					if (tmp.key.equals(key)) {
						tmp = tmp.next;
					}
				}

			}
		}
	}

	public K get(K key) {

		return null;

	}

	/** removes the data by key from map **/
	@Override
	public boolean remove(K key) {
		int idx = key.hashCode() % data.length;
		if (data[idx] == null) {
			return false;
		} else {
			findInBarAndRemove(idx, key);
			size--;
			return true;
		}

	}

	/**
	 * this class examples store data K key and V Value this class examples are
	 * put into bars
	 **/
	private static class Node<K, V> {
		K key;
		V value;
		Node<K, V> next;

		public Node(K key, V value, Node<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	/**
	 * this class examples are put into the array and stores nodes
	 **/
	private static class Bar<K, V> {
		int barSize;
		Node<K, V> head;
		Node<K, V> tail;

		public Bar() {

		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (Node<K, V> tmp = head; tmp != null; tmp = tmp.next) {
				sb.append(tmp.key).append(" : ").append(tmp.value).append("\n");
			}
			return sb.toString();
		}
	}

	@Override
	public String toString() {
		if (size == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			if (data[i] != null) {
				sb.append(data[i].toString());
			}
		}

		return sb.toString();
	}

	@Override
	public Iterator<K> iterator() {

		return new Iterator<K>() {
			int pos;
			int position = -1;

			@Override
			public boolean hasNext() {

				return pos < size();
			}

			@Override
			public K next() {

				if (!hasNext()) {
					throw new NoSuchElementException();
				}

				for (position++; data[position] == null; position++) {

				}
				pos++;
				return data[position++].tail.key;
			}

		};
	}

}
