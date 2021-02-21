package stack;

import java.util.Stack;

public class DuplicateRemover {
    public void remover(int[] arr){
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }else{
                int count = 0;
                int j = i;
                while (j < arr.length && stack.peek() == arr[j]) {
                    count++;
                    j++;
                }
                if (count == 0) {
                    stack.push(arr[i]);
                } else {
                    for (int k = 1; k < count; k++)
                        i++;
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
