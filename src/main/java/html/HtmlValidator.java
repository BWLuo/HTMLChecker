package html;

import java.util.LinkedList;
import java.util.Queue;

/*
 * This is the HtmlValidator class.
 * Represents a Document as its HtmlTag and validates the errors
 */
public class HtmlValidator {

	private Queue<HtmlTag> tags;

	/**
	 * Constructs a empty HtmlValidator
	 */
	public HtmlValidator() {
		this.tags = new LinkedList<HtmlTag>();
	}

	/**
	 * 
	 * @param tags
	 *            a document reduced to its HtmlTags
	 */
	public HtmlValidator(Queue<HtmlTag> tags) {
		if (tags == null) {
			throw new IllegalArgumentException();
		} else {
			this.tags = new LinkedList<HtmlTag>(tags);
		}
	}

	/**
	 * Adds a new Html tag to validator
	 * 
	 * @param tag
	 *            an Html tag to add to the validator
	 */
	public void addTag(HtmlTag tag) {
		if (tag == null) {
			throw new IllegalArgumentException();
		} else {
			this.tags.add(tag);
		}
	}

	/**
	 * 
	 * @return the Queue containing all the tags in the Validator
	 */
	public Queue<HtmlTag> getTags() {
		return this.tags;
	}

	/**
	 * Removes all occurances of an element from the Validator
	 * 
	 * @param element
	 *            element to remove entirely from the Validator
	 */
	public void removeAll(String element) {
		if (element == null) {
			throw new IllegalArgumentException();
		}

		HtmlTag openTag = new HtmlTag(element, true);
		HtmlTag closeTag = new HtmlTag(element, false);

		while (tags.contains(openTag)) {
			tags.remove(openTag);
		}
		while (tags.contains(closeTag)) {
			tags.remove(closeTag);
		}
	}

	/**
	 * 
	 * @return a string representation of the Validator as Html Tags
	 */
	public String validate() {
		int indentCount = 0;
		String textRep = "";
		MyStack stack = new MyStack();

		while (!tags.isEmpty()) {

			// prints the correct number of indents and the self-closing tag
			if (tags.peek().isSelfClosing()) {
				textRep = printTabs(textRep, indentCount);
				textRep += tags.poll() + "\n";
				continue;
			}
			
			// checks if the tag is an open tag then keeps track of whether it has been closed
			else if (tags.peek().isOpenTag()) {
				textRep = printTabs(textRep, indentCount);
				indentCount++;

				stack.push(tags.peek());

				textRep += tags.poll() + "\n";
				continue;
			}

			//check if the tag is a closing tag then see if it correctly closes the preceding tag
			//prints an error message if it does not correctly close the preceding tag
			else if (!tags.peek().isOpenTag()) {
				if (stack.peek().matches(tags.peek())) {
					indentCount--;
					textRep = printTabs(textRep, indentCount);
					stack.pop();

					textRep += tags.poll() + "\n";
					continue;
				}
				else {
					textRep += "ERROR unexpected tag: " + tags.poll().toString() + "\n";
				}
			}
		}
		
		//check if there are tags that have not been closed 
		//then prints an Error message with the tags that have not been closed
		while(!stack.isEmpty()) {
			textRep += "ERROR unclosed tag: " + stack.pop().toString() + "\n";
		}

		return textRep;
	}

	/**
	 * 
	 * @param textRep
	 *            the String to append indents to
	 * @param indentCount
	 *            the number of indents to append
	 * @return the string with the correct number of appended indents
	 */
	private String printTabs(String textRep, int indentCount) {
		for (int i = 0; i < indentCount; i++) {
			textRep += "\t";
		}
		return textRep;
	}

}
