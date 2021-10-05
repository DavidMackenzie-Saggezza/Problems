package Puzzle12;

public class Node<E>{
    private E data;
    private Node<E> leftChild;
    private Node<E> rightChild;

    public Node(E data) {
        this.data = data;
    }

    public void setLeftChild(Node<E> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node<E> rightChild) {
        this.rightChild = rightChild;
    }

    public Node<E> getLeftChild() {
        return leftChild;
    }

    public Node<E> getRightChild() {
        return rightChild;
    }
}
