package linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Linkedlist {
    public Node head;
    public class Node {
        public int data;
        public Node next;
        Node(int d) {data = d; next = null; }
    }

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void insertAfter(Node prev_node, int new_data) {
        if (prev_node == null)
        {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    public void append(int new_data) {
        Node new_node = new Node(new_data);
        if (head == null)
        {
            head = new Node(new_data);
            return;
        }
        new_node.next = null;
        Node last = head;
        while (last.next != null)
            last = last.next;
        last.next = new_node;
        return;
    }

    public void printList() {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
        System.out.println();
    }

    public int Length(){
        int len=0;
        Node trav=head;
        while(trav!=null) {
            len++;
            trav=trav.next;
        }
        return len;
    }

    public void deletetop(){
        if(head==null)
            return;

        Node temp = head;
        head=head.next;
    }

    public void deletelast(){
       Node last=head;
       while(last.next.next!=null){
           last=last.next;
       }
        last.next=null;
    }

    public void deleteMid(Node node){
        Node temp = node.next;
        node.data = temp.data;
        node.next = temp.next;
        System.gc();
    }

    public boolean search(int data){
        Node last = head;
        if (last == null)
            return false;
        while(last!=null) {
            if (last.data == data)
                return true;
            last=last.next;
        }
        return false;
    }

    public int nthnode(int x){
        Node last=head;
        int c=0;
        while(last!=null){
            if(x==c)
                return last.data;
            last=last.next;
            c++;
        }
        return 0;
    }

    //two pointers.. fast_ptr go till n.. then both start at 1 increment..
    // fast_ptr reaches end.. we get value on slow
    public int nthnodefromend(int n){
        Node last=head;
        Node flag=head;
        for(int i=0;i<n;i++){
            flag=flag.next;
        }
        while(flag!=null){
            flag=flag.next;
            last=last.next;
        }
        return last.data;
    }

    //two pointers.. one double.. one single get mid
    public int midnode(){
        if(head==null)
            return -1;
        Node last = head;
        Node flag= head;
        while(flag.next!=null && flag.next.next!=null){
            last=last.next;
            flag=flag.next.next;
        }
        return last.data;
    }

    public int integercount(int data){
        int count = 0;
        Node last = head;
        while(last!=null){
            if(last.data==data)
                count++;
            last=last.next;
        }
        return count;
    }

    public void delete(){
        head=null;
        System.gc();
    }

    // 2 loops.. one add in stack.. another values check with stack
    public boolean isPalindrome(){
        Stack<Integer> stack = new Stack<Integer>();
        Node counter = head;
        Boolean ispalin=false;
        while(counter!=null){
            stack.push(counter.data);
            counter=counter.next;
        }
        Node last = head;
        while(last!=null){
            if(last.data==stack.pop())
                ispalin=true;
            else {
                ispalin = false;
                break;
            }
            last=last.next;
        }
        return ispalin;
    }

    //data==next.data.. then replace next with next
    public void removesortedDuplicates() {
        Node curr = head;
        while (curr != null) {
            Node temp = curr;
            while(temp!=null && temp.data==curr.data) {
                temp = temp.next;
            }
            curr.next = temp;
            curr = curr.next;
        }
    }

    //store in hashset and retrieve later
    public void removeunsortedDuplicate() {
        Node current = head;
        Node flag=null;
        HashSet<Integer> hs = new HashSet<>();
        while (current != null)
        {
            int data = current.data;
            if (hs.contains(data)) {
                flag.next=current.next;
            } 
            else {
                hs.add(data);
                flag=current;
            }
            current = current.next;
        }

    }

    //take a stack..put the values in it..
    //replace the head with the last node and pop elements from the stack and save to LL
    public void reverse(){
        Stack<Node> stack = new Stack<Node>();
        Node counter = head;
        while(counter.next!=null){
            stack.add(counter);
            counter=counter.next;
        }
        head=counter;
        while (!stack.isEmpty()){
            counter.next=stack.pop();
            counter=counter.next;
        }
        counter.next=null;
    }

    //store node in a hashset.. if it is visited again..break you have it
    public boolean loopwithHash(){
        HashSet h = new HashSet();
        Node last = head;
        while(last!=null){
            if(h.contains(last))
                return true;
            else
                h.add(last);
            last=last.next;
        }
        return false;
    }

    //Floyd’s Cycle-Finding Algorithm
    public boolean loopwithNode(){
        Node temp=head, flag = head;
        while(flag!=null && flag.next!=null){
            temp=temp.next;
            flag=flag.next.next;
            if(temp==flag)
                return true;
        }
        return false;
    }

    //taking a new node temp and changing the next of every node to point to temp.
    //thus when there is a loop.. it will encounter value of temp and give the node value
    //another way is the extension of floyd's cycle finding algorithm.. where after finding the loop
    //we reset the value of the fast_ptr to the head and increment them together by 1..
    //they meet each other at the start node.
    public void loopStart(){
        Node temp=new Node(0);
        Node last = head;
        while(last!=null){
            if(last.next==temp)
                break;
            else{
                Node rep=last.next;
                last.next=temp;
                last=rep;
            }
        }
        System.out.println(last.data);
    }

    public void reverseInPair(){
        Node temp = head;

        while (temp != null && temp.next != null) {
            int k = temp.data;
            temp.data = temp.next.data;
            temp.next.data = k;
            temp = temp.next.next;
        }
    }

}
