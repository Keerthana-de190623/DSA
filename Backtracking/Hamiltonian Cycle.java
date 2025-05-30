// Java Code to check whether the given graph
// contains Hamiltonian Cycle using backtracking
class GfG {

    // Check if it's valid to place vertex at current position
    static boolean isSafe(int vertex, int[][] graph, 
                          int[] path, int pos) {
        
        // The vertex must be adjacent to the previous vertex
        if (graph[path[pos - 1]][vertex] == 0) {
            return false;
        }

        // The vertex must not already be in the path
        for (int i = 0; i < pos; i++) {
            if (path[i] == vertex) {
                return false;
            }
        }

        return true;
    }

    // Recursive backtracking to construct Hamiltonian Cycle
    static boolean hamCycleUtil(int[][] graph, int[] path, 
                                int pos, int n) {
        
        // Base case: all vertices are in the path
        if (pos == n) {
            
            // Check if there's an edge from 
            // last to first vertex
            return graph[path[pos - 1]][path[0]] == 1;
        }

        // Try all possible vertices as next candidate
        for (int v = 1; v < n; v++) {
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;

                if (hamCycleUtil(graph, path, pos + 1, n)) {
                    return true;
                }

                // Backtrack if v doesn't lead to a solution
                path[pos] = -1;
            }
        }

        return false;
    }

    // Initialize path and invoke backtracking function
    static int[] hamCycle(int[][] graph) {
        int n = graph.length;
        int[] path = new int[n];
        for (int i = 0; i < n; i++) {
            path[i] = -1;
        }

        // Start path with vertex 0
        path[0] = 0;

        if (!hamCycleUtil(graph, path, 1, n)) {
            return new int[]{-1};
        }

        return path;
    }

    // Driver Code
    public static void main(String[] args) {

        // Representation of the given graph
        //    (0)-(1)-(2) 
        //     |  / \  | 
        //     | /   \ | 
        //     |/     \| 
        //    (3)-----(4)
        int[][] graph = {
            {0, 1, 0, 1, 0}, 
            {1, 0, 1, 1, 1}, 
            {0, 1, 0, 0, 1}, 
            {1, 1, 0, 0, 1}, 
            {0, 1, 1, 1, 0}
        };

        int[] path = hamCycle(graph);

        if (path[0] == -1) {
            System.out.print("Solution does not Exist");
        } else {
            for (int i = 0; i < path.length; i++) {
                System.out.print(path[i] + " ");
            }

            // Print the first vertex again 
            // to complete the cycle
            System.out.print(path[0]);
        }
    }
}