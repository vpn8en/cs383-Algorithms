package a7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import edu.princeton.cs.algs4.TrieST;

public class Index {

	TrieST<List<Integer>> st;

	public Index(String fileName) {
		st = new TrieST<List<Integer>>();
		File f = new File("src/a7/" + fileName); // you may have problems with this, my version of eclipse needed the "src/a7/"
		Scanner s;
		String[] line = new String[50];
		int lineNumber = 0;
		try {
			s = new Scanner(f);
			while (s.hasNextLine()) {
				line = s.nextLine().split(" ");
				for (int i = 0; i < line.length; i++) {
					record(line[i].trim(), lineNumber);
				}
				lineNumber++;
			}
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found!");
			e.printStackTrace();
			System.exit(0);
		}
	}

	private void record(String key, int lineNumber) {
		List<Integer> entry = st.get(key);
		if (entry == null) {
			entry = new ArrayList<Integer>();
			st.put(key, entry);
		}
		entry.add(lineNumber);

	}

	public Object get(String string) {
		if (st.get(string) == null)
			return null;
		StringBuilder result = new StringBuilder();
		for (int i : st.get(string))
			result.append(i + " ");
		return result;
	}
}
