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
			throw new java.lang.NullPointerException(
					"It isn't allowed to add null items");
		}
		Node<Item> n = new Node<Item>(item);
		if (size == 0) {
			first = n;
			last = n;
		} else {
			n.next = first;
			first.previous = n;
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
			throw new java.lang.NullPointerException(
					"It isn't allowed to add null items");
		}
		Node<Item> n = new Node<Item>(item);
		if (size == 0) {
			first = n;
			last = n;
		} else {
			n.previous = last;
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
		Item item = first.data;
		if (size == 1) {
			first = null;
			last = null;
		} else {
			first = first.next;
			first.previous = null;
		}
		size--;
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
		Item item = last.data;
		if (size == 1) {
			first = null;
			last = null;
		} else {
			last = last.previous;
			last.next = null;
		}
		size--;
		return item;
	}

	/**
	 * return an iterator over items in order from front to end
	 */
	public Iterator<Item> iterator() {
		return new DequeIterator<Item>();
	}
	
	private final class DequeIterator<T> implements Iterator<T> {
		
		private Node<T> current;
		private DequeIterator() {
			current = (Node<T>) first;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if (current == null) {
				throw new NoSuchElementException();
			}
			T t = current.data;
			current = current.next;
			return t;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}

	private class Node<T> {
		private T data;
		private Node<T> next;
		private Node<T> previous;

		Node(T data) {
			this.data = data;
			next = null;
			previous = null;
		}
	}

}