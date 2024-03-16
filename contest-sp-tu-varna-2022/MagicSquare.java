import java.util.Arrays;
import java.util.Scanner;

public class MagicSquare {
    static int[][] square;
    static int counter = 1;
    static int[] last = new int[2];
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < test; i++) {
            n = Integer.parseInt(scanner.nextLine());
            square = new int[n][n];
            makeMagicSquare(0, n / 2);
        }
        for (int[] row : square) {
            System.out.println(String.join(" ",
                    Arrays.stream(row).mapToObj(String::valueOf).toArray(String[]::new)));
        }
    }

    private static void makeMagicSquare(int row, int col) {
        if(counter == n * n + 1){
            return;
        }
        if(row == -1){
            row = n - 1;
        }
        if(col == -1){
            col = n - 1;
        }
        if(square[row][col] == 0) {
            square[row][col] = counter;
            last[0] = row;
            last[1] = col;
            counter++;
        }
        else{
            makeMagicSquare(last[0] + 1, last[1]);
        }
        makeMagicSquare(row - 1, col - 1);
    }
}