package matura_2023;

import java.util.Scanner;

public class _25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            int a = Integer.parseInt(scanner.nextLine());
            System.out.println(unique(a, 1) ? "Yes" : "No");
        }
        catch (Exception e){
            System.out.println("Something went wrong!");
        }
    }

    private static boolean unique(int a, int pos) {
        if(a == 0){
            return true;
        }
            int current = a % (10 * pos);
            if(a % current != 0){
                return false;
            }
            return unique(a, pos + 1);
    }
}