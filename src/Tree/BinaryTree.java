package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @uther Parej
 */

public class BinaryTree {
	private BinaryTreeNode root;

	// creating binary tree node
	public void insertNode(int data) {
		// creating an object of binary tree
		BinaryTreeNode node = new BinaryTreeNode(data);
		if (root == null) {
			root = node;
			// making node as root node
			return;
		} else {
			Queue q = new Queue();
			// creating queue object
			q.offer(root);
			// inserting root element in queue
			q.offer(null);
			while (!q.isEmpty()) {
				// checking queue is empty or not
				BinaryTreeNode tmp = q.poll();
				// removing an element from queue
				if (tmp.left != null)
					q.offer(tmp.left);
				// inserting left element if not null
				else {
					tmp.left = node;
					// adding node as a left node of tree
					return;
				}
				if (tmp.right != null)
					q.offer(tmp.right);
				// inserting right element if not null
				else {
					tmp.right = node;
					// adding node as a right node of tree
					return;
				}
			}
		}
	}

	public BinaryTreeNode getRoot() {
		return root;
		// getting root of the tree
	}

	public void preOrder(BinaryTreeNode rootNode) {
		if (rootNode != null) {
			System.out.printf("%d ", rootNode.getData());
			// printing node data
			preOrder(rootNode.getLeft());
			// recursive calling with left child
			preOrder(rootNode.getRight());
			// recursive calling with right child
		}
	}

	public void inOrder(BinaryTreeNode rootNode) {
		if (rootNode != null) {
			inOrder(rootNode.getLeft());
			System.out.printf("%d ", rootNode.getData());
			inOrder(rootNode.getRight());
		}
	}

	public void postOrder(BinaryTreeNode rootNode) {
		if (rootNode != null) {
			postOrder(rootNode.getLeft());
			postOrder(rootNode.getRight());
			System.out.printf("%d ", rootNode.getData());
		}
	}

	public void levelOrderTraversal(BinaryTreeNode rootNode) {
		Queue q = new Queue();
		if (root == null) {
			System.out.println("Empty tree!");
			// if tree has no element
			return;
		}
		q.offer(root);
		// inserting root node in the queue
		q.offer(null);
		// inserting null for level
		while (!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			// taking/removing head element from queue
			if (tmp != null) {
				System.out.printf("%d ", tmp.getData());
				// printing node data
				if (tmp.getLeft() != null)
					q.offer(tmp.getLeft());
				// inserting left child of tmp node in queue
				if (tmp.getRight() != null)
					q.offer(tmp.getRight());
				// inserting right child of tmp node in queue
			} else {
				if (!q.isEmpty())
					q.offer(null);
				// inserting null for next level
			}
		}
	}
	
	public void findNode(int data) {
		Queue q = new Queue();
		if (root == null) {
			System.out.println("Empty tree!");
			// if tree has no element
			return;
		}
		q.offer(root);
		// inserting root node in the queue
		q.offer(null);
		// inserting null for level
		while (!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			// taking/removing head element from queue
			if (tmp != null) {
				if(tmp.getData() == data) {
					System.out.println(data+ " exists in the tree.\n");
					return;
				}
				// printing node data
				if (tmp.getLeft() != null)
					q.offer(tmp.getLeft());
				// inserting left child of tmp node in queue
				if (tmp.getRight() != null)
					q.offer(tmp.getRight());
				// inserting right child of tmp node in queue
			} else {
				if (!q.isEmpty())
					q.offer(null);
				// inserting null for next level
			}
		}
		System.out.printf(data+ " doesn't exists in the tree.\n");
	}
	
