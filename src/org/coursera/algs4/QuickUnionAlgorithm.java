package org.coursera.algs4;

import java.util.Arrays;

public class QuickUnionAlgorithm {

	private int id[];

	public QuickUnionAlgorithm(int size) {
		id = new int[size];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}

	public void union(int p, int q) {
		id[p] = root(q);
	}

	private int root(int p) {
		return (id[p] == p) ? p : root(id[p]);
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public boolean isArrayEquals(int array[]) {
		return Arrays.equals(id, array);
	}

	@Override
	public String toString() {
		return "QuickUnionAlgorithm [id=" + Arrays.toString(id) + "]";
	}

}
