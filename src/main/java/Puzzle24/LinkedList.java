package Puzzle24;


public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(Node head) {
        this.head = head;
    }

    public void rotate(int k) {
        Node oldHead = getHead();
        Node current = getHead();
        Node previous = null;
        while (current != null) {
            previous = current;
            current = current.getNext();
        }
        previous.setNext(oldHead);
        current = getHead();
        for (int i = 0; i < k; i++) {
            current = current.getNext();
        }
        setHead(current);
        current = oldHead;
        for (int i = 0; i < k - 1; i++) {
            current = current.getNext();
        }
        current.setNext(null);
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}