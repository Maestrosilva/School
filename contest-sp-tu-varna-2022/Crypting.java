import java.util.*;

public class Crypting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> data = new ArrayDeque<>();
        String input = scanner.nextLine();
        for (int i = input.length() - 1; i >= 0; i--) {
            data.offer(String.valueOf(input.charAt(i)));
        }
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++){
            data.offer(data.pop());
        }
        List<String> output = new ArrayList<>(data);
        output.replaceAll(s -> String.valueOf((char) ((int) s.charAt(0) + n)));
        Collections.reverse(output);
        output.forEach(System.out::print);
    }
}