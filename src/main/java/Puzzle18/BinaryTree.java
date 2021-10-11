package Puzzle18;

public class BinaryTree{
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public int minSum() {
        if (getRoot() == null) {
            throw new RuntimeException("Empty Binary Tree");
        }
        int count = 0;
        return minSumRecursive(getRoot(), count);
    }

    private int minSumRecursive(Node node, int count) {
        count += node.getData();
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            return count;
        }
        else if (node.getLeftChild() == null) {
            return minSumRecursive(node.getRightChild(), count);
        }
        else if (node.getRightChild() == null) {
            return minSumRecursive(node.getLeftChild(), count);
        }
        else {
            return Math.min(minSumRecursive(node.getLeftChild(), count), minSumRecursive(node.getRightChild(), count));
        }
    }


}
