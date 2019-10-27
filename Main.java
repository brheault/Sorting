package com.company;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static int[] random10k;
    private static int[] random20k;
    private static int[] random50k;
    private static int[] random100k;
    private static int[] inorder10k;
    private static int[] inorder20k;
    private static int[] inorder50k;
    private static int[] inorder100k;
    private static int[] reverseOrder10k;
    private static int[] reverseOrder20k;
    private static int[] reverseOrder50k;
    private static int[] reverseOrder100k;

    public Main() {
    }

    public static int[] randomNumbers(int size) {
        int[] array = new int[size];
        Random rand = new Random();

        for(int i = 0; i < size; ++i) {
            int temp = rand.nextInt(size);
            array[i] = temp;
        }

        return array;
    }

    public static int[] inorderNumbers(int size) {
        int[] array = new int[size];

        for(int i = 0; i < size; array[i] = i++) {
        }

        return array;
    }

    public static int[] reverseOrderNumbers(int size) {
        int[] array = new int[size];

        for(int i = 0; i < size; ++i) {
            array[i] = size - i;
        }

        return array;
    }

    public static void setData() {
        random10k = randomNumbers(10000);
        random20k = randomNumbers(20000);
        random50k = randomNumbers(50000);
        random100k = randomNumbers(100000);
        inorder10k = inorderNumbers(10000);
        inorder20k = inorderNumbers(20000);
        inorder50k = inorderNumbers(50000);
        inorder100k = inorderNumbers(100000);
        reverseOrder10k = reverseOrderNumbers(10000);
        reverseOrder20k = reverseOrderNumbers(20000);
        reverseOrder50k = reverseOrderNumbers(50000);
        reverseOrder100k = reverseOrderNumbers(100000);
    }

    public static float timedSelectionSort(int[] array) {
        long startTime = System.nanoTime();

        for(int i = 0; i < array.length; ++i) {
            int min = array[i];
            int minIndex = i;

            for(int j = i; j < array.length; ++j) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }

            array[minIndex] = array[i];
            array[i] = min;
        }

        long endTime = System.nanoTime();
        float duration = (float)(endTime - startTime);
        return duration / 1000000.0F;
    }

    public static float timedInsertionSort(int[] array) {
        long startTime = System.nanoTime();

        for(int i = 1; i < array.length; ++i) {
            int j = i;

            while(array[j - 1] > array[j]) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                --j;
                if (j < 1) {
                    break;
                }
            }
        }

        long endTime = System.nanoTime();
        float duration = (float)(endTime - startTime);
        return duration / 1000000.0F;
    }

    public static float timedMergeSort(int[] array) {
        long startTime = System.nanoTime();
        array = mergeSort(array);
        long endTime = System.nanoTime();
        float duration = (float)(endTime - startTime);
        return duration / 1000000.0F;
    }

    private static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        } else {
            int[] leftHalf = Arrays.copyOfRange(array, 0, array.length / 2);
            int[] rightHalf = Arrays.copyOfRange(array, array.length / 2, array.length);
            leftHalf = mergeSort(leftHalf);
            rightHalf = mergeSort(rightHalf);
            int l = 0;
            int r = 0;
            int i = 0;

            while(i < array.length) {
                if (l == leftHalf.length) {
                    array[i] = rightHalf[r];
                    ++i;
                    ++r;
                } else if (r == rightHalf.length) {
                    array[i] = leftHalf[l];
                    ++l;
                    ++i;
                } else {
                    int left = leftHalf[l];
                    int right = rightHalf[r];
                    if (left <= right) {
                        array[i] = leftHalf[l];
                        ++l;
                        ++i;
                    } else {
                        array[i] = rightHalf[r];
                        ++i;
                        ++r;
                    }
                }
            }

            return array;
        }
    }

    public static void main(String[] args) {
        float insert_random_10k = 0.0F;
        float insert_random_20k = 0.0F;
        float insert_random_50k = 0.0F;
        float insert_random_100k = 0.0F;
        float insert_inorder_10k = 0.0F;
        float insert_inorder_20k = 0.0F;
        float insert_inorder_50k = 0.0F;
        float insert_inorder_100k = 0.0F;
        float insert_reverse_10k = 0.0F;
        float insert_reverse_20k = 0.0F;
        float insert_reverse_50k = 0.0F;
        float insert_reverse_100k = 0.0F;
        float selection_random_10k = 0.0F;
        float selection_random_20k = 0.0F;
        float selection_random_50k = 0.0F;
        float selection_random_100k = 0.0F;
        float selection_inorder_10k = 0.0F;
        float selection_inorder_20k = 0.0F;
        float selection_inorder_50k = 0.0F;
        float selection_inorder_100k = 0.0F;
        float selection_reverse_10k = 0.0F;
        float selection_reverse_20k = 0.0F;
        float selection_reverse_50k = 0.0F;
        float selection_reverse_100k = 0.0F;
        float merge_random_10k = 0.0F;
        float merge_random_20k = 0.0F;
        float merge_random_50k = 0.0F;
        float merge_random_100k = 0.0F;
        float merge_inorder_10k = 0.0F;
        float merge_inorder_20k = 0.0F;
        float merge_inorder_50k = 0.0F;
        float merge_inorder_100k = 0.0F;
        float merge_reverse_10k = 0.0F;
        float merge_reverse_20k = 0.0F;
        float merge_reverse_50k = 0.0F;
        float merge_reverse_100k = 0.0F;

        for(int i = 1; i < 11; ++i) {
            System.out.println("Test Number " + i);
            setData();
            System.out.println("Selection Sort With Random (milliseconds): ");
            float temp = timedSelectionSort(random10k);
            selection_random_10k += temp;
            System.out.println("10k Elements: \t" + temp);
            temp = timedSelectionSort(random20k);
            selection_random_20k += temp;
            System.out.println("20k Elements: \t" + temp);
            temp = timedSelectionSort(random50k);
            selection_random_50k += temp;
            System.out.println("50k Elements: \t" + temp);
            temp = timedSelectionSort(random100k);
            selection_random_100k += temp;
            System.out.println("100k Elements: \t" + temp);
            System.out.println();
            System.out.println("Selection Sort With In-Order (milliseconds): ");
            temp = timedSelectionSort(inorder10k);
            selection_inorder_10k += temp;
            System.out.println("10k Elements: \t" + temp);
            temp = timedSelectionSort(inorder20k);
            selection_inorder_20k += temp;
            System.out.println("20k Elements: \t" + temp);
            temp = timedSelectionSort(inorder50k);
            selection_inorder_50k += temp;
            System.out.println("50k Elements: \t" + temp);
            temp = timedSelectionSort(inorder100k);
            selection_inorder_100k += temp;
            System.out.println("100k Elements: \t" + temp);
            System.out.println();
            System.out.println("Selection Sort With Reverse-Order (milliseconds): ");
            temp = timedSelectionSort(reverseOrder10k);
            selection_reverse_10k += temp;
            System.out.println("10k Elements: \t" + temp);
            temp = timedSelectionSort(reverseOrder20k);
            selection_reverse_20k += temp;
            System.out.println("20k Elements: \t" + temp);
            temp = timedSelectionSort(reverseOrder50k);
            selection_reverse_50k += temp;
            System.out.println("50k Elements: \t" + temp);
            temp = timedSelectionSort(reverseOrder100k);
            selection_reverse_100k += temp;
            System.out.println("100k Elements: \t" + temp);
            System.out.println();
            System.out.println();
            System.out.println();
            setData();
            System.out.println("Insertion Sort With Random: ");
            temp = timedInsertionSort(random10k);
            insert_random_10k += temp;
            System.out.println("10k Elements: \t" + temp);
            temp = timedInsertionSort(random20k);
            insert_random_20k += temp;
            System.out.println("20k Elements: \t" + temp);
            temp = timedInsertionSort(random50k);
            insert_random_50k += temp;
            System.out.println("50k Elements: \t" + temp);
            temp = timedInsertionSort(random100k);
            insert_random_100k += temp;
            System.out.println("100k Elements: \t" + temp);
            System.out.println();
            System.out.println("Insertion Sort With In-Order: ");
            temp = timedInsertionSort(inorder10k);
            insert_inorder_10k += temp;
            System.out.println("10k Elements: \t" + temp);
            temp = timedInsertionSort(inorder20k);
            insert_inorder_20k += temp;
            System.out.println("20k Elements: \t" + temp);
            temp = timedInsertionSort(inorder50k);
            insert_inorder_50k += temp;
            System.out.println("50k Elements: \t" + temp);
            temp = timedInsertionSort(inorder100k);
            insert_inorder_100k += temp;
            System.out.println("100k Elements: \t" + temp);
            System.out.println();
            System.out.println("Insertion Sort With Reverse-Order: ");
            temp = timedInsertionSort(reverseOrder10k);
            insert_reverse_10k += temp;
            System.out.println("10k Elements: \t" + temp);
            temp = timedInsertionSort(reverseOrder20k);
            insert_reverse_20k += temp;
            System.out.println("20k Elements: \t" + temp);
            temp = timedInsertionSort(reverseOrder50k);
            insert_reverse_50k += temp;
            System.out.println("50k Elements: \t" + temp);
            temp = timedInsertionSort(reverseOrder100k);
            insert_reverse_100k += temp;
            System.out.println("100k Elements: \t" + temp);
            System.out.println();
            System.out.println();
            System.out.println();
            setData();
            System.out.println("Merge Sort With Random: ");
            temp = timedMergeSort(random10k);
            merge_random_10k += temp;
            System.out.println("10k Elements: \t" + temp);
            temp = timedMergeSort(random20k);
            merge_random_20k += temp;
            System.out.println("20k Elements: \t" + temp);
            temp = timedMergeSort(random50k);
            merge_random_50k += temp;
            System.out.println("50k Elements: \t" + temp);
            temp = timedMergeSort(random100k);
            merge_random_100k += temp;
            System.out.println("100k Elements: \t" + temp);
            System.out.println();
            System.out.println("Merge Sort With In-Order: ");
            temp = timedMergeSort(inorder10k);
            merge_inorder_10k += temp;
            System.out.println("10k Elements: \t" + temp);
            temp = timedMergeSort(inorder20k);
            merge_inorder_20k += temp;
            System.out.println("20k Elements: \t" + temp);
            temp = timedMergeSort(inorder50k);
            merge_inorder_50k += temp;
            System.out.println("50k Elements: \t" + temp);
            temp = timedMergeSort(inorder100k);
            merge_inorder_100k += temp;
            System.out.println("100k Elements: \t" + temp);
            System.out.println();
            System.out.println("Merge Sort With Reverse-Order: ");
            temp = timedMergeSort(reverseOrder10k);
            merge_reverse_10k += temp;
            System.out.println("10k Elements: \t" + temp);
            temp = timedMergeSort(reverseOrder20k);
            merge_reverse_20k += temp;
            System.out.println("20k Elements: \t" + temp);
            temp = timedMergeSort(reverseOrder50k);
            merge_reverse_50k += temp;
            System.out.println("50k Elements: \t" + temp);
            temp = timedMergeSort(reverseOrder100k);
            merge_reverse_100k += temp;
            System.out.println("100k Elements: \t" + temp);
            System.out.println();
            System.out.println();
            System.out.println();
        }

        insert_random_10k /= 10.0F;
        insert_random_20k /= 10.0F;
        insert_random_50k /= 10.0F;
        insert_random_100k /= 10.0F;
        insert_inorder_10k /= 10.0F;
        insert_inorder_20k /= 10.0F;
        insert_inorder_50k /= 10.0F;
        insert_inorder_100k /= 10.0F;
        insert_reverse_10k /= 10.0F;
        insert_reverse_20k /= 10.0F;
        insert_reverse_50k /= 10.0F;
        insert_reverse_100k /= 10.0F;
        selection_random_10k /= 10.0F;
        selection_random_20k /= 10.0F;
        selection_random_50k /= 10.0F;
        selection_random_100k /= 10.0F;
        selection_inorder_10k /= 10.0F;
        selection_inorder_20k /= 10.0F;
        selection_inorder_50k /= 10.0F;
        selection_inorder_100k /= 10.0F;
        selection_reverse_10k /= 10.0F;
        selection_reverse_20k /= 10.0F;
        selection_reverse_50k /= 10.0F;
        selection_reverse_100k /= 10.0F;
        merge_random_10k /= 10.0F;
        merge_random_20k /= 10.0F;
        merge_random_50k /= 10.0F;
        merge_random_100k /= 10.0F;
        merge_inorder_10k /= 10.0F;
        merge_inorder_20k /= 10.0F;
        merge_inorder_50k /= 10.0F;
        merge_inorder_100k /= 10.0F;
        merge_reverse_10k /= 10.0F;
        merge_reverse_20k /= 10.0F;
        merge_reverse_50k /= 10.0F;
        merge_reverse_100k /= 10.0F;
        System.out.println("Total Averages:");
        System.out.println();
        System.out.println("Selection Sort:");
        System.out.println("Random 10k: \t" + selection_random_10k);
        System.out.println("Random 20k: \t" + selection_random_20k);
        System.out.println("Random 50k: \t" + selection_random_50k);
        System.out.println("Random 100k: \t" + selection_random_100k);
        System.out.println("InOrder 10k: \t" + selection_inorder_10k);
        System.out.println("InOrder 20k: \t" + selection_inorder_20k);
        System.out.println("InOrder 50k: \t" + selection_inorder_50k);
        System.out.println("InOrder 100k: \t" + selection_inorder_100k);
        System.out.println("Reverse 10k: \t" + selection_reverse_10k);
        System.out.println("Reverse 20k: \t" + selection_reverse_20k);
        System.out.println("Reverse 50k: \t" + selection_reverse_50k);
        System.out.println("Reverse 100k: \t" + selection_reverse_100k);
        System.out.println();
        System.out.println("Insertion Sort:");
        System.out.println("Random 10k: \t" + insert_random_10k);
        System.out.println("Random 20k: \t" + insert_random_20k);
        System.out.println("Random 50k: \t" + insert_random_50k);
        System.out.println("Random 100k: \t" + insert_random_100k);
        System.out.println("Inorder 10k: \t" + insert_inorder_10k);
        System.out.println("Inorder 20k: \t" + insert_inorder_20k);
        System.out.println("Inorder 50k: \t" + insert_inorder_50k);
        System.out.println("Inorder 100k: \t" + insert_inorder_100k);
        System.out.println("Reverse 10k: \t" + insert_reverse_10k);
        System.out.println("Reverse 20k: \t" + insert_reverse_20k);
        System.out.println("Reverse 50k: \t" + insert_reverse_50k);
        System.out.println("Reverse 100k: \t" + insert_reverse_100k);
        System.out.println();
        System.out.println("Merge Sort:");
        System.out.println("Random 10k: \t" + merge_random_10k);
        System.out.println("Random 20k: \t" + merge_random_20k);
        System.out.println("Random 50k: \t" + merge_random_50k);
        System.out.println("Random 100k: \t" + merge_random_100k);
        System.out.println("Inorder 10k: \t" + merge_inorder_10k);
        System.out.println("Inorder 20k: \t" + merge_inorder_20k);
        System.out.println("Inorder 50k: \t" + merge_inorder_50k);
        System.out.println("Inorder 100k: \t" + merge_inorder_100k);
        System.out.println("Reverse 10k: \t" + merge_reverse_10k);
        System.out.println("Reverse 20k: \t" + merge_reverse_20k);
        System.out.println("Reverse 50k: \t" + merge_reverse_50k);
        System.out.println("Reverse 100k: \t" + merge_reverse_100k);
    }
}
