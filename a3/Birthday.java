package a3;

import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.introcs.*;

public class Birthday {
	/*
	 * Birthday problem. Write a program that takes an integer N from the
	 * command line and uses StdRandom.uniform() to generate a random sequence
	 * of integers between 0 and N – 1. Run experiments to validate the
	 * hypothesis that the number of integers generated before the first
	 * repeated value is found is ~√?N/2.
	 */

	public static final int NUMTESTS = 1000;

	public static void main(String[] Args) {
		boolean[] validate = new boolean[NUMTESTS];
		while (true) {
			System.out.println("Enter Number: ");
			int n = Integer.parseInt(StdIn.readLine());// gets the command line
														// argument and parses
														// it as an integer.
			for (int i = 0; i < NUMTESTS; i++) {
				validate[i] = testHyp(n);// tests the hypothesis of the problem.
			}
			System.out.println(analyse(validate));
		}
	}

	private static String analyse(boolean[] validate) {// confirm or deny
														// hypothesis by testing
														// boolean array
		int numTrue = 0;
		for (int i = 0; i < validate.length; i++) {
			if (validate[i])
				numTrue++;
		}
		return "True: " + numTrue + " False: " + (NUMTESTS - numTrue);
	}

	private static boolean testHyp(int n) {// tests the hypothesis of the
											// problem.
		int value = (int) Math.round(Math.sqrt(n) / 2);// the rounded value of
														// the test hypothesis
		int[] a = new int[value];
		generate(a, n);// assigns random values to the array
		//System.out.println(Arrays.toString(a)); printout arrays for testing. 

		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (a[i] == a[j]){
					//System.out.println("a[" + i + "] = " + a[i] + " a[" + j + "] = "+ a[j]);
					return true;}
			}
		}
		return false;
	}

	private static void generate(int[] a, int n) {
		for (int i = 0; i < a.length; i++) {
			a[i] = StdRandom.uniform(n);
		}
	}
}
