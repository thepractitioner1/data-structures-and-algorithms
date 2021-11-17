package com.company.misan;

public class Main {

    public static void main(String[] args) {

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
        int[] array = new int[]{10,5, 17,4, 22};
        Heap heap = new Heap();
        for (int i = 0; i<array.length; i++){
            heap.insert(array[i]);
        }

        System.out.println(heap);
        heap.remove();
        System.out.println(heap);
        heap.remove();
        System.out.println(heap);


    }
}
