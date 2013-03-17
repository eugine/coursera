package org.coursera.algs4;

import java.util.Arrays;

public class WeightedQuickUnionAlgorithm extends QuickUnionAlgorithm {

	protected int sz[]; 
	
	public WeightedQuickUnionAlgorithm(int size) {
		super(size);
		sz = new int[size];
		for (int i = 0; i < size; i++) {
            sz[i] = 1;
        }		
	}

	@Override
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if (sz[i] < sz[j]) 
			{ id[i] = j; sz[j] += sz[i];} 
		else
			{ id[j] = i; sz[i] += sz[j];}
	}

	@Override
	public String toString() {
		return "WeightedQuickUnionAlgorithm [id=" + Arrays.toString(id)
				+ ", sz=" + Arrays.toString(sz) + "]";
	}
	
	
	
}
