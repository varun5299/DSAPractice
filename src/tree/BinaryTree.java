package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BinaryTree {
    public Node root;

    public class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
            left=right=null;
        }
    }

    public BinaryTree(int data){
        this.root = new Node(data);
    }

    public BinaryTree(){
        root=null;
    }

    public void levelOrder(){
        if(root==null)
            System.out.println("Tree is empty");

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data+" ");

            if(temp.left!=null)
                queue.add(temp.left);

            if(temp.right!=null)
                queue.add(temp.right);
        }
    }

    public void iterativePreorder(){
        if(root == null) {
            System.out.println("Tree is Empty");
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            System.out.println(temp.data+" ");

            if(temp.right!=null)
                stack.push(temp.right);

            if(temp.left!=null)
                stack.push(temp.left);
        }
    }

    public void recursivePreorder(Node temp_root){
        if(temp_root!=null) {
            System.out.print(temp_root.data + " ");
            recursivePreorder(temp_root.left);
            recursivePreorder(temp_root.right);
        }
    }

    public void iterativePostorder(){
        if(root == null){
            System.out.println("Tree is empty");
            return;
        }

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            Node temp = stack1.pop();
            stack2.push(temp);
            if(temp.left!=null)
                stack1.push(temp.left);
            if(temp.right!=null)
                stack1.push(temp.right);
        }

        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().data+" ");
        }
    }

    public void recursivePostorder(Node temp_root){
        if(temp_root!=null) {
            recursivePostorder(temp_root.left);
            recursivePostorder(temp_root.right);
            System.out.print(temp_root.data + " ");
        }
    }

    public void iterativeInorder(){
        if(root == null){
            System.out.println("Tree is empty");
            return;
        }

        Stack<Node> stack = new Stack<>();

        Node curr = root;
        while (curr != null || stack.size() > 0) {
            while (curr !=  null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }

    }

    public void recursiveInorder(Node temp_root){
        if(temp_root!=null) {
            recursiveInorder(temp_root.left);
            recursiveInorder(temp_root.right);
            System.out.print(temp_root.data + " ");
        }
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            }
            else q.add(temp.left);

            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            }
            else q.add(temp.right);
        }
    }

    public void searchMax(){
        if(root==null)
            System.out.println("Tree is empty");

        Queue<Node> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.data>=max)
                max=temp.data;

            if(temp.left!=null)
                queue.add(temp.left);

            if(temp.right!=null)
                queue.add(temp.right);
        }

        System.out.println("The max element in the tree is "+max);
    }

    public void searchMin(){
        if(root==null)
            System.out.println("Tree is empty");

        Queue<Node> queue = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.data<=min)
                min=temp.data;

            if(temp.left!=null)
                queue.add(temp.left);

            if(temp.right!=null)
                queue.add(temp.right);
        }

        System.out.println("The Minimum element in the tree is "+min);
    }

    public void searchElement(int data){
        if(root==null)
            System.out.println("tree is empty");
        Boolean x=false;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.data==data){
                x=true;
                break;
            }

            if(temp.right!=null)
                queue.add(temp.right);

            if(temp.left!=null)
                queue.add(temp.left);

        }
        if(x)
            System.out.println("Value found");
        else
            System.out.println("Value not found");
    }

    public void size(){
        if(root==null){
            System.out.println("The size is 0 as the tree is empty");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int size=0;
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp!=null)
                size++;

            if(temp.right!=null)
                queue.add(temp.right);

            if(temp.left!=null)
                queue.add(temp.left);
        }
        System.out.println("The size of the tree is "+size);
    }

    public void deleteTree(){
        root = null;
    }

    public void levelOrderReverse(){
        if(root==null){
            System.out.println("The size is 0 as the tree is empty");
            return;
        }
        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            stack.push(temp);

            if(temp.left!=null)
                queue.add(temp.left);

            if(temp.right!=null)
                queue.add(temp.right);
        }

        if(!stack.isEmpty())
            System.out.print(stack.pop().data+" ");
    }

    public int depthOrHeight(Node root){
        if(root==null){
            return 0;
        }
        int leftDepth = depthOrHeight(root.left);
        int rightDepth = depthOrHeight(root.right);

        return Math.max(leftDepth+1,rightDepth+1);

    }

    public int mindepth(Node root){
        if(root==null)
            return 0;

        if(root.right==null && root.left==null)
            return 1;

        if(root.right==null)
            return mindepth(root.left)+1;

        if(root.left==null)
            return mindepth(root.right)+1;

        return Math.min(mindepth(root.left),mindepth(root.right))+1;
    }

    public void deepestNode(){
        if(root==null) {
            System.out.println("tree is empty");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node temp=null;
        while (!queue.isEmpty()){
            temp=queue.poll();
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
        Node deepest = temp;
        System.out.println("Deepest node is "+deepest);
    }

    public void deleteNode(Node del){
        if(root==null) {
            System.out.println("tree is empty");
            return;
        }
        if(root.left==null && root.right==null){
            if(root==del) {
                root = null;
                return;
            }
            else return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node temp=null;
        Node keyNode=null;
        while (!queue.isEmpty()){
            temp=queue.poll();
            if(temp==del)
                keyNode=temp;
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
        Node deepest = temp;
        if (keyNode != null) {
            int x = deepest.data;
            Queue<Node> q = new LinkedList<Node>();
            q.add(root);
            Node temp2 = null;
            while (!q.isEmpty()) {
                temp2 = q.peek();
                q.remove();

                if (temp2 == deepest) {
                    temp2 = null;
                    return;
                }
                if (temp2.right!=null) {
                    if (temp2.right == deepest) {
                        temp2.right = null;
                        return;
                    } else
                        q.add(temp2.right);
                }

                if (temp2.left != null) {
                    if (temp2.left == deepest) {
                        temp2.left = null;
                        return;
                    } else
                        q.add(temp2.left);
                }
            }
            keyNode.data = x;
        }


    }

    public void countLeaf(){
        if(root==null){
            System.out.println("Tree is empty");
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int count=0;
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.left==null && temp.right==null)
                count++;
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }

        System.out.println("Leafs are "+count);
    }

    public void fullNode(){
        if(root==null){
            System.out.println("Tree is empty.. 0 full nodes");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        int count=0;
        queue.add(root);
        if(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.right!=null && temp.left!=null)
                count++;
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
        System.out.println("Full nodes are "+count);
    }

    public void halfNode(){
        if(root==null){
            System.out.println("Tree is empty.. 0 full nodes");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        int count=0;
        queue.add(root);
        if(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.right==null && temp.left!=null || temp.left==null && temp.right!=null)
                count++;
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
        System.out.println("Full nodes are "+count);
    }

    public void identical(Node rootToCompare){
        if(root==null || rootToCompare==null){
            System.out.println("Tree is empty");
            return;
        }
        if(root==null && rootToCompare==null){
            System.out.println("Tree is empty but identical");
            return;
        }
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.add(root);
        q2.add(rootToCompare);
        Boolean check = true;
        while(!q1.isEmpty() && !q2.isEmpty()){
            Node temp1 = q1.poll();
            Node temp2 = q2.poll();
            if(temp1!=temp2){
                check=false;
                break;
            }
            if(temp1.left!=null)
                q1.add(temp1.left);
            if(temp1.right!=null)
                q1.add(temp1.right);
            if(temp2.left!=null)
                q2.add(temp2.left);
            if(temp2.right!=null)
                q2.add(temp2.right);

        }
        System.out.println("the trees are identical = "+check);

    }

    public int diameterOrWidth(Node root){
        if(root==null)
            return 0;

        int lheight = depthOrHeight(root.left);
        int rheight = depthOrHeight(root.right);

        int ldiameter = diameterOrWidth(root.left);
        int rdiameter = diameterOrWidth(root.right);

        return Math.max(lheight+rheight+1,Math.max(ldiameter,rdiameter));

    }

    public void maxwidth() {
        if (root == null)
            return;
        int maxwidth = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();
            maxwidth = Math.max(maxwidth, count);
            while (count-- > 0) {
                Node temp = q.remove();
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }

        System.out.println("The max width of the tree is "+maxwidth);
    }

    public void maxSum() {
        if(root==null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int maxSum=Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int count=queue.size();
            int sum=0;
            while(count-- !=0){
                Node temp = queue.remove();
                sum=sum+temp.data;
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            maxSum=Math.max(maxSum,sum);
        }
        System.out.println("The max sum of the levels is "+maxSum);
    }

    public void printPaths(Node root, int [] arr, int len){
        if(root==null)
            return;

        arr[len]=root.data;
        len++;

        if(root.left==null && root.right==null) {
            for (int i = 0; i < len; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
        else{
            printPaths(root.left,arr,len);
            printPaths(root.right,arr,len);
        }


    }

    public boolean pathSum(Node root, int sum){
        if(root==null)
            return false;
        if(root.data==sum && root.right==null && root.left==null)
            return true;
        else{
            return pathSum(root.left, sum - root.data) || pathSum(root.right, sum - root.data);
        }
    }

    public void sumAllNode(){
        if(root==null) {
            System.out.println("the sum is 0");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int sum=0;
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            sum += temp.data;
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }

        System.out.println("Sum of all nodes is " +sum);
    }

    public void mirror(){
        if(root==null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node current = queue.poll();

            Node temp = current.left;
            current.left=current.right;
            current.right = temp;

            if(current.left!=null)
                queue.add(current.left);

            if(current.right!=null)
                queue.add(current.right);
        }
    }

    public boolean checkmirror(Node root1, Node root2){
        if(root1==null && root2==null)
            return true;

        if(root1==null || root2==null)
            return false;

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.add(root1);
        q2.add(root2);
        while(!q1.isEmpty() && !q2.isEmpty()){
            Node temp1=q1.poll();
            Node temp2=q2.poll();
            if(temp1.data!=temp2.data){
                return false;
            }
            if(temp1.left!=null)
                q1.add(temp1.left);

            if(temp1.right!=null)
                q1.add(temp1.right);

            if(temp2.right!=null)
                q2.add(temp2.right);

            if(temp2.left!=null)
                q2.add(temp2.left);

        }
        return true;
    }

    public boolean ancestor(Node root, int target){
        if(root==null)
            return false;

        if(root.data==target)
            return true;

        if(ancestor(root.left,target)||ancestor(root.right,target)){
            System.out.println(root.data+" ");
            return true;
        }
        return false;
    }

    public Node lca(Node root, Node n1, Node n2){
        if(root==null)
            return null;

        if(root==n1 || root==n2)
            return root;

        Node left = lca(root.left,n1,n2);
        Node right = lca(root.right,n1,n2);

        if(left!=null && right!=null)
            return root;

        if(left!=null)
            return left;
        else
            return right;
    }

    public void zigzag(){
        if(root==null)
            return;

        Stack<Node> current = new Stack<>();
        Stack<Node> next = new Stack<>();

        current.push(root);
        Boolean lefttoright = true;

        while(!current.isEmpty()){
            Node temp = current.pop();
            if(temp!=null){
                System.out.println(temp.data+" ");

                if(lefttoright){
                    if(temp.left!=null)
                        next.push(temp.left);
                    if(temp.right!=null)
                        next.push(temp.right);
                } else{
                    if(temp.right!=null)
                        next.push(temp.right);
                    if(temp.left!=null)
                        next.push(temp.left);
                }
            }

            if(current.isEmpty()){
                lefttoright=!lefttoright;
                Stack<Node> swap = current;
                current=next;
                next=swap;
            }
        }

    }


}
