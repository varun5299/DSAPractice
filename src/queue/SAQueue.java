package queue;

import java.util.Stack;

public class SAQueue {
    public int capacity;
    public int rear, size, front;
    public int [] arr;

    public SAQueue(int capacity){
        this.capacity=capacity;
        arr=new int[this.capacity];
        front = this.size = 0;
        rear = capacity-1;
    }

    public boolean isFull(){
        return size==capacity;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void enQueue(int data) throws Exception {
        if(isFull()) throw new Exception("Queue Overflow");
        else {
            rear = (rear + 1) % capacity;
            arr[rear] = data;
            size++;
        }
    }

    public int deQueue() throws Exception{
        if(isEmpty()) throw new Exception("Queue Underflow");
        else{
            int item = arr[front];
            front = (front+1)%capacity;
            System.out.println("Element popped is "+item);
            size--;
            return item;
        }
    }

    public int front() throws Exception {
        if(isEmpty()) throw new Exception("Underflow");
        else return arr[front];
    }

    public int rear() throws Exception{
        if (isEmpty()) throw new Exception("Underflow");
        else return arr[rear];
    }

    public int size(){
        return size;
    }

    public void print(){
        for(int i=front;i<=rear;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

}
