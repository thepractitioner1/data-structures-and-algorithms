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

    public int remove(){
        if(size == 0) throw new IllegalStateException("Heap is empty.");
        var item = intItems[0];
        swapItem(0, --size);
        bubbleDown(0);

        return item;
    }

    public boolean isFull(){
        return size == intItems.length;
    }

    private boolean checkIfValidHeap(int index){
        int parent = getParent(index);
        return intItems[index] <= intItems[parent];
    }

    private void bubbleDown(int index){


        if(isValidParent(index)) return;
        var swapIndex = getLargerChild(index);
        swapItem(swapIndex, index);
        bubbleDown(swapIndex);
    }

    private boolean isValidParent(int index){

        var leftNode = (index * 2) + 1;
        var rightNode = (index * 2) + 2;
        if(leftNode >= size){
            return true;
        }
        if(rightNode>=size){
            return intItems[leftNode]<= intItems[index];
        }

        return intItems[leftNode] <= intItems[index] && intItems[rightNode] <= intItems[index];
    }
    private int getLargerChild(int index ){
        var leftNode = (index * 2) + 1;
        var rightNode = (index * 2) + 2;
        if(leftNode >= size){
            return index;
        }
        if(rightNode>= size){
            return leftNode;
        }
        return intItems[leftNode] < intItems[rightNode] ? rightNode : leftNode;
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
