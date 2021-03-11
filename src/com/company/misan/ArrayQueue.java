package com.company.misan;

import java.util.Arrays;

public class ArrayQueue {
    private int rear;
    private int front;
    private int count ;
    private int[] array;

    public ArrayQueue(int value) {
        array = new int[value];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == array.length;
    }


    public void enqueue(int value){
        if(isFull()) throw new StackOverflowError("The queue is full, Please delete some items");
        array[rear] = value;
        rear =  (rear + 1) % array.length;
        count++;
    }

    public int dequeue(){
        if(isEmpty()) throw new IllegalStateException("This queue is currently empty.");

         var item = array[front];
         array[front] = 0;
         front = (front + 1) % array.length;
         count--;
         return item;
    }

    public int peek(){
        if(isEmpty()) throw new IllegalStateException("This queue is currently empty.");
        return array[rear];
    }


    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
