import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Presents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> presents = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            presents.add(i);
            presents.add(i + n);
        }
        presents = presents.stream().sorted().collect(Collectors.toList());
        for (int i = n; i < 100_000_000; i++) {
            List<Integer> dummy = new ArrayList<>(presents);
            boolean gameOver = false;
            int ahead = 0;
            for (int j = 0; j < n; j++) {
                int k = i + ahead;
                int current = dummy.get((k - 1) % dummy.size());
                ahead = (k - 1) % dummy.size();
                if (current <= n) {
                    gameOver = true;
                    break;
                }
                dummy.remove((Integer) current);
            }
            if (!gameOver) {
                System.out.println(i);
                break;
            }
        }
    }
}