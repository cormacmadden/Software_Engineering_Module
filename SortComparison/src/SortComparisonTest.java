import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @CormacMadden
 *  @version HT 2020
 *  
 *  //NOTE!!!:
 *  Hi I've only submitted the image of github to blackboard, but also I forgot about the blackboard submission until the 27th, 
 *  I had the assignment completed and submitted to Webcat on the 26th, hopefully the delayed upload to blackboard doesn't affect my grade.
 *  Thanks,
 *  Cormac
 *  
 
 Results in nanoseconds:
 
 	InsertionSort			
				
Trial				1			2			3			Average
10 numbers			4400		6000		3200		4533
100 numbers			267600		280400		253800		267267
1000 numbers		14154400	14658800	10227500	13013567
1000 few unique		5278300		6867800		8678500		6941533
1000 nearly ordered	2481200		2123900		2755700		2453600
1000 reverse order	10616900	10130400	10045200	10264167
1000 sorted			110200		676400		471200		419267

	SelectionSort			
				
Trial				1			2			3			Average
10 numbers			8000		6800		14000		9600
100 numbers			373400		406000		552200		443867
1000 numbers		17320600	10905700	11763000	13329767
1000 few unique		7650400		13090900	10690100	10477133
1000 nearly ordered	8047100		8854800		9294400		8732100
1000 reverse order	12193900	27258100	14852500	18101500
1000 sorted			8604200		9186400		12140300	9976967

	QuickSort			
				
Trial				1			2			3			Average
10 numbers			6100		5600		5200		5633
100 numbers			57400		37500		10500		35133
1000 numbers		759200		774000		744500		759233
1000 few unique		1124400		1624300		1964800		1571166
1000 nearly ordered	2488800		2426000		1655000		2189933
1000 reverse order	8585600		10825000	11540200	10316933
1000 sorted			16722800	12182700	17753400	15552967

	mergeSort Iterative			
				
Trial				1			2			3			Average
10 numbers			24300		26600		13300		21400
100 numbers			162900		232000		121400		172100
1000 numbers		3264000		1999900		2899700		2721200
1000 few unique		2049700		2726600		1242000		2006100
1000 nearly ordered	2768800		2207200		1460900		2145633
1000 reverse order	1390000		2056200		2354700		1933633
1000 sorted			2838600		2264800		2264800		2456067

	mergeSort Recursive			
				
Trial				1			2			3			Average
10 numbers			15700		11300		13400		13467
100 numbers			155500		347800		122200		208500
1000 numbers		2470000		4053400		2641700		3055033
1000 few unique		1579200		2050000		2167900		1932367
1000 nearly ordered	4761800		3317400		5135700		4404967
1000 reverse order	3314700		2109500		3525200		2983133
1000 sorted			2637600		1895900		4187600 	2907033

	AVERAGES
	
					Insertion	selection	Quick		Merge Iter	Merge Recur
10 numbers			4533		9600		5633		21400		13467
100 numbers			443867		443867		35133		172100		208500
1000 numbers		13329767	13329767	759233		2721200		3055033
1000 few unique		6941533		10477133	1571166		2006100		1932367
1000 nearly ordered	2453600		8732100		2189933		2145633		4404967
1000 reverse order	10264167	18101500	10316933	1933633		2983133
1000 sorted			419267		9976967		15552967 	2456067		2907033

a. Which of the sorting algorithms does the order of input have an impact on?
	Insertion sort,

Why?
 
	it took a relatively long time on large random numbers, and reversed numbers but a relatively short time on nearly ordered, few unique and sorted
 
b. Which algorithm has the biggest difference between the best and worst performance, based
on the type of input, for the input of size 1000?

	Insertion Sort,

Why? 
	best case is its sorted and it just accesses every element of the array once
	worst case is its in reverse order and it needs to make n^2 memory accesses.


c. Which algorithm has the best/worst scalability, i.e., the difference in performance time 
based on the input size? Please consider only input files with random order for this answer.

	Base on the first three inputs, quicksort would be considered the the best for scalability,
	because it has the second shortest time for 10 numbers and shortest time for 1000 numbers.


d. Did you observe any difference between iterative and recursive implementations of merge sort?
	Iterative seemed to be generally more efficient with 5/7 input files sorting faster using iterative merge sort. 
	(More noticeable difference with larger inputs)

e. Which algorithm is the fastest for each of the 7 input files?
	10Numbers :Insertion Sort
	100Numbers: Quicksort
	1000Numbers: Quicksort
	1000fewunique: Quicksort
	1000nearlyOrdered: Mergesort Iterative
	1000reverseOrder: Mergesort Iterative
	1000 sorted: Insertion Sort

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
        assertTrue(Arrays.equals(SortComparison.mergeSortIterative(input),input));
        assertTrue(Arrays.equals(SortComparison.mergeSortRecursive(input),input));

    }

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

        assertTrue(Arrays.equals(SortComparison.mergeSortIterative(input),result));
    	input = new double[] {2.2,1.1,3.3,6.6,5.0,10.0};

        assertTrue(Arrays.equals(SortComparison.mergeSortRecursive(input),result));
    }


    @Test
    public void main()
    {

		double[] ary = new double[1000];
		
		try {
			Scanner s = new Scanner(new File("numbersSorted1000.txt"));
			for (int j = 0; j < ary.length; j++) {
				ary[j] = s.nextDouble();
			}
			s.close();
		} catch (FileNotFoundException filenotfoundexception) {
			System.out.println("File not found.");
		}
		
		long start = System.nanoTime();
		SortComparison.quickSort(ary);		
		long end = System.nanoTime();
		System.out.println("Time = " + (end-start));

    }

}
