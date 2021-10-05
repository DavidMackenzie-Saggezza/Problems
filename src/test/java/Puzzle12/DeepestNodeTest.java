package Puzzle12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeepestNodeTest {
    @Test
    void emptyBinaryTreeReturnsNull() {
        Node<Integer> node = null;
        BinaryTree<Integer> binaryTree = new BinaryTree<>(node);
        assertNull(binaryTree.getDeepest());
    }

    @Test
    void SingleElementBinaryTreeReturnsRoot() {
        Node<Integer> node = new Node<>(1);
        BinaryTree<Integer> binaryTree = new BinaryTree<>(node);
        assertEquals(node, binaryTree.getDeepest());
    }

    @Test
    void example() {
        Node<String> nodeA = new Node<>("a");
        Node<String> nodeB = new Node<>("b");
        Node<String> nodeC = new Node<>("c");
        Node<String> nodeD = new Node<>("d");
        nodeA.setLeftChild(nodeB);
        nodeB.setLeftChild(nodeD);
        nodeA.setRightChild(nodeC);
        BinaryTree<String> binaryTree = new BinaryTree<>(nodeA);
        assertEquals(nodeD, binaryTree.getDeepest());
    }

    @Test
    void longerRightSide() {
        Node<String> nodeA = new Node<>("a");
        Node<String> nodeB = new Node<>("b");
        Node<String> nodeC = new Node<>("c");
        Node<String> nodeD = new Node<>("d");
        Node<String> nodeE = new Node<>("e");
        Node<String> nodeF = new Node<>("f");
        Node<String> nodeG = new Node<>("g");
        nodeA.setLeftChild(nodeB);
        nodeB.setLeftChild(nodeD);
        nodeB.setRightChild(nodeE);
        nodeA.setRightChild(nodeC);
        nodeC.setRightChild(nodeF);
        nodeF.setLeftChild(nodeG);
        BinaryTree<String> binaryTree = new BinaryTree<>(nodeA);
        assertEquals(nodeG, binaryTree.getDeepest());
    }

    @Test
    void onlyLeftChildren() {
        Node<String> nodeA = new Node<>("a");
        Node<String> nodeB = new Node<>("b");
        Node<String> nodeC = new Node<>("c");
        Node<String> nodeD = new Node<>("d");
        nodeA.setLeftChild(nodeB);
        nodeB.setLeftChild(nodeC);
        nodeC.setLeftChild(nodeD);
        BinaryTree<String> binaryTree = new BinaryTree<>(nodeA);
        assertEquals(nodeD, binaryTree.getDeepest());
    }

    @Test
    void singleChildren() {
        Node<String> nodeA = new Node<>("a");
        Node<String> nodeB = new Node<>("b");
        Node<String> nodeC = new Node<>("c");
        Node<String> nodeD = new Node<>("d");
        nodeA.setLeftChild(nodeB);
        nodeB.setRightChild(nodeC);
        nodeC.setLeftChild(nodeD);
        BinaryTree<String> binaryTree = new BinaryTree<>(nodeA);
        assertEquals(nodeD, binaryTree.getDeepest());
    }
}