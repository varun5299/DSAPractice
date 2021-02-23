package queue;

import java.util.Queue;
import java.util.Stack;

public class Reverse {
    public void reverse(Queue queue){
        Stack stack = new Stack();
        while (!queue.isEmpty()){
            stack.push(queue.remove());
        }
        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }
        for(Object n:queue){
            System.out.println(n+" ");
        }
    }
}
