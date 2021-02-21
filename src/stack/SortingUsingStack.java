package stack;

import java.util.Stack;

//keep a temp stack.. take out the element from original store it in X
//check if the temp stack is not empty and if the temp stack's top is >/< X
//if they true then pop from the temp stack and add all elements back to the stack
//finally add X to the sort stack
public class SortingUsingStack {
    public void sort(Stack<Integer> stack){
        Stack<Integer> sortStack = new Stack<>();
        while(!stack.isEmpty()){
            int temp = stack.pop();
            while(!sortStack.isEmpty() && sortStack.peek()<temp){
                stack.push(sortStack.pop());
            }
            sortStack.push(temp);
        }
        while(!sortStack.isEmpty()){
            System.out.print(sortStack.pop()+" ");
        }
    }
}
