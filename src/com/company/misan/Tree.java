package com.company.misan;


import java.util.ArrayList;

public class Tree {
    private Node root;

   public Node insert(int value){
       var node = new Node(value);
       if(root == null){
           root = node;
           return root;
       }
       var current = root;
       while (true){
           if(node.value > current.value){
               if(current.rightChild == null){
                   current.rightChild = node;
                   break;
               }
               current = current.rightChild;
           }else{
               if(current.leftChild == null){
                   current.leftChild = node;
                   break;
               }
               current = current.leftChild;
           }
       }
       return root;
   }

   public boolean find(int target){
       var current = root;
       while (current != null){
           if (current.value == target ) return true;
           else if(target > current.value) current = current.rightChild;
           else  current = current.leftChild;
       }
       return false;
   }

    public void  traversePreOrder(){
       traversePreOrder(root);
   }
    public void  traverseInOrder(){
        traverseInOrder(root);
    }
    public void  traversePostOrder(){
        traversePostOrder(root);
    }

    public int height(){
       return height(root);
    }
    public int min(){ return min(root);}
    public int minBinarySearchTree(){
       return minBinarySearchTree(root);
    }
    public ArrayList<Integer> getNodesAtDistanceK(int distance){
       var list = new ArrayList<Integer>();
        getNodesAtDistanceK(root, distance, list);
        return list;
    }

    public boolean equals(Tree other){
       if (other == null) return  false;
       return equals(root, other.root);
    }

    public boolean validateBinarySearchTree(){
       return validateBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public void swapRoot(){
       var temp = root.leftChild;
       root.leftChild = root.rightChild;
       root.rightChild = temp;
    }

    public int size(){
       return size(root);
    }

    public int maxRecursion(){
       return maxRecursion(root);
    }

    public int countLeaves(){
       return countLeaves(root);
    }

    public int countLeaves(Node root){
       if(root == null) return 0;

       if(isLeaf(root)) return 1;
       return countLeaves(root.leftChild) + countLeaves(root.rightChild);
    }

    public boolean contains(int value) {
        return contains(root, value);
    }


    private int maxRecursion(Node root){
       if (root == null) return 0;
       if(root.rightChild == null) return root.value;
       return maxRecursion(root.rightChild);
    }

    private boolean contains(Node root, int value) {
        if (root == null)
            return false;

        if (root.value == value)
            return true;

        return contains(root.leftChild, value) || contains(root.rightChild, value);
    }

    private int size(Node root){
       if(root  == null) return 0;

       return 1 + (size(root.leftChild) + size(root.rightChild));
    }

    private void getNodesAtDistanceK(Node root, int distance, ArrayList<Integer> list){

       if(root == null) return;
       if(distance == 0){
           list.add(root.value);
           return;
       }

       getNodesAtDistanceK(root.leftChild, distance - 1, list);
       getNodesAtDistanceK(root.rightChild, distance - 1, list);
    }

    private boolean validateBinarySearchTree(Node root, int lowerBound, int upperBound){
       if(root == null)  return true;
       return  (root.value>lowerBound && root.value< upperBound) && validateBinarySearchTree(root.leftChild, Integer.MIN_VALUE, root.value) &&
               validateBinarySearchTree(root.rightChild, root.value, upperBound );
    }

    private boolean equals(Node first, Node second){
       if(first == null && second == null) return true;
       if(first != null && second != null)
           return  first.value == second.value && equals(first.leftChild, second.leftChild)
           && equals(first.rightChild, second.rightChild);

       return  false;
    }

   private void traversePreOrder(Node root){
       if (root == null) return;
       System.out.println(root.value);
       traversePreOrder(root.leftChild);
       traversePreOrder(root.rightChild);
   }

   private void traverseInOrder(Node root){
       if(root == null) return;
       traverseInOrder(root.leftChild);
       System.out.println(root.value);
       traverseInOrder(root.rightChild);
   }

   private void traversePostOrder(Node root){
       if (root == null) return;
       traversePostOrder(root.leftChild);
       traversePostOrder(root.rightChild);
       System.out.println(root.value);
   }

   private int height(Node root){
       if(root == null) return -1;
       if(root.leftChild == null && root.rightChild == null) return 0;
       return 1 + Math.max(height(root.leftChild), height(root.rightChild));
   }

     private int min(Node root){
         if (isLeaf(root)) return root.value;
         var left = min(root.leftChild);
         var right = min(root.rightChild);
         return Math.min(Math.min(left, right), root.value);
     }

    private int minBinarySearchTree(Node root){
         while (root.leftChild != null) {
             root = root.leftChild;
         }
         return (root.value);
     }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    public void traverseLevelOrder(){
       for(var i = 0; i <= height(); i++){
           for(var list: getNodesAtDistanceK(i)){
               System.out.println(list);
           }
       }
    }


    private class Node {
        int value;
        Node leftChild;
        Node rightChild;

        public Node(int value) {
            this.value = value;
        }

    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}
