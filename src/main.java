import queue.InterleaveQueue;
import queue.PairwiseOrder;
import queue.ReverseKElements;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class main {
    public static void main(String[] args) throws Exception {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(11);
        queue.add(12);
        queue.add(13);
        queue.add(14);
        queue.add(15);
        queue.add(16);
        queue.add(17);
        queue.add(18);
        queue.add(19);
        queue.add(20);
        ReverseKElements reverseKElements = new ReverseKElements();
        reverseKElements.reverseKElements(queue,8);
    }
}
