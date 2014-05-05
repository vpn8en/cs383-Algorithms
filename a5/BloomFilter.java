package a5;

public class BloomFilter<T> {

	boolean[] bitArray = new boolean[256];

	public int hash(String string, int i) {
		return (byte) (string.hashCode() >> 8*i) & 0XFF;
	}

	public boolean contains(String string) {
		for (int i = 0; i < 4; i++) {
			if (!bitArray[hash(string, i)])
				return false;
		}
		return true;
	}

	public void add(String string) {
		for (int i = 0; i < 4; i++) {
			bitArray[hash(string,i)] = true;
		}
	}

}
