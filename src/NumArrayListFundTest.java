import static org.junit.Assert.*;

import org.junit.Test;

public class NumArrayListFundTest {

    /*
     * JUnit tests of fundamental functionality.
     *
     * Use these JUnit tests to ensure that your code compiles
     * and correctly implements the fundamental functionality.
     */

    @Test
    public void testDefaultConstructorAndToString() {
        NumArrayList list = new NumArrayList();
        assertEquals("With no parameters, your constructors should initialize an list size 0. " +
            "It also can be the problem in method TOSTRING.",
            "", list.toString());
    }

    @Test
    public void testAddAndToString() {
        NumArrayList list = new NumArrayList();

        list.add(1.0);
        list.add(3.0);
        list.add(2.0);

        assertEquals("Add method should add element to the end of list each time. " +
            "It's also can be the problem in method TOSTRING.",
            "1.0 3.0 2.0", list.toString());
    }

    @Test
    public void testSize() {
        NumArrayList list = new NumArrayList();

        assertEquals("Method SIZE should return 0, when list is constructed by default constructor.",
            0, list.size());

        list.add(1.0);
        list.add(2.0);
        list.add(3.0);

        assertEquals("Method SIZE should return the size of the list, " +
            "i.e. the number of elements, in the sequence.",
            3, list.size());
    }

    @Test
    public void testEquals() {
        NumArrayList listA = new NumArrayList();
        NumArrayList listB = new NumArrayList();
        NumArrayList listC = new NumArrayList();

        listA.add(1.0);
        listA.add(3.0);

        assertFalse("EQUALS method should return FALSE, when two lists are not the same.",
            listA.equals(listB));

        listB.add(1.0);
        listB.add(3.0);

        assertTrue("EQUALS method should return TRUE, when two lists are the same.",
            listA.equals(listB));

        listC.add(3.0);
        listC.add(1.0);

        assertFalse("EQUALS method should return FALSE, even if the same " +
            "numbers are in different order in two lists.",
            listA.equals(listC));
    }
    
    @Test
    public void testRemoveDuplicates() {
    	NumArrayList listA = new NumArrayList();
    	
    	listA.add(1.0);
    	listA.add(2.0);
    	listA.add(3.0);
    	listA.add(2.0);
    	listA.add(4.0);
    	listA.add(1.0);
    	listA.removeDuplicates();
    	
    	assertEquals("RemoveDuplicates should remove the duplicates from the array.", 
    			"1.0 2.0 3.0 4.0", listA.toString());
    }
    
    @Test
    public void testInsert() {
    	NumArrayList listA = new NumArrayList();
    	
    	listA.add(1.0);
    	listA.add(1.0);
    	listA.add(1.0);
    	listA.add(1.0);
    	listA.insert(0, 2.0);
    	
    	assertEquals("Inserting a value at the start of the list should shift the rest of the list as well.",
    			"2.0 1.0 1.0 1.0 1.0", listA.toString());
    }
    /* Other JUnit tests.
     *
     * Write your own JUnit tests below to check the correctness of your implementation.
     *
     * When you turn in your draft (and final) we will run our own test suite on your code
     * and provide you with the feedback.
     */

}