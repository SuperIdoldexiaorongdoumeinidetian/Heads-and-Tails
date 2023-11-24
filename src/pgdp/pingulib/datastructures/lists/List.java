package pgdp.pingulib.datastructures.lists;

public class List {

	private Element head;
	private Element tail;
	private int size;

	List() {
		this.head = null;
		this.tail = null;
	}
	/*
	 * returns size/length of the list
	 */
	public int size() {
		return size;
	}

	/*
	 * returns <true> if the list is empty, otherwise <false>
	 */
	public boolean isEmpty() {
		return head ==null;
	}

	/*
	 * removes all elements from the list
	 */
	public void clear() {
		this.head = null;
		this.tail = null;
		size =0;
	}

	/*
	 * adds an element at the end of the list
	 */
	public void add(int element) {
		size++;
		tail.next = new Element(element);
		tail = tail.next;
	}

	/*
	 * adds an element at the specified index
	 */
	public boolean add(int index, int element) {
		if(index == 0){
			head = new Element(element, head);
			return true;
		}
		if(index == size-1){
			tail.next = new Element(element);
			tail=tail.next;
			return true;
		}
		Element x = head;
		for(int i = 0; i<index-1;i++){
			x=x.next;
		}
		x.next = new Element(element, x.next);
		return true;
	}

	/*
	 * returns the value of the element at the specified index returns default value
	 * (minimum value of an integer) iff. such an element does not exist.
	 */
	public int get(int index) {
		if(index>size)return Integer.MIN_VALUE;
		Element x = head;
		for(int i = 0; i<index;i++){
			x= x.next;
		}
		return x.value;
	}

	/*
	 * removes the element at the specified index
	 */
	public void remove(int index) {
		Element x = head;
		for(int i = 0; i<index-1;i++){
			x=x.next;
		}
		x.next = x.next.next;


	}

	/*
	 * returns String representation of the list
	 */
	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append("[ ");
		Element current = head;
		for (int i = 0; i < size; i++) {
			out.append(current.toString());
			if (i != size - 1) {
				out.append(", ");
			}
			current = current.next;
		}
		out.append(" ]");
		return out.toString();
	}

	private static class Element {
		private int value;
		private Element next;

		Element(int value) {
			this.value = value;
			this.next = null;
		}

		Element(int value, Element next) {
			this.value = value;
			this.next = next;
		}

		/*
		 * returns String representation of the element
		 */
		@Override
		public String toString() {
			return "" + value;
		}
	}


}