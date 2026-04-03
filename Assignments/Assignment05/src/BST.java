import java.util.LinkedList;

public class BST {
    // Fields

    private BSTNode root;

    // Constructors

    public BST() {
        this(null);
    }

    public BST(BSTNode root) {
        this.root = root;
    }

    // Getters and Setters

    public BSTNode getRoot() {
        return root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    // Other Methods

    /**
     * Inserts a new node containing a specified string into the Binary Search Tree
     * at the proper position sorted alphabetically, if duplicate values are found
     * they are not inserted.
     * 
     * @param s The string to be contained in the node
     */
    public void insert(String s) {
        if (root == null) {
            root = new BSTNode(s);
            return;
        }
        BSTNode node = new BSTNode(s);
        BSTNode testNode = root;
        BSTNode prevNode = null;
        while (testNode != null) {
            prevNode = testNode;
            if (s.compareTo(testNode.getData()) < 0) {
                testNode = testNode.getLeft();
            } else {
                testNode = testNode.getRight();
            }
        }
        if (s.compareTo(prevNode.getData()) < 0) {
            prevNode.setLeft(node);
        } else {
            prevNode.setRight(node);
        }
    }

    /**
     * Computes the height of the Binary Search Tree. An empty tree has a height of
     * 0.
     * 
     * @return the height of the tree
     */
    public int height() {
        if (root == null) {
            return 0;
        }
        return height(root);
    }

    /**
     * Recursively computes the height of the subtree starting at a specific root.
     * 
     * @param root The root of the subtree
     * @return The height of the subtree
     */
    private int height(BSTNode root) {
        // Base Case
        if (root == null)
            return 0;

        // Recursive Case
        int leftHeight = height(root.getLeft());
        int rightHeight = height(root.getRight());
        int max = Math.max(leftHeight, rightHeight);
        return 1 + max;
    }

    /**
     * Prints the contents of the Binary Search Tree, using depth first search, on a
     * single line seperated by spaces.
     */
    public void printDepthFirst() {
        printDepthFirst(root);
        System.out.println();
    }

    /**
     * Recursively prints the contents of a subtree starting at a specific root on a
     * single line seperated by spaces.
     * 
     * @param root the root of the subtree
     */
    private void printDepthFirst(BSTNode root) {
        // Base Case
        if (root == null)
            return;
        // Recursive Case
        printDepthFirst(root.getLeft());
        System.out.print(root.getData() + " ");
        printDepthFirst(root.getRight());
    }

    /**
     * Prints the contents of the Binary Search Tree, using breadth first search
     * method, on a single line seperated by spaces.
     */
    public void printBreadthFirst() {
        if (root == null) {
            return;
        }

        LinkedList<BSTNode> queue = new LinkedList<BSTNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BSTNode node = queue.removeFirst();

            System.out.print(node.getData() + " ");

            if (node.getLeft() != null)
                queue.add(node.getLeft());
            if (node.getRight() != null)
                queue.add(node.getRight());
        }
        System.out.println();
    }

    public static void main(String[] args){
        System.out.println("Tasks 1, 2, and 6 are running");
        BST tree = new BST();
        tree.insert("U");
        tree.insert("W");
        tree.insert("E");
        tree.insert("A");
        tree.insert("U");
        tree.insert("C");
        tree.insert("L");
        tree.insert("A");
        tree.insert("I");
        tree.insert("R");
        tree.insert("E");

        System.out.println("==========");
        System.out.println("Task 3 output:");
        int height = tree.height();
        System.out.print("Tree Height: ");
        System.out.println(height);

        System.out.println("==========");
        System.out.println("Task 4 output:");
        tree.printDepthFirst();

        System.out.println("==========");
        System.out.println("Task 5 output:");
        tree.printBreadthFirst();
    }
}