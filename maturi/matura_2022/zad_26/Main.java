package matura_2022.zad_26;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {
        ArrayDeque<Human> toSave = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(YELLOW + "BG -> Въведете цяло число: ");
            System.out.println(YELLOW + "EN -> Enter whole number: ");
            int n = Integer.parseInt(scanner.nextLine());
            System.out.println(YELLOW + "BG -> На следващите " + n + " реда въведете данни за човек.");
            System.out.println(YELLOW + "EN -> On the following " + n + " lines enter data for a human.");
            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.println(YELLOW + "BG -> Първо име: ");
                System.out.println(YELLOW + "EN -> First name: ");
                String fName = scanner.nextLine();
                System.out.println(YELLOW + "BG -> Фамилия: ");
                System.out.println(YELLOW + "EN -> Last name: ");
                String lName = scanner.nextLine();
                System.out.println(YELLOW + "BG -> Възраст: ");
                System.out.println(YELLOW + "EN -> Age: ");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.println(YELLOW + "BG -> Вашият избор [въведете 's' за ученик] , [въведете 'w' за работник]: ");
                System.out.println(YELLOW + "EN -> Your choice [enter 's' for student] , [enter 'w' for worker]: ");
                char choice = scanner.nextLine().charAt(0);
                Human human = null;
                switch (choice) {
                    case 'w' -> {
                        System.out.println(YELLOW + "BG -> Надница: ");
                        System.out.println(YELLOW + "EN -> Wage: ");
                        double wage = Double.parseDouble(scanner.nextLine());
                        System.out.println(YELLOW + "BG -> Часове работа: ");
                        System.out.println(YELLOW + "EN -> Work hours: ");
                        int workHours = Integer.parseInt(scanner.nextLine());
                        human = new Worker(fName, lName, age, wage, workHours);
                    }
                    case 's' -> {
                        System.out.println(YELLOW + "BG -> Оценка: ");
                        System.out.println(YELLOW + "EN -> Grade: ");
                        double grade = Double.parseDouble(scanner.nextLine());
                        human = new Student(fName, lName, age, grade);
                    }
                }
                assert human != null;
                toSave.push(human);
            }
            System.out.println(YELLOW + "BG -> Записани данни: " + CYAN);
            System.out.println(YELLOW + "EN -> Saved data: " + CYAN);
            toSave.forEach(System.out::println);
        }
        catch (Exception e){
            System.out.println(RED  + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
/*
Примени входове
Example inputs:
2
Ivan
Ivanov
13
s
5.44
Pesho
Peshev
55
w
5.11
20
 */
