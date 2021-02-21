package stack;

//keep one array and have two tops - one in start and one in end
public class TwoStacksOneArray {
    public int capacity;
    public int top1, top2;
    int[] arr;

    public TwoStacksOneArray(int capacity) throws Exception {
        if(capacity<2) throw new Exception("Capacity should be more");
        this.capacity = capacity;
        this.top1=-1;
        this.top2=capacity;
        this.arr=new int[capacity];
    }

    public void push1(int x) {
        if (top1 < top2 - 1) {
            top1++;
            arr[top1] = x;
        }
        else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    public void push2(int x) {
        if (top1 < top2 - 1) {
            top2--;
            arr[top2] = x;
        }
        else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    public int pop1() {
        if (top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        }
        else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }

    public int pop2() {
        if (top2 < capacity) {
            int x = arr[top2];
            top2++;
            return x;
        }
        else {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return 0;
    }

    public int peek1(){
        return arr[top1];
    }

    public int peek2(){
        return arr[top2];
    }

    public void print1(){
        for(int i=top1;i>=0;i--)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public void print2(){
        for(int i=top2;i<capacity;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
