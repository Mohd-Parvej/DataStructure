package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedStack {
	private int length = 0;

	public ListNode push(int data, ListNode top) {
		ListNode node = new ListNode(data);
		node.setNext(top);
		top = node;
		length++;
		return top;
	}

	public ListNode pop(ListNode top) {
		if (top == null)
			return top;
		int result = top.getData();
		System.out.println("Removed " + result);
		top = top.getNext();
		length--;
		return top;
	}

	public void showStack(ListNode top) {
		if (top == null) {
			System.out.println("Stack is empty!");
			return;
		}
		ListNode end = top;
		while (end != null) {
			System.out.printf("%d -> ", end.getData());
			end = end.getNext();
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		ListNode top = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean start = true;
		LinkedStack stack = new LinkedStack();
		while (start) {
			System.out.println("1. Push\n2. Pop");
			System.out.println("Please select above choices");
			int choice = Integer.parseInt(br.readLine());
			switch (choice) {
			case 1:
				System.out.println("Please enter an element:");
				int ele = Integer.parseInt(br.readLine());
				top = stack.push(ele, top);
				stack.showStack(top);
				break;
			case 2:
				top = stack.pop(top);
				stack.showStack(top);
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
			this.next = null;
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
	}

}
