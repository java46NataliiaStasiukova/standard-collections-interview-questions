package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.util.Words;

class WordsTest {

	@Test
	void testAddWord() {
		Words words = new Words();
		assertTrue(words.addWord("Hello"));
		assertFalse(words.addWord("Hello"));
		assertFalse(words.addWord("hello"));
		
	}
	@Test
	void testGetWordsByPrefix() {
		Words words = new Words();
		String[] expected = {
				"hello", "hello java", "hello telran", "helloworld"
		};
		String[] expected2 = {"java"};
		
		words.addWord("helloWorld");
		words.addWord("hello Java");
		words.addWord("hello Telran");
		words.addWord("hello");
		words.addWord("java");
		
		assertArrayEquals(expected, words.getWordsByPrefix("Hello").toArray());
		assertArrayEquals(expected2, words.getWordsByPrefix("Java").toArray());
		
		
	}

}
