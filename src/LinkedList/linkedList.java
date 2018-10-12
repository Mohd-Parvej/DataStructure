package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class linkedList {
	private int length = 0;

	// default constructor
	public linkedList() {
		length = 0;
	}

	// return the first node in the list
	public synchronized ListNode getHead(ListNode head) {
		return head;
	}

	// insert a node at the beginning of the list
	public synchronized ListNode insertAtBegin(int data, ListNode head) {
		ListNode node = new ListNode(data);
		node.next = head;
		head = node;
		length++;
		return head;
	}

	// insert a node at the end of the list
	public synchronized ListNode insertAtEnd(int data, ListNode head) {
		ListNode node = new ListNode(data);
		if (head == null)
			head = node;
		else {
			ListNode p, q;
			for (p = head; (q = p.getNext()) != null; p = q);
			p.setNext(node);
		}
		length++;
		return head;
	}

	// add a new value to the list at a given position
	public ListNode insert(int data, int pos, ListNode head) {
		if (pos < 0)
			pos = 0;
		if (pos > length)
			pos = length - 1;
		// if the list is empty
		if (head == null)
			head = new ListNode(data);
		else if (pos == 0) {
			ListNode temp = new ListNode(data);
			temp.next = head;
			head = temp;
		} else {
			ListNode temp = head;
			for (int i = 1; i < pos; i++)
				temp = temp.getNext();
			ListNode newNode = new ListNode(data);
			newNode.next = temp.next;
			temp.setNext(newNode);
		}
		length++;
		return head;
	}

	// Remove and return
	public synchronized ListNode removeFromBegin(ListNode head) {
		ListNode node = head;
		if (node != null) {
			head = node.getNext();
			node.setNext(null);
		}
		return head;
	}

	// Remove from the end of the list
	public synchronized ListNode removeFromEnd(ListNode head) {
		if (head == null)
			return null;
		ListNode p = head, q = null, next = head.getNext();
		if (next == null) {
			head = null;
			return p;
		}
		while ((next = p.getNext()) != null) {
			q = p;
			p = next;
		}
		q.setNext(null);
		return head;
	}

	// Remove a node matching the specified node from the list
	public synchronized void removeMatched(ListNode node, ListNode head) {
		if (head == null)
			return;
		if (node.equals(head)) {
			head = head.getNext();
			return;
		}
		ListNode p = head, q = null;
		while ((q = p.getNext()) != null) {
			if (node.equals(q)) {
				p.setNext(q.getNext());
				return;
			}
			p = q;
		}
	}

	// Remove the value at a given position
	public ListNode remove(int pos, ListNode head) {
		if (pos < 0)
			pos = 0;
		if (pos > length)
			pos = length - 1;
		if (head == null)
			return null;
		if (pos == 0)
			head = head.getNext();
		else {
			ListNode temp = head;
			for (int i = 1; i < pos; i++)
				temp = temp.getNext();
			temp.setNext(temp.getNext().getNext());
		}
		length--;
		return head;
	}

	// Return the current length of the list
	public int length() {
		return length;
	}

	// Show the list
	public void showList(ListNode head) {
		ListNode temp = head;
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
		ListNode head = null;
		/*
		 * ListNode node = new ListNode(1); linkedList list = new linkedList();
		 * list.insertAtEnd(node); ListNode node2 = new ListNode(2);
		 * list.insertAtEnd(node2); list.showList();
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean start = true;
		linkedList list = new linkedList();
		while (start) {
			System.out.println("1. Insert at begin");
			System.out.println("2. Inset at end");
			System.out.println("3. Inset by position");
			System.out.println("4. Remove from begin");
			System.out.println("5. Remove from end");
			System.out.println("6. Remove from specific position");
			System.out.println("7. Show the list");
			System.out.println("8. Exit");
			System.out.println("Please select above choices:");
			int choice = Integer.parseInt(br.readLine());
			switch (choice) {
			case 1:
				System.out.println("Please enter an element to add at the beginning:");
				int begin = Integer.parseInt(br.readLine());
				head = list.insertAtBegin(begin, head);
				list.showList(head);
				break;
			case 2:
				System.out.println("Please enter an element to add at the end:");
				int end = Integer.parseInt(br.readLine());
				head = list.insertAtEnd(end, head);
				list.showList(head);
				break;
			case 3:
				System.out.println("Enter a value:");
				int ele = Integer.parseInt(br.readLine());
				System.out.println("Enter the position:");
				int elePos = Integer.parseInt(br.readLine());
				head = list.insert(ele, elePos, head);
				list.showList(head);
				break;
			case 4:
				head = list.removeFromBegin(head);
				list.showList(head);
				break;
			case 5:
				head = list.removeFromEnd(head);
				list.showList(head);
				break;
			case 6:
				System.out.println("Enter the position:");
				int pos = Integer.parseInt(br.readLine());
				head = list.remove(pos, head);
				list.showList(head);
				break;
			case 7:
				System.out.println("List.......");
				list.showList(head);
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

	static class ListNode {
		private int data;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
			next = null;
		}

		public void setData(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setNext(ListNode next) {
			this.next = next;
		}

		public ListNode getNext() {
			return this.next;
		}

		public int listLength(ListNode headNode) {
			int length = 0;
			ListNode currNode = headNode;
			while (currNode != null) {
				length++;
				currNode = currNode.getNext();
			}
			return length;
		}

	}

}
