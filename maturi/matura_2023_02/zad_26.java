package matura_2023_02;

import java.util.*;

public class zad_26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Double> grades = readPoints(scanner, n);
        double minDiff = minDpoints(grades);
        int laureates = Laureates(grades);
        System.out.printf("valid works - %d%n", grades.size());
        System.out.printf("minimal difference - %.3f%n", minDiff);
        System.out.printf("laureates - %d%n", laureates);
        }
        //valid works - 11
    //minimal difference - 1.022 p.
    //laureates - 4

    private static int Laureates(List<Double> grades) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            double max = grades.stream()
                    .sorted(Comparator.reverseOrder())
                    .toList()
                    .get(0);
            for (int j = 0; j < grades.size(); j++) {
                if(grades.get(j) == max){
                    count++;
                }
            }
            grades = grades.stream().filter(g -> !g.equals(max)).toList();
        }
        return count;
    }

    private static double minDpoints(List<Double> points) {
        double minDiff = 200;
        for (int i = 0; i < points.size() - 1; i++) {
            for (int j = i + 1; j < points.size(); j++) {
                if(Objects.equals(points.get(i), points.get(j))){
                    continue;
                }
                double diff = Math.abs(points.get(i) - points.get(j));
                if(minDiff > diff){
                    minDiff = diff;
                }
            }
        }
        return minDiff;
    }


    private static List<Double> readPoints(Scanner scanner, int n) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double a = Double.parseDouble(scanner.nextLine());
            if(a > 0){
                list.add(a);
            }
        }
        return list;
    }
}