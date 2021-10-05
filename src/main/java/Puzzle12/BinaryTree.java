package Puzzle12;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E>{
    private Node<E> root;

    public BinaryTree(Node<E> root) {
        this.root = root;
    }

    public Node<E> getDeepest() {
        if (root == null) {
            return null;
        }
        List<Node<E>> nodes = new ArrayList<>();
        List<Node<E>> children = new ArrayList<>();
        Node<E> lastNode = root;
        nodes.add(root);
        while (!nodes.isEmpty()) {
            for (Node<E> node: nodes) {
                if (node.getLeftChild() != null) {
                    children.add(node.getLeftChild());
                }
                if (node.getRightChild() != null) {
                    children.add(node.getRightChild());
                }
            }
            lastNode = nodes.get(0);
            nodes = children;
            children = new ArrayList<>();
        }
        return lastNode;
    }
}
