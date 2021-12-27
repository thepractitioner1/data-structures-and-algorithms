package com.company.misan;

import java.util.Stack;

class BrowserHistory {

    String homepage;
    Stack<String> history = new Stack();
    Stack <String> forward = new Stack();

    public BrowserHistory(String homepage) {
        this.homepage = homepage;
    }

    public void visit(String url) {
        history.add(url);
        forward = new Stack();
    }

    public String back(int steps) {
        for(int i = 0; i<steps; i++){
            if(history.isEmpty()) return this.homepage;
            forward.add(history.pop());
        }
        return  history.isEmpty() ? this.homepage  : history.peek();
    }

    public String forward(int steps) {
        for(int i = 0; i<steps; i++){
            if(forward.isEmpty()) return history.peek();
            history.add(forward.pop());
        }
        return history.peek();
    }
}

