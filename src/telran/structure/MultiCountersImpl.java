package telran.structure;

import java.util.*;

public class MultiCountersImpl implements MultiCounters {
 HashMap<Object, Integer> items = new HashMap<>(); //key - item, value - counter
 TreeMap<Integer, HashSet<Object>> counters = new TreeMap<>(); //key counter, value - set of items having the key - counter
 @Override
	public Integer addItem(Object item) {
	 	items.compute(item, (k, v) -> (v == null) ? 1 : v + 1);
		int count = items.get(item);
		if(count > 1) {
			HashSet<Object> tmp = counters.get(count - 1);
			tmp.remove(item);
			if(tmp.isEmpty()) {
				counters.remove(count - 1);
			}	
		}
		counters.computeIfAbsent(count, c -> new HashSet<>()).add(item);
	 
		return count;
	}

	@Override
	public Integer getValue(Object item) {	
		
		return items.get(item);
	}

	@Override
	public boolean remove(Object item) {
		boolean res = false;
		Integer key = items.remove(item);
		if(key != null) {
			res = true;
			if(counters.get(key).size() > 1) {
				counters.get(key).remove(item);
			} else {
				counters.remove(key);
			}
		}
		return res;
	}

	@Override
	public Set<Object> getMaxItems() {
		if(counters.isEmpty()) {
			return new HashSet<>();
		}
		int key = counters.lastKey();
		return counters.get(key);
	}

}