package com.company.misan;

import java.util.NoSuchElementException;

public class LinkedList {
    private Node first;
    private Node last;
    private int size = 0;


    private class Node{
        int value;
        Node next;

        private Node(int value) {
            this.value = value;
        }
    }



    public void addFirst(int value){
        Node newNode = new Node(value);
        if(isEmpty()){
             first = newNode;
             last = newNode;
        }else{
           newNode.next =  first;
           first = newNode;
        }

        this.size++;
    }


    public void addLast(int value){
        var newNode = new Node(value);
        newNode.next = null;
        if(isEmpty()){
            first = newNode;
        }else{
            last.next = newNode;
        }
        last = newNode;
        size++;

    }

    public void deleteFirst(){
        Node second;
        if(isEmpty()) throw new NoSuchElementException("Linked list is empty");

        if(first == last){
            first = last = null;
        }else{
            first = first.next;
//            second = first.next;
//            first.next = null;
//            first = second;
        }
        size--;
    }

    public void deleteLast(){
        if(isEmpty()) throw new NoSuchElementException("Linked list is empty");
        var current = first;

        if(first == last) {
            first = last = null;
        }else{
            while(current != null){
                if (current.next == last){
                    current.next = null;
                    last = current;
                }
                current = current.next;
            }
        }
        size--;

    }


    public int indexOf(int value){
        int index = 0;
        if (isEmpty()) return -1;
        var node = first;
        while(node != null){
           if(node.value == value) return index;
           node = node.next;
           index++;
        }
        return -1;
    }

    public boolean contains(int value) {

        return indexOf(value) != -1;
    }


    private boolean isEmpty() {
        return first == null;
    }

    public int getSize() {
        return size;
    }

    public int[] toArray(){
        int [] arr = new int[size];
        var current = first;
        int index = 0;
        while (current != null){
            arr[index++] = current.value;
            current=current.next;
        }
        return arr;
    }


    public void reverse(){
        if(isEmpty()) throw new NoSuchElementException("No item currently exist in the Linked List");

        var previous = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }


    private Node getPreviousNode(Node node){
        Node current = first;
        while (current != null){
            if(current.next == node) return current;
            current =  current.next;
        }
        return null;
    }

    public int getKthFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();

        var a = first;
        var b = first;
        for (int i = 0; i < k - 1; i++) {
            b = b.next;
            if (b == null)
                throw new IllegalArgumentException();
        }
        while (b != last) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }
}
