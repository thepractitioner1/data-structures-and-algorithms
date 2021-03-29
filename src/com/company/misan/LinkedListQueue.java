package com.company.misan;


import java.util.NoSuchElementException;

public class LinkedListQueue {

    private Node first;
    private Node last;
    private int size = 0;

    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }

        this.size++;
    }

    public int dequeue() {
        Node temp;

        if (isEmpty()) throw new NoSuchElementException("Linked list is empty");
        int value = first.value;
        if (first == last) {
            first = last = null;
        } else {
            temp = first.next;
            first.next = null;
            first = temp;
        }
        size--;

        return value;
    }

    public int peek() {
        if (isEmpty()) throw new NoSuchElementException("Linked list is empty");
        return last.value;
    }

    public int size(){
        return size;
    }


    public boolean isEmpty() {
        return first == null;
    }

    private class Node {
        int value;
        Node next;

        private Node(int value) {
            this.value = value;
        }
    }


}
