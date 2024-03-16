import java.util.*;
import java.util.stream.Collectors;

public class Report {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] days = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] output = new int[n];
        output[0] = 0;
        for (int i = n - 1; i > 0; i--) {
            int currentDay = days[i];
            for (int j = i - 1; j >= 0; j--) {
                if(days[j] < currentDay){
                    output[i] = j + 1;
                    break;
                }
            }
        }
        System.out.println(Arrays.stream(output)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}