package stack;

import java.util.Stack;

public class PalindromeX {
    public void check(String str){
        String output="Palindrome";
        Stack<Character> stack = new Stack<>();
        int i=0;
        while(str.charAt(i)!='X'){
            stack.push(str.charAt(i));
            i++;
        }
        i++;
        while(i<str.length()){
            if(stack.isEmpty())
                output="Not Palindrome";
            else if(str.charAt(i)!=stack.pop())
                output="Not Palindrome";
            i++;
        }
        if(!stack.isEmpty())
            output="Not Palindrome";
        System.out.println(output);

    }
}
