package vovka.algo;

import java.util.Arrays;
import java.util.Hashtable;

public class Method {

    public String bubles(int[] toSort, How enm){

        boolean isSorted = false;
        int temp;

        while (!isSorted){
            isSorted = true;
            for (int i = 0; i < toSort.length - 1; i++){
                if (enm == How.ASC) {
                    if (toSort[i] > toSort[i + 1]) {
                        isSorted = false;

                        temp = toSort[i + 1];
                        toSort[i + 1] = toSort[i];
                        toSort[i] = temp;

                        System.out.println(Arrays.toString(toSort));

                    }
                }else {
                    if (toSort[i] < toSort[i + 1]) {

                        isSorted = false;

                        temp = toSort[i + 1];
                        toSort[i + 1] = toSort[i];
                        toSort[i] = temp;

                        System.out.println(Arrays.toString(toSort));

                    }
                }
            }
        }

        return Arrays.toString(toSort);
    }
}
