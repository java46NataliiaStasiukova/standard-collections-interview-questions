package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class ArrayTests {

	@Test
	void halfSum() {
		int arWithHalfSum[] = {40, -20, 50, 10, 20}; //sum = 100, 40 + 10 = 50
		int arWithNoHalfSum[] = {40, -20, 50, 5, 25}; //sum = 100 , no two numbers with sum = 50
		assertTrue(isHalfSumTwoNumbers(arWithHalfSum));
		assertFalse(isHalfSumTwoNumbers(arWithNoHalfSum));
	}
/**
 * 
 * @param array with no limitations of the number values
 * @return true if there are two numbers with sum equaled 
 * half of total sum of a given array
 */
	private boolean isHalfSumTwoNumbers(int[] array) {
		int halfSum = Arrays.stream(array).sum() / 2;
		HashSet<Integer> setHelper = new HashSet<>();
		for(int num: array) {
			if (setHelper.contains(halfSum - num)) {
				return true;
			}
			setHelper.add(num);
		}
		
		return false;
	}
	
	@Test
	void valueWithMaxNegativeTest() {
		int arWithNegative[] = {10, 20000000, 2, 4, 40, -4, 10, -20000000, -2};
		int arWithNoNegative[] = {10, 20, 2, 4, 40, -14, 10, -21, -3};
		assertEquals(20000000, valueWithMaxNegative(arWithNegative));
		assertEquals(-1, valueWithMaxNegative(arWithNoNegative));
	}
	/**
	 * 
	 * @param array with numbers that may have the huge values
	 * @return maximal value with existing negative image (negative value with same absolute value)
	 * if no value with its negative image the function returns -1
	 */
	private Integer valueWithMaxNegative(int[] array) {
		int res = -1;
		HashSet<Integer> setHelper = new HashSet<>();
		for (int num: array) {
			int absNum = Math.abs(num);
			if (setHelper.contains(-num) && absNum > res) {
				res = absNum;
			}
			setHelper.add(num);
		}
		
		return res;
	}
	/**
	 * The method doesn't update a given array
	 * @param <T>
	 * @param array
	 * @return true if there is exactly one swap for getting sorted array
	 * examples: {1, 2, 3, 10, -1, 5, 6} -> false
	 * {1, 2, 3, 5, 6, 10} -> false
	 * {1,3,2,4, 3, 10} -> false
	 * {10, 2, 3, 4, 1} -> true
	 * {1, 2, 4, 3, 5, 10} -> true
	 * {1, 5, 3, 4, 2, 10} -> true
	 * {"lmn", "ab", "bc", "cd", "a"} -> true
	 * An Array should contain Comparable elements
	 */

	<T extends Comparable<T>> boolean isOneSwapForSorted (T [] array) {

		T[] test = Arrays.copyOf(array, array.length);
		int[] index = {-1, -1};
		int count = 0;
		for(int i = 1; i < array.length; i++) {
			if(test[i].compareTo(test[i - 1]) == -1) {
				if(count == 0) {
					index[0] = i - 1;
					index[1] = i;
					count++;
				} else {
					index[1] = i;
					count++;
				}	
			} 	
		}
		if(count > 2 || count == 0) {
			return false;	
		}
			test[index[0]] = array[index[1]];
			test[index[1]] = array[index[0]];
		for(int i = 1; i < array.length; i++) {
			if(test[i].compareTo(test[i -1]) == -1) {
				return false;
			}
		}

		return true;
	}
	@Test
	void isOneSwapTest() {
		Integer arTrue1[] = {1, 6, 3, 4, 2, 10};
		Integer arTrue2[] = {1, 2, 4, 3, 6, 10};
		Integer arTrue3[] = {10, 2, 3, 4, 6, 1};
		Integer arTrue4[] = {3, 2, 3, 4, 6, 10};
		Integer arTrue5[] = {1, 2, 3, 4, 6, 10, 7};
		assertTrue(isOneSwapForSorted(arTrue1));
		assertTrue(isOneSwapForSorted(arTrue2));
		assertTrue(isOneSwapForSorted(arTrue3));
		assertTrue(isOneSwapForSorted(arTrue4));
		assertTrue(isOneSwapForSorted(arTrue5));
		
		Integer arFalse1[] = {1, 10, 2, 3, 6, 4};
		Integer arFalse2[] = {1, 2, 4, 2, 10, 6};
		Integer arFalse3[] = {1, 2, 3, 4, 6, 10};
		assertFalse(isOneSwapForSorted(arFalse1));
		assertFalse(isOneSwapForSorted(arFalse2));	
		assertFalse(isOneSwapForSorted(arFalse3));
	}

}
