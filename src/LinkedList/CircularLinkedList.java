package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CircularLinkedList {
	
	private int length = 0;
	
	public CLLNode addToHead(int data, CLLNode tail) {
		CLLNode temp = new CLLNode(data);
		if(tail == null) {
			tail = temp;
			tail.setNext(tail);
		} else {
			temp.setNext(tail.getNext());
			tail.setNext(temp);
		}
		length++;
		return tail;
	}
	
	public CLLNode addToTail(int data, CLLNode tail) {
		tail = addToHead(data, tail);
		tail = tail.getNext();
		return tail;
	}
	
	public int getHead(CLLNode tail) {
		return tail.getNext().getData();
	}
	
	public int getTail(CLLNode tail) {
		return tail.getData();
	}
	
	public CLLNode removeFromHead(CLLNode tail) {
		if(tail == tail.getNext()) {
			tail = null;
			length--;
			return tail;
		}
		CLLNode temp = tail.getNext();
		tail.setNext(temp.getNext());
		length--;
		return tail;
	}
	
	public CLLNode removeFromTail(CLLNode tail) {
		if(tail == tail.getNext()) {
			tail = null;
			length--;
			return tail;
		}
		CLLNode temp = tail.getNext();
		while(temp.next != tail) 
			temp = temp.getNext();
		temp.setNext(tail.getNext());
		tail = temp;
		length--;
		return tail;
	}
	
	public void removeData(int data, CLLNode tail) {
		if(length == 0)
			return;
		CLLNode p = null, q = tail.getNext();
		int findEle = 0;
		while(q != tail) {
			p = q;
			if(data == q.getData()) {
				findEle = 1;
				break;
			}
			q = q.getNext();
		}
		if(findEle == 1 && (data == tail.getData())) {
			p.setNext(tail.getNext());
			tail = q;
			length--;
		} 
		else if(findEle == 1) {
			length--;
			p.setNext(q.getNext());
		} else
			System.out.println(data+" is not present in the list.");
	}
	
	public void showCLL(CLLNode tail) {
		if(length == 0) {
			System.out.println("List is empty!");
			return;
		}
		else if(length == 1) {
			System.out.printf("%d -> \n", tail.getData());
			return;
		}
		CLLNode temp, head = tail.getNext();
		System.out.printf("%d -> ", head.getData());
		temp = head.next;
		while(temp != head) {
			System.out.printf("%d -> ", temp.getData());
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		CLLNode tail = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean start = true;
		CircularLinkedList cList = new CircularLinkedList();
		
		while(start) {
			System.out.println("1. Add to head\n2. Add to tail\n3. Get head\n4. Get tail\n5. Remove from head\n6. Remove from tail\n7. Remove data");
			System.out.println("Please select above choice:");
			int choice = Integer.parseInt(br.readLine());
			
			switch(choice) {
			case 1:
				System.out.println("Enter the element:");
				int ele = Integer.parseInt(br.readLine());
				tail = cList.addToHead(ele, tail);
				cList.showCLL(tail);
				break;
			case 2:
				System.out.println("Enter the element:");
				ele = Integer.parseInt(br.readLine());
				tail = cList.addToTail(ele, tail);
				cList.showCLL(tail);
				break;
			case 3:
				System.out.printf("Head -> %d\n", cList.getHead(tail));
				break;
			case 4:
				System.out.printf("Tail -> %d\n", cList.getTail(tail));
				break;
			case 5:
				tail = cList.removeFromHead(tail);
				cList.showCLL(tail);
				break;
			case 6:
				tail = cList.removeFromTail(tail);
				cList.showCLL(tail);
				break;
			case 7:
				System.out.println("Enter an element which you want to remove:");
				ele = Integer.parseInt(br.readLine());
				cList.removeData(ele, tail);
				cList.showCLL(tail);
				break;
			}
		}

	}
	
	static class CLLNode {
		private int data;
		private CLLNode next;
		
		public CLLNode(int data) {
			this.data = data;
			next = null;
		}
		
		public void setData(int data) {
			this.data = data;
		}
		
		public int getData() {
			return this.data;
		}
		
		public void setNext(CLLNode next) {
			this.next = next;
		}
		
		public CLLNode getNext() {
			return this.next;
		}
	}

}
