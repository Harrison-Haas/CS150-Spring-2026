import java.util.NoSuchElementException;

public class IntSinglyLinkedList {

	private IntNode head;

	/**
	 * Adds a node to the front of the list
	 * 
	 * @param value The value to be added to the node at the front of the list
	 */
	public void addFirst(int value) {
		// Put data in a node
		IntNode node = new IntNode(value);

		// Check to see if head is null and handle it
		if (this.head == null) {
			this.head = node;
			return;
		}

		// Put the next of the new node to the head value
		node.setNext(head);

		// Set the new node as the head
		head = node;

	}

	/**
	 * Adds a node to the end of the list
	 * 
	 * @param value The value to be added to the node at the end of the list
	 */
	public void addLast(int value) {
		// Put data in a node
		IntNode node = new IntNode(value);

		// Check to see if head is null, and set the value to it if it is
		if (this.head == null) {
			this.head = node;
			return;
		}

		// Run through the list until the next node is null
		IntNode currentNode = head;
		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		// Set the next node to the created node
		currentNode.setNext(node);
	}

	/**
	 * Finds and returns the value at a specified index if that index exists
	 * 
	 * @param index The specified index
	 * @return The value at the index if it exists, an index out of bounds error if
	 *         it doesn't
	 */
	public int get(int index) {
		// Check if the index is in bounds
		if (index >= size()) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size());
		}

		// Run a for loop up until we hit the index, then return the value of that node
		IntNode currentNode = head;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.getNext();
		}
		return currentNode.getData();
	}

	/**
	 * Removes the first node of a list and returns the value that was removed,
	 * throws a NoSuchElementException if the list is empty
	 * 
	 * @return The value of the node removed
	 */
	public int removeFirst() {
		// Check if the head is null and handle it
		if (head == null) {
			throw new NoSuchElementException("The list is empty; cannot remove the first element");
		}

		// Get the value that is being removed
		int value = head.getData();

		// Move the head to the next variable
		this.head = head.getNext();

		return value;
	}

	/**
	 * removes a specified value and return true if the value was found, removes
	 * false if the value isn't found in the list
	 * 
	 * @param value The value to be removed
	 * @return True if the value was removed, false if the value was not found
	 */
	public boolean removeValue(int value) {
		// Check if the head is null and handle it
		if (head == null) {
			return false;
		}

		// Set up two helper variables, the current node and the previous node
		IntNode previousNode = head;
		IntNode currentNode = head.getNext();

		// Check if the head is the value and handle it
		if (currentNode == null) {
			if (head.getData() == value) {
				this.head = head.getNext();
				return true;
			}
		}

		// Go through the list and if the value is found, delete it and return true
		while (currentNode != null) {
			if (currentNode.getData() == value) {
				// Remove the node
				previousNode.setNext(currentNode.getNext());
				return true;
			}
			currentNode = currentNode.getNext();
			previousNode = previousNode.getNext();
		}
		return false;
	}

	/**
	 * Find the number of values in a singly linked list
	 * 
	 * @return The amount of values in the list
	 */
	public int size() {
		// Create a helper int and node
		int size = 0;
		IntNode currentNode = head;

		// Run a loop and count each incrament until a node is null
		while (true) {
			if (currentNode == null) {
				return size;
			}
			currentNode = currentNode.getNext();
			size++;
		}
	}

	/**
	 * Checks if a list contains any nodes
	 * 
	 * @return True if the list is empty, false if the list contains any nodes
	 */
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Formats the list and prints out the properly formatted list
	 */
	public String toString() {
		String output = "[";
		IntNode currentNode = this.head;
		while (currentNode != null) {
			output += String.valueOf(currentNode.getData());
			if (currentNode.getNext() != null) {
				output += ", ";
			}
			currentNode = currentNode.getNext();
		}
		output += "]";
		return output;
	}
}
