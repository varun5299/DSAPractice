package stack;

import java.util.Stack;

public class StockSpan {
    public void stockSpan(int[] profit){
        int n=profit.length;
        int [] S = new int[n];
        Stack<Integer> stack = new Stack<>();

        //satoring initial values in the stack
        stack.push(0);
        S[0]=1;

        //loop through the stack
        for(int i=1;i<n;i++){

            //check if the ith price is greater than the previously stores prices.. if yes pop the previous out
            while(!stack.isEmpty() && profit[stack.peek()]<=profit[i])
                stack.pop();

            //if the stack is empty then it means that the current price presides over all and is max
            if(stack.isEmpty())
                S[i]=i+1;
            //if not the it means there is a value which is more than it.
            else
                S[i]=i-stack.peek();

            stack.push(i);
        }
    }
}
