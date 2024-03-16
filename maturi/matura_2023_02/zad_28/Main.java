package matura_2023_02.zad_28;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rallyName = scanner.nextLine();
        int year = Integer.parseInt(scanner.nextLine());
        Rally rally = new Rally(rallyName, year);
        String input;
        while (!(input = scanner.nextLine()).equals("q")){
//            System.out.println("[a]dd [v]iew [q]uit");
//            System.out.println();
            switch (input) {
                case "a" -> {
                    String name = scanner.nextLine();
                    int age = Integer.parseInt(scanner.nextLine());
                    String category = scanner.nextLine();
                    String brand = scanner.nextLine();
                    int power = Integer.parseInt(scanner.nextLine());
                    Pilot pilot = new Pilot(name, age, new Car(brand, power), category);
                    rally.addParticipant(pilot);
                }
                case "v" -> System.out.println(rally);
                default -> System.out.println("Invalid input");
            }
        }
    }
}
