import java.util.*;
public class BinarySearchTree {

    private Node root;

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(int value) {
        if (isEmpty()) {
            this.root = new Node(value);
        } else {
            this.root.add(value);
        }
    }

    public void preOrder() {
        if (!isEmpty()) {
            this.root.preOrder();
        }
    }
    
    public void inOrder() {
        if (!isEmpty()) {
            this.root.inOrder();
        }
    }

    public void posOrder() {
        if (!isEmpty()) {
            this.root.posOrder();
        }
    }

    public int size() {
        return size(this.root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        else return 1 + size(node.left) + size(node.right);
    }

    public int countLeafs() {
        if (!isEmpty())
            return this.root.countLeafs();
        return 0;
    }

    public void bfs() {
        if (!isEmpty()) {
            Deque<Node> queue = new LinkedList<Node>();
            queue.addLast(this.root);

            while (!queue.isEmpty()) {
            
                Node n = queue.removeFirst();
                System.out.print(n.value + " ");
            
                if (n.left != null)
                    queue.addLast(n.left);
            
                if (n.right != null)
                    queue.addLast(n.right);
            
            }
        }
    }

}

class Node {

    int value;
    Node right;
    Node left;

    Node(int value) {
        this.value = value;
    }

    void add(int value) {
        if (value > this.value) {
            if (this.right == null)
                this.right = new Node(value);
            else {
                this.right.add(value);
            }
        } else if (value < this.value) {
            if (this.left == null) {
                this.left = new Node(value);
            } else {
                this.left.add(value);
            }
        }

    }
    
    void inOrder() {
        if (this.left != null) this.left.inOrder();
        System.out.print(this.value + " ");
        if (this.right != null) this.right.inOrder();
    }

    void preOrder() {
        System.out.print(this.value + " ");
        if (this.left != null) this.left.preOrder();
        if (this.right != null) this.right.preOrder();
    }

    void posOrder() {
        if (this.left != null) this.left.posOrder();
        if (this.right != null) this.right.posOrder();
        System.out.print(this.value + " ");
    }
    
    int size() {
        int leftSize = (this.left == null) ? 0 : this.left.size();
        int rightSize = (this.right == null) ? 0 : this.right.size();
    
        return 1 + leftSize + rightSize;
    }

    int countLeafs() {
        int i = 0;
        if (this.left == null && this.right == null)
            i = 1;
        
        if (this.left != null)
            i+= left.countLeafs();
        
        if (this.right != null)
            i+= right.countLeafs();

        return i;
    }
}