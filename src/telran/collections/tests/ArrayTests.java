package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class ArrayTests {

	@Test
	void halfSum() {
		int arWithHalfSum[] = {40, -20, 50, 10, 20};//sum = 100, 40 + 10 = 50
		int arWithNoHalfSum[] = {40, -20, 50, 5, 25};//sum = 100, no two numbers with sum = 50
		assertTrue(isHalfSumTwoNumbers(arWithHalfSum));
		assertFalse(isHalfSumTwoNumbers(arWithNoHalfSum));
		
		int arWithHalfSumWithRepeated[] = {50, 25, 10, 25, -10};
		int arWithNoHalfSumWithRepeated[] = {50, 25, 10, 25, -10, 40};
		
		assertTrue(isHalfSumTwoNumbersWithRepeated(arWithHalfSumWithRepeated));
		assertFalse(isHalfSumTwoNumbersWithRepeated(arWithNoHalfSumWithRepeated));
	}
	/**
	 * 
	 * @param array with no limitation of the numbers values
	 * @return true if there are two numbers with sum equaled
	 * half of total sum of a given array
	 */
	private boolean isHalfSumTwoNumbers(int[] array) {
		HashSet<Integer> hashSet = new HashSet<>();
		int halfSum = IntStream.of(array).sum()/2;
		IntStream.of(array).forEach(n -> hashSet.add(n));
		for(int num: hashSet) {
			if(hashSet.contains(halfSum - num) && halfSum - num != num) {
				return true;
			}
		}
		return false;
	}
	private boolean isHalfSumTwoNumbersWithRepeated(int[] array) {
		HashSet<Integer> hashSet = new HashSet<>();
		HashSet<Integer> repeatedNumsSet = new HashSet<>();
		int halfSum = IntStream.of(array).sum()/2;
		IntStream.of(array).forEach(n -> {
			if(hashSet.add(n) == false) {
				repeatedNumsSet.add(n);
			}
		});
		if(array.length != hashSet.size()) {
			
		}	
		for(int num: hashSet) {
			if(hashSet.contains(halfSum - num) && halfSum - num != num || repeatedNumsSet.contains(halfSum - num)) {
				return true;
			}
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
		HashSet<Integer> hashSet = new HashSet<>();
		IntStream.of(array).forEach(n -> hashSet.add(n));
		TreeSet<Integer> treeSet = new TreeSet<>(hashSet);
		int res = -1;
		Iterator<Integer> it = treeSet.descendingIterator();
		while(it.hasNext()) {
			int tmp = it.next();
			if(hashSet.contains(-tmp)) {
				res = tmp;
				break;
			}
		}	
		return res;
	}

}
