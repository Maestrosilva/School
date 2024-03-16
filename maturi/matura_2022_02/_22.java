package matura_2022_02;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _22 {
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(YELLOW + "Enter a number:" + RESET);
            int n = Integer.parseInt(scanner.nextLine());
            Map<Integer, Integer> counter = new LinkedHashMap<>();
            System.out.println();
            System.out.println(YELLOW + "On the following " + n + " lines enter one whole number: " + RESET);
            for (int i = 0; i < n; i++) {
                int currentNumber = Integer.parseInt(scanner.nextLine());
                counter.putIfAbsent(currentNumber, 0);
                counter.put(currentNumber, counter.get(currentNumber) + 1);
            }
            System.out.println();
            System.out.println(YELLOW + "Number occurrences: " + RESET);
            counter.entrySet().stream()
                    .map(e -> String.format(CYAN + "num: %d, count: %d", e.getKey(), e.getValue()))
                    .forEach(System.out::println);
        } catch (Exception e) {
            System.out.println();
            System.out.println(RED + e.getClass().getSimpleName() + " - " + e.getMessage() + RESET);
        }
    }
}
