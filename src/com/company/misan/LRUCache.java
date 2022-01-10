package com.company.misan;

import java.util.HashMap;

class LRUCache {

    private class Node {
        int key;
        int val;
        Node next = null;
        Node previous = null;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }


    private int capacity;
    private HashMap<Integer, Node> cache = new HashMap<>();
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        left.next = right;
        right.previous = left;
    }


    private void insert(Node node){

        Node prev = right.previous;
        Node next = right;
        prev.next = node;
        next.previous = node;
        node.previous = prev;
        node.next = next;
    }

    private void delete(Node node){
        Node prev = node.previous;
        Node next = node.next;
        prev.next = next;
        next.previous = prev;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            delete(node);
            insert(node);
            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        var node = new Node(key, value);
        if(cache.containsKey(key)){
            cache.remove(key);
        }
        insert(node);
        cache.put(key, node);
        if(cache.size() > capacity){
            var lru = left.next;
            delete(lru);
            cache.remove(lru.key);
        }
    }

    public int[] sortedSquares(int[] nums){
        int j = 0;
        int k = nums.length - 1;
        int counter = k;
        int result [] = new int [nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(Math.abs(nums[k]) > Math.abs(nums[j])) {
                result[counter] = (int)Math.pow(nums[k], 2);
                counter--;
                k--;
            }else {
                result[counter] = (int)Math.pow(nums[j], 2);
                counter--;
                j++;
            }
        }
        return result;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */