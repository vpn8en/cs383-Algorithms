package a2;

public class Steque<Item> {

	private Node first;
	private Node last;
	private int N;

	private class Node { // nested class to define nodes
		Item item;
		Node next;

		public Node(Item item, Node next) {
			this.item = item;
			this.next = next;
		}
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(Item item) { // Add item to top of stack.
		if (isEmpty()) {
			last = first = new Node(item, null);
			N++;
		} else {
			Node oldfirst = first;
			first = new Node(item, oldfirst);
			N++;
		}
	}

	public Item pop() { // Remove item from top of stack.
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	public void enqueue(Item item) {
		Node toAdd = new Node(item, null);
		if (isEmpty()) {
			push(item);
		} else {
			last.next = toAdd;
			last = toAdd;
		}
		N++;
	}

	public void catenate(Steque<Integer> B) {
		last.next = (Node) B.first;
		last = (Node) B.last;
	}

	public String toString() {
		String result = "";
		for (Node n = first; n != null; n = n.next) {
			result += n.item + " ";
		}
		return result;
	}

}
