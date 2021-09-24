package vovka.algo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] array = {50, -3, -21, 100, 10};

//		Складність - O(n^2)

//      Як працює(від меншого до більшого):
//      Беремо по два елементи(1-2, 2-3, 3-4 etc), порівнюємо, якщо правий менший за лівий - міняємо місцями,
//      і так робимо до тих пір, поки не зрозуміємо що масив вже посортований(за прохід цілого масиву не має відбутись ні одної ітерації)

        Method method = new Method();

        System.out.println("Start - " + Arrays.toString(array));
        System.out.println("Finish - " + method.bubles(array, How.ASC));



    }
}
