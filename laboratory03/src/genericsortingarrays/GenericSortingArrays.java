package genericsortingarrays;

import java.util.Arrays;

public class GenericSortingArrays {

    /**
     * Swaps two vector positions O(1)
     */
    public static <E> void swap(E[] v, int i, int j) {
        E temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    // printArray
    public static <E> void printArray(E[] v) {
        for (E element : v) {
            System.out.println(", " + element);
        }
    }

    /**
     * Selection Sort Algorithm
     */
    public static <E extends Comparable<E>> void selectionSort(E[] v) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Bubble Sort Algorithm
     *
     * @param v
     */
    public static <E extends Comparable<E>> void bubbleSort(E[] v) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * insertionSort Algorithm
     */
    public static <E extends Comparable<E>> void insertionSort(E[] v) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Mergesort Algorithm
     */
    private static <E extends Comparable<E>> void merge(E[] S1, E[] S2, E[] S) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static <E extends Comparable<E>> void mergeSort(E[] S) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Quicksort Algorithm
     */
    public static <E extends Comparable<E>> void quickSort(E v[]) {

        throw new UnsupportedOperationException("Not supported yet.");
    }

    private static <E extends Comparable<E>> void quickSort(E v[], int left, int right) {

        throw new UnsupportedOperationException("Not supported yet.");
    }
}
