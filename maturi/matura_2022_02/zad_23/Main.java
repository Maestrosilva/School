package matura_2022_02.zad_23;

import java.util.Scanner;

public class Main {
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(YELLOW + "BG -> Въведете цяло число:" + RESET);
            System.out.println(YELLOW + "EN -> Enter a whole number:" + RESET);
            int n = Integer.parseInt(scanner.nextLine());
            ItemList items = new ItemList();
            System.out.println(YELLOW + "BG -> На следващите " + n + " реда въведете данни за предмет: " + RESET);
            System.out.println(YELLOW + "      ([описание] [цена]):" + RESET);
            System.out.println(YELLOW + "EN -> On the following " + n + " lines enter data for an item: " + RESET);
            System.out.println(YELLOW + "      ([description] [price]):" + RESET);
            for (int i = 0; i < n; i++) {
                String[] data = scanner.nextLine().split("\\s+");
                String description = data[0];
                double price = Double.parseDouble(data[1]);
                Item item = new Item(description, price);
                items.add(item);
            }
            System.out.println(YELLOW + "BG -> Съдържание на листта с предмети: " + RESET);
            System.out.println(YELLOW + "EN -> Item list content: " + RESET);
            System.out.print(CYAN);
            items.getProducts().forEach(System.out::println);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(RED + "BG -> Невалидно форматиране!" + RESET);
            System.out.println(RED + "EN -> Invalid format!" + RESET);
        }
//        catch (Exception e) {
//            System.out.println(RED + e.getClass().getSimpleName() + " - " + e.getMessage() + RESET);
//        }
    }
}