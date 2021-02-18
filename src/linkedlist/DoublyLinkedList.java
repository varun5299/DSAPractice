package linkedlist;

import java.util.HashMap;
import java.util.Stack;

public class DoublyLinkedList {
    public Node head;
    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void print(){
        Node last = head;
        while(last!=null){
            System.out.print(last.data+" <=> ");
            last=last.next;
        }
        System.out.print("null");
        System.out.println();
        return;
    }

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next=head;
        newNode.prev=null;
        if (head != null)
            head.prev = newNode;
        head=newNode;
    }

    public void insertBefore(Node node,int data){
        Node newNode = new Node(data);
        newNode.prev=node.prev;
        node.prev=newNode;
        newNode.next=node;
        if(newNode.prev!=null)
            newNode.prev.next=newNode;
        else
            head=newNode;
    }

    public void insertAfter(Node node, int data){
        Node newNode = new Node(data);
        newNode.next=node.next;
        node.next=newNode;
        newNode.prev=node;
        if(newNode.next!=null)
            newNode.next.prev = newNode;
    }

    public void append(int data){
        Node newNode = new Node(data);
        newNode.next=null;
        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }
        Node last = head;
        while(last.next!=null){
            last=last.next;
        }
        newNode.prev=last;
        last.next=newNode;
    }

    public void deleteStart(){
        head.next.prev=null;
        head=head.next;
    }

    public void deleteLast(){
        Node last = head;
        while(last.next!=null){
            last=last.next;
        }
        last.prev.next=null;
    }

    public void deleteNode(Node node){
        if(node.prev==null) {
            deleteStart();
            return;
        }
        if(node.next==null) {
            deleteLast();
            return;
        }
        Node prev = node.prev;
        Node next = node.next;

        prev.next=next;
        next.prev=prev;
    }

    public void deleteAtPosition(int n){
        if (head == null || n <= 0)
            return;
        Node last = head;
        for (int i = 1; last != null && i < n; i++)
        {
            last = last.next;
        }
        if (last==null)
            return;
        Node prev = last.prev;
        Node next = last.next;
        prev.next=next;
        next.prev=prev;
    }

    public void reverse(){
        Stack stack = new Stack();
        Node temp = head;
        while (temp != null)
        {
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null)
        {
            temp.data =(int) stack.pop();
            temp = temp.next;
        }
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
}
