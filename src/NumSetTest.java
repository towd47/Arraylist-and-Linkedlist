import static org.junit.Assert.*;

import org.junit.Test;

public class NumSetTest {
	@Test
	public void testSize() {
		double[] testArray = {1.0, 2.0, 3.0, 4.0, 2.0};
		NumSet testSet = new NumSet(testArray);
		assertTrue("Size of a set with 4 items should be 4, only found " + testSet.size(),
				testSet.size() == 4);
	}
	
	@Test
	public void testContains() {
		double[] testArray = {1.0, 2.0, 3.0, 4.0, 2.0};
		NumSet testSet = new NumSet(testArray);
		assertTrue("Contains should return true if it contains the value", testSet.contains(2.0));
		assertFalse("Contains should return false if it does not contain the value", testSet.contains(5.0));
	}
	
	@Test
	public void testIntersect() {
		double[] testArray = {1.0, 2.0, 3.0, 4.0};
		NumSet testSet = new NumSet(testArray);
		double[] testArray2 = {1.0, 2.0, 5.0, 4.0};
		NumSet testSet2 = new NumSet(testArray2);
		NumSet x = NumSet.intersect(testSet, testSet2);
		assertEquals("Should return the intersection of two sets which is the numbers that are in both sets only",
				"1.0 2.0 4.0", x.toString());
	}
	
	@Test
	public void testUnion() {
		double[] testArray = {1.0, 2.0, 3.0, 4.0};
		NumSet testSet = new NumSet(testArray);
		double[] testArray2 = {1.0, 2.0, 5.0, 4.0};
		NumSet testSet2 = new NumSet(testArray2);
		NumSet x = NumSet.union(testSet, testSet2);
		assertEquals("Should return the union of both sets, which includes all numbers in both sets",
				"1.0 2.0 3.0 4.0 5.0", x.toString());
	}
	
	@Test
	public void testEquivilance() {
		double[] testArray = {5.0, 2.0, 3.0, 1.0};
		NumSet testSet = new NumSet(testArray);
		double[] testArray2 = {1.0, 2.0, 5.0, 3.0};
		NumSet testSet2 = new NumSet(testArray2);
		assertTrue("Should return true when comparing two sets with the same values regardless of order",
				NumSet.equivalence(testSet, testSet2));
	}

}
