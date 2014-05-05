package a8;
//I worked on this with Dani Fenske
/**
 * Las Vegas variant of 2-dimensional pattern matching, using a generalization
 * of the Rabin-Karp algorithm. Based on the implementation provided in
 * Sedgewick & Wayne, Algorithms (Fourth Edition).
 */
public class RabinKarp2D {

	/** A large number that happens to be prime. */
	public static final long MODULUS = Integer.MAX_VALUE;

	/** Radix of the alphabet. Assumes ASCII characters. */
	public static final int RADIX = 256;

	/**
	 * Powers of RADIX. Used to find the hash when the pattern window is
	 * shifted. Analogous to RM in S&W's code.
	 */
	private long[] factors;

	/** Height of pattern. */
	private int height;

	/** The pattern itself. */
	private char[][] pattern;

	/** Hash code of the pattern. */
	private long patternHash;

	/** Width of pattern. */
	private int width;

	public RabinKarp2D(char[][] pattern) {
		this.pattern = pattern;
		height = pattern.length;
		width = pattern[0].length;
		factors = new long[(height - 1) + (width - 1) + 1];
		factors[0] = 1;
		for (int i = 1; i < factors.length; i++) {
			factors[i] = (RADIX * factors[i - 1]) % MODULUS;
		}
		patternHash = hash(pattern);
	}

	/** Returns true if pattern matches text at position i, j. */
	public boolean check(char[][] text, int i, int j) {
		int x = i;
		int y = j;
		for (int a = 0; a < height; a++) {
			for (int b = 0; b < width; b++) {
				if (text[x][y] != pattern[a][b]) {
					return false;
				}
				y++;
			}
			x++;
			y = j;
		}
		return true;
	}

	/**
	 * Returns powers of RADIX, modulo MODULUS, up to (height - 1) * (width -
	 * 1).
	 */
	protected long[] getFactors() {
		return factors;
	}

	/**
	 * Computes (from scratch) and returns the hash of the upper left height *
	 * width block of data.
	 */
	protected long hash(char[][] data) {
		long result = 0;
		for (int i = 0; i < height; i++) {
			long rowHash = 0;
			for (int j = 0; j < width; j++) {
				rowHash = (RADIX * rowHash + data[i][j]) % MODULUS;
			}
			result = (RADIX * result + rowHash) % MODULUS;
		}
		return result;
	}

	/**
	 * Returns an array [i, j], where i and j are the coordinates of a match of
	 * pattern in text.
	 */
	public int[] search(char[][] text) {
		long rowStartHash = hash(text);
		long hash = rowStartHash;
		for (int i = 0; i <= text.length - height -1; i++) {
			if ((hash == patternHash) && check(text, i, 0)) {
				return new int[] { i, 0 };
			}
			for (int j = 0; j < text[0].length - width; j++) {
				hash = shiftRight(hash, text, i, j);
				if ((hash == patternHash) && check(text, i, j + 1)) {
					return new int[] { i, j + 1 };
				}
			}
			rowStartHash = shiftDown(rowStartHash, text, i);
			hash = rowStartHash;
		}
		return null;
	}

	//Given the hash of the block at i, j, returns the hash of the block at i + 1, j.
	protected long shiftDown(long hash, char[][] text, int i) {
		long result = hash;
		int degree = width + height - 2;
		
		long firstRowHash = 0;
		long newRowHash = 0;

		for (int j = 0; j < width; j++) {
			firstRowHash = (firstRowHash + (text[i][j] * factors[degree--])) % MODULUS;//compute first row hash
			newRowHash = (RADIX * newRowHash + text[i+height][j]) % MODULUS;//hash for new row 
		}
		result = ((result + MODULUS - firstRowHash) * RADIX) % MODULUS;
		return (result + newRowHash) % MODULUS;
	}

	//Given the hash of the block at i, j, returns the hash of the block at i, j + 1.
	protected long shiftRight(long hash, char[][] text, int i, int j) {
		long result = hash;
		int degree = width + height - 2; //The exponent to keep track of.
		
		//compute first column's hash
		long firstColHash = 0;
		for (int offset = 0; offset < height; offset++) {
			firstColHash = (firstColHash + (text[i+offset][j] * factors[degree--])) % MODULUS;
		}
		
		//subtract firstColHash and multiply by RADIX
		result = (RADIX*(result + MODULUS - firstColHash)) % MODULUS;
		
		//compute new column's hash
		long colHash = 0;
		for (int k = 0; k < height; k++) {
			colHash = (RADIX * colHash + text[i+k][j+width]) % MODULUS;
		}
		return (result +colHash) % MODULUS;
	}

}
