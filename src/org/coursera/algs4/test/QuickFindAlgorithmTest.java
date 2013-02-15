package org.coursera.algs4.test;

import static org.junit.Assert.*;

import org.coursera.algs4.QuickFindAlgorithm;
import org.junit.Test;

public class QuickFindAlgorithmTest {

	@Test
	public void testQuickFindUnionOperation() {
		QuickFindAlgorithm qf = new QuickFindAlgorithm(10);
		
		qf.union(9, 8);
		assertTrue(qf.connected(9,8));
		qf.union(7, 8);
		assertTrue(qf.connected(7, 9));
		
		qf.union(0, 3);
		qf.union(1, 2);
		qf.union(3, 2);

		assertTrue(qf.connected(0, 2));
	}
}
