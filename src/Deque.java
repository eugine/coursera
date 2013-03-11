import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
	/**
	 * construct an empty deque
	 */
	public Deque() {
	}

	/**
	 * is the deque empty?
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return true;
	}

	/**
	 * return the number of items on the deque
	 * 
	 * @return
	 */
	public int size() {
		return 0;
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
	}

	/**
	 * delete and return the item at the front
	 * 
	 * @return
	 */
	public Item removeFirst() {
		return null;
	}

	/**
	 * delete and return the item at the end
	 * 
	 * @return
	 */
	public Item removeLast() {
		return null;
	}

	/**
	 * return an iterator over items in order from front to end
	 */
	public Iterator<Item> iterator() {
		return null;
	}
}