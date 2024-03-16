import java.util.*;

public class Path {
    static Map<Set<Integer>, Integer> graph = new LinkedHashMap<>();
    static Map<Integer, Integer> distances = new LinkedHashMap<>();
    static Map<Integer, Set<Integer>> accessible = new LinkedHashMap<>();
    static Map<Integer, Boolean> used = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < tests; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int cities = input[0];
            for (int j = 1; j <= cities; j++) {
                distances.put(j, Integer.MAX_VALUE);
                used.put(j, false);
            }
            int links = input[1];
            for (int j = 0; j < links; j++) {
                int[] setData = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int from = setData[0];
                int to = setData[1];
                int distance = setData[2];
                Set<Integer> couple = new LinkedHashSet<>(List.of(from, to));
                graph.put(couple, distance);
                accessible.putIfAbsent(from, new LinkedHashSet<>());
                accessible.get(from).add(to);

            }
            findShortestPath(1, 0);
            System.out.println(distances.get(6));
        }
    }

    private static void findShortestPath(int node, int distance) {
        distances.put(node, Math.min(distances.get(node), distance));
        if(node == 6){
            return;
        }
        Set<Integer> toGo = accessible.get(node);
        if(toGo.isEmpty()){
            return;
        }
        for (Integer n : toGo) {
            if(!used.get(n)) {
                used.put(n, true);
                Set<Integer> current = new LinkedHashSet<>(List.of(node, n));
                Set<Integer> set = graph.keySet().stream()
                        .filter(s -> sameSets(current, s))
                        .findFirst()
                        .orElse(null);
                if(set == null){
                    return;
                }
                int value = graph.get(set);
                findShortestPath(n, distances.get(node) + value);
                used.put(n, false);
            }
        }
    }

    private static boolean sameSets(Set<Integer> set1, Set<Integer> set2) {
        return set1.containsAll(set2);
    }
}