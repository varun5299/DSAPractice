package queue;

public class LLQueue {
    Node head;
    int size=0;

    public class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next=null;
        }
    }

    public boolean isEmpty(){
        return(head==null);
    }

    public int size(){
        Node temp = head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        return size;
    }

    public void enqueue(int data){
        if(isEmpty())
            head=new Node(data);
        else{
            Node newNode = new Node(data);
            newNode.next=head;
            head=newNode;
        }
    }

    public int dequeue(){
        if(isEmpty())
            return -1;
        Node temp = head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        int data = temp.next.data;
        temp.next=null;
        return data;
    }

    public int front(){
        Node temp = head;
        while(temp.next!=null)
            temp=temp.next;
        return temp.data;
    }

    public int rear(){
        return head.data;
    }
}
