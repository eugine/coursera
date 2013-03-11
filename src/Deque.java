import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	private Node<Item> first, last;
	private int size;
	/**
	 * construct an empty deque
	 */
	public Deque() {
		size = 0;
	}

	/**
	 * is the deque empty?
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * return the number of items on the deque
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * insert the item at the front
	 * 
	 * @param item
	 */
	public void addFirst(Item item) {
		if (item == null) {
			throw new java.lang.NullPointerException("It isn't allowed to add null items");
		}
		Node<Item> n = new Node<Item>(item);
		if (isEmpty()) {
			first = n;
			last = first;
		} else {
			n.next = first;
			first.prev = n;
			first = n;
		}
		size++;
	}

	/**
	 * insert the item at the end
	 * 
	 * @param item
	 */
	public void addLast(Item item) {
		if (item == null) {
			throw new java.lang.NullPointerException("It isn't allowed to add null items");
		}
		Node<Item> n = new Node<Item>(item);
		if (isEmpty()) {
			last = n;
			first = last;
 		} else {
 			n.prev = last;
 			last.next = n;
 			last = n;
 		}
		size++;
	}

	/**
	 * delete and return the item at the front
	 * 
	 * @return
	 */
	public Item removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("The deque is empty");
		}
		Item item = first.item;
		first = first.next;
		first.prev = null;
		size--;
		if (size == 0) {
			last = null;
			first = null;
		}
		return item;
	}

	/**
	 * delete and return the item at the end
	 * 
	 * @return
	 */
	public Item removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("The deque is empty");
		}
		Item item = last.item;
		last = last.prev;
		last.next = null;
		size--;
		if (size == 0) {
			last = null;
			first = null;
		}
		return item;
	}

	/**
	 * return an iterator over items in order from front to end
	 */
	public Iterator<Item> iterator() {
		return null;
	}
	
	private class Node<T>{
		private T item;
		private Node<T> next;
		private Node<T> prev;
		
		Node() {
			item = null;
			next = null;
			prev = null;
		}
		
		Node(T item) {
			this.item = item;
			next = null;
			prev = null;
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<Item> current = first;
		while(current != null) {
			sb.append(current.item + " | ");
			current = current.next;
		}
		return sb.toString();
	}
}