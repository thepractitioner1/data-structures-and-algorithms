package com.company.misan;

import java.util.Queue;
import java.util.Stack;

public class QueueExercises {
    public static Queue<Integer> reverser(Queue<Integer> queue, int index){
        var stack = new Stack<Integer>();
        for(int i = 0; i < index; i++){
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }

        for(int i = 0; i<queue.size() - index; i++){
            queue.add(queue.remove());
        }
        return queue;
    }
}
