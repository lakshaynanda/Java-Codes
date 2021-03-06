package Lecture18;

public class BST {
	private class Node {
		int data;
		Node left;
		Node right;

		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private int size;
	private Node root;

	BST() {
		this.root = null;
		this.size = 0;
	}

	public BST(int... sortedArray) {
		this.root = construct(sortedArray, 0, sortedArray.length - 1);
	}

	private Node construct(int[] sa, int si, int li) {
		if (si > li) {
			return null;
		}
		int mid = (si + li) / 2;

		Node node = new Node(sa[mid], null, null);
		this.size++;

		node.left = construct(sa, si, mid - 1);
		node.right = construct(sa, mid + 1, li);

		return node;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void add(int data) {
		if (this.isEmpty()) {
			this.root = new Node(data, null, null);
			this.size++;
		} else {
			this.add(this.root, data);
		}
	}

	private void add(Node node, int data) {
		if (data > node.data) {
			if (node.right == null) {
				node.right = new Node(data, null, null);
				this.size++;
			} else {
				add(node.right, data);
			}
		} else if (data < node.data) {
			if (node.left == null) {
				node.left = new Node(data, null, null);
				this.size++;
			} else {
				add(node.left, data);
			}
		}
	}

	public void display() {
		this.display(this.root);
	}

	private void display(Node node) {
		if (node.left != null) {
			System.out.print(node.left.data + "=>");
		} else {
			System.out.print("END=>");
		}
		System.out.print(node.data);
		if (node.right != null) {
			System.out.print("<=" + node.right.data);
		} else {
			System.out.print("<=END");
		}
		System.out.println();
		if (node.left != null) {
			display(node.left);
		}
		if (node.right != null) {
			display(node.right);
		}
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		if (node.right == null) {
			return node.data;
		}
		return max(node.right);
	}

	public int min() {
		return this.min(this.root);
	}

	private int min(Node node) {
		if (node.left == null) {
			return node.data;
		}
		return min(node.left);
	}

	public void remove(int data) {
		this.root = this.remove(this.root, data);
	}

	private Node remove(Node node, int data) {
		if (node == null) {
			return null;
		}
		if (data > node.data) {
			node.right = remove(node.right, data);
			return node;
		} else if (data < node.data) {
			node.left = remove(node.left, data);
			return node;
		} else {
			if (node.left == null && node.right == null) {
				this.size--;
				return null;
			} else if (node.left == null) {
				this.size--;
				return node.right;
			} else if (node.right == null) {
				this.size--;
				return node.left;
			} else {
				int lmax = max(node.left);
				node.data = lmax;
				node.left = this.remove(node.left, lmax);
				return node;
			}
		}
	}

}
