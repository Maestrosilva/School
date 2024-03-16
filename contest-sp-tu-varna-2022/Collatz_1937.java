import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Collatz_1937 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < tests; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            Set<Integer> pastNumbers = new LinkedHashSet<>();
            while (true) {
                pastNumbers.add(n);
                if (n % 2 == 0) {
                    n /= 2;
                } else {
                    n *= 3;
                    n += 1;
                }
                if (pastNumbers.contains(n)) {
                    System.out.println(n);
                    break;
                }
            }
        }
    }
}