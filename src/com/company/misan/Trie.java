package com.company.misan;

import java.util.HashMap;

public class Trie {

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

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public void setEndOfWord(boolean endOfWord) {
            isEndOfWord = endOfWord;
        }

        public void removeChild(char value) {
            children.remove(value);
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

    public boolean contains(String word) {
        var current = root;
        if (word == null) return false;

        for (int i = 0; i < word.length(); i++) {
            char val = word.charAt(i);
            if (!current.containsChild(val)) return false;
            current = current.getChild(val);
        }

        return current.isEndOfWord();
    }

    public void traverse() {
        traverse(root);
    }

    public void remove(String word) {
        if (word == null) return;
        remove(word, 0, root);
    }

    private void remove(String word, int count, Node root) {

        if (count == word.length()) {
            root.setEndOfWord(false);
            return;
        }
        var ch = word.charAt(count);
        var child = root.getChild(ch);

        if (child == null) return;

        remove(word, count + 1, child);
        if (!child.hasChildren() && !child.isEndOfWord()) root.removeChild(ch);
    }

    private void traverse(Node root) {
        // pre-order traversal implementation
        System.out.println(root.value);
        for (var child : root.getChildren()) traverse(child);

        // post-order traversal implementation
//        for(var child : root.getChildren()) traverse(child);
//        System.out.println(root.value);
    }
}

