package a3;

public class ListStack<Item> {

	private Node first;
	private int size;

	private class Node {
		Item item;
		Node next;

		private Node(Item item, Node next) {
			this.item = item;
			this.next = next;
		}
	}
	
	public boolean isEmpty(){ return size == 0;}
	public int size(){return size;}
	
	public void push(Item item){
		Node oldfirst = first;
		first = new Node(item, oldfirst);
		size++;
	}
	public Item pop(){
		Item item = first.item;
		first = first.next;
		size--;
		return item;
	}
}