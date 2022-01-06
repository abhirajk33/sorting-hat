package com.vedantu.sorting.hat;
/*
      Binary tree to its sum tree.
*/

class Solution {
  
  class Node {
   
    int val;
    Node left;
    Node right;
    
    Node(Node left, Node right, int val){
      this.left = left;
      this.right = right;
      this.val = val;
    }
    
  }
  
/*
Input Tree:
           4
          / \
         2   1
        / \    
       3   9


Output Tree:
           19
          / \
         14   1
        / \    
       3   9
       
*/    
    
  Node sumTree(Node node) {
    
	  if(node == null) {
		  return null;
	  }
	  int sum = node.val;
	  sumTree(node.left);
	  sumTree(node.right);
	  
	  
	  if(node.left!= null) {
		  sum+= node.left.val;
	  }
	  
	  if(node.left!= null) {
		  sum+=  node.right.val;
	  }
	
	  node.val = sum;
//	  System.out.println(node.val);
	  return node;
    
    
  }
  
  public void postOrder(Node node) {
	  if(node == null) {
		  return;
	  }
	  postOrder(node.left);
	  
	  postOrder(node.right);
	  System.out.println(node.val);
  }
  
  public Node getTree() {
    Node root = new Node(null, null, 4);
    root.left = new Node(null, null, 2);
    root.left.left = new Node(null, null, 3);
    root.left.right = new Node(null, null, 9);
    root.right = new Node(null, null, 1);
    Node sumTreeRoot = root;
    return sumTreeRoot;
//    System.out.println(sumTreeRoot.val);
//    System.out.println(sumTreeRoot.left.val);
//    System.out.println(sumTreeRoot.left.left.val);
//    System.out.println(sumTreeRoot.left.right.val);
//    System.out.println(sumTreeRoot.right.val);
    
  }
  
  public static void main(String[] args) {
    Solution s = new Solution();
    Node node = s.getTree();
    s.postOrder(node);
    
    System.out.println();
    s.sumTree(node);
    
    System.out.println();
    s.postOrder(node);
    
  }
}
