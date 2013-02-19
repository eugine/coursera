package org.coursera.algs4.assignment.percolation;

import java.util.Arrays;

import org.coursera.algs4.QuickUnionAlgorithm;

/**
 * @author Eugene Sokolov
 */
public class Percolation {

	private static final byte BLOCKED_SITE = 0;
	private static final byte OPEN_SITE = 1;

	private int size;
	private byte grid[];
	private int virtualTopSiteIndex, virtualBottomSiteIndex;
	private QuickUnionAlgorithm uf;

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
		uf = new QuickUnionAlgorithm(gridSize + 2);
		// initialize first N elements
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				grid[i * N + j] = BLOCKED_SITE;
			}
		}
		virtualTopSiteIndex = gridSize; // index = NN;
		virtualBottomSiteIndex = gridSize + 1; // NN+1
		grid[virtualTopSiteIndex] = OPEN_SITE;
		grid[virtualBottomSiteIndex] = OPEN_SITE;
	}

	/**
	 * Transform (i,j) to index in grid array ((i-1)*N+(j-1))
	 * 
	 * @param row
	 *            row index
	 * @param column
	 *            column index
	 * @return index in the grid array or -1 if out of the boundaries
	 */
	private int getGridIndex(int row, int column) {
		if (row <= 0 || row > size || column <= 0 || column > size) {
			return -1;
		}
		return size * (row - 1) + (column - 1);
	}

	/**
	 * Open site (row, column) if it is not already
	 * 
	 * @param row
	 *            - row index
	 * @param column
	 *            - column index
	 * @throws IndexOutOfBoundsException
	 *             rise exception in case i,j > N or i,j <= 0
	 */
	public void open(int row, int column) {
		int gridIndex = getGridIndex(row, column);
		if (gridIndex == -1) {
			throw new IndexOutOfBoundsException("Index is out of boundaries.");
		}
		grid[gridIndex] = OPEN_SITE;
		int top = getGridIndex(row-1, column);
		int left = getGridIndex(row, column-1);
		int right = getGridIndex(row, column+1);
		int bottom = getGridIndex(row + 1, column);
		if (top != -1 && grid[top] == OPEN_SITE) {
			//union with top
			uf.union(gridIndex, top);
		}
		if (left != -1 && grid[left] == OPEN_SITE) {
			//union with left
			uf.union(gridIndex, left);
		}
		if (right != -1 && grid[right] == OPEN_SITE) {
			//union with right
			uf.union(gridIndex, right);
		}
		if (bottom != -1 && grid[bottom] == OPEN_SITE) {
			//union with bottom
			uf.union(gridIndex, bottom);			
		}
		if (row == 1) {
			//if top row - union with virtual top site
			uf.union(gridIndex, virtualTopSiteIndex);
		} 
		if (row == size) {
			//if bottom row - union with virtual bottom site
			uf.union(gridIndex, virtualBottomSiteIndex);
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
		int gridIndex = getGridIndex(row, column);
		if (gridIndex == -1) {
			throw new IndexOutOfBoundsException("Index is out of boundaries.");
		}
		return grid[gridIndex] == OPEN_SITE;
	}

	/**
	 * Is site (row, column) full (connected to top)?
	 * 
	 * @param row
	 *            - row index
	 * @param column
	 *            - column index
	 * @return true in case site (i,j) is full, false otherwise
	 */
	public boolean isFull(int row, int column) {
		int gridIndex = getGridIndex(row, column);
		if (gridIndex == -1) {
			throw new IndexOutOfBoundsException("Index is out of boundaries.");
		}
		return uf.connected(gridIndex, virtualTopSiteIndex);
	}

	/**
	 * Does the system percolate?
	 * 
	 * @return true in case the system percolate
	 */
	public boolean percolates() {
		return uf.connected(virtualBottomSiteIndex, virtualTopSiteIndex);
	}

	@Override
	public String toString() {
		return "Percolation [grid=" + Arrays.toString(grid) + "]" + "\n" +
				uf.toString();
	}

}
