package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedQueue {
	private int size = 0;
	private ListNode front, rear;

	public void Enqueue(int data) {
		ListNode node = new ListNode(data);
		if (front == null)
			front = rear = node;
		else {
			rear.setNext(node);
			rear = node;
		}
		size++;
	}

	public void Dequeue() {
		if (front == null)
			return;
		ListNode node = front;
		System.out.println("Removed " + node.getData());
		front = front.getNext();
		size--;
	}

	public void getSize() {
		System.out.println("Queue has " + size + " elements.");
		return;
	}

	public void getFront() {
		if (front == null) {
			System.out.println("Queue is empty!");
			return;
		}
		System.out.println("Front -> " + front.getData());
	}

	public void getRear() {
		if (front == rear) {
			System.out.println("Queue is empty!");
			return;
		}
		System.out.println("Rear -> " + rear.getData());
	}

	public void showQueue() {
		if (front == null) {
			System.out.println("Queue is empty!");
			return;
		}
		ListNode head = front;
		while (head != null) {
			System.out.printf("%d -> ", head.getData());
			head = head.getNext();
		}
		System.out.println();
	}
	
	public void reverseQueue() {
		if(front == null || front == rear)
			return;
		ListNode head = front;
		ListNode front2 = null, rear2 = null;
		
		for(int i=size-1; i>=0; i--) {
			for(int j=0; j<i; j++) {
				ListNode node = new ListNode(head.getData());
				if(front2 == null)
					front2 = node;
				else {
					rear2.setNext(node);
					rear2 = node;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedQueue queue = new LinkedQueue();
		boolean start = true;
		while (start) {
			System.out.println("1. Enqueue\n2. Dequeue\n3. Size\n4. Get front\n5. Get rear\n6. Reverse Queue\n7. Exit");
			System.out.println("Please select the above choices");
			int choice = Integer.parseInt(br.readLine());
			switch (choice) {
			case 1:
				System.out.println("Enter the value:");
				int ele = Integer.parseInt(br.readLine());
				queue.Enqueue(ele);
				queue.showQueue();
				break;
			case 2:
				queue.Dequeue();
				queue.showQueue();
				break;
			case 3:
				queue.getSize();
				break;
			case 4:
				queue.getFront();
				break;
			case 5:
				queue.getRear();
				break;
			case 6:
				queue.reverseQueue();
				break;
			case 7:
				System.out.println("Exit from the exection");
				start = false;
				break;
			default:
				System.out.println("Wrong enttry! Please try again");
				break;
			}
		}

	}

	static class ListNode {
		private int data;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}

		public void setData(int data) {
			this.data = data;
		}

		public int getData() {
			return this.data;
		}

		public void setNext(ListNode next) {
			this.next = next;
		}

		public ListNode getNext() {
			return this.next;
		}
	}

}