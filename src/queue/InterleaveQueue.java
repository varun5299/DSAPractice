package queue;

import java.util.Queue;
import java.util.Stack;

public class InterleaveQueue {
    public void interleaveQueue(Queue<Integer> queue) throws Exception {
        Stack<Integer> stack = new Stack<>();
        int n=queue.size();
        if(n%2!=0) throw new Exception("Queue Size is wrong");

        for(int i=0;i<n/2;i++){
            stack.push(queue.poll());
        }

        for(int i=0;i<n/2;i++){
            queue.add(stack.pop());
        }

        for(int i=0;i<n/2;i++){
            queue.add(queue.poll());
        }

        for(int i=0;i<n/2;i++){
            stack.push(queue.poll());
        }

        while(!stack.isEmpty()){
            queue.add(stack.pop());
            queue.add(queue.poll());
        }

        while(!queue.isEmpty()){
            System.out.print(queue.remove()+" ");
        }
        System.out.println();
    }
}
