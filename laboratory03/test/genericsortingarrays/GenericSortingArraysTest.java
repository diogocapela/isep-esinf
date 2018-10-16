/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericsortingarrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenericSortingArraysTest {

    // The sizes may need adjusting to the computer's calculation power
    private final static int[] sizeSlow =  {100, 5000,   7000,  15000,  25000 };
    private final static int[] sizeFast =  {100, 5000,  10000,  22000,  40000 };
    private final static int[] sizeUltra = {100, 200000, 600000, 2000000, 10000000 };
    private String[][] bufString;

    /**
     * Constructor initializes the vectors of various sizes to be sorted.
     * All methods sort the same vectors
     */
    public GenericSortingArraysTest() {

        System.out.println("Creating arrays...");
        bufString = new String[sizeUltra.length][];
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < sizeUltra.length; i++) {
            bufString[i] = new String[sizeUltra[i]];

            int charactersLength = characters.length();
            for (int j = 0; j < sizeUltra[i]; j++) {
                StringBuffer buffer = new StringBuffer();
                for (int k = 0; k < 2; k++) {
                    double index = Math.random() * charactersLength;
                    buffer.append(characters.charAt((int) index));
                }
                bufString[i][j] = buffer.toString();
            }
        }
    }

    /**
     * Actually executes the sorting algorithm, timing its execution
     *
     * @param v the vector to be sorted
     * @param sfa the sort function algorithm to be used
     * @return the elapsed time
     */
    private long doSort(String [] v, Consumer <String[]> sfa) {
        long startTime = System.currentTimeMillis();
        sfa.accept(v);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        return elapsedTime;
    }

    /**
     * Execution of the sorting algorithm for the various sizes
     * @param sfa the sort function algorithm to be used
     */
    private void timeSort(Consumer <String[]> sfa, int [] size) {

        System.out.println("+-------------------------------+");
        System.out.println("|    Units     +    Time (ms)   |");
        System.out.println("+--------------+----------------+");
        long [] tms = new long[size.length];
        for (int i=0; i<size.length; i++) {
            String [] v = Arrays.copyOfRange(bufString[i],0,size[i]);
            tms[i] =  doSort(v,sfa);
            System.out.printf("|  %10d  +  %12d  |\n",size[i],tms[i]);
        }
        for (int i=1; i<size.length; i++) {
            assertTrue(tms[i - 1] <= tms[i]);
        }
    }

    /**
     * checks the correct ordering of the algorithm
     * @param sfa the sort function algorithm to be used
     */
    private void checkOrder(Consumer <String[]> sfa) {

        String[] so = bufString[0].clone();
        List<String> lo = Arrays.asList(bufString[0].clone());
        sfa.accept(so);
        Collections.sort(lo);

        assertArrayEquals(so, lo.toArray());
    }

    /**
     * Test of selectionSort method, of class GenericSortingArrays.
     */
    @Test
    public void testSelectionSort() {
        System.out.println("SelectionSort Order");

        checkOrder(GenericSortingArrays::selectionSort);
    }

    /**
     * Test of insertionSort method, of class GenericSortingArrays.
     */
    @Test
    public void testSelectionSortTime() {
        System.out.println("SelectionSort Time");

        timeSort(GenericSortingArrays::selectionSort, sizeSlow);
    }

    /**
     * Test of insertionSort method, of class GenericSortingArrays.
     */
    @Test
    public void testInsertionSort() {
        System.out.println("InsertionSort Order");

        checkOrder(GenericSortingArrays::insertionSort);
    }

    /**
     * Test of insertionSort method, of class GenericSortingArrays.
     */
    @Test
    public void testInsertionSortTime() {
        System.out.println("InsertionSort Time");

        timeSort(GenericSortingArrays::insertionSort, sizeFast);
    }

    /**
     * Test of mergeSort method, of class GenericSortingArrays.
     */
    @Test
    public void testMergeSort() {
        System.out.println("MergeSort Order");

        checkOrder(GenericSortingArrays::mergeSort);
    }

    /**
     * Test of mergeSort method, of class GenericSortingArrays.
     */
    @Test
    public void testMergeSortTime() {
        System.out.println("MergeSort Time");

        timeSort(GenericSortingArrays::mergeSort, sizeUltra);
    }

    /**
     * Test of quickSort method, of class GenericSortingArrays.
     */
    @Test
    public void testQuickSort() {
        System.out.println("QuickSort Order");

        checkOrder(GenericSortingArrays::quickSort);
    }

    /**
     * Test of quickSort method, of class GenericSortingArrays.
     */
    @Test
    public void testQuickSortTime() {
        System.out.println("QuickSort Time");

        timeSort(GenericSortingArrays::quickSort, sizeUltra);
    }
   
}