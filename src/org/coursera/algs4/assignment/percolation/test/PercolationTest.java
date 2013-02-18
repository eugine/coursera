package org.coursera.algs4.assignment.percolation.test;

import static org.junit.Assert.*;

import org.coursera.algs4.assignment.percolation.Percolation;
import org.junit.Test;

public class PercolationTest {

	@Test
	public void testPercolationCreation() {
		Percolation percolation = new Percolation(3);
		
		System.out.println(percolation);
	}

}
