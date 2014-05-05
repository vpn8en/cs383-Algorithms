package a3;

import java.util.Iterator;

public class ArrayStack<Item> implements Iterable<Item> {

	private Item[] a = (Item[]) new Object[1];
	private int size;

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < size; i++) {
			temp[i] = a[i];
			a = temp;
		}
	}
	
	public void push(Item item){
		if(size == a.length) resize(2*a.length);
		a[size++] = item;
	}

	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item> {

		private int i = size;

		public boolean hasNext() {
			return i > 0;
		}

		public Item next() {
			return a[--i];
		}

		public void remove() {
		}
	}

}