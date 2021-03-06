package com.company.misan;

import java.util.Arrays;

public class Stack {
    private final int[] myarr = new int[5];
    private int count;

    public void push(int item){
        if(count == myarr.length)
            throw new StackOverflowError("Stack is full");

        myarr[count++] = item;
    }

    public int pop(){
        if (isEmpty()) throw  new IllegalArgumentException("Stack is empty");
       return myarr[--count];
    }
    public int peek(){
        if (isEmpty()) throw  new IllegalArgumentException("Stack is empty");
        return myarr[count - 1];
    }

    public boolean isEmpty(){
        return (count == 0);
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(myarr, 0 , count);
        return  Arrays.toString(content);
    }
}
