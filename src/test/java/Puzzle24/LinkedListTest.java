package Puzzle24;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListTest {

    @Test
    void example1() {
        Node node1 = new Node(7);
        Node node2 = new Node(7);
        Node node3 = new Node(3);
        Node node4 = new Node(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        LinkedList ll = new LinkedList(node1);
        int k = 2;
        ll.rotate(k);
        assertEquals(node3, ll.getHead());
        assertEquals(node4, ll.getHead().getNext());
        assertEquals(node1, ll.getHead().getNext().getNext());
        assertEquals(node2, ll.getHead().getNext().getNext().getNext());
    }

    @Test
    void example2() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        LinkedList ll = new LinkedList(node1);
        int k = 3;
        ll.rotate(k);
        assertEquals(node4, ll.getHead());
        assertEquals(node5, ll.getHead().getNext());
        assertEquals(node1, ll.getHead().getNext().getNext());
        assertEquals(node2, ll.getHead().getNext().getNext().getNext());
        assertEquals(node3, ll.getHead().getNext().getNext().getNext().getNext());
    }
}