
public class NumSet {
	NumArrayList set = new NumArrayList();
	
	public NumSet(double[] array) {
		set.numArray = array;
		set.numVals = array.length;
		set.removeDuplicates();
	}
	
	public int size() {
		return set.size();
	}
	
	public boolean contains(double value) {
		return set.contains(value);
	}
	
	public static NumSet intersect(NumSet S1, NumSet S2) {
		double[] newSetArray = new double[0];
		NumSet newSet = new NumSet(newSetArray);
		for (int i = 0; i < S1.size(); i++) {
			if (S2.contains(S1.set.numArray[i])) {
				newSet.set.add(S1.set.numArray[i]);
			}
		}
		return newSet;
	}
	
	public static NumSet union(NumSet S1, NumSet S2) {
		NumSet newSet = new NumSet(S1.set.numArray);
		for (int i = 0; i < S2.size(); i++) {
			if (!S1.contains(S2.set.numArray[i])) {
				newSet.set.add(S2.set.numArray[i]);
			}
		}
		
		return newSet;
	}
	
	public String toString() {
		return set.toString();
	}
	
	public static boolean equivalence(NumSet S1, NumSet S2) {
		if (S1.size() == S2.size()) {
			for (int i = 0; i < S1.size(); i++) {
				if (!S2.contains(S1.set.numArray[i])) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
