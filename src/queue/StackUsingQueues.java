package queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    Queue<Integer> queue1 = new LinkedList();
    Queue<Integer> queue2 = new LinkedList();
    int size=0;

    public void push(int data){
        queue1.add(data);
        size++;
    }

    public int pop(){
        if(queue1.isEmpty())
            return -1;

        while(queue1.size()!=1){
            queue2.add(queue1.remove());
        }
        int data = queue1.remove();
        size--;

        Queue temp = queue1;
        queue1=queue2;
        queue2=temp;

        return data;
    }

    public int size(){
        return size;
    }

    public int peek(){
        if(queue1.isEmpty())
            return -1;

        while(queue1.size()!=1){
            queue2.add(queue1.remove());
        }
        int data = queue1.remove();
        queue2.add(data);

        Queue temp = queue1;
        queue1=queue2;
        queue2=temp;

        return data;
    }
}
