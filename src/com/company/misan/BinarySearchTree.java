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
