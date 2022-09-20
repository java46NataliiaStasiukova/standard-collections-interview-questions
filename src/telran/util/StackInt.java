package telran.util;

import java.util.NoSuchElementException;

public class StackInt {
	private static final int defaultCapacity = 1000000;
	private int array[];
	private int top;
	private int max;
	private int arrayMax[];
	private int index;
	
	public StackInt(){
		array = new int[defaultCapacity];
		top = -1;
		arrayMax = new int[defaultCapacity];
		index = -1;
	}	 
	public int pop() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		max = arrayMax[index--];
		int res = array[top--];
		return res;
	}
	public void push(int number) {
		if(isEmpty()) {
			max = number;
			arrayMax[++index] = number;
		}
		else if(max >= number) {
			arrayMax[++index] = max;
		}
		else {
			max = number;
			arrayMax[++index] = number;
		}	
		array[++top] = number;
	}
	public boolean isEmpty() {
		
		return top == -1;
	}
	public int getMaxNumber() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return arrayMax[index];
	}

}
