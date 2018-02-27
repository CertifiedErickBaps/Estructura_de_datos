package cem.itesm.mx;

public class CLinkedList {

	private ListNode last;
	private int size;
	
	private static class ListNode {
		private ListNode next;
		private int data;
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	public CLinkedList() {
		last = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void createCLinkedList() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(5);
		ListNode third = new ListNode(10);
		ListNode fourth = new ListNode(15);
		
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = first;
		last = fourth;
		
	}
	
	public void display() {
		if(last == null) {
			return;
		}
		ListNode first = last.next;
		while(first != last) {
			System.out.print(first.data + " ");
			first = first.next;
		}
		System.out.print(first.data + " ");
	}
	
	public static void main(String[] args) {
		CLinkedList c = new CLinkedList();
		c.createCLinkedList();
		c.display();
		
	}
}
