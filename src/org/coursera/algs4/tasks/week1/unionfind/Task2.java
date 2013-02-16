package org.coursera.algs4.tasks.week1.unionfind;

import org.coursera.algs4.WeightedQuickUnionAlgorithm;

/**
 * Question 2 (seed = 866391)<br>
 * Give the id[] array that results from the following sequence of 9 union operations on a set of 10 items using the weighted quick-union algorithm from lecture.<br><br>
 * 
 * 4-2 1-2 8-5 1-6 9-3 9-8 6-7 5-2 2-0<br><br>
 * Recall: when joining two trees of equal size, our weighted quick union convention is to make the root of the second tree point to the root of the first tree.<br>
 * @author eugine
 *
 */
public class Task2 {

	public static void main(String[] args) {
		WeightedQuickUnionAlgorithm wqu = new WeightedQuickUnionAlgorithm(10);
		wqu.union(4, 2);
		wqu.union(1, 2);
		wqu.union(8, 5);
		wqu.union(1, 6);
		wqu.union(9, 3);
		wqu.union(9, 8);
		wqu.union(6, 7);
		wqu.union(5, 2);
		wqu.union(2, 0);
		System.out.println(wqu);
	}
}
