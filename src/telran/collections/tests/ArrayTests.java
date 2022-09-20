package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.Test;

class ArrayTests {

	@Test
	void halfSum() {
		int arWithHalfSum[] = {40, -20, 50, 10,20};//sum = 100, 40 + 10 = 50
		int arWithNoHalfSum[] = {40, -20, 50, 5, 25};//sum = 100, no two numbers with sum = 50
		assertTrue(isHalfSumTwoNumbers(arWithHalfSum));
		assertFalse(isHalfSumTwoNumbers(arWithNoHalfSum));
	}
	/**
	 * 
	 * @param array with no limitation of the numbers values
	 * @return true if there are two numbers with sum equaled
	 * half of total sum of a given array
	 */
	private boolean isHalfSumTwoNumbers(int[] array) {
		// TODO 
		return false;
	}
	
	@Test
	void valueWithMaxNegativeTest() {
		int arWithNegative[] = {10, 20000000, 2, 4, 40, -4, 10, -20000000, -2};
		int arWithNoNegative[] = {10, 20, 2, 4, 40, -14, 10, -21, -3};
		assertEquals(20, valueWithMaxNegative(arWithNegative));
		assertEquals(-1, valueWithMaxNegative(arWithNoNegative));
		
	}
	//HashSet + TreeSet
	/**
	 *
	 * @param array with numbers that may have the huge values
	 * @return maximal value with existing negative image (negative value with same absolute value)
	 * if no value with its negative image the function returns -1
	 */
	private Integer valueWithMaxNegative(int[] array) {
		// TODO 
		return -1;
	}

}
