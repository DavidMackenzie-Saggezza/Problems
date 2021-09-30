package Puzzle11;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void emptyLinkedListDoesNothing() {
        LinkedList ll = new LinkedList();
        ll.reverse();
        assertNull(ll.getHead());
    }

    @Test
    void OneElementLinkedListDoesNothing() {
        Node node1 = new Node(1);
        LinkedList ll = new LinkedList(node1);
        ll.reverse();
        assertEquals(node1, ll.getHead());
    }

    @Test
    void twoElementLinkedListSwapsElements() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.setNext(node2);
        LinkedList ll = new LinkedList(node1);
        ll.reverse();
        assertEquals(node2, ll.getHead());
        assertEquals(node1, ll.getHead().getNext());
        assertNull(ll.getHead().getNext().getNext());
    }

    @Test
    void ThreeElementLinkedListReversesElements() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.setNext(node2);
        node2.setNext(node3);
        LinkedList ll = new LinkedList(node1);
        ll.reverse();
        assertEquals(node3, ll.getHead());
        assertEquals(node2, ll.getHead().getNext());
        assertEquals(node1, ll.getHead().getNext().getNext());
        assertNull(ll.getHead().getNext().getNext().getNext());
    }
}