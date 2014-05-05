package a2;

import edu.princeton.cs.algs4.Queue;

public class Josephus {

	public static String run(int N, int offset) {
		String result = "";
		int store;
		Queue<Integer> circleOfLife = new Queue<Integer>();
		for (int i = 0; i < N; i++) {
			circleOfLife.enqueue(i);
		}
		for (int k = 0; k < N; k++) {
			for (int j = 1; j < offset; j++) {
				store = circleOfLife.dequeue();
				circleOfLife.enqueue(store);
			}
			store = circleOfLife.dequeue();
			result += store + " ";
		}
		return result;
	}
}
