package stack;

import java.util.Stack;

//Create a stack and convert the string to array.
//while (end of input is not reached)

//If the character read is not a symbol to be balanced, ignore it.

//If the character is an opening symbol like (, [, {, push it onto the stack

//If it is a closing symbol like ),],},
//check if stack is empty and peek if the top element of the stack matches the type of closing bracket.
//if they match.. then pop them out of the stack.

//At the end if the stack is empty.. that means stack is balanced
public class BalancingParanthesis {
    public void checker(String str){
        char[] arr = str.toCharArray();
        int len = arr.length;
        int i=0;
        Stack<Character> stack = new Stack<>();
        while(i!=len){
            char ch=arr[i];
            if(ch=='('||ch=='{'||ch=='{'){
                stack.push(ch);
                i++;
            }else if(ch==')'){
                if(stack.isEmpty()&&stack.peek()=='(')
                stack.pop();
                i++;
            }else if(ch=='}'){
                if(stack.isEmpty()&&stack.peek()=='{')
                    stack.pop();
                i++;
            }else if(ch==']'){
                if(stack.isEmpty()&&stack.peek()=='[')
                    stack.pop();
                i++;
            }else
                i++;
        }
        if(stack.isEmpty())
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
    }
}
