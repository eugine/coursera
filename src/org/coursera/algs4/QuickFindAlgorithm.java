package org.coursera.algs4;

import java.util.Arrays;

public class QuickFindAlgorithm {

	private int id[]; 
	
	public QuickFindAlgorithm(int size) {
		id = new int [size];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
	}	
	
	public void union(int p, int q) {
		int pid=id[p];
		int qid=id[q];
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid) id[i] = qid;
		}
	}


	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	

	public boolean isArrayEquals(int array[]) {
		return Arrays.equals(id, array);
	}
	
	@Override
	public String toString() {
		return "QuickFindAlgorithm [id=" + Arrays.toString(id) + "]";
	}
	

}
