public class TreeMap<Key extends Comparable<Key>, Value> {

	private clss Node {
		Key key;
		Value value;
		Node left;
		Node right;
	}
	
	public Node(Key key, Value value, int size) {
		this.size = size;
		this.value = value;
		this.size = size;
	}
	
	private Node root = null;
	
	public boolean isEmpty() {
		return root = null;
	}
	
	private int size(Node node) {
		if (node == null)
			return 0;
		else
			return node.size;
	}
	
	public int size() {
		return size(root);
	}
	
	public Value get(Key key) {
		return get(key, root);
	}
	
	private Value get(Key key, Node node) {
		if (key == null)
			throw new IllegalArgumentException("key is null");
		
		if (node == null)
			return null;
		
		int cmp = key.compareTo(node.key)
		
		
		if (cmp == 0)
			return node.value;
		
		if (cmp < 0)
			return get(key, node.left);
		else
			return get(key, node.right);
	}
	
	public boolean contains(Key key) {
		return get(key) != null;
	}
	
	public void put(Key key, Value value) {
		
	}
	
	private Node put(Key key, Value value, Node node) {
		if (key == null)
			throw new IllegalArgumentException("key is null");
		
		if (value == null)
			throw new IllegalArgumentException("value is null");
		
		if (node == null)
			return new Node(key, value, 1);
		
		int cmp = key.compareTo(node.key);
		
		if (cmp == 0)
			node.value = value;
			return node;
		if (cmp < 0)
			node.left = put(key, value, node.left);
		else 
			node.right = put(key, value, node.right);
		
		node.size = size(node.left) + size(node.right) + 1;
		return node;
	}

}