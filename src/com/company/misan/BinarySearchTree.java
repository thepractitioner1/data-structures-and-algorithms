package com.company.misan;

import java.util.Arrays;

public class BinarySearchTree {
    private Node root;

    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
        } else {
            var current = root;
            while (true) {
                if (value > current.value) {
                    if (current.rightChild == null) {
                        current.rightChild = node;
                        break;
                    }
                    current = current.rightChild;
                } else {
                    if (current.leftChild == null) {
                        current.leftChild = node;
                        break;
                    }
                    current = current.leftChild;
                }
            }
        }
    }

    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value > current.value) {
                current = current.rightChild;
            } else if (value < current.value) {
                current = current.leftChild;
            } else {
                return true;
            }
        }
        return false;
    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    public void traverseInOrder(){
        traverseInOrder(root);
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }

    public int height(){
        return height(root);
    }

    public int min(){
        return min(root);
    }

    private void traverseInOrder( Node root){
        if(root == null) return;
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    private void traversePostOrder( Node root){
        if(root == null) return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    private void traversePreOrder(Node root) {
        if(root == null) return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

     private int height(Node root){
        if(root == null) return -1;
         if (isLeaf(root)) return 0;
         return 1 + Math.max(height(root.leftChild), height(root.rightChild));
     }

     private int min(Node root){
         if (isLeaf(root)) return root.value;
         var left = min(root.leftChild);
         var right = min(root.rightChild);
         return Math.min(Math.min(left, right), root.value);
     }

     int minBinarySearchTree(Node root){
         while (root.leftChild != null) {
             root = root.leftChild;
         }
         return (root.value);
     }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
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
