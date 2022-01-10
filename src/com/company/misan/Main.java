package com.company.misan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
//        HashMap<Integer, Integer> cache = new HashMap<>();
//        cache.put(1,1);
//        cache.put(1,2);
//        System.out.println(cache);
//
//        var list = new LinkedList();
//        list.addFirst(20);
//        list.addLast(30);
//        list.addLast(40);
//        list.addLast(50);
//        list.deleteFirst();
//        list.deleteFirst();
//        list.deleteFirst();
//
//        var stack = new Stack();
//        list.deleteFirst();
//        System.out.println(Arrays.toString(list.toArray()));


//        var tree = new Tree();
//        Integer[] myArray = new Integer[] {1, 7, 5, 9, 2, 12, 3};
//        int difference = 2;
//        int result = HashTableExercises.countPairsWithDiff(myArray, difference);
//        System.out.println(result);

//        tree.insert(7);
//        tree.insert(4);
//        tree.insert(9);
//        tree.insert(1);
//        tree.insert(6);
//        tree.insert(8);
//        tree.insert(10);

//        var avlTrees = new AVLTrees();
//        avlTrees.insert(10);
//        avlTrees.insert(20);
//        avlTrees.insert(15);

//        System.out.println(tree.find(10));
//        tree.traversePostOrder();
//        tree.swapRoot();
//        System.out.println(tree.getNodesAtDistanceK(7).toString());
//        tree.traverseLevelOrder();
//        System.out.println(tree.size());
//        System.out.println(tree.countLeaves());
//        System.out.println(tree.maxRecurision());
//        System.out.println(DPUtils.fibronacci(7));
//        System.out.println(DPUtils.gridTraveler(18, 18));
//        var list = new ArrayList<>(Arrays.asList( 6, 14));
//        System.out.println(DPUtils.howSum(list,300));

//        int[] array = new int[]{10,5, 17,4, 22, 30, 12, 13};
//        MaxHeap.heapify(array);
//        System.out.println(Arrays.toString(array));
//        Heap heap = new Heap();
//        for (int i = 0; i<array.length; i++){
//            heap.insert(array[i]);
//        }
//        System.out.println(heap);
//        for(int i =0; i<array.length; i++){
////            System.out.println(i);
//            array [i] = heap.remove();
//        }
//        System.out.println(Arrays.toString(array));
//
//        System.out.println(MaxHeap.kthLargestElement(array, 8));



//        System.out.println(heap);
//        heap.remove();
//        System.out.println(heap);
//        heap.remove();
//        System.out.println(heap);


//        var trie = new Trie();
//        trie.insert("boy");
//        trie.insert("book");
//        trie.insert("border");
//        trie.insert("cat");
//        trie.insert("dog");
//        trie.insert("doctor");
//        trie.insert("picture");
//        trie.insert("finest");
//        trie.insert("figure");
//        trie.insert("pickle");
//
//        System.out.println(trie.contains("pickle"));
//        trie.remove("border");
//        System.out.println(trie.contains("boy"));
//        trie.remove("boy");
//        trie.remove("book");
//        System.out.println(trie.contains("boy"));
//        System.out.println(trie.contains("border"));
//        System.out.println(trie.findWords("bo"));


//
//        System.out.println(myBrowserHistory.back(1));
//        System.out.println(myBrowserHistory.forward(1));
//        myBrowserHistory.visit("linkedin.com");
//        System.out.println(myBrowserHistory.forward(2));
//        System.out.println(myBrowserHistory.back(2));


        Graph mygraph = new Graph();
        mygraph.addNode("A");
        mygraph.addNode("B");
        mygraph.addNode("C");
        mygraph.addNode("D");

        mygraph.addEdges("A", "B");
        mygraph.addEdges("A", "C");
        mygraph.addEdges("B", "D");
        mygraph.addEdges("D", "C");

        mygraph.depthFirstSearchIter("A");


    }
}
