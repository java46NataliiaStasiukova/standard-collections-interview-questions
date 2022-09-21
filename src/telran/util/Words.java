package telran.util;
import java.util.*;
public class Words {
TreeSet<String> treeSet = new TreeSet<>();
	/**
	 * adds word
	 * @param word
	 * @return true if added, otherwise false if an word already exists(case insensitive)
	 */
	public boolean addWord(String word) {
		word = word.toLowerCase();
		if(!treeSet.contains(word)) {
			treeSet.add(word);
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @param prefix
	 * @return list of words starting from a given prefix  (case insensitive)
	 */
	public List<String> getWordsByPrefix(String prefix){
		prefix = prefix.toLowerCase();
		String first = treeSet.ceiling(prefix);
		String last = treeSet.floor(prefix + Character.MAX_VALUE);
		TreeSet<String> subList = (TreeSet<String>)treeSet.subSet(first, true, last, true);
		List<String> list = new ArrayList<>(subList);

		return list;
	}
}
