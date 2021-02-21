package stack;

import java.util.Stack;

//get the minimum element of the stack at anypoint of the stack
//maintain two separate stack one that will keep track of minimum element and one with stack.
public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Integer minEle = Integer.MAX_VALUE;
    Stack<Integer> min = new Stack<>();

    public void push(int data){
        if(data<minEle){
            minEle=data;
        }
        stack.push(data);
        min.push(minEle);
    }

    public void pop(){
        stack.pop();
        min.pop();
    }

    public void peek(){
        System.out.println("Element in main Stack is "+stack.peek());
        System.out.println("Element in min Stack is "+min.peek());
    }

    public void getMin(){
        if(min.isEmpty())
            System.out.println("The stack is empty");
        else
            System.out.println("The smallest element in the stack is "+min.peek());
    }

    public void pushBetter(int data){
        if(data<=minEle){
            minEle=data;
            min.push(minEle);
        }
        stack.push(data);
    }

    public void popBetter(){
        if(stack.peek()==min.peek()){
            min.pop();
        }
        stack.pop();
    }
}
