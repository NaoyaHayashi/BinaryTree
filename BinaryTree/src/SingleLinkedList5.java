import java.util.Iterator;

// **************************************
// EXAMPLE of BOTH generics and iterators
// **************************************

public class SingleLinkedList5<ItemType> implements ISimpleList3<ItemType>, Iterable<ItemType> {
		
	private class Node {
		ItemType    value;
		Node   next; 
	}
	
	private Node first;
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void insertFront(ItemType item) {
		// Save the previous first
		Node oldfirst = first;
		
		// Create the new node
		Node newfirst = new Node();
		newfirst.value = item;
		newfirst.next = oldfirst;
		
		// Set the new node as the first node
		first = newfirst;
	}
	
	public ItemType removeFront() {
		// Save the previous first
		Node oldfirst = first;
		
		// Follow the first's node (possibly empty)
		// and set the first to that pointer
		first = oldfirst.next;
		
		// Return the value of old first 
		return oldfirst.value;
	}
	
	// *************
	// Iterator code
	// *************
	
	public Iterator<ItemType> iterator() {
		return new SLL4Iterator();
	}
	
    private class SLL4Iterator implements Iterator<ItemType>
    {
        private Node current = first;
        public boolean hasNext() {
        	return (current != null);
        }
        public void remove() { 
        	/* we don't (yet?) allow arbitrary deletion */
        }
        public ItemType next() {
            ItemType item = current.value; // extract the item value
            current = current.next;        // move the iterator to the next item
            return item;
        }
    }

}
