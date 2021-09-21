package com.javovka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

        public static void main(String[] args) {
            HashTableChainType<String, Integer> a = new HashTableChainType<>();
            for (int i = 0; i < 15; i++) {
                a.put(String.valueOf(i),i);
            }

            a.print();

            for (int i = 0; i < 15; i++) {
                if(i % 20 == 0){
                    System.out.println();
                }
                System.out.print(a.get(String.valueOf(i)) + "; ");
            }
            System.out.println();

            for (int i = 0; i < 15; i++) {
                a.remove(String.valueOf(i));
            }
            a.print();

        }
    }


