package Puzzle5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    @Test
    void poppingEmptyStackReturnsNull() {
        MyStack<Integer> stack = new MyStack();
        assertNull(stack.pop());
    }

    @Test
    void maxOnEmptyStackReturnsNull() {
        MyStack<Integer> stack = new MyStack();
        assertNull(stack.max());
    }

    @Test
    void sizeIncreasesAfterPushing() {
        MyStack<Integer> stack = new MyStack();
        stack.push(3);
        assertEquals(1, stack.getSize());
    }

    @Test
    void sizeDecreasesAfterPushing() {
        MyStack<Integer> stack = new MyStack();
        stack.push(3);
        stack.pop();
        assertEquals(0, stack.getSize());
    }

    @Test
    void popReturnsLastAddedElement() {
        MyStack<Integer> stack = new MyStack();
        stack.push(3);
        stack.push(7);
        assertEquals(7, stack.pop());
    }

    @Test
    void poppingTwiceReturnsCorrectElement() {
        MyStack<Integer> stack = new MyStack();
        stack.push(3);
        stack.push(7);
        stack.pop();
        assertEquals(3, stack.pop());
    }

    @Test
    void genericsWorkingWithPersonClassWhichImplementsComparable() {
        MyStack<Person> stack = new MyStack();
        stack.push(new Person("David", 18));
        stack.push(new Person("Chris", 21));
        Person maxAgePerson = stack.max();
        assertEquals(21, maxAgePerson.getAge());
    }
}