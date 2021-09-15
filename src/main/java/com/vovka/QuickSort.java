package com.vovka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {

    private static int comparisons = 0;
    private static int swaps = 0;

//    ==================================================================================================================

    public static void ascSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int opora = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                comparisons++;
                i++;
            }

            while (array[j] > opora) {
                comparisons++;
                j--;
            }

            if (i <= j) {
                swaps++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            ascSort(array, low, j);

        if (high > i)
            ascSort(array, i, high);
    }

//    ==================================================================================================================

    public static void descSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int opora = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] > opora) {
                comparisons++;
                i++;
            }

            while (array[j] < opora) {
                comparisons++;
                j--;
            }

            if (i <= j) {
                swaps++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) {
            descSort(array, low, j);
        }
        if (high > i) {
            descSort(array, i, high);
        }
    }

//    ==================================================================================================================

    public static String ascSortReturn(int[] arr){
        final long startTime = System.nanoTime();
        int low = 0;
        int high = arr.length - 1;
        ascSort(arr, low, high);
        final long endTime = System.nanoTime();

        return "===== Heap sort ASC =====" +
                "\nExecution time: " + (endTime - startTime) + "ns" +
                "\nComparisons: " + comparisons +
                "\nSwaps " + swaps +
                "\nSorted array: " + Arrays.toString(arr);
    }

    public static String descSortReturn(int[] arr){
        final long startTime = System.nanoTime();
        int low = 0;
        int high = arr.length - 1;
        descSort(arr, low, high);
        final long endTime = System.nanoTime();

        return "===== Heap sort DESC =====" +
                "\nExecution time: " + (endTime - startTime) + "ns" +
                "\nComparisons: " + comparisons +
                "\nSwaps " + swaps +
                "\nSorted array: " + Arrays.toString(arr);
    }

//    ==================================================================================================================

    private static int[] readArrFromFile(String stringArr) {
        List<Integer> arrayList = new ArrayList<>();

        for (String number : stringArr.split(",")) {
            arrayList.add(Integer.parseInt(number));
        }

        return arrayList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {

        String order = args[0];
        int[] arr = readArrFromFile(args[1]);

        if (order.equals("asc")) {
            System.out.println(ascSortReturn(arr));
        } else if(order.equals("desc")){
            System.out.println(descSortReturn(arr));
        }else {
            System.out.println("no no no");
        }

    }
}


