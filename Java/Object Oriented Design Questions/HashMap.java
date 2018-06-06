package Test;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap {

	int size;
	int count;
	List<List<Item>> map = new ArrayList<List<Item>>();

	public MyHashMap(int size) {
		this.count=0;
		this.size = size;
		for (int i = 0; i < size; i++) {
			List<Item> chain = new ArrayList<Item>();
			map.add(chain);
		}
	}

	public int getHashKey(int key) {
		int hash = new Integer(key).hashCode() & size - 1;
		return hash;
	}

	public int get(int key) throws Exception {
		int hash = getHashKey(key);
		List<Item> chain = map.get(hash);
		for (Item item : chain) {
			if (item.key == key)
				return item.value;
		}
		throw new Exception("No such key found...!!!");
	}

	public boolean remove(int key) throws Exception {
		int hash = getHashKey(key);
		List<Item> chain = map.get(hash);
		for (Item item : chain) {
			if (item.key == key)
				return chain.remove(item);
		}
		throw new Exception("No such key found...!!!");
	}
	
	public void put(int key, int value) {
		int hash = getHashKey(key);
		List<Item> chain = map.get(hash);
		for (Item item : chain) {
			if (item.key == key) {
				item.value = value;
				return;
			}
		}
		chain.add(new Item(key, value));
		count++;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public int size() {
		return count;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MyHashMap m = new MyHashMap(5);
		System.out.println(m.isEmpty());
		m.put(1,5);
		m.put(2,10);
		m.put(3,15);
		System.out.println(m.size());
		System.out.println(m.isEmpty());
		System.out.println(m.get(2));
		System.out.println(m.size());
		System.out.println(m.isEmpty());
		m.put(2,20);
		System.out.println(m.get(2));
	}

}


class Item {

	int key;
	int value;
	
	public Item(int key,int value){
		this.key=key;
		this.value=value;
	}
}
