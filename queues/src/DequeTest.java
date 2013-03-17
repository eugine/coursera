import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DequeTest {

	@Test(expected = NullPointerException.class)
	public void testAddNullFirstNullPointerException() {
		Deque<String> deque = new Deque<String>();
		deque.addFirst(null);
	}

	@Test(expected = NullPointerException.class)
	public void testAddNullLastNullPointerException() {
		Deque<String> deque = new Deque<String>();
		deque.addLast(null);
	}

	@Test
	public void testAddition() {
		Deque<String> deque = new Deque<String>();
		deque.addFirst(new String("test"));
		assertFalse(deque.isEmpty());
		deque.addFirst(new String("test first"));
		deque.addLast(new String("test last"));
		assertEquals(deque.size(), 3);
	}

	@Test
	public void testAdditionOrdered() {
		Deque<Integer> deque = new Deque<Integer>();
		for (int i = 0; i < 10; i++) {
			deque.addFirst(i);
		}
		for (int i = 0; i < 10; i++) {
			assertEquals(deque.removeLast(), new Integer(i));
		}
	}

	@Test
	public void testAdditionReverseOrdered() {
		Deque<Integer> deque = new Deque<Integer>();
		for (int i = 0; i < 10; i++) {
			deque.addLast(i);
		}
		for (int i = 0; i < 10; i++) {
			assertEquals(deque.removeFirst(), new Integer(i));
		}
	}

	@Test
	public void testRemove() {
		Deque<String> deque = new Deque<String>();
		deque.addFirst(new String("test"));
		deque.addFirst(new String("test first"));
		deque.addLast(new String("test last"));
		deque.removeLast();
		deque.removeFirst();
		assertTrue(deque.size() == 1);
		deque.removeLast();
		assertTrue(deque.size() == 0);
	}

	@Test
	public void testIsEmpty() {
		Deque<String> deque = new Deque<String>();
		assertTrue(deque.isEmpty());
		deque.addFirst(new String("test first"));
		deque.addLast(new String("test last"));
		deque.addLast(new String("test last"));
		deque.addFirst(new String("test first"));
		deque.addLast(new String("test last"));
		assertFalse(deque.isEmpty());
		deque.removeFirst();
		deque.removeFirst();
		deque.removeFirst();
		deque.removeLast();
		deque.removeLast();
		assertTrue(deque.isEmpty());
	}

	@Test(expected = NoSuchElementException.class)
	public void testRemoveLastFromEmptyDeque() {
		Deque<Integer> deque = new Deque<Integer>();
		int count = 10;
		for (int i = 0; i < count; i++) {
			deque.addLast(i);
		}
		for (int i = 0; i < count; i++) {
			deque.removeLast();
		}
		deque.removeLast(); // should throw
	}

	@Test(expected = NoSuchElementException.class)
	public void testRemoveFirstFromEmptyDeque() {
		Deque<Integer> deque = new Deque<Integer>();
		int count = 10;
		for (int i = 0; i < count; i++) {
			deque.addFirst(10);
		}
		for (int i = 0; i < count; i++) {
			deque.removeFirst();
		}
		deque.removeFirst(); // should throw exception
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testRemoveFromIterator() {
		Deque<String> deque = new Deque<String>();
		deque.addFirst("middle");
		deque.addLast("last");
		deque.addFirst("first");
		Iterator<String> i = deque.iterator();
		i.next();
		i.remove(); // should throw exception
	}

	@Test(expected = NoSuchElementException.class)
	public void testNextFromEmptyIterator() {
		Deque<String> deque = new Deque<String>();
		deque.addLast("last");
		deque.addFirst("first");
		Iterator<String> i = deque.iterator();
		i.next();
		i.next();
		i.next(); // should throw exception
	}


	
}
