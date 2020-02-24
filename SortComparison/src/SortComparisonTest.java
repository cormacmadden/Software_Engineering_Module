import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;
import java.util.*; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.*; 
import java.io.*; 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @CormacMadden
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
    
    @Test
    public void testFromFiles()
    {
    	// Java program to illustrate reading data from file 
    	// using nio.File 

 
    	
    }

    
    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        double[] annualIntRt = new double[5];
        fillArray(annualIntRt);
        for (int i = 0; i < annualIntRt.length; i++)
            System.out.println(annualIntRt[i]);
    }
    
    public static void fillArray(double[] ary) {
        try {
            File arrayInput = new File("numbers10.txt");
            Scanner in = new Scanner(arrayInput);
            int i = 0;  
            while (in.hasNextLine())
                ary[i++] = in.nextDouble();
            in.close();
        }
        catch (FileNotFoundException e) {
            System.exit(1);
        }
    }

}
