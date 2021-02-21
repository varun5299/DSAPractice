package stack;

public class SAStack {
    public int capacity=100;

    int top = -1;
    int[] arr = new int[capacity];

    public int size() {
        return (top + 1);
    }

    public boolean isEmpty(){
        return (top < 0);
    }

    public boolean isFull(){
        return(top+1==capacity);
    }

    public void push(int data) throws Exception {
        if (isFull()) {
            throw new Exception("Stack overflow");
        }
        else {
            top++;
            arr[top] = data;
            System.out.println("Element "+data+" added to stack");
        }
    }

    public int peek() throws Exception {
        if(isEmpty()){
            throw new Exception("Stack Underflow");
        }else
            return arr[top];
    }

    public int pop() throws Exception {
        int data;
        if(isEmpty()){
            throw new Exception("Stack Underflow");
        }
        data=arr[top--];
        //arr[top--]=Integer.MIN_VALUE;
        return data;
    }

    public void print() throws Exception{
        if(isEmpty()) throw new Exception("Stack Underflow");
        else{
            for(int i=top;i>=0;i--)
                System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
