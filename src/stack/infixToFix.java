package stack;

import java.util.Stack;

public class infixToFix {

    //^,*/,+-
    public int Prec(char ch) {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    //if digit.. add to output
    //if (.. add to stack
    //if ).. remove from stack and add to output till we get )
    //if signs.. add to stack according to precendence.. if prec(current)>prec(stack) then pop from stack and add to output
    //at end if stack not empty.. pop and keep on adding
    public void postFix(String str){
        Stack<Character> stack = new Stack<>();
        int len = str.length();
        String output="";
        for(int i=0;i<len;i++){
            char ch = str.charAt(i);

            if(Character.isLetterOrDigit(ch))
                output+=ch;

            else if(ch=='(')
                stack.push(ch);

            else if(ch==')'){
                while (!stack.isEmpty() && stack.peek() != '(')
                    output += stack.pop();
                    stack.pop();
            }

            else{
                while (!stack.isEmpty() && Prec(ch) <= Prec(stack.peek())){
                    output+= stack.pop();
                }
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek() == '(')
                System.out.println("The Expression is not Valid");
            output+=stack.pop();
        }
        System.out.println("The Postfix is = "+output);
    }
}
