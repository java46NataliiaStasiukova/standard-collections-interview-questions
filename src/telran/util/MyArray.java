package telran.util;

import java.util.HashMap;

/**
 * All methods of the class should have complaxity O[1]
 * @author nataliiastasiukova
 *
 * @param <T>
 */
public class MyArray<T> {
	int size;
	T defaultValue;
	HashMap<Integer, T> hashMap;
	public MyArray(int size) {
		this.size = size;
		hashMap = new HashMap<>();
		defaultValue = null;
	}
	/**
	 * sets all array elements with a given value
	 * @param value
	 */
	public void setAll(T value) {
		hashMap = new HashMap<>();
		defaultValue = value;
	}
	/**
	 * 
	 * @param index
	 * @return value at given index or null if index wrong
	 */
	public T get(int index) {
		T res = defaultValue;;
		if(index < 0 || index > size) {
			return null;
		}
		if(hashMap.get(index) != null) {
			
			res =  hashMap.get(index);
		}
		return res;
	}
	/**
	 * sets a given value at a given index
	 * throws IndexOutOfBoundsException in the case of wrong index
	 * @param index
	 * @param value
	 */
	public void set(int index, T value) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		hashMap.put(index, value);
		
	}
}
