import java.math.BigDecimal;
import java.util.Scanner;

public class Divisibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        BigDecimal n = new BigDecimal(input);
        for (long i = 2; i < 2001; i++) {
            if(n.divideAndRemainder(BigDecimal.valueOf(i))[1].intValue() == 0){
                System.out.print(i + " ");
                System.out.println(n.divide(BigDecimal.valueOf(i)));
            }
        }
    }
}