
public class BinaryTree<KeyType, ValueType> {
	
	protected class BinNode {
		KeyType key;
		ValueType value;
		BinNode left, right;
		int height;
		
		public BinNode(KeyType k, ValueType v) {
			key = k;
			value = v;
			height = 1;
		}
	}
	
	BinNode root;

	public int size() {
		// TODO: using the function 'size(BinNode x)', implement function
		// that computes the total number of elements in a tree
		
		return size(root);
	}
	
	private int size(BinNode x) { 
		// TODO: implement function that recursively computes the number of
		// elements in the tree rooted at x
		if(x==null){
			return 0;
		}
		else if((x.left==null) && (x.right==null)){
			return 1;
		}
		else if(x.left==null){
			return 1+size(x.right);
		}
		else if (x.right==null){
			return 1+size(x.left);
		}
		else{
			return (size(x.left)+size(x.right))+1;
		}
	}

	// NOTE: Later on, traversals should be implemented as iterators!
	
	public void print_inorder_traversal(){
		print_inorder_traversal(root);
	}
	
	public void print_preorder_traversal(){
		print_preorder_traversal(root);
	}
	
	public void print_postorder_traversal(){
		print_postorder_traversal(root);
	}
	
	
	// 1st visit: prefix=preorder
	// 2nd visit: postfix=postorder
	// 3rd visit: infix=inorder
	private void print_inorder_traversal(BinNode x){
		// TODO: implement an in-order traversal of the tree
		if(x==null){
			return;
		}
		
		print_inorder_traversal(x.left);
		System.out.println(x.key + " | " + x.value);
		print_inorder_traversal(x.right);
		return;
	}
	
	// TODO: implement similar functions for prefix and postfix traversal
	
	private void print_preorder_traversal(BinNode x){
		// TODO: implement an pre-order traversal of the tree
		if(x==null){
			return;
		}
		
		System.out.println(x.key + " | " + x.value);
		print_preorder_traversal(x.left);
		print_preorder_traversal(x.right);
		return;
	}
	
	
	private void print_postorder_traversal(BinNode x){
		// TODO: implement an post-order traversal of the tree
		if(x==null){
			return;
		}
		
		print_postorder_traversal(x.left);
		print_postorder_traversal(x.right);
		System.out.println(x.key + " | " + x.value);
		return;
	}
	
	
	// TODO: instead of printing out the traversal, have it return a list (hard)
	
	
	
}