package com.company.misan;

public class MaxHeap {
    public static void heapify(int[] array) {
        var lastParentIndex = array.length / 2 - 1;
        for (var i = lastParentIndex; i >= 0; i--)
            heapify(array, i);
    }


    public static int kthLargestElement(int[] array,int index){
        Heap heap = new Heap();

        for (int j : array) {
            heap.insert(j);
        }

        for(int j = 0; j < index - 1; j++){
            heap.remove();
        }

        return heap.max();

    }

    private static void heapify(int[] array, int index) {
        var largerIndex = index;

        var leftIndex = index * 2 + 1;
        if (leftIndex < array.length &&
                array[leftIndex] > array[largerIndex])
            largerIndex = leftIndex;

        var rightIndex = index * 2 + 2;
        if (rightIndex < array.length &&
                array[rightIndex] > array[largerIndex])
            largerIndex = rightIndex;

        if (index == largerIndex)
            return;

        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }





    private static void swap(int[] array, int first, int second) {
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

}
