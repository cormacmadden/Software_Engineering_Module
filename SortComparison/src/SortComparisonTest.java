import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;
//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
        
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double [] input = new double[0];
    	    	
        assertTrue(Arrays.equals(SortComparison.insertionSort(input),input));
        assertTrue(Arrays.equals(SortComparison.selectionSort(input),input));
        assertTrue(Arrays.equals(SortComparison.quickSort(input),input));
        assertTrue(Arrays.equals(SortComparison.selectionSort(input),input));
        assertTrue(Arrays.equals(SortComparison.mergeSortIterative(input),input));
        assertTrue(Arrays.equals(SortComparison.mergeSortRecursive(input),input));

    }

    // TODO: add more tests here. Each line of code and each decision in Collinear.java should
    // be executed at least once from at least one test.
    @Test
    public void testSort()
    {
    	double [] input = new double[] {2.2,1.1,3.3,6.6,5.0,10.0};
    	double [] result = new double[] {1.1,2.2,3.3,5.0,6.6,10.0};
    	    	
        assertTrue(Arrays.equals(SortComparison.insertionSort(input),result));
    	input = new double[] {2.2,1.1,3.3,6.6,5.0,10.0};

        assertTrue(Arrays.equals(SortComparison.selectionSort(input),result));
    	input = new double[] {2.2,1.1,3.3,6.6,5.0,10.0};

        assertTrue(Arrays.equals(SortComparison.quickSort(input),result));
    	input = new double[] {2.2,1.1,3.3,6.6,5.0,10.0};

        assertTrue(Arrays.equals(SortComparison.selectionSort(input),result));
    	input = new double[] {2.2,1.1,3.3,6.6,5.0,10.0};

        assertTrue(Arrays.equals(SortComparison.mergeSortIterative(input),result));
    	input = new double[] {2.2,1.1,3.3,6.6,5.0,10.0};

        assertTrue(Arrays.equals(SortComparison.mergeSortRecursive(input),result));
    }
    
    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    }

}
