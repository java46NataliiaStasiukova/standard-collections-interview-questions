package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static telran.util.Anagram.isAnagram;
class AnagramTests {

	@Test
	void testIsAnagram() {
		assertTrue(isAnagram("Anagram", "anagram"));
		assertTrue(isAnagram("anagram", "graaamn"));
		assertTrue(isAnagram("yellow", "wolely"));
		assertTrue(isAnagram("yellow", "lowlye"));
		
		assertFalse(isAnagram("Anagram", "Abagra1"));
		assertFalse(isAnagram("", "Hello"));
		assertFalse(isAnagram("Hello", "ello"));
		assertFalse(isAnagram("hello", ""));
		//assertFalse(isAnagram("", ""));
	}
	String word = "yellow";
	@Test
	void testAnagramTrue() {
		assertTrue(isAnagram(word, "loweyl"));
		assertTrue(isAnagram(word, "elolyw"));
		assertTrue(isAnagram(word, "wolley"));
		assertTrue(isAnagram(word, "loleyw"));
		
	}
	@Test
	void testAnagramFalse() {
		assertFalse(isAnagram(word,""));
		assertFalse(isAnagram(word, "yellob"));
		assertFalse(isAnagram(word,"yello"));
		assertFalse(isAnagram(word,"yelllo"));
		


		
	}

}