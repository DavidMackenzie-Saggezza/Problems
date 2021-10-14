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
        Node lastNode = null;
        while (current != null) {
            lastNode = current;
            current = current.getNext();
        }
        lastNode.setNext(oldHead);

        Node kthNode = oldHead;
        Node nodeBeforekthNode = oldHead;
        for (int i = 0; i < k - 1; i++) {
            kthNode = kthNode.getNext();
            nodeBeforekthNode = nodeBeforekthNode.getNext();
        }
        kthNode = kthNode.getNext();
        setHead(kthNode);
        nodeBeforekthNode.setNext(null);
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}