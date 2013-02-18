package org.coursera.algs4.assignment.percolation;

import java.util.Arrays;

import org.coursera.algs4.QuickFindAlgorithm;

/**
 * @author Eugene Sokolov
 */
public class Percolation {

	private static final byte BLOCKED_SITE = 0;
	private static final byte OPEN_SITE = 1;

	private int size;
	private byte grid[];
	private int topSiteIndex, bottomSiteIndex;

	/**
	 * Create N-by-N grid, with all sites blocked
	 * 
	 * @param N
	 *            grid size (N-by-N)
	 */
	public Percolation(int N) {
		if (N <= 0) {
			throw new IllegalArgumentException(
					"Grid size has to be bigger than 0.");
		}
		size = N;
		int gridSize = size * size;
		grid = new byte[gridSize + 2]; // N*N elements + top and bottom imagine
										// site elements
		// initialize first N elements
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				grid[i * N + j] = BLOCKED_SITE;
			}
		}
		topSiteIndex = gridSize; // index = NN;
		bottomSiteIndex = gridSize + 1; // NN+1
		grid[topSiteIndex] = OPEN_SITE;
		grid[bottomSiteIndex] = OPEN_SITE;
	}

	/**
	 * Transform (i,j) to index in grid array (i*N+j)
	 * 
	 * @param row
	 *            row index
	 * @param column
	 *            column index
	 * @return index in the grid array or -1 if out of the boundaries
	 */
	private int getSiteIndex(int row, int column) {
		if (row < 0 || row >= size || column < 0 || column >= size) {
			return -1;
		}
		return size * row + column;
	}

	/**
	 * Open site (row, column) if it is not already
	 * 
	 * @param row
	 *            - row index
	 * @param column
	 *            - column index
	 * @throws IndexOutOfBoundsException
	 *             rise exception in case i,j >= N or i,j < 0
	 */
	public void open(int row, int column) {
		int siteIndex = getSiteIndex(row, column);
		if (siteIndex == -1) {
			throw new IndexOutOfBoundsException("Index is out of boundaries.");
		}
		grid[siteIndex] = OPEN_SITE;
		int top = getSiteIndex(row-1, column);
		int left = getSiteIndex(row, column-1);
		int right = getSiteIndex(row, column+1);
		int bottom = getSiteIndex(row + 1, column);
		if (top != -1 && grid[top] == OPEN_SITE) {
			//unite with top
		}
		if (left != -1 && grid[left] == OPEN_SITE) {
			//unite with left
		}
		if (right != -1 && grid[right] == OPEN_SITE) {
			//unite with right
		}
		if (bottom != -1 && grid[bottom] == OPEN_SITE) {
			//unite with bottom
		}
		if (row == 0) {
			//if top row - unite with imagine top site
		} 
		if (row == size - 1) {
			//if bottom row - unite with imagine bottom site
			
		}
	}

	/**
	 * Check whether site (row, column) open?
	 * 
	 * @param row
	 *            - row index
	 * @param column
	 *            - column index
	 * @return true in case site (i,j) is open, false otherwise
	 */
	public boolean isOpen(int row, int column) {
		int siteIndex = getSiteIndex(row, column);
		return;
	}

	/**
	 * Is site (row, column) full?
	 * 
	 * @param row
	 *            - row index
	 * @param column
	 *            - column index
	 * @return true in case site (i,j) is full, false otherwise
	 */
	public boolean isFull(int row, int column) {
		return false;
	}

	/**
	 * Does the system percolate?
	 * 
	 * @return true in case the system percolate
	 */
	public boolean percolates() {
		return false;
	}

	@Override
	public String toString() {
		return "Percolation [grid=" + Arrays.toString(grid) + "]";
	}

}
