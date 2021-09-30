package Puzzle11;

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(Node head) {
        this.head = head;
    }

    public void reverse() {
        if (getHead() == null) {
            return;
        }
        Node current = getHead();
        Node previous = null;
        Node next = current.getNext();
        while (next != null) {
            current.setNext(previous);
            previous = current;
            current = next;
            next = next.getNext();
        }
        current.setNext(previous);
        setHead(current);
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}
