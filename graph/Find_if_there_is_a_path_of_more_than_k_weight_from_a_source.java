import java.util.*;

class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Find_if_there_is_a_path_of_more_than_k_weight_from_a_source {

    // recursive function to find if there
    // exist simple path with weight more than k
    public static boolean findPath(HashMap<Integer, ArrayList<Pair>> adj, 
        int src, int k, HashMap<Integer, Integer> visited) {

        // if k is 0 or negative, return true
        if (k <= 0) return true;

        for (Pair i: adj.get(src)) {

            // adjacnet vertex and weight of edge
            int v = i.first, w = i.second;

            // if vertex v is visited, continue
            if (visited.get(v) == 1) continue;

            // else include the vertex in path
            visited.put(v, 1);

            // if path greater than k is found, return true
            if (findPath(adj, v, k - w, visited))
                return true;

            // backtrack
            visited.put(v, 0);
        }

        return false;
    }

    public static boolean pathMoreThanK(
        ArrayList<ArrayList<Integer>> edgeList, int src, int k) {

        // create an adjacency list representation of the
        // graph
        HashMap<Integer, ArrayList<Pair>> adj = new HashMap<>();
        for (ArrayList<Integer> edge: edgeList) {
            int u = edge.get(0), v = edge.get(1), w = edge.get(2);
            adj.computeIfAbsent(u, x -> new ArrayList<>()).add(new Pair(v, w));
            adj.computeIfAbsent(v, x -> new ArrayList<>()).add(new Pair(u, w));
        }

        // to mark the visited vertices
        HashMap<Integer, Integer> visited = new HashMap<>();

        // initialize visited vertices to 0
        for (Integer key : adj.keySet()) {
            visited.put(key, 0);
        }

        // mark source vertex visited
        visited.put(src, 1);

        return findPath(adj, src, k, visited);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edgeList = 
        new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(0, 1, 4)), 
            new ArrayList<>(Arrays.asList(0, 7, 8)), 
            new ArrayList<>(Arrays.asList(1, 7, 11)),
            new ArrayList<>(Arrays.asList(1, 2, 8)), 
            new ArrayList<>(Arrays.asList(2, 8, 2)), 
            new ArrayList<>(Arrays.asList(8, 6, 6)),
            new ArrayList<>(Arrays.asList(6, 7, 1)), 
            new ArrayList<>(Arrays.asList(7, 8, 7)), 
            new ArrayList<>(Arrays.asList(2, 3, 7)),
            new ArrayList<>(Arrays.asList(2, 5, 4)), 
            new ArrayList<>(Arrays.asList(5, 6, 2)), 
            new ArrayList<>(Arrays.asList(3, 5, 14)),
            new ArrayList<>(Arrays.asList(3, 4, 9)), 
            new ArrayList<>(Arrays.asList(4, 5, 10))
        ));
        int source = 0, k = 58;
        if (pathMoreThanK(edgeList, source, k))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}