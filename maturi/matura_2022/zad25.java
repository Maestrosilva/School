package matura_2022;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class zad25 {

    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String CYAN = "\u001B[36m";
    /**
     * Създайте проект с име zad25. Вашата задача е да напишете програма, която
     * прочита от стандартния вход две цели числа a и b. Програмата да намира и извежда
     * на стандартния изход решенията на квадратното неравенство ax² < b.
     **/
    public static void main(String[] args) {
        System.out.println(YELLOW + "BG -> Въведете целочислени стойности за 'a' и 'b' НА ЕДИН РЕД резделени с празно място" + RESET);
        System.out.println(YELLOW + "EN -> Enter whole number values for 'a' and 'b' ON ONE LINE separated by a space:" + RESET);
        int a;
        int b;
        Scanner scanner = new Scanner(System.in);
        try {
            int[] ns = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.out.println(CYAN);
            if (ns.length != 2) {
                System.out.println(RED + "BG -> Трябва да въведете само две числа!");
                System.out.println(RED + "EN -> You should enter two numbers only!");
            }
            a = ns[0];
            b = ns[1];
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.print(RESET);
        } catch (NumberFormatException e) {
            System.out.println(RED + "BG -> Невалидно въведени числа!");
            System.out.println(RED + "EN -> Input contains invalid numbers!");
            return;
        }
        solve(a, b);
    }

    private static void solve(int a, int b) {
        /** a * x^2 < b **/
        System.out.println(YELLOW + "------->   a * x^2 < b   <-------" + RESET);
        System.out.println(YELLOW + "------->   " + a + " * x^2 < " + b + "   <-------" + RESET);
        System.out.println();

        if (a >= 0 && b <= 0) {
            System.out.println(CYAN + "EN -> Няма реални корени.");
            System.out.println(CYAN + "EN -> No real solutions.");
            return;
        }
        if (a <= 0 && b >= 0) {
            System.out.println(CYAN + "BG -> Всяко реално число е корен.");
            System.out.println(CYAN + "EN -> Every real number is a solution.");
            return;
        }
        double n = (double) b / a;
        double upperBorder = Math.sqrt(n);
        double lowerBorder = -Math.sqrt(n);
        if (a > 0) {
            System.out.printf(Locale.US, CYAN + "BG -> Решенията са: (%.2f; %.2f) %n",
                    lowerBorder, upperBorder);
            System.out.printf(Locale.US, CYAN + "EN -> Solutions are: (%.2f; %.2f) %n",
                    lowerBorder, upperBorder);
        } else {
            System.out.printf(Locale.US, CYAN + "BG -> Решенията са: (-inf; %.2f) U (%.2f; +inf) %n",
                    lowerBorder, upperBorder);
            System.out.printf(Locale.US, CYAN + "EN -> Solutions are: (-inf; %.2f) U (%.2f; +inf) %n",
                    lowerBorder, upperBorder);
        }
    }
}

/*
Примерни входове:
Example inputs:
2 18
-4 -1
2 0
-3 15
4 t
 */