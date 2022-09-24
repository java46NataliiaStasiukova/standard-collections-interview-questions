package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.MyArray;

class MyArrayTests {
	MyArray<String> myArray;
	@BeforeEach
	void setUp() {
		myArray = new MyArray<>(6);
	}
	@Test
	void testMyArray() {
		MyArray<Integer> myTest = new MyArray<>(12);
		assertNull(myTest.get(12));
		myTest.setAll(120);
		assertEquals(120, myTest.get(12));
		assertNull(myTest.get(13));
		
	}

	@Test
	void testSetAll() {
		myArray.setAll("Hello");
		assertEquals("Hello", myArray.get(3));
		assertEquals("Hello", myArray.get(0));
		assertEquals("Hello", myArray.get(6));	
	}

	@Test
	void testGet() {
		assertNull(myArray.get(5));
		assertNull(myArray.get(-2));
		assertNull(myArray.get(7));
		myArray.set(4, "Test");
		assertEquals("Test", myArray.get(4));
		myArray.setAll("Telran");
		assertEquals("Telran", myArray.get(4));
		
		
	}

	@Test
	void testSet() {
		myArray.set(2, "Telran");
		assertEquals("Telran", myArray.get(2));
		assertThrows(IndexOutOfBoundsException.class, ()-> myArray.set(-2, "Hello"));
	}

}