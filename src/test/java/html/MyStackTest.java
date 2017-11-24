package html;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyStackTest {

	@Test (expected = IllegalArgumentException.class)
	public void emptyPop() {
		MyStack test = new MyStack();
		test.pop();
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void emptyPeek() {
		MyStack test = new MyStack();
		test.peek();
	}
}
