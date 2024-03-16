import java.util.Arrays;
import java.util.Scanner;

public class Swap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = Integer.parseInt(scanner.nextLine());
        int[] input;
        for (int i = 0; i < tests; i++) {
            input = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            solve(input);
        }
    }

    private static void solve(int[] input) {
        int price = input[0];
        int toExchange = input[1];
        int money = input[2];
        int total = money / price;
        int currentEmptyBottles = total;
        while (currentEmptyBottles >= toExchange) {
            int toAdd = currentEmptyBottles / toExchange;
            total += toAdd;
            currentEmptyBottles %= toExchange;
            currentEmptyBottles += toAdd;
        }
        System.out.println(total);
    }
}