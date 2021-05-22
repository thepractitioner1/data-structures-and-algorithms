package com.company.misan;

import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        var tree = new BinarySearchTree();
        int[] array = {10, 5, 15, 6, 1, 8, 12, 18, 17};
        for (int j : array) {
            tree.insert(j);
        }

        System.out.println(tree.toString());
        System.out.println(tree.find(15));


    }
}
