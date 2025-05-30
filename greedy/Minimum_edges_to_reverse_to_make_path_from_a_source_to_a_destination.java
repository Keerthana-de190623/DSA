package greedy;
import java.util.*;
public class Minimum_edges_to_reverse_to_make_path_from_a_source_to_a_destination {
    
// Function to find the minimum cost required 
// to run m tasks on n cores


    static int solve(Map<Integer, List<Pair> > map, int[] v, 
    String str, int src, int dst, Map<String, Integer> dp) {

        if (v[src] == 1)
            return Integer.MAX_VALUE - 1000;

        if (src == dst)
            return 0;

        String _key = str + "-" + src;

        if (dp.containsKey(_key))
            return dp.get(_key);

        v[src] = 1;
        int minStep = Integer.MAX_VALUE - 1000;

        if (map.containsKey(src)) {

            for (Pair key : map.get(src)) {
                String temp = str + key.node;

                if (key.dir == -1) {
                    minStep = Math.min(minStep, 
                    1 + solve(map, v, temp, key.node, dst, dp));
                }
                else {
                    minStep = Math.min(minStep, 
                    solve(map, v, temp, key.node, dst, dp));
                }
            }
        }

        v[src] = -1;
        dp.put(_key, minStep);
        return minStep;
    }

    // Function to find the minimum number of edge reversals
    static int minimumEdgeReversal(int[][] edges, 
    int n, int src, int dst) {

        Map<Integer, List<Pair> > map = new HashMap<>();

        for (int[] edge : edges) {

            if (map.containsKey(edge[0])) {

                // forward edge -> 1
                map.get(edge[0]).add(new Pair(edge[1], 1));
            }
            else {
                List<Pair> l = new ArrayList<>();
                l.add(new Pair(edge[1], 1));
                map.put(edge[0], l);
            }

            if (map.containsKey(edge[1])) {

                // backward edge -> -1
                map.get(edge[1]).add(new Pair(edge[0], -1));
            }
            else {
                List<Pair> l = new ArrayList<>();
                l.add(new Pair(edge[0], -1));
                map.put(edge[1], l);
            }
        }

        // visited
        int[] v = new int[n + 1]; 
        Arrays.fill(v, -1);

        Map<String, Integer> dp = new HashMap<>();

        int step = solve(map, v, 
        String.valueOf(src), src, dst, dp);

        return step == Integer.MAX_VALUE - 1000 ? -1 : step;
    }

    public static void main(String[] args) {
        int[][] edgeList = { {0, 1}, {2, 1}, {2, 3}, 
        {6, 3}, {6, 4}, {4, 5}, {5, 1} };
        int n = 7, src = 0, dst = 6;
        System.out.println(
        minimumEdgeReversal(edgeList, n, src, dst));
    }

    static class Pair {
        
        public int node;
        public int dir;
        
        
        public Pair(int node, int dir) {
            
            this.node = node;
            this.dir = dir;
        }
    }
}