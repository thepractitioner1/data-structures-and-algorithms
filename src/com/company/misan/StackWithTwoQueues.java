package com.company.misan;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues {
    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();
    private int top;


    public void Enqueue(int value){
        queue1.add(value);
        top = value;
    }

    public int Dequeue(){
        if(isEmpty()) throw new IllegalStateException("Stack is empty");

        while (queue1.size() > 1) {
            top = queue1.remove();
            queue2.add(top);
        }

        swapQueues();
        return queue2.remove();
    }

    public int peek(){
        if(isEmpty()) throw new IllegalStateException("Stack is empty");
        return top;
    }

    public int size(){
        return queue1.size();
    }


    private void swapQueues() {
        var temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }



    public boolean isEmpty(){
        return queue1.isEmpty();
    }
}
