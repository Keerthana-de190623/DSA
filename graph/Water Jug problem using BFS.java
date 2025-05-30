import java.util.*;

class GfG {
  
	// Function to find the minimum operations to obtain
    // d liters in one jug
    static int minSteps(int m, int n, int d) {
        if (d > Math.max(m, n)) return -1; 

        // Queue for BFS: each state is (jug1, jug2, steps)
        Queue<int[]> q = new LinkedList<>();
      
        // Tracking visited states
        boolean[][] visited = new boolean[m + 1][n + 1]; 

        // Start with both jugs empty
        q.add(new int[] {0, 0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int jug1 = curr[0], jug2 = curr[1], steps = curr[2];

            if (jug1 == d || jug2 == d) return steps;

            // All possible operations:

            // 1: Fill jug1
            if (!visited[m][jug2]) {
                visited[m][jug2] = true;
                q.add(new int[] {m, jug2, steps + 1});
            }

            // 2: Fill jug2
            if (!visited[jug1][n]) {
                visited[jug1][n] = true;
                q.add(new int[] {jug1, n, steps + 1});
            }

            // 3: Empty jug1
            if (!visited[0][jug2]) {
                visited[0][jug2] = true;
                q.add(new int[] {0, jug2, steps + 1});
            }

            // 4: Empty jug2
            if (!visited[jug1][0]) {
                visited[jug1][0] = true;
                q.add(new int[] {jug1, 0, steps + 1});
            }

            // 5: Pour jug1 into jug2
            int pour1to2 = Math.min(jug1, n - jug2);
            if (!visited[jug1 - pour1to2][jug2 + pour1to2]) {
                visited[jug1 - pour1to2][jug2 + pour1to2] = true;
                q.add(new int[] {jug1 - pour1to2, jug2 
                                       + pour1to2, steps + 1});
            }

            // 6: Pour jug2 into jug1
            int pour2to1 = Math.min(jug2, m - jug1);
            if (!visited[jug1 + pour2to1][jug2 - pour2to1]) {
                visited[jug1 + pour2to1][jug2 - pour2to1] = true;
                q.add(new int[] {jug1 + pour2to1, jug2 
                                        - pour2to1, steps + 1});
            }
        }

        return -1;
    }
  
    public static void main(String[] args) {
      
        // jug1 = 4 litre, jug2 = 3 litre 
        int m = 4, n = 3, d = 2;
        System.out.println(minSteps(m, n, d));
    }
}