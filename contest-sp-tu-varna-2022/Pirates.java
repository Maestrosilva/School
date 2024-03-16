import java.util.*;
import java.util.stream.Collectors;

public class Pirates {
    static char[][] matrix;
    static Map<Set<String>, Integer> graph = new LinkedHashMap<>();
    static String[] current;
    static List<String> objects = new ArrayList<>();
    static Set<String[]> combinations = new LinkedHashSet<>();
    static Map<String, Boolean> used = new LinkedHashMap<>();
    static int[][] distancesMatrix;
    static int x;
    static int y;
    static int f;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        x = input[1];
        y = input[0];
        f = input[2];
        matrix = new char[x][y];
        for (int i = 0; i < x; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
        Map<String, int[]> objectsCoordinates = new HashMap<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] != '*' && matrix[i][j] != 'X') {
                    String object = String.valueOf(matrix[i][j]);
                    objectsCoordinates.putIfAbsent(object, new int[]{i, j});
                    objects.add(object);
                    used.put(object, false);
                }
            }
        }
        current = new String[objects.size()];
        current[0] = "P";
        current[current.length - 1] = "T";
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                int distance = findShortestPath(objectsCoordinates.get(objects.get(i))
                        , objectsCoordinates.get(objects.get(j)));
                graph.put(new HashSet<>(List.of(objects.get(i)
                                , objects.get(j)))
                        , distance);
            }
        }
        System.out.println(dfs());
    }

    private static int dfs() {
        objects = objects.stream()
                .filter(e -> !e.equals("P") && !e.equals("T"))
                .collect(Collectors.toList());
        getCombinations(1);
        int minSum = Integer.MAX_VALUE;
        int currentSum = 0;
        for (String[] c : combinations) {
            for (int i = 1; i < c.length; i++) {
                Set<String> currentSet = new HashSet<>(List
                        .of(c[i], c[i - 1]));
                Set<String> set = graph.keySet().stream()
                        .filter(s -> sameSets(s, currentSet))
                        .findFirst()
                        .orElse(null);
                int value = graph.get(set);
                currentSum += value;
            }
            if (currentSum < minSum) {
                minSum = currentSum;
            }
            currentSum = 0;
        }
        return minSum * 10;
    }

    private static void getCombinations(int index) {
        if (index == current.length - 1) {
            combinations.add(Arrays.stream(current)
                    .toArray(String[]::new));
            return;
        }
        for (String s : objects) {
            if (!used.get(s)) {
                used.put(s, true);
                current[index] = s;
                getCombinations(index + 1);
                used.put(s, false);
            }
        }
    }

    private static boolean sameSets(Set<String> set1, Set<String> set2) {
        return set1.containsAll(set2);
    }

    private static int findShortestPath(int[] from, int[] to) {
        distancesMatrix = new int[x][y];
        for (int i = 0; i < x; i++) {
            Arrays.fill(distancesMatrix[i], 10_000);
        }
        distancesMatrix[from[0]][from[1]] = -1;
        discover(from[0], from[1], 0);
        return distancesMatrix[to[0]][to[1]];
    }

    private static void discover(int coor1, int coor2, int value) {
        int up = 10_000;
        int down = 10_000;
        int left = 10_000;
        int right = 10_000;
        if (accessible(coor1 - 1, coor2))
            up = distancesMatrix[coor1 - 1][coor2];
        if (accessible(coor1 + 1, coor2))
            down = distancesMatrix[coor1 + 1][coor2];
        if (accessible(coor1, coor2 - 1))
            left = distancesMatrix[coor1][coor2 - 1];
        if (accessible(coor1, coor2 + 1))
            right = distancesMatrix[coor1][coor2 + 1];
        distancesMatrix[coor1][coor2] = Math.min(Math.min(Math.min(up, left)
                        , Math.min(down, right))
                , distancesMatrix[coor1][coor2]) + 1;
        if (accessible(coor1 + 1, coor2) &&
                distancesMatrix[coor1 + 1][coor2] == 10_000 &&
                matrix[coor1 + 1][coor2] != 'X') {
            discover(coor1 + 1, coor2, value + 1);
        }
        if (accessible(coor1, coor2 + 1) &&
                distancesMatrix[coor1][coor2 + 1] == 10_000 &&
                matrix[coor1][coor2 + 1] != 'X') {
            discover(coor1, coor2 + 1, value + 1);
        }
        if (accessible(coor1 - 1, coor2) &&
                distancesMatrix[coor1 - 1][coor2] == 10_000 &&
                matrix[coor1 - 1][coor2] != 'X') {
            discover(coor1 - 1, coor2, value + 1);
        }
        if (accessible(coor1, coor2 - 1) &&
                distancesMatrix[coor1][coor2 - 1] == 10_000 &&
                matrix[coor1][coor2 - 1] != 'X') {
            discover(coor1, coor2 - 1, value + 1);
        }
    }

    private static boolean accessible(int coor1, int coor2) {
        try {
            char a = matrix[coor1][coor2];
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }
}