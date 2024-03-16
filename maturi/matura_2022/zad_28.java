package matura_2022;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class zad_28 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String file_1 = scanner.nextLine();
        String file_2 = scanner.nextLine();
        for (String str : readWords(file_2)) {
            System.out.println(contains(Objects.requireNonNull(readMatrix(file_1)), str) ? str : "");
        }
    }

    public static boolean contains(char[][] matrix, String str) {
        for (char[] ch : matrix) {
            String row = new String(ch);
            if (row.contains(str)) {
                return true;
            }
            if (new StringBuilder(row).reverse().toString().contains(str)) {
                return true;
            }
        }
        return false;
    }

    public static char[][] readMatrix(String fileName) throws FileNotFoundException {
        char[][] matrix = null;
        try (
                BufferedReader bufferedReader =
                        new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            int lines = (int) Files.lines(Path.of(fileName)).count();
            matrix = new char[lines][];
            for (int i = 0; i < lines; i++) {
                String row = bufferedReader.readLine();
                matrix[i] = row.toCharArray();
                if (i >= 1) {
                    if (matrix[i].length != matrix[i - 1].length) {
                        return null;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("incorrect input");
        }
        return matrix;
    }

    public static List<String> readWords(String path) throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        List<String> list = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            list.add(line);
        }
        return list;
    }
}