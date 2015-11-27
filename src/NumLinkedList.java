
public class NumLinkedList implements NumList{
	int lstSize;
	Node lstHead;
	
	public NumLinkedList() {
		lstHead = new Node();
		this.lstSize = 0;
	}
	
	@Override
	public int size() {
		return lstSize;
	}

	@Override
	public void add(double value) {
		Node currentNode = this.lstHead;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		Node newNode = new Node(value);
		currentNode.next = newNode;
		lstSize++;
	}

	@Override
	public void insert(int i, double value) {
		Node newNode = new Node(value);
		Node currentNode = this.lstHead;
		if (currentNode.next == null) {
			currentNode.next = newNode;
			return;
		}
		for (int j = 0; j < i; j++) {
			currentNode = currentNode.next;
			if (currentNode.next == null) {
				currentNode.next = newNode;
				return;
			}
			
		}
		newNode.next = currentNode.next;
		currentNode.next = newNode;
		
	}

	@Override
	public void remove(int i) {
		Node currentNode = this.lstHead;
		for (int j = 0; j < i; j++) {
			if (currentNode.next == null) {
				return;
			}
			currentNode = currentNode.next;
		}
		if (currentNode.next == null) {
			return;
		}
		currentNode.next = currentNode.next.next;	
		lstSize--;
	}

	@Override
	public boolean contains(double value) {
		Node currentNode = this.lstHead;
		while (currentNode.next != null) {
			if (currentNode.next.value == value) {
				return true;
			}
			currentNode = currentNode.next;
		}
		return false;
	}

	@Override
	public double lookup(int i) {
		Node currentNode = this.lstHead;
		for (int j = 0; j <= i; j++) {
			if (currentNode.next == null) {
				return -1;
			}
			currentNode = currentNode.next;
		}
		return currentNode.value;
	}

	@Override
	public boolean equals(NumList otherList) {
		if (this.toString().equals(otherList.toString())) {
			return true;
		}
		return false;
	}

	@Override
	public void removeDuplicates() {
		Node currentNode = this.lstHead;
		while (currentNode.next != null) {
			Node compareNode = currentNode.next;
			while (compareNode.next != null) {
				if (currentNode.next.value == compareNode.next.value) {
					compareNode.next = compareNode.next.next;
					lstSize--;
				}
				else{
					compareNode = compareNode.next;
				}
			}
			currentNode = currentNode.next;
		}
	}
	
	public String toString() {
		String lstString = "";
		Node currentNode = this.lstHead.next;
		while (currentNode != null) {
			lstString = lstString + currentNode.value;
			if (currentNode.next != null) {
				lstString = lstString + " ";
			}
			currentNode = currentNode.next;
		}
		return lstString;
	}

}
