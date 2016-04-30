//---------------------------------------------------------------------------------------------------------------
// This main tests the methods in BinarySearchTree class.
// There are two test trees with which I tested:
// 	1st tree: containing 3 nodes and well balanced. [10(root's left) 20(root) 30(root's right)]
//  2nd tree: containing 5 nodes and not well balanced. [10, 20(root's left), 25, 30(root), 40(root's right)]
// I applied several rotations to each tree and checked its height of nodes and shape.
// Please run the main for the detail of outputs. Thank you.
//
// Date: June 22nd, 2014
// Student Name: Naoya Hayashi
// SFU ID: 301233985
// Computing ID: nhayashi
//
// Course: CMPT 225 E100
// Homework #7: Binary Search Tree
// Instructor: Jeremie Lumbroso
// TA    : Kamyar Khodamoradi
//---------------------------------------------------------------------------------------------------------------

public class Main {
	public static void main(String[] args)
	{
		BinarySearchTree<Integer, String> students1 = new BinarySearchTree<Integer, String>();
		
		System.out.println("Output to demonstrate methods in BinaryTree and BinarySearchTree classes.\n");
		
		students1.insert(20, "Bashir");
		students1.insert(10, "John");
		students1.insert(30, "Ramira");
		
		assert(students1.search(10) == "John");
		assert(students1.search(20) == "Bashir"); 
		assert(students1.search(30) == "Ramira");
		
		
		int n = students1.size();
		System.out.println("The size of the tree is " + n + ".");
		System.out.println();
		
		System.out.println("INFIX Order");
		students1.print_inorder_traversal();
		System.out.println();
		
		System.out.println("PREFIX Order");
		students1.print_preorder_traversal();
		System.out.println();
		
		/*
		System.out.println("POSTFIX Order");
		students1.print_postorder_traversal();
		System.out.println();
		*/
		
		System.out.println(students1.getHeightReport());
		
		students1.rotateRight();
		System.out.println("-----Right Rotation-----");
		
		System.out.println("INFIX Order");
		students1.print_inorder_traversal();
		System.out.println();
		
		System.out.println("PREFIX Order");
		students1.print_preorder_traversal();
		System.out.println();
		
		/*
		System.out.println("POSTFIX Order");
		students1.print_postorder_traversal();
		System.out.println();
		*/
		
		System.out.println(students1.getHeightReport());
		
		students1.rotateLeft();
		System.out.println("-----Left Rotation-----");
		
		System.out.println("INFIX Order");
		students1.print_inorder_traversal();
		System.out.println();
		
		System.out.println("PREFIX Order");
		students1.print_preorder_traversal();
		System.out.println();
		
		/*
		System.out.println("POSTFIX Order");
		students1.print_postorder_traversal();
		System.out.println();
		*/
		
		System.out.println(students1.getHeightReport());
		System.out.println();
		
		students1.rotateLeft();
		System.out.println("-----Left Rotation-----");
		
		System.out.println("INFIX Order");
		students1.print_inorder_traversal();
		System.out.println();
		
		System.out.println("PREFIX Order");
		students1.print_preorder_traversal();
		System.out.println();
		
		System.out.println(students1.getHeightReport());
		System.out.println();
		
		students1.rotateLeft();
		System.out.println("-----Left Rotation-----");
		System.out.println("**Note: This rotation doesn't change the shape of the tree because " + 
				"the root doesn't have a right node.");
		
		System.out.println("INFIX Order");
		students1.print_inorder_traversal();
		System.out.println();
		
		System.out.println("PREFIX Order");
		students1.print_preorder_traversal();
		System.out.println();
		
		System.out.println(students1.getHeightReport());
		System.out.println();
		
		//----------------------------------------- Testing with Another Tree below --------------------------------------
		
		System.out.println("--------------------------Testing with Another Tree--------------------------");
		
		BinarySearchTree<Integer, String> students2 = new BinarySearchTree<Integer, String>();
		
		students2.insert(20, "Bashir");
		students2.insert(10, "John");
		students2.insert(30, "Ramira");
		students2.insert(40, "Kimmy");
		students2.insert(25, "Mike");
		// intentionally overwriting the value in the node with key 25
		// so that I can check if it has any effect on height variables
		students2.insert(25, "Kate");
		
		assert(students2.search(10) == "John");
		assert(students2.search(20) == "Bashir"); 
		assert(students2.search(30) == "Ramira");
		assert(students2.search(40) == "Kimmy");
		assert(students2.search(25) == "Kate");
		
		n = students2.size();
		System.out.println("The size of the tree is " + n + ".");
		System.out.println();
		
		System.out.println("INFIX Order");
		students2.print_inorder_traversal();
		System.out.println();
		
		System.out.println("PREFIX Order");
		students2.print_preorder_traversal();
		System.out.println();
		
		/*
		System.out.println("POSTFIX Order");
		students2.print_postorder_traversal();
		System.out.println();
		*/
		
		System.out.println(students2.getHeightReport());
		System.out.println();
		
		students2.rotateLeft();
		System.out.println("-----Left Rotation-----");
		
		System.out.println("INFIX Order");
		students2.print_inorder_traversal();
		System.out.println();
		
		System.out.println("PREFIX Order");
		students2.print_preorder_traversal();
		System.out.println();
		
		/*
		System.out.println("POSTFIX Order");
		students2.print_postorder_traversal();
		System.out.println();
		*/
		
		System.out.println(students2.getHeightReport());
		System.out.println();
		
		students2.rotateLeft();
		System.out.println("-----Left Rotation-----");
		
		System.out.println("INFIX Order");
		students2.print_inorder_traversal();
		System.out.println();
		
		System.out.println("PREFIX Order");
		students2.print_preorder_traversal();
		System.out.println();
		
		/*
		System.out.println("POSTFIX Order");
		students2.print_postorder_traversal();
		System.out.println();
		*/
		
		System.out.println(students2.getHeightReport());
		System.out.println();
		
		students2.rotateRight();
		System.out.println("-----Right Rotation-----");
		
		System.out.println("INFIX Order");
		students2.print_inorder_traversal();
		System.out.println();
		
		System.out.println("PREFIX Order");
		students2.print_preorder_traversal();
		System.out.println();
		
		/*
		System.out.println("POSTFIX Order");
		students2.print_postorder_traversal();
		System.out.println();
		*/
		
		System.out.println(students2.getHeightReport());
		System.out.println();
	}
}