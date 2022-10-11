package telran.util;
import java.util.*;
public class Words {
TreeSet<String> treeSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
	/**
	 * adds word
	 * @param word
	 * @return true if added, otherwise false if an word already exists(case insensitive)
	 */
	public boolean addWord(String word) {

		return treeSet.add(word);
	}
	/**
	 * 
	 * @param prefix
	 * @return list of words starting from a given prefix  (case insensitive)
	 */
	public List<String> getWordsByPrefix(String prefix){
		String first = treeSet.ceiling(prefix);
		String last = treeSet.floor(prefix + Character.MAX_VALUE);
		TreeSet<String> subList = (TreeSet<String>)treeSet.subSet(first, true, last, true);

		return new ArrayList<>(subList);
	}
}
