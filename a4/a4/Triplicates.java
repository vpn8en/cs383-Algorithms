package a4;
import edu.princeton.cs.algs4.*;
import edu.princeton.cs.introcs.*;

import java.util.Arrays;

public class Triplicates {

	public static String find(String[] a, String[] b, String[] c) { //linearithmic because of binary search
		Quick.sort(a);
		Quick.sort(b);
		Quick.sort(c);
		int tempb,tempc;
		for (int i = 0; i < a.length; i++) {
			tempb = Arrays.binarySearch(b, a[i]);
			tempc = Arrays.binarySearch(c, a[i]);
			if(tempb > 0 && tempc > 0){
				return b[tempb];
			}
		}
		return null;
	}
}
