package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DoublyLinkedList {
	private int length = 0;

	public DLLNode insertAtBegin(int data, DLLNode head) {
		if (head == null) {
			DLLNode node = new DLLNode(data);
			node.setNext(null);
			node.setPrev(null);
			head = node;
			return head;
		}
		DLLNode node = new DLLNode(data, head, head.getNext());
		node.setPrev(null);
		head.setPrev(node);
		node.setNext(head);
		head = node;
		length++;
		return head;
	}

	public DLLNode insertAtEnd(int data, DLLNode head) {
		if (head == null) {
			DLLNode node = new DLLNode(data);
			node.setNext(null);
			node.setPrev(null);
			head = node;
			return head;
		}
		DLLNode p, q;
		for (p = head; (q = p.getNext()) != null; p = q)
			;
		DLLNode node = new DLLNode(data, p, p.getNext());
		node.setNext(null);
		node.setPrev(p);
		p.setNext(node);
		length++;
		return head;
	}

	public DLLNode insert(int data, int pos, DLLNode head) {
		if (pos < 0)
			pos = 0;
		if (pos > length)
			pos = length;
		if (head == null) {
			DLLNode node = new DLLNode(data);
			node.setNext(null);
			node.setPrev(null);
			head = node;
			return head;
		} else if (pos == 0) {
			return insertAtBegin(data, head);
		} else {
			DLLNode temp = head;
			for (int i = 0; i < pos - 1; i++)
				temp = temp.getNext();
			DLLNode node = new DLLNode(data, temp, temp.getNext());
			node.next = temp.next;
			node.prev = temp;
			node.next.prev = node;
			temp.next = node;
		}
		length++;
		return head;
	}

	public DLLNode removeFromBegin(DLLNode head) {
		if (head == null) {
			System.out.println("List is empty");
			return head;
		}
		DLLNode temp = head;
		head = head.next;
		head.setPrev(null);
		temp.next = null;
		length--;
		return head;
	}
	
	public DLLNode removeFromEnd(DLLNode head) {
		if(length == 0) {
			System.out.println("List is empty!");
			return null;
		}
		DLLNode p = head, q;
		while(p.next != null)
			p = p.getNext();
		q = p.getPrev();
		q.next = null;
		length--;
		return head;
	}
	
	public DLLNode remove(int pos, DLLNode head) {
		if(pos < 0)
			pos = 0;
		if(pos > length)
			pos = length;
		if(length == 0) {
			System.out.println("List is empty!");
			return null;
		}
		DLLNode temp = head;
		for(int i=1; i<pos-1; i++)
			temp = temp.getNext();
		temp.next.next.prev = temp;
		temp.next = temp.getNext().getNext();
		return head;
	}

	public void showDLL(DLLNode head) {
		DLLNode temp = head;
		if (temp == null) {
			System.out.println("List is empty!");
			return;
		}
		while (temp != null) {
			System.out.printf("%d -> ", temp.getData());
			temp = temp.getNext();
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		DLLNode head = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean start = true;
		DoublyLinkedList DDList = new DoublyLinkedList();
		while (start) {
			System.out.println("1. Insert at begin");
			System.out.println("2. Inset at end");
			System.out.println("3. Inset by position");
			System.out.println("4. Remove from begin");
			System.out.println("5. Remove from end");
			System.out.println("6. Remove from specific position");
			System.out.println("7. Show the list");
			System.out.println("8. Exit");
			System.out.println("Please select below choices:");
			int choice = Integer.parseInt(br.readLine());
			switch (choice) {
			case 1:
				System.out.println("Enter the value:");
				int begin = Integer.parseInt(br.readLine());
				head = DDList.insertAtBegin(begin, head);
				DDList.showDLL(head);
				break;
			case 2:
				System.out.println("Please enter a element to add at the end:");
				int end = Integer.parseInt(br.readLine());
				head = DDList.insertAtEnd(end, head);
				DDList.showDLL(head);
				break;
			case 3:
				System.out.println("Enter a value:");
				int ele = Integer.parseInt(br.readLine());
				System.out.println("Enter the position:");
				int elePos = Integer.parseInt(br.readLine());
				head = DDList.insert(ele, elePos, head);
				DDList.showDLL(head);
				break;
			case 4:
				head = DDList.removeFromBegin(head);
				DDList.showDLL(head);
				break;
			case 5:
				head = DDList.removeFromEnd(head);
				DDList.showDLL(head);
				break;
			case 6:
				System.out.println("Enter the position:");
				int pos = Integer.parseInt(br.readLine());
				head = DDList.remove(pos, head);
				DDList.showDLL(head);
				break;
			case 7:
				System.out.println("Doubly LinkedList.......");
				DDList.showDLL(head);
				break;
			case 8:
				System.out.println("Exit from the exection");
				start = false;
				break;
			default:
				System.out.println("Wrong entry! please try again");
				break;
			}
		}
	}

	static class DLLNode {
		private int data;
		private DLLNode prev;
		private DLLNode next;

		public DLLNode(int data) {
			this.data = data;
		}

		public DLLNode(int data, DLLNode prev, DLLNode next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public DLLNode getPrev() {
			return prev;
		}

		public DLLNode getNext() {
			return next;
		}

		public void setPrev(DLLNode where) {
			this.prev = where;
		}

		public void setNext(DLLNode where) {
			this.next = where;
		}
	}

}
