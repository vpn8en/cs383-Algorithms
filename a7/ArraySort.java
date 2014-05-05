package a7;


public class ArraySort {
    
    // sort an array of strings
    public static void sort(int[][] a) {
        sort(a, 0, a.length-1, 0);
    }


    private static void sort(int[][] a, int lo, int hi, int d) { 
            if(hi <= lo) return;
        int less = lo, greater = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= greater) {
            int t = charAt(a[i], d);
            if      (t < v) swap(a, less++, i++);
            else if (t > v) swap(a, i, greater--);
            else              i++;
        }

        sort(a, lo, less-1, d);
        if (v >= 0) sort(a, less, greater, d+1);
        sort(a, greater+1, hi, d);
    }
    
    private static int charAt(int[] s, int d) {
        if (d >= s.length) return -1;
        return s[d];
    }

    // exchange a[i] and a[j]
    private static void swap(int[][] a, int i, int j) {
        int[] temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}