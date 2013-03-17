package org.coursera.algs4.test;

import static org.junit.Assert.*;

import org.coursera.algs4.WeightedQuickUnionAlgorithm;
import org.junit.Test;

public class WeightedQuickUnionAlgorithmTest {

	@Test
	public void test() {
		WeightedQuickUnionAlgorithm wqu = new WeightedQuickUnionAlgorithm(10);
		int expected[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		wqu.union(4, 3);
		expected[3] = 4;
		wqu.union(3, 8); //0, 1, 2, 4, 4, 5, 6, 7, 4, 9
		expected[8] = 4;
		wqu.union(6, 5); //0, 1, 2, 4, 4, 6, 6, 7, 4, 9
		expected[5] = 6;
		wqu.union(9, 4); //0, 1, 2, 4, 4, 6, 6, 7, 4, 4
		expected[9] = 4;
		wqu.union(2, 1); //0, 2, 2, 4, 4, 6, 6, 7, 4, 4
		expected[1] = 2;
		wqu.union(5, 0); //6, 2, 2, 4, 4, 6, 6, 7, 4, 4
		expected[0] = 6;
		wqu.union(7, 2); //6, 2, 2, 4, 4, 6, 6, 2, 4, 4
		expected[7] = 2;
		wqu.union(6, 1); //6, 2, 6, 4, 4, 6, 6, 2, 4, 4
		expected[2] = 6;
		wqu.union(7, 3); //6, 2, 6, 4, 6, 6, 6, 2, 4, 4		
		expected[4] = 6;
		assertTrue(wqu.connected(1, 7));
		assertTrue(wqu.isArrayEquals(expected));
	}

}
