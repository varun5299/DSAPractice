package stack;

import java.util.Stack;

public class Evaluations {
    //if operator.. pop 2 elements and operate them and add back
    //if operand.. add to stack
    public void postFix(String str){
        Stack<String> stack = new Stack<>();
        int len = str.length();
        for(int i=0;i<len;i++){
            char ch = str.charAt(i);
            if(ch=='+'){
                int op1 = Integer.parseInt(stack.pop());
                int op2 = Integer.parseInt(stack.pop());
                int sum = op1+op2;
                stack.push(String.valueOf(sum));
            }
            else if(ch=='-'){
                int op1 = Integer.parseInt(stack.pop());
                int op2 = Integer.parseInt(stack.pop());
                int sum = op2-op1;
                stack.push(String.valueOf(sum));
            }
            else if(ch=='*'){
                int op1 = Integer.parseInt(stack.pop());
                int op2 = Integer.parseInt(stack.pop());
                int sum = op1*op2;
                stack.push(String.valueOf(sum));
            }
            else if(ch=='/'){
                int op1 = Integer.parseInt(stack.pop());
                int op2 = Integer.parseInt(stack.pop());
                int sum = op2/op1;
                stack.push(String.valueOf(sum));
            }
            else{
                stack.push(String.valueOf(ch));
            }
        }
        System.out.println("The evaluation is "+stack.pop());
    }
}
