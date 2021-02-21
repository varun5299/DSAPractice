package stack;

public class LLStack{
    int length=0;
    public Node head;
    public class Node{
        public int data;
        public Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    public boolean isEmpty(){
        if(head==null)
            return true;
        else
            return false;
    }

    public void push(int data){
        if(isEmpty()){
            head=new Node(data);
            length++;
        } else{
            Node newNode = new Node(data);
            newNode.next=head;
            head=newNode;
            length++;
        }
    }

    public int pop() throws Exception {
        int data;
        if(isEmpty()) throw new Exception("Stack Underflow");
        else{
            data=head.data;
            head=head.next;
            length--;
        }
        return data;
    }

    public int peek(){
        return head.data;
    }

    public void print(){
        if(isEmpty())
            System.out.println("Stack Underflow");
        else{
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.println();
        }
    }

    public int size(){
        return length;
    }
}
