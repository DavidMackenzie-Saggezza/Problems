package Puzzle18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MinimumPathSumTest {
    @Test
    void emptyBinaryTreeThrowsError() {
        BinaryTree binaryTree = new BinaryTree(null);
        assertThrows(RuntimeException.class, binaryTree::minSum);
    }

    @Test
    void onlyRootNodeReturnsValueOfRootNode() {
        Node node1 = new Node(10);
        BinaryTree binaryTree = new BinaryTree(node1);
        assertEquals(10, binaryTree.minSum());
    }

    @Test
    void rootNodeWithOneChildReturnsSum() {
        Node node1 = new Node(10);
        Node node2 = new Node(5);
        node1.setLeftChild(node2);
        BinaryTree binaryTree = new BinaryTree(node1);
        assertEquals(15, binaryTree.minSum());
    }

    @Test
    void rootNodeWithTwoChildren() {
        Node node1 = new Node(10);
        Node node2 = new Node(5);
        Node node3 = new Node(-23);
        node1.setLeftChild(node2);
        node1.setRightChild(node3);
        BinaryTree binaryTree = new BinaryTree(node1);
        assertEquals(-13, binaryTree.minSum());
    }

    @Test
    void LeftChildOfRootBecomesSmallestBeforeLeaf() {
        Node node1 = new Node(10);
        Node node2 = new Node(5);
        Node node3 = new Node(-23);
        Node node4 = new Node(29);
        node1.setLeftChild(node2);
        node1.setRightChild(node3);
        node3.setLeftChild(node4);
        BinaryTree binaryTree = new BinaryTree(node1);
        assertEquals(15, binaryTree.minSum());
    }

    @Test
    void exampleReturns15() {
        Node node1 = new Node(10);
        Node node2 = new Node(5);
        Node node3 = new Node(5);
        Node node4 = new Node(2);
        Node node5 = new Node(1);
        Node node6 = new Node(-1);
        node1.setLeftChild(node2);
        node1.setRightChild(node3);
        node2.setRightChild(node4);
        node3.setRightChild(node5);
        node5.setLeftChild(node6);
        BinaryTree binaryTree = new BinaryTree(node1);
        assertEquals(15, binaryTree.minSum());
    }
}