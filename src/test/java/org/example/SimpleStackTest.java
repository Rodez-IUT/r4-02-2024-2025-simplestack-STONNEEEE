package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test behaviour of a SimpleStack")
class SimpleStackTest {

    @Test
    @DisplayName("Test the state of a newly created slack")
    public void testCreateEmptyStack() { // Test case

        // When a fresh stack is created
        Stack stack = new SimpleStack();

        // Then… (oracle)
        assertTrue(stack.isEmpty(), "A new stack must be empty");
        assertEquals( 0, stack.getSize(), "A new stack has no element");
    }

    @Test
    @DisplayName("Test the push of items")
    public void testPush() throws EmptyStackException {

        // Given an empty stack and an item
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();

        // When the item is pushed in the stack
        stack.push(item);

        // Then…
        assertEquals(1, stack.getSize(),"The stack must contain 1 item");

        // Given a new item to add
        Item item2 = new SimpleItem();

        // When we add the new item
        stack.push(item2);

        // then...
        assertEquals(2, stack.getSize(),"The stack must contain 2 items");
    }

    @Test
    @DisplayName("Test limit when trying to pop an empty stack")
    public void testPopOnEmptyStack()  {
        // Given an empty stack
        Stack stack = new SimpleStack();

        // When we "pop" the stack, should throw an EmptyStackException.
        assertThrows(EmptyStackException.class, stack::pop, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test nominal quand on essaye de pop une stack non vide")
    public void testPopOnNotEmptyStack() {
        // Given an empty stack
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();

        stack.push(item);
        // When we "pop" the stack, shouldn't throw an Exception.
        assertDoesNotThrow(stack::pop, "Stack should have been empty");
        assertTrue(stack.isEmpty(), "The stack must not be empty");
        assertEquals(0, stack.getSize(),"The stack must contain 1 item");
    }

    @Test
    @DisplayName("Test limit when trying to peek the first element of an empty stack")
    public void testPeekOnEmptyStack() {
        // Given an empty stack
        Stack stack = new SimpleStack();

        // When we "pop" the stack, shouldn't throw an Exception.
        assertThrows(EmptyStackException.class, stack::peek, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test limit when trying to peek the first element of an empty stack")
    public void testPeekOnNotEmptyStack() throws EmptyStackException {
        // Given a stack with two items
        Stack stack = new SimpleStack();

        Item item = new SimpleItem();
        Item item2 = new SimpleItem();

        stack.push(item);
        stack.push(item2);

        assertEquals(item2, stack.peek(), "EmptyStackException is thrown");
    }

    @Test
    @DisplayName("Test limit when ")
    public void testIsEmptyOnNotEmptyStack() throws EmptyStackException {
        // Given a stack with two items
        Stack stack = new SimpleStack();

        Item item = new SimpleItem();
        Item item2 = new SimpleItem();

        stack.push(item);
        stack.push(item2);

        assertFalse(stack.isEmpty(), "The stack must not be empty");
    }

    @Test
    @DisplayName("Test limit when ")
    public void testIsEmptyOnEmptyStack() {
        // Given a stack with two items
        Stack stack = new SimpleStack();

        assertTrue(stack.isEmpty(), "The stack must be empty");
    }

    @Test
    @DisplayName("Test limit when ")
    public void testGetSizeOnNotEmptyStack() throws EmptyStackException {
        // Given a stack with two items
        Stack stack = new SimpleStack();

        Item item = new SimpleItem();
        Item item2 = new SimpleItem();

        stack.push(item);
        stack.push(item2);

        assertEquals(2, stack.getSize(), "EmptyStackException is thrown");
    }

    @Test
    @DisplayName("Test limit when ")
    public void testGetSizeOnEmptyStack() throws EmptyStackException {
        // Given a stack with two items
        Stack stack = new SimpleStack();

        assertEquals(0, stack.getSize(), "EmptyStackException is thrown");
    }
}
