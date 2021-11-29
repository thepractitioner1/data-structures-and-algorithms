package com.company.misan;

import java.util.HashMap;

public class Trie {

    public static int ALPHABET_SIZE = 26;

    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public boolean containsChild(char value) {
            return children.containsKey(value);
        }

        public void addChild(char value, Node node) {
            children.put(value, node);
        }

        public Node getChild(char value) {
            return children.get(value);
        }

        public void setEndOfWord(boolean endOfWord) {
            isEndOfWord = endOfWord;
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        var current = root;
        for (int i = 0; i < word.length(); i++) {
            char val = word.charAt(i);
            if (!current.containsChild(val)) {
                var node = new Node(val);
                current.addChild(val, node);
            }
            current = current.getChild(val);
        }
        current.setEndOfWord(true);
    }

    public boolean contains(String word){
        var current = root;

        for(int i = 0; i<word.length(); i++){
            char val = word.charAt(i);
            if(!current.containsChild(val)) return false;
            current = current.getChild(val);
        }

        return current.isEndOfWord();
    }
}

