import java.util.Random;

public class PercolationStats {

	private double mean;
	private double low, high;
	private double stddev;
	
	// perform T independent computational experiments on an N-by-N grid
	public PercolationStats(int N, int T) {
		if (N<=0 || T<=0) {
			throw new IllegalArgumentException("N and T have to bigger that 0.");
		}
		int threshold[] = new int[T];
		Random random = new Random();
		for (int i = 0; i < T; i++) {
			Percolation p = new Percolation(N);
			int attemp = 0;
			while (!p.percolates()) {
				int row = random.nextInt(N)+1;
				int column = random.nextInt(N)+1;
				while(p.isOpen(row, column)){
					row = random.nextInt(N)+1;
					column = random.nextInt(N)+1;
				}
				p.open(row, column);
				attemp++;
			}
			threshold[i] = attemp;
		}
		//calc mean
		double sum = 0.0;
		for (int i = 0; i < threshold.length; i++) {
			sum += threshold[i];
		}
		mean = sum / (T * N * N);
		//calc standrad deviation
		sum = 0.0;
		for (int i = 0; i < threshold.length; i++) {
			sum += Math.pow((((double)threshold[i]/(N*N)) - mean), 2);
		}
		stddev = Math.sqrt(sum / (T-1));
		//low
		double delta = 1.96 * stddev / Math.sqrt(T); 
		low = mean - delta;
		high = mean + delta;
	}

	// sample mean of percolation threshold
	public double mean() {
		return mean;
	}

	// sample standard deviation of percolation threshold
	public double stddev() {
		return stddev;
	}

	// returns lower bound of the 95% confidence interval
	public double confidenceLo() {
		return low;
	}

	// returns upper bound of the 95% confidence interval
	public double confidenceHi() {
		return high;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		PercolationStats stats = new PercolationStats(200, 200);
		System.out.println("mean\t\t\t= " + stats.mean());
		System.out.println("stddev\t\t\t= " + stats.stddev());
		System.out.println("95% confidence interval\t= " + stats.confidenceLo() + ", " + stats.confidenceHi());
		System.out.println("Time: " + (System.currentTimeMillis() - start));

	}

}
