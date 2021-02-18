package linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class CircularLinkedList {
    public Node head;
    public class Node{

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next=null;
        }
    }

    public void print(){
        if(head==null)
            return;
        Node last = head;
        do{
            System.out.print(last.data+" -> ");
            last=last.next;
        }while(last!=head);

        System.out.println();
    }

    public void push(int data){
        if(head==null) {
            head = new Node(data);
            head.next=head;
            return;
        }
        Node last = head;
        Node newNode = new Node(data);
        while(last.next!=head){
            last=last.next;
        }
        last.next=newNode;
        newNode.next=head;
        head=newNode;

    }

    public void append(int data){
        if(head==null){
            head = new Node(data);
            head.next=head;
            return;
        }

        Node last = head;
        do{
            last=last.next;
        }while (last.next!=head);
        Node newNode = new Node(data);
        newNode.next=last.next;
        last.next=newNode;
    }

    public void insertNode(int data, Node node){
        if(head==null){
            head = new Node(data);
            head.next=head;
            return;
        }

        Node last = head;
        while(last!=node){
            last=last.next;
            if(last==head)
            {
                System.out.println("Node "+node.data+" not found ");
                break;
            }
        }

        Node newNode = new Node(data);
        newNode.next=last.next;
        last.next=newNode;
    }

    public void Length(){
        Node last = head;
        int count=0;
        do{
            count++;
            last=last.next;
        }while(last!=head);
        System.out.println(count);
    }

    public void deleteStart(){
        if(head==null)
            return;
        if(head==head.next) {
            head = null;
            return;
        }
        Node last = head;
        do{
            last=last.next;
        }while(last.next!=head);
        head=head.next;
        last.next=head;
        System.gc();
    }

    public void deleteEnd(){
        if(head==null)
            return;
        if(head==head.next) {
            head = null;
            return;
        }
        Node last = head;
        do{
            last=last.next;
        }while(last.next.next!=head);
        last.next=head;
    }

    //run a loop to check if there is only one element in the list
    //take two pointers one that will iterate through the list and one that will store the previous value
    //take a counter variable to check if the nth person it met..
    //if not then store the prev value and move to the next value
    //if the value is found then replace the current value with the previous value
    //and restart the counter at the start of the second while.
    public void JosCicle(int n){
        Node last = head, flag=head;
        while(last.next!=last){
            int count=1;
            while(count!=n){
                flag=last;
                last=last.next;
                count++;
            }
            flag.next=last.next;
            last=flag.next;
        }
        System.out.println ("Last person left standing " + "(Josephus Position) is " + last.data);
    }
}
