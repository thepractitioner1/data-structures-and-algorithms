package com.company.misan;

public class Trie {

    public static int ALPHABET_SIZE = 26;

    private class Node {
        char value;
        Node[] children = new Node[ALPHABET_SIZE];
        boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        public char getValue() {
            return value;
        }


        public void setValue(char value) {
            this.value = value;
        }

        public Node[] getChildren() {
            return children;
        }

        public void setChildren(Node[] children) {
            this.children = children;
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public boolean containsChild(char value) {
            return children[getChildIndex(value)] != null;
        }

        public void addChild (int index, Node node){
            children[index] = node;
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
                current.addChild(getChildIndex(val), node);
            }
            current = current.children[getChildIndex(val)];
        }
        current.setEndOfWord(true);
    }

    private int getChildIndex(char val){
        return val - 'a';
    }

}

