import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.Test;

public class RandomizedQueueTest {

	@Test
	public void testIsEmpty() {
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		assertTrue(rq.isEmpty());
		assertTrue(rq.size() == 0);
	}

	@Test(expected = NullPointerException.class)
	public void testEnqueueNull() {
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		rq.enqueue(null);
	}

	@Test
	public void testEnqueue() {
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			rq.enqueue(i);
		}
		assertFalse(rq.isEmpty());
		assertEquals(rq.size(), 10);
	}

	@Test
	public void testAutoCapacity() {
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		for (int i = 0; i < 1000; i++) {
			rq.enqueue(i); //shouldn't throw an exception
		}
		for (int i = 0; i < 1000; i++) {
			rq.dequeue(); //don't know how to assert it without "capacity()" for RandomizedQueue
		}
	}

	@Test(expected = NoSuchElementException.class)
	public void testDequeueEmptyQueue() {
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		rq.dequeue();
	}

	@Test(expected = NoSuchElementException.class)
	public void testSampleEmptyQueue() {
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		rq.sample();
	}

	@Test
	public void testDequeue() {
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		int count = 100;
		for (int i = 0; i < count; i++) {
			rq.enqueue(i);
		}
		for (int i = 0; i < count; i++) {
			rq.dequeue();
		}
		assertEquals(rq.size(), 0);
	}

	@Test
	public void testSample() {
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		int count = 10;
		for (int i = 0; i < count; i++) {
			rq.enqueue(i);
		}
		for (int i = 0; i < count; i++) {
			rq.sample();
		}
		assertEquals(rq.size(), count);
	}

	@Test
	public void testSampleRandomize() {
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			rq.enqueue(i);
		}
		int sample = rq.sample();
		int matchCount = 0;
		for (int i = 0; i < 1000; i++) {
			int temp = rq.sample();
			if (temp == sample) {
				matchCount++;
			}
		}
		assertTrue(matchCount < 250); //25% threshold should be enough to check that sample generated in random order 
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testEmptyIterator() {
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		rq.iterator().next();
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testRemoveFromIterator() {
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		rq.iterator().remove();
	}
	
	@Test
	public void testIterator() {
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		int sum_original = 0;
		for (int i = 0; i < 50; i++) {
			int item = StdRandom.uniform(50);
			sum_original+=item;
			rq.enqueue(item);
		}
		int sum_after = 0;
		for (Iterator<Integer> iterator = rq.iterator(); iterator.hasNext();) {
			sum_after += iterator.next();
		}
		assertEquals(sum_original, sum_after);
	}
	
	@Test
	public void testIteratorRandomization() {
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		for (int i = 0; i < 1000; i++) {
			rq.enqueue(i);
		}
		Iterator<Integer> iterator_1 = rq.iterator();
		Iterator<Integer> iterator_2 = rq.iterator();
		int total = 0;
		int match = 0;
		while (iterator_1.hasNext()) {
			total++;
			if (iterator_1.next().equals(iterator_2.next())) {
				match++;
			}
		}
		assertTrue(match * 100 / total < 5); // 5% diff is it enought? 
	}

}
