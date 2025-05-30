package greedy;
import java.util.*;
public class Job_Sequencing_Problem_using_Disjoint_Set {
    
// Java program to solve job sequencing
// problem with maximum profit



    // Disjoint Set Data Structure
    static class DisjointSet {
        int[] parent;

        // Constructor
        DisjointSet(int n) {
            parent = new int[n + 1];
            // Every node is a parent of itself
            for (int i = 0; i <= n; i++)
                parent[i] = i;
        }

        // Path Compression
        int find(int s) {

            // Make the parent of the nodes in the path
            //   from u--> parent[u] point to parent[u]
            if (s == parent[s])
                return s;
            return parent[s] = find(parent[s]);
        }

        // Makes u as parent of v.
        void merge(int u, int v) {

            // update the greatest available
            // free slot to u
            parent[v] = u;
        }
    }

    static boolean comp(Pair a, Pair b) {
        return a.first > b.first;
    }

    static ArrayList<Integer> jobSequencing(int[] id, 
                             int[] deadline, int[] profit) {
        int n = id.length;
        ArrayList<Integer> ans =
          new ArrayList<>(Arrays.asList(0, 0));

        // pair the profit and deadline of
        // all the jobs together
        ArrayList<Pair> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new Pair(profit[i], deadline[i]));
        }

        // sort the jobs based on profit
        // in descending order
        jobs.sort((a, b) -> b.first - a.first);

        // Find maximum deadline
        int d = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            d = Math.max(d, deadline[i]);
        }

        // create a disjoint set of d nodes
        DisjointSet ds = new DisjointSet(d);

        // Traverse through all the jobs
        for (int i = 0; i < n; i++) {

            // Find the maximum available free slot for
            // this job (corresponding to its deadline)
            int slots = ds.find(jobs.get(i).second);

            // If maximum available free slot is greater
            // than 0, then free slot available
            if (slots > 0) {

                // update greatest free slot.
                ds.merge(ds.find(slots - 1), slots);

                // update answer
                ans.set(1, ans.get(1) + jobs.get(i).first);
                ans.set(0, ans.get(0) + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] id = {1, 2, 3, 4, 5};
        int[] deadline = {2, 1, 2, 1, 1};
        int[] profit = {100, 19, 27, 25, 15};
        ArrayList<Integer> ans = jobSequencing(id, deadline, profit);
        System.out.println(ans.get(0) + " " + ans.get(1));
    }
}

class Pair {
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}