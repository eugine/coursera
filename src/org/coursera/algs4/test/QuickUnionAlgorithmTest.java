package org.coursera.algs4.test;

import static org.junit.Assert.*;

import org.coursera.algs4.QuickUnionAlgorithm;
import org.junit.Test;

public class QuickUnionAlgorithmTest {

	@Test
	public void testQuickUnionAlgorithm() {
		QuickUnionAlgorithm qu = new QuickUnionAlgorithm(10);
		qu.union(4, 3);
		assertTrue(qu.connected(4, 3));
		qu.union(3, 8);
		assertTrue(qu.connected(4, 8));
		System.out.println(qu);
//		qu.union();
//		qu.union();
//		qu.union();
	}

}
