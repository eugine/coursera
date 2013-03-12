
public class Subset {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int amount = Integer.parseInt(args[0]);
		RandomizedQueue<String> queue = new RandomizedQueue<String>();
		while (!StdIn.isEmpty()) {
			String str = StdIn.readString();
			queue.enqueue(str);
		}
		for (int i = 0; i < amount; i++) {
			System.out.println(queue.dequeue());
		}
	}

}
