package com.company.misan;

public class Main {

    public static void main(String[] args) {

        var tree = new BinarySearchTree();
        Integer[] myArray = new Integer[] {1, 7, 5, 9, 2, 12, 3};
        int difference = 2;
        int result = HashTableExercises.countPairsWithDiff(myArray, difference);
        System.out.println(result);

        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(0);




        System.out.println(tree.find(10));
        tree.traversePostOrder();
        System.out.println(tree.min());


    }
}
