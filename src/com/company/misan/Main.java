package com.company.misan;

public class Main {

    public static void main(String[] args) {

        var tree = new Tree();
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
        tree.insert(10);




        System.out.println(tree.find(10));
        tree.traversePostOrder();
        tree.swapRoot();
        System.out.println(tree.getNodesAtDistanceK(7).toString());
        tree.traverseLevelOrder();
        System.out.println(tree.size());
        System.out.println(tree.countLeaves());
        System.out.println(tree.maxRecurision());


    }
}
