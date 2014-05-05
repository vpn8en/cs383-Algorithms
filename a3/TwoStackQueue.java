package a3;
import edu.princeton.cs.algs4.Stack;

public class TwoStackQueue<Item> {

	private Stack<Item> in;
	private Stack<Item> out;

	public TwoStackQueue() {
		in = new Stack<Item>();
		out = new Stack<Item>();
	}

	public boolean isEmpty() {
		return in.isEmpty() && out.isEmpty();
	}

	public void enqueue(Item item) {
		in.push(item);
	}

	public Item dequeue() {
		if(out.isEmpty()){
			while (in.size() > 0) {
				out.push(in.pop());
			}
		}
		return out.pop();
	}
}