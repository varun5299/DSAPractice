package stack;

import java.util.Stack;

//add element from array to stack if its greater than stack top or is empty
//else pop all the elements of greater height
//if stack is empty.. then calculate minimum height * i for area and store
//if not empty..  then area = minimum height * [i-stack.top-1] and store area.
public class RectangleHistogram {
    public void getMaxArea(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int i =0;
        int tp;
        int maxArea=Integer.MIN_VALUE, area=0;
        while(i<arr.length){
            if(stack.empty() || arr[i]>=arr[stack.peek()]){
                stack.push(i);
                i++;
            }else{
                tp=stack.pop();
                if(stack.empty())
                    area=arr[tp]*i;
                else
                    area=arr[tp]*(i-stack.peek()-1);
            }
            if(area>maxArea)
                maxArea=area;
        }
        while(stack.empty()==false){
            tp=stack.pop();
            if(stack.empty())
                area=arr[tp]*i;
            else
                area=arr[tp]*(i-stack.peek()-1);

            if(area>maxArea)
                maxArea=area;
        }

        System.out.println(maxArea);

    }
}
