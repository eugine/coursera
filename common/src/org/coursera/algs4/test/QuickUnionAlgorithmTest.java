package org.coursera.algs4.test;

import static org.junit.Assert.*;

import org.coursera.algs4.QuickUnionAlgorithm;
import org.junit.Test;

public class QuickUnionAlgorithmTest {

	@Test
	public void testQuickUnionAlgorithm() {
		QuickUnionAlgorithm qu = new QuickUnionAlgorithm(10);
		qu.union(4, 3);
		qu.union(3, 8);
		qu.union(6, 5);
		qu.union(9, 4);
		qu.union(2, 1);

		assertTrue(qu.connected(4, 3));
		assertTrue(qu.connected(4, 8));
		assertTrue(qu.connected(8, 9));
		assertFalse(qu.connected(4, 5));

		qu.union(5, 0);
		qu.union(7, 2);
		qu.union(6, 1);
		qu.union(7, 3);

		int expected[] = { 1, 8, 1, 8, 3, 0, 5, 1, 8, 8 };
		assertTrue(qu.isArrayEquals(expected));
	}

}
