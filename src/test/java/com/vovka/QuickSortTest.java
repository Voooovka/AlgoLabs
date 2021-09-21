package com.vovka;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuickSortTest extends TestCase {

    private static int[] UNSORTED_ARR;
    private static int[] SORTED_ARR_ASC;
    private static int[] SORTED_ARR_DESC;

    @Before
    public void setUp() throws Exception {
        UNSORTED_ARR = new int[]{1, 2, 56, 45, -9, 78, 11, -9};
        SORTED_ARR_ASC = new int[]{-9, -9, 1, 2, 11, 45, 56, 78};
        SORTED_ARR_DESC = new int[]{78, 56, 45, 11, 2, 1, -9, -9};
    }

    @Test
    public void testSortUnsortedArrAsc() {
        Assert.assertArrayEquals(QuickSort.sort(UNSORTED_ARR, 0, UNSORTED_ARR.length-1, "asc"), SORTED_ARR_ASC);
    }

    @Test
    public void testSortUnsortedArrDesc() {
        Assert.assertArrayEquals(QuickSort.sort(UNSORTED_ARR, 0, UNSORTED_ARR.length-1, "desc"), SORTED_ARR_DESC);
    }

    @Test
    public void testSortAscSortedArrAsc() {
        Assert.assertArrayEquals(QuickSort.sort(SORTED_ARR_ASC, 0, UNSORTED_ARR.length-1, "asc"), SORTED_ARR_ASC);
    }

    @Test
    public void testSortAscSortedArrDesc() {
        Assert.assertArrayEquals(QuickSort.sort(SORTED_ARR_ASC, 0, UNSORTED_ARR.length-1, "desc"), SORTED_ARR_DESC);
    }

    @Test
    public void testSortDescSortedArrAsc() {
        Assert.assertArrayEquals(QuickSort.sort(SORTED_ARR_DESC, 0, UNSORTED_ARR.length-1, "asc"), SORTED_ARR_ASC);
    }

    @Test
    public void testSortDescSortedArrDesc() {
        Assert.assertArrayEquals(QuickSort.sort(SORTED_ARR_DESC, 0, UNSORTED_ARR.length-1, "desc"), SORTED_ARR_DESC);
    }
}
