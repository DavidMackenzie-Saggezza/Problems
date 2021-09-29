package Puzzle2;

import org.junit.jupiter.api.Test;

import static Puzzle2.Intersection.getIntersection;
import static org.junit.jupiter.api.Assertions.*;

class IntersectionTest {

    @Test
    void name() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.setNext(node4);

        node2.setNext(node3);
        node3.setNext(node4);

        node4.setNext(node5);
        node5.setNext(node6);

        LinkedList ll1 = new LinkedList(node1);
        LinkedList ll2 = new LinkedList(node2);
        assertEquals(node4, getIntersection(ll1, ll2));
    }
}