import java.util.*;

class GfG {

    // Function to construct the adjacency list from edges
    static ArrayList<ArrayList<Integer>> constructadj(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }

    // Function to check if the graph is Bipartite using BFS
    static boolean isBipartite(int V,int[][]  edges) {
        
        int[] color = new int[V];
        Arrays.fill(color, -1); 
        
        // create adjacency list
        ArrayList<ArrayList<Integer>> adj = constructadj(V,edges);
        
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                color[i] = 0;
                q.offer(i);

                while (!q.isEmpty()) {
                    int u = q.poll();

                    for (int v : adj.get(u)) {
                        if (color[v] == -1) {
                            color[v] = 1 - color[u];
                            q.offer(v);
                        } else if (color[v] == color[u]) {
                            return false; // Conflict found
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int V = 4;

        // Edges of the graph
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};

        // Check if the graph is bipartite
        System.out.println(isBipartite(V, edges));
    }
}
