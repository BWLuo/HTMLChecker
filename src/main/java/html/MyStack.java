package html;

/*
 * Implementation of a simple stack for HtmlTags.
 * You should implement this class.
 */

import java.util.ArrayList;

public class MyStack {
	// An ArrayList to hold HtmlTag objects.
	private ArrayList<HtmlTag> stack_internal;

	/*
	 * Create an empty stack.
	 */
	public MyStack( ) {
		this.stack_internal = new ArrayList<HtmlTag>( );
	}

	/*
	 * Push a tag onto the top of the stack.
	 */
	public void push( HtmlTag tag ) {
		stack_internal.add(0,tag);

	}

	/*
	 * Removes the tag at the top of the stack.
	 * throws an exception if the stack is empty.
	 */
	public HtmlTag pop( ) throws IllegalArgumentException  {
		if(stack_internal.isEmpty()) {
			throw new IllegalArgumentException();
		}
		else {
			return stack_internal.remove(0);
		}

	}

	/*
	 * Looks at the object at the top of the stack but
	 * does not actually remove the object.
	 * throws an exception if the stack is empty.
	 */
	public HtmlTag peek( ) {
		if (stack_internal.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return stack_internal.get(0);
	}

	/*
	 * Tests if the stack is empty.
	 * Returns true if the stack is empty;
	 * false otherwise.
	 */
	public boolean isEmpty( ) {
		return stack_internal.isEmpty();
	}
}
