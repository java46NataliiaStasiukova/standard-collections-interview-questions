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
	boolean res = true;
	if(word.length() != anagram.length() || word.length() == 0) {
		return false;
	}
	HashMap<Character, Integer> hashMap = new HashMap<>();
	char[] word1 = word.toLowerCase().toCharArray();
	char[] word2 = anagram.toLowerCase().toCharArray();
	for(int i = 0; i < word.length(); i++) {
		Integer count = hashMap.getOrDefault(word1[i], 0);
		hashMap.put(word1[i], count + 1);
		count = hashMap.getOrDefault(word2[i], 0);
		hashMap.put(word2[i], count - 1);
	}
	for(int n: hashMap.values()) {
		if(n != 0) {
			res = false;
		}
	}
	return res;
}


}

