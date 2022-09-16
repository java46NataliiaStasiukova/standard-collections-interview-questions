package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.StackInt;

class StackIntTests {
	Integer[] numbers = {1,2,3,4};
	StackInt stack = new StackInt();
	@BeforeEach
	void setUp() {	
		for(int num: numbers) {
			stack.push(num);
		}
	}	
	@Test
	void testPop() {
		assertEquals(4, stack.pop());
		assertEquals(3, stack.pop());
		assertEquals(2, stack.pop());
		assertEquals(1, stack.pop());
		assertThrows(NoSuchElementException.class, () -> stack.pop());	
	}
	@Test
	void testPush() {
		stack.push(5);
		assertEquals(5, stack.pop());
		stack.push(10);
		stack.push(12);
		assertEquals(12, stack.pop());
	}
	@Test
	void testIsEmpty() {
		StackInt emptyStack = new StackInt();
		assertTrue(emptyStack.isEmpty());
		emptyStack.push(1);
		assertFalse(emptyStack.isEmpty());
	}
	@Test
	void testGetMaxNumber() {
		assertEquals(4, stack.getMaxNumber());
		stack.push(9);
		stack.push(5);
		assertEquals(9, stack.getMaxNumber());
		stack.pop();
		stack.pop();
		assertEquals(4, stack.getMaxNumber());
		stack.pop();
		stack.pop();
		assertEquals(2, stack.getMaxNumber());
		stack.pop();
		stack.pop();
		assertThrows(NoSuchElementException.class, () -> stack.getMaxNumber());	
		}

}
