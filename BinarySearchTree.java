public class BinarySearchTree {
	private class Node {
		int key;
		Node left;
		Node right;

		public Node(int item) {
			this.key = item;
		}
	}

	private Node root;

	public BinarySearchTree() {

	}

	public BinarySearchTree(int key) {
		this.root = new Node(key);
	}

	public void insert(int key) {
		root = insertItem(root, key);
	}
	
	public void delete(int key) {
		root = deleteRec(root, key);
	}

	private Node deleteRec(Node node, int key) {
		if (node == null) {
			return node;
		}
		if (node.key < key) {
			root.right = deleteRec(node.right, key);
		} else if (node.key > key) {
			root.left = deleteRec(node.left, key);
		} else {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			}
			
			node.key = minValue(node.right);
			node.right = deleteRec(node.right, node.key);
		}
		return node;
	}
	
	private int minValue(Node node) {
		int ret = node.key;
		while (node.left != null) {
			node = node.left;
			ret = node.key;
		}
		return ret;
	}

	private Node insertItem(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		} else if (root.key > key) {
			root.left = insertItem(root.left, key);
		} else if (root.key < key) {
			root.right = insertItem(root.right, key);
		}

		return root;
	}

	private void inorder() {
		inorderRec(root);
	}

	private void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.key);
			inorderRec(root.right);
		}
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.inorder();
	}
}
