package telran.util;

import java.util.HashMap;

public class Anagram {
	/**
	 * O[N]
	 * @param word
	 * @param anagram
	 * @return true if anagram is one of the possible anagrams of a given word
	 * anagram is a string containing all symbols from a given word with different order
	 * Example: yellow {wolely, lowlye, yellow}, wrong anagrams{yello, yelllw} 
	 */
public static boolean isAnagram(String word, String anagram) {

	boolean res = false;
	if(word.length() == anagram.length() || word.length() == 0) {
		res = true;
	
		HashMap<Character, Integer> hashMap = new HashMap<>();
		char[] word1 = word.toLowerCase().toCharArray();
		char[] word2 = anagram.toLowerCase().toCharArray();	
		for(char c: word1) {
			hashMap.put(c, hashMap.compute(c, (k, v) -> (v == null) ? 1 : v+1));
		}
		for(char c: word2) {
			hashMap.merge(c, 1, (oldV, newV) -> oldV - newV);
		}
		for(int n: hashMap.values()) {
			if(n != 0) {
				res = false;
			}
		}
	}
	return res;
}

}
