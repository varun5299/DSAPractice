package stack;

public class DAStack {
    public int capacity=2;
    public int top=-1;
    int [] arr = new int[capacity];

    public boolean isEmpty(){
        return (top<0);
    }

    public boolean isFull(){
        return (top+1==capacity);
    }

    public int size(){
        return (top+1);
    }

    public void push(int data){
        if(isFull())
            arr=expand(arr);
        top++;
        arr[top]=data;
    }

    private int[] expand(int[] arr) {
        int length = arr.length;
        int[] newArr=new int[length*2];
        for(int i=0;i<length;i++){
            newArr[i]=arr[i];
        }
        this.capacity=(this.capacity*2);
        return newArr;
    }

    public void print() throws Exception{
        if(isEmpty()) throw new Exception("Stack Underflow");
        else if(isFull()) throw new Exception("Stack overflow");
        else{
            for(int i=top;i>=0;i--)
                System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public int pop() throws Exception {
        int data;
        if(isEmpty()) throw new Exception("Stack Underflow");
        data=arr[top];
        top--;
        return data;
    }

    public int peek() throws Exception{
        if (isEmpty()) throw new Exception("Stack Underflow");
        else return arr[top];
    }
}
