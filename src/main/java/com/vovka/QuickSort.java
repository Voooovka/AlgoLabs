package com.vovka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {

    private static int comparisons = 0;
    private static int swaps = 0;

//    ==================================================================================================================

    public static int[] sort(int[] array, int low, int high, String order) {
        if (array.length == 0)
            return array;

        if (low >= high)
            return array;

        int middle = low + (high - low) / 2;
        int opora = array[middle];

        int i = low, j = high;
        while (i <= j) {

            if (order.equals("asc")) {
                while (array[i] < opora) {
                    comparisons++;
                    i++;
                }

                while (array[j] > opora) {
                    comparisons++;
                    j--;
                }

            }else {
                while (array[i] > opora) {
                    comparisons++;
                    i++;
                }

                while (array[j] < opora) {
                    comparisons++;
                    j--;
                }
            }

            if (i <= j) {
                swaps++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }

            if (low < j) {
                sort(array, low, j, order);
            }
            if (high > i) {
                sort(array, i, high, order);
            }
        }

        return array;
    }

//    ==================================================================================================================

    public static String sortReturn(int[] arr, String order){

        final long startTime = System.nanoTime();

        int low = 0;
        int high = arr.length - 1;
        sort(arr, low, high, order);

        if (order.equals("asc")) {

            final long endTime = System.nanoTime();

            return "===== Heap sort ASC =====" +
                    "\nExecution time: " + (endTime - startTime) + "ns" +
                    "\nComparisons: " + comparisons +
                    "\nSwaps " + swaps +
                    "\nSorted array: " + Arrays.toString(arr);

        } else if(order.equals("desc")){

            final long endTime = System.nanoTime();

            return "===== Heap sort DESC =====" +
                    "\nExecution time: " + (endTime - startTime) + "ns" +
                    "\nComparisons: " + comparisons +
                    "\nSwaps " + swaps +
                    "\nSorted array: " + Arrays.toString(arr);

        }

        return "no";
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

        System.out.println(sortReturn(arr, order));

    }
}