	public void findMax() {
		int max = Integer.MIN_VALUE;
		Queue q = new Queue();
		if (root == null) {
			System.out.println("Empty tree!");
			// if tree has no element
			return;
		}
		q.offer(root);
		// inserting root node in the queue
		q.offer(null);
		// inserting null for level
		while (!q.isEmpty()) {
			BinaryTreeNode tmp = q.poll();
			// taking/removing front element from queue
			if (tmp != null) {
				if(max < tmp.getData())
					max = tmp.getData();
				if (tmp.getLeft() != null)
					q.offer(tmp.getLeft());
				// inserting left child of tmp node in queue
				if (tmp.getRight() != null)
					q.offer(tmp.getRight());
				// inserting right child of tmp node in queue
			} else {
				if (!q.isEmpty())
					q.offer(null);
				// inserting null for next level
			}
		}
		System.out.println("Maximum element in the tree: " +max);
	}
	
	public int BTSize(BinaryTreeNode rootNode) {
		if(rootNode == null)
			return 0;
		else
			return (BTSize(rootNode.getLeft()) + 1 + BTSize(rootNode.getRight()));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BinaryTree btree = new BinaryTree();
		// creating an object of BinaryTree class for calling functions
		boolean start = true;
		while (start) {
			System.out.println(
					"1. Insert node in Binary tree\n2. PreOrder traversal\n3. InOrder traversal\n4. PostOrder traversal\n"
							+ "5. Level Order traversal\n6. Get the root node\n7. Find the matching node\n8. Max element"
							+"\n9. Size of Binary tree");
			System.out.println("Please select above choice:");
			int choice = Integer.parseInt(br.readLine());
			// taking user choice
			switch (choice) {
			case 1:
				System.out.println("Enter the node value:");
				int node = Integer.parseInt(br.readLine());
				// taking user input as a node to add in a binary tree
				btree.insertNode(node);
				break;
			case 2:
				System.out.println("PreOrder traversal:");
				btree.preOrder(btree.getRoot());
				System.out.println("\n");
				break;
			case 3:
				System.out.println("InOrder traversal:");
				btree.inOrder(btree.getRoot());
				System.out.println("\n");
				break;
			case 4:
				System.out.println("PostOrder traversal:");
				btree.postOrder(btree.getRoot());
				System.out.println("\n");
				break;
			case 5:
				System.out.println("Level Order traversal:");
				btree.levelOrderTraversal(btree.getRoot());
				System.out.println("\n");
				break;
			case 6:
				System.out.printf("root -> %d\n\n", btree.getRoot().getData());
				break;
			case 7:
				System.out.println("Please enter the node value which you want to search in the tree:");
				node = Integer.parseInt(br.readLine());
				btree.findNode(node);
				break;
			case 8:
				btree.findMax();
				break;
			case 9:
				int size = btree.BTSize(btree.getRoot());
				System.out.println("Size of Binary tree: " +size);
				break;
			default:
				System.out.println("Wrong entry! please try again.");
				break;
			}
		}

	}

	static class BinaryTreeNode {
		private int data;
		private BinaryTreeNode left;
		private BinaryTreeNode right;
		public BinaryTreeNode next;

		public BinaryTreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
		}

		public void setData(int data) {
			this.data = data;
		}

		public int getData() {
			return this.data;
		}

		public void setLeft(BinaryTreeNode left) {
			this.left = left;
		}

		public BinaryTreeNode getLeft() {
			return this.left;
		}

		public void setRight(BinaryTreeNode right) {
			this.right = right;
		}

		public BinaryTreeNode getRight() {
			return this.right;
		}
	}

	static class Node {
		Node root;
		Node next;

		public Node(Node root) {
			this.root = root;
		}
	}

	class Queue {
		BinaryTreeNode front;
		BinaryTreeNode rear;
		public void offer(BinaryTreeNode root) {
			if (front == null) {
				front = rear = root;
				return;
			}
			rear.next = root;
			rear = root;
		}

		public BinaryTreeNode poll() {
			if (front == null)
				return front;
			BinaryTreeNode node = front;
			front = front.next;
			return node;
		}

		public boolean isEmpty() {
			return front == null;
		}
	}
}
