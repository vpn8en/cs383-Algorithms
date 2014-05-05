package a3;

import edu.princeton.cs.introcs.*;

/*1.4.43 Resizing arrays versus linked lists. Run experiments to validate the hypothesis
 that resizing arrays are faster than linked lists for stacks (see Exercise 1.4.35 and 
 Exercise 1.4.36). Do so by developing a version of  DoublingRatio that computes the ratios 
 of the running times of the two programs.
 */

public class DoubleRatio {
	public static final int NUMTESTS = 100;
	public static final int NUMDOUBLES = 5;

	public static final int MAX = 10000;//max value of loaded random number
	public static double avgListTime, avgArrayTime = 0;

	public static void main(String[] args) {
		
		double [] avgRatio = new double [NUMTESTS];
		int k = 60000;
		for (int j = 0; j < NUMTESTS; j++) {
			for (int i = 0; i < NUMDOUBLES; i++) {
				double arrayTime = timeTrialArray(k);
				double listTime = timeTrialList(k);

				avgRatio[j] += arrayTime/listTime;
				//StdOut.printf("Ratio: %7d %8.4f %8.4f ", k, arrayTime, listTime);
				//StdOut.printf("%5.1f\n", arrayTime/listTime);
				k += k;
			}
			k = 60000;
			avgRatio[j] /= 10;
			System.out.println("avgRatio: " + avgRatio[j]);
			//System.out.println(j + " & " + avgRatio[j]+" \\\\"); used to put into latex table

		}
		System.out.println(evaluate(avgRatio));
	}

	private static String evaluate(double [] avgRatio) {
		double average = 0;
		for (int i = 0; i < NUMTESTS; i++) {
			average += avgRatio[i];
		}
		return "The average ratio of the running times is: " + average/NUMTESTS;
	}

	private static double timeTrialArray(int i) {
		ArrayStack a = new ArrayStack();
		Stopwatch timer = new Stopwatch();
		for (int j = 0; j < i; j++) {
			a.push(StdRandom.uniform(MAX));
		}
		return timer.elapsedTime();
	}

	private static double timeTrialList(int i) {
		ListStack a = new ListStack();
		Stopwatch timer = new Stopwatch();
		for (int j = 0; j < i; j++) {
			a.push(StdRandom.uniform(MAX));
		}
		return timer.elapsedTime();
	}
}