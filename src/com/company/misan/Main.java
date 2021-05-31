package com.company.misan;

import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        var tree = new BinarySearchTree();
//        int[] array = {20, 10, 30, 6, 14, 24, 3, 8, 26};
//        for (int j : array) {
//            tree.insert(j);
//        }

        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);

//        System.out.println(tree.toString());
        System.out.println(tree.find(15));
//        tree.traversePreOrder();
        System.out.println(tree.height());
        System.out.println(tree.min());


    }
}
