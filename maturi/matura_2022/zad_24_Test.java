package matura_2022;

import java.util.*;

public class zad_24_Test {
//    static int steps = 0;
    public static void main(String[] args) {
        Random random = new Random();
        int length = 20;
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(sort(a)));
//        System.out.println("steps: " + steps);
    }

    private static int[] sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(a[j] < a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
//                steps++;
            }
        }
        return a;
    }
}