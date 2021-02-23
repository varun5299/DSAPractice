package queue;

import java.util.Queue;
import java.util.Stack;

public class ReverseKElements {
    public void reverseKElements(Queue<Integer> queue, int k){
        Stack<Integer> stack = new Stack();
        for(int i=0;i<k;i++){
            stack.push(queue.poll());
        }
        while(!stack.isEmpty())
            queue.add(stack.pop());

        for(int i=0;i<queue.size()-k;i++)
            queue.add(queue.poll());

        while(!queue.isEmpty()){
            System.out.print(queue.remove()+" ");
        }
        System.out.println();
    }
}
