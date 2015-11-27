
public class NumArrayList implements NumList{
	double[] numArray;
	int numVals;
	
	public NumArrayList() {
		this.numArray = new double[0];
		numVals = 0;
	}
	
	public NumArrayList(int arrayCapacity) {
		this.numArray = new double[arrayCapacity];
		numVals = 0;
	}
	
	@Override
	public int size() {
		return numVals;
	}
	
	public int capacity() {
		return this.numArray.length;
	}

	@Override
	public void add(double value) {
		if (size() == capacity()) {
			this.expandArray();
			
		}
		this.numArray[this.size()] = value;
		this.numVals++;
	}

	@Override
	public void insert(int i, double value) {
		if (i >= this.size()) {
			this.add(value);
		}
		else {
			if(this.size() == this.capacity()) {
				this.expandArray();
			}
			for(int j = this.size(); j > i; j--) {
				this.numArray[j] = this.numArray[j - 1];
			}
			this.numArray[i] = value;
			this.numVals++;
		}		
	}

	@Override
	public void remove(int i) {
		if (i >= this.size()) {
			return;
		}
		for (int j = i; j < this.size() - 1; j++) {
			this.numArray[j] = this.numArray[j+1];
		}
		this.numArray[this.size() - 1] = 0;
		this.numVals--;
		
	}

	@Override
	public boolean contains(double value) {
		for (int i = 0; i < this.size(); i++) {
			if (this.numArray[i] == value) {
				return true;
			}
		}
		return false;
	}

	@Override
	public double lookup(int i) {
		if (i >= this.size()) {
			throw new ArrayIndexOutOfBoundsException(i);
		}
		return this.numArray[i];
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
		for (int i = 0; i < this.size() - 1; i++) {
			for (int j = i+1; j < this.size(); j++) {
				if (this.numArray[j] == this.numArray[i]) {
					this.remove(j);
					j--;
				}
			}
		}
		
	}
	
	public String toString() {
		String arrayString = "";
		for (int i = 0; i < this.size(); i++) {
			arrayString = arrayString + this.numArray[i];
			if (i != this.size() - 1) {
				arrayString = arrayString + " ";
			}
		}
		return arrayString;
	}
	
	public void expandArray() {
		if (this.capacity() != 0) {
			double[] tempArray = new double[this.capacity() * 2];
			for (int i = 0; i < this.capacity(); i++) {
				tempArray[i] = numArray[i];
			}
			this.numArray = tempArray;
		}
		else {
			this.numArray = new double[1];
		}
	}

}
