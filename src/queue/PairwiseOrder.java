package queue;

import java.util.Stack;

public class PairwiseOrder {
    public void pairwiseOrder(Stack<Integer> stack){
        Boolean pairwise = true;
        if(stack.size()%2!=0)
            stack.pop();

        while(!stack.isEmpty()){
            int m=stack.pop();
            int n=stack.pop();
            if(Math.abs(m-n)!=1)
                pairwise=false;
        }

        System.out.println(pairwise);
    }
}
