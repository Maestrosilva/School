import java.util.Scanner;
/*
  1/x + 1/y = 1/z
  (x + y)/xy = 1/z
  x + y = xy/z
  xz + yz = xy
  xz/y = x - z
  y = xz/(x - z)
 */
public class EgyptianFractions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < tests; i++) {
            double z = Double.parseDouble(scanner.nextLine());
            for (double x = 1; x < z * 2; x++) {
                double y = x * z / (x - z);
                if (y % 1 == 0 && y > 0) {
                    System.out.println((int) x + " " + (int) y);
                }
            }
        }
    }
}