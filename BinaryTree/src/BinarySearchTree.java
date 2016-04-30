
// KeyType now has to be Comparable!
public class BinarySearchTree<KeyType extends Comparable<KeyType>, ValueType>
	 extends BinaryTree<KeyType, ValueType> {

	public void insert(KeyType k, ValueType v){
		root = insert(root, k, v);
	}
	
	private BinNode insert(BinNode x, KeyType k, ValueType v){
		if (x == null) {
			return new BinNode(k, v);
		}
		
		int cmp = k.compareTo(x.key);
		
		if(cmp < 0){
			x.left  = insert(x.left, k, v); // x is smaller
		}
		else if (cmp > 0){
			x.right = insert(x.right, k, v); // x is larger
		}
		else{
		// we don't allow duplicate keys so if cmp == 0
		// we update the value of the existing node
			x.value = v;
		}
		// Update height if the height of this tree grew by the insertion
		if(getHeight(x) > x.height){
			x.height++;
		}
		// return the node so the parent can modify its child
		return x;
	}
	
	public ValueType search(KeyType k) {
		return search(root, k);
	}
	
	private ValueType search(BinNode x, KeyType k) {
		if(x == null) 
			return null;
		
		int cmp = k.compareTo(x.key);
		
		if(cmp < 0) 
			return search(x.left,  k); // x is smaller
		else if(cmp > 0) 
			return search(x.right, k); // x is larger
		else
			return x.value;
	}
	
	public KeyType getMinimumKey() throws NullPointerException{
		if(root == null){
			throw new NullPointerException("ERROR: Empty Tree!!");
		}
		return getMinimumNode(root).key;
	}
	
	private BinNode getMinimumNode(BinNode tree){
		if(tree == null){
			return tree;
		}
		
		BinNode node = tree;
		while(node.left != null){
			node = node.left;
		}
		return node;
	}
	
	
	// Compute the height of a given tree without using height valuable of BinNode
	// This method is needed when a tree has to update its height for each node after insertion/rotation
	// This method uses recursive algorithm.
	private int getHeight(BinNode tree){
		if(tree == null){
			return 0;
		}
		
		int leftHeight = getHeight(tree.left);
		int rightHeight = getHeight(tree.right);
		
		if(leftHeight >= rightHeight){
			return leftHeight+1;
		}
		else{
			return rightHeight+1;
		}
	}
	
	// Method for Test: getting height using height valuable of BinNode class
	public int getHeight1(){
		if(root == null){
			return 0;
		}
		return root.height;
	}
	// Method for Test: getting height using private int getHeight(BinNode tree) method
	public int getHeight2(){
		return getHeight(root);
	}
	
	
	public void rotateRight(){
		root = rotateRight(root);
	}
	
	private BinNode rotateRight(BinNode x){
		if(x == null){
			return null;
		}
		// If root has no left node, rotate right does nothing
		// so it just returns the root and the tree keeps the same shape as before
		if(x.left == null){
			return x;
		}
		
		BinNode pivot = x.left;
		x.left = pivot.right;
		pivot.right = x;
		
		// updating each height
		// with one rotation, only these two heights have chance to change
		// others should remain the same
		pivot.height = getHeight(pivot);
		x.height = getHeight(x);
		
		return pivot;
	}
	
	
	public void rotateLeft(){
		root = rotateLeft(root);
	}
	
	private BinNode rotateLeft(BinNode x){
		if(x == null){
			return null;
		}
		// If root has no right node, rotate left does nothing
		// so it just returns the root and the tree keeps the same shape as before
		if(x.right == null){
			return x;
		}
		
		BinNode pivot = x.right;
		x.right = pivot.left;
		pivot.left = x;
		
		// updating each height
		// with one rotation, only these two heights have chance to change
		// others should remain the same
		pivot.height = getHeight(pivot);
		x.height = getHeight(x);
				
		return pivot;
	}
	
	
	// Return the String that tells the height of root and its sub nodes (left and right of the root).
	// This method is created just for test purpose.
	public String getHeightReport(){
		if(root == null){
			return "The Height of root: " + 0 + "\nThe Height of root.left: Not Available" + 
					"\nThe Height of root.right: Not Available";
		}
		else if((root.right == null) && (root.left == null)){
			return "The Height of root: " + root.height + "\nThe Height of root.left: " + 0 + 
					"\nThe Height of root.right: " + 0;
		}
		else if(root.right == null){
			return "The Height of root: " + root.height + "\nThe Height of root.left: " + root.left.height + 
					"\nThe Height of root.right: " + 0;
		}
		else if(root.left == null){
			return "The Height of root: " + root.height + "\nThe Height of root.left: " + 0 + 
					"\nThe Height of root.right: " + root.right.height;
		}
		else{
			return "The Height of root: " + root.height + "\nThe Height of root.left: " + root.left.height + 
					"\nThe Height of root.right: " + root.right.height;
		}
	}
	
}
