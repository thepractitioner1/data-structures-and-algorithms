package com.company.misan;

import java.util.Arrays;

public class Heap {
    private int[] intItems = new int[10];
    private int size = 0;


    public void insert(int value){
        if(isFull()) throw new IllegalStateException("Heap is full.");
        intItems[size++] =  value;
        bubbleUp(size - 1);
    }

    public void remove(){
        if(size == 0) throw new IllegalStateException("Heap is empty.");
        swapItem(0, --size);
        bubbleDown(0);
    }

    public boolean isFull(){
        return size == intItems.length;
    }

    private boolean checkIfValidHeap(int index){
        int parent = getParent(index);
        return intItems[index] <= intItems[parent];
    }

    private void bubbleDown(int index){
        var leftNode = (index * 2) + 1;
        var rightNode = (index * 2) + 2;

        if(rightNode > size - 1 || leftNode > size - 1 ||(intItems[leftNode] <= intItems[index] && intItems[rightNode] <= intItems[index]) ) return;
        var swapIndex = intItems[leftNode] < intItems[rightNode] ? rightNode : leftNode;
        swapItem(swapIndex, index);
        bubbleDown(swapIndex);
    }


    private void bubbleUp(int index){
        if (checkIfValidHeap(index)) return;
        int parent = getParent(index);
        swapItem(parent, index);
        bubbleUp(parent);
    }

    private void swapItem(int firstIndex, int secondIndex){
        int temp = intItems[firstIndex];
        intItems[firstIndex] = intItems[secondIndex];
        intItems[secondIndex] = temp;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }



    @Override
    public String toString() {
        int[] array = Arrays.copyOfRange(intItems, 0 ,size);
        return Arrays.toString(array);


    }
}
