import java.util.LinkedList;

public class BSTNode {

    // Fields

    private String data;
    private BSTNode left;
    private BSTNode right;

    // Constructor

    public BSTNode(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // Getters and Setters

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    // Other Methods

    public void queueBreadthFirstSearch(LinkedList<BSTNode> queue) {
        queue.add(this);
    }

    public int height() {
        return 0;
    }

}
