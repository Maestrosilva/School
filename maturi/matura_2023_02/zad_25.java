package matura_2023_02;

import java.util.Scanner;

public class zad_25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            int n = Integer.parseInt(scanner.nextLine());
            if(n <= 0 || n > 10_000_000){
                throw new RuntimeException();
            }
            String str = String.valueOf(n);
            int l = str.length();
            for (int i = 0; i < l / 2; i++) {
                if(str.charAt(i) != str.charAt(l - 1 - i)){
                    System.out.println(n + " is not a palindrome");
                    return;
                }
            }
            System.out.println(n + " is a palindrome");
        }
        catch (Exception e){
            System.out.println("Incorrectly entered number");
        }
    }
}
