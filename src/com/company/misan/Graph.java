package com.company.misan;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Stack;

public class Graph {
    private class Node{
        String label;
        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

        private Map <String, Node> Nodes = new HashMap<>();
        private Map <Node, ArrayList<Node>> AdjacencyList = new HashMap<>();



    public void addNode(String label){
        if(label == null) throw new IllegalStateException("Unsupported type");
        var node = new Node(label);
        Nodes.putIfAbsent(label, node);
        AdjacencyList.putIfAbsent(node, new ArrayList<Node>());
    }

    public void addEdges(String from, String to){
        var fromNode = Nodes.get(from);
        if(fromNode == null) throw new IllegalArgumentException();

        var toNode = Nodes.get(to);
        if(toNode == null) throw new IllegalArgumentException();

        AdjacencyList.get(fromNode).add(toNode);
    }

    public void print(){
        for (var source : AdjacencyList.keySet()){
            var targets = AdjacencyList.get(source);
            if(!targets.isEmpty()) System.out.println(source + " is connected to " + targets);
        }
    }


    public void remove(String label){
        var node = Nodes.get(label);
        if(node == null) return;
        for(var ele : AdjacencyList.keySet()){
            AdjacencyList.get(ele).remove(node);
        }
        Nodes.remove(label);
        AdjacencyList.remove(node);
    }


    public void removeEdge (String from, String to){
        var fromNode = Nodes.get(from);
        if(fromNode == null) throw new IllegalArgumentException();

        var toNode = Nodes.get(to);
        if(toNode == null) throw new IllegalArgumentException();

        AdjacencyList.get(fromNode).remove(toNode);
    }

    public List<String> topologicalSort(){
        var set = new HashSet<Node>();
        var list = new ArrayList<String>();
        var stack = new Stack<Node>();
        for(Node node : AdjacencyList.keySet()){
            System.out.println(node);
            topologicalSort(node, set, stack);
        }


        while (!stack.isEmpty()){
            list.add(stack.pop().label);
        }
        return  list;
    }


    public void depthFirstSearchRec(String root){
        var node = Nodes.get(root);
        if(node == null) return;

        depthFirstSearchRec(node, new HashSet<>());
    }

    public void depthFirstSearchIter(String root){
        var node = Nodes.get(root);
        var stack = new Stack<Node>();
        var visited = new HashSet<Node>();
        if(node == null) return;

        stack.push(node);



        while (!stack.isEmpty()){
            var current = stack.pop();
            if(visited.contains(current)) continue;
            System.out.println(current);
            visited.add(current);
            var neighbours = AdjacencyList.get(current);
            for(Node neighbour: neighbours){
                if(!visited.contains(neighbour))  stack.push(neighbour);
            }
        }
    }

    public void breadthFirstSearch(String root){
        var node = Nodes.get(root);
        var queue = new ArrayDeque<Node>();
        var visited = new HashSet<Node>();
        if(node == null) return;

        queue.add(node);



        while (!queue.isEmpty()){
            var current = queue.remove() ;
            if(visited.contains(current)) continue;
            System.out.println(current);
            visited.add(current);
            var neighbours = AdjacencyList.get(current);
            for(Node neighbour: neighbours){
                if(!visited.contains(neighbour))  queue.add(neighbour);
            }
        }
    }


    public boolean hasCycle(){
        var visited = new HashSet<Node>();
        for(Node node: AdjacencyList.keySet()){
            if(hasCycle(node, visited)) return  true;
        }
        return false;
    }

    private boolean hasCycle(Node node, Set<Node> visiting){
        if(visiting.contains(node)) return true;
        if(AdjacencyList.get(node).isEmpty()) return false;
        visiting.add(node);

        for(Node neighbour: AdjacencyList.get(node)){
            if(hasCycle(neighbour, visiting)) return true;
        }
        visiting.remove(node);
        AdjacencyList.put(node, new ArrayList<>());
        return false;
    }

    private void depthFirstSearchRec(Node node, Set<Node> visited){
        visited.add(node);
        System.out.println(node);
        var neighbours = AdjacencyList.get(node);
        for(Node neighbour: neighbours){
            if(visited.contains(neighbour)) continue;
            depthFirstSearchRec(neighbour, visited);
        }
    }


    private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack){
        if(visited.contains(node)) return;
        visited.add(node);
        for(Node neighbour: AdjacencyList.get(node)){
            topologicalSort(neighbour, visited, stack);
        }
        stack.push(node);
    }


}
